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
package org.eclipse.emf.cdo.internal.container;

import org.eclipse.emf.cdo.CDOConstants;
import org.eclipse.emf.cdo.container.CDOContainerAdapter;

import org.eclipse.net4j.container.Container;
import org.eclipse.net4j.internal.container.ProtocolContainerAdapter;
import org.eclipse.net4j.transport.ProtocolFactory;

import org.eclipse.emf.internal.cdo.protocol.ClientProtocolFactory;

/**
 * @author Eike Stepper
 */
public class CDOContainerAdapterImpl extends ProtocolContainerAdapter implements CDOContainerAdapter
{
  public CDOContainerAdapterImpl(Container container)
  {
    super(container, CDOConstants.TYPE);
  }

  protected ProtocolFactory createProtocolFactory()
  {
    return new ClientProtocolFactory();
  }
}
