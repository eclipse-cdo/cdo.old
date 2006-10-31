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

import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.cdo.client.PackageInfo;
import org.eclipse.emf.cdo.client.PackageManager;
import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.client.internal.CDOClient;
import org.eclipse.emf.cdo.core.ImplementationError;
import org.eclipse.emf.cdo.core.protocol.AbstractCDOProtocol;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.internal.net4j.transport.AbstractProtocolFactory;

import java.util.Iterator;
import java.util.Set;


public class ClientCDOProtocolImpl extends AbstractCDOProtocol
{
  public static final long REQUEST_TIMEOUT = 10 * 60 * 1000;

  protected PackageManager packageManager;

  protected ResourceManager resourceManager;

  public ClientCDOProtocolImpl(Channel channel, PackageManager packageManager,
      ResourceManager resourceManager)
  {
    super(channel);
    this.packageManager = packageManager;
    this.resourceManager = resourceManager;
  }

  public PackageManager getPackageManager()
  {
    return packageManager;
  }

  public ResourceManager getResourceManager()
  {
    return resourceManager;
  }

  @Override
  protected SignalReactor createSignalReactor(short signalID)
  {
    switch (signalID)
    {
      case REMOVAL_NOTIFICATION:
        return new RemovalNotificationIndication(resourceManager);

      case INVALIDATION_NOTIFICATION:
        return new InvalidationNotificationIndication(resourceManager);

      default:
        throw new ImplementationError("Invalid " + PROTOCOL_NAME + " signalID: " + signalID);
    }
  }

  public static boolean requestAnnouncePackage(Channel channel, PackageInfo packageInfo)
      throws Exception
  {
    AnnouncePackageRequest signal = new AnnouncePackageRequest(channel, packageInfo);
    Boolean returnValue = signal.send(REQUEST_TIMEOUT);
    return returnValue != null && ((Boolean) returnValue).booleanValue();
  }

  public static void requestDescribePackage(Channel channel, PackageInfo packageInfo)
      throws Exception
  {
    DescribePackageRequest signal = new DescribePackageRequest(channel, packageInfo);
    signal.send(REQUEST_TIMEOUT);
  }

  public static int requestResourcePath(Channel channel, String path) throws Exception
  {
    ResourcePathRequest signal = new ResourcePathRequest(channel, path);
    return signal.send(REQUEST_TIMEOUT);
  }

  public static String requestResourceRID(Channel channel, int rid) throws Exception
  {
    ResourceRIDRequest signal = new ResourceRIDRequest(channel, rid);
    return signal.send(REQUEST_TIMEOUT);
  }

  public static Set<EObject> requestQueryExtent(Channel channel, int cid, boolean exactMatch,
      int rid) throws Exception
  {
    QueryExtentRequest signal = new QueryExtentRequest(channel, cid, exactMatch, rid);
    return signal.send(REQUEST_TIMEOUT);
  }

  public static Set requestQueryExtent(Channel channel, int cid, boolean exactMatch)
      throws Exception
  {
    return requestQueryExtent(channel, cid, exactMatch, GLOBAL_EXTENT);
  }

  public static Set requestQueryExtent(Channel channel, int cid) throws Exception
  {
    return requestQueryExtent(channel, cid, false);
  }

  public static EList requestQueryXRefs(Channel channel, long oid, int rid) throws Exception
  {
    QueryXRefsRequest signal = new QueryXRefsRequest(channel, oid, rid);
    return signal.send(REQUEST_TIMEOUT);
  }

  public static EObject requestLoadResource(Channel channel, int rid, PackageManager packageManager)
      throws Exception
  {
    packageManager.announceNewPackages(channel);
    LoadResourceRequest signal = new LoadResourceRequest(channel, rid);
    EObject firstObject = signal.send(REQUEST_TIMEOUT);
    postProcessNewResources(channel);
    return firstObject;
  }

  private static void postProcessNewResources(Channel channel) throws Exception
  {
    ResourceManager resourceManager = ((ClientCDOProtocolImpl) channel.getReceiveHandler())
        .getResourceManager();
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

  public static EObject requestLoad(Channel channel, long oid) throws Exception
  {
    LoadObjectRequest signal = new LoadObjectRequest(channel, oid);
    EObject firstObject = signal.send(REQUEST_TIMEOUT);
    postProcessNewResources(channel);
    return firstObject;
  }

  public static boolean requestCommit(Channel channel, ChangeDescription changeDescription,
      PackageManager packageManager) throws Exception
  {
    packageManager.announceNewPackages(channel);
    CommitTransactionRequest signal = new CommitTransactionRequest(channel, changeDescription);
    Boolean success = signal.send(REQUEST_TIMEOUT);
    return success;
  }

  @Override
  protected void onAboutToActivate() throws Exception
  {
    super.onAboutToActivate();
    if (packageManager == null)
    {
      throw new IllegalStateException("packageManager == null");
    }

    if (resourceManager == null)
    {
      throw new IllegalStateException("resourceManager == null");
    }
  }

  @Override
  protected void onDeactivate() throws Exception
  {
    packageManager = null;
    super.onDeactivate();
  }


  /**
   * @author Eike Stepper
   */
  public static final class Factory extends AbstractProtocolFactory
  {
    private PackageManager packageManager;

    public Factory(PackageManager packageManager)
    {
      this.packageManager = packageManager;
    }

    public Protocol createProtocol(Channel channel, Object protocolData)
    {
      ClientCDOProtocolImpl protocol = new ClientCDOProtocolImpl(channel, packageManager,
          (ResourceManager) protocolData);
      try
      {
        protocol.activate();
      }
      catch (Exception ex)
      {
        CDOClient.LOG.error(ex);
        return null;
      }

      return protocol;
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
