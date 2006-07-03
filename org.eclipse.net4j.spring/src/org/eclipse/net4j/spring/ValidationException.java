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
package org.eclipse.net4j.spring;


public class ValidationException extends RuntimeException
{
  /**
   * 
   */
  private static final long serialVersionUID = 3834868104936305717L;

  /**
   * 
   */
  public ValidationException()
  {
    super();
  }

  /**
   * @param arg0
   */
  public ValidationException(String arg0)
  {
    super(arg0);
  }

  /**
   * @param arg0
   */
  public ValidationException(Throwable arg0)
  {
    super(arg0);
  }

  /**
   * @param arg0
   * @param arg1
   */
  public ValidationException(String arg0, Throwable arg1)
  {
    super(arg0, arg1);
  }
}
