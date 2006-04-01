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


import org.eclipse.net4j.spring.Loggable;


public interface Signal extends Loggable
{
  public Channel getChannel();

  public String getName();

  public short getSignalId();

  public Protocol getProtocol();

  public boolean hasResponse();

  public void setChannel(Channel channel);
}
