/***************************************************************************
 * Copyright (c) 2004-2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.examples.client.ui;


import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Shell;


public abstract class BusyTemplate
{
  private Shell shell;

  public BusyTemplate(Shell shell)
  {
    this.shell = shell;
  }

  public Object execute()
  {
    try
    {
      final Object[] result = new Object[1];

      Runnable r = new Runnable()
      {
        public void run()
        {
          try
          {
            result[0] = BusyTemplate.this.run();
          }
          catch (Exception ex)
          {
            ClientUIActivator.getDefault().error("Error while executing runnable " + this, ex);
          }
        }
      };

      BusyIndicator.showWhile(shell.getDisplay(), r);
      return result[0];
    }
    catch (OperationCanceledException e)
    {
      return null;
    }
  }

  protected abstract Object run() throws Exception;
}
