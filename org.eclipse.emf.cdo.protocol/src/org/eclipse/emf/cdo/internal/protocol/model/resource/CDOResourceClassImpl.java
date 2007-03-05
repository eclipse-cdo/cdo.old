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

import org.eclipse.emf.cdo.internal.protocol.model.CDOClassImpl;
import org.eclipse.emf.cdo.protocol.model.resource.CDOResourceClass;

/**
 * @author Eike Stepper
 */
public class CDOResourceClassImpl extends CDOClassImpl implements CDOResourceClass
{
  // @Singleton
  public static final CDOResourceClassImpl INSTANCE = new CDOResourceClassImpl();

  public CDOResourceClassImpl()
  {
    super(CLASSIFIER_ID, NAME, false);
    addFeature(CDOPathFeatureImpl.INSTANCE);
    addFeature(CDOContentsFeatureImpl.INSTANCE);
  }

  @Override
  public boolean isResource()
  {
    return true;
  }

  public CDOPathFeatureImpl getCDOPathFeature()
  {
    return CDOPathFeatureImpl.INSTANCE;
  }

  public CDOContentsFeatureImpl getCDOContentsFeature()
  {
    return CDOContentsFeatureImpl.INSTANCE;
  }
}
