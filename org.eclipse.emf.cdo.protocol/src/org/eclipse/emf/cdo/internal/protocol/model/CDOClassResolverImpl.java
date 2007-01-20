/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.internal.protocol.model;

import org.eclipse.emf.cdo.protocol.model.CDOClassRef;
import org.eclipse.emf.cdo.protocol.model.CDOClassResolver;

/**
 * @author Eike Stepper
 */
public class CDOClassResolverImpl implements CDOClassResolver
{
  public static final CDOClassResolverImpl INSTANCE = (CDOClassResolverImpl)CDOClassResolver.INSTANCE;

  public CDOClassResolverImpl()
  {
  }

  public CDOClassImpl resolveClass(CDOClassRef classRef)
  {
    String packageURI = classRef.getPackageURI();
    int classifierID = classRef.getClassifierID();
    CDOPackageImpl cdoPackage = CDOPackageManagerImpl.INSTANCE.lookupPackage(packageURI);
    if (cdoPackage != null)
    {
      return cdoPackage.lookupClass(classifierID);
    }

    return null;
  }
}
