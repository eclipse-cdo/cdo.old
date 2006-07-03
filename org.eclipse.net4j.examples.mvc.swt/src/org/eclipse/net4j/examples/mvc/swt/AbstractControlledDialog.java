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
package org.eclipse.net4j.examples.mvc.swt;


import org.eclipse.net4j.examples.mvc.IController;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public abstract class AbstractControlledDialog extends Dialog implements DisposeListener
{
  private Map<String, IController> controllers = new HashMap<String, IController>();

  public AbstractControlledDialog(Shell parentShell)
  {
    super(parentShell);
  }

  public AbstractControlledDialog(IShellProvider parentShell)
  {
    super(parentShell);
  }

  public IController getFirstController()
  {
    return getControllers().next();
  }

  public IController getController(String name)
  {
    return controllers.get(name);
  }

  public void addController(IController controller)
  {
    controllers.put(controller.getName(), controller);
  }

  public Iterator<IController> getControllers()
  {
    return controllers.values().iterator();
  }

  public void create()
  {
    super.create();
    getContents().addDisposeListener(this);

    initControllers();
    extractTargets(getContents());
    afterTargetsExtracted();
  }

  public boolean close()
  {
    if (getReturnCode() == OK)
    {
      for (Iterator<IController> it = getControllers(); it.hasNext();)
      {
        if (!it.next().mayClose())
        {
          return false;
        }
      }
    }

    return super.close();
  }

  public void widgetDisposed(DisposeEvent e)
  {
    for (Iterator<IController> it = getControllers(); it.hasNext();)
    {
      it.next().dispose();
    }
  }

  protected void extractTargets(Control control)
  {
    Object targetData = control.getData("target");

    if (targetData instanceof String)
    {
      String names[] = ((String)targetData).split("\\.");

      IController controller = names.length == 2 ? getController(names[0]) : null;
      String targetName = names.length == 2 ? names[1] : names[0];

      if (controller != null)
      {
        controller.putTarget(targetName, control);
      }
      else
      {
        for (Iterator<IController> it = getControllers(); it.hasNext();)
        {
          it.next().putTarget(targetName, control);
        }
      }
    }

    if (control instanceof Composite)
    {
      Control[] children = ((Composite)control).getChildren();
      extractTargets(children);
    }
  }

  protected void extractTargets(Control[] controls)
  {
    for (int i = 0; i < controls.length; i++)
    {
      extractTargets(controls[i]);
    }
  }

  protected void afterTargetsExtracted()
  {
    for (Iterator<IController> it = getControllers(); it.hasNext();)
    {
      it.next().afterTargetsSet();
    }
  }

  protected abstract void initControllers();
}
