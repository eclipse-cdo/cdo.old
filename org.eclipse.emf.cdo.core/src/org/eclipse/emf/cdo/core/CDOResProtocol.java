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


import org.eclipse.net4j.transport.Protocol;


/**
 * Defines symbolic constants to be 
 * used in payload traffic of the CDORES protocol.<p>
 *
 * @author Eike Stepper
 */
public interface CDOResProtocol extends Protocol, CDOResSignals
{
  /**
   * The identifying name of the CDORES protocol.<p>
   */
  public static final String PROTOCOL_NAME = "cdores";

  /**
   * For internal use only.<p>
   */
  public static final int NO_MORE_RESOURCES = -1;
}
