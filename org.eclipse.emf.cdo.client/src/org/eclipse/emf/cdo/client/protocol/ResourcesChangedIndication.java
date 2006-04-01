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

import org.eclipse.emf.cdo.core.CdoResSignals;
import org.eclipse.emf.cdo.core.protocol.NoMoreResourceChangesException;
import org.eclipse.emf.cdo.core.protocol.ResourceChangeInfo;

import java.util.ArrayList;
import java.util.List;


public class ResourcesChangedIndication extends AbstractIndication
{
  public short getSignalId()
  {
    return CdoResSignals.RESOURCES_CHANGED;
  }

  public void indicate()
  {
    List<ResourceChangeInfo> infos = new ArrayList();

    try
    {
      for (;;)
      {
        infos.add(new ResourceChangeInfo(getChannel()));
      }
    }
    catch (NoMoreResourceChangesException ignore)
    {
    }

    CdoResClientProtocolImpl protocol = (CdoResClientProtocolImpl) getProtocol();
    protocol.resourcesChanged(getChannel(), infos);
  }
}
