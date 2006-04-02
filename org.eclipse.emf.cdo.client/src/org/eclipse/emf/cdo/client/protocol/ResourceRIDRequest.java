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


import org.eclipse.emf.cdo.core.CDOProtocol;


public class ResourceRIDRequest extends AbstractCDOClientRequest
{
  private int rid;

  public ResourceRIDRequest(int rid)
  {
    this.rid = rid;
  }

  public short getSignalId()
  {
    return CDOProtocol.RESOURCE_RID;
  }

  public void request()
  {
    if (isDebugEnabled()) debug("Requesting rid " + rid);
    transmitInt(rid);
  }

  public Object confirm()
  {
    String path = receiveString();

    if (isDebugEnabled())
    {
      if (path != null)
      {
        debug("Responded path " + path);
      }
      else
      {
        debug("No resource with rid " + rid);
      }
    }

    return path;
  }
}
