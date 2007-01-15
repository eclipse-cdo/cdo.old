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
import org.eclipse.emf.cdo.protocol.model.CDOModelResolver;
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
public final class CDOFeatureImpl extends CDOModelElementImpl implements CDOFeature
{
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

  public CDOFeatureImpl(CDOClassImpl containingClass, int featureID, String name, int type,
      boolean many, boolean containment, CDOClassRefImpl referenceType)
  {
    super(name);
    this.containingClass = containingClass;
    this.featureID = featureID;
    this.type = type;
    this.many = many;
    this.containment = containment;
    this.referenceType = referenceType;
  }

  public CDOFeatureImpl(CDOClassImpl containingClass, ExtendedDataInputStream in)
      throws IOException
  {
    super(in);
    this.containingClass = containingClass;
    featureID = in.readInt();
    type = in.readInt();
    many = in.readBoolean();
    containment = in.readBoolean();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Read feature: ID={0}, name={1}, type={2}, many={3}, containment={4}",
          featureID, getName(), type, many, containment);
    }

    CDOClassProxy classRef = null;
    if (isReference())
    {
      classRef = new CDOClassProxy(in);
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

    if (type == CDOTypes.OBJECT)
    {
      CDOClassProxy classRef = getReferenceClassRef();
      if (PROTOCOL.isEnabled())
      {
        PROTOCOL.format("Writing reference type: classRef={0}", classRef);
      }

      classRef.write(out);
    }
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
    if (referenceType instanceof CDOClassImpl)
    {
      return (CDOClassImpl)referenceType;
    }

    throw new IllegalStateException("Feature definition not initialized: " + this);
  }

  public void initialize()
  {
    if (isReference() && referenceType instanceof CDOClassProxy)
    {
      CDOClassProxy classRef = (CDOClassProxy)referenceType;
      referenceType = getModelResolver().resolveClass(classRef);
      if (referenceType == null)
      {
        throw new IllegalStateException("Unable to resolve reference type: " + classRef);
      }
    }
  }

  public CDOModelResolver getModelResolver()
  {
    return getContainingPackage().getModelResolver();
  }

  public CDOPackage getContainingPackage()
  {
    return containingClass.getContainingPackage();
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("CDOFeature(ID={0}, name={1}", featureID, getName());
  }
}
