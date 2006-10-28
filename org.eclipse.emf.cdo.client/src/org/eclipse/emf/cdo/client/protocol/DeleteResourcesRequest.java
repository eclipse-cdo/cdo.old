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
import org.eclipse.net4j.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.stream.ExtendedDataInputStream;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import org.eclipse.emf.cdo.client.internal.CDOClient;
import org.eclipse.emf.cdo.core.CDOResProtocol;
import org.eclipse.emf.cdo.core.CDOResSignals;

import java.util.Set;

import java.io.IOException;


public class DeleteResourcesRequest extends RequestWithConfirmation<Boolean>
{
  private static final ContextTracer TRACER = new ContextTracer(CDOClient.DEBUG_PROTOCOL,
      DeleteResourcesRequest.class);

  private Set<Integer> rids;

  public DeleteResourcesRequest(Channel channel, Set<Integer> rids)
  {
    super(channel);
    this.rids = rids;
  }

  @Override
  protected short getSignalID()
  {
    return CDOResSignals.DELETE_RESOURCES;
  }

  @Override
  protected void requesting(ExtendedDataOutputStream out) throws IOException
  {
    for (Integer rid : rids)
    {
      if (TRACER.isEnabled())
      {
        TRACER.trace(this, "Deleting rid " + rid);
      }

      out.writeInt(rid);
    }

    out.writeInt(CDOResProtocol.NO_MORE_RESOURCES);
  }

  @Override
  protected Boolean confirming(ExtendedDataInputStream in) throws IOException
  {
    boolean ok = in.readBoolean();
    if (TRACER.isEnabled())
    {
      TRACER.trace(this, "Deleted resources: " + ok);
    }

    return ok;
  }
}
