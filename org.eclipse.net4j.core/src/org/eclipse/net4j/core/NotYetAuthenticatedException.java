/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.core;


public class NotYetAuthenticatedException extends RuntimeException
{
  /**
   * 
   */
  private static final long serialVersionUID = 3258415027806875702L;

  /**
   * 
   */
  public NotYetAuthenticatedException()
  {
    super();
  }

  /**
   * @param message
   */
  public NotYetAuthenticatedException(String message)
  {
    super(message);
  }

  /**
   * @param message
   * @param cause
   */
  public NotYetAuthenticatedException(String message, Throwable cause)
  {
    super(message, cause);
  }

  /**
   * @param cause
   */
  public NotYetAuthenticatedException(Throwable cause)
  {
    super(cause);
  }
}
