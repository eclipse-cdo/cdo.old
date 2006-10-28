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


public class ResourcePathRequest extends AbstractCDOClientRequest<Integer>
{
  private static final ContextTracer TRACER = new ContextTracer(CDOClient.DEBUG_PROTOCOL,
      ResourcePathRequest.class);

  protected String path;

  public ResourcePathRequest(Channel channel, String path)
  {
    super(channel);
    this.path = path;
  }

  @Override
  protected short getSignalID()
  {
    return CDOProtocol.RESOURCE_PATH;
  }

  @Override
  protected void requesting(ExtendedDataOutputStream out) throws IOException
  {
    if (TRACER.isEnabled())
    {
      TRACER.trace(this, "Requesting path " + path);
    }

    out.writeString(path);
  }

  @Override
  protected Integer confirming(ExtendedDataInputStream in) throws IOException
  {
    int rid = in.readInt();
    if (TRACER.isEnabled())
    {
      if (rid > 0)
      {
        TRACER.trace(this, "Responded rid " + rid);
      }
      else
      {
        TRACER.trace(this, "No resource with path " + path + " - reserved rid " + -rid);
      }
    }

    return rid;
  }
}
