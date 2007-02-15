/***************************************************************************
 * Copyright (c) 2004-2007 Eike Stepper, Germany.
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

/**
 * @author Eike Stepper
 */
public interface CDORevisionResolver
{
  public CDORevision getActualRevision(CDOID id);

  public CDORevision getHistoricalRevision(CDOID id, long timeStamp);
}
