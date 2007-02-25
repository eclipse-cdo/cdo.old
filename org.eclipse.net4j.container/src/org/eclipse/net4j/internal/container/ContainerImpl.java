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

import static org.eclipse.net4j.util.registry.IRegistryDelta.Kind.DEREGISTERED;
import static org.eclipse.net4j.util.registry.IRegistryDelta.Kind.REGISTERED;

import org.eclipse.net4j.container.Container;
import org.eclipse.net4j.container.ContainerAdapter;
import org.eclipse.net4j.container.ContainerAdapterFactory;
import org.eclipse.net4j.container.ContainerUtil;
import org.eclipse.net4j.internal.container.bundle.ContainerBundle;
import org.eclipse.net4j.internal.container.store.FileStore;
import org.eclipse.net4j.internal.container.store.Store;
import org.eclipse.net4j.transport.Acceptor;
import org.eclipse.net4j.transport.AcceptorConnectorsEvent;
import org.eclipse.net4j.transport.AcceptorFactory;
import org.eclipse.net4j.transport.BufferHandler;
import org.eclipse.net4j.transport.BufferProvider;
import org.eclipse.net4j.transport.Channel;
import org.eclipse.net4j.transport.ChannelID;
import org.eclipse.net4j.transport.Connector;
import org.eclipse.net4j.transport.ConnectorChannelsEvent;
import org.eclipse.net4j.transport.ConnectorFactory;
import org.eclipse.net4j.transport.ConnectorLocation;
import org.eclipse.net4j.transport.Protocol;
import org.eclipse.net4j.transport.ProtocolFactory;
import org.eclipse.net4j.transport.ProtocolFactoryID;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.net4j.util.lifecycle.LifecycleAdapter;
import org.eclipse.net4j.util.lifecycle.LifecycleImpl;
import org.eclipse.net4j.util.lifecycle.LifecycleListener;
import org.eclipse.net4j.util.lifecycle.LifecycleNotifier;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.net4j.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.registry.IRegistry;
import org.eclipse.net4j.util.registry.IRegistryDelta;
import org.eclipse.net4j.util.registry.IRegistryEvent;
import org.eclipse.net4j.util.registry.IRegistryListener;

import org.eclipse.internal.net4j.bundle.Net4j;
import org.eclipse.internal.net4j.transport.AbstractAcceptor;
import org.eclipse.internal.net4j.transport.AbstractConnector;
import org.eclipse.internal.net4j.transport.DescriptionUtil;
import org.eclipse.internal.net4j.util.registry.HashMapRegistry;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author Eike Stepper
 */
public class ContainerImpl extends LifecycleImpl implements Container
{
  public static final short DEFAULT_BUFFER_CAPACITY = 4096;

  public static final ThreadFactory THREAD_FACTORY = new ThreadFactory()
  {
    public Thread newThread(Runnable r)
    {
      Thread thread = new Thread(r);
      thread.setDaemon(true);
      return thread;
    }
  };

  private static final ContextTracer TRACER = new ContextTracer(ContainerBundle.DEBUG, ContainerImpl.class);

  private Store<ContainerConfig> store;

  private IRegistry<String, ContainerAdapterFactory> adapterFactoryRegistry;

  private IRegistry<String, AcceptorFactory> acceptorFactoryRegistry;

  private IRegistry<String, ConnectorFactory> connectorFactoryRegistry;

  private IRegistry<ProtocolFactoryID, ProtocolFactory> protocolFactoryRegistry;

  private IRegistry<String, Acceptor> acceptorRegistry;

  private IRegistry<String, Connector> connectorRegistry;

  private IRegistry<ChannelID, Channel> channelRegistry;

  private ExecutorService executorService;

  private BufferProvider bufferProvider;

  private IRegistry<String, ContainerAdapter> adapters = new HashMapRegistry();

