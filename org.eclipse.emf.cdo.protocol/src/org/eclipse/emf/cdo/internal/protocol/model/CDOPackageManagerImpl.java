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

import org.eclipse.emf.cdo.internal.protocol.bundle.OM;
import org.eclipse.emf.cdo.internal.protocol.model.core.CDOCorePackageImpl;
import org.eclipse.emf.cdo.internal.protocol.model.resource.CDOResourcePackageImpl;
import org.eclipse.emf.cdo.protocol.model.CDOClassRef;
import org.eclipse.emf.cdo.protocol.model.CDOPackage;
import org.eclipse.emf.cdo.protocol.model.CDOPackageManager;

import org.eclipse.net4j.internal.util.container.SingleDeltaContainerEvent;
import org.eclipse.net4j.internal.util.event.Notifier;
import org.eclipse.net4j.internal.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.container.IContainer;
import org.eclipse.net4j.util.container.IContainerDelta;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Eike Stepper
 */
public abstract class CDOPackageManagerImpl extends Notifier implements CDOPackageManager, IContainer<CDOPackage>
{
  private static final ContextTracer TRACER = new ContextTracer(OM.DEBUG_MODEL, CDOPackageManagerImpl.class);

  private ConcurrentMap<String, CDOPackageImpl> packages = new ConcurrentHashMap();

  private CDOCorePackageImpl cdoCorePackage;

  private CDOResourcePackageImpl cdoResourcePackage;

  public CDOPackageManagerImpl()
  {
    addPackage(cdoCorePackage = new CDOCorePackageImpl(this));
    addPackage(cdoResourcePackage = new CDOResourcePackageImpl(this));
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

  public CDOClassImpl resolveClass(CDOClassRef classRef)
  {
    String packageURI = classRef.getPackageURI();
    CDOPackageImpl cdoPackage = lookupPackage(packageURI);

    int classifierID = classRef.getClassifierID();
    return cdoPackage.lookupClass(classifierID);
  }

  public CDOCorePackageImpl getCDOCorePackage()
  {
    return cdoCorePackage;
  }

  public CDOResourcePackageImpl getCDOResourcePackage()
  {
    return cdoResourcePackage;
  }

  public boolean isEmpty()
  {
    return packages.isEmpty();
  }

  public CDOPackage[] getElements()
  {
    return getPackages();
  }

  public List<CDOPackageImpl> getTransientPackages()
  {
    List<CDOPackageImpl> result = new ArrayList();
    for (CDOPackageImpl cdoPackage : packages.values())
    {
      if (!cdoPackage.isPersistent())
      {
        result.add(cdoPackage);
      }
    }

    return result;
  }

  public void addPackage(CDOPackageImpl cdoPackage)
  {
    CDOPackage existing = packages.putIfAbsent(cdoPackage.getPackageURI(), cdoPackage);
    if (existing == null)
    {
      if (TRACER.isEnabled())
      {
        TRACER.format("Added package: {0}", cdoPackage);
      }

      fireEvent(new SingleDeltaContainerEvent(this, cdoPackage, IContainerDelta.Kind.ADDED));
    }
    else
    {
      throw new IllegalStateException("Duplicate package: " + cdoPackage);
    }
  }

  /**
   * @param cdoPackage
   *          is a proxy CDO package. The implementer of this method must only
   *          use the package URI of the cdoPackage passed in.
   */
  protected abstract void resolve(CDOPackageImpl cdoPackage);
}
