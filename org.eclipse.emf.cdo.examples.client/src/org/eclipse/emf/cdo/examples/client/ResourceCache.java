package org.eclipse.emf.cdo.example.client;


import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.core.Connector;

import org.eclipse.emf.cdo.client.ResourceInfo;
import org.eclipse.emf.cdo.client.impl.ResourceInfoImpl;
import org.eclipse.emf.cdo.client.protocol.CdoResClientProtocolImpl;
import org.eclipse.emf.cdo.client.protocol.CdoResListener;
import org.eclipse.emf.cdo.core.CdoResProtocol;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;


public class ResourceCache implements CdoResListener
{
  private CdoResClientProtocolImpl protocol;

  private Connector connector;

  private Channel channel;

  private List<ResourceInfo> allResources = new ArrayList();

  private List<Listener> listeners = new ArrayList();

  public ResourceCache(CdoResClientProtocolImpl protocol, Connector connector)
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
        channel = connector.addChannel(CdoResProtocol.PROTOCOL_NAME);

        List<ResourceInfo> resources = CdoResClientProtocolImpl.queryAllResources(channel);
        if (resources != null)
        {
          for (ResourceInfo resourceInfo : resources)
          {
            addResource(resourceInfo);
          }
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

  public void notifyResourceAdded(Channel channel, int rid, String path)
  {
    if (channel == this.channel)
    {
      addResource(new ResourceInfoImpl(path, rid, true));
    }
  }

  public void notifyResourceRemoved(Channel channel, int rid, String path)
  {
    if (channel == this.channel)
    {
      removeResource(new ResourceInfoImpl(path, rid, true));
    }
  }

  private void addResource(ResourceInfo resourceInfo)
  {
    synchronized (allResources)
    {
      if (!allResources.contains(resourceInfo))
      {
        allResources.add(resourceInfo);
      }
      else
      {
        resourceInfo = null;
      }
    }

    if (resourceInfo != null)
    {
      for (Listener listener : listeners)
      {
        listener.notifyResourceAdded(this, resourceInfo);
      }
    }
  }

  private void removeResource(ResourceInfo resourceInfo)
  {
    synchronized (allResources)
    {
      if (!allResources.remove(resourceInfo))
      {
        resourceInfo = null;
      }
    }

    if (resourceInfo != null)
    {
      for (Listener listener : listeners)
      {
        listener.notifyResourceRemoved(this, resourceInfo);
      }
    }
  }


  public static interface Listener
  {
    public void notifyResourceAdded(ResourceCache manager, ResourceInfo resourceInfo);

    public void notifyResourceRemoved(ResourceCache manager, ResourceInfo resourceInfo);
  }
}
