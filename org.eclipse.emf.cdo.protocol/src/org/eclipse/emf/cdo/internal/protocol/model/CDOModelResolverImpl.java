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
package org.eclipse.emf.cdo.internal.protocol.model;

import org.eclipse.emf.cdo.internal.protocol.bundle.CDOProtocol;
import org.eclipse.emf.cdo.protocol.CDOConstants;
import org.eclipse.emf.cdo.protocol.model.CDOModelResolver;
import org.eclipse.emf.cdo.protocol.model.CDOPackage;
import org.eclipse.emf.cdo.protocol.model.CDOTypes;

import org.eclipse.net4j.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.stream.ExtendedDataInputStream;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class CDOModelResolverImpl implements CDOModelResolver
{
  private static final ContextTracer TRACER = new ContextTracer(CDOProtocol.DEBUG_MODEL,
      CDOModelResolverImpl.class);

  private Map<String, CDOPackageImpl> packages = new HashMap();

  private CDOPackageImpl cdoResourcePackage;

  private CDOClassImpl cdoResourceClass;

  private CDOFeatureImpl cdoResourceContents;

  public CDOModelResolverImpl()
  {
    initCDOResourceModel();
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

  public CDOClassImpl resolveClass(CDOClassProxy classRef)
  {
    String packageURI = classRef.getPackageURI();
    int classifierID = classRef.getClassifierID();
    CDOPackageImpl cdoPackage = lookupPackage(packageURI);
    CDOClassImpl cdoClass = cdoPackage.lookupClass(classifierID);
    return cdoClass;
  }

  public CDOPackageImpl getCDOResourcePackage()
  {
    return cdoResourcePackage;
  }

  public CDOClassImpl getCDOResourceClass()
  {
    return cdoResourceClass;
  }

  public CDOFeatureImpl getCDOResourceContents()
  {
    return cdoResourceContents;
  }

  private void initCDOResourceModel()
  {
    cdoResourcePackage = new CDOPackageImpl(this, CDOConstants.CDORESOURCE_PACKAGE_URI,
        CDOConstants.CDORESOURCE_PACKAGE_NAME);
    cdoResourceClass = new CDOClassImpl(cdoResourcePackage, CDOConstants.CDORESOURCE_CLASS_ID,
        CDOConstants.CDORESOURCE_CLASS_NAME, false);
    cdoResourceContents = new CDOFeatureImpl(cdoResourceClass,
        CDOConstants.CDORESOURCE_CONTENTS_ID, CDOConstants.CDORESOURCE_CONTENTS_NAME,
        CDOTypes.OBJECT, true, true, null);

    cdoResourceClass.addFeature(cdoResourceContents);
    cdoResourcePackage.addClass(cdoResourceClass);
    addPackage(cdoResourcePackage);
  }

}
