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
package org.eclipse.emf.cdo.protocol.analyzer;

import org.eclipse.emf.cdo.internal.protocol.analyzer.NOOPFeatureAnalyzer;
import org.eclipse.emf.cdo.protocol.model.CDOFeature;
import org.eclipse.emf.cdo.protocol.revision.CDORevision;

/**
 * @author Eike Stepper
 */
public interface IFeatureAnalyzer
{
  public static final IFeatureAnalyzer NOOP = new NOOPFeatureAnalyzer();

  public void preTraverseFeature(CDORevision revision, CDOFeature feature, int index);

  public void postTraverseFeature(CDORevision revision, CDOFeature feature, int index);
}
