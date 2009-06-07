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

  private Map<String, FShareResource> children;

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
    if (!locked)
    {
      getFileSystem().fireFolderUnlocked(this);
    }
  }

  public FShareResource getChild(String name)
  {
    synchronized (this)
    {
      ensureChildren(true);
      return children.get(name);
    }
  }

  public FShareResource[] getChildren()
  {
    synchronized (this)
    {
      ensureChildren(true);
      return children.values().toArray(new FShareResource[children.size()]);
    }
  }

  public boolean addChild(FShareResource resource, boolean load, boolean notify)
  {
    boolean added = false;
    String name = resource.getName();
    synchronized (this)
    {
      ensureChildren(load);
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

  public boolean performDrop(String[] sourcePaths)
  {
    for (String sourcePath : sourcePaths)
    {
      File source = new File(sourcePath);
      FShareResource resource = createResource(source, true);
      if (addChild(resource, true, true))
      {
        getFileSystem().getProtocol().upload(resource, source);
      }
    }

    return true;
  }

  private FShareResource createResource(File source, boolean base)
  {
    if (source.isDirectory())
    {
      FShareFolder folder = createFolder(source);
      if (base)
      {
        folder.setLocked(true);
      }

      return folder;
    }

    return createFile(source);
  }

  private FShareFolder createFolder(File source)
  {
    FShareFolder folder = new FShareFolder(source.getName(), this);
    for (File child : source.listFiles())
    {
      FShareResource resource = folder.createResource(child, false);
      folder.addChild(resource, false, false);
    }

    return folder;
  }

  private FShareFile createFile(File source)
  {
    return new FShareFile(source.getName(), source.length(), this);
  }

  private void ensureChildren(boolean load)
  {
    if (children == null)
    {
      children = new HashMap<String, FShareResource>();
      if (load)
      {
        getFileSystem().getProtocol().loadChildren(this);
      }
    }
  }
}
