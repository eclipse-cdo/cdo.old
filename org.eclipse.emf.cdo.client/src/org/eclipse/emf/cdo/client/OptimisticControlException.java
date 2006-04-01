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
package org.eclipse.emf.cdo.client;


public class OptimisticControlException extends RuntimeException
{

  /**
   * 
   */
  private static final long serialVersionUID = 3257847701231384113L;

  public OptimisticControlException()
  {
    super();
  }

  public OptimisticControlException(String arg0)
  {
    super(arg0);
  }

  public OptimisticControlException(Throwable arg0)
  {
    super(arg0);
  }

  public OptimisticControlException(String arg0, Throwable arg1)
  {
    super(arg0, arg1);
  }

}