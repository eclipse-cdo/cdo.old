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


import org.eclipse.net4j.core.NegotiationException;
import org.eclipse.net4j.core.Negotiator;
import org.eclipse.net4j.spring.ValidationException;
import org.eclipse.net4j.spring.impl.ServiceImpl;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;


public abstract class AbstractChallengeNegotiator extends ServiceImpl implements Negotiator
{
  public static final byte[] NEGOTIATION_FAILURE = {0};

  public static final byte[] NEGOTIATION_SUCCESS = {1};

  public static final String PBE_WITH_MD5_AND_DES = "PBEWithMD5AndDES";

  public static final String DEFAULT_ALGORITHM_NAME = PBE_WITH_MD5_AND_DES;

  private String algorithmName = DEFAULT_ALGORITHM_NAME;

  public String getAlgorithmName()
  {
    return algorithmName;
  }

  public void setAlgorithmName(String algorithmName)
  {
    doSet("algorithmName", algorithmName);
  }

  /**
   * @param token
   * @param password
   * @return
   * @throws NegotiationException
   */
  public byte[] encrypt(byte[] token, char[] password) throws NegotiationException
  {
    try
    {
      // Salt
      final byte[] salt = {(byte)0xc7, (byte)0x73, (byte)0x21, (byte)0x8c, (byte)0x7e, (byte)0xc8,
              (byte)0xee, (byte)0x99}; // TODO Make configurable

      // Iteration count
      final int count = 20; // TODO Make configurable

      // Create PBE parameter set
      PBEParameterSpec pbeParamSpec = new PBEParameterSpec(salt, count);
      PBEKeySpec pbeKeySpec = new PBEKeySpec(password);
      SecretKeyFactory keyFac = SecretKeyFactory.getInstance(algorithmName);
      SecretKey pbeKey = keyFac.generateSecret(pbeKeySpec);

      // Create PBE Cipher
      Cipher pbeCipher = Cipher.getInstance(algorithmName);

      // Initialize PBE Cipher with key and parameters
      pbeCipher.init(Cipher.ENCRYPT_MODE, pbeKey, pbeParamSpec);

      return pbeCipher.doFinal(token);
    }
    catch (Exception ex)
    {
      throw new NegotiationException("Could not encrypt token with password", ex);
    }
  }

  @Override
  protected void validate() throws ValidationException
  {
    super.validate();
    assertNotNull("algorithmName"); // TODO Verify existance of algorithm
  }
}
