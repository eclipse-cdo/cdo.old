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

import org.eclipse.net4j.transport.ProtocolFactory;

public abstract class ProtocolContainerAdapter extends AbstractContainerAdapter
{
  private ProtocolFactory protocolFactory;

  protected ProtocolContainerAdapter(ContainerImpl container, String type)
  {
    super(container, type);
    protocolFactory = createProtocolFactory();
  }

  @Override
  protected void onActivate() throws Exception
  {
    super.onActivate();
    getContainer().register(protocolFactory);
  }

  @Override
  protected void onDeactivate() throws Exception
  {
    getContainer().deregister(protocolFactory);
    super.onDeactivate();
  }

  protected abstract ProtocolFactory createProtocolFactory();
}