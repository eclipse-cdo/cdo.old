package org.eclipse.net4j.examples.internal.fshare;

import org.eclipse.net4j.examples.fshare.IFolder;

import java.util.HashMap;
import java.util.Map;

public class Folder extends Resource implements IFolder
{
  private Map<String, Resource> children = new HashMap<String, Resource>();

  public Folder(String name, FileSystem fileSystem)
  {
    super(name, null, fileSystem);
  }

  public Folder(String name, Folder parent)
  {
    super(name, parent, parent.getFileSystem());
  }

  public Resource[] getChildren()
  {
    synchronized (children)
    {
      return children.values().toArray(new Resource[children.size()]);
    }
  }

  public boolean addChild(Resource resource)
  {
    boolean added = false;
    String name = resource.getName();
    synchronized (children)
    {
      if (!children.containsKey(name))
      {
        children.put(name, resource);
        added = true;
      }
    }

    if (added)
    {
      getFileSystem().fireResourceAdded(resource);
    }

    return added;
  }
}
