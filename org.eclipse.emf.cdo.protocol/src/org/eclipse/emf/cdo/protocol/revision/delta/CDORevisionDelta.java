/***************************************************************************
 * Copyright (c) 2004 - 2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Simon McDuff - https://bugs.eclipse.org/bugs/show_bug.cgi?id=201266
 **************************************************************************/
package org.eclipse.emf.cdo.protocol.revision.delta;

import org.eclipse.emf.cdo.protocol.CDOID;

import java.util.List;

/**
 * @author Eike Stepper
 */
public interface CDORevisionDelta
{
  public int getOriginVersion();

  public int getDirtyVersion();

  public CDOID getId();

  public List<CDOFeatureDelta> getFeatureDeltas();

  public void accept(CDOFeatureDeltaVisitor visitor);
}
