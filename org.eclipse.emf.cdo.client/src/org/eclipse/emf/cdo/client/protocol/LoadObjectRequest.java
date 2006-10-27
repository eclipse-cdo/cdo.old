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
import org.eclipse.net4j.util.om.ContextTracer;
import org.eclipse.net4j.util.stream.ExtendedDataInputStream;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.client.impl.ResourceManagerImpl;
import org.eclipse.emf.cdo.client.internal.CDOClient;
import org.eclipse.emf.cdo.core.CDOProtocol;
import org.eclipse.emf.cdo.core.ImplementationError;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import java.io.IOException;


public class LoadObjectRequest extends AbstractDataRequest<EObject>
{
  private static final ContextTracer TRACER = new ContextTracer(CDOClient.DEBUG_PROTOCOL,
      LoadObjectRequest.class);

  private long oid;

  public LoadObjectRequest(Channel channel, long oid)
  {
    super(channel);
    this.oid = oid;
  }

  @Override
  protected short getSignalID()
  {
    return CDOProtocol.LOAD_OBJECT;
  }

  @Override
  protected void requesting(ExtendedDataOutputStream out) throws IOException
  {
    if (TRACER.isEnabled())
    {
      TRACER.trace("Loading object " + getPackageManager().getOidEncoder().toString(oid));
    }

    out.writeLong(oid);
  }

  @Override
  protected EObject confirming(ExtendedDataInputStream in) throws IOException
  {
    EObject firstObject = null;
    for (;;)
    {
      long oid = in.readLong();
      if (oid == CDOProtocol.NO_MORE_OBJECTS)
      {
        break;
      }

      int oca = in.readInt();
      int classifierId = in.readInt();

      ResourceManager resourceManager = getResourceManager();
      resourceManager.stopRequestingObjects();
      EObject object = receiveObject(in, oid, oca, classifierId);
      resourceManager.startRequestingObjects();

      if (firstObject == null)
      {
        firstObject = object;
      }
    }

    return firstObject;
  }

  protected EObject provideObject(EClass eClass, long oid, int oca)
  {
    EObject object = getProxyObject(oid);
    if (object == null)
    {
      throw new ImplementationError("A proxy should be available, when requesting object data!");
    }

    int rid = getPackageManager().getOidEncoder().getRID(oid);
    CDOResource cdoResource = getResourceManager().getResource(rid);
    ResourceManagerImpl.initPersistable(object, cdoResource, oid, oca);
    ((InternalEObject) object).eSetProxyURI(null);

    return object;
  }
}
