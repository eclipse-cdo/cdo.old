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


import org.eclipse.net4j.transport.Channel;
import org.eclipse.net4j.transport.Connector;

import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.cdo.client.PackageManager;
import org.eclipse.emf.cdo.client.ResourceInfo;
import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.client.protocol.ClientCDOResProtocolImpl;
import org.eclipse.emf.cdo.examples.client.ResourceCache;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.io.IOException;


/**
 * The main plugin class to be used in the desktop.
 */
public class ExampleClientPlugin extends AbstractPlugin
{
  public static final String CONTEXT_PATH = "META-INF/";

  //The shared instance.
  private static ExampleClientPlugin plugin;

  private static Connector cachedConnector;

  private static Container container;

  private static Container clientContainer;

  private static ResourceCache resourceCache;

  /**
   * The constructor.
   */
  public ExampleClientPlugin()
  {
    if (plugin == null) plugin = this;
  }

  /**
   * Returns the shared instance.
   */
  public static ExampleClientPlugin getDefault()
  {
    return plugin;
  }

  protected void doStart() throws Exception
  {
  }

  protected void doStop() throws Exception
  {
    if (resourceCache != null)
    {
      resourceCache.dispose();
      resourceCache = null;
    }

    if (cachedConnector != null)
    {
      cachedConnector.stop();
      cachedConnector = null;
    }

    if (clientContainer != null)
    {
      clientContainer.stop();
      clientContainer = null;
    }

    if (container != null)
    {
      container.stop();
      container = null;
    }

    plugin = null;
  }

  public static Container getContainer()
  {
    if (container == null)
    {
      String baseResourcePath;

      try
      {
        baseResourcePath = getBundleLocation(getDefault().getBundle());
      }
      catch (IOException ex)
      {
        throw new ContainerCreationException("Error while computing location of bundle "
            + getDefault().getBundle(), ex);
      }

      String location = CONTEXT_PATH + "common.xml";
      String name = "common";
      Container parent = null;
      ClassLoader classLoader = getDefault().getClassLoader();
      container = new ContainerImpl(baseResourcePath, location, name, parent, classLoader);
    }

    return container;
  }

  public static Container getClientContainer()
  {
    if (clientContainer == null)
    {
      String baseResourcePath;

      try
      {
        baseResourcePath = getBundleLocation(getDefault().getBundle());
      }
      catch (IOException ex)
      {
        throw new ContainerCreationException("Error while computing location of bundle "
            + getDefault().getBundle(), ex);
      }

      String location = CONTEXT_PATH + "client.xml";
      String name = "client";
      Container parent = getContainer();
      ClassLoader classLoader = getDefault().getClassLoader();
      clientContainer = new ContainerImpl(baseResourcePath, location, name, parent, classLoader);
    }

    return clientContainer;
  }

  public static Connector getConnector()
  {
    if (cachedConnector == null)
    {
      cachedConnector = (Connector) getClientContainer().getBean("connector");
    }

    return cachedConnector;
  }

  public static ResourceManager createResourceManager(ResourceSet resourceSet)
  {
    ResourceManager resourceManager = (ResourceManager) getClientContainer().getBean(
        "resourceManager");
    resourceManager.setResourceSet(resourceSet);

    try
    {
      resourceManager.start();
    }
    catch (Exception ex)
    {
      getDefault().error("Problem while starting ResourceManager " + resourceManager, ex);
    }

    return resourceManager;
  }

  public static PackageManager getPackageManager()
  {
    PackageManager packageManager = (PackageManager) getClientContainer().getBean("packageManager");
    return packageManager;
  }

  public static ResourceCache getResourceCache()
  {
    if (resourceCache == null)
    {
      ClientCDOResProtocolImpl protocol = (ClientCDOResProtocolImpl) getClientContainer().getBean(
          "clientCDOResProtocol");
      resourceCache = new ResourceCacheImpl(protocol, getConnector());
    }

    return resourceCache;
  }

  public static ResourceCache createResourceCache(final ResourceManager resourceManager)
  {
    return new ResourceCache()
    {
      public List<ResourceInfo> getAllResources()
      {
        List<ResourceInfo> result = new ArrayList<ResourceInfo>();
        EList resources = resourceManager.getResourceSet().getResources();
        for (Iterator it = resources.iterator(); it.hasNext();)
        {
          Resource resource = (Resource) it.next();
          if (resource instanceof CDOResource)
          {
            CDOResource cdoResource = (CDOResource) resource;
            cdoResource.getPath();
            result.add(cdoResource.getInfo());
          }
        }

        return result;
      }

      public void dispose()
      {
      }

      public Channel getChannel()
      {
        throw new UnsupportedOperationException();
      }

      public void addListener(ResourceCache.Listener listener)
      {
      }

      public void removeListener(ResourceCache.Listener listener)
      {
      }
    };
  }
}
