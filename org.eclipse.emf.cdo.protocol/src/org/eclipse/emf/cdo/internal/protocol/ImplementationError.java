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
package org.eclipse.emf.cdo.internal.protocol;

/**
 * @author Eike Stepper
 */
public class ImplementationError extends RuntimeException
{
  private static final long serialVersionUID = 1L;

  public ImplementationError()
  {
  }

  public ImplementationError(String message)
  {
    super(message);
  }

  public ImplementationError(String message, Throwable cause)
  {
    super(message, cause);
  }

  public ImplementationError(Throwable cause)
  {
    super(cause);
  }
}
