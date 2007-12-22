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

import org.eclipse.emf.cdo.internal.protocol.model.CDOFeatureImpl;
import org.eclipse.emf.cdo.internal.protocol.revision.CDORevisionImpl;
import org.eclipse.emf.cdo.protocol.model.CDOClass;
import org.eclipse.emf.cdo.protocol.revision.CDORevision;
import org.eclipse.emf.cdo.protocol.revision.delta.CDOAddFeatureDelta;
import org.eclipse.emf.cdo.protocol.revision.delta.CDOFeatureDeltaVisitor;

import org.eclipse.net4j.util.io.ExtendedDataInput;

import java.io.IOException;

/**
 * @author Simon McDuff
 */
public class CDOAddFeatureDeltaImpl extends CDOSingleValueFeatureDeltaImpl implements CDOAddFeatureDelta
{
  public CDOAddFeatureDeltaImpl(CDOFeatureImpl feature, int index, Object value)
  {
    super(feature, index, value);
  }

  public CDOAddFeatureDeltaImpl(ExtendedDataInput in, CDOClass packageManager) throws IOException
  {
    super(in, packageManager);
  }

  @Override
  public CDOFeatureDeltaEnumType getShortType()
  {
    return CDOFeatureDeltaEnumType.ADD;
  }

  public void apply(CDORevision revision)
  {
    ((CDORevisionImpl)revision).getList(getFeature()).add(getIndex(), getValue());
  }

  public void accept(CDOFeatureDeltaVisitor visitor)
  {
    visitor.visit(this);
  }
}