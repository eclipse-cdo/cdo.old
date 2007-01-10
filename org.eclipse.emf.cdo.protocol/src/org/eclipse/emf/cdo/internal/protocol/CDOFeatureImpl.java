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
import org.eclipse.emf.cdo.protocol.CDOClass;
import org.eclipse.emf.cdo.protocol.CDOClassRef;
import org.eclipse.emf.cdo.protocol.CDOClassResolver;
import org.eclipse.emf.cdo.protocol.CDOFeature;
import org.eclipse.emf.cdo.protocol.CDOPackage;
import org.eclipse.emf.cdo.protocol.CDOTypes;

import org.eclipse.net4j.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.stream.ExtendedDataInputStream;

import java.io.IOException;

/**
 * @author Eike Stepper
 */
public final class CDOFeatureImpl implements CDOFeature
{
  private static final ContextTracer PROTOCOL = new ContextTracer(CDOProtocol.DEBUG_PROTOCOL,
      CDOFeatureImpl.class);

  private CDOClass cdoClass;

  private int featureID;

  private String name;

  private int type;

  private boolean many;

  private Object referenceType;

  public CDOFeatureImpl(CDOClass c, int featureID, String name, int type, boolean many,
      CDOClassRef classRef)
  {
    cdoClass = c;
    this.featureID = featureID;
    this.name = name;
    this.type = type;
    this.many = many;
    referenceType = classRef;
  }

  public CDOFeatureImpl(CDOClass c, ExtendedDataInputStream in) throws IOException
  {
    cdoClass = c;
    featureID = in.readInt();
    name = in.readString();
    type = in.readInt();
    many = in.readBoolean();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Read feature: featureID={0}, name={1}, type={2}, many={3}", featureID, name,
          type, many);
    }

    CDOClassRef classRef = null;
    if (type == CDOTypes.OBJECT)
    {
      classRef = new CDOClassRef(in);
      if (PROTOCOL.isEnabled())
      {
        PROTOCOL.format("Read reference type: classRef={0}, className={1}", classRef, null);
      }
    }
  }

  public CDOClass getCDOClass()
  {
    return cdoClass;
  }

  public int getFeatureID()
  {
    return featureID;
  }

  public String getName()
  {
    return name;
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

  public CDOClass getReferenceType()
  {
    if (referenceType instanceof CDOClassImpl)
    {
      return (CDOClass)referenceType;
    }

    throw new IllegalStateException("Feature definition not initialized: " + this);
  }

  public CDOClassRef getReferenceClassRef()
  {
    if (referenceType instanceof CDOClassImpl)
    {
      return ((CDOClass)referenceType).getClassRef();
    }

    return (CDOClassRef)referenceType;
  }

  public void initialize()
  {
    if (isReference())
    {
      CDOClassResolver classResolver = getClassResolver();
      CDOClassRef classRef = (CDOClassRef)referenceType;
      referenceType = classResolver.getCDOClass(classRef);
      if (PROTOCOL.isEnabled())
      {
        PROTOCOL.format("Resolving reference type: {0} --> {1}", classRef, getReferenceType()
            .getClassID());
      }
    }
  }

  public CDOClassResolver getClassResolver()
  {
    return getCDOPackage().getClassResolver();
  }

  public CDOPackage getCDOPackage()
  {
    return cdoClass.getCDOPackage();
  }
}
