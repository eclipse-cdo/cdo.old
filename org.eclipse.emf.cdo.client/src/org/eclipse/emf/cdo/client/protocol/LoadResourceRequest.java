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


import org.eclipse.net4j.util.ImplementationError;

import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.client.impl.ResourceManagerImpl;
import org.eclipse.emf.cdo.core.CDOProtocol;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;


public class LoadResourceRequest extends AbstractDataRequest
{
  protected int rid;

  public LoadResourceRequest(int rid)
  {
    this.rid = rid;
  }

  public short getSignalId()
  {
    return CDOProtocol.LOAD_RESOURCE;
  }

  public void request()
  {
    if (isDebugEnabled())
    {
      debug("Loading rid " + rid);
    }

    transmitInt(rid);
  }

  public Object confirm()
  {
    EObject firstObject = null;

    for (;;)
    {
      long oid = receiveLong();
      if (oid == CDOProtocol.NO_MORE_OBJECTS) break;

      int oca = receiveInt();
      int cid = receiveInt();

      ResourceManager resourceManager = getResourceManager();
      resourceManager.stopRequestingObjects();

      EObject object = receiveObject(oid, oca, cid);

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
    if (isDebugEnabled())
      debug("Providing object " + eClass.getName() + " "
          + getPackageManager().getOidEncoder().toString(oid) + "v" + oca);

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
  protected void receiveContainers()
  {
    // Don't expect containment info to be sent for root objects!
  }
}
