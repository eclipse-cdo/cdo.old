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

import org.eclipse.emf.cdo.protocol.id.CDOIDObject;
import org.eclipse.emf.cdo.protocol.model.CDOClassRef;

/**
 * @author Eike Stepper
 */
public class CDOIDObjectImpl extends AbstractCDOIDLong implements CDOIDObject
{
  private static final long serialVersionUID = 1L;

  public CDOIDObjectImpl()
  {
  }

  public CDOIDObjectImpl(long value)
  {
    super(value);
  }

  public Type getType()
  {
    return Type.OBJECT;
  }

  public CDOClassRef getClassRef()
  {
    return null;
  }

  public Legacy asLegacy(CDOClassRef classRef)
  {
    return new Legacy(getValue(), classRef);
  }

  @Override
  public String toString()
  {
    return "OID" + getValue();
  }

  /**
   * @author Eike Stepper
   */
  public static class Legacy extends CDOIDObjectImpl
  {
    private static final long serialVersionUID = 1L;

    private CDOClassRef classRef;

    public Legacy()
    {
    }

    public Legacy(long value, CDOClassRef classRef)
    {
      super(value);
      if (classRef == null)
      {
        throw new IllegalArgumentException("classRef == null");
      }

      this.classRef = classRef;
    }

    @Override
    public Type getType()
    {
      return Type.LEGACY_OBJECT;
    }

    @Override
    public CDOClassRef getClassRef()
    {
      return classRef;
    }

    public void setClassRef(CDOClassRef classRef)
    {
      this.classRef = classRef;
    }

    @Override
    public Legacy asLegacy(CDOClassRef classRef)
    {
      return this;
    }

    @Override
    public String toString()
    {
      return super.toString() + "(" + classRef + ")";
    }
  }
}
