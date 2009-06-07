package org.eclipse.net4j.examples.fshare.internal.server;

import java.io.File;

/**
 * @author Eike Stepper
 */
public abstract class FShareServerResource
{
  private String name;

  private FShareServerFolder parent;

  public FShareServerResource(String name, FShareServerFolder parent)
  {
    this.name = name;
    this.parent = parent;
  }

  public String getName()
  {
    return name;
  }

  public FShareServerFolder getParent()
  {
    return parent;
  }

  public String getPath()
  {
    if (parent == null)
    {
      return "";
    }

    return parent.getPath() + "/" + name;
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
