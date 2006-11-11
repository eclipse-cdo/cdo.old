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

import org.eclipse.emf.cdo.client.PackageInfo;
import org.eclipse.emf.cdo.client.internal.CDOClient;
import org.eclipse.emf.cdo.core.CDOProtocol;

import java.io.IOException;


public class AnnouncePackageRequest extends AbstractPackageRequest<Boolean>
{
  private static final ContextTracer TRACER = new ContextTracer(CDOClient.DEBUG_PROTOCOL,
      AnnouncePackageRequest.class);

  private PackageInfo packageInfo;

  public AnnouncePackageRequest(Channel channel, PackageInfo packageInfo)
  {
    super(channel);
    this.packageInfo = packageInfo;
  }

  @Override
  protected short getSignalID()
  {
    return CDOProtocol.ANNOUNCE_PACKAGE;
  }

  @Override
  protected void requesting(ExtendedDataOutputStream out) throws IOException
  {
    if (TRACER.isEnabled())
    {
      TRACER.trace("Announcing package " + packageInfo.getFullName());
    }

    out.writeString(packageInfo.getFullName());
  }

  @Override
  protected Boolean confirming(ExtendedDataInputStream in) throws IOException
  {
    int count = in.readInt();
    if (count >= 0)
    {
      handlePackageResponse(in, count);
      return true;
    }
    else
    {
      if (TRACER.isEnabled())
      {
        TRACER.trace("Unknown package " + packageInfo.getFullName());
      }

      return false;
    }
  }
}
