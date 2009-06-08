package org.eclipse.net4j.examples.fshare.internal.server;

import java.io.File;

/**
 * @author Eike Stepper
 */
public abstract class ServerResource
{
  private ServerFolder parent;

  private String name;

  private int size;

  private int uploaded;

  public ServerResource(ServerFolder parent, String name, int size)
  {
    this.parent = parent;
    this.name = name;
    this.size = size;
  }

  public ServerFolder getParent()
  {
    return parent;
  }

  public String getName()
  {
    return name;
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
    this.uploaded = uploaded;
  }

  public String getPath()
  {
    return parent.getPath() + name;
  }

  public File getTarget()
  {
    return new File(parent.getTarget(), name);
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
}
