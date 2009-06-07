package org.eclipse.net4j.examples.fshare.internal.server;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class FShareServerFolder extends FShareServerResource
{
  private boolean locked;

  private Map<String, FShareServerResource> children = new HashMap<String, FShareServerResource>();

  public FShareServerFolder()
  {
    super(null, null);
  }

  public FShareServerFolder(String name, FShareServerFolder parent)
  {
    super(name, parent);
  }

  public boolean isLocked()
  {
    if (locked)
    {
      return true;
    }

    FShareServerFolder parent = getParent();
    if (parent != null)
    {
      return parent.isLocked();
    }

    return false;
  }

  public void setLocked(boolean locked)
  {
    this.locked = locked;
  }

  public FShareServerResource getChild(String name)
  {
    synchronized (this)
    {
      return children.get(name);
    }
  }

  public FShareServerResource[] getChildren()
  {
    synchronized (this)
    {
      return children.values().toArray(new FShareServerResource[children.size()]);
    }
  }

  public boolean addChild(FShareServerResource resource)
  {
    String name = resource.getName();
    synchronized (this)
    {
      if (!children.containsKey(name))
      {
        children.put(name, resource);
        return true;
      }
    }

    return false;
  }
  //
  // private FShareResource createResource(File source, boolean base)
  // {
  // if (source.isDirectory())
  // {
  // FShareFolder folder = createFolder(source);
  // if (base)
  // {
  // folder.setLocked(true);
  // }
  //
  // return folder;
  // }
  //
  // return createFile(source);
  // }
  //
  // private FShareFolder createFolder(File source)
  // {
  // FShareFolder folder = new FShareFolder(source.getName(), this);
  // for (File child : source.listFiles())
  // {
  // FShareResource resource = folder.createResource(child, false);
  // folder.addChild(resource, false, false);
  // }
  //
  // return folder;
  // }
  //
  // private FShareFile createFile(File source)
  // {
  // return new FShareFile(source.getName(), source.length(), this);
  // }
}
