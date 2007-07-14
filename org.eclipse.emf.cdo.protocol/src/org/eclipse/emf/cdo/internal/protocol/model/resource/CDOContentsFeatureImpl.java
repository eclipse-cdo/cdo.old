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
package org.eclipse.emf.cdo.internal.protocol.model.resource;

import org.eclipse.emf.cdo.internal.protocol.model.CDOClassProxy;
import org.eclipse.emf.cdo.internal.protocol.model.CDOFeatureImpl;
import org.eclipse.emf.cdo.internal.protocol.model.CDOPackageManagerImpl;
import org.eclipse.emf.cdo.protocol.model.resource.CDOContentsFeature;

/**
 * @author Eike Stepper
 */
public class CDOContentsFeatureImpl extends CDOFeatureImpl implements CDOContentsFeature
{
  public CDOContentsFeatureImpl(CDOPackageManagerImpl packageManager)
  {
    super(FEATURE_ID, NAME, new CDOClassProxy(packageManager.getCDOCorePackage().getCDOObjectClass()), true, true);
  }
}
