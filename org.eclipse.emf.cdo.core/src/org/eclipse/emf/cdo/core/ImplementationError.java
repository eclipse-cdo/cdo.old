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
 * @author Eike Stepper
 */
public class ImplementationError extends RuntimeException
{
  /**
   * Needed for serialization.<p>
   */
  private static final long serialVersionUID = 1L;

  public ImplementationError()
  {
  }

  public ImplementationError(String message)
  {
    super(message);
  }

  public ImplementationError(Throwable cause)
  {
    super(cause);
  }

  public ImplementationError(String message, Throwable cause)
  {
    super(message, cause);
  }
}
