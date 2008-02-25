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
package org.eclipse.emf.cdo.internal.protocol.model.core;

import org.eclipse.emf.cdo.internal.protocol.model.CDOClassImpl;
import org.eclipse.emf.cdo.protocol.model.CDOPackage;
import org.eclipse.emf.cdo.protocol.model.core.CDOObjectClass;

/**
 * @author Eike Stepper
 */
public class CDOObjectClassImpl extends CDOClassImpl implements CDOObjectClass
{
  public CDOObjectClassImpl(CDOPackage containingPackage)
  {
    super(containingPackage, CLASSIFIER_ID, NAME, false);
  }

  @Override
  public boolean isRoot()
  {
    return true;
  }
}