  private IRegistryListener registryListener = new IRegistryListener()
  {
    public void notifyRegistryEvent(IRegistryEvent event)
    {
      IRegistryDelta[] deltas = event.getDeltas();
      for (IRegistryDelta delta : deltas)
      {
        switch (delta.getKind())
        {
        case REGISTERED:
          added(delta.getValue());
          break;

        case DEREGISTERED:
          removed(delta.getValue());
          break;
        }
      }
    }
  };

  private IRegistryListener adapterFactoryRegistryListener = new IRegistryListener<String, ContainerAdapterFactory>()
  {
    public void notifyRegistryEvent(IRegistryEvent<String, ContainerAdapterFactory> event)
    {
      IRegistryDelta<String, ContainerAdapterFactory>[] deltas = event.getDeltas();
      for (IRegistryDelta<String, ContainerAdapterFactory> delta : deltas)
      {
        try
        {
          ContainerAdapterFactory factory = delta.getValue();
          switch (delta.getKind())
          {
          case REGISTERED:
            addAdapter(factory.getType());
            break;

          case DEREGISTERED:
            // TODO Implement method .notifyRegistryEvent()
            throw new UnsupportedOperationException("Not yet implemented");
          }
        }
        catch (Exception ex)
        {
          Net4j.LOG.error(ex);
        }
      }
    }
  };

  private LifecycleListener lifecycleListener = new LifecycleAdapter()
  {
    @Override
    public void notifyLifecycleDeactivating(LifecycleNotifier notifier)
    {
      if (notifier instanceof Acceptor)
      {
        Acceptor acceptor = (Acceptor)notifier;
        acceptorRegistry.remove(acceptor.getDescription());
        acceptor.removeListener(acceptorListener);
      }
      else if (notifier instanceof Connector)
      {
        Connector connector = (Connector)notifier;
        connectorRegistry.remove(connector.getDescription());
        connector.removeListener(connectorListener);
      }

      LifecycleUtil.removeListener(notifier, lifecycleListener);
    }
  };

  private IListener acceptorListener = new IListener()
  {
    public void notifyEvent(IEvent event)
    {
      if (event instanceof AcceptorConnectorsEvent)
      {
        AcceptorConnectorsEvent e = (AcceptorConnectorsEvent)event;
        Connector connector = e.getAcceptedConnector();
        connector.addListener(connectorListener);
      }
    }
  };

  private IListener connectorListener = new IListener()
  {
    public void notifyEvent(IEvent event)
    {
      if (event instanceof ConnectorChannelsEvent)
      {
        ConnectorChannelsEvent e = (ConnectorChannelsEvent)event;
        Channel channel = e.getChannel();
        switch (e.getType())
        {
        case OPENED:
          channelRegistry.put(channel.getID(), channel);
          break;
        case CLOSING:
          channelRegistry.remove(channel.getID());
          break;
        }
      }
    }
  };

  private IRegistryListener storeHandler = new IRegistryListener()
  {
    public void notifyRegistryEvent(IRegistryEvent event)
    {
      IRegistryDelta<String, Object>[] deltas = event.getDeltas();
      for (IRegistryDelta<String, Object> delta : deltas)
      {
        String description = delta.getKey();
        Object object = delta.getValue();
        switch (delta.getKind())
        {
        case REGISTERED:
          objectAdded(description, object);
          break;

        case DEREGISTERED:
          objectRemoved(description, object);
          break;
        }
      }
    }

    private void objectAdded(String description, Object object)
    {
      if (object instanceof Acceptor)
      {
        if (getConfig().getAcceptorDescriptions().add(description))
        {
          store.setDirty();
          if (TRACER.isEnabled())
          {
            TRACER.trace("Added acceptor description: " + description);
          }
        }
      }
      else if (object instanceof Connector)
      {
        if (getConfig().getConnectorDescriptions().add(description))
        {
          store.setDirty();
          if (TRACER.isEnabled())
          {
            TRACER.trace("Added connector description: " + description);
          }
        }
      }
      else
      {
        createObjects();
      }
    }

    private void objectRemoved(String description, Object object)
    {
      if (object instanceof Acceptor)
      {
        if (getConfig().getAcceptorDescriptions().remove(description))
        {
          store.setDirty();
          if (TRACER.isEnabled())
          {
            TRACER.trace("Removed acceptor description: " + description);
          }
        }
      }
      else if (object instanceof Connector)
      {
        if (getConfig().getConnectorDescriptions().remove(description))
        {
          store.setDirty();
          if (TRACER.isEnabled())
          {
            TRACER.trace("Removed connector description: " + description);
          }
        }
      }
    }

    private ContainerConfig getConfig()
    {
      return store.getContent();
    }

    private void createObjects()
    {
      for (String description : getConfig().getAcceptorDescriptions())
      {
        try
        {
          getAcceptor(description);
        }
        catch (Exception ignore)
        {
        }
      }

      for (String description : getConfig().getConnectorDescriptions())
      {
        try
        {
          getConnector(description);
        }
        catch (Exception ignore)
        {
        }
      }
    }
  };

