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
package org.eclipse.net4j.examples.mvc.util;


public class NoTargetException extends RuntimeException
{
  private static final long serialVersionUID = 3977585787980035383L;

  public NoTargetException()
  {
    super();
  }

  public NoTargetException(String message)
  {
    super(message);
  }
}
