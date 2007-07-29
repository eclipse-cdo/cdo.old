/***************************************************************************
 * Copyright (c) 2004 - 2007 Eike Stepper, Germany.
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

import java.io.File;

/**
 * @author Eike Stepper
 */
public interface ICDOWeaver
{
  public static final ICDOWeaver INSTANCE = CDOWeaver.INSTANCE;

  /**
   * @param bundleLocations
   *          The locations bundle of the bundles in the file system. Each
   *          location must either point to a jar bundle or a folder bundle. In
   *          both cases the bundle must contain its classes in the bundle root
   *          directory.
   */
  public File[] weave(File[] bundleLocations) throws IORuntimeException;
}
