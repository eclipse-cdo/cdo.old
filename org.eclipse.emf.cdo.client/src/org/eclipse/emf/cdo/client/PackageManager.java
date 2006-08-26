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


import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.spring.Service;

import org.eclipse.emf.cdo.core.CID;
import org.eclipse.emf.cdo.core.OIDEncoder;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import java.util.Iterator;
import java.util.List;


/**
 * Manages the set of packages that are mappable to a CDO server.<p>
 *
 * For each such package a {@link PackageManager} contains a {@link PackageInfo}
 * instance.<p>
 *
 * @author Eike Stepper
 */
public interface PackageManager extends Service
{
  /**
   * Returns a list of the contained {@link PackageInfo} instances.<p>
   *
   * @return A list of the contained {@link PackageInfo} instances.<p>
   */
  public List<PackageInfo> getPackages();

  /**
   * Returns the {@link ClassInfo} instance associated with the given {@link EClass}.<p>
   *
   * @param eClass The {@link EClass} to use as search key.<p>
   * @return The {@link ClassInfo} instance (or <code>null</code>).<p>
   */
  public ClassInfo getClassInfo(EClass eClass);

  /**
   * Returns the {@link ClassInfo} instance associated with the {@link EClass} of 
   * the given {@link EObject}.<p>
   * 
   * This is a convenience method and identical to calling 
   * <code>getClassInfo(eObject.eClass())</code>.<p>
   *
   * @see #getClassInfo(EClass)
   * @param eObject The {@link EObject} whose {@link EClass} to use as search key.<p>
   * @return The {@link ClassInfo} instance (or <code>null</code>).<p>
   */
  public ClassInfo getClassInfo(EObject eObject);

  /**
   * Returns the {@link ClassInfo} instance associated with the given {@link CID}.<p>
   *
   * @param cid The {@link CID} to use as search key.<p>
   * @return The {@link ClassInfo} instance (or <code>null</code>).<p>
   */
  public ClassInfo getClassInfo(int cid);

  /**
   * Returns an iterator over all {@link ClassInfo} instances managed by this 
   * {@link PackageManager}.<p>
   *
   * @return An iterator over all {@link ClassInfo} instances managed by this 
   * {@link PackageManager}.<p>
   */
  public Iterator<ClassInfo> getClassInfos();

  /**
   * For internal use only.<p>
   */
  public void initCID(ClassInfo classInfo);

  /**
   * For internal use only.<p>
   */
  public void addPackage(EPackage ePackage, String mappingFile);

  /**
   * Adds a {@link PackageListener} to the list of listeners to be notified about 
   * packages newly added to this {@link PackageManager}.<p>
   *
   * @param listener The {@link PackageListener} to be added.<p>
   */
  public void addPackageListener(PackageListener listener);

  /**
   * Removes a {@link PackageListener} from the list of listeners to be notified about 
   * packages newly added to this {@link PackageManager}.<p>
   *
   * @param listener The {@link PackageListener} to be removed.<p>
   */
  public void removePackageListener(PackageListener listener);

  /**
   * For internal use only.<p>
   */
  public void announceNewPackages(Channel channel);

  /**
   * For internal use only.<p>
   * TODO Move this out of PackageManager.
   */
  public OIDEncoder getOidEncoder(); // Don't change case! Spring will be irritated

  /**
   * For internal use only.<p>
   * TODO Move this out of PackageManager.
   */
  public AttributeConverter getAttributeConverter();
}
