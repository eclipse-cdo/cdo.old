/***************************************************************************
 * Copyright (c) 2004-2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.core;


import org.eclipse.net4j.util.Net4jException;


public class IllegalEventException extends Net4jException
{
  private static final long serialVersionUID = 3258129171946551347L;

  public IllegalEventException()
  {
    super();
  }

  public IllegalEventException(String message)
  {
    super(message);
  }

  public IllegalEventException(Throwable cause)
  {
    super(cause);
  }

  public IllegalEventException(String message, Throwable cause)
  {
    super(message, cause);
  }
}
