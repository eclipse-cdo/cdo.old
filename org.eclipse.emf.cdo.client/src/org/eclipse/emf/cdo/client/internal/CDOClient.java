/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.client.internal;


import org.eclipse.net4j.util.om.OMBundle;
import org.eclipse.net4j.util.om.OMLogger;
import org.eclipse.net4j.util.om.OMPlatform;
import org.eclipse.net4j.util.om.OMTracer;


/**
 * @author Eike Stepper
 */
public final class CDOClient
{
  public static final String BUNDLE_ID = "org.eclipse.net4j"; //$NON-NLS-1$

  public static final OMBundle BUNDLE = OMPlatform.INSTANCE.bundle(BUNDLE_ID, CDOClient.class);

  public static final OMTracer DEBUG = BUNDLE.tracer("debug"); //$NON-NLS-1$

  public static final OMTracer DEBUG_MODEL = DEBUG.tracer("model"); //$NON-NLS-1$

  public static final OMTracer DEBUG_RESOURCE = DEBUG.tracer("resource"); //$NON-NLS-1$

  public static final OMTracer DEBUG_PROTOCOL = DEBUG.tracer("protocol"); //$NON-NLS-1$

  public static final OMLogger LOG = BUNDLE.logger();

  private CDOClient()
  {
  }
}
