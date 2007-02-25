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
package org.eclipse.net4j.jmx.internal.container.bundle;

import org.eclipse.net4j.util.om.OMBundle;
import org.eclipse.net4j.util.om.OMLogger;
import org.eclipse.net4j.util.om.OMPlatform;
import org.eclipse.net4j.util.om.OMTracer;

import org.eclipse.internal.net4j.util.om.OSGiActivator;

/**
 * @author Eike Stepper
 */
public final class JMXContainerBundle
{
  public static final String BUNDLE_ID = "org.eclipse.net4j.jmx.container"; //$NON-NLS-1$

  public static final OMBundle BUNDLE = OMPlatform.INSTANCE.bundle(BUNDLE_ID, JMXContainerBundle.class);

  public static final OMTracer DEBUG = BUNDLE.tracer("debug"); //$NON-NLS-1$

  public static final OMLogger LOG = BUNDLE.logger();

  private JMXContainerBundle()
  {
  }

  /**
   * @author Eike Stepper
   */
  public static class Activator extends OSGiActivator
  {
    @Override
    protected OMBundle getOMBundle()
    {
      return BUNDLE;
    }
  }
}
