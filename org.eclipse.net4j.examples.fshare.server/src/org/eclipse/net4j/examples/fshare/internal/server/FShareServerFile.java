package org.eclipse.net4j.examples.fshare.internal.server;

/**
 * @author Eike Stepper
 */
public class FShareServerFile extends FShareServerResource
{
  private long size;

  private long uploaded;

  public FShareServerFile(String name, long size, FShareServerFolder parent)
  {
    super(name, parent);
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
    this.uploaded = uploaded;
  }
}
