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
import org.eclipse.emf.cdo.protocol.model.CDOClass;

import org.eclipse.net4j.internal.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class CDOClassImpl extends CDOModelElementImpl implements CDOClass
{
  private static final ContextTracer MODEL = new ContextTracer(OM.DEBUG_MODEL, CDOClassImpl.class);

  private static final ContextTracer PROTOCOL = new ContextTracer(OM.DEBUG_PROTOCOL, CDOClassImpl.class);

  private static final byte SEGMENT_THIS = 0;

  private static final byte SEGMENT_SAME = 1;

  private static final byte SEGMENT_NEXT = 2;

  private CDOPackageImpl containingPackage;

  private int classifierID;

  private boolean isAbstract;

  private List<CDOClassProxy> superTypes = new ArrayList(0);

  private CDOClassImpl[] allSuperTypes;

  private List<CDOFeatureImpl> features = new ArrayList(0);

  private CDOFeatureImpl[] allFeatures;

  private transient List<Integer> index = new ArrayList(0);

  public CDOClassImpl(CDOPackageImpl containingPackage, int classifierID, String name, boolean isAbstract)
  {
    super(name);
    this.containingPackage = containingPackage;
    this.classifierID = classifierID;
    this.isAbstract = isAbstract;
    if (MODEL.isEnabled())
    {
      MODEL.format("Created {0}", this);
    }
  }

  public CDOClassImpl(CDOPackageImpl containingPackage, ExtendedDataInputStream in) throws IOException
  {
    super(in);
    this.containingPackage = containingPackage;
    classifierID = in.readInt();
    isAbstract = in.readBoolean();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Read class: ID={0}, name={1}, abstract={2}", classifierID, getName(), isAbstract);
    }

    int size = in.readInt();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Reading {0} features", size);
    }

    for (int i = 0; i < size; i++)
    {
      CDOFeatureImpl cdoFeature = new CDOFeatureImpl(this, in);
      addFeature(cdoFeature);
    }

    // size = in.readInt();
    // if (PROTOCOL.isEnabled())
    // {
    // PROTOCOL.format("Reading {0} super types", size);
    // }
    //
    // for (int i = 0; i < size; i++)
    // {
    // CDOClassRefImpl classRef = new CDOClassRefImpl(in,
    // containingPackage.getPackageURI());
    // }
  }

  @Override
  public void write(ExtendedDataOutputStream out) throws IOException
  {
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Writing class: ID={0}, name={1}, abstract={2}", classifierID, getName(), isAbstract);
    }

    super.write(out);
    out.writeInt(classifierID);
    out.writeBoolean(isAbstract);

    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Writing {0} features", features.size());
    }

    out.writeInt(features.size());
    for (CDOFeatureImpl cdoFeature : features)
    {
      cdoFeature.write(out);
    }

    // if (PROTOCOL.isEnabled())
    // {
    // PROTOCOL.format("Writing {0} super types", allSuperTypes.length);
    // }
    //
    // out.writeInt(allSuperTypes.length);
    // for (CDOClassImpl cdoClass : allSuperTypes)
    // {
    // cdoClass.createClassRef().write(out, containingPackage.getPackageURI());
    // }
    //
    // CDOClassImpl lastClass = null;
    // for (CDOFeatureImpl cdoFeature : allFeatures)
    // {
    // CDOClassImpl containingClass = cdoFeature.getContainingClass();
    // if (containingClass == this)
    // {
    // out.writeByte(SEGMENT_THIS);
    // break;
    // }
    // else if (containingClass == lastClass)
    // {
    // out.writeByte(SEGMENT_SAME);
    // }
    // else
    // {
    // out.writeByte(SEGMENT_NEXT);
    // containingClass.createClassRef().write(out,
    // containingPackage.getPackageURI());
    // lastClass = containingClass;
    // }
    // }
  }

  public CDOPackageImpl getContainingPackage()
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

  public boolean isResource()
  {
    return false;
  }

  public int getSuperTypeCount()
  {
    return superTypes.size();
  }

  public CDOClass[] getSuperTypes()
  {
    int size = superTypes.size();
    CDOClass[] result = new CDOClass[size];
    for (int i = 0; i < size; i++)
    {
      result[i] = getSuperType(i);
    }

    return result;
  }

  public CDOClass getSuperType(int index)
  {
    return superTypes.get(index).getCDOClass();
  }

  public CDOClassImpl[] getAllSuperTypes()
  {
    return allSuperTypes;
  }

  public void setAllSuperTypes(CDOClassImpl[] allSuperTypes)
  {
    this.allSuperTypes = allSuperTypes;
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
    return features.get(i);// XXX Use allFeatures!!!
  }

  public CDOClassRefImpl createClassRef()
  {
    return new CDOClassRefImpl(containingPackage.getPackageURI(), classifierID);
  }

  public void addSuperType(CDOClassRefImpl classRef)
  {
    if (MODEL.isEnabled())
    {
      MODEL.format("Adding super type: {0}", classRef);
    }

    superTypes.add(new CDOClassProxy(classRef, containingPackage.getPackageManager()));
  }

  public void addFeature(CDOFeatureImpl cdoFeature)
  {
    int featureID = cdoFeature.getFeatureID();
    if (MODEL.isEnabled())
    {
      MODEL.format("Adding feature: {0}", cdoFeature);
    }

    int i = features.size();
    setIndex(featureID, i);
    cdoFeature.setFeatureIndex(i);
    features.add(cdoFeature);
  }

  public CDOFeatureImpl[] getAllFeatures()
  {
    return allFeatures;
  }

  public void setAllFeatures(CDOFeatureImpl[] allFeatures)
  {
    this.allFeatures = allFeatures;
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
    return MessageFormat.format("CDOClass(ID={0}, name={1})", classifierID, getName());
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
