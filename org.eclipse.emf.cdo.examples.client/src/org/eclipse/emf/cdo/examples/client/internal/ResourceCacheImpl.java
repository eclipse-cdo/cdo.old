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
package org.eclipse.emf.cdo.examples.client.internal;


import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.core.Connector;

import org.eclipse.emf.cdo.client.ResourceInfo;
import org.eclipse.emf.cdo.client.impl.ResourceInfoImpl;
import org.eclipse.emf.cdo.client.protocol.CDOResListener;
import org.eclipse.emf.cdo.client.protocol.ClientCDOResProtocolImpl;
import org.eclipse.emf.cdo.core.CDOResProtocol;
import org.eclipse.emf.cdo.core.protocol.ResourceChangeInfo;
import org.eclipse.emf.cdo.examples.client.ResourceCache;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;


public class ResourceCacheImpl implements ResourceCache, CDOResListener
{
  private ClientCDOResProtocolImpl protocol;

  private Connector connector;

  private Channel channel;

  private List<ResourceInfo> allResources = new ArrayList<ResourceInfo>();

  private List<ResourceCache.Listener> listeners = new ArrayList<ResourceCache.Listener>();

  public ResourceCacheImpl(ClientCDOResProtocolImpl protocol, Connector connector)
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

  /* (non-Javadoc)
   * @see org.eclipse.emf.cdo.examples.client.ResourceCache#addListener(org.eclipse.emf.cdo.examples.client.ResourceCacheImpl.Listener)
   */
  public void addListener(ResourceCache.Listener listener)
  {
    listeners.add(listener);
  }

  /* (non-Javadoc)
   * @see org.eclipse.emf.cdo.examples.client.ResourceCache#removeListener(org.eclipse.emf.cdo.examples.client.ResourceCacheImpl.Listener)
   */
  public void removeListener(ResourceCache.Listener listener)
  {
    listeners.remove(listener);
  }

  /* (non-Javadoc)
   * @see org.eclipse.emf.cdo.examples.client.ResourceCache#getAllResources()
   */
  public List<ResourceInfo> getAllResources()
  {
    return allResources;
  }

  public Channel getChannel()
  {
    return channel;
  }

  /* (non-Javadoc)
   * @see org.eclipse.emf.cdo.examples.client.ResourceCache#dispose()
   */
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
    for (ResourceCache.Listener listener : listeners)
    {
      listener.notifyResourcesChanged(this);
    }
  }
}
