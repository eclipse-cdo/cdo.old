/***************************************************************************
 * Copyright (c) 2004 - 2007 Eike Stepper, Germany.
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
import org.eclipse.emf.cdo.internal.protocol.bundle.OM;
import org.eclipse.emf.cdo.internal.protocol.model.CDOClassImpl;
import org.eclipse.emf.cdo.internal.protocol.model.CDOClassRefImpl;
import org.eclipse.emf.cdo.internal.protocol.model.CDOFeatureImpl;
import org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl;
import org.eclipse.emf.cdo.protocol.CDOID;
import org.eclipse.emf.cdo.protocol.model.CDOFeature;
import org.eclipse.emf.cdo.protocol.model.CDOPackageManager;
import org.eclipse.emf.cdo.protocol.revision.CDOReferenceProxy;
import org.eclipse.emf.cdo.protocol.revision.CDORevision;
import org.eclipse.emf.cdo.protocol.revision.CDORevisionData;
import org.eclipse.emf.cdo.protocol.revision.CDORevisionResolver;

import org.eclipse.net4j.internal.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.ImplementationError;
import org.eclipse.net4j.util.io.ExtendedDataInput;
import org.eclipse.net4j.util.io.ExtendedDataOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class CDORevisionImpl implements CDORevision, CDORevisionData
{
  public static final Object UNINITIALIZED = new Uninitialized();

  private static final ContextTracer TRACER = new ContextTracer(OM.DEBUG_REVISION, CDORevisionImpl.class);

  private CDORevisionResolver revisionResolver;

  private CDOClassImpl cdoClass;

  private CDOID id;

  private int version;

  private long created;

  private long revised;

  private CDOID resourceID;

  private CDOID containerID;

  private int containingFeatureID;

  private Object[] values;

  public CDORevisionImpl(CDORevisionResolver revisionResolver, CDOClassImpl cdoClass, CDOID id)
  {
    this.revisionResolver = revisionResolver;
    this.cdoClass = cdoClass;
    this.id = id;
    version = 0;
    created = UNSPECIFIED_DATE;
    revised = UNSPECIFIED_DATE;
    resourceID = CDOID.NULL;
    containerID = CDOID.NULL;
    containingFeatureID = 0;
    values = new Object[cdoClass.getAllFeatures().length];
  }

  public CDORevisionImpl(CDORevisionImpl source)
  {
    revisionResolver = source.revisionResolver;
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

  public CDORevisionImpl(ExtendedDataInput in, CDORevisionResolver revisionResolver, CDOPackageManager packageManager)
      throws IOException
  {
    this.revisionResolver = revisionResolver;

    CDOClassRefImpl classRef = new CDOClassRefImpl(in, null);
    cdoClass = classRef.resolve(packageManager);
    if (cdoClass == null)
    {
      throw new ImplementationError("ClassRef unresolveable: " + classRef);
    }

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

  public void write(ExtendedDataOutput out, CDOIDProvider idProvider, int referenceChunk) throws IOException
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
    writeValues(out, idProvider, referenceChunk);
  }

  public CDORevisionResolver getRevisionResolver()
  {
    return revisionResolver;
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
      TRACER.format("Setting revised: {0} -> {1,date} {1,time}", this, revised);
    }

    this.revised = revised;
  }

  public boolean isCurrent()
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

  public int hashCode(CDOFeature feature)
  {
    return getValue(feature).hashCode();
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

    CDOFeatureImpl[] features = cdoClass.getAllFeatures();
    for (int i = 0; i < features.length; i++)
    {
      CDOFeatureImpl feature = features[i];
      if (feature.isReference())
      {
        if (feature.isMany())
        {
          List<Object> list = (List<Object>)values[i];
          int size = list == null ? 0 : list.size();
          for (int j = 0; j < size; j++)
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
    return getList(feature, 0);
  }

  public MoveableList getList(CDOFeature feature, int size)
  {
    int i = feature.getFeatureIndex();
    MoveableList list = (MoveableList)values[i];
    if (list == null)
    {
      list = new MoveableList(size);
      values[i] = list;
    }

    return list;
  }

  public void setListSize(CDOFeature feature, int size)
  {
    MoveableList list = getList(feature, size);
    for (int j = list.size(); j < size; j++)
    {
      list.add(UNINITIALIZED);
    }
  }

  private void copyValues(Object[] sourceValues)
  {
    CDOFeatureImpl[] features = cdoClass.getAllFeatures();
    values = new Object[features.length];
    for (int i = 0; i < features.length; i++)
    {
      CDOFeatureImpl feature = features[i];
      CDOTypeImpl type = feature.getType();
      if (feature.isMany())
      {
        MoveableList sourceList = (MoveableList)sourceValues[i];
        if (sourceList != null)
        {
          int size = sourceList.size();
          List<Object> list = new MoveableList(size);
          for (int j = 0; j < size; j++)
          {
            Object value = sourceList.get(j);
            if (value instanceof CDOReferenceProxy)
            {
              list.add(new CDOReferenceProxyImpl(this, feature, ((CDOReferenceProxy)value).getIndex()));
            }
            else
            {
              list.add(type.copyValue(value));
            }
          }

          values[i] = list;
        }
      }
      else
      {
        values[i] = type.copyValue(sourceValues[i]);
      }
    }
  }

  private void readValues(ExtendedDataInput in) throws IOException
  {
    CDOFeatureImpl[] features = cdoClass.getAllFeatures();
    values = new Object[features.length];
    for (int i = 0; i < features.length; i++)
    {
      CDOFeatureImpl feature = features[i];
      CDOTypeImpl type = feature.getType();
      if (feature.isMany())
      {
        int referenceChunk;
        int size = in.readInt();
        if (size < 0)
        {
          size = -size;
          referenceChunk = in.readInt();
          if (TRACER.isEnabled())
          {
            TRACER.format("Read feature {0}: size={1}, referenceChunk={2}", feature, size, referenceChunk);
          }
        }
        else
        {
          referenceChunk = size;
          if (TRACER.isEnabled()) TRACER.format("Read feature {0}: size={1}", feature, size);
        }

        if (size != 0)
        {
          CDORevisionImpl baseRevision = null;
          List<Object> list = new MoveableList(size);
          int ranges = in.readInt();
          if (ranges != 0)
          {
            // This happens only on server side
            while (ranges-- > 0)
            {
              int range = in.readInt();
              if (range > 0)
              {
                while (range-- > 0)
                {
                  Object value = type.readValue(in);
                  list.add(value);
                  if (TRACER.isEnabled()) TRACER.trace("    " + value);
                }
              }
              else
              {
                if (baseRevision == null)
                {
                  baseRevision = (CDORevisionImpl)revisionResolver.getRevisionByVersion(id, CDORevision.UNCHUNKED,
                      version - 1);
                }

                MoveableList baseList = baseRevision.getList(feature);
                int index = in.readInt();
                while (range++ < 0)
                {
                  Object value = baseList.get(index++);
                  list.add(value);
                  if (TRACER.isEnabled()) TRACER.trace("    " + value);
                }
              }
            }
          }
          else
          {
            for (int j = 0; j < referenceChunk; j++)
            {
              Object value = type.readValue(in);
              list.add(value);
              if (TRACER.isEnabled()) TRACER.trace("    " + value);
            }

            for (int j = referenceChunk; j < size; j++)
            {
              list.add(new CDOReferenceProxyImpl(this, feature, j));
            }

            values[i] = list;
          }
        }
      }
      else
      {
        values[i] = type.readValue(in);
        if (TRACER.isEnabled()) TRACER.format("Read feature {0}: {1}", feature, values[i]);
      }
    }
  }

  private void writeValues(ExtendedDataOutput out, CDOIDProvider idProvider, int referenceChunk) throws IOException
  {
    CDOFeatureImpl[] features = cdoClass.getAllFeatures();
    for (int i = 0; i < features.length; i++)
    {
      CDOFeatureImpl feature = features[i];
      if (feature.isMany())
      {
        List<Object> list = (List<Object>)values[i];
        int size = list == null ? 0 : list.size();
        if (referenceChunk != CDORevision.UNCHUNKED && referenceChunk < size)
        {
          // This happens only on server-side
          if (TRACER.isEnabled())
          {
            TRACER.format("Writing feature {0}: size={1}, referenceChunk={2}", feature, size, referenceChunk);
          }

          out.writeInt(-size);
          out.writeInt(referenceChunk);
          size = referenceChunk;
        }
        else
        {
          if (TRACER.isEnabled()) TRACER.format("Writing feature {0}: size={1}", feature, size);
          out.writeInt(size);
        }

        if (size != 0)
        {
          List<Integer> ranges = revisionResolver.analyzeReferenceRanges(list);
          if (ranges != null)
          {
            // This happens only on client-side
            out.writeInt(ranges.size());
            int j = 0;
            for (int range : ranges)
            {
              out.writeInt(range);
              if (range > 0)
              {
                // This is an id range
                while (range-- > 0)
                {
                  Object value = list.get(j);
                  if (value != null && feature.isReference())
                  {
                    value = idProvider.provideCDOID(value);
                    list.set(j, value);
                  }

                  if (TRACER.isEnabled()) TRACER.trace("    " + value);
                  feature.getType().writeValue(out, value);
                  ++j;
                }
              }
              else
              {
                // This is a proxy range
                CDOReferenceProxy proxy = (CDOReferenceProxy)list.get(j);
                out.writeInt(proxy.getIndex());
                j -= range; // Increase j to next range start
              }
            }
          }
          else
          {
            out.writeInt(0); // No ranges -> no ref proxies
            for (int j = 0; j < size; j++)
            {
              Object value = list.get(j);
              if (value != null && feature.isReference())
              {
                value = idProvider.provideCDOID(value);
                list.set(j, value);
              }

              if (TRACER.isEnabled()) TRACER.trace("    " + value);
              feature.getType().writeValue(out, value);
            }
          }
        }
      }
      else
      {
        if (values[i] != null && feature.isReference())
        {
          values[i] = idProvider.provideCDOID(values[i]);
        }

        if (TRACER.isEnabled()) TRACER.format("Writing feature {0}: {1}", feature, values[i]);
        feature.getType().writeValue(out, values[i]);
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
        if (newID == null)
        {
          throw new ImplementationError("Missing mapping for " + oldID);
        }

        if (TRACER.isEnabled())
        {
          TRACER.format("Adjusting ID: {0} --> {1}", oldID, newID);
        }

        return newID;
      }
    }

    return value;
  }

  /**
   * @author Eike Stepper
   */
  private static final class Uninitialized
  {
    public Uninitialized()
    {
    }

    @Override
    public String toString()
    {
      return "UNINITIALIZED";
    }
  }

  /**
   * A list with O(1) effort for random access.
   * 
   * @author Eike Stepper
   */
  public static final class MoveableList extends ArrayList<Object>
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
