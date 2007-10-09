/***************************************************************************
 * Copyright (c) 2004 - 2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.buddies.internal.protocol;

/**
 * @author Eike Stepper
 */
public interface ProtocolConstants
{
  public static final String PROTOCOL_NAME = "buddies";

  public static final short SIGNAL_OPEN_SESSION = 1;

  public static final short SIGNAL_LOAD_ACCOUNT = 2;

  public static final short SIGNAL_BUDDY_ADDED = 3;

  public static final short SIGNAL_BUDDY_REMOVED = 4;

  public static final short SIGNAL_BUDDY_STATE = 5;

  public static final short SIGNAL_INITIATE_COLLABORATION = 6;

  public static final short SIGNAL_INSTALL_FACILITY = 7;

  public static final short SIGNAL_MESSAGE = 8;

  public static final byte STATE_AVAILABLE = 1;

  public static final byte STATE_LONESOME = 2;

  public static final byte STATE_AWAY = 3;

  public static final byte STATE_DO_NOT_DISTURB = 4;
}
