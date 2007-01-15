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

import org.eclipse.emf.cdo.internal.protocol.model.CDOClassImpl;
import org.eclipse.emf.cdo.internal.protocol.model.CDOFeatureImpl;

/**
 * @author Eike Stepper
 */
public interface CDOModelResolver
{
  public int getPackageCount();

  public CDOPackage[] getPackages();

  public CDOPackage lookupPackage(String packageURI);

  public CDOPackage getCDOResourcePackage();

  public CDOClassImpl getCDOResourceClass();

  public CDOFeatureImpl getCDOResourceContents();
}
