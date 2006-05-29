/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.client.protocol;


import org.eclipse.net4j.core.impl.AbstractRequestWithConfirmation;

import org.eclipse.emf.cdo.client.ResourceInfo;
import org.eclipse.emf.cdo.client.impl.ResourceInfoImpl;
import org.eclipse.emf.cdo.core.CDOResProtocol;
import org.eclipse.emf.cdo.core.CDOResSignals;

import java.util.ArrayList;
import java.util.List;


public class QueryAllResourcesRequest extends AbstractRequestWithConfirmation
{
  public QueryAllResourcesRequest()
  {
  }

  public short getSignalId()
  {
    return CDOResSignals.QUERY_ALL_RESOURCES;
  }

  public void request()
  {
  }

  public Object confirm()
  {
    List<ResourceInfo> result = new ArrayList<ResourceInfo>();

    for (;;)
    {
      int rid = receiveInt();
      if (rid == CDOResProtocol.NO_MORE_RESOURCES) break;

      String path = receiveString();
      result.add(new ResourceInfoImpl(path, rid, true));
    }

    return result;
  }
}
