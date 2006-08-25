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
package org.eclipse.emf.cdo.client;


import org.eclipse.net4j.core.Channel;

import org.eclipse.emf.cdo.mapping.PackageMapping;
import org.eclipse.emf.ecore.EPackage;


public interface PackageInfo
{
  public String getName();

  public String getFullName();

  public EPackage getEPackage();

  public PackageMapping getMapping();

  public void addClass(ClassInfo classInfo);

  public ClassInfo[] getClasses();

  public boolean isAnnounced();

  public void announce(Channel channel);

  public PackageManager getPackageManager();
}
