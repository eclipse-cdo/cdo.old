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


import org.eclipse.net4j.signal.Indication;
import org.eclipse.net4j.util.stream.ExtendedDataInputStream;

import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.core.CDOProtocol;

import java.io.IOException;


public class RemovalNotificationIndication extends Indication
{
  @Override
  protected short getSignalID()
  {
    return CDOProtocol.REMOVAL_NOTIFICATION;
  }

  @Override
  protected void indicating(ExtendedDataInputStream in) throws IOException
  {
    int count = in.readInt();
    int[] rids = new int[count];

    for (int i = 0; i < count; i++)
    {
      rids[i] = in.readInt();
    }

    ResourceManager resourceManager = ((ClientCDOProtocolImpl) getProtocol()).getResourceManager();
    resourceManager.handleRemovedResources(rids);
  }
}
