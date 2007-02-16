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
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;

/**
 * @author Eike Stepper
 */
public class ContainerManagerImpl implements ContainerManager
{
  public static final ContainerManagerImpl INSTANCE = new ContainerManagerImpl();

  private Container container;

  public ContainerManagerImpl()
  {
  }

  public Container getContainer()
  {
    if (container == null)
    {
      try
      {
        container = ContainerUtil.createContainer();
        LifecycleUtil.activate(container);
      }
      catch (Exception ex)
      {
        // TODO Introduce unchecked LifecycleException
        throw new IllegalStateException(ex);
      }
    }

    return container;
  }
}