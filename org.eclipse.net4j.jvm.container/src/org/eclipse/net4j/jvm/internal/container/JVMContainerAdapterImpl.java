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
package org.eclipse.net4j.jvm.internal.container;

import org.eclipse.net4j.internal.container.ContainerImpl;
import org.eclipse.net4j.internal.container.TransportContainerAdapter;
import org.eclipse.net4j.internal.jvm.JVMAcceptorFactoryImpl;
import org.eclipse.net4j.internal.jvm.JVMConnectorFactoryImpl;
import org.eclipse.net4j.jvm.JVMConstants;
import org.eclipse.net4j.jvm.container.JVMContainerAdapter;
import org.eclipse.net4j.transport.IAcceptorFactory;
import org.eclipse.net4j.transport.IConnectorFactory;

/**
 * @author Eike Stepper
 */
public class JVMContainerAdapterImpl extends TransportContainerAdapter implements JVMContainerAdapter
{
  public JVMContainerAdapterImpl(ContainerImpl container)
  {
    super(container, JVMConstants.TYPE);
  }

  protected IAcceptorFactory createAcceptorFactory()
  {
    return new JVMAcceptorFactoryImpl();
  }

  protected IConnectorFactory createConnectorFactory()
  {
    return new JVMConnectorFactoryImpl();
  }
}
