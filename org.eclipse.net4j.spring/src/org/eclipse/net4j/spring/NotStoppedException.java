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


public class NotStoppedException extends ServiceException
{
  /**
   * 
   */
  private static final long serialVersionUID = 3257285829398180912L;

  /**
   * 
   */
  public NotStoppedException()
  {
    super();
  }

  /**
   * @param message
   */
  public NotStoppedException(String message)
  {
    super(message);
  }

  /**
   * @param cause
   */
  public NotStoppedException(Throwable cause)
  {
    super(cause);
  }

  /**
   * @param message
   * @param cause
   */
  public NotStoppedException(String message, Throwable cause)
  {
    super(message, cause);
  }
}
