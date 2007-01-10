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
import org.eclipse.emf.cdo.protocol.CDOClassResolver;
import org.eclipse.emf.cdo.protocol.CDOPackage;
import org.eclipse.emf.cdo.protocol.CDOPackageInfo;

import org.eclipse.net4j.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.stream.ExtendedDataInputStream;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eike Stepper
 */
public final class CDOPackageImpl implements CDOPackage
{
  public static final int UNINITIALIZED_ID = -1;

  private static final ContextTracer PROTOCOL = new ContextTracer(CDOProtocol.DEBUG_PROTOCOL,
      CDOPackageImpl.class);

  private CDOClassResolver classResolver;

  private int id;

  private String name;

  private String uri;

  private List<CDOClassImpl> cdoClasses = new ArrayList(0);

  private List<CDOClassImpl> index = new ArrayList(0);

  public CDOPackageImpl(CDOClassResolver classResolver, int id, String name, String uri)
  {
    this.classResolver = classResolver;
    this.id = id;
    this.name = name;
    this.uri = uri;
  }

  public CDOPackageImpl(CDOClassResolver classResolver, ExtendedDataInputStream in)
      throws IOException
  {
    this.classResolver = classResolver;
    id = in.readInt();
    name = in.readString();
    uri = in.readString();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Read package: id={0}, name={1}, URI={2}", id, name, uri);
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
  }

  public CDOClassResolver getClassResolver()
  {
    return classResolver;
  }

  public int getID()
  {
    if (id == UNINITIALIZED_ID)
    {
      throw new IllegalStateException("id == UNINITIALIZED_ID");
    }

    return id;
  }

  public void setID(int id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public String getURI()
  {
    return uri;
  }

  public CDOPackageInfo getPackageInfo()
  {
    return new CDOPackageInfo(id, uri);
  }

  public CDOClass[] getCDOClasses()
  {
    return cdoClasses.toArray(new CDOClassImpl[cdoClasses.size()]);
  }

  public void addCDOClass(CDOClassImpl c)
  {
    int classifierID = c.getClassifierID();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Adding class: classifierID={0}, name={1}, abstract={2}", classifierID, c
          .getName(), c.isAbstract());
    }

    while (classifierID >= index.size())
    {
      index.add(null);
    }

    index.set(classifierID, c);
    cdoClasses.add(c);
  }

  public void initialize()
  {
    for (CDOClassImpl c : cdoClasses)
    {
      c.initialize();
    }
  }

  public CDOClass getCDOClass(int classifierID)
  {
    return index.get(classifierID);
  }
}
