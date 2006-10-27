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
import org.eclipse.net4j.util.stream.ExtendedDataInputStream;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import org.eclipse.emf.cdo.client.ResourceInfo;
import org.eclipse.emf.cdo.client.impl.ResourceInfoImpl;
import org.eclipse.emf.cdo.core.CDOResProtocol;
import org.eclipse.emf.cdo.core.CDOResSignals;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;


public class QueryAllResourcesRequest extends RequestWithConfirmation<List<ResourceInfo>>
{
  public QueryAllResourcesRequest(Channel channel)
  {
    super(channel);
  }

  @Override
  protected short getSignalID()
  {
    return CDOResSignals.QUERY_ALL_RESOURCES;
  }

  @Override
  protected void requesting(ExtendedDataOutputStream out) throws IOException
  {
  }

  @Override
  protected List<ResourceInfo> confirming(ExtendedDataInputStream in) throws IOException
  {
    List<ResourceInfo> result = new ArrayList<ResourceInfo>();
    for (;;)
    {
      int rid = in.readInt();
      if (rid == CDOResProtocol.NO_MORE_RESOURCES) break;

      String path = in.readString();
      result.add(new ResourceInfoImpl(path, rid, true));
    }

    return result;
  }
}
