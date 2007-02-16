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
package org.eclipse.net4j.jmx.internal.container;

import org.eclipse.net4j.container.Container;
import org.eclipse.net4j.container.ContainerAdapter;
import org.eclipse.net4j.container.ContainerAdapterFactory;
import org.eclipse.net4j.jmx.container.JMXConstants;

public final class JMXContainerAdapterFactoryImpl implements ContainerAdapterFactory
{
  public JMXContainerAdapterFactoryImpl()
  {
  }

  public String getType()
  {
    return JMXConstants.TYPE;
  }

  public ContainerAdapter createAdapter(Container container)
  {
    return new JMXContainerAdapterImpl(container);
  }
}