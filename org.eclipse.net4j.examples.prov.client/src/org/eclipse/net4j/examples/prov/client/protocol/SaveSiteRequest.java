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
package org.eclipse.net4j.examples.prov.client.protocol;


import org.eclipse.net4j.core.impl.AbstractRequestWithConfirmation;
import org.eclipse.net4j.examples.prov.ProvisioningProtocol;
import org.eclipse.net4j.examples.prov.Site;
import org.eclipse.net4j.examples.prov.protocol.AbstractProvisioningProtocol;


public class SaveSiteRequest extends AbstractRequestWithConfirmation
{
  private Site site;

  public SaveSiteRequest(Site site)
  {
    this.site = site;
  }

  public short getSignalId()
  {
    return ProvisioningProtocol.SAVE_SITE;
  }

  public void request()
  {
    AbstractProvisioningProtocol.transmitCategories(getChannel(), site.getCategories());
  }

  public Object confirm()
  {
    int retCode = receiveInt();
    return retCode;
  }
}
