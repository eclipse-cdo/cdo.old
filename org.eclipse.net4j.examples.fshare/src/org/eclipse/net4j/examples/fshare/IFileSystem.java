package org.eclipse.net4j.examples.fshare;

public interface IFileSystem
{
  public State getState();

  public IFolder getRootFolder();

  public void addListener(Listener listener);

  public void removeListener(Listener listener);

  public enum State
  {
    CONNECTING, CONNECTED
  }

  public interface Listener
  {
    public void stateChanged(IFileSystem fileSystem, State state);

    public void folderAdded(IFolder folder);

    public void fileAdded(IFile file);

    public void transferStarted(ITransfer transfer);

    public void transferStopped(ITransfer transfer);

    public void transferProgressed(ITransfer transfer, int percentFinished);
  }
}
