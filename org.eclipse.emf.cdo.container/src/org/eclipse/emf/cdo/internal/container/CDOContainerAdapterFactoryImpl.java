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

import org.eclipse.net4j.container.ContainerAdapter;
import org.eclipse.net4j.container.ContainerAdapterFactory;
import org.eclipse.net4j.internal.container.ContainerImpl;

public final class CDOContainerAdapterFactoryImpl implements ContainerAdapterFactory
{
  public CDOContainerAdapterFactoryImpl()
  {
  }

  public String getType()
  {
    return CDOConstants.TYPE;
  }

  public ContainerAdapter createAdapter(ContainerImpl container)
  {
    return new CDOContainerAdapterImpl(container);
  }
}