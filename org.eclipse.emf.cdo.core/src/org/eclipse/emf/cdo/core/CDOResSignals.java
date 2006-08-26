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
 * used in signal headers of the CDORES protocol.<p>
 *
 * @author Eike Stepper
 */
public interface CDOResSignals
{
  /**
   * The signal ID of the {@link #QUERY_ALL_RESOURCES} request.<p>
   */
  public static final byte QUERY_ALL_RESOURCES = 1;

  /**
   * Reserved for future use.<p>
   */
  public static final byte QUERY_SUB_RESOURCES = 2;

  /**
   * Reserved for future use.<p>
   */
  public static final byte CREATE_RESOURCE = 3;

  /**
   * Reserved for future use.<p>
   */
  public static final byte REMOVE_RESOURCE = 4;

  /**
   * Reserved for future use.<p>
   */
  public static final byte MOVE_RESOURCE = 5;

  /**
   * The signal ID of the {@link #RESOURCES_CHANGED} notification.<p>
   */
  public static final byte RESOURCES_CHANGED = 6;
}
