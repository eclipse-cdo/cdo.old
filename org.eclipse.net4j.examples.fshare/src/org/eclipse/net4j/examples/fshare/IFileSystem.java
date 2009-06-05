package org.eclipse.net4j.examples.fshare;

public interface IFileSystem
{
  public IFolder getRootFolder();

  public void addListener(Listener listener);

  public void removeListener(Listener listener);

  public interface Listener
  {
    public void protocolClosed(IFileSystem fileSystem);

    public void resourceAdded(IResource resource);

    public void transferStarted(ITransfer transfer);

    public void transferStopped(ITransfer transfer);

    public void transferProgressed(ITransfer transfer, int percentFinished);
  }
}
