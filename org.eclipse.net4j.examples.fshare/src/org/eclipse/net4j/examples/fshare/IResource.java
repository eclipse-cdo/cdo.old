package org.eclipse.net4j.examples.fshare;

public interface IResource
{
  public String getName();

  public IFolder getParent();

  public IFileSystem getFileSystem();
}
