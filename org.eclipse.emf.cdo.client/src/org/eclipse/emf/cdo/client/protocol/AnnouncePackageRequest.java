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


import org.eclipse.emf.cdo.client.PackageInfo;
import org.eclipse.emf.cdo.core.CDOProtocol;


public class AnnouncePackageRequest extends AbstractPackageRequest
{
  private PackageInfo packageInfo;

  public AnnouncePackageRequest(PackageInfo packageInfo)
  {
    this.packageInfo = packageInfo;
  }

  public short getSignalId()
  {
    return CDOProtocol.ANNOUNCE_PACKAGE;
  }

  public void request()
  {
    if (isDebugEnabled()) debug("Announcing package " + packageInfo.getFullName());
    transmitString(packageInfo.getFullName());
  }

  public Object confirm()
  {
    int count = receiveInt();

    if (count >= 0)
    {
      handlePackageResponse(count);
      return Boolean.TRUE;
    }
    else
    {
      if (isDebugEnabled()) debug("Unknown package " + packageInfo.getFullName());
      return Boolean.FALSE;
    }
  }
}
