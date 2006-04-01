/*******************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Sympedia Methods and Tools.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.cdo.client.protocol;


import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.core.Indication;
import org.eclipse.net4j.core.Request;
import org.eclipse.net4j.util.ImplementationError;

import org.eclipse.emf.cdo.client.ResourceInfo;
import org.eclipse.emf.cdo.core.protocol.AbstractCdoResProtocol;

import java.util.ArrayList;
import java.util.List;


public class CdoResClientProtocolImpl extends AbstractCdoResProtocol
{
  private List<CdoResListener> listeners = new ArrayList();

  public CdoResClientProtocolImpl()
  {
  }

  public int getType()
  {
    return CLIENT;
  }

  public Indication createIndication(short signalId)
  {
    switch (signalId)
    {
      case RESOURCE_CHANGED:
        return new ResourceChangedIndication();

      default:
        throw new ImplementationError("Invalid " + PROTOCOL_NAME + " signalId: " + signalId);
    }
  }

  public void addListener(CdoResListener listener)
  {
    listeners.add(listener);
  }

  public void removeListener(CdoResListener listener)
  {
    listeners.remove(listener);
  }

  public void resourceChanged(Channel channel, int rid, String path, int changeKind)
  {
    switch (changeKind)
    {
      case ADDED:
        for (CdoResListener listener : listeners)
          listener.notifyResourceAdded(channel, rid, path);
        break;

      case REMOVED:
        for (CdoResListener listener : listeners)
          listener.notifyResourceRemoved(channel, rid, path);
        break;
    }
  }

  public static List<ResourceInfo> queryAllResources(Channel channel)
  {
    assertValidChannel(channel);
    Request signal = new QueryAllResourcesRequest();
    return (List<ResourceInfo>) channel.transmit(signal);
  }
}