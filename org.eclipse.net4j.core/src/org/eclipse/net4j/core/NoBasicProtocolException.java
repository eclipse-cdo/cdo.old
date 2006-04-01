/*******************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Sympedia Methods and Tools.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *******************************************************************************/
package org.eclipse.net4j.core;


import org.eclipse.net4j.util.Net4jException;


public class NoBasicProtocolException extends Net4jException
{
  /**
   * 
   */
  private static final long serialVersionUID = 3258410612597142834L;

  /**
   * 
   */
  public NoBasicProtocolException()
  {
    super();
  }

  /**
   * @param message
   */
  public NoBasicProtocolException(String message)
  {
    super(message);
  }

  /**
   * @param cause
   */
  public NoBasicProtocolException(Throwable cause)
  {
    super(cause);
  }

  /**
   * @param message
   * @param cause
   */
  public NoBasicProtocolException(String message, Throwable cause)
  {
    super(message, cause);
  }
}
