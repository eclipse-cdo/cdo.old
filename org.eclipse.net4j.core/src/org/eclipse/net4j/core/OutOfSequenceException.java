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
package org.eclipse.net4j.core;


import org.eclipse.net4j.util.Net4jException;


public class OutOfSequenceException extends Net4jException
{
  /**
   * 
   */
  private static final long serialVersionUID = 3256999951929063731L;

  /**
   * 
   */
  public OutOfSequenceException()
  {
    super();
  }

  /**
   * @param message
   */
  public OutOfSequenceException(String message)
  {
    super(message);
  }

  /**
   * @param cause
   */
  public OutOfSequenceException(Throwable cause)
  {
    super(cause);
  }

  /**
   * @param message
   * @param cause
   */
  public OutOfSequenceException(String message, Throwable cause)
  {
    super(message, cause);
  }

}
