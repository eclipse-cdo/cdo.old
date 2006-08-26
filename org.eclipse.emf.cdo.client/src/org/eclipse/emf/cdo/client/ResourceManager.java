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

import org.eclipse.emf.cdo.client.protocol.CommitTransactionRequest;
import org.eclipse.emf.cdo.core.OID;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import java.util.Set;


/**
 * Manages the {@link CDOResource} instances in an associated {@link ResourceSet}.<p>
 * 
 * A {@link ResourceManager} can be seen as a "CDO session" for the {@link ResourceSet}.
 * It holds a handle to the {@link Channel} that connects this {@link ResourceManager}
 * to the CDO server.
 *
 * @author Eike Stepper
 */
public interface ResourceManager extends Service
{
  /**
   * Commits all changes to the CDO repository that have been applied to the contained 
   * {@link CDOPersistable} instances since the last call to {@link #commit} or the
   * creation of this {@link ResourceManager}, whichever occurred more recently.<p>
   * 
   * This is a blocking call. The calling thread gets suspended until the confirmation
   * for the {@link CommitTransactionRequest} is received and processed.<p>
   * 
   * @see CommitTransactionRequest
   */
  public void commit();

  /**
   * Rolls back the current transaction that is started with the creation 
   * of this {@link ResourceManager} or after a call to {@link #commit},
   * whichever occurred more recently.<p>
   * 
   * The associated {@link ResourceSet} and the contained {@link Resource} and
   * {@link EObject} instances are put back into the state before the first change
   * in the current transaction.<p>
   * 
   * Finally a new transaction is started.<p>
   */
  public void rollback();

  /**
   * For internal use only.<p>
   */
  public PausableChangeRecorder getTransaction();

  /**
   * TODO Document method getResourceSet<p>
   * The <code>getResourceSet</code> method.<p>
   *
   * @return
   */
  public ResourceSet getResourceSet();

  /**
   * TODO Document method setResourceSet<p>
   * The <code>setResourceSet</code> method.<p>
   *
   * @param resourceSet
   */
  public void setResourceSet(ResourceSet resourceSet);

  /**
   * Returns the {@link Channel} that represents the connection of this 
   * {@link ResourceManager} to the CDO server.<p>
   *
   * @return The {@link Channel} that represents the connection of this 
   * {@link ResourceManager} to the CDO server.<p>
   */
  public Channel getChannel();

  /**
   * Returns the {@link CDOResource} instance with the given {@link RID} and loads 
   * that {@link CDOResource} if necessary.<p>
   *
   * @param rid The {@link RID} of the resource to load.<p>
   * @return The {@link CDOResource} or <code>null</code> if no resource with the 
   * given {@link RID} exists in the CDO repository.<p>
   */
  public CDOResource getResource(int rid);

  /**
   * A convenience method for creating a resource in the associated {@link ResourceSet}.<p>
   * 
   * Identical to calling <code>getResourceSet().createResource(uri)</code>.<p>
   *
   * @param uri The URI of the resource to create.
   * @return a new resource, or <code>null</code> if no factory is registered.
   */
  public Resource createResource(URI uri);

  /**
   * A convenience method for querying a resource in the associated {@link ResourceSet}
   * and eventually loading that resource.<p>
   * 
   * Identical to calling <code>getResourceSet().getResource(uri, loadOnDemand)</code>.<p>
   *
   * @param uri The URI to resolve.
   * @param loadOnDemand Whether to create and load the resource, if it doesn't already exists.
   * @return The resource resolved by the URI.
   * @throws RuntimeException if a resource can't be demand created.
   * @throws org.eclipse.emf.common.util.WrappedException if a problem occurs during demand load.
   */
  public Resource getResource(URI uri, boolean loadOnDemand);

  /**
   * For internal use only.<p>
   */
  public boolean isRequestingObjects();

  /**
   * For internal use only.<p>
   */
  public void startRequestingObjects();

  /**
   * For internal use only.<p>
   */
  public void stopRequestingObjects();

  /**
   * For internal use only.<p>
   */
  public void requestObject(CDOPersistable cdoObject);

  /**
   * For internal use only.<p>
   */
  public URI createProxyURI(long oid);

  /**
   * For internal use only.<p>
   */
  public EObject getProxyObject(long oid);

  /**
   * For internal use only.<p>
   */
  public void invalidateObjects(long[] oid);

  /**
   * For internal use only.<p>
   */
  public void registerObject(long id, EObject object);

  /**
   * For internal use only.<p>
   */
  public void reRegisterObject(EObject object, long newId);

  /**
   * For internal use only.<p>
   */
  public EObject createEObject(EClass eClass, long oid, int oca, CDOResource resource);

  /**
   * TODO Document method getObject<p>
   * The <code>getObject</code> method.<p>
   *
   * @param oid
   * @return
   */
  public EObject getObject(long oid);

  /**
   * For internal use only.<p>
   */
  public void registerResource(CDOResource resource);

  /**
   * For internal use only.<p>
   */
  public void registerResourcePath(CDOResource cdoResource, String path);

  /**
   * Returns the {@link PackageManager} used by this {@link ResourceManager}.<p>
   *
   * @return The {@link PackageManager} used by this {@link ResourceManager}.<p>
   */
  public PackageManager getPackageManager();

  /**
   * TODO Document method queryExtent<p>
   * The <code>queryExtent</code> method.<p>
   *
   * @param context
   * @return
   */
  public Set queryExtent(EClass context);

  /**
   * TODO Document method queryExtent<p>
   * The <code>queryExtent</code> method.<p>
   *
   * @param context
   * @param resource
   * @return
   */
  public Set queryExtent(EClass context, CDOResource resource);

  /**
   * TODO Document method queryExtent<p>
   * The <code>queryExtent</code> method.<p>
   *
   * @param context
   * @param exactMatch
   * @param resource
   * @return
   */
  public Set queryExtent(EClass context, boolean exactMatch, CDOResource resource);

  /**
   * TODO Document method queryExtent<p>
   * The <code>queryExtent</code> method.<p>
   *
   * @param context
   * @param exactMatch
   * @return
   */
  public Set queryExtent(EClass context, boolean exactMatch);

  /**
   * Adds an {@link InvalidationListener} to the list of listeners to be notified about 
   * invalidated obejcts in the scope of this {@link PackageManager}.<p>
   *
   * @param listener The {@link InvalidationListener} to be added.<p>
   */
  public void addInvalidationListener(InvalidationListener listener);

  /**
   * Removes an {@link InvalidationListener} from the list of listeners to be notified about 
   * invalidated obejcts in the scope of this {@link PackageManager}.<p>
   *
   * @param listener The {@link InvalidationListener} to be removed.<p>
   */
  public void removeInvalidationListener(InvalidationListener listener);


  /**
   * Can be registered with a {@link ResourceManager} to be subsequently notified about
   * invalidated objects.<p>
   *
   * @author Eike Stepper
   */
  public interface InvalidationListener
  {
    /**
     * Called by the {@link ResourceManager} this {@link InvalidationListener} is 
     * registered with to notify about invalidated objects.<p>
     * 
     * @param resourceManager The {@link ResourceManager} this {@link InvalidationListener} is 
     * registered with.<p>
     * @param oids An array of {@link OID} values which have been invalidated.<p>
     */
    public void notifyInvalidation(ResourceManager resourceManager, long[] oids);
  }
}
