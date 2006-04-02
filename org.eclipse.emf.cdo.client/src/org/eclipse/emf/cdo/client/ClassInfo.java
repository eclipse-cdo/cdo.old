/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.client;


import org.eclipse.emf.cdo.mapping.ClassMapping;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;


public interface ClassInfo
{
  public int getCID();

  public void setCID(int cid);

  public String getName();

  public String getFullName();

  public EClass getEClass();

  public ClassInfo getParent();

  public ClassMapping getMapping();

  public PackageInfo getPackageInfo();

  public AttributeInfo[] getAttributeInfos();

  public EReference[] getAllReferences();

  public AttributeInfo getAttributeInfo(EAttribute eAttribute);

  public AttributeInfo getAttributeInfo(int feature);
}
