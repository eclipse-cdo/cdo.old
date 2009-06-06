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
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.container.IPluginContainer;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.net4j.util.om.OSGiApplication;

import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.spi.net4j.AcceptorFactory;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Eike Stepper
 */
public class FShareServer extends OSGiApplication
{
  public static final String ID = OM.BUNDLE_ID + ".app";

  private IAcceptor acceptor;

  private String path;

  public FShareServer()
  {
    super(ID);
  }

  public String getPath()
  {
    return path;
  }

  @Override
  protected void doStart() throws Exception
  {
    OM.LOG.info("FShare server starting");
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
    OM.LOG.info("FShare server stopped");
  }

  protected IManagedContainer getContainer()
  {
    return IPluginContainer.INSTANCE;
  }
}
