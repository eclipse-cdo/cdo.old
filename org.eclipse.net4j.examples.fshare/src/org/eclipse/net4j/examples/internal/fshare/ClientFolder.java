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

import org.eclipse.net4j.examples.fshare.IFolder;
import org.eclipse.net4j.examples.fshare.common.FShareConstants;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class ClientFolder extends ClientResource implements IFolder
{
  private Map<String, ClientResource> children;

  public ClientFolder(Client client, int size, int uploaded)
  {
    super(client, null, null, size);
    setUploaded(uploaded);
  }

  public ClientFolder(ClientFolder parent, String name, int size)
  {
    super(parent.getClient(), parent, name, size);
  }

  public synchronized ClientResource[] getChildren()
  {
    ensureChildren(true);
    return children.values().toArray(new ClientResource[children.size()]);
  }

  public synchronized ClientResource getChild(String name)
  {
    ensureChildren(true);
    return children.get(name);
  }

  public boolean addChild(ClientResource resource, boolean load, boolean notify)
  {
    boolean added = basicAddChild(resource, load);
    if (added && notify)
    {
      getClient().fireResourceAdded(resource);
    }

    return added;
  }

  @Override
  public synchronized int getTotalFileSize()
  {
    long sum = 0L;
    for (ClientResource child : children.values())
    {
      sum += child.getTotalFileSize();
    }

    if (sum > Integer.MAX_VALUE)
    {
      throw new IllegalArgumentException("Total file size exeeds limit: " + this);
    }

    return (int)sum;
  }

  public void performDrop(String[] sourcePaths)
  {
    for (final String sourcePath : sourcePaths)
    {
      final File source = new File(sourcePath);
      final ClientResource resource = createResource(source);
      if (addChild(resource, true, true))
      {
        Job job = new Job("Uploading")
        {
          @Override
          protected IStatus run(IProgressMonitor monitor)
          {
            getClient().getProtocol().upload(resource, source, monitor);
            return Status.OK_STATUS;
          }
        };

        job.schedule();
      }
    }
  }

  @Override
  public void upload(ExtendedDataOutputStream out, File source, byte[] buffer, IProgressMonitor monitor)
      throws IOException
  {
    super.upload(out, source, buffer, monitor);
    out.writeBoolean(FShareConstants.FOLDER);

    for (ClientResource child : getChildren())
    {
      File childSource = new File(source, child.getName());
      child.upload(out, childSource, buffer, monitor);
    }
  }

  private ClientResource createResource(File source)
  {
    if (source.isDirectory())
    {
      return createFolder(source);
    }

    return createFile(source);
  }

  private ClientFolder createFolder(File source)
  {
    File[] children = source.listFiles();
    ClientFolder folder = new ClientFolder(this, source.getName(), children.length);
    for (File child : children)
    {
      ClientResource resource = folder.createResource(child);
      folder.addChild(resource, false, false);
    }

    return folder;
  }

  private ClientFile createFile(File source)
  {
    long length = source.length();
    if (length > Integer.MAX_VALUE)
    {
      throw new IllegalArgumentException("File size exeeds limit: " + source);
    }

    return new ClientFile(this, source.getName(), (int)length);
  }

  private void ensureChildren(boolean load)
  {
    if (children == null)
    {
      children = new HashMap<String, ClientResource>();
      if (load)
      {
        getClient().getProtocol().loadChildren(this);
      }
    }
  }

  private synchronized boolean basicAddChild(ClientResource resource, boolean load)
  {
    String name = resource.getName();
    ensureChildren(load);
    if (children.containsKey(name))
    {
      return false;
    }

    children.put(name, resource);
    return true;
  }
}
