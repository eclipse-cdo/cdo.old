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
package org.eclipse.net4j.core;


import org.eclipse.net4j.spring.Service;


public interface Channel extends Service, DataListener, Receiver, Transmitter
{
  public static final int IDLE = 0;

  public static final int REQUESTING = 1;

  public static final int INDICATING = 2;

  public static final int INDIQUESTING = 3;

  public static final int RESPONDING = 4;

  public static final int CONFIRMING = 5;

  public static final int REQUEST_START = 0;

  public static final int REQUEST_END = 1;

  public static final int INDICATE_START = 2;

  public static final int INDICATE_END = 3;

  public static final int RESPOND_START = 4;

  public static final int RESPOND_END = 5;

  public static final int CONFIRM_START = 6;

  public static final int CONFIRM_END = 7;

  public static final int HEADER_SIZE = 4;

  public int getCommState();

  public void setCommState(int state);

  public void processCommEvent(int event);

  public boolean isTransmittingAllowed();

  public boolean isReceivingAllowed();

  public Object transmit(Request request);

  public Connector getConnector();

  public short getChannelIndex();

  public Protocol getProtocol();

  public Object getProtocolData();

  public void setProtocolData(Object data);

  public void start() throws Exception;

  public void stop() throws Exception;

  public void cancel(String code);

  public boolean isCancelled();

  /**
   * internal
   */
  public void handleTransmission();

  /**
   * internal
   */
  public Request getCurrentRequest();

  /**
   * internal
   */
  public void setConnector(Connector connector);

  /**
   * internal
   */
  public void setProtocol(Protocol protocol);

  /**
   * internal
   */
  public void setChannelIndex(short channelIndex);
}
