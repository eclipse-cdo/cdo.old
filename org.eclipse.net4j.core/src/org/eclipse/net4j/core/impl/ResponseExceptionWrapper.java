package org.eclipse.net4j.core.impl;


public class ResponseExceptionWrapper
{
  private RuntimeException exception;

  public ResponseExceptionWrapper(RuntimeException exception)
  {
    this.exception = exception;
  }

  public RuntimeException getException()
  {
    return exception;
  }
}
