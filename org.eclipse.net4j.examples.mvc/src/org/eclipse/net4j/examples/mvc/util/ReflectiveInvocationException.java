/***************************************************************************
 * Copyright (c) 2004-2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.examples.mvc.util;


import java.lang.reflect.Method;


public class ReflectiveInvocationException extends RuntimeException
{
  private static final long serialVersionUID = 3257846601786470451L;

  private Method method;

  public ReflectiveInvocationException(Method method, String message, Throwable cause)
  {
    super(message, cause);
    this.method = method;
  }

  public ReflectiveInvocationException(Method method, String message)
  {
    this(method, message, null);
  }

  public ReflectiveInvocationException(Method method, Throwable cause)
  {
    this(method, null, cause);
  }

  public ReflectiveInvocationException(Method method)
  {
    this(method, null, null);
  }

  public Method getMethod()
  {
    return method;
  }
}
