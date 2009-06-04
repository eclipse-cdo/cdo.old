package org.eclipse.net4j.examples.fshare;

public interface IResource
{
  public String getName();

  public IResource getParent();

  public IFileSystem getFileSystem();
}
