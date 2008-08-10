/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany, and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Martin Taal - added hibernate specifics
 **************************************************************************/
package org.eclipse.emf.cdo.server.hibernate.internal.id;

import org.eclipse.emf.cdo.common.id.CDOIDObject;
import org.eclipse.emf.cdo.common.model.CDOClassRef;
import org.eclipse.emf.cdo.server.hibernate.id.CDOIDHibernate;
import org.eclipse.emf.cdo.spi.common.AbstractCDOID;

import org.eclipse.net4j.util.ObjectUtil;
import org.eclipse.net4j.util.io.ExtendedDataInput;
import org.eclipse.net4j.util.io.ExtendedDataOutput;
import org.eclipse.net4j.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.om.trace.OMTracer;

import java.io.IOException;
import java.io.Serializable;
import java.text.MessageFormat;

/**
 * @author Eike Stepper
 * @author Martin Taal
 */
public class CDOIDHibernateImpl extends AbstractCDOID implements CDOIDHibernate
{
  // TODO: make this more dynamic
  public static final int HB_ID_TYPE_SERIALIZABLE = 0;

  public static final int HB_ID_TYPE_LONG = 1;

  public static final int HB_ID_TYPE_STRING = 2;

  private ContextTracer tracer;

  private static final long serialVersionUID = 1L;

  private Serializable id;

  private String entityName;

  public CDOIDHibernateImpl()
  {
  }

  public OMTracer getTracer()
  {
    return tracer.getDelegate();
  }

  public void setTracer(OMTracer tracer)
  {
    this.tracer = new ContextTracer(tracer, CDOIDHibernateImpl.class);
  }

  protected int getIDType()
  {
    return HB_ID_TYPE_SERIALIZABLE;
  }

  /**
   * @return the id
   */
  public Serializable getId()
  {
    return id;
  }

  /**
   * @param id
   *          the id to set
   */
  public void setId(Serializable id)
  {
    this.id = id;
  }

  /**
   * @return the entityName
   */
  public String getEntityName()
  {
    return entityName;
  }

  /**
   * @param entityName
   *          the entityName to set
   */
  public void setEntityName(String entityName)
  {
    this.entityName = entityName;
  }

  public Type getType()
  {
    return Type.OBJECT;
  }

  public CDOClassRef getClassRef()
  {
    return null;
  }

  public CDOIDObject asLegacy(CDOClassRef classRef)
  {
    return new Legacy(classRef);
  }

  public String asString()
  {
    // TODO: implement CDOIDHibernateImpl.asString()
    throw new UnsupportedOperationException();
  }

  @Override
  public void read(String fragmentPart)
  {
    // TODO: implement CDOIDHibernateImpl.read(fragmentPart)
    throw new UnsupportedOperationException();
  }

  @Override
  public void read(ExtendedDataInput in) throws IOException
  {
    // the idtype is read by the id factory!

    readId(in);
    if (tracer != null && tracer.isEnabled())
    {
      tracer.format("Read id={0}", id);
    }

    entityName = in.readString();
    if (tracer != null && tracer.isEnabled())
    {
      tracer.format("Read entityName={0}", entityName);
    }
  }

  @Override
  public void write(ExtendedDataOutput out) throws IOException
  {
    if (tracer != null && tracer.isEnabled())
    {
      tracer.format("Writing id type={0}", getIDType());
    }

    out.writeInt(getIDType());
    if (tracer != null && tracer.isEnabled())
    {
      tracer.format("Writing id={0}", id);
    }

    writeId(out);
    if (tracer != null && tracer.isEnabled())
    {
      tracer.format("Writing entityName={0}", entityName);
    }

    out.writeString(entityName);
  }

  protected void readId(ExtendedDataInput in) throws IOException
  {
    id = (Serializable)in.readObject();
  }

  protected void writeId(ExtendedDataOutput out) throws IOException
  {
    out.writeObject(id);
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
    {
      return true;
    }

    if (obj instanceof CDOIDHibernate)
    {
      return ObjectUtil.equals(id, ((CDOIDHibernate)obj).getId())
          && ObjectUtil.equals(entityName, ((CDOIDHibernate)obj).getEntityName());
    }

    return false;
  }

  @Override
  public int hashCode()
  {
    return id.hashCode() + entityName.hashCode();
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("HBM-{0}-{1}", entityName, id);
  }

  /**
   * @author Eike Stepper
   */
  public static final class Legacy extends CDOIDHibernateImpl
  {
    private static final long serialVersionUID = 1L;

    private CDOClassRef classRef;

    public Legacy()
    {
    }

    public Legacy(CDOClassRef classRef)
    {
      if (classRef == null)
      {
        throw new IllegalArgumentException("classRef == null");
      }

      this.classRef = classRef;
    }

    @Override
    public Type getType()
    {
      return Type.LEGACY_OBJECT;
    }

    @Override
    public CDOClassRef getClassRef()
    {
      return classRef;
    }

    public void setClassRef(CDOClassRef classRef)
    {
      this.classRef = classRef;
    }

    @Override
    public Legacy asLegacy(CDOClassRef classRef)
    {
      return this;
    }

    @Override
    public String toString()
    {
      return super.toString() + "(" + classRef + ")";
    }
  }
}
