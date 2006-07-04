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
import org.eclipse.net4j.examples.prov.Category;
import org.eclipse.net4j.examples.prov.ProvisioningProtocol;
import org.eclipse.net4j.examples.prov.protocol.AbstractProvisioningProtocol;
import org.eclipse.net4j.examples.prov.server.SiteManager;

import org.eclipse.emf.common.util.BasicEList;

import java.util.List;


public class SaveSiteIndication extends AbstractIndicationWithResponse implements Indication
{
  private List<Category> categories = new BasicEList();

  public SaveSiteIndication()
  {
  }

  public short getSignalId()
  {
    return ProvisioningProtocol.SAVE_SITE;
  }

  public void indicate()
  {
    AbstractProvisioningProtocol.receiveCategories(getChannel(), categories);
  }

  public void respond()
  {
    ProvisioningServerProtocol protocol = (ProvisioningServerProtocol)getProtocol();
    SiteManager siteManager = protocol.getSiteManager();
    siteManager.setCategories(categories);

    transmitInt(0);
  }
}
