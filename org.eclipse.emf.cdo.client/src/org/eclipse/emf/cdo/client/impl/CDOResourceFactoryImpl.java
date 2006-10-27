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
package org.eclipse.emf.cdo.client.impl;


import org.eclipse.net4j.util.om.ContextTracer;

import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.cdo.client.ResourceInfo;
import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.client.internal.CDOClient;
import org.eclipse.emf.cdo.client.protocol.ClientCDOProtocolImpl;
import org.eclipse.emf.cdo.core.CDOProtocol;
import org.eclipse.emf.cdo.core.util.StringHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;

import java.util.Properties;

import java.io.IOException;


public class CDOResourceFactoryImpl implements Resource.Factory
{
  private static final ContextTracer TRACER = new ContextTracer(CDOClient.DEBUG_RESOURCE,
      CDOResourceFactoryImpl.class);

  protected ResourceManager resourceManager;

  public CDOResourceFactoryImpl(ResourceManager resourceManager)
  {
    this.resourceManager = resourceManager;
  }

  public ResourceManager getResourceManager()
  {
    return resourceManager;
  }

  public Resource createResource(URI uri)
  {
    if (TRACER.isEnabled())
    {
      TRACER.trace("Creating resource from URI " + uri);
    }

    try
    {
      if (!CDOProtocol.PROTOCOL_NAME.equals(uri.scheme()))
      {
        return createResourceFromFile(uri.path().substring("/resource".length()));
      }

      int rid = parseRID(uri.authority());
      if (rid != CDOProtocol.UNKNOWN_RID)
      {
        return createResourceFromRID(rid);
      }
      else
      {
        return createResourceFromPath(uri.path());
      }
    }
    catch (Exception ex)
    {
      CDOClient.LOG.error(ex);
      return null;
    }
  }

  private Resource createResourceFromFile(String fileName) throws Exception
  {
    String path;

    try
    {
      IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(fileName));
      Properties properties = new Properties();

      try
      {
        properties.load(file.getContents());
      }
      catch (CoreException ex)
      {
        ex.printStackTrace();
        return null;
      }

      String resourcePath = properties.getProperty("cdo.resource", "");
      if (resourcePath.length() != 0)
      {
        path = resourcePath;
      }
      else
      {
        String prefix = properties.getProperty("cdo.prefix", "");
        String replace = properties.getProperty("cdo.replace", "");

        if (fileName.startsWith(prefix))
        {
          path = replace + StringHelper.removePrefix(fileName, prefix);
        }

        path = StringHelper.removeSuffix(fileName, ".cdo");
      }
    }
    catch (IOException ex)
    {
      CDOClient.LOG.error("Error while creating CDO resource", ex);
      return null;
    }

    return createResourceFromPath(path);
  }

  private CDOResource createResourceFromPath(String path) throws Exception
  {
    if (TRACER.isEnabled())
    {
      TRACER.trace("Creating resource with path " + path);
    }

    int rid = ClientCDOProtocolImpl.requestResourcePath(resourceManager.getChannel(), path);
    boolean existing = rid > 0;
    if (!existing)
    {
      rid = -rid;
    }

    return createResource(rid, path, existing);
  }

  private CDOResource createResourceFromRID(int rid)
  {
    if (TRACER.isEnabled())
    {
      TRACER.trace("Creating resource with RID " + rid);
    }

    return createResource(rid, null, true);
  }

  private CDOResource createResource(int rid, String path, boolean existing)
  {
    ResourceInfo resourceInfo = new ResourceInfoImpl(path, rid, existing);
    CDOResource resource = new CDOResourceImpl(resourceInfo, resourceManager);
    resourceManager.registerResource(resource);
    resource.eAdapters().add(resourceManager.getTransaction());
    return resource;
  }

  public static URI formatURI(String path)
  {
    return URI.createURI(CDOProtocol.PROTOCOL_SCHEME + path);
  }

  public static URI formatURI(int rid)
  {
    return formatURI(String.valueOf(rid));
  }

  public static int parseRID(String path)
  {
    if (path == null || path.length() == 0)
    {
      return CDOProtocol.UNKNOWN_RID;
    }

    try
    {
      return Integer.parseInt(path);
    }
    catch (NumberFormatException ex)
    {
      return CDOProtocol.UNKNOWN_RID;
    }
  }
}
