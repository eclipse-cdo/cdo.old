package org.eclipse.net4j.examples.internal.fshare;

import org.eclipse.net4j.examples.fshare.IResource;

/**
 * @author Eike Stepper
 */
public abstract class FShareResource implements IResource
{
  private String name;

  private FShareFolder parent;

  private FShareFileSystem fileSystem;

  public FShareResource(String name, FShareFolder parent, FShareFileSystem fileSystem)
  {
    this.name = name;
    this.parent = parent;
    this.fileSystem = fileSystem;
  }

  public String getName()
  {
    return name;
  }

  public FShareFolder getParent()
  {
    return parent;
  }

  public String getPath(FShareFolder baseFolder)
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
    // return getPath(fileSystem.getRootFolder());
    if (parent == null)
    {
      return "";
    }

    return parent.getPath() + "/" + name;
  }

  public FShareFileSystem getFileSystem()
  {
    return fileSystem;
  }

  @Override
  public String toString()
  {
    return getPath();
  }
}
