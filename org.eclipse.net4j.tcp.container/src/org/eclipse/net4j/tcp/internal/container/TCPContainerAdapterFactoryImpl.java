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

import org.eclipse.net4j.container.ContainerAdapter;
import org.eclipse.net4j.container.ContainerAdapterFactory;
import org.eclipse.net4j.internal.container.ContainerImpl;
import org.eclipse.net4j.tcp.TCPConstants;

public final class TCPContainerAdapterFactoryImpl implements ContainerAdapterFactory
{
  public TCPContainerAdapterFactoryImpl()
  {
  }

  public String getType()
  {
    return TCPConstants.TYPE;
  }

  public ContainerAdapter createAdapter(ContainerImpl container)
  {
    return new TCPContainerAdapterImpl(container);
  }
}