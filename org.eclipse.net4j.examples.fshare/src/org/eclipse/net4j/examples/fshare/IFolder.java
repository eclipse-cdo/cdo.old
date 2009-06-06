package org.eclipse.net4j.examples.fshare;

/**
 * @author Eike Stepper
 */
public interface IFolder extends IResource
{
  public boolean isLocked();

  public IResource[] getChildren();

  public boolean performDrop(String sourcePath);
}
