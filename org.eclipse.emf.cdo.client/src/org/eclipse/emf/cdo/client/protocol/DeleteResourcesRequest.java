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
package org.eclipse.emf.cdo.client.protocol;


import org.eclipse.net4j.core.impl.AbstractRequestWithConfirmation;

import org.eclipse.emf.cdo.core.CDOResProtocol;
import org.eclipse.emf.cdo.core.CDOResSignals;

import java.util.Set;


public class DeleteResourcesRequest extends AbstractRequestWithConfirmation
{
  private Set<Integer> rids;

  public DeleteResourcesRequest(Set<Integer> rids)
  {
    this.rids = rids;
  }

  public short getSignalId()
  {
    return CDOResSignals.DELETE_RESOURCES;
  }

  public void request()
  {
    for (Integer rid : rids)
    {
      if (isDebugEnabled())
      {
        debug("Deleting rid " + rid);
      }

      transmitInt(rid);
    }

    transmitInt(CDOResProtocol.NO_MORE_RESOURCES);
  }

  public Object confirm()
  {
    boolean ok = receiveBoolean();
    if (isDebugEnabled())
    {
      debug("Deleted resources: " + ok);
    }

    return ok;
  }
}
