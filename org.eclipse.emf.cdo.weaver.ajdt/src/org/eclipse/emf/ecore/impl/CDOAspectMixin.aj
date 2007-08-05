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
package org.eclipse.emf.ecore.impl;

/**
 * @author Eike Stepper
 */
public aspect CDOAspectMixin
{
  declare parents: EObjectImpl implements CDOAware;

  private CDOCallback EObjectImpl.cdoCallback = null;

  public CDOCallback EObjectImpl.getCDOCallback()
  {
    return cdoCallback;
  }

  public void EObjectImpl.setCDOCallback(CDOCallback callback)
  {
    cdoCallback = callback;
  }

  public void EObjectImpl.beforeRead()
  {
    if (cdoCallback != null && eDeliver())
    {
      cdoCallback.beforeRead(this);
    }
  }

  public void EObjectImpl.beforeWrite()
  {
    if (cdoCallback != null && eDeliver())
    {
      cdoCallback.beforeWrite(this);
    }
  }
}
