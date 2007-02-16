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

import org.eclipse.emf.cdo.server.ServerConstants;

import org.eclipse.net4j.container.Container;
import org.eclipse.net4j.container.ContainerAdapter;
import org.eclipse.net4j.container.ContainerAdapterFactory;

public final class CDOServerContainerAdapterFactoryImpl implements ContainerAdapterFactory
{
  public CDOServerContainerAdapterFactoryImpl()
  {
  }

  public String getType()
  {
    return ServerConstants.TYPE;
  }

  public ContainerAdapter createAdapter(Container container)
  {
    return new CDOServerContainerAdapterImpl(container);
  }
}