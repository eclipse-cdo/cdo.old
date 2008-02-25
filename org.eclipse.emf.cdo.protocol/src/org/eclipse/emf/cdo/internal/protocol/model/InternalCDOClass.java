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
package org.eclipse.emf.cdo.internal.protocol.model;

import org.eclipse.emf.cdo.protocol.model.CDOClass;
import org.eclipse.emf.cdo.protocol.model.CDOClassRef;
import org.eclipse.emf.cdo.protocol.model.CDOFeature;
import org.eclipse.emf.cdo.protocol.model.CDOPackage;

import org.eclipse.net4j.util.io.ExtendedDataOutput;

import java.io.IOException;
import java.util.List;

/**
 * @author Eike Stepper
 */
public interface InternalCDOClass extends CDOClass, InternalCDOModelElement
{
  public void setContainingPackage(CDOPackage containingPackage);

  public void addSuperType(CDOClassRef classRef);

  public void addFeature(CDOFeature cdoFeature);

  public int getFeatureIndex(int featureID);

  public List<CDOClassProxy> getSuperTypeProxies();

  public void write(ExtendedDataOutput out) throws IOException;
}
