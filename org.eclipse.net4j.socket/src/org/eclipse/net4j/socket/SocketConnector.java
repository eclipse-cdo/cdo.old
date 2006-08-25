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
package org.eclipse.net4j.socket;


import org.eclipse.net4j.core.Connector;

import java.nio.channels.SocketChannel;


public interface SocketConnector extends Connector
{
  public static final int DENSITY_PORT = SocketAcceptor.DENSITY_PORT;

  public static final long DEFAULT_AUTHENTICATION_TIMEOUT = 5000L;

  public long getAuthenticationTimeout();

  public void setAuthenticationTimeout(long authenticationTimeout);

  public SocketChannel getSocketChannel();

  public void setSocketChannel(SocketChannel socketChannel);
}
