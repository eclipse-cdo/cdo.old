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


import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.core.Indication;
import org.eclipse.net4j.core.Request;
import org.eclipse.net4j.spring.ValidationException;
import org.eclipse.net4j.util.ImplementationError;

import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.cdo.client.PackageInfo;
import org.eclipse.emf.cdo.client.PackageManager;
import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.core.protocol.AbstractCDOProtocol;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.Resource;

import java.util.Iterator;
import java.util.Set;


public class ClientCDOProtocolImpl extends AbstractCDOProtocol
{
  protected PackageManager packageManager;

  public int getType()
  {
    return CLIENT;
  }

  public PackageManager getPackageManager()
  {
    return packageManager;
  }

  public void setPackageManager(PackageManager packageManager)
  {
    doSet("packageManager", packageManager);
  }

  public Indication createIndication(short signalId)
  {
    switch (signalId)
    {
      case INVALIDATE_OBJECT:
        return new InvalidateObjectIndication();

      default:
        throw new ImplementationError("Invalid " + PROTOCOL_NAME + " signalId: " + signalId);
    }
  }

  /**
   * @return Returns the associated ResourceManager for the given channel.
   * It is needed to dispatch notifications of the server to the resource.
   */
  public static ResourceManager getResourceManager(Channel channel)
  {
    assertValidChannel(channel);
    ResourceManager channelData = (ResourceManager) channel.getProtocolData();
    if (channelData == null)
    {
      throw new ImplementationError("ChannelData has not been set");
    }

    return channelData;
  }

  public static void setResourceManager(Channel channel, ResourceManager resourceManager)
  {
    assertValidChannel(channel);
    if (channel.getProtocolData() != null)
    {
      throw new ImplementationError("ChannelData has already been set");
    }

    channel.setProtocolData(resourceManager);
  }

  public static boolean requestAnnouncePackage(Channel channel, PackageInfo packageInfo)
  {
    assertValidChannel(channel);
    Request signal = new AnnouncePackageRequest(packageInfo);
    Object returnValue = channel.transmit(signal);
    return returnValue != null && returnValue instanceof Boolean
        && ((Boolean) returnValue).booleanValue();
  }

  public static void requestDescribePackage(Channel channel, PackageInfo packageInfo)
  {
    assertValidChannel(channel);
    Request signal = new DescribePackageRequest(packageInfo);
    channel.transmit(signal);
  }

  public static int requestResourcePath(Channel channel, String path)
  {
    assertValidChannel(channel);
    Request signal = new ResourcePathRequest(path);
    return ((Integer) channel.transmit(signal)).intValue();
  }

  public static String requestResourceRID(Channel channel, int rid)
  {
    assertValidChannel(channel);
    Request signal = new ResourceRIDRequest(rid);
    return (String) channel.transmit(signal);
  }

  public static Set requestQueryExtent(Channel channel, int cid, boolean exactMatch, int rid)
  {
    assertValidChannel(channel);
    Request signal = new QueryExtentRequest(cid, exactMatch, rid);
    return (Set) channel.transmit(signal);
  }

  public static Set requestQueryExtent(Channel channel, int cid, boolean exactMatch)
  {
    return requestQueryExtent(channel, cid, exactMatch, GLOBAL_EXTENT);
  }

  public static Set requestQueryExtent(Channel channel, int cid)
  {
    return requestQueryExtent(channel, cid, false);
  }

  public static EList requestQueryXRefs(Channel channel, long oid, int rid)
  {
    assertValidChannel(channel);
    Request signal = new QueryXRefsRequest(oid, rid);
    return (EList) channel.transmit(signal);
  }

  public static void requestLoadResource(Channel channel, int rid, PackageManager packageManager)
  {
    assertValidChannel(channel);
    packageManager.announceNewPackages(channel);

    Request signal = new LoadResourceRequest(rid);
    channel.transmit(signal);

    postProcessNewResources(channel);
  }

  private static void postProcessNewResources(Channel channel)
  {
    ResourceManager resourceManager = getResourceManager(channel);
    EList resources = resourceManager.getResourceSet().getResources();

    for (Iterator iter = resources.iterator(); iter.hasNext();)
    {
      Resource resource = (Resource) iter.next();
      if (resource instanceof CDOResource)
      {
        CDOResource cdoResource = (CDOResource) resource;
        if (cdoResource.getPath() == null)
        {
          String path = ClientCDOProtocolImpl.requestResourceRID(channel, cdoResource.getRID());
          if (path == null)
          {
            throw new ImplementationError("path == null");
          }

          resourceManager.registerResourcePath(cdoResource, path);
          ClientCDOProtocolImpl.requestLoadResource(channel, cdoResource.getRID(), resourceManager
              .getPackageManager());
        }
      }
    }
  }

  public static void requestLoad(Channel channel, long oid)
  {
    assertValidChannel(channel);
    Request signal = new LoadObjectRequest(oid);
    channel.transmit(signal);

    postProcessNewResources(channel);
  }

  public static boolean requestCommit(Channel channel, ChangeDescription changeDescription,
      PackageManager packageManager)
  {
    assertValidChannel(channel);
    packageManager.announceNewPackages(channel);

    Request signal = new CommitTransactionRequest(changeDescription);
    Object result = channel.transmit(signal);
    return ((Boolean) result).booleanValue();
  }

  protected void validate() throws ValidationException
  {
    super.validate();
    assertNotNull("packageManager");
  }
}
