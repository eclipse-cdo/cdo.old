package org.eclipse.net4j.examples.internal.fshare;

import org.eclipse.net4j.connector.IConnector;
import org.eclipse.net4j.examples.fshare.IFileSystem;
import org.eclipse.net4j.examples.fshare.common.FShareConstants;
import org.eclipse.net4j.examples.internal.fshare.bundle.OM;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.container.IPluginContainer;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.net4j.util.lifecycle.ILifecycle;
import org.eclipse.net4j.util.lifecycle.LifecycleEventAdapter;

import org.eclipse.spi.net4j.ConnectorFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class FShareFileSystem implements IFileSystem
{
  private IConnector connector;

  private FShareClientProtocol protocol;

  private IListener protocolListener = new LifecycleEventAdapter()
  {
    @Override
    protected void onDeactivated(ILifecycle protocol)
    {
      fireProtocolClosed();
    };
  };

  private FShareFolder rootFolder;

  private List<Listener> listeners = new ArrayList<Listener>();

  public FShareFileSystem(String targetURL)
  {
    try
    {
      URI uri = new URI(targetURL);
      String type = uri.getScheme();
      String description = uri.getAuthority();
      String path = uri.getPath();

      connector = (IConnector)getContainer().getElement(ConnectorFactory.PRODUCT_GROUP, type, description);

      protocol = new FShareClientProtocol(connector);
      protocol.addListener(protocolListener);
      protocol.logon(path);

      rootFolder = new FShareFolder(this);
    }
    catch (URISyntaxException ex)
    {
      throw new IllegalArgumentException(ex);
    }
  }

  public void close()
  {
    rootFolder = null;
    protocol.removeListener(protocolListener);
    protocol.close();
    protocol = null;
    connector = null;
  }

  public FShareClientProtocol getProtocol()
  {
    return protocol;
  }

  public FShareFolder getRootFolder()
  {
    return rootFolder;
  }

  public FShareResource getResource(String path)
  {
    FShareFolder folder = rootFolder;
    for (;;)
    {
      int slash = path.indexOf('/');
      if (slash == -1)
      {
        return folder.getChild(path);
      }

      folder = (FShareFolder)folder.getChild(path.substring(0, slash));
      path = path.substring(slash + 1);
    }
  }

  public synchronized void addListener(Listener listener)
  {
    if (!listeners.contains(listener))
    {
      listeners.add(listener);
    }
  }

  public synchronized void removeListener(Listener listener)
  {
    listeners.remove(listener);
  }

  protected IManagedContainer getContainer()
  {
    return IPluginContainer.INSTANCE;
  }

  private Listener[] getListeners()
  {
    synchronized (listeners)
    {
      return listeners.toArray(new Listener[listeners.size()]);
    }
  }

  private void fireProtocolClosed()
  {
    for (Listener listener : getListeners())
    {
      try
      {
        listener.protocolClosed(this);
      }
      catch (Exception ex)
      {
        OM.LOG.error(ex);
      }
    }
  }

  public void fireResourceAdded(FShareResource resource)
  {
    for (Listener listener : getListeners())
    {
      try
      {
        listener.resourceAdded(resource);
      }
      catch (Exception ex)
      {
        OM.LOG.error(ex);
      }
    }
  }

  public FShareResource setUploadFeedback(String path, long size)
  {
    if (size == FShareConstants.FOLDER)
    {
    }

    return null;
  }
}
