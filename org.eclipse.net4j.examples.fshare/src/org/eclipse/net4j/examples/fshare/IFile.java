package org.eclipse.net4j.examples.fshare;

/**
 * @author Eike Stepper
 */
public interface IFile extends IResource
{
  public long getSize();

  public int getPercentUploaded();
}
