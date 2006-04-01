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


import org.eclipse.emf.cdo.core.CdoProtocol;


public class ResourcePathRequest extends AbstractCdoClientRequest
{
  protected String path;

  public ResourcePathRequest(String path)
  {
    this.path = path;
  }

  public short getSignalId()
  {
    return CdoProtocol.RESOURCE_PATH;
  }

  public void request()
  {
    if (isDebugEnabled()) debug("Requesting path " + path);
    transmitString(path);
  }

  public Object confirm()
  {
    int rid = receiveInt();

    if (isDebugEnabled())
    {
      if (rid > 0)
      {
        debug("Responded rid " + rid);
      }
      else
      {
        debug("No resource with path " + path);
        debug("Reserved rid " + -rid);
      }
    }

    return new Integer(rid);
  }
}
