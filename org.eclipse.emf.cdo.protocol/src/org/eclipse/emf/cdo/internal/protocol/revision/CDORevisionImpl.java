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
package org.eclipse.emf.cdo.internal.protocol.revision;

import org.eclipse.emf.cdo.internal.protocol.CDOIDImpl;
import org.eclipse.emf.cdo.internal.protocol.bundle.CDOProtocol;
import org.eclipse.emf.cdo.internal.protocol.model.CDOClassImpl;
import org.eclipse.emf.cdo.internal.protocol.model.CDOClassRefImpl;
import org.eclipse.emf.cdo.internal.protocol.model.CDOFeatureImpl;
import org.eclipse.emf.cdo.internal.protocol.model.CDOPackageManagerImpl;
import org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl;
import org.eclipse.emf.cdo.protocol.CDOID;
import org.eclipse.emf.cdo.protocol.model.CDOFeature;
import org.eclipse.emf.cdo.protocol.revision.CDORevision;
import org.eclipse.emf.cdo.protocol.revision.CDORevisionData;

import org.eclipse.net4j.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.stream.ExtendedDataInputStream;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class CDORevisionImpl implements CDORevision, CDORevisionData
{
  public static final ContextTracer TRACER = new ContextTracer(CDOProtocol.DEBUG_REVISION, CDORevisionImpl.class);

  private CDOClassImpl cdoClass;

  private CDOID id;

  private int version;

  private long created;

  private long revised;

  private CDOID resourceID;

  private CDOID containerID;

  private int containingFeatureID;

  private Object[] values;

  public CDORevisionImpl(CDOClassImpl cdoClass, CDOID id)
  {
    this.cdoClass = cdoClass;
    this.id = id;
    version = 0;
    created = UNSPECIFIED_DATE;
    revised = UNSPECIFIED_DATE;
    resourceID = CDOID.NULL;
    containerID = CDOID.NULL;
    containingFeatureID = 0;
    values = new Object[cdoClass.getFeatureCount()];
  }

  public CDORevisionImpl(CDORevisionImpl source)
  {
    cdoClass = source.cdoClass;
    id = source.id;
    version = source.version;
    created = source.created;
    revised = source.revised; // == UNSPECIFIED
    resourceID = source.resourceID;
    containerID = source.containerID;
    containingFeatureID = source.containingFeatureID;
    copyValues(source.values);
  }

  public CDORevisionImpl(ExtendedDataInputStream in) throws IOException
  {
    CDOClassRefImpl classRef = new CDOClassRefImpl(in, null);
    cdoClass = CDOPackageManagerImpl.INSTANCE.resolveClass(classRef);
    id = CDOIDImpl.read(in);
    if (TRACER.isEnabled())
    {
      TRACER.format("Reading revision: ID={0}, classRef={1}, className={2}", id, classRef, cdoClass.getName());
    }

    version = in.readInt();
    created = in.readLong();
    revised = in.readLong();
    resourceID = CDOIDImpl.read(in);
    containerID = CDOIDImpl.read(in);
    containingFeatureID = in.readInt();
    readValues(in);
  }

  public void write(ExtendedDataOutputStream out) throws IOException
  {
    CDOClassRefImpl classRef = cdoClass.createClassRef();
    if (TRACER.isEnabled())
    {
      TRACER.format("Writing revision: ID={0}, classRef={1}, className={2}", id, classRef, cdoClass.getName());
    }

    classRef.write(out, null);
    CDOIDImpl.write(out, id);
    out.writeInt(version);
    out.writeLong(created);
    out.writeLong(revised);
    CDOIDImpl.write(out, resourceID);
    CDOIDImpl.write(out, containerID);
    out.writeInt(containingFeatureID);
    writeValues(out);
  }

  public CDOClassImpl getCDOClass()
  {
    return cdoClass;
  }

  public CDOID getID()
  {
    return id;
  }

  public void setID(CDOID id)
  {
    if (TRACER.isEnabled())
    {
      TRACER.format("Setting ID: {0}", id);
    }

    this.id = id;
  }

  public int getVersion()
  {
    return version;
  }

  public void setVersion(int version)
  {
    if (TRACER.isEnabled())
    {
      TRACER.format("Setting version: {0}", version);
    }

    this.version = version;
  }

  public int increaseVersion()
  {
    if (TRACER.isEnabled())
    {
      TRACER.format("Increasing version: {0}", version + 1);
    }

    return ++version;
  }

  public long getCreated()
  {
    return created;
  }

  public void setCreated(long created)
  {
    if (TRACER.isEnabled())
    {
      TRACER.format("Setting created: {0,date} {0,time}", created);
    }

    this.created = created;
  }

  public long getRevised()
  {
    return revised;
  }

  public void setRevised(long revised)
  {
    if (TRACER.isEnabled())
    {
      TRACER.format("Setting revised: {0,date} {0,time}", revised);
    }

    this.revised = revised;
  }

  public boolean isActual()
  {
    return revised == UNSPECIFIED_DATE;
  }

  public boolean isValid(long timeStamp)
  {
    return created <= timeStamp && revised == UNSPECIFIED_DATE;
  }

  public boolean isResource()
  {
    return cdoClass.isResource();
  }

  public CDORevisionData getData()
  {
    return this;
  }

  public CDORevisionDeltaImpl createDelta(CDORevision origin)
  {
    return new CDORevisionDeltaImpl((CDORevisionImpl)origin, this);
  }

  public CDOID getResourceID()
  {
    return resourceID;
  }

  public void setResourceID(CDOID resourceID)
  {
    if (TRACER.isEnabled())
    {
      TRACER.format("Setting resourceID: {0}", resourceID);
    }

    this.resourceID = resourceID;
  }

  public CDOID getContainerID()
  {
    return containerID;
  }

  public void setContainerID(CDOID containerID)
  {
    if (TRACER.isEnabled())
    {
      TRACER.format("Setting containerID: {0}", containerID);
    }

    this.containerID = containerID;
  }

  public int getContainingFeatureID()
  {
    return containingFeatureID;
  }

  public void setContainingFeature(int containingFeatureID)
  {
    if (TRACER.isEnabled())
    {
      TRACER.format("Setting containingFeatureID: {0}", containingFeatureID);
    }

    this.containingFeatureID = containingFeatureID;
  }

  public Object get(CDOFeature feature, int index)
  {
    if (feature.isMany())
    {
      return getList(feature).get(index);
    }

    return getValue(feature);
  }

  public boolean contains(CDOFeature feature, Object value)
  {
    return getList(feature).contains(value);
  }

  public int hashCode(CDOFeature feature)
  {
    return getList(feature).hashCode();
  }

  public int indexOf(CDOFeature feature, Object value)
  {
    return getList(feature).indexOf(value);
  }

  public boolean isEmpty(CDOFeature feature)
  {
    return getList(feature).isEmpty();
  }

  public boolean isSet(CDOFeature feature)
  {
    return getValue(feature) != null;
  }

  public int lastIndexOf(CDOFeature feature, Object value)
  {
    return getList(feature).lastIndexOf(value);
  }

  public int size(CDOFeature feature)
  {
    return getList(feature).size();
  }

  public Object[] toArray(CDOFeature feature)
  {
    if (!feature.isMany())
    {
      throw new IllegalStateException("!feature.isMany()");
    }

    return getList(feature).toArray();
  }

  public <T> T[] toArray(CDOFeature feature, T[] array)
  {
    if (!feature.isMany())
    {
      throw new IllegalStateException("!feature.isMany()");
    }

    return getList(feature).toArray(array);
  }

  public void add(CDOFeature feature, int index, Object value)
  {
    getList(feature).add(index, value);
  }

  public void clear(CDOFeature feature)
  {
    setValue(feature, null);
  }

  public Object move(CDOFeature feature, int targetIndex, int sourceIndex)
  {
    return getList(feature).move(targetIndex, sourceIndex);
  }

  public Object remove(CDOFeature feature, int index)
  {
    return getList(feature).remove(index);
  }

  public Object set(CDOFeature feature, int index, Object value)
  {
    if (feature.isMany())
    {
      return getList(feature).set(index, value);
    }

    return setValue(feature, value);
  }

  public void unset(CDOFeature feature)
  {
    setValue(feature, null);
  }

  public void adjustReferences(Map<CDOID, CDOID> idMappings)
  {
    if (TRACER.isEnabled())
    {
      TRACER.format("Adjusting references for revision {0}", this);
    }

    resourceID = (CDOID)remapID(resourceID, idMappings);
    containerID = (CDOID)remapID(containerID, idMappings);

    CDOFeatureImpl[] features = cdoClass.getFeatures();
    for (int i = 0; i < features.length; i++)
    {
      CDOFeatureImpl feature = features[i];
      if (feature.isReference())
      {
        if (feature.isMany())
        {
          List list = (List)values[i];
          for (int j = 0; j < list.size(); j++)
          {
            Object oldID = list.get(j);
            Object newID = remapID(oldID, idMappings);
            if (newID != oldID)
            {
              list.set(j, newID);
            }
          }
        }
        else
        {
          values[i] = remapID(values[i], idMappings);
        }
      }
    }
  }

  @Override
  public String toString()
  {
    return cdoClass.getName() + "@" + id + "v" + version;
  }

  public Object getValue(CDOFeature feature)
  {
    return values[feature.getFeatureIndex()];
  }

  public Object setValue(CDOFeature feature, Object value)
  {
    int i = feature.getFeatureIndex();
    Object old = values[i];
    values[i] = value;
    return old;
  }

  public MoveableList getList(CDOFeature feature)
  {
    int i = feature.getFeatureIndex();
    MoveableList result = (MoveableList)values[i];
    if (result == null)
    {
      result = new MoveableList(0);
      values[i] = result;
    }

    return result;
  }

  private void copyValues(Object[] sourceValues)
  {
    values = new Object[cdoClass.getFeatureCount()];
    CDOFeatureImpl[] features = cdoClass.getFeatures();
    for (int i = 0; i < features.length; i++)
    {
      CDOFeatureImpl feature = features[i];
      CDOTypeImpl type = feature.getType();
      if (feature.isMany())
      {
        MoveableList sourceList = (MoveableList)sourceValues[i];
        int size = sourceList.size();
        List list = new MoveableList(size);
        for (int j = 0; j < size; j++)
        {
          list.add(type.copyValue(sourceList.get(j)));
        }

        values[i] = list;
      }
      else
      {
        values[i] = type.copyValue(sourceValues[i]);
      }
    }
  }

  private void readValues(ExtendedDataInputStream in) throws IOException
  {
    values = new Object[cdoClass.getFeatureCount()];
    CDOFeatureImpl[] features = cdoClass.getFeatures();
    for (int i = 0; i < features.length; i++)
    {
      CDOFeatureImpl feature = features[i];
      CDOTypeImpl type = feature.getType();
      if (feature.isMany())
      {
        int size = in.readInt();
        List list = new MoveableList(size);
        for (int j = 0; j < size; j++)
        {
          list.add(type.readValue(in));
        }

        values[i] = list;
      }
      else
      {
        values[i] = type.readValue(in);
      }
    }
  }

  private void writeValues(ExtendedDataOutputStream out) throws IOException
  {
    CDOFeatureImpl[] features = cdoClass.getFeatures();
    for (int i = 0; i < features.length; i++)
    {
      CDOFeatureImpl feature = features[i];
      if (feature.isMany())
      {
        List list = (List)values[i];
        out.writeInt(list.size());
        for (Object value : list)
        {
          feature.getType().writeValue(out, value);
        }
      }
      else
      {
        Object value = values[i];
        System.out.println(feature);
        feature.getType().writeValue(out, value);
      }
    }
  }

  private static Object remapID(Object value, Map<CDOID, CDOID> idMappings)
  {
    if (value instanceof CDOID)
    {
      CDOID oldID = (CDOID)value;
      if (oldID.isTemporary())
      {
        CDOID newID = idMappings.get(oldID);
        if (newID != null)
        {
          if (TRACER.isEnabled())
          {
            TRACER.format("Adjusting ID: {0} --> {1}", oldID, newID);
          }

          return newID;
        }
      }
    }

    return value;
  }

  private static final class MoveableList extends ArrayList<Object>
  {
    private static final long serialVersionUID = 1L;

    public MoveableList(int initialCapacity)
    {
      super(initialCapacity);

    }

    public Object move(int targetIndex, int sourceIndex)
    {
      int size = size();
      if (sourceIndex >= size)
      {
        throw new IndexOutOfBoundsException("sourceIndex=" + sourceIndex + ", size=" + size);
      }

      if (targetIndex >= size)
      {
        throw new IndexOutOfBoundsException("targetIndex=" + targetIndex + ", size=" + size);
      }

      Object object = get(sourceIndex);
      if (targetIndex == sourceIndex)
      {
        return object;
      }

      if (targetIndex < sourceIndex)
      {
        moveDown(targetIndex, targetIndex + 1, sourceIndex - targetIndex);
      }
      else
      {
        moveUp(sourceIndex + 1, sourceIndex, targetIndex - sourceIndex);
      }

      set(targetIndex, object);
      return object;
    }

    private void moveDown(int sourceIndex, int targetIndex, int count)
    {
      for (int i = 0; i < count; i++)
      {
        set(targetIndex + i, get(sourceIndex + i));
      }
    }

    private void moveUp(int sourceIndex, int targetIndex, int count)
    {
      for (int i = count - 1; i >= 0; i--)
      {
        set(targetIndex + i, get(sourceIndex + i));
      }
    }
  }
}
