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
import org.eclipse.emf.cdo.protocol.revision.CDORevision;
import org.eclipse.emf.cdo.protocol.revision.delta.CDOFeatureDelta;
import org.eclipse.emf.cdo.protocol.revision.delta.CDOFeatureDeltaVisitor;
import org.eclipse.emf.cdo.protocol.revision.delta.CDOListFeatureDelta;

import org.eclipse.net4j.util.io.ExtendedDataInput;
import org.eclipse.net4j.util.io.ExtendedDataOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Simon McDuff
 */
public class CDOListFeatureDeltaImpl extends CDOFeatureDeltaImpl implements CDOListFeatureDelta
{
  private List<CDOFeatureDelta> featureDeltas = new ArrayList<CDOFeatureDelta>();

  public CDOListFeatureDeltaImpl(CDOFeature feature)
  {
    super(feature);
  }

  public CDOListFeatureDeltaImpl(ExtendedDataInput in, CDOClass packageManager) throws IOException
  {
    super(in, packageManager);
    int size = in.readInt();
    for (int i = 0; i < size; i++)
    {
      featureDeltas.add(CDOFeatureDeltaImpl.readFeature(in, packageManager));
    }
  }

  public List<CDOFeatureDelta> getListChanges()
  {
    return featureDeltas;
  }

  @Override
  public void write(ExtendedDataOutput out, CDOIDProvider idProvider) throws IOException
  {
    super.write(out, idProvider);
    out.writeInt(featureDeltas.size());
    for (CDOFeatureDelta featureDelta : featureDeltas)
    {
      ((CDOFeatureDeltaImpl)featureDelta).write(out, idProvider);
    }
  }

  public Type getType()
  {
    return Type.LIST;
  }

  public void add(CDOFeatureDelta featureDelta)
  {
    featureDeltas.add(featureDelta);
  }

  public void apply(CDORevision revision)
  {
    for (CDOFeatureDelta featureDelta : featureDeltas)
    {
      ((CDOFeatureDeltaImpl)featureDelta).apply(revision);
    }
  }

  @Override
  public void adjustReferences(Map<CDOID, CDOID> idMappings)
  {
    for (CDOFeatureDelta featureDelta : featureDeltas)
    {
      ((CDOFeatureDeltaImpl)featureDelta).adjustReferences(idMappings);
    }
  }

  public void accept(CDOFeatureDeltaVisitor visitor)
  {
    visitor.visit(this);
  }
}
