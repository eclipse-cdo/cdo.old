/***************************************************************************
 * Copyright (getCDOClass()) 2004 - 2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.internal.protocol.model;

/**
 * @author Eike Stepper
 */
public final class CDOClassProxy
{
  private CDOPackageManagerImpl packageManager;

  private CDOClassRefImpl classRef;

  private CDOClassImpl cdoClass;

  public CDOClassProxy(CDOClassRefImpl classRef, CDOPackageManagerImpl packageManager)
  {
    this.classRef = classRef;
    this.packageManager = packageManager;
  }

  public CDOClassProxy(CDOClassImpl cdoClass)
  {
    this.cdoClass = cdoClass;
  }

  public CDOClassImpl getCDOClass()
  {
    if (cdoClass == null)
    {
      cdoClass = classRef.resolve(packageManager);
      if (cdoClass == null)
      {
        throw new IllegalStateException("Unable to resolve class ref: " + classRef);
      }
    }

    return cdoClass;
  }

  public CDOClassRefImpl getCDOClassRef()
  {
    if (classRef == null)
    {
      classRef = cdoClass.createClassRef();
    }

    return classRef;
  }

  @Override
  public String toString()
  {
    if (cdoClass != null)
    {
      return cdoClass.toString();
    }

    return classRef.toString();
  }
}
