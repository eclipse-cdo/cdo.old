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
package org.eclipse.emf.cdo.client;


public class UnconnectedException extends CdoClientException
{
  /**
   * 
   */
  private static final long serialVersionUID = 3258408422029669173L;

  /**
   * 
   */
  public UnconnectedException()
  {
    super();
  }

  /**
   * @param message
   */
  public UnconnectedException(String message)
  {
    super(message);
  }

  /**
   * @param cause
   */
  public UnconnectedException(Throwable cause)
  {
    super(cause);
  }

  /**
   * @param message
   * @param cause
   */
  public UnconnectedException(String message, Throwable cause)
  {
    super(message, cause);
  }
}