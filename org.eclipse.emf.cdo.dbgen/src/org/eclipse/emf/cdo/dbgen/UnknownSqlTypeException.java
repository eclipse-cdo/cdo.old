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


public class UnknownSqlTypeException extends RuntimeException
{
  /**
   * 
   */
  private static final long serialVersionUID = 3978147655534719285L;

  public UnknownSqlTypeException()
  {
    super();
  }

  public UnknownSqlTypeException(String arg0)
  {
    super(arg0);
  }

  public UnknownSqlTypeException(String arg0, Throwable arg1)
  {
    super(arg0, arg1);
  }

  public UnknownSqlTypeException(Throwable arg0)
  {
    super(arg0);
  }
}
