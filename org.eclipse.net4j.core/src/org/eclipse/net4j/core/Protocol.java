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


import org.eclipse.net4j.spring.Service;


public interface Protocol extends Service
{
  public static final int SERVER = 1;

  public static final int CLIENT = 2;

  public static final int SYMMETRIC = SERVER | CLIENT;

  public String getName();

  public int getType();

  public boolean isClient();

  public boolean isServer();

  public Indication createIndication(short signalId);

  public Channel[] getChannels();

  public void registerChannel(Channel channel) throws Exception;

  public void deregisterChannel(Channel channel) throws Exception;
}
