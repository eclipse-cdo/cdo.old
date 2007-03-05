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

import org.eclipse.net4j.transport.IProtocolFactory;

public abstract class ProtocolContainerAdapter extends AbstractContainerAdapter
{
  private IProtocolFactory protocolFactory;

  protected ProtocolContainerAdapter(ContainerImpl container, String type)
  {
    super(container, type);
    protocolFactory = createProtocolFactory();
  }

  @Override
  protected void doActivate() throws Exception
  {
    super.doActivate();
    getContainer().register(protocolFactory);
  }

  @Override
  protected void doDeactivate() throws Exception
  {
    getContainer().deregister(protocolFactory);
    super.doDeactivate();
  }

  protected abstract IProtocolFactory createProtocolFactory();
}