package org.eclipse.net4j.examples.internal.fshare;

import org.eclipse.net4j.examples.fshare.IResource;

public class Resource implements IResource
{
  private String name;

  private Folder parent;

  private FileSystem fileSystem;

  public Resource(String name, Folder parent, FileSystem fileSystem)
  {
    this.name = name;
    this.parent = parent;
    this.fileSystem = fileSystem;
  }

  public String getName()
  {
    return name;
  }

  public Folder getParent()
  {
    return parent;
  }

  public FileSystem getFileSystem()
  {
    return fileSystem;
  }
}
