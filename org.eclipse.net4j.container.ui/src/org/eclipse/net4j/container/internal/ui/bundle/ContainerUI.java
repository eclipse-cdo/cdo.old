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
package org.eclipse.net4j.container.internal.ui.bundle;

import org.eclipse.net4j.util.om.OMBundle;
import org.eclipse.net4j.util.om.OMLogger;
import org.eclipse.net4j.util.om.OMPlatform;
import org.eclipse.net4j.util.om.OMTracer;
import org.eclipse.net4j.util.om.log.EclipseLoggingBridge;

import org.eclipse.internal.net4j.bundle.AbstractOMPlatform;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author Eike Stepper
 */
public final class ContainerUI
{
  public static final String BUNDLE_ID = "org.eclipse.net4j.container.ui"; //$NON-NLS-1$

  public static final OMBundle BUNDLE = OMPlatform.INSTANCE.bundle(BUNDLE_ID, ContainerUI.class);

  public static final OMTracer DEBUG = BUNDLE.tracer("debug"); //$NON-NLS-1$

  public static final OMLogger LOG = BUNDLE.logger();

  private ContainerUI()
  {
  }

  /**
   * @author Eike Stepper
   */
  public static class Activator implements BundleActivator
  {
    public void start(BundleContext context) throws Exception
    {
      AbstractOMPlatform.INSTANCE.addLogHandler(EclipseLoggingBridge.INSTANCE);
      BUNDLE.setBundleContext(context);
    }

    public void stop(BundleContext context) throws Exception
    {
      BUNDLE.setBundleContext(null);
    }
  }
}
