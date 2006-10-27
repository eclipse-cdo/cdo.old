package org.eclipse.emf.cdo.core;


import java.io.IOException;


/**
 * @author Eike Stepper
 */
public final class WrappedIOException extends RuntimeException
{
  private static final long serialVersionUID = 1L;

  public WrappedIOException(IOException ex)
  {
    super(ex);
  }

  public void reThrow() throws IOException
  {
    throw (IOException) getCause();
  }
}