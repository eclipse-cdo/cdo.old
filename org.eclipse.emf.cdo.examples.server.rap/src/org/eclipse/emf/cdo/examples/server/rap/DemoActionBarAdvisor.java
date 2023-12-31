/**
 * Copyright (c) 2004 - 2010 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.emf.cdo.examples.server.rap;

import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

/**
 * An action bar advisor is responsible for creating, adding, and disposing of the actions added to a workbench window.
 * Each window will be populated with new actions.
 * 
 * @author Eike Stepper
 */
public class DemoActionBarAdvisor extends ActionBarAdvisor
{
  // Actions - important to allocate these only in makeActions, and then use
  // them
  // in the fill methods. This ensures that the actions aren't recreated
  // when fillActionBars is called with FILL_PROXY.
  public DemoActionBarAdvisor(IActionBarConfigurer configurer)
  {
    super(configurer);
  }
}
