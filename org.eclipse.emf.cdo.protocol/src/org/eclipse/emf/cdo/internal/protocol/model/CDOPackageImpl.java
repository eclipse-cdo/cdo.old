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
import org.eclipse.emf.cdo.protocol.util.CDOPackageInfo;

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

  private CDOModelResolver classResolver;

  private String uri;

  private List<CDOClassImpl> cdoClasses = new ArrayList(0);

  private List<CDOClassImpl> index = new ArrayList(0);

  public CDOPackageImpl(CDOModelResolver classResolver, int id, String name, String uri)
  {
    super(id, name);
    this.classResolver = classResolver;
    this.uri = uri;
  }

  public CDOPackageImpl(CDOModelResolver classResolver, ExtendedDataInputStream in)
      throws IOException
  {
    super(in);
    this.classResolver = classResolver;
    uri = in.readString();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Read package: ID={0}, name={1}, URI={2}", getID(), getName(), uri);
    }

    int size = in.readInt();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Reading {0} classes", size);
    }

    for (int i = 0; i < size; i++)
    {
      CDOClassImpl c = new CDOClassImpl(this, in);
      addCDOClass(c);
    }
  }

  public void write(ExtendedDataOutputStream out) throws IOException
  {
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Writing package: ID={0}, name={0}, URI={1}", getID(), getName(), uri);
    }

    super.write(out);
    out.writeString(uri);

    int size = cdoClasses.size();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Writing {0} classes", size);
    }

    out.writeInt(size);
    for (CDOClassImpl cdoClass : cdoClasses)
    {
      cdoClass.write(out);
    }
  }

  public CDOModelResolver getClassResolver()
  {
    return classResolver;
  }

  public String getURI()
  {
    return uri;
  }

  public CDOPackageInfo getPackageInfo()
  {
    return new CDOPackageInfo(getID(), uri);
  }

  public int getClassCount()
  {
    return cdoClasses.size();
  }

  public CDOClass[] getCDOClasses()
  {
    return cdoClasses.toArray(new CDOClassImpl[cdoClasses.size()]);
  }

  public void addCDOClass(CDOClassImpl c)
  {
    int id = c.getID();
    if (MODEL.isEnabled())
    {
      MODEL.format("Adding class: ID={0}, name={1}, abstract={2}", id, c.getName(), c.isAbstract());
    }

    while (id >= index.size())
    {
      index.add(null);
    }

    index.set(id, c);
    cdoClasses.add(c);
  }

  public void initialize()
  {
    for (CDOClassImpl c : cdoClasses)
    {
      c.initialize();
    }
  }

  public CDOClassImpl getCDOClass(int classifierID)
  {
    return index.get(classifierID);
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("CDOPackage(id={0}, name={1}, uri={2})", getID(), getName(), uri);
  }
}
