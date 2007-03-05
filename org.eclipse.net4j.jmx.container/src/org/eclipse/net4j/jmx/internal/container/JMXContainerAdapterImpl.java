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

import org.eclipse.net4j.internal.container.AbstractContainerAdapter;
import org.eclipse.net4j.internal.container.ContainerImpl;
import org.eclipse.net4j.jmx.container.JMXConstants;
import org.eclipse.net4j.jmx.container.JMXContainerAdapter;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;

/**
 * @author Eike Stepper
 */
public class JMXContainerAdapterImpl extends AbstractContainerAdapter implements JMXContainerAdapter
{
  private MBeanServer mbeanServer;

  public JMXContainerAdapterImpl(ContainerImpl container)
  {
    super(container, JMXConstants.TYPE);
  }

  public MBeanServer getMBeanServer()
  {
    return mbeanServer;
  }

  @Override
  protected void doActivate() throws Exception
  {
    super.doActivate();
    mbeanServer = MBeanServerFactory.createMBeanServer();
  }

  @Override
  protected void doDeactivate() throws Exception
  {
    MBeanServerFactory.releaseMBeanServer(mbeanServer);
    mbeanServer = null;
    super.doDeactivate();
  }
}
