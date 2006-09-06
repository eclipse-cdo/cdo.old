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


import org.eclipse.emf.cdo.core.RID;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import java.util.Set;


/**
 * A special {@link Resource} that associates a CDO {@link ResourceManager}
 * to the contained {@link org.eclipse.emf.ecore.EObject EObject} instances.<p>
 *
 * There are two possible {@link URI} formats for a 
 * {@link CDOResource} that can be used interchangeably:
 * <ol>
 * <li> The scheme is <code>cdo</code> and the opaque part of the 
 *      {@link URI} contains an arbitrary, but absolute and unique <b>path</b>, 
 *      for example <code>cdo:///com/foo/bar.xyz</code> 
 * <li> The scheme is <code>cdo</code> and the opaque part of the {@link URI} 
 *      contains a flat <b>resource identifier</b> ({@link RID}), for 
 *      example <code>cdo://4711</code> 
 * </ol>
 *
 * The first format is usually used by clients when creating or loading a 
 * {@link CDOResource}. The second format is used internally by CDO, but can also
 * be used by additional tooling. The {@link RID} of a {@link CDOResource}
 * is assigned by the CDO server, is guaranteed to be unique and will never change.<p> 
 * 
 * This interface is not expected to be implemented by clients.<p>
 * 
 * @see CDOPersistable
 * @see ResourceManager
 * @author Eike Stepper
 */
public interface CDOResource extends Resource
{
  /**
   * Returns the {@link ResourceManager} associated with this 
   * {@link CDOResource}.<p>
   *
   * @return The {@link ResourceManager} associated with this 
   * {@link CDOResource}.
   */
  public ResourceManager getResourceManager();

  /**
   * Determines if this {@link CDOResource} does already exist in 
   * the repository.<p>
   *
   * @return <code>true</code> if this {@link CDOResource} exists in 
   * the repository, <code>false</code> otherwise. 
   */
  public boolean isExisting();

  /**
   * For internal use only.
   */
  public void setExisting(boolean existing);

  /**
   * Returns the absolute path of this {@link CDOResource}.<p>
   *
   * @return The absolute path of this {@link CDOResource}.
   */
  public String getPath();

  /**
   * Returns the {@link RID} of this {@link CDOResource}.<p>
   *
   * @return The {@link RID} of this {@link CDOResource}.
   */
  public int getRID();

  /**
   * Returns the {@link ResourceInfo} of this {@link CDOResource}.<p>
   *
   * @return The {@link ResourceInfo} of this {@link CDOResource}.
   */
  public ResourceInfo getInfo();
  
  /**
   * For internal use only.
   */
  public void setPath(String path);

  /**
   * Convenience method to query polymorphic extents, returns the same result as 
   * <code>queryExtent(context, false)</code>.<p>
   *   
   * @see #queryExtent(EClass, boolean)
   * @see ResourceManager#queryExtent(EClass)
   * 
   * @param context The {@link EClass} that all the objects to be queried 
   *    shall be castable to.
   * @return A {@link Set} of all the objects in this 
   *    {@link CDOResource} that can safely be casted to the context 
   *    {@link EClass}.
   */
  public Set queryExtent(EClass context);

  /**
   * Sends a request to the CDO server to query all
   * {@link CDOPersistable} instances in this {@link CDOResource}
   * that are instances of the context {@link EClass} or of any 
   * of its subclasses.<p>
   * 
   * The {@link CDOPersistable} instances do not have to be already 
   * loaded in order to be found by this remote query. If they had not been loaded
   * before, CDO will create proxies for them and lazily load them while iterating 
   * over the returned {@link Set}. The remote query is performed on each call
   * to this method, no caching will occur.<p>
   *  
   * @see ResourceManager#queryExtent(EClass, boolean)
   * @param context The {@link EClass} that all the objects to be queried 
   *    shall be castable to.
   * @param exactMatch Pass <code>true</code> to exclude objects from the result
   *    that are instances of subclasses of the context {@link EClass}, 
   *    <code>false</code> otherwise.
   * @return A {@link Set} of all the objects in this 
   *    {@link CDOResource} that can safely be casted to the context 
   *    {@link EClass}.
   */
  public Set queryExtent(EClass context, boolean exactMatch);

  /**
   * TODO Document method queryCrossReferences<p>
   * The <code>queryCrossReferences</code> method.<p>
   *
   * @param object
   * @return
   */
  public EList queryCrossReferences(EObject object);

  /**
   * Loads all the contained objects from the repository.<p>
   */
  public void preLoad();

}
