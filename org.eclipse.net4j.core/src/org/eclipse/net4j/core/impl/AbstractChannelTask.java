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
package org.eclipse.net4j.core.impl;


import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.core.Task;
import org.eclipse.net4j.spring.Container;
import org.eclipse.net4j.spring.Loggable;

import org.apache.log4j.Logger;


public abstract class AbstractChannelTask implements Task, Loggable
{
  protected Channel channel;

  public AbstractChannelTask(Channel channel)
  {
    this.channel = channel;
  }

  public void debug(String message)
  {
    channel.debug(message);
  }

  public void debug(String message, Throwable t)
  {
    channel.debug(message, t);
  }

  public void error(String message)
  {
    channel.error(message);
  }

  public void error(String message, Throwable t)
  {
    channel.error(message, t);
  }

  public void fatal(String message)
  {
    channel.fatal(message);
  }

  public void fatal(String message, Throwable t)
  {
    channel.fatal(message, t);
  }

  public void info(String message)
  {
    channel.info(message);
  }

  public void info(String message, Throwable t)
  {
    channel.info(message, t);
  }

  public boolean isDebugEnabled()
  {
    return channel.isDebugEnabled();
  }

  public boolean isErrorEnabled()
  {
    return channel.isErrorEnabled();
  }

  public boolean isFatalEnabled()
  {
    return channel.isFatalEnabled();
  }

  public boolean isInfoEnabled()
  {
    return channel.isInfoEnabled();
  }

  public boolean isWarnEnabled()
  {
    return channel.isWarnEnabled();
  }

  public void warn(String message)
  {
    channel.warn(message);
  }

  public void warn(String message, Throwable t)
  {
    channel.warn(message, t);
  }

  public String getBeanName()
  {
    return channel.getBeanName();
  }

  public Loggable getChild(String name)
  {
    return channel.getChild(name);
  }

  public Container getContainer()
  {
    return channel.getContainer();
  }

  public String getFullBeanName()
  {
    return channel.getFullBeanName();
  }

  public Logger getLogger()
  {
    return channel.getLogger();
  }
}
