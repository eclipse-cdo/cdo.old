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
import org.eclipse.emf.cdo.protocol.model.CDOFeature;
import org.eclipse.emf.cdo.protocol.model.CDOPackage;
import org.eclipse.emf.cdo.protocol.model.CDOTypes;

import org.eclipse.net4j.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.stream.ExtendedDataInputStream;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * @author Eike Stepper
 */
public class CDOFeatureImpl extends CDOModelElementImpl implements CDOFeature
{
  @SuppressWarnings("unused")
  private static final ContextTracer MODEL = new ContextTracer(CDOProtocol.DEBUG_MODEL,
      CDOFeatureImpl.class);

  private static final ContextTracer PROTOCOL = new ContextTracer(CDOProtocol.DEBUG_PROTOCOL,
      CDOFeatureImpl.class);

  private CDOClassImpl containingClass;

  private int featureID;

  private int type;

  private boolean many;

  private boolean containment;

  private Object referenceType;

  public CDOFeatureImpl(int featureID, String name, int type, boolean many, boolean containment)
  {
    super(name);
    this.featureID = featureID;
    this.type = type;
    this.many = many;
    this.containment = containment;
  }

  public CDOFeatureImpl(int featureID, String name, CDOClassImpl referenceType, boolean many,
      boolean containment)
  {
    this(featureID, name, many, containment, referenceType, false);
  }

  public CDOFeatureImpl(int featureID, String name, CDOClassRefImpl referenceType, boolean many,
      boolean containment)
  {
    this(featureID, name, many, containment, referenceType, true);
  }

  private CDOFeatureImpl(int featureID, String name, boolean many, boolean containment,
      Object referenceType, boolean resolved)
  {
    super(name);
    this.featureID = featureID;
    this.type = CDOTypes.OBJECT;
    this.many = many;
    this.containment = containment;
    this.referenceType = referenceType;
  }

  public CDOFeatureImpl(ExtendedDataInputStream in) throws IOException
  {
    super(in);
    featureID = in.readInt();
    type = in.readInt();
    many = in.readBoolean();
    containment = in.readBoolean();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Read feature: ID={0}, name={1}, type={2}, many={3}, containment={4}",
          featureID, getName(), type, many, containment);
    }

    CDOClassRefImpl classRef = null;
    if (isReference())
    {
      String defaultURI = containingClass.getContainingPackage().getPackageURI();
      classRef = new CDOClassRefImpl(in, defaultURI);
      if (PROTOCOL.isEnabled())
      {
        PROTOCOL.format("Read reference type: classRef={0}", classRef);
      }
    }
  }

  public void write(ExtendedDataOutputStream out) throws IOException
  {
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Writing feature: ID={0}, name={1}, type={2}, many={3}, containment={4}",
          featureID, getName(), type, many, containment);
    }

    super.write(out);
    out.writeInt(featureID);
    out.writeInt(type);
    out.writeBoolean(many);
    out.writeBoolean(containment);

    if (isReference())
    {
      CDOClassRefImpl classRef = getReferenceTypeClassRef();
      if (PROTOCOL.isEnabled())
      {
        PROTOCOL.format("Writing reference type: classRef={0}", classRef);
      }

      classRef.write(out, getContainingPackage().getPackageURI());
    }
  }

  private CDOClassRefImpl getReferenceTypeClassRef()
  {
    if (referenceType instanceof CDOClassRefImpl)
    {
      return (CDOClassRefImpl)referenceType;
    }

    return ((CDOClassImpl)referenceType).createClassRef();
  }

  public CDOClassImpl getContainingClass()
  {
    return containingClass;
  }

  public int getFeatureID()
  {
    return featureID;
  }

  public int getType()
  {
    return type;
  }

  public boolean isMany()
  {
    return many;
  }

  public boolean isReference()
  {
    return type == CDOTypes.OBJECT;
  }

  public boolean isContainment()
  {
    return containment;
  }

  public CDOClassImpl getReferenceType()
  {
    if (isReference())
    {
      if (referenceType instanceof CDOClassImpl)
      {
        return (CDOClassImpl)referenceType;
      }

      throw new IllegalStateException("Feature definition not initialized: " + this);
    }

    return null;
  }

  public void initialize()
  {
    if (isReference())
    {
      if (referenceType instanceof CDOClassRefImpl)
      {
        CDOClassRefImpl classRef = (CDOClassRefImpl)referenceType;
        referenceType = CDOModelResolverImpl.INSTANCE.resolveClass(classRef);
        if (referenceType == null)
        {
          throw new IllegalStateException("Unable to resolve reference type: " + classRef);
        }
      }
    }
  }

  public CDOPackage getContainingPackage()
  {
    return containingClass.getContainingPackage();
  }

  public void setContainingClass(CDOClassImpl containingClass)
  {
    this.containingClass = containingClass;
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("CDOFeature(ID={0}, name={1}", featureID, getName());
  }
}
