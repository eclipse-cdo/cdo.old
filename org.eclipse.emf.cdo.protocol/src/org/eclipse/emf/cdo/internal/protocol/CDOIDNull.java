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
package org.eclipse.emf.cdo.internal.protocol;

import org.eclipse.emf.cdo.protocol.CDOID;

import org.eclipse.net4j.util.ImplementationError;

/**
 * @author Eike Stepper
 */
public final class CDOIDNull extends CDOIDImpl
{
  private static final long VALUE = 0L;

  public CDOIDNull()
  {
    super(VALUE);
    if (CDOID.NULL != null)
    {
      throw new ImplementationError("NULL is already created");
    }
  }

  @Override
  public boolean isNull()
  {
    return true;
  }

  @Override
  public boolean equals(Object obj)
  {
    return CDOID.NULL == obj;
  }

  @Override
  public int hashCode()
  {
    return 0;
  }

  @Override
  public String toString()
  {
    return "NULL";
  }
}
