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
package org.eclipse.emf.cdo.client;


import org.eclipse.net4j.transport.Channel;

import org.eclipse.emf.cdo.mapping.PackageMapping;
import org.eclipse.emf.ecore.EPackage;


/**
 * Stores CDO related information for an associated {@link EPackage} instance. <p>
 * 
 * The most important information is the mapping specification that is determined 
 * from a mapping file or from model annotations. All {@link PackageInfo} instances 
 * are managed by the {@link PackageManager}.<p>
 * 
 * This interface is not expected to be implemented by clients.<p>
 * 
 * @see EPackage
 * @see PackageMapping
 * @see MappingProvider
 * @see PackageManager
 *
 * @author Eike Stepper
 */
public interface PackageInfo
{
  /**
   * Returns the name of this {@link PackageInfo}.<p>
   * 
   * Identical to calling <code>getEPackage().getName()</code>.<p>
   *
   * @return The name of this {@link PackageInfo}.
   */
  public String getName();

  /**
   * Returns the fully qualified name of this {@link PackageInfo}.<p>
   * 
   * Identical to calling <code>getEPackage().getNsPrefix()</code>.<p>
   *
   * @return The fully qualified of this {@link PackageInfo}.
   */
  public String getFullName();

  /**
   * Returns the {@link EPackage} associated with this {@link PackageInfo}.<p>
   * 
   * @return The {@link EPackage} associated with this {@link PackageInfo}.
   */
  public EPackage getEPackage();

  /**
   * Returns the CDO mapping specification associated with this {@link PackageInfo}.<p>
   * 
   * @return The CDO mapping specification} associated with this {@link PackageInfo}.
   */
  public PackageMapping getMapping();

  /**
   * For internal use only.<p>
   */
  public void addClass(ClassInfo classInfo);

  /**
   * Returns a handle to the internal array of the {@link ClassInfo} 
   * instances contained by this {@link PackageInfo}.<p>
   * 
   * @return A handle to the internal array of the {@link ClassInfo} 
   * instances contained by this {@link PackageInfo}.<p>
   */
  public ClassInfo[] getClasses();

  /**
   * For internal use only.<p>
   */
  public boolean isAnnounced();

  /**
   * For internal use only.<p>
   */
  public void announce(Channel channel) throws Exception;

  /**
   * Returns the {@link PackageManager} managing this {@link PackageInfo}.<p>
   * 
   * @return The {@link PackageManager} managing this {@link PackageInfo}.
   */
  public PackageManager getPackageManager();
}
