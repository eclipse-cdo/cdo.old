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

import org.eclipse.emf.cdo.internal.protocol.CDOIDRangeImpl;
import org.eclipse.emf.cdo.internal.protocol.bundle.OM;
import org.eclipse.emf.cdo.protocol.CDOIDRange;
import org.eclipse.emf.cdo.protocol.model.CDOPackage;
import org.eclipse.emf.cdo.protocol.model.CDOPackageManager;

import org.eclipse.net4j.internal.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.io.ExtendedDataInput;
import org.eclipse.net4j.util.io.ExtendedDataOutput;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class CDOPackageImpl extends CDOModelElementImpl implements CDOPackage
{
  private static final ContextTracer MODEL = new ContextTracer(OM.DEBUG_MODEL, CDOPackageImpl.class);

  private static final ContextTracer PROTOCOL = new ContextTracer(OM.DEBUG_PROTOCOL, CDOPackageImpl.class);

  private CDOPackageManager packageManager;

  private String packageURI;

  private List<CDOClassImpl> classes;

  private List<CDOClassImpl> index;

  private String ecore;

  private boolean dynamic;

  private CDOIDRange metaIDRange;

  /**
   * TODO If this is only needed by the client then put it into server info
   */
  private boolean persistent = true;

  public CDOPackageImpl(CDOPackageManager packageManager, String packageURI, String name, String ecore,
      boolean dynamic, CDOIDRange metaIDRange)
  {
    super(name);
    this.packageManager = packageManager;
    this.packageURI = packageURI;
    this.ecore = ecore;
    this.dynamic = dynamic;
    this.metaIDRange = metaIDRange;
    if (MODEL.isEnabled())
    {
      MODEL.format("Created {0}", this);
    }

    createLists();
  }

  public CDOPackageImpl(CDOPackageManager packageManager, ExtendedDataInput in) throws IOException
  {
    this.packageManager = packageManager;
    createLists();
    read(in);
  }

  /**
   * Creates a proxy CDO package
   */
  public CDOPackageImpl(CDOPackageManager packageManager, String packageURI, boolean dynamic, CDOIDRange metaIDRange)
  {
    this.packageManager = packageManager;
    this.packageURI = packageURI;
    this.dynamic = dynamic;
    this.metaIDRange = metaIDRange;
    if (MODEL.isEnabled())
    {
      MODEL.format("Created proxy package {0}, dynamic={1}, metaIDRange={2}", packageURI, dynamic, metaIDRange);
    }
  }

  @Override
  public void read(ExtendedDataInput in) throws IOException
  {
    super.read(in);
    packageURI = in.readString();
    dynamic = in.readBoolean();
    ecore = in.readString();
    metaIDRange = CDOIDRangeImpl.read(in);
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Read package: URI={0}, name={1}, dynamic={2}, metaIDRange={3}", packageURI, getName(), dynamic,
          metaIDRange);
    }

    int size = in.readInt();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Reading {0} classes", size);
    }

    for (int i = 0; i < size; i++)
    {
      CDOClassImpl cdoClass = new CDOClassImpl(this, in);
      addClass(cdoClass);
    }
  }

  @Override
  public void write(ExtendedDataOutput out) throws IOException
  {
    resolve();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Writing package: URI={0}, name={1}, dynamic={2}, metaIDRange={3}", packageURI, getName(),
          dynamic, metaIDRange);
    }

    super.write(out);
    out.writeString(packageURI);
    out.writeBoolean(dynamic);
    out.writeString(ecore);
    CDOIDRangeImpl.write(out, metaIDRange);

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

  public void setPackageManager(CDOPackageManager packageManager)
  {
    this.packageManager = packageManager;
  }

  public CDOPackageManager getPackageManager()
  {
    return packageManager;
  }

  public String getPackageURI()
  {
    return packageURI;
  }

  public int getClassCount()
  {
    resolve();
    return classes.size();
  }

  public CDOClassImpl[] getClasses()
  {
    resolve();
    return classes.toArray(new CDOClassImpl[classes.size()]);
  }

  /**
   * @return All classes with <code>isAbstract() == false</code> and
   *         <code>isSystem() == false</code>.
   */
  public CDOClassImpl[] getConcreteClasses()
  {
    resolve();
    List<CDOClassImpl> result = new ArrayList(0);
    for (CDOClassImpl cdoClass : classes)
    {
      if (!cdoClass.isAbstract())
      {
        CDOPackage cdoPackage = cdoClass.getContainingPackage();
        if (!cdoPackage.isSystem())
        {
          result.add(cdoClass);
        }
      }
    }

    return result.toArray(new CDOClassImpl[result.size()]);
  }

  public CDOClassImpl lookupClass(int classifierID)
  {
    resolve();
    return index.get(classifierID);
  }

  public String getEcore()
  {
    if (ecore == null && packageManager instanceof CDOPackageManagerImpl)
    {
      // TODO Can ecore be null?
      ecore = ((CDOPackageManagerImpl)packageManager).provideEcore(this);
    }

    return ecore;
  }

  /**
   * TODO Add IStore API to demand read dynamic ecore string
   */
  public void setEcore(String ecore)
  {
    this.ecore = ecore;
  }

  public CDOIDRange getMetaIDRange()
  {
    return metaIDRange;
  }

  public void setMetaIDRange(CDOIDRange metaIDRange)
  {
    this.metaIDRange = metaIDRange;
  }

  public boolean isDynamic()
  {
    return dynamic;
  }

  public boolean isSystem()
  {
    return false;
  }

  public boolean isProxy()
  {
    return classes == null;
  }

  public boolean isPersistent()
  {
    return persistent;
  }

  public void setPersistent(boolean persistent)
  {
    this.persistent = persistent;
  }

  public void addClass(CDOClassImpl cdoClass)
  {
    int classifierID = cdoClass.getClassifierID();
    if (MODEL.isEnabled())
    {
      MODEL.format("Adding class: {0}", cdoClass);
    }

    setIndex(classifierID, cdoClass);
    classes.add(cdoClass);
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("CDOPackage(URI={0}, name={1}, dynamic={2}, metaIDRange={3})", packageURI, getName(),
        dynamic, metaIDRange);
  }

  @Override
  protected void onInitialize()
  {
    for (CDOClassImpl cdoClass : classes)
    {
      cdoClass.initialize();
    }
  }

  private void setIndex(int classifierID, CDOClassImpl cdoClass)
  {
    while (classifierID >= index.size())
    {
      index.add(null);
    }

    index.set(classifierID, cdoClass);
  }

  private void resolve()
  {
    if (classes == null && packageManager instanceof CDOPackageManagerImpl)
    {
      createLists();
      ((CDOPackageManagerImpl)packageManager).resolve(this);
    }
  }

  private void createLists()
  {
    classes = new ArrayList(0);
    index = new ArrayList(0);
  }
}
