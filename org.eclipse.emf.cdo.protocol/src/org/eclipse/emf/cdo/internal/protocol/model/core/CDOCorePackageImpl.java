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
package org.eclipse.emf.cdo.internal.protocol.model.core;

import org.eclipse.emf.cdo.internal.protocol.model.CDOPackageImpl;
import org.eclipse.emf.cdo.protocol.model.core.CDOCorePackage;

/**
 * @author Eike Stepper
 */
public final class CDOCorePackageImpl extends CDOPackageImpl implements CDOCorePackage
{
  public static final CDOCorePackageImpl INSTANCE = (CDOCorePackageImpl)CDOCorePackage.INSTANCE;

  public CDOCorePackageImpl()
  {
    super(PACKAGE_URI, NAME);
    addClass(CDOObjectClassImpl.INSTANCE);
    addClass(CDOResourceClassImpl.INSTANCE);
  }

  public CDOObjectClassImpl getCDOObjectClass()
  {
    return CDOObjectClassImpl.INSTANCE;
  }

  public CDOResourceClassImpl getCDOResourceClass()
  {
    return CDOResourceClassImpl.INSTANCE;
  }

  @Override
  public String toString()
  {
    return "CDOCorePackage";
  }
}
