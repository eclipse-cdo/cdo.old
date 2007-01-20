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
package org.eclipse.emf.cdo.protocol.model.core;

import org.eclipse.emf.cdo.internal.protocol.model.core.CDOCorePackageImpl;
import org.eclipse.emf.cdo.protocol.model.CDOPackage;

/**
 * @author Eike Stepper
 */
public interface CDOCorePackage extends CDOPackage
{
  public static final CDOCorePackage INSTANCE = new CDOCorePackageImpl();

  public static final String PACKAGE_URI = "http://www.eclipse.org/emf/CDO/resource/1.0.0";

  public static final String NAME = "cdoresource";

  public CDOObjectClass getCDOObjectClass();

  public CDOResourceClass getCDOResourceClass();

}