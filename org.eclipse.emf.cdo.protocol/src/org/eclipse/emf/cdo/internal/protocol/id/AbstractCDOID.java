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

/**
 * @author Eike Stepper
 */
public abstract class AbstractCDOID implements CDOID
{
  private static final long serialVersionUID = 1L;

  public AbstractCDOID()
  {
  }

  public boolean isNull()
  {
    switch (getType())
    {
    case NULL:
      return true;
    default:
      return false;
    }
  }

  public boolean isObject()
  {
    switch (getType())
    {
    case OBJECT:
    case LEGACY_OBJECT:
    case TEMP_OBJECT:
      return true;
    default:
      return false;
    }
  }

  public boolean isLegacy()
  {
    switch (getType())
    {
    case LEGACY_OBJECT:
      return true;
    default:
      return false;
    }
  }

  public boolean isMeta()
  {
    switch (getType())
    {
    case META:
    case TEMP_META:
      return true;
    default:
      return false;
    }
  }

  public boolean isTemporary()
  {
    switch (getType())
    {
    case TEMP_OBJECT:
    case TEMP_META:
      return true;
    default:
      return false;
    }
  }

  // public CDOClassRef getClassRef()
  // {
  // return null;
  // }
  //
  // public CDOID asLegacy(CDOClassRef classRef)
  // {
  // throw new UnsupportedOperationException();
  // }
}
