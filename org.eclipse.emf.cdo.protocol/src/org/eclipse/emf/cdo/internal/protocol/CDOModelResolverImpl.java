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
package org.eclipse.emf.cdo.internal.protocol;

import org.eclipse.emf.cdo.internal.protocol.bundle.CDOProtocol;
import org.eclipse.emf.cdo.protocol.CDOClass;
import org.eclipse.emf.cdo.protocol.CDOClassID;
import org.eclipse.emf.cdo.protocol.CDOClassRef;
import org.eclipse.emf.cdo.protocol.CDOModelResolver;
import org.eclipse.emf.cdo.protocol.CDOPackage;

import org.eclipse.net4j.util.om.trace.ContextTracer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class CDOModelResolverImpl implements CDOModelResolver
{
  private static final ContextTracer TRACER = new ContextTracer(CDOProtocol.DEBUG_MODEL,
      CDOModelResolverImpl.class);

  private Map<Integer, CDOPackageImpl> idToPackage = new HashMap();

  private Map<String, CDOPackageImpl> uriToPackage = new HashMap();

  public CDOModelResolverImpl()
  {
  }

  public String getPackageURI(int packageID)
  {
    return getCDOPackage(packageID).getURI();
  }

  public int getPackageID(String uri)
  {
    return getCDOPackage(uri).getID();
  }

  public CDOPackageImpl getCDOPackage(int packageID)
  {
    return idToPackage.get(packageID);
  }

  public CDOPackageImpl getCDOPackage(String uri)
  {
    return uriToPackage.get(uri);
  }

  public CDOPackage[] getCDOPackages()
  {
    return idToPackage.values().toArray(new CDOPackageImpl[idToPackage.size()]);
  }

  public void addCDOPackage(CDOPackageImpl p)
  {
    if (TRACER.isEnabled())
    {
      TRACER
          .format("Adding package: ID={0}, name={1}, URI={2}", p.getID(), p.getName(), p.getURI());
    }

    idToPackage.put(p.getID(), p);
    uriToPackage.put(p.getURI(), p);
  }

  public CDOClass getCDOClass(CDOClassID classID)
  {
    CDOPackageImpl p = getCDOPackage(classID.getModelID());
    int classifierID = classID.getClassifierID();
    return p.getCDOClass(classifierID);
  }

  public CDOClass getCDOClass(CDOClassRef classRef)
  {
    CDOPackageImpl p = getCDOPackage(classRef.getModelURI());
    int classifierID = classRef.getClassifierID();
    return p.getCDOClass(classifierID);
  }
}
