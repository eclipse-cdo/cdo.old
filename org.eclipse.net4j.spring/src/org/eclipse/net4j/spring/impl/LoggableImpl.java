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
package org.eclipse.net4j.spring.impl;


import org.eclipse.net4j.spring.Container;
import org.eclipse.net4j.spring.Loggable;
import org.eclipse.net4j.util.IOHelper;

import org.apache.log4j.Logger;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class LoggableImpl implements Loggable, ApplicationContextAware, BeanNameAware
{
  private transient Container container;

  private transient String beanName;

  private transient Logger logger;

  public static final boolean GUARANTEED_LOGGING = false;

  public LoggableImpl()
  {
  }

  public String toString()
  {
    return getFullBeanName();
  }

  /**
   * @return Returns the beanName.
   */
  public String getBeanName()
  {
    return beanName;
  }

  public String getFullBeanName()
  {
    if (container == null || beanName == null)
    {
      return getClass().getName();
    }

    return container.getFullName() + "." + beanName;
  }

  public Container getContainer()
  {
    return container;
  }

  public Loggable getChild(String name)
  {
    LoggableImpl child = new LoggableImpl();
    child.setApplicationContext(container);
    child.setBeanName(beanName + "." + name);
    return child;
  }

  public void debug(String message)
  {
    if (GUARANTEED_LOGGING) IOHelper.log("DEBUG " + message);
    getLogger().debug(message);
  }

  public void debug(String message, Throwable t)
  {
    if (GUARANTEED_LOGGING) IOHelper.log("DEBUG " + message, t);
    getLogger().debug(message, t);
  }

  public void info(String message)
  {
    if (GUARANTEED_LOGGING) IOHelper.log("INFO " + message);
    getLogger().info(message);
  }

  public void info(String message, Throwable t)
  {
    if (GUARANTEED_LOGGING) IOHelper.log("INFO " + message, t);
    getLogger().info(message, t);
  }

  public void warn(String message)
  {
    if (GUARANTEED_LOGGING) IOHelper.log("WARN " + message);
    getLogger().warn(message);
  }

  public void warn(String message, Throwable t)
  {
    if (GUARANTEED_LOGGING) IOHelper.log("WARN " + message, t);
    getLogger().warn(message, t);
  }

  public void error(String message)
  {
    if (GUARANTEED_LOGGING) IOHelper.log("ERROR " + message);
    getLogger().error(message);
  }

  public void error(String message, Throwable t)
  {
    if (GUARANTEED_LOGGING) IOHelper.log("ERROR " + message, t);
    getLogger().error(message, t);
  }

  public void fatal(String message)
  {
    if (GUARANTEED_LOGGING) IOHelper.log("FATAL " + message);
    getLogger().fatal(message);
  }

  public void fatal(String message, Throwable t)
  {
    if (GUARANTEED_LOGGING) IOHelper.log("FATAL " + message, t);
    getLogger().fatal(message, t);
  }

  public boolean isDebugEnabled()
  {
    return getLogger().isDebugEnabled();
  }

  public boolean isInfoEnabled()
  {
    return getLogger().isInfoEnabled();
  }

  public boolean isWarnEnabled()
  {
    return true;
  }

  public boolean isErrorEnabled()
  {
    return true;
  }

  public boolean isFatalEnabled()
  {
    return true;
  }

  /**
   * setBeanName() is called after this bean is populated, but before setApplicationContext() is called.
   * @see org.springframework.beans.factory.BeanNameAware#setBeanName(java.lang.String)
   */
  public void setBeanName(String beanName)
  {
    this.beanName = beanName;
    logger = null;
  }

  /**
   * setApplicationContext() is called after this bean is populated and after setBeanName() is called.
   * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
   */
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
  {
    container = (Container) applicationContext;
    logger = null;
  }

  public Logger getLogger()
  {
    if (logger == null)
    {
      logger = Logger.getLogger(getFullBeanName());
    }
    return logger;
  }
}