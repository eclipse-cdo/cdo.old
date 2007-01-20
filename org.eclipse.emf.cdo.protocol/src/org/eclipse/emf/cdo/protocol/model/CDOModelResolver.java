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

import org.eclipse.emf.cdo.internal.protocol.model.CDOModelResolverImpl;
import org.eclipse.emf.cdo.protocol.model.core.CDOCorePackage;

/**
 * @author Eike Stepper
 */
public interface CDOModelResolver
{
  public static final CDOModelResolver INSTANCE = new CDOModelResolverImpl();

  public int getPackageCount();

  public CDOPackage[] getPackages();

  public CDOPackage lookupPackage(String packageURI);

  public CDOClass resolveClass(CDOClassRef classRef);

  public CDOCorePackage getCDOCorePackage();
}
