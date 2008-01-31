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
import org.eclipse.emf.cdo.protocol.id.CDOIDTyped;
import org.eclipse.emf.cdo.protocol.id.CDOIDUtil;
import org.eclipse.emf.cdo.protocol.model.CDOClassRef;

import org.eclipse.net4j.util.ObjectUtil;

/**
 * @author Eike Stepper
 */
public class CDOIDImpl implements CDOID
{
  private static final byte BYTE_ONE = 1;

  private long value;

  public CDOIDImpl(long value)
  {
    this.value = value;
  }

  public long getValue()
  {
    return value;
  }

  public boolean isNull()
  {
    return false;
  }

  public boolean isTemporary()
  {
    return value < 0;
  }

  public boolean isMeta()
  {
    return (value & BYTE_ONE) != 0;
  }

  public CDOID getNext()
  {
    return CDOIDUtil.create(value < 0 ? value - 2 : value + 2);
  }

  public int compareTo(CDOID that)
  {
    if (value < that.getValue())
    {
      return -1;
    }

    if (value > that.getValue())
    {
      return 1;
    }

    return 0;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj == this)
    {
      return true;
    }

    if (obj instanceof CDOIDImpl)
    {
      CDOIDImpl that = (CDOIDImpl)obj;
      return value == that.value;
    }

    return false;
  }

  /**
   * @see Long#hashCode()
   */
  @Override
  public int hashCode()
  {
    return ObjectUtil.hashCode(value);
  }

  @Override
  public String toString()
  {
    return Long.toString(value);
  }

  /**
   * @author Eike Stepper
   */
  public static class Typed extends CDOIDImpl implements CDOIDTyped
  {
    private CDOClassRef type;

    public Typed(long value, CDOClassRef type)
    {
      super(value);
      this.type = type;
    }

    public CDOClassRef getType()
    {
      return type;
    }
  }
}
