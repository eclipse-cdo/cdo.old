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
package org.eclipse.emf.cdo.internal.protocol.model;

import org.eclipse.emf.cdo.internal.protocol.bundle.CDOProtocol;
import org.eclipse.emf.cdo.internal.protocol.model.core.CDOCorePackageImpl;
import org.eclipse.emf.cdo.internal.protocol.model.resource.CDOResourcePackageImpl;
import org.eclipse.emf.cdo.protocol.model.CDOClassRef;
import org.eclipse.emf.cdo.protocol.model.CDOPackage;
import org.eclipse.emf.cdo.protocol.model.CDOPackageManager;

import org.eclipse.net4j.util.lifecycle.Singleton;
import org.eclipse.net4j.util.om.trace.ContextTracer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class CDOPackageManagerImpl implements CDOPackageManager
{
  private static final ContextTracer TRACER = new ContextTracer(CDOProtocol.DEBUG_MODEL, CDOPackageManagerImpl.class);

  @Singleton
  public static final CDOPackageManagerImpl INSTANCE = new CDOPackageManagerImpl();

  private Map<String, CDOPackageImpl> packages = new HashMap();

  public CDOPackageManagerImpl()
  {
    addPackage(CDOCorePackageImpl.INSTANCE);
    addPackage(CDOResourcePackageImpl.INSTANCE);
  }

  public CDOPackageImpl lookupPackage(String uri)
  {
    return packages.get(uri);
  }

  public int getPackageCount()
  {
    return packages.size();
  }

  public CDOPackage[] getPackages()
  {
    return packages.values().toArray(new CDOPackageImpl[packages.size()]);
  }

  public void addPackage(CDOPackageImpl cdoPackage)
  {
    if (TRACER.isEnabled())
    {
      TRACER.format("Adding package: {0}", cdoPackage);
    }

    packages.put(cdoPackage.getPackageURI(), cdoPackage);
  }

  public CDOClassImpl resolveClass(CDOClassRef classRef)
  {
    String packageURI = classRef.getPackageURI();
    int classifierID = classRef.getClassifierID();
    CDOPackageImpl cdoPackage = lookupPackage(packageURI);
    if (cdoPackage != null)
    {
      return cdoPackage.lookupClass(classifierID);
    }

    return null;
  }

  public CDOCorePackageImpl getCDOCorePackage()
  {
    return CDOCorePackageImpl.INSTANCE;
  }

  public CDOResourcePackageImpl getCDOResourcePackage()
  {
    return CDOResourcePackageImpl.INSTANCE;
  }
}