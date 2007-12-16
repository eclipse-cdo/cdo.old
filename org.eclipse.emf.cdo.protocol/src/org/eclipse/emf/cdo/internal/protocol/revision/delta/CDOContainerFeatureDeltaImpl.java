/***************************************************************************
 * Copyright (c) 2004 - 2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Simon McDuff - initial API and implementation
 *    Eike Stepper - maintenance
 **************************************************************************/
package org.eclipse.emf.cdo.internal.protocol.revision.delta;

import org.eclipse.emf.cdo.internal.protocol.CDOIDImpl;
import org.eclipse.emf.cdo.internal.protocol.revision.CDOIDProvider;
import org.eclipse.emf.cdo.internal.protocol.revision.CDORevisionImpl;
import org.eclipse.emf.cdo.protocol.CDOID;
import org.eclipse.emf.cdo.protocol.model.CDOClass;
import org.eclipse.emf.cdo.protocol.model.CDOFeature;
import org.eclipse.emf.cdo.protocol.model.CDOPackage;
import org.eclipse.emf.cdo.protocol.model.CDOPackageManager;
import org.eclipse.emf.cdo.protocol.model.CDOType;
import org.eclipse.emf.cdo.protocol.revision.CDORevision;
import org.eclipse.emf.cdo.protocol.revision.delta.CDOContainerFeatureDelta;
import org.eclipse.emf.cdo.protocol.revision.delta.CDOFeatureDeltaVisitor;

import org.eclipse.net4j.util.io.ExtendedDataInput;
import org.eclipse.net4j.util.io.ExtendedDataOutput;

import java.io.IOException;
import java.util.Map;

/**
 * @author Simon McDuff
 */
public class CDOContainerFeatureDeltaImpl extends CDOFeatureDeltaImpl implements CDOContainerFeatureDelta
{
  private static CDOFeature CONTAINER_FEATURE = new ContainerFeature();

  private CDOID newContainerID;

  private int newContainerFeatureID;

  public CDOContainerFeatureDeltaImpl(CDOID newContainerID, int newContainerFeatureID)
  {
    super(CONTAINER_FEATURE);
    this.newContainerID = newContainerID;
    this.newContainerFeatureID = newContainerFeatureID;
  }

  public CDOContainerFeatureDeltaImpl(ExtendedDataInput in, CDOClass packageManager) throws IOException
  {
    super(CONTAINER_FEATURE);
    newContainerFeatureID = in.readInt();
    newContainerID = CDOIDImpl.read(in);
  }

  public int getContainerFeatureID()
  {
    return this.newContainerFeatureID;
  }

  public CDOID getContainerID()
  {
    return this.newContainerID;
  }

  @Override
  public CDOFeatureDeltaEnumType getShortType()
  {
    return CDOFeatureDeltaEnumType.CONTAINER;
  }

  public void apply(CDORevision revision)
  {
    ((CDORevisionImpl)revision).setContainerID(newContainerID);
    ((CDORevisionImpl)revision).setContainingFeature(newContainerFeatureID);
  }

  @Override
  public void adjustReferences(Map<CDOID, CDOID> idMappings)
  {
    newContainerID = (CDOID)CDORevisionImpl.remapID(newContainerID, idMappings);
  }

  @Override
  public void write(ExtendedDataOutput out, CDOIDProvider idProvider) throws IOException
  {
    out.writeInt(getShortType().ordinal());
    out.writeInt(newContainerFeatureID);
    CDOIDImpl.write(out, newContainerID);
  }

  public void accept(CDOFeatureDeltaVisitor visitor)
  {
    visitor.visit(this);
  }

  /**
   * @author Simon McDuff
   */
  private static final class ContainerFeature implements CDOFeature
  {
    public CDOClass getContainingClass()
    {
      return null;
    }

    public CDOPackage getContainingPackage()
    {
      return null;
    }

    public int getFeatureID()
    {
      return 0;
    }

    public int getFeatureIndex()
    {
      return 0;
    }

    public CDOClass getReferenceType()
    {
      return null;
    }

    public CDOType getType()
    {
      return null;
    }

    public boolean isContainment()
    {
      return false;
    }

    public boolean isMany()
    {
      return false;
    }

    public boolean isReference()
    {
      return false;
    }

    public Object getClientInfo()
    {
      return null;
    }

    public String getName()
    {
      return null;
    }

    public CDOPackageManager getPackageManager()
    {
      return null;
    }

    public Object getServerInfo()
    {
      return null;
    }

    public void setClientInfo(Object clientInfo)
    {
    }

    public void setServerInfo(Object serverInfo)
    {
    }

    @Override
    public String toString()
    {
      return "CONTAINER_FEATURE";
    }
  }
}
