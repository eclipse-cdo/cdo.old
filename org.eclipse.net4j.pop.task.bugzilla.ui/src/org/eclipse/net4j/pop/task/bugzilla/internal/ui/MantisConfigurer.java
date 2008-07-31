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

import org.eclipse.net4j.pop.task.ITaskRepositoryConfiguration;
import org.eclipse.net4j.pop.task.internal.bugzilla.MantisConnector;
import org.eclipse.net4j.pop.task.spi.ui.TaskRepositoryConfigurer;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author Eike Stepper
 */
public class MantisConfigurer extends TaskRepositoryConfigurer
{
  private static final String NAME = MantisConnector.NAME;

  public MantisConfigurer()
  {
    super(NAME);
  }

  public Control createControl(Composite parent, ITaskRepositoryConfiguration configuration)
  {
    return null;
  }
}
