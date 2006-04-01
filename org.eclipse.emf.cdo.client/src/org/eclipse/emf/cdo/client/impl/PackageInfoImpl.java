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
package org.eclipse.emf.cdo.client.impl;


import org.eclipse.net4j.core.Channel;

import org.eclipse.emf.cdo.client.ClassInfo;
import org.eclipse.emf.cdo.client.PackageInfo;
import org.eclipse.emf.cdo.client.PackageManager;
import org.eclipse.emf.cdo.client.protocol.CdoClientProtocolImpl;
import org.eclipse.emf.cdo.mapping.PackageMapping;
import org.eclipse.emf.ecore.EPackage;

import java.util.ArrayList;
import java.util.List;


public class PackageInfoImpl implements PackageInfo
{
  private PackageManager packageManager;

  private transient boolean announced = false;

  private transient EPackage ePackage;

  private transient PackageMapping mapping;

  private transient List classes = new ArrayList();

  public PackageInfoImpl(EPackage ePackage, PackageMapping mapping, PackageManager packageManager)
  {
    this.ePackage = ePackage;
    this.mapping = mapping;
    this.packageManager = packageManager;
  }

  public String toString()
  {
    return getFullName();
  }

  public String getName()
  {
    return ePackage.getName();
  }

  public String getFullName()
  {
    return ePackage.getNsPrefix();
  }

  public EPackage getEPackage()
  {
    return ePackage;
  }

  public PackageMapping getMapping()
  {
    return mapping;
  }

  public void addClass(ClassInfo classInfo)
  {
    classes.add(classInfo);
  }

  public ClassInfo[] getClasses()
  {
    return (ClassInfo[]) classes.toArray(new ClassInfo[classes.size()]);
  }

  public boolean isAnnounced()
  {
    return announced;
  }

  public void announce(Channel channel)
  {
    if (!CdoClientProtocolImpl.requestAnnouncePackage(channel, this))
    {
      CdoClientProtocolImpl.requestDescribePackage(channel, this);
    }

    announced = true;
  }

  public PackageManager getPackageManager()
  {
    return packageManager;
  }
}