  public ContainerImpl()
  {
    adapterFactoryRegistry = createAdapterFactoryRegistry();
    executorService = createExecutorService();
    bufferProvider = createBufferProvider();
    acceptorFactoryRegistry = createAcceptorFactoryRegistry();
    connectorFactoryRegistry = createConnectorFactoryRegistry();
    protocolFactoryRegistry = createProtocolFactoryRegistry();
    acceptorRegistry = createAcceptorRegistry();
    connectorRegistry = createConnectorRegistry();
    channelRegistry = createChannelRegistry();
  }

  public ContainerImpl(File file)
  {
    this();
    store = new ConfigStore(file);

    adapterFactoryRegistry = createAdapterFactoryRegistry();
    executorService = createExecutorService();
    bufferProvider = createBufferProvider();
    acceptorFactoryRegistry = createAcceptorFactoryRegistry();
    connectorFactoryRegistry = createConnectorFactoryRegistry();
    protocolFactoryRegistry = createProtocolFactoryRegistry();
    acceptorRegistry = createAcceptorRegistry();
    connectorRegistry = createConnectorRegistry();
    channelRegistry = createChannelRegistry();
  }

  public Set<String> getAdapterConfig(String type)
  {
    if (store != null)
    {
      ContainerConfig config = store.getContent();
      final Set<String> adapterConfig = config.getAdapterConfig(type);
      return new Set<String>()
      {
        public boolean add(String e)
        {
          if (adapterConfig.add(e))
          {
            store.setDirty();
            return true;
          }

          return false;
        }

        public boolean addAll(Collection<? extends String> c)
        {
          if (adapterConfig.addAll(c))
          {
            store.setDirty();
            return true;
          }

          return false;
        }

        public void clear()
        {
          if (!isEmpty())
          {
            store.setDirty();
          }

          adapterConfig.clear();
        }

        public boolean contains(Object o)
        {
          return adapterConfig.contains(o);
        }

        public boolean containsAll(Collection<?> c)
        {
          return adapterConfig.containsAll(c);
        }

        public boolean equals(Object o)
        {
          return adapterConfig.equals(o);
        }

        public int hashCode()
        {
          return adapterConfig.hashCode();
        }

        public boolean isEmpty()
        {
          return adapterConfig.isEmpty();
        }

        public Iterator<String> iterator()
        {
          final Iterator<String> it = adapterConfig.iterator();
          return new Iterator<String>()
          {
            public boolean hasNext()
            {
              return it.hasNext();
            }

            public String next()
            {
              return it.next();
            }

            public void remove()
            {
              store.setDirty();
              it.remove();
            }
          };
        }

        public boolean remove(Object o)
        {
          if (adapterConfig.remove(o))
          {
            store.setDirty();
            return true;
          }

          return false;
        }

        public boolean removeAll(Collection<?> c)
        {
          if (adapterConfig.removeAll(c))
          {
            store.setDirty();
            return true;
          }

          return false;
        }

        public boolean retainAll(Collection<?> c)
        {
          if (adapterConfig.retainAll(c))
          {
            store.setDirty();
            return true;
          }

          return false;
        }

        public int size()
        {
          return adapterConfig.size();
        }

        public Object[] toArray()
        {
          return adapterConfig.toArray();
        }

        public <T> T[] toArray(T[] a)
        {
          return adapterConfig.toArray(a);
        }
      };
    }

    return Collections.emptySet();
  }

