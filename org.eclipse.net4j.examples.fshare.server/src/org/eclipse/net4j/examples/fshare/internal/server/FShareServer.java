/**
 * Copyright (c) 2009 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *
 *  Initial Publication:
 *    Eclipse Magazin - http://www.eclipse-magazin.de
 */
package org.eclipse.net4j.examples.fshare.internal.server;

import org.eclipse.net4j.acceptor.IAcceptor;
import org.eclipse.net4j.examples.fshare.internal.server.bundle.OM;
import org.eclipse.net4j.util.concurrent.Worker;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.container.IPluginContainer;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.net4j.util.lifecycle.ILifecycle;
import org.eclipse.net4j.util.lifecycle.LifecycleEventAdapter;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.net4j.util.om.OSGiApplication;

import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.spi.net4j.AcceptorFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class FShareServer extends OSGiApplication
{
  public static final String ID = OM.BUNDLE_ID + ".app";

  private IAcceptor acceptor;

  private String path;

  private List<FShareServerProtocol> sessions = new ArrayList<FShareServerProtocol>();

  private IListener sessionListener = new LifecycleEventAdapter()
  {
    @Override
    protected void onDeactivated(ILifecycle session)
    {
      ((FShareServerProtocol)session).removeListener(sessionListener);
      synchronized (sessions)
      {
        sessions.remove(session);
      }
    };
  };

  private NotificationManager notificationManager = new NotificationManager();

  private List<FShareUpload> uploads = new LinkedList<FShareUpload>();

  public FShareServer()
  {
    super(ID);
  }

  public String getPath()
  {
    return path;
  }

  public FShareServerProtocol[] getSessions()
  {
    synchronized (sessions)
    {
      return sessions.toArray(new FShareServerProtocol[sessions.size()]);
    }
  }

  public boolean addSession(FShareServerProtocol session)
  {
    session.addListener(sessionListener);
    synchronized (sessions)
    {
      return sessions.add(session);
    }
  }

  public FShareUpload[] getUploads()
  {
    synchronized (uploads)
    {
      return uploads.toArray(new FShareUpload[uploads.size()]);
    }
  }

  public FShareUpload addUpload(FShareServerProtocol session, String path)
  {
    FShareUpload upload = new FShareUpload(session, path);
    synchronized (uploads)
    {
      uploads.add(upload);
    }

    return upload;
  }

  @Override
  protected void doStart() throws Exception
  {
    OM.LOG.info("FShare server starting");
    notificationManager.activate();

    String[] args = (String[])getApplicationContext().getArguments().get(IApplicationContext.APPLICATION_ARGS);
    if (args == null || args.length == 0)
    {
      throw new IllegalArgumentException("No acceptor URL!");
    }

    IManagedContainer container = getContainer();
    container.registerFactory(new FShareServerProtocol.Factory(this));

    try
    {
      URI uri = new URI(args[0]);
      path = uri.getPath();

      String type = uri.getScheme();
      String description = uri.getAuthority();
      acceptor = (IAcceptor)container.getElement(AcceptorFactory.PRODUCT_GROUP, type, description);
      OM.LOG.info("Serving " + uri);
    }
    catch (URISyntaxException ex)
    {
      throw new IllegalArgumentException(ex);
    }

    OM.LOG.info("FShare server started");
  }

  @Override
  protected void doStop() throws Exception
  {
    OM.LOG.info("FShare server stopping");
    LifecycleUtil.deactivate(acceptor);
    LifecycleUtil.deactivate(notificationManager);
    OM.LOG.info("FShare server stopped");
  }

  protected IManagedContainer getContainer()
  {
    return IPluginContainer.INSTANCE;
  }

  /**
   * @author Eike Stepper
   */
  private class NotificationManager extends Worker
  {
    private static final long INTERVAL = 1000L;

    @Override
    protected void work(WorkContext context) throws Exception
    {
      List<FShareUpload> copy = copyUploads();
      if (copy != null)
      {
        synchronized (sessions)
        {
          for (FShareServerProtocol session : sessions)
          {
            session.notifyUploads(copy);
          }
        }
      }
      context.nextWork(INTERVAL);
    }

    private List<FShareUpload> copyUploads()
    {
      synchronized (uploads)
      {
        if (uploads.isEmpty())
        {
          return null;
        }

        List<FShareUpload> copy = new ArrayList<FShareUpload>(uploads.size());
        for (Iterator<FShareUpload> it = uploads.iterator(); it.hasNext();)
        {
          FShareUpload source = it.next();
          copy.add(new FShareUpload(source));
          if (source.isDone())
          {
            it.remove();
          }
        }

        return copy;
      }
    }
  }
}
