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
import org.eclipse.emf.cdo.protocol.model.CDOClass;
import org.eclipse.emf.cdo.protocol.model.CDOModelResolver;
import org.eclipse.emf.cdo.protocol.model.CDOPackage;

import org.eclipse.net4j.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.stream.ExtendedDataInputStream;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eike Stepper
 */
public final class CDOPackageImpl extends CDOModelElementImpl implements CDOPackage
{
  private static final ContextTracer MODEL = new ContextTracer(CDOProtocol.DEBUG_MODEL,
      CDOPackageImpl.class);

  private static final ContextTracer PROTOCOL = new ContextTracer(CDOProtocol.DEBUG_PROTOCOL,
      CDOPackageImpl.class);

  private CDOModelResolver modelResolver;

  private String packageURI;

  private List<CDOClassImpl> classes = new ArrayList(0);

  private List<CDOClassImpl> index = new ArrayList(0);

  public CDOPackageImpl(CDOModelResolver modelResolver, String packageURI, String name)
  {
    super(name);
    this.modelResolver = modelResolver;
    this.packageURI = packageURI;
  }

  public CDOPackageImpl(CDOModelResolver modelResolver, ExtendedDataInputStream in)
      throws IOException
  {
    super(in);
    this.modelResolver = modelResolver;
    packageURI = in.readString();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Read package: URI={0}, name={1}", packageURI, getName());
    }

    int size = in.readInt();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Reading {0} classes", size);
    }

    for (int i = 0; i < size; i++)
    {
      CDOClassImpl c = new CDOClassImpl(this, in);
      addClass(c);
    }
  }

  public void write(ExtendedDataOutputStream out) throws IOException
  {
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Writing package: URI={0}, name={0}", packageURI, getName());
    }

    super.write(out);
    out.writeString(packageURI);

    int size = classes.size();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Writing {0} classes", size);
    }

    out.writeInt(size);
    for (CDOClassImpl cdoClass : classes)
    {
      cdoClass.write(out);
    }
  }

  public CDOModelResolver getModelResolver()
  {
    return modelResolver;
  }

  public String getPackageURI()
  {
    return packageURI;
  }

  public int getClassCount()
  {
    return classes.size();
  }

  public CDOClass[] getClasses()
  {
    return classes.toArray(new CDOClassImpl[classes.size()]);
  }

  public CDOClassImpl lookupClass(int classifierID)
  {
    return index.get(classifierID);
  }

  public void addClass(CDOClassImpl cdoClass)
  {
    int classifierID = cdoClass.getClassifierID();
    if (MODEL.isEnabled())
    {
      MODEL.format("Adding class: {0}", cdoClass);
    }

    while (classifierID >= index.size())
    {
      index.add(null);
    }

    index.set(classifierID, cdoClass);
    classes.add(cdoClass);
  }

  public void initialize()
  {
    for (CDOClassImpl cdoClass : classes)
    {
      cdoClass.initialize();
    }
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("CDOPackage(URI={0}, name={1})", packageURI, getName());
  }
}
