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


import org.eclipse.net4j.signal.SignalReactor;
import org.eclipse.net4j.transport.Channel;
import org.eclipse.net4j.transport.Protocol;
import org.eclipse.net4j.transport.ProtocolFactory;
import org.eclipse.net4j.transport.Connector.Type;

import org.eclipse.emf.cdo.client.ResourceInfo;
import org.eclipse.emf.cdo.core.ImplementationError;
import org.eclipse.emf.cdo.core.protocol.AbstractCDOResProtocol;
import org.eclipse.emf.cdo.core.protocol.ResourceChangeInfo;

import org.eclipse.internal.net4j.transport.AbstractProtocolFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class ClientCDOResProtocolImpl extends AbstractCDOResProtocol
{
  public static final long REQUEST_TIMEOUT = ClientCDOProtocolImpl.REQUEST_TIMEOUT;

  private List<CDOResListener> listeners = new ArrayList<CDOResListener>();

  public ClientCDOResProtocolImpl(Channel channel)
  {
    super(channel);
  }

  @Override
  protected SignalReactor createSignalReactor(short signalID)
  {
    switch (signalID)
    {
      case RESOURCES_CHANGED:
        return new ResourcesChangedIndication();

      default:
        throw new ImplementationError("Invalid " + PROTOCOL_NAME + " signalID: " + signalID);
    }
  }

  public void addListener(CDOResListener listener)
  {
    listeners.add(listener);
  }

  public void removeListener(CDOResListener listener)
  {
    listeners.remove(listener);
  }

  public void resourcesChanged(Channel channel, List<ResourceChangeInfo> infos)
  {
    for (CDOResListener listener : listeners)
    {
      listener.notifyResourcesChanged(channel, infos);
    }
  }

  public static List<ResourceInfo> queryAllResources(Channel channel) throws Exception
  {
    QueryAllResourcesRequest signal = new QueryAllResourcesRequest(channel);
    return signal.send(REQUEST_TIMEOUT);
  }

  public static boolean deleteResources(Channel channel, Set<Integer> rids) throws Exception
  {
    DeleteResourcesRequest signal = new DeleteResourcesRequest(channel, rids);
    return signal.send(REQUEST_TIMEOUT);
  }

  @Override
  protected void onDeactivate() throws Exception
  {
    listeners = null;
    super.onDeactivate();
  }


  /**
   * @author Eike Stepper
   */
  public static final class Factory extends AbstractProtocolFactory
  {
    public Protocol createProtocol(Channel channel, Object protocolData)
    {
      return new ClientCDOResProtocolImpl(channel);
    }

    public Set<Type> getConnectorTypes()
    {
      return ProtocolFactory.FOR_CLIENTS;
    }

    public String getID()
    {
      return PROTOCOL_NAME;
    }
  }
}
