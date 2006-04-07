/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.client.impl;


import org.eclipse.emf.cdo.client.CDOPersistable;
import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.cdo.client.ResourceInfo;
import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.client.protocol.ClientCDOProtocolImpl;
import org.eclipse.emf.cdo.core.CDOProtocol;
import org.eclipse.emf.cdo.core.OIDEncoder;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.Map;


public class CDOResourceImpl extends ResourceImpl implements CDOResource
{
  protected ResourceInfo resourceInfo;

  protected ResourceManager resourceManager;

  private static long nextTempOIDFragment;

  private static final Logger logger = Logger.getLogger(CDOResourceImpl.class);

  public CDOResourceImpl(ResourceInfo resourceInfo, ResourceManager resourceManager)
  {
    super(URI.createURI(CDOProtocol.PROTOCOL_NAME + "://" + resourceInfo.getRID()));
    this.resourceInfo = resourceInfo;
    this.resourceManager = resourceManager;
  }

  public void setPath(String path)
  {
    resourceInfo.setPath(path);
  }

  public String getPath()
  {
    return resourceInfo.getPath();
  }

  public int getRID()
  {
    return resourceInfo.getRID();
  }

  public boolean isExisting()
  {
    return resourceInfo.isExisting();
  }

  public void load(Map options)
  {
    if (resourceManager.isRequestingObjects())
    {
      ClientCDOProtocolImpl.requestLoadResource(resourceManager.getChannel(), getRID(),
          resourceManager.getPackageManager());
    }
  }

  /* (non-Javadoc)
   * @see org.eclipse.emf.ecore.resource.Resource#save(java.util.Map)
   */
  public void save(Map options)
  {
    try
    {
      resourceManager.commit();
    }
    catch (Throwable t)
    {
      logger.error("Error while committing", t);
    }
  }

  public synchronized EObject getEObjectByID(String id)
  {
    OIDEncoder oidEncoder = resourceManager.getPackageManager().getOidEncoder();
    long oidFragment = Long.parseLong(id);
    long oid = oidEncoder.getOID(getRID(), oidFragment);
    EObject object = resourceManager.getObject(oid);

    if (object != null)
    {
      if (logger.isDebugEnabled())
      {
        logger.debug("Object " + oid + " found --> " + ResourceManagerImpl.getLabel(object));
      }
    }
    else
    {
      object = resourceManager.getProxyObject(oid);
      //
      //      long counter = 0;
      //      while (resourceManager.isRequestingObjects())
      //      {
      //        if (logger.isDebugEnabled() && (++counter % 5) == 0)
      //        {
      //          logger.debug("Object " + oid + " not found --> requesting...");
      //        }
      //
      //        try
      //        {
      //          Thread.sleep(200);
      //        }
      //        catch (InterruptedException ex)
      //        {
      //          logger.error("Thread interrupted", ex);
      //          break;
      //        }
      //      }
    }

    return object;
  }

  public void attached(EObject eObject)
  {
    attach(eObject);

    for (Iterator tree = eObject.eAllContents(); tree.hasNext();)
    {
      EObject child = (EObject) tree.next();
      attach(child);
    }
  }

  private void attach(EObject eObject)
  {
    // TODO Check if this can be done later in commit
    if (eObject instanceof CDOPersistable)
    {
      CDOPersistable cDOPersistable = (CDOPersistable) eObject;

      if (cDOPersistable.cdoGetOID() == 0)
      {
        long oid = getNextTempOID();

        if (logger.isDebugEnabled())
        {
          logger.debug("Attaching object " + eObject + " with oid " + oid);
        }

        cDOPersistable.cdoSetOID(oid, null);
        cDOPersistable.cdoSetOCA(CDOPersistable.NOT_LOADED_YET);
      }
    }
    else
    {
      logger.warn("Attached object is no CDOPersistable: " + eObject);
    }
  }

  private long getNextTempOID()
  {
    OIDEncoder oidEncoder = resourceManager.getPackageManager().getOidEncoder();
    return -oidEncoder.getOID(getRID(), ++nextTempOIDFragment);
  }

  public ResourceManager getResourceManager()
  {
    return resourceManager;
  }
}