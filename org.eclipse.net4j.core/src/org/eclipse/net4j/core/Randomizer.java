/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.core;


import org.eclipse.net4j.spring.Service;


public interface Randomizer extends Service
{
  public static final String SHA1PRNG_ALGORITHM = "SHA1PRNG";

  public String getAlgorithmName();

  public String getPackageName();

  public boolean nextBoolean();

  public double nextDouble();

  public float nextFloat();

  public double nextGaussian();

  public int nextInt();

  public int nextInt(int n);

  public long nextLong();

  public byte[] generateSeed(int numBytes);

  public String getAlgorithm();

  public void nextBytes(byte[] bytes);
}
