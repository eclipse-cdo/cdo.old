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
package org.eclipse.emf.cdo.protocol.model.resource;

import org.eclipse.emf.cdo.internal.protocol.model.resource.CDOResourceClassImpl;
import org.eclipse.emf.cdo.protocol.model.CDOClass;

/**
 * @author Eike Stepper
 */
public interface CDOResourceClass extends CDOClass
{
  public static final CDOResourceClass INSTANCE = CDOResourceClassImpl.INSTANCE;

  public static final int CLASSIFIER_ID = 0;

  public static final String NAME = "CDOResource";

  public CDOPathFeature getCDOPathFeature();

  public CDOContentsFeature getCDOContentsFeature();
}
