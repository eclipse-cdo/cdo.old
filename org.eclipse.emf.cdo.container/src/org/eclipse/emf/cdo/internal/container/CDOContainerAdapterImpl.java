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
import org.eclipse.emf.cdo.CDOSession;
import org.eclipse.emf.cdo.container.CDOContainerAdapter;
import org.eclipse.emf.cdo.internal.container.bundle.CDOContainerBundle;
import org.eclipse.emf.cdo.util.CDOUtil;

import org.eclipse.net4j.container.Container;
import org.eclipse.net4j.internal.container.ProtocolContainerAdapter;
import org.eclipse.net4j.transport.Connector;
import org.eclipse.net4j.transport.ProtocolFactory;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.net4j.util.registry.IRegistry;

import org.eclipse.emf.internal.cdo.protocol.ClientProtocolFactory;

import org.eclipse.internal.net4j.util.registry.HashMapRegistry;

import java.util.Collection;

/**
 * @author Eike Stepper
 */
public class CDOContainerAdapterImpl extends ProtocolContainerAdapter implements CDOContainerAdapter
{
  private IRegistry<String, CDOSession> sessionRegistry;

  public CDOContainerAdapterImpl(Container container)
  {
    super(container, CDOConstants.TYPE);
  }

  public IRegistry<String, CDOSession> getSessionRegistry()
  {
    return sessionRegistry;
  }

  public CDOSession getSession(String description)
  {
    try
    {
      String[] tokens = description.split("@");
      String repositoryName = tokens[0];
      String connectorDescription = tokens[1];

      Connector connector = getContainer().getConnector(connectorDescription);
      CDOSession session = CDOUtil.openSession(connector, repositoryName);

      sessionRegistry.put(description, session);
      return session;
    }
    catch (Exception ex)
    {
      CDOContainerBundle.LOG.error(ex);
      return null;
    }
  }

  protected ProtocolFactory createProtocolFactory()
  {
    return new ClientProtocolFactory();
  }

  @Override
  protected void onActivate() throws Exception
  {
    super.onActivate();
    sessionRegistry = createSessionRegistry();
  }

  @Override
  protected void onDeactivate() throws Exception
  {
    Collection<CDOSession> sessions = sessionRegistry.values();
    for (CDOSession session : sessions.toArray(new CDOSession[sessions.size()]))
    {
      LifecycleUtil.deactivateNoisy(session);
    }

    sessionRegistry = null;
    super.onDeactivate();
  }

  protected IRegistry<String, CDOSession> createSessionRegistry()
  {
    return new HashMapRegistry();
  }
}
