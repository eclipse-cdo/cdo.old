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
package org.eclipse.emf.cdo.client;


import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.spring.Service;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;


public interface ResourceManager extends Service
{
  public void commit();

  public void rollback();

  public ResourceSet getResourceSet();

  public void setResourceSet(ResourceSet resourceSet);

  public Channel getChannel();

  public CDOResource getResource(int rid);

  public Resource createResource(URI uri);

  public Resource getResource(URI uri, boolean loadOnDemand);

  public boolean isRequestingObjects();

  public void startRequestingObjects();

  public void stopRequestingObjects();

  public void requestObject(CDOPersistable cdoObject);

  public URI createProxyURI(long oid);

  public EObject getProxyObject(long oid);

  public void invalidateObjects(long[] oid);

  public void registerObject(long id, EObject object);

  public void reRegisterObject(EObject object, long newId);

  public EObject getObject(long oid);

  public void registerResource(CDOResource resource);

  public void registerResourcePath(CDOResource cdoResource, String path);

  public PackageManager getPackageManager();

  public void addInvalidationListener(InvalidationListener listener);

  public void removeInvalidationListener(InvalidationListener listener);


  public interface InvalidationListener
  {
    public void notifyInvalidation(ResourceManager resourceManager, long[] oids);
  }
}
