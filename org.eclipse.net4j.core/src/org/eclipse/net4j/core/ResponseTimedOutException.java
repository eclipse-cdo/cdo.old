package org.eclipse.net4j.core;


import org.eclipse.net4j.util.Net4jException;


public class ResponseTimedOutException extends Net4jException
{
  private static final long serialVersionUID = 1L;

  public ResponseTimedOutException()
  {
  }

  public ResponseTimedOutException(String message)
  {
    super(message);
  }

  public ResponseTimedOutException(Throwable cause)
  {
    super(cause);
  }

  public ResponseTimedOutException(String message, Throwable cause)
  {
    super(message, cause);
  }
}
