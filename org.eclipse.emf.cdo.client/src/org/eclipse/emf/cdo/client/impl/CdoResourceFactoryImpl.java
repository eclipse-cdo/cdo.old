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
package org.eclipse.emf.cdo.client.impl;


import org.eclipse.net4j.util.StringHelper;

import org.eclipse.emf.cdo.client.CdoResource;
import org.eclipse.emf.cdo.client.ResourceInfo;
import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.client.protocol.CdoClientProtocolImpl;
import org.eclipse.emf.cdo.core.CdoProtocol;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;

import org.apache.log4j.Logger;

import java.util.Properties;

import java.io.IOException;


public class CdoResourceFactoryImpl implements Resource.Factory
{
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(CdoResourceFactoryImpl.class);

  protected ResourceManager resourceManager;

  public CdoResourceFactoryImpl(ResourceManager resourceManager)
  {
    this.resourceManager = resourceManager;
  }

  public ResourceManager getResourceManager()
  {
    return resourceManager;
  }

  public Resource createResource(URI uri)
  {
    if (logger.isDebugEnabled()) logger.debug("Creating resource from URI " + uri);

    if (!CdoProtocol.PROTOCOL_NAME.equals(uri.scheme()))
    {
      return createResourceFromFile(uri.path().substring("/resource".length()));
    }

    int rid = parseRID(uri.authority());
    if (rid != CdoProtocol.UNKNOWN_RID)
    {
      return createResourceFromRid(rid);
    }
    else
    {
      return createResourceFromPath(uri.path());
    }
  }

  private Resource createResourceFromFile(String fileName)
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
      logger.warn("Error while creating CDO resource", ex);
      return null;
    }

    return createResourceFromPath(path);
  }

  private CdoResource createResourceFromPath(String path)
  {
    if (logger.isDebugEnabled())
    {
      logger.debug("Creating resource with path " + path);
    }

    int rid = CdoClientProtocolImpl.requestResourcePath(resourceManager.getChannel(), path);
    boolean existing = rid > 0;

    if (!existing)
    {
      rid = -rid;
    }

    return createResource(rid, path, existing);
  }

  private CdoResource createResourceFromRid(int rid)
  {
    if (logger.isDebugEnabled()) logger.debug("Creating resource with RID " + rid);

    String path = null;
    boolean existing = true;

    // Only ask for resource info, when not in the context of a ReceivingLoadResponse!!!
    if (resourceManager.isRequestingObjects())
    {
      path = CdoClientProtocolImpl.requestResourceRid(resourceManager.getChannel(), rid);
      existing = path == null;

      if (!existing)
      {
        return null;
      }
    }

    return createResource(rid, path, existing);
  }

  private CdoResource createResource(int rid, String path, boolean existing)
  {
    ResourceInfo resourceInfo = new ResourceInfoImpl(path, rid, existing);
    CdoResource resource = new CdoResourceImpl(resourceInfo, resourceManager);
    resourceManager.registerResource(resource);
    return resource;
  }

  public static URI formatURI(String path)
  {
    return URI.createURI(CdoProtocol.PROTOCOL_SCHEME + path);
  }

  public static URI formatURI(int rid)
  {
    return formatURI(String.valueOf(rid));
  }

  public static int parseRID(String path)
  {
    if (path == null || path.length() == 0)
    {
      return CdoProtocol.UNKNOWN_RID;
      //throw new IllegalArgumentException("path == null || path.length() == 0");
    }

    try
    {
      int rid = Integer.parseInt(path);
      return rid;
    }
    catch (NumberFormatException ex)
    {
      return CdoProtocol.UNKNOWN_RID;
    }
  }
}