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


import org.eclipse.net4j.transport.Channel;
import org.eclipse.net4j.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.stream.ExtendedDataInput;
import org.eclipse.net4j.util.stream.ExtendedDataInputStream;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.client.impl.ResourceManagerImpl;
import org.eclipse.emf.cdo.client.internal.CDOClient;
import org.eclipse.emf.cdo.core.CDOProtocol;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import java.io.IOException;


public class LoadResourceRequest extends AbstractDataRequest<EObject>
{
  private static final ContextTracer TRACER = new ContextTracer(CDOClient.DEBUG_PROTOCOL,
      LoadResourceRequest.class);

  protected int rid;

  public LoadResourceRequest(Channel channel, int rid)
  {
    super(channel);
    this.rid = rid;
  }

  @Override
  protected short getSignalID()
  {
    return CDOProtocol.LOAD_RESOURCE;
  }

  @Override
  protected void requesting(ExtendedDataOutputStream out) throws IOException
  {
    if (TRACER.isEnabled())
    {
      TRACER.trace("Loading rid " + rid);
    }

    out.writeInt(rid);
  }

  @Override
  protected EObject confirming(ExtendedDataInputStream in) throws IOException
  {
    EObject firstObject = null;
    for (;;)
    {
      long oid = in.readLong();
      if (oid == CDOProtocol.NO_MORE_OBJECTS) break;

      int oca = in.readInt();
      int cid = in.readInt();

      ResourceManager resourceManager = getResourceManager();
      resourceManager.stopRequestingObjects();

      EObject object = receiveObject(in, oid, oca, cid);

      CDOResource resource = getResource(rid);
      resource.getContents().add(object);

      resourceManager.startRequestingObjects();

      if (firstObject == null)
      {
        firstObject = object;
      }
    }

    return firstObject;
  }

  @Override
  protected EObject provideObject(EClass eClass, long oid, int oca)
  {
    if (TRACER.isEnabled())
    {
      TRACER.trace("Providing object " + eClass.getName() + " "
          + getPackageManager().getOidEncoder().toString(oid) + "v" + oca);
    }

    int rid = getPackageManager().getOidEncoder().getRID(oid);
    ResourceManager resourceManager = getResourceManager();
    CDOResource cdoResource = resourceManager.getResource(rid);

    EObject object = getProxyObject(oid);
    if (object == null)
    {
      object = resourceManager.createEObject(eClass, oid, oca, cdoResource);
      resourceManager.registerObject(oid, object);
    }
    else
    {
      ResourceManagerImpl.initPersistable(object, cdoResource, oid, oca);
      ((InternalEObject) object).eSetProxyURI(null);
    }

    return object;
  }

  @Override
  protected void receiveContainers(ExtendedDataInput in) throws IOException
  {
    // Don't expect containment info to be sent for root objects!
  }
}
