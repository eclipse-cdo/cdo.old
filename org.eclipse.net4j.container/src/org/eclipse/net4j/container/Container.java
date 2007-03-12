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
package org.eclipse.net4j.container;

import org.eclipse.net4j.transport.ConnectorLocation;
import org.eclipse.net4j.transport.IAcceptor;
import org.eclipse.net4j.transport.IBufferProvider;
import org.eclipse.net4j.transport.IChannel;
import org.eclipse.net4j.transport.IChannelID;
import org.eclipse.net4j.transport.IConnector;
import org.eclipse.net4j.transport.IProtocolFactory;
import org.eclipse.net4j.transport.IProtocolFactoryID;
import org.eclipse.net4j.util.factory.IFactory;
import org.eclipse.net4j.util.registry.IRegistry;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/**
 * @author Eike Stepper
 */
public interface Container
{
  public ExecutorService getExecutorService();

  public IBufferProvider getBufferProvider();

  /*
   * ContainerAdapterFactory
   */

  public IRegistry<String, ContainerAdapterFactory> getAdapterFactoryRegistry();

  public void registerContainerAdapterFactory(ContainerAdapterFactory factory);

  public void deregisterContainerAdapterFactory(ContainerAdapterFactory factory);

  /*
   * ContainerAdapter
   */

  public IRegistry<String, ContainerAdapter> getAdapterRegistry();

  public ContainerAdapter getAdapter(String type);

  /*
   * AcceptorFactory
   */

  public IRegistry<String, IFactory<IAcceptor>> getAcceptorFactoryRegistry();

  public void registerAcceptorFactory(IFactory<IAcceptor> factory);

  public void deregisterAcceptorFactory(IFactory<IAcceptor> factory);

  /*
   * ConnectorFactory
   */

  public IRegistry<String, IFactory<IConnector>> getConnectorFactoryRegistry();

  public void registerConnectorFactory(IFactory<IConnector> factory);

  public void deregisterConnectorFactory(IFactory<IConnector> factory);

  /*
   * ProtocolFactory
   */

  public IRegistry<IProtocolFactoryID, IProtocolFactory> getProtocolFactoryRegistry();

  public void registerProtocolFactory(IProtocolFactory factory);

  public void deregisterProtocolFactory(IProtocolFactory factory);

  /*
   * Acceptor
   */

  public IRegistry<String, IAcceptor> getAcceptorRegistry();

  public IAcceptor getAcceptor(String description);

  /*
   * Connector
   */

  public IRegistry<String, IConnector> getConnectorRegistry();

  public IConnector getConnector(String description);

  /*
   * Channel
   */

  public IRegistry<IChannelID, IChannel> getChannelRegistry();

  public Collection<IChannel> getChannels(String protocolID, Set<ConnectorLocation> locations);

  public Collection<IChannel> getChannels(String protocolID);

  public Collection<IChannel> getChannels(Set<ConnectorLocation> locations);
}
