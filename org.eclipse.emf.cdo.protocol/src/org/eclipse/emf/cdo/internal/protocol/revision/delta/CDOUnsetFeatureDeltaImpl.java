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

import org.eclipse.emf.cdo.internal.protocol.model.CDOFeatureImpl;
import org.eclipse.emf.cdo.internal.protocol.revision.CDORevisionImpl;
import org.eclipse.emf.cdo.protocol.CDOID;
import org.eclipse.emf.cdo.protocol.model.CDOClass;
import org.eclipse.emf.cdo.protocol.revision.CDORevision;
import org.eclipse.emf.cdo.protocol.revision.delta.CDOFeatureDeltaVisitor;
import org.eclipse.emf.cdo.protocol.revision.delta.CDOUnsetFeatureDelta;

import org.eclipse.net4j.util.io.ExtendedDataInput;

import java.io.IOException;
import java.util.Map;

/**
 * @author Simon McDuff
 */
public class CDOUnsetFeatureDeltaImpl extends CDOFeatureDeltaImpl implements CDOUnsetFeatureDelta
{
  public CDOUnsetFeatureDeltaImpl(CDOFeatureImpl feature)
  {
    super(feature);
  }

  public CDOUnsetFeatureDeltaImpl(ExtendedDataInput in, CDOClass packageManager) throws IOException
  {
    super(in, packageManager);
  }

  public Type getType()
  {
    return Type.UNSET;
  }

  public void apply(CDORevision revision)
  {
    ((CDORevisionImpl)revision).unset(getFeature());
  }

  public void accept(CDOFeatureDeltaVisitor visitor)
  {
    visitor.visit(this);
  }

  @Override
  public void adjustReferences(Map<CDOID, CDOID> idMappings)
  {
    // Do nothing
  }
}
