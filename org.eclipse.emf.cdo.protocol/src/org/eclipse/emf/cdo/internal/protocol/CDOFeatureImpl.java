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
import org.eclipse.emf.cdo.protocol.CDOFeature;
import org.eclipse.emf.cdo.protocol.CDOModelResolver;
import org.eclipse.emf.cdo.protocol.CDOPackage;
import org.eclipse.emf.cdo.protocol.CDOTypes;

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

  private CDOClassImpl cdoClass;

  private int type;

  private boolean many;

  private Object referenceClass;

  public CDOFeatureImpl(CDOClassImpl c, int id, String name, int type, boolean many,
      CDOClassRef classRef)
  {
    super(id, name);
    cdoClass = c;
    this.type = type;
    this.many = many;
    referenceClass = classRef;
  }

  public CDOFeatureImpl(CDOClassImpl c, ExtendedDataInputStream in) throws IOException
  {
    super(in);
    cdoClass = c;
    type = in.readInt();
    many = in.readBoolean();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Read feature: ID={0}, name={1}, type={2}, many={3}", getID(), getName(),
          type, many);
    }

    CDOClassRef classRef = null;
    if (type == CDOTypes.OBJECT)
    {
      classRef = new CDOClassRef(in);
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
      PROTOCOL.format("Writing feature: ID={0}, name={1}, type={2}, many={3}", getID(), getName(),
          type, many);
    }

    super.write(out);
    out.writeInt(type);
    out.writeBoolean(many);

    if (type == CDOTypes.OBJECT)
    {
      CDOClassRef classRef = getReferenceClassRef();
      if (PROTOCOL.isEnabled())
      {
        PROTOCOL.format("Writing reference type: classRef={0}", classRef);
      }

      classRef.write(out);
    }
  }

  public CDOClassImpl getCDOClass()
  {
    return cdoClass;
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

  public CDOClassImpl getReferenceClass()
  {
    if (referenceClass instanceof CDOClassImpl)
    {
      return (CDOClassImpl)referenceClass;
    }

    throw new IllegalStateException("Feature definition not initialized: " + this);
  }

  public CDOClassRef getReferenceClassRef()
  {
    if (referenceClass instanceof CDOClassImpl)
    {
      return ((CDOClass)referenceClass).getClassRef();
    }

    return (CDOClassRef)referenceClass;
  }

  public void initialize()
  {
    if (referenceClass instanceof CDOClassRef)
    {
      CDOClassRef classRef = (CDOClassRef)referenceClass;
      referenceClass = getClassResolver().getCDOClass(classRef);
      if (MODEL.isEnabled())
      {
        MODEL.format("Resolving reference type: {0} --> {1}", classRef, getReferenceClass()
            .getClassID());
      }

      if (referenceClass == null)
      {
        throw new IllegalStateException("Unable to resolve reference type: " + classRef);
      }
    }
  }

  public CDOModelResolver getClassResolver()
  {
    return getCDOPackage().getClassResolver();
  }

  public CDOPackage getCDOPackage()
  {
    return cdoClass.getCDOPackage();
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("CDOFeature(id={0}, name={1}, type={2}, many={3}, classRef={4})",
        getID(), getName(), type, many, referenceClass);
  }
}
