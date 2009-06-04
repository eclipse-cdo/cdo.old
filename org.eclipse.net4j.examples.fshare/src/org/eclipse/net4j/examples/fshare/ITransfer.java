package org.eclipse.net4j.examples.fshare;

public interface ITransfer
{
  public IFile getFile();

  public int getPercentFinished();

  public Type getType();

  public enum Type
  {
    UPLOAD, DOWNLOAD
  }
}
