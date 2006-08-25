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
package org.eclipse.emf.cdo.dbgen;


public class TableCreationException extends DBGenException
{
  /**
   * 
   */
  private static final long serialVersionUID = 3977858492600301877L;

  /**
   * 
   */
  public TableCreationException()
  {
    super();
  }

  /**
   * @param message
   */
  public TableCreationException(String message)
  {
    super(message);
  }

  /**
   * @param cause
   */
  public TableCreationException(Throwable cause)
  {
    super(cause);
  }

  /**
   * @param message
   * @param cause
   */
  public TableCreationException(String message, Throwable cause)
  {
    super(message, cause);
  }
}
