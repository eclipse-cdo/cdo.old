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
package org.eclipse.net4j.core;


public interface ControlProtocol extends Protocol
{
  public static final String PROTOCOL_NAME = "control";

  public static final short CHANNEL_REGISTRATION = 1;

  public static final short CHANNEL_DEREGISTRATION = 2;

  public static final short GET_PROTOCOLS = 3;

  public static final short CANCELATION = 4;
}
