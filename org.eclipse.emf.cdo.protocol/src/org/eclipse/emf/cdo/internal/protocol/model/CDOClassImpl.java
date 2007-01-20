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
import org.eclipse.emf.cdo.protocol.model.CDOClass;
import org.eclipse.emf.cdo.protocol.model.CDOClassRef;
import org.eclipse.emf.cdo.protocol.model.CDOPackage;

import org.eclipse.net4j.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.stream.ExtendedDataInputStream;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class CDOClassImpl extends CDOModelElementImpl implements CDOClass
{
  private static final ContextTracer MODEL = new ContextTracer(CDOProtocol.DEBUG_MODEL,
      CDOClassImpl.class);

  private static final ContextTracer PROTOCOL = new ContextTracer(CDOProtocol.DEBUG_PROTOCOL,
      CDOClassImpl.class);

  private CDOPackageImpl containingPackage;

  private int classifierID;

  private boolean isAbstract;

  private List<CDOFeatureImpl> features = new ArrayList(0);

  private transient List<Integer> index = new ArrayList(0);

  public CDOClassImpl(int classifierID, String name, boolean isAbstract)
  {
    super(name);
    this.classifierID = classifierID;
    this.isAbstract = isAbstract;
  }

  public CDOClassImpl(ExtendedDataInputStream in) throws IOException
  {
    super(in);
    classifierID = in.readInt();
    isAbstract = in.readBoolean();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Read class: ID={0}, name={1}, abstract={2}", classifierID, getName(),
          isAbstract);
    }

    int size = in.readInt();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Reading {0} features", size);
    }

    for (int i = 0; i < size; i++)
    {
      CDOFeatureImpl cdoFeature = new CDOFeatureImpl(in);
      addFeature(cdoFeature);
    }
  }

  public void write(ExtendedDataOutputStream out) throws IOException
  {
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Writing class: ID={0}, name={1}, abstract={2}", classifierID, getName(),
          isAbstract);
    }

    super.write(out);
    out.writeInt(classifierID);
    out.writeBoolean(isAbstract);

    int size = features.size();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Writing {0} features", size);
    }

    out.writeInt(size);
    for (CDOFeatureImpl cdoFeature : features)
    {
      cdoFeature.write(out);
    }
  }

  public CDOPackage getContainingPackage()
  {
    return containingPackage;
  }

  public int getClassifierID()
  {
    return classifierID;
  }

  public boolean isAbstract()
  {
    return isAbstract;
  }

  public int getFeatureCount()
  {
    return features.size();
  }

  public CDOFeatureImpl[] getFeatures()
  {
    return features.toArray(new CDOFeatureImpl[features.size()]);
  }

  public CDOFeatureImpl lookupFeature(int featureID)
  {
    int i = index.get(featureID);
    return features.get(i);
  }

  public CDOClassRefImpl createClassRef()
  {
    return new CDOClassRefImpl(containingPackage.getPackageURI(), classifierID);
  }

  public void addFeature(CDOFeatureImpl cdoFeature)
  {
    int featureID = cdoFeature.getFeatureID();
    if (MODEL.isEnabled())
    {
      MODEL.format("Adding feature: {0}", cdoFeature);
    }

    cdoFeature.setContainingClass(this);
    setIndex(featureID, features.size());
    features.add(cdoFeature);
  }

  public void setContainingPackage(CDOPackageImpl containingPackage)
  {
    this.containingPackage = containingPackage;
  }

  public void initialize()
  {
    for (CDOFeatureImpl cdoFeature : features)
    {
      cdoFeature.initialize();
    }
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("CDOClass(id={0}, name={1})", classifierID, getName());
  }

  private void setIndex(int id, int i)
  {
    while (index.size() <= id)
    {
      index.add(null);
    }

    index.set(id, i);
  }
}
