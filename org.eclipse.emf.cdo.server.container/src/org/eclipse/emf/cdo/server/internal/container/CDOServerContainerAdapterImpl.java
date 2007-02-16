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
package org.eclipse.emf.cdo.server.internal.container;

import org.eclipse.emf.cdo.internal.server.protocol.ServerProtocolFactory;
import org.eclipse.emf.cdo.server.ServerConstants;
import org.eclipse.emf.cdo.server.container.CDOServerContainerAdapter;

import org.eclipse.net4j.container.Container;
import org.eclipse.net4j.internal.container.ProtocolContainerAdapter;
import org.eclipse.net4j.transport.ProtocolFactory;

/**
 * @author Eike Stepper
 */
public class CDOServerContainerAdapterImpl extends ProtocolContainerAdapter implements CDOServerContainerAdapter
{
  public CDOServerContainerAdapterImpl(Container container)
  {
    super(container, ServerConstants.TYPE);
  }

  protected ProtocolFactory createProtocolFactory()
  {
    return new ServerProtocolFactory();
  }
}
