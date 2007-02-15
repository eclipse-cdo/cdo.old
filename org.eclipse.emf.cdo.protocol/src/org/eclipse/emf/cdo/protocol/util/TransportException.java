/***************************************************************************
 * Copyright (c) 2004-2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.protocol.util;

/**
 * @author Eike Stepper
 */
public class TransportException extends RuntimeException
{
  private static final long serialVersionUID = 1L;

  public TransportException()
  {
  }

  public TransportException(String message)
  {
    super(message);
  }

  public TransportException(String message, Throwable cause)
  {
    super(message, cause);
  }

  public TransportException(Throwable cause)
  {
    super(cause);
  }
}
