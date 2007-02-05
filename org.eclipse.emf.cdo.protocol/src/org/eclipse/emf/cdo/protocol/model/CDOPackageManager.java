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
package org.eclipse.emf.cdo.protocol.model;

import org.eclipse.emf.cdo.internal.protocol.model.CDOPackageManagerImpl;
import org.eclipse.emf.cdo.protocol.model.core.CDOCorePackage;
import org.eclipse.emf.cdo.protocol.model.resource.CDOResourcePackage;

/**
 * @author Eike Stepper
 */
public interface CDOPackageManager
{
  public static final CDOPackageManager INSTANCE = CDOPackageManagerImpl.INSTANCE;

  public int getPackageCount();

  public CDOPackage[] getPackages();

  public CDOPackage lookupPackage(String packageURI);

  public CDOCorePackage getCDOCorePackage();

  public CDOResourcePackage getCDOResourcePackage();
}
