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


import org.eclipse.net4j.transport.Channel;
import org.eclipse.net4j.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.stream.ExtendedDataInputStream;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import org.eclipse.emf.cdo.client.internal.CDOClient;
import org.eclipse.emf.cdo.core.CDOProtocol;

import java.io.IOException;


public class ResourceRIDRequest extends AbstractCDOClientRequest<String>
{
  private static final ContextTracer TRACER = new ContextTracer(CDOClient.DEBUG_PROTOCOL,
      ResourceRIDRequest.class);

  private int rid;

  public ResourceRIDRequest(Channel channel, int rid)
  {
    super(channel);
    this.rid = rid;
  }

  @Override
  protected short getSignalID()
  {
    return CDOProtocol.RESOURCE_RID;
  }

  @Override
  protected void requesting(ExtendedDataOutputStream out) throws IOException
  {
    if (TRACER.isEnabled())
    {
      TRACER.trace(this, "Requesting rid " + rid);
    }

    out.writeInt(rid);
  }

  @Override
  protected String confirming(ExtendedDataInputStream in) throws IOException
  {
    String path = in.readString();
    if (TRACER.isEnabled())
    {
      if (path != null)
      {
        TRACER.trace(this, "Responded path " + path);
      }
      else
      {
        TRACER.trace(this, "No resource with rid " + rid);
      }
    }

    return path;
  }
}
