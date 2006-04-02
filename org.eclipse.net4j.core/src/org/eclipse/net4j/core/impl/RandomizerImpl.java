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


import org.eclipse.net4j.core.Randomizer;
import org.eclipse.net4j.spring.ValidationException;
import org.eclipse.net4j.spring.impl.ServiceImpl;

import java.security.SecureRandom;


public class RandomizerImpl extends ServiceImpl implements Randomizer
{
  public static final String DEFAULT_ALGORITHM_NAME = SHA1PRNG_ALGORITHM;

  private String algorithmName = DEFAULT_ALGORITHM_NAME;

  private String packageName;

  private transient SecureRandom secureRandom;

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.net4j.core.impl.TTT#getAlgorithmName()
   */
  public String getAlgorithmName()
  {
    return algorithmName;
  }

  public void setAlgorithmName(String algorithmName)
  {
    doSet("algorithmName", algorithmName);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.net4j.core.impl.TTT#getPackageName()
   */
  public String getPackageName()
  {
    return packageName;
  }

  public void setPackageName(String packageName)
  {
    doSet("packageName", packageName);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.net4j.core.impl.TTT#nextBoolean()
   */
  public boolean nextBoolean()
  {
    return secureRandom.nextBoolean();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.net4j.core.impl.TTT#nextDouble()
   */
  public double nextDouble()
  {
    return secureRandom.nextDouble();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.net4j.core.impl.TTT#nextFloat()
   */
  public float nextFloat()
  {
    return secureRandom.nextFloat();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.net4j.core.impl.TTT#nextGaussian()
   */
  public synchronized double nextGaussian()
  {
    return secureRandom.nextGaussian();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.net4j.core.impl.TTT#nextInt()
   */
  public int nextInt()
  {
    return secureRandom.nextInt();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.net4j.core.impl.TTT#nextInt(int)
   */
  public int nextInt(int n)
  {
    return secureRandom.nextInt(n);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.net4j.core.impl.TTT#nextLong()
   */
  public long nextLong()
  {
    return secureRandom.nextLong();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.net4j.core.impl.TTT#generateSeed(int)
   */
  public byte[] generateSeed(int numBytes)
  {
    return secureRandom.generateSeed(numBytes);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.net4j.core.impl.TTT#getAlgorithm()
   */
  public String getAlgorithm()
  {
    return secureRandom.getAlgorithm();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.net4j.core.impl.TTT#nextBytes(byte[])
   */
  public synchronized void nextBytes(byte[] bytes)
  {
    secureRandom.nextBytes(bytes);
  }

  public synchronized void setSeed(byte[] seed)
  {
    secureRandom.setSeed(seed);
  }

  public void setSeed(long seed)
  {
    secureRandom.setSeed(seed);
  }

  @Override
  protected void validate() throws ValidationException
  {
    super.validate();
    assertNotNull("algorithmName");

    try
    {
      if (packageName == null)
      {
        secureRandom = SecureRandom.getInstance(algorithmName);
      }
      else
      {
        secureRandom = SecureRandom.getInstance(algorithmName, packageName);
      }
    }
    catch (Exception ex)
    {
      throw new ValidationException("Secure random generator could not be initialized", ex);
    }

    secureRandom.setSeed(System.currentTimeMillis());
  }
}
