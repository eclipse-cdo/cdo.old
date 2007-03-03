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

import org.eclipse.net4j.container.ContainerAdapter;

import org.eclipse.internal.net4j.util.lifecycle.LifecycleImpl;

/**
 * @author Eike Stepper
 */
public abstract class AbstractContainerAdapter extends LifecycleImpl implements ContainerAdapter
{
  private ContainerImpl container;

  private String type;

  public AbstractContainerAdapter(ContainerImpl container, String type)
  {
    this.container = container;
    this.type = type;
  }

  public ContainerImpl getContainer()
  {
    return container;
  }

  public String getType()
  {
    return type;
  }

  protected void addedToContainer(Object object)
  {
  }

  protected void removedFromContainer(Object object)
  {
  }
}
