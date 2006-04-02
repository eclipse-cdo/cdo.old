/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.core.impl;


import org.eclipse.net4j.core.AuthenticationManager;
import org.eclipse.net4j.core.Connector;
import org.eclipse.net4j.core.NegotiationException;
import org.eclipse.net4j.core.Randomizer;
import org.eclipse.net4j.spring.ValidationException;

import java.util.Arrays;


public class ServerChallengeNegotiatorImpl extends AbstractChallengeNegotiator
{
  public static final int DEFAULT_TOKEN_LENGTH = 128;

  private Randomizer randomizer;

  private AuthenticationManager authenticationManager;

  private int tokenLength = DEFAULT_TOKEN_LENGTH;

  public Randomizer getRandomizer()
  {
    return randomizer;
  }

  public void setRandomizer(Randomizer randomizer)
  {
    doSet("randomizer", randomizer);
  }

  public AuthenticationManager getAuthenticationManager()
  {
    return authenticationManager;
  }

  public void setAuthenticationManager(AuthenticationManager authenticationManager)
  {
    doSet("authenticationManager", authenticationManager);
  }

  public int getTokenLength()
  {
    return tokenLength;
  }

  public void setTokenLength(int tokenLength)
  {
    doSet("tokenLength", tokenLength);
  }

  public void negotiate(Connector connector) throws NegotiationException
  {
    // Phase 1
    if (isDebugEnabled()) debug("Transmitting token");
    byte[] token = createRandomToken();
    connector.transmitNegotiation(token);

    // Phase 2
    if (isDebugEnabled()) debug("Waiting for cryptedToken...");
    byte[] cryptedToken = connector.receiveNegotiation();
    if (isDebugEnabled()) debug("Received cryptedToken");

    if (isDebugEnabled()) debug("Waiting for userName...");
    byte[] loginBytes = connector.receiveNegotiation();
    if (isDebugEnabled()) debug("Received userName");

    String login = new String(loginBytes);
    char[] passwd = authenticationManager.getPassword(login);

    // Phase 3
    if (!verifyToken(cryptedToken, token, passwd))
    {
      if (isDebugEnabled()) debug("Transmitting failure");
      connector.transmitNegotiation(NEGOTIATION_FAILURE);
      throw new NegotiationException("User " + login + " could not be authenticated");
    }

    if (isDebugEnabled()) debug("Transmitting success");
    connector.transmitNegotiation(NEGOTIATION_SUCCESS);
    connector.setUserName(login);
  }

  /**
   * @param cryptedToken
   * @param token
   * @param login
   * @return
   */
  protected boolean verifyToken(byte[] cryptedToken, byte[] token, char[] passwd)
  {
    if (passwd == null)
    {
      return false;
    }

    try
    {
      byte[] locallyCryptedToken = encrypt(token, passwd);
      return Arrays.equals(cryptedToken, locallyCryptedToken);
    }
    catch (Exception ex)
    {
      warn("Token could not be encrypted", ex);
      return false;
    }
  }

  @Override
  protected void validate() throws ValidationException
  {
    super.validate();
    assertNotNull("randomizer");
    assertNotNull("authenticationManager");

    if (tokenLength <= 0)
    {
      throw new ValidationException("tokenLength must be positive");
    }
  }

  protected byte[] createRandomToken()
  {
    byte[] token = new byte[tokenLength];
    randomizer.nextBytes(token);
    return token;
  }
}
