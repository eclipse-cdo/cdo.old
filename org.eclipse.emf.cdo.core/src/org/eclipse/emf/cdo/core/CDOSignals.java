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
 * Defines symbolic constants to be 
 * used in signal headers of the CDO protocol.<p>
 *
 * @author Eike Stepper
 */
public interface CDOSignals
{
  /**
   * The signal ID of the {@link #ANNOUNCE_PACKAGE} request.<p>
   */
  public static final byte ANNOUNCE_PACKAGE = 1;

  /**
   * The signal ID of the {@link #DESCRIBE_PACKAGE} request.<p>
   */
  public static final byte DESCRIBE_PACKAGE = 2;

  /**
   * The signal ID of the {@link #RESOURCE_RID} request.<p>
   */
  public static final byte RESOURCE_RID = 3;

  /**
   * The signal ID of the {@link #RESOURCE_PATH} request.<p>
   */
  public static final byte RESOURCE_PATH = 4;

  /**
   * The signal ID of the {@link #LOAD_RESOURCE} request.<p>
   */
  public static final byte LOAD_RESOURCE = 5;

  /**
   * The signal ID of the {@link #LOAD_OBJECT} request.<p>
   */
  public static final byte LOAD_OBJECT = 6;

  /**
   * The signal ID of the {@link #COMMIT_TRANSACTION} request.<p>
   */
  public static final byte COMMIT_TRANSACTION = 7;

  /**
   * The signal ID of the {@link #INVALIDATE_OBJECT} notification.<p>
   */
  public static final byte INVALIDATE_OBJECT = 8;

  /**
   * The signal ID of the {@link #QUERY_EXTENT} request.<p>
   */
  public static final byte QUERY_EXTENT = 9;
}
