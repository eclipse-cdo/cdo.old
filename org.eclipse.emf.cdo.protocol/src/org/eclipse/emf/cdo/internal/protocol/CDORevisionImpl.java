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
import org.eclipse.emf.cdo.protocol.CDOClassID;
import org.eclipse.emf.cdo.protocol.CDOFeature;
import org.eclipse.emf.cdo.protocol.CDOID;
import org.eclipse.emf.cdo.protocol.CDORevision;
import org.eclipse.emf.cdo.protocol.CDORevisionData;

import org.eclipse.net4j.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.stream.ExtendedDataInputStream;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Eike Stepper
 */
public class CDORevisionImpl implements CDORevision, CDORevisionData
{
  private static final ContextTracer TRACER = new ContextTracer(CDOProtocol.DEBUG_REVISION,
      CDORevisionImpl.class);

  private CDOClassImpl cdoClass;

  private CDOID id;

  private int version;

  private long created;

  private long revised;

  private CDOID containerID;

  private int containingFeatureID;

  private Object[] settings;

  public CDORevisionImpl(CDOClassImpl cdoClass, CDOID id)
  {
    this.cdoClass = cdoClass;
    this.id = id;
    version = 0;
    created = UNSPECIFIED_DATE;
    revised = UNSPECIFIED_DATE;
    containerID = CDOID.NULL;
    containingFeatureID = 0;
    settings = new Object[cdoClass.getFeatureCount()];
  }

  public CDORevisionImpl(CDORevisionImpl source)
  {
    cdoClass = source.cdoClass;
    id = CDOIDImpl.copy(source.id);
    version = source.version + 1;
    created = source.created;
    revised = source.revised; // == UNSPECIFIED
    containerID = source.containerID;
    containingFeatureID = source.containingFeatureID;
    settings = cloneSettings();
  }

  public CDORevisionImpl(CDOModelResolverImpl modelResolver, ExtendedDataInputStream in)
      throws IOException
  {
    CDOClassID classID = new CDOClassID(in);
    cdoClass = modelResolver.getCDOClass(classID);
    id = CDOIDImpl.read(in);
    if (TRACER.isEnabled())
    {
      TRACER.format("Reading revision: class={0}, id={1}", cdoClass, id);
    }

    version = in.readInt();
    created = in.readLong();
    revised = in.readLong();
    containerID = CDOIDImpl.read(in);
    containingFeatureID = in.readInt();

    // TODO Implement method RevisionImpl.RevisionImpl()
    throw new UnsupportedOperationException("Not yet implemented");
  }

  public void write(ExtendedDataOutputStream out) throws IOException
  {
    CDOClassID classID = cdoClass.getClassID();
    if (TRACER.isEnabled())
    {
      TRACER.format("Writing revision: ID={0}, classID={1}, className={2}", id, classID, cdoClass
          .getName());
    }

    classID.write(out);
    id.write(out);
    out.writeInt(version);
    out.writeLong(created);
    out.writeLong(revised);
    containerID.write(out);
    out.writeInt(containingFeatureID);

    CDOFeatureImpl[] features = cdoClass.getCDOFeatures();
    for (int i = 0; i < features.length; i++)
    {
      features[i].write(out, settings[i]);
    }
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
      TRACER.format("Changing id {0} -> {1}", this.id, id);
    }

    this.id = id;
  }

  public int getVersion()
  {
    return version;
  }

  public void setVersion(int version)
  {
    this.version = version;
  }

  public long getCreated()
  {
    return created;
  }

  public void setCreated(long created)
  {
    this.created = created;
  }

  public long getRevised()
  {
    return revised;
  }

  public void setRevised(long revised)
  {
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

  public CDORevisionData getData()
  {
    return this;
  }

  public CDOID getContainerID()
  {
    return containerID;
  }

  public void setContainerID(CDOID containerID)
  {
    this.containerID = containerID;
  }

  public int getContainingFeatureID()
  {
    return containingFeatureID;
  }

  public void setContainingFeature(int containingFeatureID)
  {
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
    // TODO Implement method CDORevisionImpl.toArray()
    throw new UnsupportedOperationException("Not yet implemented");
  }

  public <T> T[] toArray(CDOFeature feature, T[] array)
  {
    // TODO Implement method CDORevisionImpl.toArray()
    throw new UnsupportedOperationException("Not yet implemented");
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

  public Object[] cloneSettings()
  {
    // TODO Implement method CDORevisionImpl.cloneSettings()
    throw new UnsupportedOperationException("Not yet implemented");

    // CDOFeature[] features = cdoClass.getCDOFeatures();
    // Object[] result = new Object[features.length];
    // for (int i = 0; i < features.length; i++)
    // {
    // CDOFeature feature = features[i];
    // Object setting = settings[i];
    // if (feature.isReference())
    // {
    // result[i] = RevisionUtil.cloneReference((EReference)feature, setting);
    // }
    // else
    // {
    // result[i] = RevisionUtil.cloneAttribute((EAttribute)feature, setting);
    // }
    // }
    //
    // return result;
  }

  @Override
  public String toString()
  {
    return cdoClass.getName() + "@" + id + "v" + version;
  }

  private Object getValue(CDOFeature feature)
  {
    return settings[feature.getID()];
  }

  private Object setValue(CDOFeature feature, Object value)
  {
    int i = feature.getID();
    Object old = settings[i];
    settings[i] = value;
    return old;
  }

  private RList getList(CDOFeature feature)
  {
    int i = feature.getID();
    RList result = (RList)settings[i];
    if (result == null)
    {
      result = new RList();
      settings[i] = result;
    }

    return result;
  }

  private static final class RList extends ArrayList<Object>
  {
    private static final long serialVersionUID = 1L;

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
