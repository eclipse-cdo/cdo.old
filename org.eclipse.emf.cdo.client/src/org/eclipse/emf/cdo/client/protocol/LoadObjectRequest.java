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


public class LoadObjectRequest extends AbstractDataRequest
{
  private long oid;

  public LoadObjectRequest(long oid)
  {
    this.oid = oid;
  }

  public short getSignalId()
  {
    return CDOProtocol.LOAD_OBJECT;
  }

  public void request()
  {
    transmitLong(oid);
  }

  public Object confirm()
  {
    EObject firstObject = null;

    for (;;)
    {
      long oid = receiveLong();
      if (oid == 0)
      {
        break;
      }

      int oca = receiveInt();
      int classifierId = receiveInt();

      ResourceManager resourceManager = getResourceManager();
      resourceManager.stopRequestingObjects();
      EObject object = receiveObject(oid, oca, classifierId);
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
