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
package org.eclipse.emf.cdo.client.protocol;


import org.eclipse.net4j.core.impl.AbstractIndication;

import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.core.CdoProtocol;


public class InvalidateObjectIndication extends AbstractIndication
{
  public short getSignalId()
  {
    return CdoProtocol.INVALIDATE_OBJECT;
  }

  public void indicate()
  {
    ResourceManager resourceManager = CdoClientProtocolImpl.getResourceManager(getChannel());
    int count = receiveInt();
    long[] oids = new long[count];

    for (int i = 0; i < count; i++)
    {
      oids[i] = receiveLong();
    }

    resourceManager.invalidateObjects(oids);
  }
}
