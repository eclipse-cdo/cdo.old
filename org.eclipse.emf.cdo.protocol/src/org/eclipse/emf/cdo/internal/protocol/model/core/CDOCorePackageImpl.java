/***************************************************************************
 * Copyright (c) 2004-2007 Eike Stepper, Germany.
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

import org.eclipse.net4j.util.lifecycle.Singleton;

/**
 * @author Eike Stepper
 */
public final class CDOCorePackageImpl extends CDOPackageImpl implements CDOCorePackage
{
  @Singleton
  public static final CDOCorePackageImpl INSTANCE = new CDOCorePackageImpl();

  public CDOCorePackageImpl()
  {
    super(PACKAGE_URI, NAME);
    addClass(CDOObjectClassImpl.INSTANCE);
  }

  public CDOObjectClassImpl getCDOObjectClass()
  {
    return CDOObjectClassImpl.INSTANCE;
  }
}
