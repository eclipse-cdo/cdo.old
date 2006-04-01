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
package org.eclipse.net4j.core;


import org.eclipse.net4j.util.Net4jException;


public class NegotiationException extends Net4jException
{
  /**
   * 
   */
  private static final long serialVersionUID = 3256437006320873784L;

  public NegotiationException()
  {
  }

  public NegotiationException(String message)
  {
    super(message);
  }

  public NegotiationException(Throwable cause)
  {
    super(cause);
  }

  public NegotiationException(String message, Throwable cause)
  {
    super(message, cause);
  }
}
