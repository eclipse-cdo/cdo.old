/***************************************************************************
 * Copyright (c) 2004-2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.internal.container;

import org.eclipse.net4j.container.Container;
import org.eclipse.net4j.container.ContainerManager;
import org.eclipse.net4j.container.ContainerUtil;
import org.eclipse.net4j.internal.container.bundle.ContainerBundle;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;

import org.eclipse.internal.net4j.util.lifecycle.Lifecycle;

import java.io.File;

/**
 * @author Eike Stepper
 */
public class ContainerManagerImpl extends Lifecycle implements ContainerManager
{
  public static final ContainerManagerImpl INSTANCE = new ContainerManagerImpl();

  private Container container;

  public ContainerManagerImpl()
  {
  }

  public Container getContainer()
  {
    return container;
  }

  @Override
  protected void doActivate() throws Exception
  {
    super.doActivate();
    File folder = new File(ContainerBundle.BUNDLE.getStateLocation());
    File file = new File(folder, "container.state");
    container = ContainerUtil.createContainer(file);
    LifecycleUtil.activate(container);
  }

  @Override
  protected void doDeactivate() throws Exception
  {
    try
    {
      LifecycleUtil.deactivateNoisy(container);
    }
    finally
    {
      container = null;
    }

    super.doDeactivate();
  }
}
