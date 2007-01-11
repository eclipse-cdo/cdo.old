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
import org.eclipse.emf.cdo.protocol.CDOClassID;
import org.eclipse.emf.cdo.protocol.CDOClassRef;
import org.eclipse.emf.cdo.protocol.CDOModelResolver;
import org.eclipse.emf.cdo.protocol.CDOPackage;

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
public final class CDOClassImpl extends CDOModelElementImpl implements CDOClass
{
  private static final ContextTracer MODEL = new ContextTracer(CDOProtocol.DEBUG_MODEL,
      CDOClassImpl.class);

  private static final ContextTracer PROTOCOL = new ContextTracer(CDOProtocol.DEBUG_PROTOCOL,
      CDOClassImpl.class);

  private CDOPackage cdoPackage;

  private boolean isAbstract;

  private List<CDOFeatureImpl> cdoFeatures = new ArrayList(0);

  private transient List<Integer> index = new ArrayList(0);

  public CDOClassImpl(CDOPackage p, int id, String name, boolean isAbstract)
  {
    super(id, name);
    cdoPackage = p;
    this.isAbstract = isAbstract;
  }

  public CDOClassImpl(CDOPackage p, ExtendedDataInputStream in) throws IOException
  {
    super(in);
    cdoPackage = p;
    isAbstract = in.readBoolean();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Read class: ID={0}, name={1}, abstract={2}", getID(), getName(), isAbstract);
    }

    int size = in.readInt();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Reading {0} features", size);
    }

    for (int i = 0; i < size; i++)
    {
      CDOFeatureImpl f = new CDOFeatureImpl(this, in);
      addCDOFeature(f);
    }
  }

  public void write(ExtendedDataOutputStream out) throws IOException
  {
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Writing class: ID={0}, name={1}, abstract={2}", getID(), getName(),
          isAbstract);
    }

    super.write(out);
    out.writeBoolean(isAbstract);

    int size = cdoFeatures.size();
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.format("Writing {0} features", size);
    }

    out.writeInt(size);
    for (CDOFeatureImpl cdoFeature : cdoFeatures)
    {
      cdoFeature.write(out);
    }
  }

  public CDOPackage getCDOPackage()
  {
    return cdoPackage;
  }

  public boolean isAbstract()
  {
    return isAbstract;
  }

  public int getFeatureCount()
  {
    return cdoFeatures.size();
  }

  public CDOFeatureImpl[] getCDOFeatures()
  {
    return cdoFeatures.toArray(new CDOFeatureImpl[cdoFeatures.size()]);
  }

  public CDOFeatureImpl getCDOFeature(int featureID)
  {
    int i = index.get(featureID);
    return cdoFeatures.get(i);
  }

  public void addCDOFeature(CDOFeatureImpl f)
  {
    if (MODEL.isEnabled())
    {
      MODEL.format("Adding feature: ID={0}, name={1}, type={2}, many={3}, classRef={4}", f.getID(),
          f.getName(), f.getType(), f.isMany(), f.getReferenceClassRef());
    }

    setIndex(f.getID(), cdoFeatures.size());
    cdoFeatures.add(f);
  }

  private void setIndex(int id, int i)
  {
    while (index.size() <= id)
    {
      index.add(null);
    }

    index.set(id, i);
  }

  public CDOClassID getClassID()
  {
    return new CDOClassID(cdoPackage.getID(), getID());
  }

  public CDOClassRef getClassRef()
  {
    return new CDOClassRef(cdoPackage.getURI(), getID());
  }

  public void initialize()
  {
    for (CDOFeatureImpl featureDef : cdoFeatures)
    {
      featureDef.initialize();
    }
  }

  public CDOModelResolver getClassResolver()
  {
    return cdoPackage.getClassResolver();
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("CDOClass(id={0}, name={1}, abstract={2})", getID(), getName(),
        isAbstract);
  }
}
