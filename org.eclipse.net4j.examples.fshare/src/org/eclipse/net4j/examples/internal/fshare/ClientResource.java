/**
 * Copyright (c) 2004 - 2010 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *
 *  Initial Publication:
 *    Eclipse Magazin - http://www.eclipse-magazin.de
 */
package org.eclipse.net4j.examples.internal.fshare;

import org.eclipse.net4j.examples.fshare.IResource;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;

import org.eclipse.core.runtime.IProgressMonitor;

import java.io.File;
import java.io.IOException;

/**
 * @author Eike Stepper
 */
public abstract class ClientResource implements IResource
{
  private Client client;

  private ClientFolder parent;

  private String name;

  private int size;

  private int uploaded;

  public ClientResource(Client client, ClientFolder parent, String name, int size)
  {
    this.client = client;
    this.parent = parent;
    this.name = name;
    this.size = size;
  }

  public Client getClient()
  {
    return client;
  }

  public ClientFolder getParent()
  {
    return parent;
  }

  public String getName()
  {
    return name;
  }

  public String getPath(ClientFolder baseFolder)
  {
    if (parent == null)
    {
      return "";
    }

    if (parent == baseFolder)
    {
      return name;
    }

    return parent.getPath(baseFolder) + "/" + name;
  }

  public String getPath()
  {
    if (parent == null)
    {
      return "";
    }

    return parent.getPath() + "/" + name;
  }

  public int getSize()
  {
    return size;
  }

  public void setSize(int size)
  {
    this.size = size;
  }

  public int getUploaded()
  {
    return uploaded;
  }

  public void setUploaded(int uploaded)
  {
    int percent = getUploadedPercent();
    this.uploaded = uploaded;
    if (getUploadedPercent() != percent)
    {
      client.fireProgressChanged(this);
    }
  }

  public int getUploadedPercent()
  {
    if (size == 0)
    {
      return 100;
    }

    return uploaded * 100 / size;
  }

  public void upload(ExtendedDataOutputStream out, File source, byte[] buffer, IProgressMonitor monitor)
      throws IOException
  {
    monitor.setTaskName(source.getAbsolutePath());
    out.writeString(name);
    out.writeInt(size);
  }

  @Override
  public String toString()
  {
    if (parent == null)
    {
      return "/";
    }

    return getPath();
  }

  public abstract int getTotalFileSize();
}
