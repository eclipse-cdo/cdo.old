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
import org.eclipse.net4j.transport.Channel;
import org.eclipse.net4j.transport.Connector;
import org.eclipse.net4j.util.registry.IRegistryEvent;
import org.eclipse.net4j.util.registry.IRegistryListener;

import java.util.Collection;

public class ConnectorsItemProvider extends ItemProvider<Container> implements IRegistryListener
{
  public ConnectorsItemProvider()
  {
  }

  public Object getParent(Object child)
  {
    if (child instanceof Connector)
    {
      return getInput();
    }

    if (child instanceof Channel)
    {
      return ((Channel)child).getConnector();
    }

    return null;
  }

  public Object[] getChildren(Object parent)
  {
    if (parent == getInput())
    {
      Collection values = getInput().getConnectorRegistry().values();
      return values.toArray(new Object[values.size()]);
    }

    if (parent instanceof Connector)
    {
      return ((Connector)parent).getChannels();
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
    input.getConnectorRegistry().addRegistryListener(this);
    input.getChannelRegistry().addRegistryListener(this);
  }

  @Override
  protected void disconnectInput(Container input)
  {
    input.getConnectorRegistry().removeRegistryListener(this);
    input.getChannelRegistry().removeRegistryListener(this);
  }
}