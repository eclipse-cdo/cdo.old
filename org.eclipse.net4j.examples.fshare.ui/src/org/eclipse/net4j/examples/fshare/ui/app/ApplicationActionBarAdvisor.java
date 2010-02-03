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

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

/**
 * @author Eike Stepper
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor
{
  // private IWorkbenchAction exitAction;

  public ApplicationActionBarAdvisor(IActionBarConfigurer configurer)
  {
    super(configurer);
  }

  @Override
  protected void makeActions(final IWorkbenchWindow window)
  {
    // exitAction = ActionFactory.QUIT.create(window);
    // register(exitAction);
  }

  @Override
  protected void fillMenuBar(IMenuManager menuBar)
  {
    // MenuManager fileMenu = new MenuManager("&File", IWorkbenchActionConstants.M_FILE);
    // menuBar.add(fileMenu);
    // fileMenu.add(exitAction);
  }
}
