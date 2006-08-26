/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.core;


/**
 * The {@link NoMoreOIDsException} class.<p>
 *
 * @author Eike Stepper
 */
public class NoMoreOIDsException extends CDOException
{
  /**
   * Needed for serialization.<p>
   */
  private static final long serialVersionUID = 1L;

  /**
   * Creates an instance of this class.<p>
   */
  public NoMoreOIDsException()
  {
    super();
  }

  /**
   * Creates an instance of this class.<p>
   *
   * @param message
   */
  public NoMoreOIDsException(String message)
  {
    super(message);
  }

  /**
   * Creates an instance of this class.<p>
   *
   * @param cause
   */
  public NoMoreOIDsException(Throwable cause)
  {
    super(cause);
  }

  /**
   * Creates an instance of this class.<p>
   *
   * @param message
   * @param cause
   */
  public NoMoreOIDsException(String message, Throwable cause)
  {
    super(message, cause);
  }
}
