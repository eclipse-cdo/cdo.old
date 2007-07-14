/***************************************************************************
 * Copyright (c) 2004-2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.internal.protocol.model;

import org.eclipse.emf.cdo.internal.protocol.bundle.CDOProtocol;
import org.eclipse.emf.cdo.protocol.model.CDOModelElement;

import org.eclipse.net4j.internal.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;

import java.io.IOException;

/**
 * @author Eike Stepper
 */
public abstract class CDOModelElementImpl implements CDOModelElement
{
  private static final ContextTracer MODEL = new ContextTracer(CDOProtocol.DEBUG_MODEL, CDOModelElementImpl.class);

  private String name;

  private Object clientInfo;

  /**
   * TODO Check if needed
   */
  private Object serverInfo;

  public CDOModelElementImpl(String name)
  {
    this.name = name;
  }

  public CDOModelElementImpl(ExtendedDataInputStream in) throws IOException
  {
    name = in.readString();
  }

  public void write(ExtendedDataOutputStream out) throws IOException
  {
    out.writeString(name);
  }

  public String getName()
  {
    return name;
  }

  public Object getClientInfo()
  {
    return clientInfo;
  }

  public void setClientInfo(Object clientInfo)
  {
    if (MODEL.isEnabled())
    {
      MODEL.format("Setting client info: {0} --> {1}", this, clientInfo);
    }

    this.clientInfo = clientInfo;
  }

  public Object getServerInfo()
  {
    return serverInfo;
  }

  public void setServerInfo(Object serverInfo)
  {
    if (MODEL.isEnabled())
    {
      MODEL.format("Setting server info: {0} --> {1}", this, serverInfo);
    }

    this.serverInfo = serverInfo;
  }
}
