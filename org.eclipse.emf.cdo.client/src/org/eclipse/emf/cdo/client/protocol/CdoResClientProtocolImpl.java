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
import org.eclipse.emf.cdo.core.protocol.ResourceChangeInfo;

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
      case RESOURCES_CHANGED:
        return new ResourcesChangedIndication();

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

  public void resourcesChanged(Channel channel, List<ResourceChangeInfo> infos)
  {
    for (CdoResListener listener : listeners)
    {
      listener.notifyResourcesChanged(channel, infos);
    }
  }

  public static List<ResourceInfo> queryAllResources(Channel channel)
  {
    assertValidChannel(channel);
    Request signal = new QueryAllResourcesRequest();
    return (List<ResourceInfo>) channel.transmit(signal);
  }
}