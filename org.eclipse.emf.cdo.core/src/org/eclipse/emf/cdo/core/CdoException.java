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
package org.eclipse.emf.cdo.core;


import org.eclipse.net4j.core.CustomProtocolException;


public class CdoException extends CustomProtocolException
{
  /**
   * 
   */
  private static final long serialVersionUID = 3257288036961236279L;

  /**
   * 
   */
  public CdoException()
  {
    super();
  }

  /**
   * @param message
   */
  public CdoException(String message)
  {
    super(message);
  }

  /**
   * @param cause
   */
  public CdoException(Throwable cause)
  {
    super(cause);
  }

  /**
   * @param message
   * @param cause
   */
  public CdoException(String message, Throwable cause)
  {
    super(message, cause);
  }
}