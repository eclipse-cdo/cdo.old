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


import org.eclipse.net4j.core.ClientChallengeNegotiator;
import org.eclipse.net4j.core.Connector;
import org.eclipse.net4j.core.NegotiationException;

import java.util.Arrays;


public abstract class AbstractClientChallengeNegotiator extends AbstractChallengeNegotiator
        implements ClientChallengeNegotiator
{
  public void negotiate(Connector connector) throws NegotiationException
  {
    LoginCredentials credentials = getLoginCredentials();

    if (credentials == null)
    {
      throw new NegotiationException("Could not retrieve login credentials");
    }

    String userName = credentials.getUserName();
    char[] password = credentials.getPassword().toCharArray();

    // Phase 1
    if (isDebugEnabled()) debug("Waiting for token...");
    byte[] token = connector.receiveNegotiation();
    if (isDebugEnabled()) debug("Received token");

    byte[] cryptedToken = encrypt(token, password);
    byte[] loginBytes = userName.getBytes();

    // Phase 2
    if (isDebugEnabled()) debug("Transmitting cryptedToken");
    connector.transmitNegotiation(cryptedToken);

    if (isDebugEnabled()) debug("Transmitting userName");
    connector.transmitNegotiation(loginBytes);

    // Phase 3
    if (isDebugEnabled()) debug("Waiting for result...");
    byte[] result = connector.receiveNegotiation();
    if (!Arrays.equals(result, NEGOTIATION_SUCCESS))
    {
      if (isDebugEnabled()) debug("Received failure");
      throw new NegotiationException("User " + userName + " could not be authenticated");
    }

    if (isDebugEnabled()) debug("Received success");
    connector.setUserName(userName);
  }
}
