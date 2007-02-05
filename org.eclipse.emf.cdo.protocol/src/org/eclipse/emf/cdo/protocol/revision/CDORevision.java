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
package org.eclipse.emf.cdo.protocol.revision;

import org.eclipse.emf.cdo.protocol.CDOID;
import org.eclipse.emf.cdo.protocol.model.CDOClass;

/**
 * @author Eike Stepper
 */
public interface CDORevision
{
  public static final long UNSPECIFIED_DATE = 0;

  public CDOClass getCDOClass();

  public CDOID getID();

  public int getVersion();

  public long getCreated();

  public long getRevised();

  public boolean isActual();

  public boolean isValid(long timeStamp);

  public boolean isResource();

  public CDORevisionData getData();

  public CDORevisionDelta createDelta(CDORevision origin);
}
