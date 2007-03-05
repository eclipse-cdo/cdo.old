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
package org.eclipse.net4j.tcp.internal.container;

import org.eclipse.net4j.internal.container.ContainerImpl;
import org.eclipse.net4j.internal.container.TransportContainerAdapter;
import org.eclipse.net4j.internal.tcp.ClientTCPConnectorImpl;
import org.eclipse.net4j.internal.tcp.TCPAcceptorFactoryImpl;
import org.eclipse.net4j.internal.tcp.TCPAcceptorImpl;
import org.eclipse.net4j.internal.tcp.TCPConnectorFactoryImpl;
import org.eclipse.net4j.internal.tcp.TCPSelectorImpl;
import org.eclipse.net4j.tcp.TCPConstants;
import org.eclipse.net4j.tcp.container.TCPContainerAdapter;
import org.eclipse.net4j.transport.IAcceptorFactory;
import org.eclipse.net4j.transport.IConnectorFactory;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;

/**
 * @author Eike Stepper
 */
public class TCPContainerAdapterImpl extends TransportContainerAdapter implements TCPContainerAdapter
{
  private TCPSelectorImpl selector;

  public TCPContainerAdapterImpl(ContainerImpl container)
  {
    super(container, TCPConstants.TYPE);
    selector = new TCPSelectorImpl();
  }

  public TCPSelectorImpl getSelector()
  {
    return selector;
  }

  @Override
  protected void doActivate() throws Exception
  {
    super.doActivate();
    LifecycleUtil.activate(selector);
  }

  @Override
  protected void doDeactivate() throws Exception
  {
    LifecycleUtil.deactivate(selector);
    super.doDeactivate();
  }

  protected IAcceptorFactory createAcceptorFactory()
  {
    return new TCPAcceptorFactoryImpl();
  }

  protected IConnectorFactory createConnectorFactory()
  {
    return new TCPConnectorFactoryImpl();
  }

  @Override
  protected void addedToContainer(Object object)
  {
    if (object instanceof TCPAcceptorImpl)
    {
      TCPAcceptorImpl acceptor = (TCPAcceptorImpl)object;
      acceptor.setSelector(getSelector());
    }
    else if (object instanceof ClientTCPConnectorImpl)
    {
      ClientTCPConnectorImpl connector = (ClientTCPConnectorImpl)object;
      connector.setSelector(getSelector());
    }
  }
}