  public IRegistry<String, ContainerAdapterFactory> getAdapterFactoryRegistry()
  {
    return adapterFactoryRegistry;
  }

  public ExecutorService getExecutorService()
  {
    return executorService;
  }

  public BufferProvider getBufferProvider()
  {
    return bufferProvider;
  }

  public IRegistry<String, AcceptorFactory> getAcceptorFactoryRegistry()
  {
    return acceptorFactoryRegistry;
  }

  public IRegistry<String, ConnectorFactory> getConnectorFactoryRegistry()
  {
    return connectorFactoryRegistry;
  }

  public IRegistry<ProtocolFactoryID, ProtocolFactory> getProtocolFactoryRegistry()
  {
    return protocolFactoryRegistry;
  }

  public IRegistry<String, Acceptor> getAcceptorRegistry()
  {
    return acceptorRegistry;
  }

  public IRegistry<String, Connector> getConnectorRegistry()
  {
    return connectorRegistry;
  }

  public IRegistry<ChannelID, Channel> getChannelRegistry()
  {
    return channelRegistry;
  }

  public IRegistry<String, ContainerAdapter> getAdapterRegistry()
  {
    return adapters;
  }

  public ContainerAdapter getAdapter(String type)
  {
    return adapters.get(type);
  }

  public Acceptor getAcceptor(String description)
  {
    IRegistry<String, Acceptor> registry = getAcceptorRegistry();
    Acceptor acceptor = registry.get(description);
    if (acceptor == null)
    {
      acceptor = createAcceptor(description);
      if (acceptor != null)
      {
        registry.put(description, acceptor);
      }
    }

    return acceptor;
  }

  public Connector getConnector(String description)
  {
    IRegistry<String, Connector> registry = getConnectorRegistry();
    Connector connector = registry.get(description);
    if (connector == null)
    {
      connector = createConnector(description);
      if (connector != null)
      {
        registry.put(description, connector);
      }
    }

    return connector;
  }

  public Collection<Channel> getChannels(String protocolID, Set<ConnectorLocation> locations)
  {
    if (locations == null)
    {
      locations = ProtocolFactory.SYMMETRIC;
    }

    IRegistry<ChannelID, Channel> channelRegistry = getChannelRegistry();
    if (channelRegistry == null)
    {
      return null;
    }

    Collection<Channel> channels = channelRegistry.values();
    Collection<Channel> result = new ArrayList(channels.size());
    for (Channel channel : channels)
    {
      if (locations.contains(channel.getConnector().getLocation()))
      {
        if (protocolID == null || protocolID.length() == 0)
        {
          result.add(channel);
        }
        else
        {
          BufferHandler receiveHandler = channel.getReceiveHandler();
          if (receiveHandler instanceof Protocol)
          {
            Protocol protocol = (Protocol)receiveHandler;
            if (protocolID.equals(protocol.getProtocolID()))
            {
              result.add(channel);
            }
          }
        }
      }
    }

    return result;
  }

  public Collection<Channel> getChannels(String protocolID)
  {
    return getChannels(protocolID, null);
  }

  public Collection<Channel> getChannels(Set<ConnectorLocation> locations)
  {
    return getChannels(null, locations);
  }

  public void register(ContainerAdapterFactory factory)
  {
    IRegistry<String, ContainerAdapterFactory> registry = getAdapterFactoryRegistry();
    registry.put(factory.getType(), factory);
  }

  public void deregister(ContainerAdapterFactory factory)
  {
    IRegistry<String, ContainerAdapterFactory> registry = getAdapterFactoryRegistry();
    registry.remove(factory.getType());
  }

  public void register(AcceptorFactory factory)
  {
    IRegistry<String, AcceptorFactory> registry = getAcceptorFactoryRegistry();
    registry.put(factory.getType(), factory);
  }

