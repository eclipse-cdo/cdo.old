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

  private static String acceptorURL;

  private static IAcceptor acceptor;

  public FShareServer()
  {
    super(ID);
  }

  public static String getAcceptorURL()
  {
    return acceptorURL;
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

    acceptorURL = args[0];

    try
    {
      URI uri = new URI(FShareServer.getAcceptorURL());
      String type = uri.getScheme();
      String description = uri.getAuthority();
      String path = uri.getPath();

      acceptor = (IAcceptor)IPluginContainer.INSTANCE.getElement(AcceptorFactory.PRODUCT_GROUP, type, description);
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
}
