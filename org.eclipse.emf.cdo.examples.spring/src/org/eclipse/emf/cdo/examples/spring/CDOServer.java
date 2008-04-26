/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.examples.spring;

import org.eclipse.net4j.internal.util.om.log.PrintLogHandler;
import org.eclipse.net4j.internal.util.om.trace.PrintTraceHandler;
import org.eclipse.net4j.util.om.OMPlatform;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Eike Stepper
 */
public class CDOServer
{
  private static final String[] CONFIG_FILES = { "net4j.xml", "cdo.xml" };

  public static void main(String[] args) throws Exception
  {
    OMPlatform.INSTANCE.setDebugging(true);
    OMPlatform.INSTANCE.addLogHandler(PrintLogHandler.CONSOLE);
    OMPlatform.INSTANCE.addTraceHandler(PrintTraceHandler.CONSOLE);

    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_FILES);
    while (System.in.available() == 0)
    {
      Thread.sleep(200);
    }

    context.close();
  }
}
