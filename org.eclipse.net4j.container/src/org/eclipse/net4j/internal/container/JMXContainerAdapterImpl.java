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

import org.eclipse.net4j.container.Container;
import org.eclipse.net4j.container.JMXContainerAdapter;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;

public class JMXContainerAdapterImpl extends AbstractContainerAdapter implements JMXContainerAdapter
{
  private MBeanServer mbeanServer;

  protected JMXContainerAdapterImpl(Container container, String type)
  {
    super(container, type);
  }

  public MBeanServer getMBeanServer()
  {
    return mbeanServer;
  }

  @Override
  protected void onActivate() throws Exception
  {
    super.onActivate();
    mbeanServer = MBeanServerFactory.createMBeanServer();
  }

  @Override
  protected void onDeactivate() throws Exception
  {
    MBeanServerFactory.releaseMBeanServer(mbeanServer);
    mbeanServer = null;
    super.onDeactivate();
  }
}