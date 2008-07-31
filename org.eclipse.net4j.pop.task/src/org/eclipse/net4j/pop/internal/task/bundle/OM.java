/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.pop.internal.task.bundle;

import org.eclipse.net4j.util.om.OMBundle;
import org.eclipse.net4j.util.om.OMPlatform;
import org.eclipse.net4j.util.om.OSGiActivator;
import org.eclipse.net4j.util.om.log.OMLogger;
import org.eclipse.net4j.util.om.pref.OMPreference;
import org.eclipse.net4j.util.om.pref.OMPreferences;
import org.eclipse.net4j.util.om.trace.OMTracer;

import org.osgi.framework.BundleContext;

/**
 * The <em>Operations & Maintenance</em> class of this bundle.
 * 
 * @author Eike Stepper
 */
public abstract class OM
{
  public static final String BUNDLE_ID = "org.eclipse.net4j.pop.task"; //$NON-NLS-1$

  public static final OMBundle BUNDLE = OMPlatform.INSTANCE.bundle(BUNDLE_ID, OM.class);

  public static final OMTracer DEBUG = BUNDLE.tracer("debug"); //$NON-NLS-1$

  public static final OMLogger LOG = BUNDLE.logger();

  public static final OMPreferences PREFS = BUNDLE.preferences();

  public static final OMPreference<Integer> PREF_AUTO_SYNC = PREFS.init("PREF_AUTO_SYNC", 60); //$NON-NLS-1$

  public static final OMPreference<String> PREF_REPOS = PREFS.initString("PREF_REPOS"); //$NON-NLS-1$

  /**
   * @author Eike Stepper
   */
  public static final class Activator extends OSGiActivator
  {
    public Activator()
    {
      super(BUNDLE);
    }

    @Override
    public void start(BundleContext context) throws Exception
    {
      super.start(context);
      org.eclipse.net4j.pop.internal.task.TaskRepositoryManager.INSTANCE.activate();
      org.eclipse.net4j.pop.internal.task.TaskManager.INSTANCE.activate();
    }

    @Override
    public void stop(BundleContext context) throws Exception
    {
      org.eclipse.net4j.pop.internal.task.TaskManager.INSTANCE.deactivate();
      org.eclipse.net4j.pop.internal.task.TaskRepositoryManager.INSTANCE.deactivate();
      super.stop(context);
    }
  }
}
