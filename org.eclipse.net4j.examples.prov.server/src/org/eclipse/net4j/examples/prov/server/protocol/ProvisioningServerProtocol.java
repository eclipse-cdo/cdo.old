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
package org.eclipse.net4j.examples.prov.server.protocol;


import org.eclipse.net4j.core.Indication;
import org.eclipse.net4j.examples.prov.protocol.AbstractProvisioningProtocol;
import org.eclipse.net4j.examples.prov.server.SiteManager;
import org.eclipse.net4j.spring.ValidationException;
import org.eclipse.net4j.util.ImplementationError;

import java.nio.channels.Channel;


public class ProvisioningServerProtocol extends AbstractProvisioningProtocol
{
  private SiteManager siteManager;

  private transient Channel lockingChannel;

  public int getType()
  {
    return SERVER;
  }

  public Indication createIndication(short signalId)
  {
    switch (signalId)
    {
    case LOAD_SITE:
      return new LoadSiteIndication();

    case SAVE_SITE:
      return new SaveSiteIndication();

    case UPLOAD_ARCHIVE:
      return new UploadArchiveIndication();

    case REMOVE_FEATURE:
      return new RemoveFeatureIndication();

    default:
      throw new ImplementationError("Invalid signalId: " + signalId);
    }
  }

  public SiteManager getSiteManager()
  {
    return siteManager;
  }

  public void setSiteManager(SiteManager siteManager)
  {
    doSet("siteManager", siteManager);
  }

  public synchronized Channel getLockingChannel()
  {
    return lockingChannel;
  }

  public synchronized void setLockingChannel(Channel lockingChannel)
  {
    this.lockingChannel = lockingChannel;
  }

  public synchronized boolean isLocked()
  {
    return lockingChannel != null;
  }

  protected void validate() throws ValidationException
  {
    super.validate();
    assertNotNull("siteManager");
  }
}
