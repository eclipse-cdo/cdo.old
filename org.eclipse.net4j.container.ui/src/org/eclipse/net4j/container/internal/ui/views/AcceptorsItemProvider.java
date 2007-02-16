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
package org.eclipse.net4j.container.internal.ui.views;

import org.eclipse.net4j.container.Container;
import org.eclipse.net4j.transport.Acceptor;
import org.eclipse.net4j.util.registry.IRegistryEvent;
import org.eclipse.net4j.util.registry.IRegistryListener;

import java.util.Collection;

public class AcceptorsItemProvider extends ItemProvider<Container> implements IRegistryListener
{
  public AcceptorsItemProvider()
  {
  }

  public Object getParent(Object child)
  {
    if (child instanceof Acceptor)
    {
      return getInput();
    }

    return null;
  }

  public Object[] getChildren(Object parent)
  {
    if (parent == getInput())
    {
      Collection values = getInput().getAcceptorRegistry().values();
      return values.toArray(new Object[values.size()]);
    }

    return NO_CHILDREN;
  }

  public void notifyRegistryEvent(IRegistryEvent event)
  {
    refreshViewer(false);
  }

  @Override
  protected void connectInput(Container input)
  {
    input.getAcceptorRegistry().addRegistryListener(this);
  }

  @Override
  protected void disconnectInput(Container input)
  {
    input.getAcceptorRegistry().removeRegistryListener(this);
  }
}