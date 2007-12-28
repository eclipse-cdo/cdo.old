/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.internal.protocol.model.resource;

import org.eclipse.emf.cdo.internal.protocol.model.CDOClassImpl;
import org.eclipse.emf.cdo.internal.protocol.model.CDOPackageImpl;
import org.eclipse.emf.cdo.internal.protocol.model.CDOPackageManagerImpl;
import org.eclipse.emf.cdo.protocol.model.resource.CDOResourceClass;

/**
 * @author Eike Stepper
 */
public class CDOResourceClassImpl extends CDOClassImpl implements CDOResourceClass
{
  private CDOPathFeatureImpl cdoPathFeature;

  private CDOContentsFeatureImpl cdoContentsFeature;

  public CDOResourceClassImpl(CDOPackageImpl containingPackage, CDOPackageManagerImpl packageManager)
  {
    super(containingPackage, CLASSIFIER_ID, NAME, false);
    addFeature(cdoPathFeature = new CDOPathFeatureImpl(this));
    addFeature(cdoContentsFeature = new CDOContentsFeatureImpl(this, packageManager));
  }

  @Override
  public boolean isResource()
  {
    return true;
  }

  public CDOPathFeatureImpl getCDOPathFeature()
  {
    return cdoPathFeature;
  }

  public CDOContentsFeatureImpl getCDOContentsFeature()
  {
    return cdoContentsFeature;
  }
}
