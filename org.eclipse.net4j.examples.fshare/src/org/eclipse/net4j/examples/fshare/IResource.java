package org.eclipse.net4j.examples.fshare;

/**
 * @author Eike Stepper
 */
public interface IResource
{
  public String getName();

  public IFolder getParent();

  public String getPath();

  public IFileSystem getFileSystem();
}
