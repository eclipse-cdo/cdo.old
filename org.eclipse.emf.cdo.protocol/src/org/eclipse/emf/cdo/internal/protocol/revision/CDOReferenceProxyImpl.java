/***************************************************************************
 * Copyright (c) 2004 - 2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.internal.protocol.revision;

import org.eclipse.emf.cdo.protocol.CDOID;
import org.eclipse.emf.cdo.protocol.model.CDOFeature;
import org.eclipse.emf.cdo.protocol.revision.CDOReferenceProxy;
import org.eclipse.emf.cdo.protocol.revision.CDORevision;
import org.eclipse.emf.cdo.protocol.revision.CDORevisionResolver;

/**
 * @author Eike Stepper
 */
public class CDOReferenceProxyImpl implements CDOReferenceProxy
{
  private CDORevision revision;

  private CDOFeature feature;

  private int index;

  public CDOReferenceProxyImpl(CDORevision revision, CDOFeature feature, int index)
  {
    this.revision = revision;
    this.feature = feature;
    this.index = index;
  }

  public CDORevision getRevision()
  {
    return revision;
  }

  public CDOFeature getFeature()
  {
    return feature;
  }

  public int getIndex()
  {
    return index;
  }

  public CDOID resolve()
  {
    CDORevisionResolver revisionResolver = revision.getRevisionResolver();
    return revisionResolver.resolveReferenceProxy(this);
  }
}
