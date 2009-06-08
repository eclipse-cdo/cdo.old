package org.eclipse.net4j.examples.fshare;

/**
 * @author Eike Stepper
 */
public interface IFolder extends IResource
{
  public IResource[] getChildren();

  public IResource getChild(String name);

  public void performDrop(String[] data);
}
