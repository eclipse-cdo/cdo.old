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
import org.eclipse.net4j.container.ContainerAdapter;
import org.eclipse.net4j.container.ContainerAdapterFactory;
import org.eclipse.net4j.internal.container.bundle.ContainerBundle;
import org.eclipse.net4j.internal.container.store.FileStore;
import org.eclipse.net4j.internal.container.store.Store;
import org.eclipse.net4j.transport.ConnectorLocation;
import org.eclipse.net4j.transport.IAcceptor;
import org.eclipse.net4j.transport.IAcceptorAcceptedEvent;
import org.eclipse.net4j.transport.IBufferHandler;
import org.eclipse.net4j.transport.IBufferProvider;
import org.eclipse.net4j.transport.IChannel;
import org.eclipse.net4j.transport.IChannelID;
import org.eclipse.net4j.transport.IConnector;
import org.eclipse.net4j.transport.IConnectorChannelsEvent;
import org.eclipse.net4j.transport.IProtocol;
import org.eclipse.net4j.transport.IProtocolFactory;
import org.eclipse.net4j.transport.IProtocolFactoryID;
import org.eclipse.net4j.transport.TransportUtil;
import org.eclipse.net4j.util.container.IContainerDelta;
import org.eclipse.net4j.util.event.EventUtil;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.net4j.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.registry.IRegistry;
import org.eclipse.net4j.util.registry.IRegistryEvent;

