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
package org.eclipse.emf.cdo.internal.protocol.analyzer;

import org.eclipse.emf.cdo.internal.protocol.model.CDOClassImpl;
import org.eclipse.emf.cdo.internal.protocol.model.CDOClassRefImpl;
import org.eclipse.emf.cdo.protocol.model.CDOClass;
import org.eclipse.emf.cdo.protocol.model.CDOFeature;
import org.eclipse.emf.cdo.protocol.model.CDOPackageManager;

import org.eclipse.net4j.util.io.ExtendedDataInput;
import org.eclipse.net4j.util.io.ExtendedDataOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class CDOFetchRule
{
  private CDOClass cdoClass;

  private List<CDOFeature> features = new ArrayList<CDOFeature>(0);

  public CDOFetchRule(CDOClass cdoClass)
  {
    this.cdoClass = cdoClass;
  }

  public CDOFetchRule(ExtendedDataInput in, CDOPackageManager packageManager) throws IOException
  {
    CDOClassRefImpl classRef = new CDOClassRefImpl(in, null);
    cdoClass = classRef.resolve(packageManager);
    int size = in.readInt();
    for (int i = 0; i < size; i++)
    {
      int featureID = in.readInt();
      CDOFeature feature = cdoClass.lookupFeature(featureID);
      features.add(feature);
    }
  }

  public void write(ExtendedDataOutput out) throws IOException
  {
    ((CDOClassImpl)cdoClass).createClassRef().write(out, null);
    out.writeInt(features.size());
    for (CDOFeature feature : features)
    {
      out.writeInt(feature.getFeatureID());
    }
  }

  public CDOClass getCDOClass()
  {
    return cdoClass;
  }

  public List<CDOFeature> getFeatures()
  {
    return features;
  }

  public void addFeature(CDOFeature feature)
  {
    features.add(feature);
  }

  public void removeFeature(CDOFeature feature)
  {
    features.remove(feature);

  }

  public boolean isEmpty()
  {
    return features.isEmpty();
  }
}
