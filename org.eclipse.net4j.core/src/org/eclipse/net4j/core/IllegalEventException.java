package org.eclipse.net4j.core;


import org.eclipse.net4j.util.Net4jException;


public class IllegalEventException extends Net4jException
{
  private static final long serialVersionUID = 3258129171946551347L;

  public IllegalEventException()
  {
    super();
  }

  public IllegalEventException(String message)
  {
    super(message);
  }

  public IllegalEventException(Throwable cause)
  {
    super(cause);
  }

  public IllegalEventException(String message, Throwable cause)
  {
    super(message, cause);
  }
}
