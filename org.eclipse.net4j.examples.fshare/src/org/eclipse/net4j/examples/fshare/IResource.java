package org.eclipse.net4j.examples.fshare;

/**
 * @author Eike Stepper
 */
public interface IResource
{
  public IFileSystem getFileSystem();

  public IFolder getParent();

  public String getName();

  public String getPath();

  public int getSize();

  public int getUploaded();

  public int getUploadedPercent();
}
