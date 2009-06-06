package org.eclipse.net4j.examples.internal.fshare;

import org.eclipse.net4j.examples.fshare.IFolder;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class FShareFolder extends FShareResource implements IFolder
{
  private boolean locked;

  private Map<String, FShareResource> children = new HashMap<String, FShareResource>();

  public FShareFolder(FShareFileSystem fileSystem)
  {
    super(null, null, fileSystem);
  }

  public FShareFolder(String name, FShareFolder parent)
  {
    super(name, parent, parent.getFileSystem());
  }

  public boolean isLocked()
  {
    if (locked)
    {
      return true;
    }

    FShareFolder parent = getParent();
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

  public FShareResource getChild(String name)
  {
    synchronized (children)
    {
      return children.get(name);
    }
  }

  public FShareResource[] getChildren()
  {
    synchronized (children)
    {
      return children.values().toArray(new FShareResource[children.size()]);
    }
  }

  public boolean performDrop(String sourcePath)
  {
    File source = new File(sourcePath);
    FShareResource resource = createResource(source);
    if (addChild(resource, true))
    {
      getFileSystem().getProtocol().upload(resource, source);
      return true;
    }

    return false;
  }

  private FShareResource createResource(File source)
  {
    if (source.isDirectory())
    {
      FShareFolder folder = createFolder(source);
      folder.setLocked(true);
      return folder;
    }

    return createFile(source);
  }

  private FShareFolder createFolder(File source)
  {
    FShareFolder folder = new FShareFolder(source.getName(), this);
    for (File child : source.listFiles())
    {
      FShareResource resource = folder.createResource(child);
      folder.addChild(resource, false);
    }

    return folder;
  }

  private FShareFile createFile(File source)
  {
    return new FShareFile(source.getName(), source.length(), this);
  }

  private boolean addChild(FShareResource resource, boolean notify)
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

    if (added && notify)
    {
      getFileSystem().fireResourceAdded(resource);
    }

    return added;
  }
}
