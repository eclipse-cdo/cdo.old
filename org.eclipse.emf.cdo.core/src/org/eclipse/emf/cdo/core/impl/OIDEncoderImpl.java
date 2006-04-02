/*******************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Sympedia Methods and Tools.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.cdo.core.impl;


import org.eclipse.net4j.spring.ValidationException;
import org.eclipse.net4j.spring.impl.ServiceImpl;

import org.eclipse.emf.cdo.core.NoMoreOIDsException;
import org.eclipse.emf.cdo.core.OIDEncoder;


public class OIDEncoderImpl extends ServiceImpl implements OIDEncoder
{
  public static final int MIN_FRAGMENT_BITS = 32;

  public static final int MAX_FRAGMENT_BITS = 64;

  public static final int DEFAULT_FRAGMENT_BITS = 48;

  protected int fragmentBits = DEFAULT_FRAGMENT_BITS;

  private long fragmentMask;

  public int getRID(long oid)
  {
    return (int) (oid >> fragmentBits);
  }

  public long getOIDFragment(long oid)
  {
    return oid & fragmentMask;
  }

  public long getOID(int rid, long oidFragment)
  {
    if (oidFragment > fragmentMask)
    {
      throw new NoMoreOIDsException();
    }

    long offset = rid;
    offset <<= fragmentBits;
    return offset + oidFragment;
  }

  public String toString(int rid, long oidFragment)
  {
    return "" + rid + ":" + oidFragment;
  }

  public String toString(long oid)
  {
    if (oid >= 0)
    {
      return toString(getRID(oid), getOIDFragment(oid));
    }
    else
    {
      return toString(getRID(-oid), -getOIDFragment(-oid));
    }
  }

  /**
   * @return Returns the fragmentBits.
   */
  public int getFragmentBits()
  {
    return fragmentBits;
  }

  /**
   * @param fragmentBits The fragmentBits to set.
   */
  public void setFragmentBits(int fragmentBits)
  {
    doSet("fragmentBits", fragmentBits);
  }

  protected void validate() throws ValidationException
  {
    super.validate();

    if (fragmentBits < MIN_FRAGMENT_BITS || fragmentBits > MAX_FRAGMENT_BITS)
      throw new ValidationException("fragmentBits is not in range (" + MIN_FRAGMENT_BITS + "-"
          + MAX_FRAGMENT_BITS + "): " + fragmentBits);

    fragmentMask = 0;
    for (int i = 0; i < fragmentBits; i++)
    {
      fragmentMask <<= 1;
      ++fragmentMask;
    }
  }
}