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
import org.eclipse.net4j.examples.fshare.common.FShareUtil;
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

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class Server extends OSGiApplication
{
  public static final String ID = OM.BUNDLE_ID + ".app";

  private static final String UPLOAD_SUFFIX = ".FShareUpload";

  private FeedbackManager feedbackManager = new FeedbackManager();

  private IAcceptor acceptor;

  private ServerFolder rootFolder;

  private List<ServerProtocol> sessions = new ArrayList<ServerProtocol>();

  private IListener sessionListener = new LifecycleEventAdapter()
  {
    @Override
    protected void onDeactivated(ILifecycle session)
    {
      ((ServerProtocol)session).removeListener(sessionListener);
      synchronized (sessions)
      {
        sessions.remove(session);
      }
    };
  };

  public Server()
  {
    super(ID);
  }

  public FeedbackManager getFeedbackManager()
  {
    return feedbackManager;
  }

  public ServerFolder getRootFolder()
  {
    return rootFolder;
  }

  public ServerResource getResource(String path)
  {
    ServerFolder folder = rootFolder;

    for (;;)
    {
      String[] split = FShareUtil.splitPathFirst(path);
      if (split[1] == null)
      {
        return folder.getChild(split[0]);
      }

      folder = (ServerFolder)folder.getChild(split[0]);
      path = split[1];
    }
  }

  public ServerProtocol[] getSessions()
  {
    synchronized (sessions)
    {
      return sessions.toArray(new ServerProtocol[sessions.size()]);
    }
  }

  public boolean addSession(ServerProtocol session)
  {
    session.addListener(sessionListener);
    synchronized (sessions)
    {
      return sessions.add(session);
    }
  }

  @Override
  protected void doStart() throws Exception
  {
    OM.LOG.info("FShare server starting");
    feedbackManager.activate();

    String[] args = (String[])getApplicationContext().getArguments().get(IApplicationContext.APPLICATION_ARGS);
    if (args == null || args.length == 0)
    {
      throw new IllegalArgumentException("No acceptor URL!");
    }

    IManagedContainer container = getContainer();
    container.registerFactory(new ServerProtocol.Factory(this));

    try
    {
      URI uri = new URI(args[0]);
      rootFolder = createRootFolder(uri.getPath());

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
    LifecycleUtil.deactivate(feedbackManager);
    OM.LOG.info("FShare server stopped");
  }

  protected IManagedContainer getContainer()
  {
    return IPluginContainer.INSTANCE;
  }

  private ServerFolder createRootFolder(final String path)
  {
    ServerFolder folder = new ServerFolder()
    {
      @Override
      public String getPath()
      {
        return "/";
      }

      @Override
      public File getTarget()
      {
        return new File(path);
      }
    };

    populateFolder(folder);
    return folder;
  }

  private void populateFolder(ServerFolder folder)
  {
    int count = 0;
    for (File file : folder.getTarget().listFiles())
    {
      String name = file.getName();
      if (name.endsWith(UPLOAD_SUFFIX))
      {
        continue;
      }

      if (file.isDirectory())
      {
        ServerFolder child = new ServerFolder(folder, name, 0);
        folder.addChild(child);
        populateFolder(child);
        ++count;
      }
      else
      {
        File lockFile = new File(file.getAbsolutePath() + UPLOAD_SUFFIX);
        if (lockFile.exists())
        {
          // Purge incomplete uploads
          lockFile.delete();
          file.delete();
        }
        else
        {
          int size = (int)file.length();
          ServerFile child = new ServerFile(folder, name, size);
          child.setUploaded(size);
          folder.addChild(child);
          ++count;
        }
      }
    }

    folder.setSize(count);
    folder.setUploaded(count);

  }

  /**
   * @author Eike Stepper
   */
  public class FeedbackManager extends Worker
  {
    private static final long INTERVAL = 1000L;

    private List<ServerResource> feedbacks = new LinkedList<ServerResource>();

    public FeedbackManager()
    {
    }

    public void addFeedback(ServerResource feedback)
    {
      synchronized (feedbacks)
      {
        feedbacks.add(feedback);
      }
    }

    public void startFeedback(ServerResource feedback)
    {
    }

    public void stopFeedback(ServerResource feedback)
    {
    }

    @Override
    protected void work(WorkContext context) throws Exception
    {
      // for (FShareServerResource feedback : getFeedbacks())
      // {
      // synchronized (sessions)
      // {
      // for (FShareServerProtocol session : sessions)
      // {
      // session.sendFeedback(copy);
      // }
      // }
      // }
      //
      // List<FShareUpload> copy = copyUploads();
      // if (copy != null)
      // {
      // synchronized (sessions)
      // {
      // for (FShareServerProtocol session : sessions)
      // {
      // session.sendFeedback(copy);
      // }
      // }
      // }

      context.nextWork(INTERVAL);
    }

    // private List<FShareUpload> copyUploads()
    // {
    // synchronized (uploads)
    // {
    // if (uploads.isEmpty())
    // {
    // return null;
    // }
    //
    // List<FShareUpload> copy = new ArrayList<FShareUpload>(uploads.size());
    // for (Iterator<FShareUpload> it = uploads.iterator(); it.hasNext();)
    // {
    // FShareUpload source = it.next();
    // copy.add(new FShareUpload(source));
    // if (source.isDone())
    // {
    // it.remove();
    // }
    // }
    //
    // return copy;
    // }
    // }
  }
}
