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
import org.eclipse.emf.cdo.core.RID;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import java.util.List;
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
   * Returns <code>true</code> if the current transaction can only be rolled back
   * due to changes by another transaction, <code>false</code> otherwise.<p>
   *
   * @return <code>true</code> if the current transaction can only be rolled back
   * due to changes by another transaction, <code>false</code> otherwise.<p>
   */
  public boolean isRollbackOnly();

  /**
   * Returns <code>true</code> if an invalidation has been deferred for the given 
   * {@link EObject} within the current transaction, <code>false</code> otherwise.<p>
   *
   * @param object The {@link EObject} to check.<p>
   * @return <code>true</code> if an invalidation has been deferred for the given 
   * {@link EObject} within the current transaction, <code>false</code> otherwise.<p>
   */
  public boolean hasDeferredInvalidation(EObject object);

  /**
   * Commits all changes to the CDO repository that have been applied to the contained 
   * {@link CDOPersistable} instances since the last call to {@link #commit} or the
   * creation of this {@link ResourceManager}, whichever occurred more recently.<p>
   * 
   * This is a blocking call. The calling thread gets suspended until the confirmation
   * for the {@link CommitTransactionRequest} is received and processed.<p>
   * 
   * @see CommitTransactionRequest
   * @throws OptimisticControlException if one or several of the objects to be committed
   * has never versions at server side.<p> 
   */
  public void commit() throws OptimisticControlException;

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
   * Returns the {@link ResourceSet} that is associated with and managed by this 
   * {@link ResourceManager}.<p>
   *
   * @return The associated {@link ResourceSet}.<p> 
   */
  public ResourceSet getResourceSet();

  /**
   * Associates the given {@link ResourceSet} with this {@link ResourceManager}.<p>
   * 
   * This method can only be called once!<p> 
   *
   * @param resourceSet The {@link ResourceSet} to associate.<p> 
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
   * Returns the {@link EObject} that is internally identified by the given global 
   * {@link OID}.<p>
   *
   * If the {@link CDOResource} that contains the found {@link EObject} is not loaded 
   * yet, it is automatically loaded into the associated {@link ResourceSet} before.<p>
   *  
   * @param oid The {@link OID} of the {@link EObject} to return.<p>
   * @return The {@link EObject} that is internally identified by the given global 
   * {@link OID}.<p>
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
   * Convenience method to query polymorphic, gloabl extents, returns the same result as 
   * <code>queryExtent(context, false, null)</code>.<p>
   *   
   * @see #queryExtent(EClass, boolean, CDOResource)
   * 
   * @param context The {@link EClass} that all the objects to be queried 
   *    shall be castable to.
   * @return A {@link Set} of all the objects that can safely be casted to the 
   * context {@link EClass}.
   */
  public Set queryExtent(EClass context);

  /**
   * Convenience method to query polymorphic extents, returns the same result as 
   * <code>queryExtent(context, false, resource)</code>.<p>
   *   
   * @see #queryExtent(EClass, boolean, CDOResource)
   * 
   * @param context The {@link EClass} that all the objects to be queried 
   *    shall be castable to.
   * @param resource The {@link CDOResource} to be used as the scope for the extent
   * or <code>null</code> for global extent scope.<p> 
   * @return A {@link Set} of all the objects that can safely be casted to the 
   * context {@link EClass}.
   */
  public Set queryExtent(EClass context, CDOResource resource);

  /**
   * Sends a request to the CDO server to query all
   * {@link CDOPersistable} instances in the given {@link CDOResource} or in all
   * resources of the CDO repository that are instances of the context {@link EClass} 
   * or of any of its subclasses.<p>
   * 
   * The {@link CDOPersistable} instances do not have to be already 
   * loaded in order to be found by this remote query. If they had not been loaded
   * before, CDO will create proxies for them and lazily load them while iterating 
   * over the returned {@link Set}. The remote query is performed on each call
   * to this method, no caching will occur.<p>
   *  
   * @see CDOResource#queryExtent(EClass, boolean)
   * @param context The {@link EClass} that all the objects to be queried 
   *    shall be castable to.
   * @param exactMatch Pass <code>true</code> to exclude objects from the result
   *    that are instances of subclasses of the context {@link EClass}, 
   *    <code>false</code> otherwise.
   * @param resource The {@link CDOResource} to be used as the scope for the extent
   * or <code>null</code> for global extent scope.<p> 
   * @return A {@link Set} of all the objects that can safely be casted to the context 
   *    {@link EClass}.
   */
  public Set queryExtent(EClass context, boolean exactMatch, CDOResource resource);

  /**
   * Convenience method to query gloabl extents, returns the same result as 
   * <code>queryExtent(context, exactMatch, null)</code>.<p>
   *   
   * @see #queryExtent(EClass, boolean, CDOResource)
   * 
   * @param context The {@link EClass} that all the objects to be queried 
   *    shall be castable to.
   * @param exactMatch Pass <code>true</code> to exclude objects from the result
   *    that are instances of subclasses of the context {@link EClass}, 
   *    <code>false</code> otherwise.
   * @return A {@link Set} of all the objects in all resources of the CDO respository 
   *    that can safely be casted to the context {@link EClass}.
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
   * TODO Document method queryCrossReferences<p>
   * The <code>queryCrossReferences</code> method.<p>
   *
   * @param object
   * @param resource
   * @return
   */
  public EList queryCrossReferences(EObject object,CDOResource resource);

  /**
   * Adds a {@link InvalidationListener} to the list of listeners to be notified about 
   * invalidated obejcts in the scope of this {@link PackageManager}.<p>
   *
   * @param listener The {@link InvalidationListener} to be added.<p>
   */
  public void addInvalidationListener(InvalidationListener listener);

  /**
   * Removes a {@link InvalidationListener} from the list of listeners to be notified about 
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
     * @param invalidated A list of {@link EObject} instances which have been invalidated.<p>
     * @param deferred A list of {@link EObject} instances which have been deferred 
     * because they are currently being changed.<p>
     */
    public void notifyInvalidation(ResourceManager resourceManager, List<EObject> invalidated,
        List<EObject> deferred);
  }
}
