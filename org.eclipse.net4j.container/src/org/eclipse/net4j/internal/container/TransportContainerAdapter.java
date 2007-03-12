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

public abstract class TransportContainerAdapter extends AbstractContainerAdapter
{
  private IAcceptorFactory acceptorFactory;

  private IConnectorFactory connectorFactory;

  protected TransportContainerAdapter(ContainerImpl container, String type)
  {
    super(container, type);
    acceptorFactory = createAcceptorFactory();
    connectorFactory = createConnectorFactory();
  }

  @Override
  protected void doActivate() throws Exception
  {
    super.doActivate();
    getContainer().registerAcceptorFactory(acceptorFactory);
    getContainer().registerAcceptorFactory(connectorFactory);
  }

  @Override
  protected void doDeactivate() throws Exception
  {
    getContainer().deregisterAcceptorFactory(connectorFactory);
    getContainer().deregisterAcceptorFactory(acceptorFactory);
    super.doDeactivate();
  }

  protected abstract IAcceptorFactory createAcceptorFactory();

  protected abstract IConnectorFactory createConnectorFactory();
}