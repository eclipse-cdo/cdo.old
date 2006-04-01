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
package org.eclipse.net4j.socket.impl;


import org.eclipse.net4j.core.Connector;
import org.eclipse.net4j.core.impl.AbstractAcceptor;
import org.eclipse.net4j.socket.SocketAcceptor;
import org.eclipse.net4j.socket.SocketConnector;
import org.eclipse.net4j.spring.ValidationException;
import org.eclipse.net4j.util.thread.Worker;

import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import java.net.InetAddress;
import java.net.InetSocketAddress;


public class SocketAcceptorImpl extends AbstractAcceptor implements SocketAcceptor
{
  public static final String DEFAULT_ADDR = "0.0.0.0";

  public static final String DEFAULT_SLAVE_NAME = "slave";

  public static final int DEFAULT_PORT = DENSITY_PORT;

  private String listenAddr = DEFAULT_ADDR;

  private String slaveName = DEFAULT_SLAVE_NAME;

  private int listenPort = DEFAULT_PORT;

  private transient Listener listener;

  private transient ServerSocketChannel serverChannel;

  public String getListenAddr()
  {
    return listenAddr;
  }

  public void setListenAddr(String listenAddr)
  {
    doSet("listenAddr", listenAddr);
  }

  public int getListenPort()
  {
    return listenPort;
  }

  public void setListenPort(int listenPort)
  {
    doSet("listenPort", listenPort);
  }

  public String getSlaveName()
  {
    return slaveName;
  }

  public void setSlaveName(String slaveName)
  {
    doSet("slaveName", slaveName);
  }

  protected Connector createSlave(SocketChannel socketChannel)
  {
    SocketConnector slave = (SocketConnector) getContainer().getBean(slaveName);
    slave.setSocketChannel(socketChannel);
    return slave;
  }

  @Override
  protected void validate() throws ValidationException
  {
    super.validate();
    assertNotNull("listenAddr");
  }

  @Override
  protected void activate() throws Exception
  {
    super.activate();
    serverChannel = ServerSocketChannel.open();

    InetAddress iAddr = InetAddress.getByName(listenAddr);
    InetSocketAddress addr = new InetSocketAddress(iAddr, listenPort);
    serverChannel.socket().bind(addr);

    listener = new Listener();
    listener.setDaemon(true);
    listener.startup();
  }

  @Override
  protected void deactivate() throws Exception
  {
    super.deactivate();

    if (listener != null)
    {
      listener.shutdown(200);
      listener = null;
    }

    if (serverChannel != null)
    {
      serverChannel.close();
    }
  }


  private class Listener extends Worker
  {
    public Listener()
    {
      super(getFullBeanName() + ".Listener");
    }

    public long doWorkStep(int progress)
    {
      SocketChannel socketChannel = null;

      try
      {
        socketChannel = serverChannel.accept();
      }
      catch (ClosedByInterruptException ex)
      {
        return TERMINATE;
      }
      catch (Exception ex)
      {
        if (isActive()) error("Error while accepting a socket channel", ex);
        return TERMINATE;
      }

      Connector slave = createSlave(socketChannel);
      accept(slave);

      return NO_PAUSE;
    }
  }
}