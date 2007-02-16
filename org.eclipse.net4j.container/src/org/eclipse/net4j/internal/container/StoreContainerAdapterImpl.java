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
import org.eclipse.net4j.container.StoreConstants;
import org.eclipse.net4j.container.StoreContainerAdapter;
import org.eclipse.net4j.internal.container.bundle.ContainerBundle;
import org.eclipse.net4j.transport.Acceptor;
import org.eclipse.net4j.transport.AcceptorFactory;
import org.eclipse.net4j.transport.Connector;
import org.eclipse.net4j.transport.ConnectorFactory;
import org.eclipse.net4j.util.IOUtil;
import org.eclipse.net4j.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.registry.IRegistryDelta;
import org.eclipse.net4j.util.registry.IRegistryEvent;
import org.eclipse.net4j.util.registry.IRegistryListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Eike Stepper
 */
public class StoreContainerAdapterImpl extends AbstractContainerAdapter implements StoreContainerAdapter,
    IRegistryListener
{
  private static final ContextTracer TRACER = new ContextTracer(ContainerBundle.DEBUG, StoreContainerAdapterImpl.class);

  private File store;

  private Config config;

  private boolean dirty;

  public StoreContainerAdapterImpl(Container container, File store)
  {
    super(container, StoreConstants.TYPE);
    this.store = store;
  }

  public File getStore()
  {
    return store;
  }

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

  @Override
  protected void onActivate() throws Exception
  {
    super.onActivate();
    loadConfig();
    createObjects();
    getContainer().getAcceptorFactoryRegistry().addRegistryListener(this);
    getContainer().getAcceptorRegistry().addRegistryListener(this);
    getContainer().getConnectorFactoryRegistry().addRegistryListener(this);
    getContainer().getConnectorRegistry().addRegistryListener(this);
  }

  @Override
  protected void onDeactivate() throws Exception
  {
    getContainer().getAcceptorFactoryRegistry().removeRegistryListener(this);
    getContainer().getAcceptorRegistry().removeRegistryListener(this);
    getContainer().getConnectorFactoryRegistry().removeRegistryListener(this);
    getContainer().getConnectorRegistry().removeRegistryListener(this);
    if (dirty)
    {
      saveConfig();
      dirty = false;
    }

    super.onDeactivate();
  }

  private void initConfig()
  {
    if (TRACER.isEnabled())
    {
      TRACER.trace("Initializing config");
    }

    config = new Config();
  }

  private void loadConfig() throws Exception
  {
    ObjectInputStream ois = null;
    if (TRACER.isEnabled())
    {
      TRACER.trace("Loading config");
    }

    try
    {
      FileInputStream fis = new FileInputStream(store);
      ois = new ObjectInputStream(fis);
      config = (Config)ois.readObject();
    }
    catch (FileNotFoundException ex)
    {
      initConfig();
    }
    catch (Exception ex)
    {
      initConfig();
      throw ex;
    }
    finally
    {
      IOUtil.closeSilent(ois);
    }
  }

  private void saveConfig()
  {
    ObjectOutputStream oos = null;
    if (TRACER.isEnabled())
    {
      TRACER.trace("Saving config");
    }

    try
    {
      FileOutputStream fos = new FileOutputStream(store);
      oos = new ObjectOutputStream(fos);
      oos.writeObject(config);
    }
    catch (Exception ex)
    {
      ContainerBundle.LOG.error(ex);
    }
    finally
    {
      IOUtil.closeSilent(oos);
    }
  }

  private void createObjects()
  {
    for (String description : config.getAcceptorDescriptions())
    {
      getContainer().getAcceptor(description);
    }

    for (String description : config.getConnectorDescriptions())
    {
      getContainer().getConnector(description);
    }
  }

  private void objectAdded(String description, Object object)
  {
    if (object instanceof Acceptor)
    {
      if (config.getAcceptorDescriptions().add(description))
      {
        dirty = true;
        if (TRACER.isEnabled())
        {
          TRACER.trace("Added acceptor description: " + description);
        }
      }
    }
    else if (object instanceof Connector)
    {
      if (config.getConnectorDescriptions().add(description))
      {
        dirty = true;
        if (TRACER.isEnabled())
        {
          TRACER.trace("Added connector description: " + description);
        }
      }
    }
    else if (object instanceof AcceptorFactory)
    {
      createObjects();
    }
    else if (object instanceof ConnectorFactory)
    {
      createObjects();
    }
  }

  private void objectRemoved(String description, Object object)
  {
    if (object instanceof Acceptor)
    {
      if (config.getAcceptorDescriptions().remove(description))
      {
        dirty = true;
        if (TRACER.isEnabled())
        {
          TRACER.trace("Removed acceptor description: " + description);
        }
      }
    }
    else if (object instanceof Connector)
    {
      if (config.getConnectorDescriptions().remove(description))
      {
        dirty = true;
        if (TRACER.isEnabled())
        {
          TRACER.trace("Removed connector description: " + description);
        }
      }
    }
  }

  /**
   * @author Eike Stepper
   */
  public static final class Config implements Serializable
  {
    private static final long serialVersionUID = 1L;

    private Set<String> acceptorDescriptions = new HashSet();

    private Set<String> connectorDescriptions = new HashSet();

    public Config()
    {
    }

    public Set<String> getAcceptorDescriptions()
    {
      return acceptorDescriptions;
    }

    public Set<String> getConnectorDescriptions()
    {
      return connectorDescriptions;
    }
  }
}
