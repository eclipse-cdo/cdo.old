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


import org.eclipse.net4j.util.Net4jException;


public class UnknownProtocolException extends Net4jException
{
  /**
   * 
   */
  private static final long serialVersionUID = 3688504411252930358L;

  /**
   * 
   */
  public UnknownProtocolException()
  {
    super();
  }

  /**
   * @param message
   */
  public UnknownProtocolException(String message)
  {
    super(message);
  }

  /**
   * @param cause
   */
  public UnknownProtocolException(Throwable cause)
  {
    super(cause);
  }

  /**
   * @param message
   * @param cause
   */
  public UnknownProtocolException(String message, Throwable cause)
  {
    super(message, cause);
  }
}
