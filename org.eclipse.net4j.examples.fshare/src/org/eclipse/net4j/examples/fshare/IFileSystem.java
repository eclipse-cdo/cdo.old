package org.eclipse.net4j.examples.fshare;

/**
 * @author Eike Stepper
 */
public interface IFileSystem
{
  public IFolder getRootFolder();

  public IResource getResource(String path);

  public void addListener(Listener listener);

  public void removeListener(Listener listener);

  /**
   * @author Eike Stepper
   */
  public interface Listener
  {
    public void protocolClosed(IFileSystem fileSystem);

    public void resourceAdded(IResource resource);

    public void progressChanged(IResource resource);
  }
}
