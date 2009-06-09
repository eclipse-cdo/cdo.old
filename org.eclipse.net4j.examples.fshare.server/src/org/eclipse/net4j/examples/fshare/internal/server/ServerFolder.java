package org.eclipse.net4j.examples.fshare.internal.server;

import org.eclipse.net4j.util.io.IOUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class ServerFolder extends ServerResource
{
  private Map<String, ServerResource> children = new HashMap<String, ServerResource>();

  public ServerFolder()
  {
    super(null, null, 0);
  }

  public ServerFolder(ServerFolder parent, String name, int size)
  {
    super(parent, name, size);
  }

  @Override
  public String getPath()
  {
    return super.getPath() + "/";
  }

  public synchronized ServerResource getChild(String name)
  {
    return children.get(name);
  }

  public synchronized ServerResource[] getChildren()
  {
    return children.values().toArray(new ServerResource[children.size()]);
  }

  public synchronized void addChild(ServerResource resource)
  {
    String name = resource.getName();
    if (children.containsKey(name))
    {
      throw new IllegalArgumentException("Duplicate resource: " + resource);
    }

    children.put(name, resource);
  }

  public void mkdirs()
  {
    IOUtil.mkdirs(getTarget());
  }
}
