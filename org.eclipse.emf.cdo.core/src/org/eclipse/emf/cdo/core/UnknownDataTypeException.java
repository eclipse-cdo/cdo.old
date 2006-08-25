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


public class UnknownDataTypeException extends CDOException
{
  /**
   * 
   */
  private static final long serialVersionUID = 3257844363974424370L;

  public UnknownDataTypeException()
  {
    super();
  }

  public UnknownDataTypeException(String message)
  {
    super(message);
  }

  public UnknownDataTypeException(Throwable cause)
  {
    super(cause);
  }

  public UnknownDataTypeException(String message, Throwable cause)
  {
    super(message, cause);
  }
}
