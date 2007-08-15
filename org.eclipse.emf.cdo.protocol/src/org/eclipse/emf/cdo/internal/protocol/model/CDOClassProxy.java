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

import org.eclipse.emf.cdo.protocol.model.CDOPackageManager;

/**
 * @author Eike Stepper
 */
public final class CDOClassProxy
{
  private CDOPackageManager packageManager;

  private CDOClassRefImpl classRef;

  private CDOClassImpl cdoClass;

  public CDOClassProxy(CDOClassRefImpl classRef, CDOPackageManager packageManager)
  {
    this.classRef = classRef;
    this.packageManager = packageManager;
  }

  public CDOClassProxy(CDOClassImpl cdoClass)
  {
    this.cdoClass = cdoClass;
  }

  public String getPackageURI()
  {
    if (cdoClass == null)
    {
      return classRef.getPackageURI();
    }

    return cdoClass.getContainingPackage().getPackageURI();
  }

  public int getClassifierID()
  {
    if (cdoClass == null)
    {
      return classRef.getClassifierID();
    }

    return cdoClass.getClassifierID();
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

  public CDOClassRefImpl getClassRef()
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
