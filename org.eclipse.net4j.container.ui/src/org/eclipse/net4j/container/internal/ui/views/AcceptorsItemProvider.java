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
import org.eclipse.net4j.container.internal.ui.bundle.SharedIcons;
import org.eclipse.net4j.transport.Acceptor;
import org.eclipse.net4j.transport.Channel;
import org.eclipse.net4j.transport.Connector;
import org.eclipse.net4j.util.registry.IRegistryEvent;
import org.eclipse.net4j.util.registry.IRegistryListener;

import org.eclipse.swt.graphics.Image;

import java.text.MessageFormat;
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

    if (child instanceof Connector)
    {
      Connector connector = (Connector)child;
      Collection<Acceptor> acceptors = getInput().getAcceptorRegistry().values();
      for (Acceptor acceptor : acceptors)
      {
        Connector[] connectors = acceptor.getAcceptedConnectors();
        for (Connector c : connectors)
        {
          if (c == connector)
          {
            return acceptor;
          }
        }
      }
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
      Collection values = getInput().getAcceptorRegistry().values();
      return values.toArray(new Object[values.size()]);
    }

    if (parent instanceof Acceptor)
    {
      Acceptor acceptor = (Acceptor)parent;
      return acceptor.getAcceptedConnectors();
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
  public String getText(Object obj)
  {
    if (obj instanceof Acceptor)
    {
      Acceptor acceptor = (Acceptor)obj;
      return acceptor.getDescription();
    }

    if (obj instanceof Connector)
    {
      Connector connector = (Connector)obj;
      return connector.getDescription();
    }

    if (obj instanceof Channel)
    {
      Channel channel = (Channel)obj;
      return MessageFormat.format("[{0}] {1}", channel.getChannelIndex(), channel.getReceiveHandler());
    }

    return super.getText(obj);
  }

  @Override
  public Image getImage(Object obj)
  {
    if (obj instanceof Acceptor)
    {
      return SharedIcons.OBJ_ACCEPTOR.createImage();
    }

    if (obj instanceof Connector)
    {
      return SharedIcons.OBJ_CONNECTOR.createImage();
    }

    if (obj instanceof Channel)
    {
      return SharedIcons.OBJ_CHANNEL.createImage();
    }

    return null;
  }

  @Override
  protected void connectInput(Container input)
  {
    input.getAcceptorRegistry().addRegistryListener(this);
    input.getConnectorRegistry().addRegistryListener(this);
    input.getChannelRegistry().addRegistryListener(this);
  }

  @Override
  protected void disconnectInput(Container input)
  {
    input.getAcceptorRegistry().removeRegistryListener(this);
    input.getConnectorRegistry().removeRegistryListener(this);
    input.getChannelRegistry().removeRegistryListener(this);
  }
}