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
package org.eclipse.emf.cdo.core.protocol;


import java.io.IOException;


public class NoMoreResourceChangesException extends IOException
{
  private static final long serialVersionUID = 3192284008660476749L;

  public NoMoreResourceChangesException()
  {
  }

  public NoMoreResourceChangesException(String arg0)
  {
    super(arg0);
  }
}