  public void deregister(AcceptorFactory factory)
  {
    IRegistry<String, AcceptorFactory> registry = getAcceptorFactoryRegistry();
    registry.remove(factory.getType());
  }

  public void register(ConnectorFactory factory)
  {
    IRegistry<String, ConnectorFactory> registry = getConnectorFactoryRegistry();
    registry.put(factory.getType(), factory);
  }

  public void deregister(ConnectorFactory factory)
  {
    IRegistry<String, ConnectorFactory> registry = getConnectorFactoryRegistry();
    registry.remove(factory.getType());
  }

  public void register(ProtocolFactory factory)
  {
    IRegistry<ProtocolFactoryID, ProtocolFactory> registry = getProtocolFactoryRegistry();
    for (ConnectorLocation location : factory.getLocations())
    {
      ProtocolFactoryID id = factory.getID(location);
      registry.put(id, factory);
    }
  }

  public void deregister(ProtocolFactory factory)
  {
    IRegistry<ProtocolFactoryID, ProtocolFactory> registry = getProtocolFactoryRegistry();
    for (ConnectorLocation location : factory.getLocations())
    {
      ProtocolFactoryID id = factory.getID(location);
      registry.remove(id);
    }
  }

  public void added(Object object)
  {
    for (ContainerAdapter adapter : adapters.values())
    {
      if (adapter instanceof AbstractContainerAdapter)
      {
        ((AbstractContainerAdapter)adapter).addedToContainer(object);
      }
    }

    LifecycleUtil.addListener(object, lifecycleListener);
  }

  public void removed(Object object)
  {
    LifecycleUtil.removeListener(object, lifecycleListener);
    for (ContainerAdapter adapter : adapters.values())
    {
      if (adapter instanceof AbstractContainerAdapter)
      {
        ((AbstractContainerAdapter)adapter).removedFromContainer(object);
      }
    }
  }

  @Override
  protected void onAboutToActivate() throws Exception
  {
    super.onAboutToActivate();
    if (adapterFactoryRegistry == null)
    {
      throw new IllegalStateException("adapterFactoryRegistry == null");
    }
  }

  @Override
  protected void onActivate() throws Exception
  {
    super.onActivate();
    IRegistry<String, ContainerAdapterFactory> registry = getAdapterFactoryRegistry();
    for (ContainerAdapterFactory factory : registry.values())
    {
      addAdapter(factory.getType());
    }

    registry.addRegistryListener(adapterFactoryRegistryListener);
    channelRegistry.addRegistryListener(registryListener);

    if (store != null)
    {
      store.activate();

      getAdapterFactoryRegistry().addRegistryListener(storeHandler);
      getAdapterRegistry().addRegistryListener(storeHandler);

      getAcceptorFactoryRegistry().addRegistryListener(storeHandler);
      getAcceptorRegistry().addRegistryListener(storeHandler);

      getConnectorFactoryRegistry().addRegistryListener(storeHandler);
      getConnectorRegistry().addRegistryListener(storeHandler);
    }
  }

  @Override
  protected void onDeactivate() throws Exception
  {
    if (store != null)
    {
      getAdapterFactoryRegistry().removeRegistryListener(storeHandler);
      getAdapterRegistry().removeRegistryListener(storeHandler);

      getAcceptorFactoryRegistry().removeRegistryListener(storeHandler);
      getAcceptorRegistry().removeRegistryListener(storeHandler);

      getConnectorFactoryRegistry().removeRegistryListener(storeHandler);
      getConnectorRegistry().removeRegistryListener(storeHandler);

      store.deactivate();
    }

    channelRegistry.removeRegistryListener(registryListener);
    getAdapterFactoryRegistry().removeRegistryListener(adapterFactoryRegistryListener);
    Collection<ContainerAdapter> adapters = this.adapters.values();
    for (ContainerAdapter adapter : adapters.toArray(new ContainerAdapter[adapters.size()]))
    {
      LifecycleUtil.deactivateNoisy(adapter);
    }

    Collection<Connector> connectors = getConnectorRegistry().values();
    for (Connector connector : connectors.toArray(new Connector[connectors.size()]))
    {
      LifecycleUtil.deactivateNoisy(connector);
    }

    Collection<Acceptor> acceptors = getAcceptorRegistry().values();
    for (Acceptor acceptor : acceptors.toArray(new Acceptor[acceptors.size()]))
    {
      LifecycleUtil.deactivateNoisy(acceptor);
    }

    super.onDeactivate();
  }

