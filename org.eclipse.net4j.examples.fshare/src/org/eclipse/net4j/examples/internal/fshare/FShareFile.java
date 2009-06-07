package org.eclipse.net4j.examples.internal.fshare;

import org.eclipse.net4j.examples.fshare.IFile;

/**
 * @author Eike Stepper
 */
public class FShareFile extends FShareResource implements IFile
{
  private long size;

  private long uploaded;

  public FShareFile(String name, long size, FShareFolder parent)
  {
    super(name, parent, parent.getFileSystem());
    this.size = size;
  }

  public long getSize()
  {
    return size;
  }

  public long getUploaded()
  {
    return uploaded;
  }

  public void setUploaded(long uploaded)
  {
    if (uploaded > 0)
    {
      this.uploaded = uploaded;
      getFileSystem().fireProgressChanged(this);
    }
  }

  public int getPercentUploaded()
  {
    if (size == 0L)
    {
      return 100;
    }

    return (int)(uploaded * 100 / size);
  }
}
