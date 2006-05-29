/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.examples.client;


import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.core.Connector;

import org.eclipse.emf.cdo.client.ResourceInfo;
import org.eclipse.emf.cdo.client.impl.ResourceInfoImpl;
import org.eclipse.emf.cdo.client.protocol.CDOResListener;
import org.eclipse.emf.cdo.client.protocol.ClientCDOResProtocolImpl;
import org.eclipse.emf.cdo.core.CDOResProtocol;
import org.eclipse.emf.cdo.core.protocol.ResourceChangeInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;


public class ResourceCache implements CDOResListener
{
  private ClientCDOResProtocolImpl protocol;

  private Connector connector;

  private Channel channel;

  private List<ResourceInfo> allResources = new ArrayList<ResourceInfo>();

  private List<Listener> listeners = new ArrayList<Listener>();

  public ResourceCache(ClientCDOResProtocolImpl protocol, Connector connector)
  {
    this.protocol = protocol;
    this.connector = connector;
    protocol.addListener(this);
    init();
  }

  private void init()
  {
    Thread thread = Executors.defaultThreadFactory().newThread(new Runnable()
    {
      public void run()
      {
        channel = connector.addChannel(CDOResProtocol.PROTOCOL_NAME);

        List<ResourceInfo> resources = ClientCDOResProtocolImpl.queryAllResources(channel);
        if (resources != null && !resources.isEmpty())
        {
          synchronized (allResources)
          {
            for (ResourceInfo resourceInfo : resources)
            {
              allResources.add(resourceInfo);
            }
          }

          notifyListeners();
        }
      }
    });

    thread.start();
  }

  public void addListener(Listener listener)
  {
    listeners.add(listener);
  }

  public void removeListener(Listener listener)
  {
    listeners.remove(listener);
  }

  public List<ResourceInfo> getAllResources()
  {
    return allResources;
  }

  public Channel getChannel()
  {
    return channel;
  }

  public void dispose()
  {
    protocol.removeListener(this);
    protocol = null;

    if (channel != null)
    {
      try
      {
        channel.stop();
      }
      catch (Exception ex)
      {
        ex.printStackTrace();
      }
      finally
      {
        channel = null;
      }
    }
  }

  public void notifyResourcesChanged(Channel channel, List<ResourceChangeInfo> changes)
  {
    if (channel == this.channel)
    {
      boolean modified = false;
      synchronized (allResources)
      {
        for (ResourceChangeInfo change : changes)
        {
          ResourceInfo resourceInfo = new ResourceInfoImpl(change.getPath(), change.getRID(), true);
          switch (change.getChangeKind())
          {
            case ResourceChangeInfo.ADDED:
              if (!allResources.contains(resourceInfo))
              {
                allResources.add(resourceInfo);
                modified = true;
              }
              break;

            case ResourceChangeInfo.REMOVED:
              if (allResources.remove(resourceInfo))
              {
                modified = true;
              }
              break;
          }
        }
      }

      if (modified)
      {
        notifyListeners();
      }
    }
  }

  private void notifyListeners()
  {
    for (Listener listener : listeners)
    {
      listener.notifyResourcesChanged(this);
    }
  }


  public static interface Listener
  {
    public void notifyResourcesChanged(ResourceCache manager);
  }
}
