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
package org.eclipse.emf.cdo.protocol.util;

import org.eclipse.net4j.util.ObjectUtil;
import org.eclipse.net4j.util.stream.ExtendedDataInputStream;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import java.io.IOException;

/**
 * @author Eike Stepper
 */
public final class CDOPackageInfo
{
  private int modelID;

  private String uri;

  public CDOPackageInfo(int modelID, String uri)
  {
    this.uri = uri;
    this.modelID = modelID;
  }

  public CDOPackageInfo(ExtendedDataInputStream in) throws IOException
  {
    modelID = in.readInt();
    uri = in.readString();
  }

  public void write(ExtendedDataOutputStream out) throws IOException
  {
    out.writeInt(modelID);
    out.writeString(uri);
  }

  public int getModelID()
  {
    return modelID;
  }

  public String getURI()
  {
    return uri;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj instanceof CDOPackageInfo)
    {
      CDOPackageInfo that = (CDOPackageInfo)obj;
      return this.modelID == that.modelID && ObjectUtil.equals(this.uri, that.uri);
    }

    return false;
  }

  @Override
  public int hashCode()
  {
    return modelID ^ uri.hashCode();
  }

  @Override
  public String toString()
  {
    return "" + modelID + " <--> " + uri;
  }
}
