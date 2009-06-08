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
  private ClientFileSystem fileSystem;

  private ClientFolder parent;

  private String name;

  private int size;

  private int uploaded;

  public ClientResource(ClientFileSystem fileSystem, ClientFolder parent, String name, int size)
  {
    this.fileSystem = fileSystem;
    this.parent = parent;
    this.name = name;
    this.size = size;
  }

  public ClientFileSystem getFileSystem()
  {
    return fileSystem;
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
      fileSystem.fireProgressChanged(this);
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
