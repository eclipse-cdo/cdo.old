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
package org.eclipse.net4j.pop.task.bugzilla.internal.ui;

import org.eclipse.net4j.pop.task.internal.bugzilla.BugzillaConnector;
import org.eclipse.net4j.pop.task.web.spi.ui.WebConfigurer;

/**
 * @author Eike Stepper
 */
public class BugzillaConfigurer extends WebConfigurer
{
  private static final String NAME = BugzillaConnector.NAME;

  public BugzillaConfigurer()
  {
    super(NAME);
  }
}
