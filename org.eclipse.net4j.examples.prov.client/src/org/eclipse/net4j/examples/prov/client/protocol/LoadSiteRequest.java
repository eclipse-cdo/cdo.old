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
package org.eclipse.net4j.examples.prov.client.protocol;


import org.eclipse.net4j.core.impl.AbstractRequestWithConfirmation;
import org.eclipse.net4j.examples.prov.ProvisioningProtocol;
import org.eclipse.net4j.examples.prov.protocol.AbstractProvisioningProtocol;


public class LoadSiteRequest extends AbstractRequestWithConfirmation
{
  public LoadSiteRequest()
  {
  }

  public short getSignalId()
  {
    return ProvisioningProtocol.LOAD_SITE;
  }

  public void request()
  {
  }

  public Object confirm()
  {
    boolean couldLock = receiveBoolean();

    if (!couldLock)
    {
      return null;
    }

    return AbstractProvisioningProtocol.receiveSite(getChannel());
  }
}
