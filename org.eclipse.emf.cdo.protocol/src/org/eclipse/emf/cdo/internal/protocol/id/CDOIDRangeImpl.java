/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.internal.protocol.id;

import org.eclipse.emf.cdo.protocol.id.CDOID;
import org.eclipse.emf.cdo.protocol.id.CDOIDRange;
import org.eclipse.emf.cdo.protocol.id.CDOIDUtil;

import org.eclipse.net4j.util.collection.Pair;

import java.text.MessageFormat;

/**
 * @author Eike Stepper
 */
public final class CDOIDRangeImpl extends Pair<CDOID, CDOID> implements CDOIDRange
{
  public CDOIDRangeImpl(CDOID id1, CDOID id2)
  {
    super(id1, id2);
    if (id1.isMeta() != id2.isMeta())
    {
      throw new IllegalArgumentException("id1.isStatic() != id2.isStatic()");
    }
  }

  public CDOIDRangeImpl(long id1, long id2)
  {
    this(CDOIDUtil.create(id1), CDOIDUtil.create(id2));
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

    return CDOIDUtil.create(lowerBound.getValue() + index);
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

    return lowerBound <= value && value <= upperBound;
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("[{0}:{1}]", getLowerBound(), getUpperBound());
  }
}
