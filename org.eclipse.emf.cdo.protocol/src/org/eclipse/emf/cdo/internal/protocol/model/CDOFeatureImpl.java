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
import org.eclipse.emf.cdo.protocol.model.CDOFeature;

import org.eclipse.net4j.internal.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * @author Eike Stepper
 */
public class CDOFeatureImpl extends CDOModelElementImpl implements CDOFeature
{
  @SuppressWarnings("unused")
  private static final ContextTracer MODEL = new ContextTracer(OM.DEBUG_MODEL, CDOFeatureImpl.class);

  private static final ContextTracer PROTOCOL = new ContextTracer(OM.DEBUG_PROTOCOL, CDOFeatureImpl.class);

  private CDOClassImpl containingClass;

  private int featureID;

  private int featureIndex;

  private CDOTypeImpl type;

  private boolean many;

  private boolean containment;

  private CDOClassProxy referenceType;

  public CDOFeatureImpl(CDOClassImpl containingClass, int featureID, String name, CDOTypeImpl type, boolean many)
  {
    super(name);
    if (type == CDOTypeImpl.OBJECT)
    {
      throw new IllegalArgumentException("type == OBJECT");
    }

    this.containingClass = containingClass;
    this.featureID = featureID;
    this.type = type;
    this.many = many;
    if (MODEL.isEnabled())
    {
      MODEL.format("Created {0}", this);
    }
  }

  public CDOFeatureImpl(CDOClassImpl containingClass, int featureID, String name, CDOClassProxy referenceType,
      boolean many, boolean containment)
  {
    super(name);
    if (referenceType == null)
    {
      throw new IllegalArgumentException("referenceType == null");
    }

    this.containingClass = containingClass;
    this.featureID = featureID;
    this.type = CDOTypeImpl.OBJECT;
    this.many = many;
    this.containment = containment;
    this.referenceType = referenceType;
    if (MODEL.isEnabled())
    {
      MODEL.format("Created {0}", this);
    }
  }

  public CDOFeatureImpl(CDOClassImpl containingClass, ExtendedDataInputStream in) throws IOException
  {
    this.containingClass = containingClass;
    read(in);
  }

  @Override
  public void read(ExtendedDataInputStream in) throws IOException
  {
    super.read(in);
    featureID = in.readInt();
    type = CDOTypeImpl.read(in);
    many = in.readBoolean();
    containment = in.readBoolean();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Read feature: ID={0}, name={1}, type={2}, many={3}, containment={4}", featureID, getName(),
          type, many, containment);
    }

    if (isReference())
    {
      String defaultURI = containingClass.getContainingPackage().getPackageURI();
      CDOClassRefImpl classRef = new CDOClassRefImpl(in, defaultURI);
      if (PROTOCOL.isEnabled())
      {
        PROTOCOL.format("Read reference type: classRef={0}", classRef);
      }

      referenceType = new CDOClassProxy(classRef, containingClass.getContainingPackage().getPackageManager());
    }
  }

  @Override
  public void write(ExtendedDataOutputStream out) throws IOException
  {
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Writing feature: ID={0}, name={1}, type={2}, many={3}, containment={4}", featureID, getName(),
          type, many, containment);
    }

    super.write(out);
    out.writeInt(featureID);
    type.write(out);
    out.writeBoolean(many);
    out.writeBoolean(containment);

    if (isReference())
    {
      if (referenceType == null)
      {
        System.out.println(type);
      }

      CDOClassRefImpl classRef = referenceType.getCDOClassRef();
      if (PROTOCOL.isEnabled())
      {
        PROTOCOL.format("Writing reference type: classRef={0}", classRef);
      }

      classRef.write(out, getContainingPackage().getPackageURI());
    }
  }

  public CDOPackageManagerImpl getPackageManager()
  {
    return getContainingPackage().getPackageManager();
  }

  public CDOPackageImpl getContainingPackage()
  {
    return containingClass.getContainingPackage();
  }

  public CDOClassImpl getContainingClass()
  {
    return containingClass;
  }

  public int getFeatureID()
  {
    return featureID;
  }

  public int getFeatureIndex()
  {
    return featureIndex;
  }

  public CDOTypeImpl getType()
  {
    return type;
  }

  public boolean isMany()
  {
    return many;
  }

  public boolean isReference()
  {
    return type == CDOTypeImpl.OBJECT;
  }

  public boolean isContainment()
  {
    return containment;
  }

  /**
   * TODO Never called
   */
  public CDOClassImpl getReferenceType()
  {
    if (isReference())
    {
      return referenceType.getCDOClass();
    }

    return null;
  }

  public void setFeatureIndex(int featureIndex)
  {
    this.featureIndex = featureIndex;
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("CDOFeature(ID={0}, name={1}, type={2})", featureID, getName(), getType());
  }

  @Override
  protected void onInitialize()
  {
  }
}