  protected IRegistry<String, ContainerAdapterFactory> createAdapterFactoryRegistry()
  {
    return new HashMapRegistry();
  }

  protected HashMapRegistry createAcceptorFactoryRegistry()
  {
    return new HashMapRegistry();
  }

  protected HashMapRegistry createConnectorFactoryRegistry()
  {
    return new HashMapRegistry();
  }

  protected HashMapRegistry createProtocolFactoryRegistry()
  {
    return new HashMapRegistry();
  }

  protected HashMapRegistry createAcceptorRegistry()
  {
    return new HashMapRegistry();
  }

  protected HashMapRegistry createConnectorRegistry()
  {
    return new HashMapRegistry();
  }

  protected HashMapRegistry createChannelRegistry()
  {
    return new HashMapRegistry();
  }

  protected ExecutorService createExecutorService()
  {
    return Executors.newCachedThreadPool(THREAD_FACTORY);
  }

  protected BufferProvider createBufferProvider()
  {
    return ContainerUtil.createBufferPool(DEFAULT_BUFFER_CAPACITY);
  }

  private Acceptor createAcceptor(String description)
  {
    IRegistry<String, AcceptorFactory> registry = getAcceptorFactoryRegistry();
    if (registry == null)
    {
      return null;
    }

    String type = DescriptionUtil.getType(description);
    AcceptorFactory factory = registry.get(type);
    if (factory == null)
    {
      return null;
    }

    AbstractAcceptor acceptor = (AbstractAcceptor)factory.createAcceptor();
    acceptor.setReceiveExecutor(getExecutorService());
    acceptor.setBufferProvider(getBufferProvider());
    acceptor.setDescription(description);
    acceptor.setProtocolFactoryRegistry(getProtocolFactoryRegistry());
    added(acceptor);

    LifecycleUtil.activate(acceptor);
    acceptor.addListener(acceptorListener);
    return acceptor;
  }

  private Connector createConnector(String description)
  {
    IRegistry<String, ConnectorFactory> registry = getConnectorFactoryRegistry();
    if (registry == null)
    {
      return null;
    }

    String type = DescriptionUtil.getType(description);
    ConnectorFactory factory = registry.get(type);
    if (factory == null)
    {
      return null;
    }

    AbstractConnector connector = (AbstractConnector)factory.createConnector();
    connector.setReceiveExecutor(getExecutorService());
    connector.setBufferProvider(getBufferProvider());
    connector.setDescription(description);
    connector.setProtocolFactoryRegistry(getProtocolFactoryRegistry());
    added(connector);

    LifecycleUtil.activate(connector);
    connector.addListener(connectorListener);
    return connector;
  }

  private ContainerAdapter addAdapter(String type)
  {
    ContainerAdapterFactory factory = adapterFactoryRegistry.get(type);
    if (factory == null)
    {
      return null;
    }

    ContainerAdapter adapter = createAdapter(factory);
    if (adapter != null)
    {
      adapters.put(type, adapter);
    }

    added(adapter);
    return adapter;
  }

  private ContainerAdapter createAdapter(ContainerAdapterFactory factory)
  {
    try
    {
      ContainerAdapter adapter = factory.createAdapter(this);
      LifecycleUtil.activate(adapter);
      return adapter;
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
      return null;
    }
  }

  /**
   * @author Eike Stepper
   */
  private static final class ConfigStore extends FileStore<ContainerConfig>
  {
    private ConfigStore(File file)
    {
      super(file);
    }

    @Override
    protected ContainerConfig getInitialContent()
    {
      return new ContainerConfig();
    }
  }
}
