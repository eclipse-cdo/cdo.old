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
package org.eclipse.emf.cdo.dbgen;


public class IndexNotFoundException extends DbgenException
{
  /**
   * 
   */
  private static final long serialVersionUID = 3256444702969704499L;

  /**
   * 
   */
  public IndexNotFoundException()
  {
    super();
  }

  /**
   * @param message
   */
  public IndexNotFoundException(String message)
  {
    super(message);
  }

  /**
   * @param cause
   */
  public IndexNotFoundException(Throwable cause)
  {
    super(cause);
  }

  /**
   * @param message
   * @param cause
   */
  public IndexNotFoundException(String message, Throwable cause)
  {
    super(message, cause);
  }
}