import org.eclipse.internal.net4j.bundle.Net4j;
import org.eclipse.internal.net4j.transport.Acceptor;
import org.eclipse.internal.net4j.transport.Connector;
import org.eclipse.internal.net4j.transport.DescriptionUtil;
import org.eclipse.internal.net4j.util.lifecycle.Lifecycle;
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
public class ContainerImpl extends Lifecycle implements Container
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

  private IRegistry<String, IAcceptorFactory> acceptorFactoryRegistry;

  private IRegistry<String, IConnectorFactory> connectorFactoryRegistry;

  private IRegistry<IProtocolFactoryID, IProtocolFactory> protocolFactoryRegistry;

  private IRegistry<String, IAcceptor> acceptorRegistry;

  private IRegistry<String, IConnector> connectorRegistry;

  private IRegistry<IChannelID, IChannel> channelRegistry;

  private ExecutorService executorService;

  private IBufferProvider bufferProvider;

  private IRegistry<String, ContainerAdapter> adapters = new HashMapRegistry();

  private IRegistryListener registryListener = new IRegistryListener()
  {
    public void notifyRegistryEvent(IRegistryEvent event)
    {
      IContainerDelta[] deltas = event.getDeltas();
      for (IContainerDelta delta : deltas)
      {
        switch (delta.getKind())
        {
        case REGISTERED:
          added(delta.getElement());
          break;

        case DEREGISTERED:
          removed(delta.getElement());
          break;
        }
      }
    }
  };

  private IRegistryListener adapterFactoryRegistryListener = new IRegistryListener<String, ContainerAdapterFactory>()
  {
    public void notifyRegistryEvent(IRegistryEvent<String, ContainerAdapterFactory> event)
    {
      IContainerDelta<String, ContainerAdapterFactory>[] deltas = event.getDeltas();
      for (IContainerDelta<String, ContainerAdapterFactory> delta : deltas)
      {
        try
        {
          ContainerAdapterFactory factory = delta.getElement();
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
      if (notifier instanceof IAcceptor)
      {
        IAcceptor acceptor = (IAcceptor)notifier;
        acceptorRegistry.remove(acceptor.getDescription());
        acceptor.removeListener(acceptorListener);
      }
      else if (notifier instanceof IConnector)
      {
        IConnector connector = (IConnector)notifier;
        connectorRegistry.remove(connector.getDescription());
        connector.removeListener(connectorListener);
      }

      EventUtil.removeListener(notifier, lifecycleListener);
    }
  };

  private IListener acceptorListener = new IListener()
  {
    public void notifyEvent(IEvent event)
    {
      if (event instanceof IAcceptorAcceptedEvent)
      {
        IAcceptorAcceptedEvent e = (IAcceptorAcceptedEvent)event;
        IConnector connector = e.getConnector();
        connector.addListener(connectorListener);
      }
    }
  };

  private IListener connectorListener = new IListener()
  {
    public void notifyEvent(IEvent event)
    {
      if (event instanceof IConnectorChannelsEvent)
      {
        IConnectorChannelsEvent e = (IConnectorChannelsEvent)event;
        IChannel channel = e.getChannel();
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
      IContainerDelta<String, Object>[] deltas = event.getDeltas();
      for (IContainerDelta<String, Object> delta : deltas)
      {
        String description = delta.getKey();
        Object object = delta.getElement();
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
      if (object instanceof IAcceptor)
      {
        if (getConfig().getAcceptorDescriptions().add(description))
        {
          setStoreDirty();
          if (TRACER.isEnabled())
          {
            TRACER.trace("Added acceptor description: " + description);
          }
        }
      }
      else if (object instanceof IConnector)
      {
        if (getConfig().getConnectorDescriptions().add(description))
        {
          setStoreDirty();
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
      if (object instanceof IAcceptor)
      {
        if (getConfig().getAcceptorDescriptions().remove(description))
        {
          setStoreDirty();
          if (TRACER.isEnabled())
          {
            TRACER.trace("Removed acceptor description: " + description);
          }
        }
      }
      else if (object instanceof IConnector)
      {
        if (getConfig().getConnectorDescriptions().remove(description))
        {
          setStoreDirty();
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
  }

  public Set<String> getAdapterConfig(String type)
  {
    if (store != null)
    {
      ContainerConfig config = store.getContent();
      Set<String> adapterConfig = config.getAdapterConfig(type);
      return new AdapterConfigSet(adapterConfig);
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

  public IBufferProvider getBufferProvider()
  {
    return bufferProvider;
  }

  public IRegistry<String, IAcceptorFactory> getAcceptorFactoryRegistry()
  {
    return acceptorFactoryRegistry;
  }

  public IRegistry<String, IConnectorFactory> getConnectorFactoryRegistry()
  {
    return connectorFactoryRegistry;
  }

  public IRegistry<IProtocolFactoryID, IProtocolFactory> getProtocolFactoryRegistry()
  {
    return protocolFactoryRegistry;
  }

  public IRegistry<String, IAcceptor> getAcceptorRegistry()
  {
    return acceptorRegistry;
  }

  public IRegistry<String, IConnector> getConnectorRegistry()
  {
    return connectorRegistry;
  }

  public IRegistry<IChannelID, IChannel> getChannelRegistry()
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

  public IAcceptor getAcceptor(String description)
  {
    IRegistry<String, IAcceptor> registry = getAcceptorRegistry();
    IAcceptor acceptor = registry.get(description);
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

  public IConnector getConnector(String description)
  {
    IRegistry<String, IConnector> registry = getConnectorRegistry();
    IConnector connector = registry.get(description);
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

  public Collection<IChannel> getChannels(String protocolID, Set<ConnectorLocation> locations)
  {
    if (locations == null)
    {
      locations = IProtocolFactory.SYMMETRIC;
    }

    IRegistry<IChannelID, IChannel> channelRegistry = getChannelRegistry();
    if (channelRegistry == null)
    {
      return null;
    }

    Collection<IChannel> channels = channelRegistry.values();
    Collection<IChannel> result = new ArrayList(channels.size());
    for (IChannel channel : channels)
    {
      if (locations.contains(channel.getConnector().getLocation()))
      {
        if (protocolID == null || protocolID.length() == 0)
        {
          result.add(channel);
        }
        else
        {
          IBufferHandler receiveHandler = channel.getReceiveHandler();
          if (receiveHandler instanceof IProtocol)
          {
            IProtocol protocol = (IProtocol)receiveHandler;
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

  public Collection<IChannel> getChannels(String protocolID)
  {
    return getChannels(protocolID, null);
  }

  public Collection<IChannel> getChannels(Set<ConnectorLocation> locations)
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

  public void register(IAcceptorFactory factory)
  {
    IRegistry<String, IAcceptorFactory> registry = getAcceptorFactoryRegistry();
    registry.put(factory.getType(), factory);
  }

  public void deregister(IAcceptorFactory factory)
  {
    IRegistry<String, IAcceptorFactory> registry = getAcceptorFactoryRegistry();
    registry.remove(factory.getType());
  }

  public void register(IConnectorFactory factory)
  {
    IRegistry<String, IConnectorFactory> registry = getConnectorFactoryRegistry();
    registry.put(factory.getType(), factory);
  }

  public void deregister(IConnectorFactory factory)
  {
    IRegistry<String, IConnectorFactory> registry = getConnectorFactoryRegistry();
    registry.remove(factory.getType());
  }

  public void register(IProtocolFactory factory)
  {
    IRegistry<IProtocolFactoryID, IProtocolFactory> registry = getProtocolFactoryRegistry();
    for (ConnectorLocation location : factory.getLocations())
    {
      IProtocolFactoryID id = factory.getID(location);
      registry.put(id, factory);
    }
  }

  public void deregister(IProtocolFactory factory)
  {
    IRegistry<IProtocolFactoryID, IProtocolFactory> registry = getProtocolFactoryRegistry();
    for (ConnectorLocation location : factory.getLocations())
    {
      IProtocolFactoryID id = factory.getID(location);
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
  protected void doBeforeActivate() throws Exception
  {
    super.doBeforeActivate();
    if (adapterFactoryRegistry == null)
    {
      throw new IllegalStateException("adapterFactoryRegistry == null");
    }
  }

  @Override
  protected void doActivate() throws Exception
  {
    super.doActivate();
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
  protected void doDeactivate() throws Exception
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

    Collection<IConnector> connectors = getConnectorRegistry().values();
    for (IConnector connector : connectors.toArray(new IConnector[connectors.size()]))
    {
      LifecycleUtil.deactivateNoisy(connector);
    }

    Collection<IAcceptor> acceptors = getAcceptorRegistry().values();
    for (IAcceptor acceptor : acceptors.toArray(new IAcceptor[acceptors.size()]))
    {
      LifecycleUtil.deactivateNoisy(acceptor);
    }

    super.doDeactivate();
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

  protected IBufferProvider createBufferProvider()
  {
    return TransportUtil.createBufferPool(DEFAULT_BUFFER_CAPACITY);
  }

  private IAcceptor createAcceptor(String description)
  {
    IRegistry<String, IAcceptorFactory> registry = getAcceptorFactoryRegistry();
    if (registry == null)
    {
      return null;
    }

    String type = DescriptionUtil.getType(description);
    IAcceptorFactory factory = registry.get(type);
    if (factory == null)
    {
      return null;
    }

    Acceptor acceptor = (Acceptor)factory.createAcceptor();
    acceptor.setReceiveExecutor(getExecutorService());
    acceptor.setBufferProvider(getBufferProvider());
    acceptor.setDescription(description);
    acceptor.setProtocolFactoryRegistry(getProtocolFactoryRegistry());
    added(acceptor);

    LifecycleUtil.activate(acceptor);
    acceptor.addListener(acceptorListener);
    return acceptor;
  }

  private IConnector createConnector(String description)
  {
    IRegistry<String, IConnectorFactory> registry = getConnectorFactoryRegistry();
    if (registry == null)
    {
      return null;
    }

    String type = DescriptionUtil.getType(description);
    IConnectorFactory factory = registry.get(type);
    if (factory == null)
    {
      return null;
    }

    Connector connector = (Connector)factory.createConnector();
    connector.setReceiveExecutor(getExecutorService());
    connector.setBufferProvider(getBufferProvider());
    connector.setDescription(description);
    connector.setProtocolFactoryRegistry(getProtocolFactoryRegistry());
    added(connector);

    LifecycleUtil.activate(connector);
    connector.addListener(connectorListener);
    return connector;
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

  private void setStoreDirty()
  {
    if (store != null)
    {
      store.setDirty();
    }
  }

  /**
   * @author Eike Stepper
   */
  private final class AdapterConfigSet implements Set<String>
  {
    private final Set<String> delegate;

    private AdapterConfigSet(Set<String> delegate)
    {
      this.delegate = delegate;
    }

    public boolean add(String e)
    {
      if (delegate.add(e))
      {
        setStoreDirty();
        return true;
      }

      return false;
    }

    public boolean addAll(Collection<? extends String> c)
    {
      if (delegate.addAll(c))
      {
        setStoreDirty();
        return true;
      }

      return false;
    }

    public void clear()
    {
      if (!isEmpty())
      {
        setStoreDirty();
      }

      delegate.clear();
    }

    public boolean contains(Object o)
    {
      return delegate.contains(o);
    }

    public boolean containsAll(Collection<?> c)
    {
      return delegate.containsAll(c);
    }

    public boolean equals(Object o)
    {
      return delegate.equals(o);
    }

    public int hashCode()
    {
      return delegate.hashCode();
    }

    public boolean isEmpty()
    {
      return delegate.isEmpty();
    }

    public Iterator<String> iterator()
    {
      final Iterator<String> it = delegate.iterator();
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
          setStoreDirty();
          it.remove();
        }
      };
    }

    public boolean remove(Object o)
    {
      if (delegate.remove(o))
      {
        setStoreDirty();
        return true;
      }

      return false;
    }

    public boolean removeAll(Collection<?> c)
    {
      if (delegate.removeAll(c))
      {
        setStoreDirty();
        return true;
      }

      return false;
    }

    public boolean retainAll(Collection<?> c)
    {
      if (delegate.retainAll(c))
      {
        setStoreDirty();
        return true;
      }

      return false;
    }

    public int size()
    {
      return delegate.size();
    }

    public Object[] toArray()
    {
      return delegate.toArray();
    }

    public <T> T[] toArray(T[] a)
    {
      return delegate.toArray(a);
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
