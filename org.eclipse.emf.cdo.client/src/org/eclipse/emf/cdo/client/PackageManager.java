/*******************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Sympedia Methods and Tools.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.cdo.client;


import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.spring.Service;

import org.eclipse.emf.cdo.core.OIDEncoder;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import java.util.Iterator;
import java.util.List;


public interface PackageManager extends Service
{
  public List<PackageInfo> getPackages();

  public ClassInfo getClassInfo(EClass eClass);

  public ClassInfo getClassInfo(EObject eObject);

  public ClassInfo getClassInfo(int cid);

  public Iterator getClassInfos();

  public void initCID(ClassInfo classInfo);

  public void addPackage(EPackage ePackage, String mappingFile);

  public void addPackageListener(PackageListener listener);

  public void removePackageListener(PackageListener listener);

  public void announceNewPackages(Channel channel);

  public OIDEncoder getOidEncoder(); // Don't change case! Spring will be irritated

  public AttributeConverter getAttributeConverter();
}