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


import org.eclipse.emf.cdo.core.CdoException;


public class CdoClientException extends CdoException
{
  /**
   * 
   */
  private static final long serialVersionUID = 3832620685939126838L;

  /**
   * 
   */
  public CdoClientException()
  {
    super();
  }

  /**
   * @param message
   */
  public CdoClientException(String message)
  {
    super(message);
  }

  /**
   * @param cause
   */
  public CdoClientException(Throwable cause)
  {
    super(cause);
  }

  /**
   * @param message
   * @param cause
   */
  public CdoClientException(String message, Throwable cause)
  {
    super(message, cause);
  }
}