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
package org.eclipse.emf.cdo.weaver;

import org.eclipse.emf.cdo.internal.weaver.CDOWeaver;

import org.eclipse.net4j.util.io.IORuntimeException;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import java.util.Collection;

/**
 * @author Eike Stepper
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ICDOWeaver
{
  public static final ICDOWeaver INSTANCE = CDOWeaver.INSTANCE;

  public static final String JAR_SUFFIX = ".jar";

  public static final String CLASS_SUFFIX = ".class";

  public static final String ECORE_NAME = EcorePlugin.getPlugin().getBundle().getSymbolicName();

  /**
   * @param bundleLocations
   *          The locations bundle of the bundles in the file system. Each location must either point to a jar bundle or
   *          a folder bundle. In both cases the bundle must contain its classes in the bundle root directory.
   */
  public void weave(Collection<BundleInfo> bundleInfos) throws IORuntimeException;
}
