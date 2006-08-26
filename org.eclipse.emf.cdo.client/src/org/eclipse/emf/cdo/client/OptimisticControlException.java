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
package org.eclipse.emf.cdo.client;


import org.eclipse.emf.cdo.core.CDOException;


/**
 * The {@link OptimisticControlException} class.<p>
 *
 * @author Eike Stepper
 */
public class OptimisticControlException extends CDOException
{
  /**
   * Needed for serialization.<p>
   */
  private static final long serialVersionUID = 1L;

  /**
   * Creates an instance of this class.<p>
   */
  public OptimisticControlException()
  {
    super();
  }

  /**
   * Creates an instance of this class.<p>
   *
   * @param arg0
   */
  public OptimisticControlException(String arg0)
  {
    super(arg0);
  }

  /**
   * Creates an instance of this class.<p>
   *
   * @param arg0
   */
  public OptimisticControlException(Throwable arg0)
  {
    super(arg0);
  }

  /**
   * Creates an instance of this class.<p>
   *
   * @param arg0
   * @param arg1
   */
  public OptimisticControlException(String arg0, Throwable arg1)
  {
    super(arg0, arg1);
  }
}
