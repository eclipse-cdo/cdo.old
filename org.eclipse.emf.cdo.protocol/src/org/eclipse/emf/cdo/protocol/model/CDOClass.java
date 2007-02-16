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
package org.eclipse.emf.cdo.protocol.model;

/**
 * @author Eike Stepper
 */
public interface CDOClass extends CDOModelElement
{
  public int getClassifierID();

  public boolean isAbstract();

  public boolean isResource();

  public int getFeatureCount();

  public CDOFeature[] getFeatures();

  public CDOFeature lookupFeature(int featureID);

  public CDOClassRef createClassRef();

  public CDOPackage getContainingPackage();
}