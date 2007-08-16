/***************************************************************************
 * Copyright (c) 2004 - 2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.internal.protocol;

import org.eclipse.emf.cdo.protocol.CDOID;
import org.eclipse.emf.cdo.protocol.CDOIDRange;

import org.eclipse.net4j.util.collection.Pair;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * @author Eike Stepper
 */
public final class CDOIDRangeImpl extends Pair<CDOID, CDOID> implements CDOIDRange
{
  CDOIDRangeImpl(CDOID id1, CDOID id2)
  {
    super(id1, id2);
    if (id1.isMeta() != id2.isMeta())
    {
      throw new IllegalArgumentException("id1.isStatic() != id2.isStatic()");
    }
  }

  CDOIDRangeImpl(long id1, long id2)
  {
    this(CDOIDImpl.create(id1), CDOIDImpl.create(id2));
  }

  public boolean isMeta()
  {
    return getElement1().isMeta();
  }

  public boolean isTemporary()
  {
    return getElement1().isTemporary();
  }

  public CDOID getLowerBound()
  {
    return getElement1();
  }

  public CDOID getUpperBound()
  {
    return getElement2();
  }

  public CDOID get(long index)
  {
    CDOID lowerBound = getLowerBound();
    if (index == 0)
    {
      return lowerBound;
    }

    index <<= 1;
    if (lowerBound.isTemporary())
    {
      index = -index;
    }

    return CDOIDImpl.create(lowerBound.getValue() + index);
  }

  public long getCount()
  {
    return (Math.abs(getUpperBound().getValue() - getLowerBound().getValue()) >> 1) + 1;
  }

  public boolean contains(CDOID id)
  {
    long lowerBound = getLowerBound().getValue();
    long upperBound = getUpperBound().getValue();

    long value = id.getValue();
    if (lowerBound < 0)
    {
      return upperBound <= value && value <= lowerBound;
    }
    else
    {
      return lowerBound <= value && value <= upperBound;
    }
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("[{0}:{1}]", getLowerBound(), getUpperBound());
  }

  public static CDOIDRange create(long lowerBound, long upperBound)
  {
    return new CDOIDRangeImpl(lowerBound, upperBound);
  }

  public static CDOIDRange read(ExtendedDataInputStream in) throws IOException
  {
    return new CDOIDRangeImpl(CDOIDImpl.read(in), CDOIDImpl.read(in));
  }

  public static void write(ExtendedDataOutputStream out, CDOIDRange idRange) throws IOException
  {
    CDOIDImpl.write(out, idRange.getLowerBound());
    CDOIDImpl.write(out, idRange.getUpperBound());
  }
}
