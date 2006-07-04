/***************************************************************************
 * Copyright (c) 2004-2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
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
import org.eclipse.net4j.core.impl.AbstractIndicationWithResponse;
import org.eclipse.net4j.examples.prov.ProvisioningProtocol;
import org.eclipse.net4j.examples.prov.Site;
import org.eclipse.net4j.examples.prov.protocol.AbstractProvisioningProtocol;
import org.eclipse.net4j.examples.prov.server.SiteManager;


public class LoadSiteIndication extends AbstractIndicationWithResponse implements Indication
{
  public LoadSiteIndication()
  {
  }

  public short getSignalId()
  {
    return ProvisioningProtocol.LOAD_SITE;
  }

  public void indicate()
  {
  }

  public void respond()
  {
    ProvisioningServerProtocol protocol = (ProvisioningServerProtocol)getProtocol();

    if (protocol.isLocked())
    {
      // TODO Implement UnlockRequest
      transmitBoolean(false);
    }
    else
    {
      transmitBoolean(true);

      SiteManager siteManager = protocol.getSiteManager();
      Site site = siteManager.getSite();
      AbstractProvisioningProtocol.transmitSite(getChannel(), site);
    }
  }
}
