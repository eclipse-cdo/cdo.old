/**
 * Copyright (c) 2004 - 2010 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *
 *  Initial Publication:
 *    Eclipse Magazin - http://www.eclipse-magazin.de
 */
package org.eclipse.net4j.examples.fshare.ui.app;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

/**
 * @author Eike Stepper
 */
public class Application implements IApplication
{
  private static String targetURL;

  public Application()
  {
  }

  public Object start(IApplicationContext context)
  {
    String[] args = (String[])context.getArguments().get(IApplicationContext.APPLICATION_ARGS);
    if (args == null || args.length == 0)
    {
      throw new IllegalArgumentException("No target URL!");
    }

    targetURL = args[0];
    Display display = PlatformUI.createDisplay();

    try
    {
      int returnCode = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
      if (returnCode == PlatformUI.RETURN_RESTART)
      {
        return IApplication.EXIT_RESTART;
      }

      return IApplication.EXIT_OK;
    }
    finally
    {
      display.dispose();
    }
  }

  public void stop()
  {
    final IWorkbench workbench = PlatformUI.getWorkbench();
    if (workbench == null)
    {
      return;
    }

    final Display display = workbench.getDisplay();
    display.syncExec(new Runnable()
    {
      public void run()
      {
        if (!display.isDisposed())
        {
          workbench.close();
        }
      }
    });
  }

  public static String getTargetURL()
  {
    return targetURL;
  }
}
