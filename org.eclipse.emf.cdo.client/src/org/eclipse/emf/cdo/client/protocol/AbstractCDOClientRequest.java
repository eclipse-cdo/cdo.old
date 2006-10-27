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


import org.eclipse.net4j.signal.RequestWithConfirmation;
import org.eclipse.net4j.transport.Channel;

import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.cdo.client.PackageManager;
import org.eclipse.emf.cdo.client.ResourceGetter;
import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.client.impl.ResourceGetterImpl;


public abstract class AbstractCDOClientRequest<RESULT> extends RequestWithConfirmation<RESULT>
{
  private ResourceGetter resourceGetter;

  public AbstractCDOClientRequest(Channel channel)
  {
    super(channel);
  }

  public PackageManager getPackageManager()
  {
    return getResourceManager().getPackageManager();
  }

  protected Channel getChannel()
  {
    return getProtocol().getChannel();
  }

  public ResourceManager getResourceManager()
  {
    return ((ClientCDOProtocolImpl) getProtocol()).getResourceManager();
  }

  protected CDOResource getResource(int rid)
  {
    return getResourceGetter().getResource(rid);
  }

  protected CDOResource getResource(long oid)
  {
    return getResourceGetter().getResource(oid);
  }

  private ResourceGetter getResourceGetter()
  {
    if (resourceGetter == null)
    {
      resourceGetter = new ResourceGetterImpl(getResourceManager());
    }

    return resourceGetter;
  }
}
