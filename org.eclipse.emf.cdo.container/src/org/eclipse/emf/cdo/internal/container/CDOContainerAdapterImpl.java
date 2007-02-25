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

import static org.eclipse.net4j.util.registry.IRegistryDelta.Kind.REGISTERED;

import org.eclipse.emf.cdo.CDOConstants;
import org.eclipse.emf.cdo.CDOSession;
import org.eclipse.emf.cdo.container.CDOContainerAdapter;
import org.eclipse.emf.cdo.util.CDOUtil;

import org.eclipse.net4j.internal.container.ContainerImpl;
import org.eclipse.net4j.internal.container.ProtocolContainerAdapter;
import org.eclipse.net4j.transport.Connector;
import org.eclipse.net4j.transport.ConnectorException;
import org.eclipse.net4j.transport.ProtocolFactory;
import org.eclipse.net4j.util.lifecycle.LifecycleAdapter;
import org.eclipse.net4j.util.lifecycle.LifecycleListener;
import org.eclipse.net4j.util.lifecycle.LifecycleNotifier;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.net4j.util.registry.IRegistry;
import org.eclipse.net4j.util.registry.IRegistryDelta;
import org.eclipse.net4j.util.registry.IRegistryEvent;
import org.eclipse.net4j.util.registry.IRegistryListener;

import org.eclipse.emf.internal.cdo.protocol.ClientProtocolFactory;

import org.eclipse.internal.net4j.util.registry.HashMapRegistry;

import java.util.Collection;
import java.util.Set;

/**
 * @author Eike Stepper
 */
public class CDOContainerAdapterImpl extends ProtocolContainerAdapter implements CDOContainerAdapter
{
  private IRegistry<String, CDOSession> sessionRegistry;

  private Set<String> descriptions;

  private IRegistryListener registryListener = new IRegistryListener()
  {
    public void notifyRegistryEvent(IRegistryEvent event)
    {
      createSessions();
    }
  };

  private IRegistryListener<String, CDOSession> sessionRegistryListener = new IRegistryListener<String, CDOSession>()
  {
    public void notifyRegistryEvent(IRegistryEvent<String, CDOSession> event)
    {
      IRegistryDelta<String, CDOSession>[] deltas = event.getDeltas();
      for (IRegistryDelta<String, CDOSession> delta : deltas)
      {
        String description = delta.getKey();
        CDOSession session = delta.getValue();
        switch (delta.getKind())
        {
        case REGISTERED:
          descriptions.add(description);
          LifecycleUtil.addListener(session, lifecycleListener);
          break;
        }
      }
    }
  };

  private LifecycleListener lifecycleListener = new LifecycleAdapter()
  {
    @Override
    public void notifyLifecycleDeactivating(LifecycleNotifier notifier)
    {
      if (notifier instanceof CDOSession)
      {
        CDOSession session = (CDOSession)notifier;
        String description = getDescription(session);
        descriptions.remove(description);
        sessionRegistry.remove(description);
      }

      LifecycleUtil.removeListener(notifier, lifecycleListener);
    }
  };

  public CDOContainerAdapterImpl(ContainerImpl container)
  {
    super(container, CDOConstants.TYPE);
  }

  public IRegistry<String, CDOSession> getSessionRegistry()
  {
    return sessionRegistry;
  }

  public CDOSession getSession(String description) throws ConnectorException
  {
    String[] tokens = description.split("@");
    String repositoryName = tokens[0];
    String connectorDescription = tokens[1];

    Connector connector = getContainer().getConnector(connectorDescription);
    CDOSession session = CDOUtil.openSession(connector, repositoryName);

    sessionRegistry.put(description, session);
    return session;
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
    descriptions = getDescriptions();
    createSessions();
    getContainer().getAcceptorRegistry().addRegistryListener(registryListener);
    getContainer().getConnectorFactoryRegistry().addRegistryListener(registryListener);
    sessionRegistry.addRegistryListener(sessionRegistryListener);
  }

  @Override
  protected void onDeactivate() throws Exception
  {
    sessionRegistry.removeRegistryListener(sessionRegistryListener);
    getContainer().getConnectorFactoryRegistry().removeRegistryListener(registryListener);
    getContainer().getAcceptorRegistry().removeRegistryListener(registryListener);

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

  private void createSessions()
  {
    for (String description : descriptions)
    {
      try
      {
        getSession(description);
      }
      catch (Exception ignore)
      {
      }
    }
  }

  private Set<String> getDescriptions()
  {
    return getContainer().getAdapterConfig(CDOConstants.TYPE);
  }

  public static String getDescription(CDOSession session)
  {
    String repository = session.getRepository().getName();
    String connector = session.getChannel().getConnector().getDescription();
    return repository + "@" + connector;
  }
}
