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
package org.eclipse.net4j.spring;


import org.apache.log4j.Logger;


public interface Loggable
{
  public String getBeanName();

  public String getFullBeanName();

  public Container getContainer();

  public Loggable getChild(String name);

  public void debug(String message);

  public void debug(String message, Throwable t);

  public void info(String message);

  public void info(String message, Throwable t);

  public void warn(String message);

  public void warn(String message, Throwable t);

  public void error(String message);

  public void error(String message, Throwable t);

  public void fatal(String message);

  public void fatal(String message, Throwable t);

  public boolean isDebugEnabled();

  public boolean isInfoEnabled();

  public boolean isWarnEnabled();

  public boolean isErrorEnabled();

  public boolean isFatalEnabled();

  public Logger getLogger();
}
