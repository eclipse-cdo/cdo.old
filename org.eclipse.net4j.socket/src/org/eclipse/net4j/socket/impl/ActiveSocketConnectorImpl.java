/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.socket.impl;


import org.eclipse.net4j.core.ControlProtocol;
import org.eclipse.net4j.socket.ActiveSocketConnector;
import org.eclipse.net4j.spring.ValidationException;

import java.nio.channels.SocketChannel;

import java.net.InetAddress;
import java.net.InetSocketAddress;


public class ActiveSocketConnectorImpl extends AbstractSocketConnector implements
    ActiveSocketConnector
{
  public static final int DEFAULT_PORT = DENSITY_PORT;

  private String host;

  private int port = DEFAULT_PORT;

  public String getHost()
  {
    return host;
  }

  public void setHost(String host)
  {
    doSet("host", host);
  }

  public int getPort()
  {
    return port;
  }

  public void setPort(int port)
  {
    doSet("port", port);
  }

  public int getType()
  {
    return CLIENT;
  }

  protected void prepareBasicChannel() throws InterruptedException
  {
    addChannel(ControlProtocol.PROTOCOL_NAME);

    long start = System.currentTimeMillis();
    while (!isAuthenticated())
    {
      // TODO introduce DeadlockDetector.sleep() throws ThreadInterruptedException
      Thread.sleep(250);

      if (System.currentTimeMillis() > start + getAuthenticationTimeout())
      {
        warn("Timeout while authenticating");
        break;
      }
    }
  }

  @Override
  protected void validate() throws ValidationException
  {
    super.validate();
    assertNotNull("host");
  }

  @Override
  protected void activate() throws Exception
  {
    SocketChannel socketChannel = SocketChannel.open();
    socketChannel.configureBlocking(false);
    setSocketChannel(socketChannel);

    InetSocketAddress addr = new InetSocketAddress(InetAddress.getByName(host), port);
    socketChannel.connect(addr);
    super.activate();
  }

  @Override
  protected void deactivate() throws Exception
  {
    super.deactivate();

    if (getSocketChannel() != null)
    {
      getSocketChannel().close();
      setSocketChannel(null);
      if (isDebugEnabled()) info("Disconnected");
    }
  }
}
