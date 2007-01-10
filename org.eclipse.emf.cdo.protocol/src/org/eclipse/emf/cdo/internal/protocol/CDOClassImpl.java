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
import org.eclipse.emf.cdo.protocol.CDOClassResolver;
import org.eclipse.emf.cdo.protocol.CDOFeature;
import org.eclipse.emf.cdo.protocol.CDOPackage;

import org.eclipse.net4j.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.stream.ExtendedDataInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eike Stepper
 */
public final class CDOClassImpl implements CDOClass
{
  private static final ContextTracer PROTOCOL = new ContextTracer(CDOProtocol.DEBUG_PROTOCOL,
      CDOClassImpl.class);

  private CDOPackage cdoPackage;

  private int classifierID;

  private String name;

  private boolean isAbstract;

  private List<CDOFeatureImpl> cdoFeatures = new ArrayList(0);

  public CDOClassImpl(CDOPackage p, int classifierID, String name, boolean isAbstract)
  {
    cdoPackage = p;
    this.classifierID = classifierID;
    this.name = name;
    this.isAbstract = isAbstract;
  }

  public CDOClassImpl(CDOPackage p, ExtendedDataInputStream in) throws IOException
  {
    cdoPackage = p;
    classifierID = in.readInt();
    name = in.readString();
    isAbstract = in.readBoolean();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Read class: classifierID={0}, name={1}, abstract={2}", classifierID, name,
          isAbstract);
    }

    int size = in.readInt();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Reading {0} features", size);
    }

    for (int i = 0; i < size; i++)
    {
      CDOFeatureImpl f = new CDOFeatureImpl(this, in);
      addCDOFeature(f);
    }
  }

  public CDOPackage getCDOPackage()
  {
    return cdoPackage;
  }

  public int getClassifierID()
  {
    return classifierID;
  }

  public String getName()
  {
    return name;
  }

  public boolean isAbstract()
  {
    return isAbstract;
  }

  public CDOFeature[] getCDOFeatures()
  {
    return cdoFeatures.toArray(new CDOFeatureImpl[cdoFeatures.size()]);
  }

  public void addCDOFeature(CDOFeatureImpl f)
  {
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Adding feature: featureID={0}, name={1}, type={2}, many={3}, classRef={4}",
          f.getFeatureID(), f.getName(), f.getType(), f.isMany(), f.getReferenceClassRef());
    }

    cdoFeatures.add(f);
  }

  public CDOClassID getClassID()
  {
    return new CDOClassID(cdoPackage.getID(), classifierID);
  }

  public CDOClassRef getClassRef()
  {
    return new CDOClassRef(cdoPackage.getURI(), classifierID);
  }

  public void initialize()
  {
    for (CDOFeatureImpl featureDef : cdoFeatures)
    {
      featureDef.initialize();
    }
  }

  public CDOClassResolver getClassResolver()
  {
    return cdoPackage.getClassResolver();
  }
}
