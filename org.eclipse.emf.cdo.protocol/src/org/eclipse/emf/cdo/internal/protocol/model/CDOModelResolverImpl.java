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
import org.eclipse.emf.cdo.protocol.model.CDOClassRef;
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

  private CDOPackageImpl cdoCorePackage;

  private CDOClassImpl cdoCoreResourceClass;

  private CDOFeatureImpl cdoCoreResourceContentsFeature;

  public CDOModelResolverImpl()
  {
    initCDOCoreModel();
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
    CDOClassImpl cdoClass = cdoPackage.lookupClass(classifierID);
    return cdoClass;
  }

  public CDOPackageImpl getCDOResourcePackage()
  {
    return cdoCorePackage;
  }

  public CDOClassImpl getCDOResourceClass()
  {
    return cdoCoreResourceClass;
  }

  public CDOFeatureImpl getCDOResourceContents()
  {
    return cdoCoreResourceContentsFeature;
  }

  private void initCDOCoreModel()
  {
    cdoCorePackage = new CDOPackageImpl(this, CDOConstants.CDORESOURCE_PACKAGE_URI,
        CDOConstants.CDORESOURCE_PACKAGE_NAME);
    cdoCoreResourceClass = new CDOClassImpl(cdoCorePackage, CDOConstants.CDORESOURCE_CLASS_ID,
        CDOConstants.CDORESOURCE_CLASS_NAME, false);
    cdoCoreResourceContentsFeature = new CDOFeatureImpl(cdoCoreResourceClass,
        CDOConstants.CDORESOURCE_CONTENTS_ID, CDOConstants.CDORESOURCE_CONTENTS_NAME,
        CDOTypes.OBJECT, true, true, null);

    cdoCoreResourceClass.addFeature(cdoCoreResourceContentsFeature);
    cdoCorePackage.addClass(cdoCoreResourceClass);
    addPackage(cdoCorePackage);
  }

}
