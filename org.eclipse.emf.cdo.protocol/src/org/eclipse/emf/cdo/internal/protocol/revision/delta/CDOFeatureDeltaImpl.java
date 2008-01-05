/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
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

import org.eclipse.emf.cdo.internal.protocol.revision.CDOIDProvider;
import org.eclipse.emf.cdo.protocol.CDOID;
import org.eclipse.emf.cdo.protocol.model.CDOClass;
import org.eclipse.emf.cdo.protocol.model.CDOFeature;
import org.eclipse.emf.cdo.protocol.revision.delta.CDOFeatureDelta;

import org.eclipse.net4j.util.io.ExtendedDataInput;
import org.eclipse.net4j.util.io.ExtendedDataOutput;

import java.io.IOException;
import java.util.Map;

/**
 * @author Simon McDuff
 */
public abstract class CDOFeatureDeltaImpl implements CDOFeatureDelta
{
  private CDOFeature feature;

  protected CDOFeatureDeltaImpl(CDOFeature feature)
  {
    this.feature = feature;
  }

  public CDOFeatureDeltaImpl(ExtendedDataInput in, CDOClass cdoClass) throws IOException
  {
    int featureID = in.readInt();
    feature = cdoClass.lookupFeature(featureID);
  }

  public CDOFeature getFeature()
  {
    return feature;
  }

  public abstract void adjustReferences(Map<CDOID, CDOID> idMappings);

  public void write(ExtendedDataOutput out, CDOIDProvider idProvider) throws IOException
  {
    out.writeInt(getType().ordinal());
    out.writeInt(feature.getFeatureID());
  }

  public static CDOFeatureDeltaImpl readFeature(ExtendedDataInput in, CDOClass cdoCLass) throws IOException
  {
    CDOFeatureDeltaImpl featureDelta = null;
    int classType = in.readInt();
    Type featureType = Type.values()[classType];

    if (featureType == Type.ADD)
    {
      featureDelta = new CDOAddFeatureDeltaImpl(in, cdoCLass);
    }
    else if (featureType == Type.SET)
    {
      featureDelta = new CDOSetFeatureDeltaImpl(in, cdoCLass);
    }
    else if (featureType == Type.LIST)
    {
      featureDelta = new CDOListFeatureDeltaImpl(in, cdoCLass);
    }
    else if (featureType == Type.MOVE)
    {
      featureDelta = new CDOMoveFeatureDeltaImpl(in, cdoCLass);
    }
    else if (featureType == Type.CLEAR)
    {
      featureDelta = new CDOClearFeatureDeltaImpl(in, cdoCLass);
    }
    else if (featureType == Type.REMOVE)
    {
      featureDelta = new CDORemoveFeatureDeltaImpl(in, cdoCLass);
    }
    else if (featureType == Type.CONTAINER)
    {
      featureDelta = new CDOContainerFeatureDeltaImpl(in, cdoCLass);
    }
    else if (featureType == Type.UNSET)
    {
      featureDelta = new CDOUnsetFeatureDeltaImpl(in, cdoCLass);
    }
    else
    {
      // TODO Find better exception for signalling errors
      throw new UnsupportedOperationException("Number of classed " + classType + " is undefined");
    }

    return featureDelta;
  }
}
