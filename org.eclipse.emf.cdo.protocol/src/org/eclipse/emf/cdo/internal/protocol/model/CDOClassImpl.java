/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
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
import org.eclipse.emf.cdo.protocol.model.CDOClassRef;
import org.eclipse.emf.cdo.protocol.model.CDOFeature;
import org.eclipse.emf.cdo.protocol.model.CDOModelUtil;
import org.eclipse.emf.cdo.protocol.model.CDOPackage;
import org.eclipse.emf.cdo.protocol.model.CDOPackageManager;

import org.eclipse.net4j.internal.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.ObjectUtil;
import org.eclipse.net4j.util.io.ExtendedDataInput;
import org.eclipse.net4j.util.io.ExtendedDataOutput;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class CDOClassImpl extends CDOModelElementImpl implements CDOClass
{
  private static final ContextTracer MODEL = new ContextTracer(OM.DEBUG_MODEL, CDOClassImpl.class);

  private static final ContextTracer PROTOCOL = new ContextTracer(OM.DEBUG_PROTOCOL, CDOClassImpl.class);

  private CDOPackage containingPackage;

  private int classifierID;

  private boolean isAbstract;

  private List<CDOClassProxy> superTypes = new ArrayList<CDOClassProxy>(0);

  private List<CDOFeature> features = new ArrayList<CDOFeature>(0);

  private transient List<Integer> indices;

  private transient CDOClass[] allSuperTypes;

  private transient CDOFeature[] allFeatures;

  public CDOClassImpl(CDOPackage containingPackage, int classifierID, String name, boolean isAbstract)
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

  public CDOClassImpl(CDOPackage containingPackage, ExtendedDataInput in) throws IOException
  {
    this.containingPackage = containingPackage;
    read(in);
  }

  @Override
  public void read(ExtendedDataInput in) throws IOException
  {
    super.read(in);
    classifierID = in.readInt();
    isAbstract = in.readBoolean();
    readSuperTypes(in);
    readFeatures(in);

    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Read class: ID={0}, name={1}, abstract={2}", classifierID, getName(), isAbstract);
    }
  }

  @Override
  public void write(ExtendedDataOutput out) throws IOException
  {
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Writing class: ID={0}, name={1}, abstract={2}", classifierID, getName(), isAbstract);
    }

    super.write(out);
    out.writeInt(classifierID);
    out.writeBoolean(isAbstract);
    writeSuperTypes(out);
    writeFeatures(out);
  }

  public CDOPackageManager getPackageManager()
  {
    return containingPackage.getPackageManager();
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

  public boolean isResource()
  {
    return false;
  }

  public boolean isRoot()
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

  public List<CDOClassProxy> getSuperTypeProxies()
  {
    return Collections.unmodifiableList(superTypes);
  }

  public int getFeatureCount()
  {
    return features.size();
  }

  public CDOFeature[] getFeatures()
  {
    return features.toArray(new CDOFeature[features.size()]);
  }

  public CDOFeature lookupFeature(int featureID)
  {
    int i = getIndex(featureID);
    return getAllFeatures()[i];
  }

  public CDOFeature lookupFeature(String name)
  {
    for (CDOFeature feature : getAllFeatures())
    {
      if (ObjectUtil.equals(feature.getName(), name))
      {
        return feature;
      }
    }

    return null;
  }

  public CDOClassRef createClassRef()
  {
    return CDOModelUtil.createClassRef(containingPackage.getPackageURI(), classifierID);
  }

  public CDOClass[] getAllSuperTypes()
  {
    if (allSuperTypes == null)
    {
      List<CDOClass> result = new ArrayList<CDOClass>(0);
      for (CDOClass superType : getSuperTypes())
      {
        CDOClass[] higherSupers = superType.getAllSuperTypes();
        for (CDOClass higherSuper : higherSupers)
        {
          addUnique(higherSuper, result);
        }

        addUnique(superType, result);
      }

      allSuperTypes = result.toArray(new CDOClass[result.size()]);
    }

    return allSuperTypes;
  }

  public int getIndex(int featureID)
  {
    if (indices == null)
    {
      CDOFeature[] features = getAllFeatures();
      indices = new ArrayList<Integer>(features.length);
      int index = 0;
      for (CDOFeature feature : features)
      {
        ((CDOFeatureImpl)feature).setFeatureIndex(index);
        setIndex(feature.getFeatureID(), index);
        index++;
      }
    }

    return indices.get(featureID);
  }

  public CDOFeature[] getAllFeatures()
  {
    if (allFeatures == null)
    {
      List<CDOFeature> result = new ArrayList<CDOFeature>(0);
      for (CDOClass superType : getSuperTypes())
      {
        CDOFeature[] features = superType.getAllFeatures();
        addAllFeatures(features, result);
      }

      addAllFeatures(getFeatures(), result);
      allFeatures = result.toArray(new CDOFeature[result.size()]);
    }

    return allFeatures;
  }

  public void addSuperType(CDOClassRef classRef)
  {
    if (MODEL.isEnabled())
    {
      MODEL.format("Adding super type: {0}", classRef);
    }

    superTypes.add(new CDOClassProxy(classRef, containingPackage.getPackageManager()));
  }

  public void addFeature(CDOFeature cdoFeature)
  {
    if (MODEL.isEnabled())
    {
      MODEL.format("Adding feature: {0}", cdoFeature);
    }

    features.add(cdoFeature);
  }

  public int compareTo(CDOClass that)
  {
    return getName().compareTo(that.getName());
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("CDOClass(ID={0}, name={1})", classifierID, getName());
  }

  @Override
  protected void onInitialize()
  {
    for (CDOFeature cdoFeature : features)
    {
      ((CDOFeatureImpl)cdoFeature).initialize();
    }
  }

  private void setIndex(int featureID, int index)
  {
    while (indices.size() <= featureID)
    {
      indices.add(null);
    }

    indices.set(featureID, index);
  }

  private void readSuperTypes(ExtendedDataInput in) throws IOException
  {
    int size = in.readInt();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Reading {0} super types", size);
    }

    for (int i = 0; i < size; i++)
    {
      CDOClassRef classRef = CDOModelUtil.readClassRef(in, containingPackage.getPackageURI());
      if (PROTOCOL.isEnabled())
      {
        PROTOCOL.format("Read super type: classRef={0}", classRef, classifierID);
      }

      superTypes.add(new CDOClassProxy(classRef, containingPackage.getPackageManager()));
    }
  }

  private void readFeatures(ExtendedDataInput in) throws IOException
  {
    int size = in.readInt();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Reading {0} features", size);
    }

    for (int i = 0; i < size; i++)
    {
      CDOFeature cdoFeature = CDOModelUtil.readFeature(this, in);
      addFeature(cdoFeature);
    }
  }

  private void writeSuperTypes(ExtendedDataOutput out) throws IOException
  {
    int size = superTypes.size();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Writing {0} super types", size);
    }

    out.writeInt(size);
    for (CDOClassProxy proxy : superTypes)
    {
      CDOClassRef classRef = proxy.getClassRef();
      if (PROTOCOL.isEnabled())
      {
        PROTOCOL.format("Writing super type: classRef={0}", classRef);
      }

      CDOModelUtil.writeClassRef(out, classRef, containingPackage.getPackageURI());
    }
  }

  private void writeFeatures(ExtendedDataOutput out) throws IOException
  {
    int size = features.size();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Writing {0} features", size);
    }

    out.writeInt(size);
    for (CDOFeature cdoFeature : features)
    {
      CDOModelUtil.writeFeature(out, cdoFeature);
    }
  }

  private static void addAllFeatures(CDOFeature[] features, List<CDOFeature> result)
  {
    for (CDOFeature feature : features)
    {
      addUnique(feature, result);
    }
  }

  @SuppressWarnings("unchecked")
  private static void addUnique(Object object, List result)
  {
    if (!result.contains(object))
    {
      result.add(object);
    }
  }
}
