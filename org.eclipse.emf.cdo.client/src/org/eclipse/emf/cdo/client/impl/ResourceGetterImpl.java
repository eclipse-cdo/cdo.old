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


import org.eclipse.net4j.util.ImplementationError;

import org.eclipse.emf.cdo.client.CdoResource;
import org.eclipse.emf.cdo.client.ResourceGetter;
import org.eclipse.emf.cdo.client.ResourceManager;


public class ResourceGetterImpl implements ResourceGetter
{
  private ResourceManager resourceManager;

  private int lastRid = 0;

  private CdoResource lastResource = null;

  public ResourceGetterImpl(ResourceManager resourceManager)
  {
    this.resourceManager = resourceManager;
  }

  /* (non-Javadoc)
   * @see org.eclipse.emf.cdo.client.impl.ResourceGetter#getResource(int)
   */
  public CdoResource getResource(int rid)
  {
    if (rid != lastRid)
    {
      CdoResource resource = resourceManager.getResource(rid);

      if (resource == null)
      {
        throw new ImplementationError("No resource for rid " + rid);
      }

      if (resource.getRid() != rid)
      {
        throw new ImplementationError("resource.getRID()= " + resource.getRid() + ", rid=" + rid);
      }

      lastResource = resource;
      lastRid = rid;
    }

    return lastResource;
  }

  /* (non-Javadoc)
   * @see org.eclipse.emf.cdo.client.impl.ResourceGetter#getResource(long)
   */
  public CdoResource getResource(long oid)
  {
    int rid = resourceManager.getPackageManager().getOidEncoder().getRID(oid);
    return getResource(rid);
  }
}
