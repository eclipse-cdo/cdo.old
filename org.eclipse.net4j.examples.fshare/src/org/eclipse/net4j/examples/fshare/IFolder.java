package org.eclipse.net4j.examples.fshare;

/**
 * @author Eike Stepper
 */
public interface IFolder extends IResource
{
  public IResource[] getChildren();

  public boolean performDrop(String sourcePath);
}
