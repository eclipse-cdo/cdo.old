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
package org.eclipse.emf.cdo.client.impl;


import org.eclipse.net4j.transport.Channel;
import org.eclipse.net4j.transport.Connector;
import org.eclipse.net4j.transport.ConnectorException;
import org.eclipse.net4j.util.lifecycle.AbstractLifecycle;
import org.eclipse.net4j.util.om.ContextTracer;

import org.eclipse.emf.cdo.client.CDOPersistable;
import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.cdo.client.ClassInfo;
import org.eclipse.emf.cdo.client.OptimisticControlException;
import org.eclipse.emf.cdo.client.PackageManager;
import org.eclipse.emf.cdo.client.PausableChangeRecorder;
import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.client.internal.CDOClient;
import org.eclipse.emf.cdo.client.protocol.ClientCDOProtocolImpl;
import org.eclipse.emf.cdo.core.CDOProtocol;
import org.eclipse.emf.cdo.core.ImplementationError;
import org.eclipse.emf.cdo.core.OIDEncoder;
import org.eclipse.emf.cdo.core.util.thread.DeadlockDetector;
import org.eclipse.emf.cdo.core.util.thread.Worker;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


public class ResourceManagerImpl extends AbstractLifecycle implements ResourceManager
{
  private static final int CAPACITY_oidToObjectMap = 10007;

  private static final ContextTracer TRACER = new ContextTracer(CDOClient.DEBUG_RESOURCE,
      ResourceManagerImpl.class);

  private ResourceSet resourceSet;

  private Connector connector;

  private PackageManager packageManager;

  private transient Channel cachedChannel;

  private transient boolean requestingObjects = true;

  private transient Map ridToResourceMap = new HashMap();

  private transient Map pathToResourceMap = new HashMap();

  private transient Map oidToObjectMap = new HashMap(CAPACITY_oidToObjectMap);

  private transient List<EObject> detachedObjects = new ArrayList<EObject>();

  private transient List<Long> deferredInvalidations = new ArrayList<Long>();

  private transient PausableChangeRecorder transaction;

  private transient Invalidator invalidator;

  private transient List<InvalidationListener> invalidationListeners = new ArrayList<InvalidationListener>();

  private Adapter resourceSetAdapter = new AdapterImpl()
  {
    public void notifyChanged(Notification msg)
    {
      if (!(msg.getNotifier() instanceof ResourceSet) || msg.getNotifier() != resourceSet)
      {
        throw new ImplementationError("Not adapted to this ResourceSet " + resourceSet);
      }

      switch (msg.getEventType())
      {
        case Notification.REMOVE:
          if (msg.getOldValue() instanceof CDOResource)
          {
            CDOResource resource = (CDOResource) msg.getOldValue();
            resource.eAdapters().remove(transaction);
            notifyRemovedResource(resource);
          }
          break;

        case Notification.REMOVE_MANY:
          Collection newResources = (Collection) msg.getNewValue();
          Collection oldResources = (Collection) msg.getOldValue();

          for (Iterator iter = oldResources.iterator(); iter.hasNext();)
          {
            Object element = iter.next();

            if (element instanceof CDOResource)
            {
              if (!newResources.contains(element))
              {
                CDOResource resource = (CDOResource) element;
                resource.eAdapters().remove(transaction);
                notifyRemovedResource(resource);
              }
            }
          }
          break;

        default:
      }
    }
  };

  public PackageManager getPackageManager()
  {
    return packageManager;
  }

  public void setPackageManager(PackageManager packageManager)
  {
    this.packageManager = packageManager;
  }

  public Connector getConnector()
  {
    return connector;
  }

  public void setConnector(Connector connector)
  {
    this.connector = connector;
  }

  public ResourceSet getResourceSet()
  {
    return resourceSet;
  }

  public void setResourceSet(ResourceSet resourceSet)
  {
    this.resourceSet = resourceSet;

    resourceSet.eAdapters().add(resourceSetAdapter);
    transaction = new PausableChangeRecorderImpl();
    transaction.beginRecording(resourceSet);

    Resource.Factory factory = new CDOResourceFactoryImpl(this);

    Map protocols = resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap();
    protocols.put(CDOProtocol.PROTOCOL_NAME, factory);

    Map extensions = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
    extensions.put(CDOProtocol.PROTOCOL_NAME, factory);
  }

  public PausableChangeRecorder getTransaction()
  {
    return transaction;
  }

  public Resource createResource(URI uri)
  {
    return resourceSet.createResource(uri);
  }

  public Resource getResource(URI uri, boolean loadOnDemand)
  {
    return resourceSet.getResource(uri, loadOnDemand);
  }

  public void registerResource(CDOResource resource)
  {
    Integer rid = new Integer(resource.getRID());
    ridToResourceMap.put(rid, resource);

    //XXX    String path = resource.getPath();
    //    if (path != null)
    //    {
    //      pathToResourceMap.put(path, resource);
    //    }
  }

  public void registerResourcePath(CDOResource cdoResource, String path)
  {
    cdoResource.setPath(path);
    pathToResourceMap.put(path, cdoResource);
  }

  public CDOResource getResource(int rid)
  {
    CDOResource resource = (CDOResource) ridToResourceMap.get(new Integer(rid));

    if (resource == null)
    {
      URI uri = CDOResourceFactoryImpl.formatURI(rid);
      resource = (CDOResource) resourceSet.getResource(uri, true);
    }

    return resource;
  }

  public Set<EObject> queryExtent(EClass context, boolean exactMatch, CDOResource resource)
  {
    ClassInfo classInfo = packageManager.getClassInfo(context);
    try
    {
      return ClientCDOProtocolImpl.requestQueryExtent(getChannel(), classInfo.getCID(), exactMatch,
          resource != null ? resource.getRID() : CDOProtocol.GLOBAL_EXTENT);
    }
    catch (Exception ex)
    {
      CDOClient.LOG.error(ex);
      return null;
    }
  }

  public Set<EObject> queryExtent(EClass context, boolean exactMatch)
  {
    return queryExtent(context, exactMatch, null);
  }

  public Set<EObject> queryExtent(EClass context, CDOResource resource)
  {
    return queryExtent(context, false, resource);
  }

  public Set<EObject> queryExtent(EClass context)
  {
    return queryExtent(context, false, null);
  }

  public EList queryCrossReferences(EObject object, CDOResource resource)
  {
    if (object instanceof CDOPersistable)
    {
      long oid = ((CDOPersistable) object).cdoGetOID();
      try
      {
        return ClientCDOProtocolImpl.requestQueryXRefs(getChannel(), oid,
            resource != null ? resource.getRID() : CDOProtocol.GLOBAL_XREFS);
      }
      catch (Exception ex)
      {
        CDOClient.LOG.error(ex);
        return null;
      }
    }

    return ECollections.EMPTY_ELIST;
  }

  public EList queryCrossReferences(EObject object)
  {
    return queryCrossReferences(object, null);
  }

  public Channel getChannel()
  {
    if (cachedChannel == null)
    {
      try
      {
        cachedChannel = connector.openChannel(CDOProtocol.PROTOCOL_NAME);
      }
      catch (ConnectorException ex)
      {
        CDOClient.LOG.error(ex);
      }
    }

    return cachedChannel;
  }

  protected void notifyRemovedResource(CDOResource resource)
  {
    Integer rid = new Integer(resource.getRID());
    if (TRACER.isEnabled())
    {
      TRACER.trace("Removing resource with rid " + rid);
    }

    synchronized (ridToResourceMap)
    {
      ridToResourceMap.remove(rid);
    }
  }

  public boolean isRollbackOnly()
  {
    return !deferredInvalidations.isEmpty();
  }

  public boolean hasDeferredInvalidation(EObject object)
  {
    return deferredInvalidations.contains(object);
  }

  public void commit() throws Exception
  {
    if (transaction == null)
    {
      throw new ImplementationError("No transaction!");
    }

    stopRequestingObjects();
    transaction.setRecording(true);
    ChangeDescription cd = transaction.endRecording();
    startRequestingObjects();

    // This is a workaround because cd.getObjectsToAttach() seemed to be useless most of the times
    cd.getObjectsToAttach().clear();
    cd.getObjectsToAttach().addAll(detachedObjects);
    detachedObjects.clear();

    boolean ok = ClientCDOProtocolImpl.requestCommit(getChannel(), cd, getPackageManager());
    processDeferredInvalidations();
    transaction.beginRecording(resourceSet);

    if (!ok)
    {
      throw new OptimisticControlException(
          "Another CDO transaction has updated one of the objects to be saved. Your transaction has been rolled back.");
    }
  }

  public EObject getObject(long oid)
  {
    EObject object = (EObject) oidToObjectMap.get(new Long(oid));

    if (object != null && ((InternalEObject) object).eProxyURI() == null)
    {
      return object;
    }

    return null;
  }

  public EObject getProxyObject(long oid)
  {
    EObject object = (EObject) oidToObjectMap.get(new Long(oid));

    if (object != null)
    {
      URI proxyUri = ((InternalEObject) object).eProxyURI();

      if (proxyUri != null)
      {
        return object;
      }
    }

    return null;
  }

  public void registerObject(long oid, EObject object)
  {
    // Ensure that the resource will be loaded
    int rid = packageManager.getOidEncoder().getRID(oid);
    URI uri = CDOResourceFactoryImpl.formatURI(rid);
    resourceSet.getResource(uri, true);

    oidToObjectMap.put(new Long(oid), object);
    // TODO Deregister sometime!!!

    transaction.setLoading(true);
    transaction.addAdapter(object);
    transaction.setLoading(false);
  }

  public void requestObject(CDOPersistable cdoObject) throws Exception
  {
    long oid = cdoObject.cdoGetOID();
    if (TRACER.isEnabled())
    {
      TRACER.trace("Demand loading object: " + packageManager.getOidEncoder().toString(oid));
    }

    ClientCDOProtocolImpl.requestLoad(getChannel(), oid);
  }

  public void reRegisterObject(EObject object, long newId)
  {
    Long oldId = new Long(getOID(object));
    if (TRACER.isEnabled())
    {
      TRACER.trace("Re-registering object " + packageManager.getOidEncoder().toString(oldId)
          + " -> " + packageManager.getOidEncoder().toString(newId));
    }

    oidToObjectMap.remove(oldId);
    oidToObjectMap.put(new Long(newId), object);
  }

  public void rollback()
  {
    if (transaction == null)
    {
      throw new ImplementationError("No transaction!");
    }

    ChangeDescription cd = transaction.endRecording();
    cd.apply();

    transaction.beginRecording(resourceSet);
  }

  public boolean isRequestingObjects()
  {
    return requestingObjects;
  }

  public void startRequestingObjects()
  {
    if (TRACER.isEnabled())
    {
      TRACER.trace("START requesting objects: " + Thread.currentThread());
    }

    requestingObjects = true;
    if (transaction != null) transaction.setRecording(true);
  }

  public void stopRequestingObjects()
  {
    if (TRACER.isEnabled())
    {
      TRACER.trace("STOP requesting objects: " + Thread.currentThread());
    }

    requestingObjects = false;
    if (transaction != null) transaction.setRecording(false);
  }

  public void handleRemovedResources(int[] rids)
  {
    EList resources = getResourceSet().getResources();
    for (Iterator it = resources.iterator(); it.hasNext();)
    {
      Resource resource = (Resource) it.next();
      if (resource instanceof CDOResource)
      {
        CDOResource cdoResource = (CDOResource) resource;
        if (isRIDContained(cdoResource.getRID(), rids))
        {
          stopRequestingObjects();
          cdoResource.unload();
          it.remove();
          startRequestingObjects();
        }
      }
    }
  }

  private boolean isRIDContained(int rid, int[] rids)
  {
    for (int contained : rids)
    {
      if (contained == rid)
      {
        return true;
      }
    }

    return false;
  }

  public void invalidateObjects(long[] oids)
  {
    if (TRACER.isEnabled())
    {
      StringBuffer buffer = new StringBuffer();
      for (int i = 0; i < oids.length; i++)
      {
        long oid = oids[i];
        buffer.append(buffer.length() == 0 ? "[" : ", ");
        buffer.append(packageManager.getOidEncoder().toString(oid));
      }

      buffer.append("]");
      TRACER.trace("Invalidating objects " + buffer);
    }

    invalidator.enqueue(oids);
  }

  public void detachObject(EObject object)
  {
    detachedObjects.add(object);
  }

  public URI createProxyURI(long oid)
  {
    OIDEncoder oidEncoder = packageManager.getOidEncoder();
    int rid = oidEncoder.getRID(oid);
    long oidFragment = oidEncoder.getOIDFragment(oid);

    StringBuffer buffer = new StringBuffer();
    buffer.append(CDOProtocol.PROTOCOL_SCHEME);
    buffer.append(rid);
    buffer.append("#");
    buffer.append(oidFragment);

    if (TRACER.isEnabled())
    {
      TRACER.trace("Creating proxy URI " + buffer.toString());
    }

    return URI.createURI(buffer.toString());
  }

  public void stop()
  {
    if (cachedChannel != null)
    {
      try
      {
        cachedChannel.close();
        cachedChannel = null;
      }
      catch (Exception ex)
      {
        CDOClient.LOG.error("Problem while stopping channel " + cachedChannel, ex);
      }
    }
  }

  @Override
  protected void onAboutToActivate() throws Exception
  {
    super.onAboutToActivate();
    if (packageManager == null)
    {
      throw new IllegalStateException("packageManager == null");
    }

    if (connector == null)
    {
      throw new IllegalStateException("connector == null");
    }

    if (resourceSet == null)
    {
      throw new IllegalStateException("resourceSet == null");
    }
  }

  @Override
  protected void onActivate() throws Exception
  {
    super.onActivate();
    invalidator = new Invalidator();
    invalidator.setDaemon(true);
    invalidator.startup();
  }

  @Override
  protected void onDeactivate() throws Exception
  {
    invalidator.shutdown(200);
    invalidator = null;
    cachedChannel = null;
    connector = null;
    deferredInvalidations = null;
    invalidationListeners = null;
    invalidator = null;
    oidToObjectMap = null;
    packageManager = null;
    pathToResourceMap = null;
    resourceSet = null;
    resourceSetAdapter = null;
    ridToResourceMap = null;
    transaction = null;
    super.onDeactivate();
  }

  public EObject createEObject(EClass eClass, long oid, int oca, CDOResource resource)
  {
    // Reflectively create a new EObject 
    EObject persistable = EcoreUtil.create(eClass);
    initPersistable(persistable, resource, oid, oca);
    return persistable;
  }

  public static long getOID(EObject eObject)
  {
    return ((CDOPersistable) eObject).cdoGetOID();
  }

  public static int getOCA(EObject eObject)
  {
    return ((CDOPersistable) eObject).cdoGetOCA();
  }

  public static void initPersistable(EObject persistable, CDOResource resource, long oid, int oca)
  {
    CDOPersistable p = (CDOPersistable) persistable;
    p.cdoSetResource(resource);
    p.cdoSetOID(oid);
    p.cdoSetOCA(oca);

    PausableChangeRecorder transaction = resource.getResourceManager().getTransaction();
    transaction.addAdapter(p);
  }

  //  public static void setOID(EObject eObject, long oid, CDOResource resource)
  //  {
  //    ((CDOPersistable) eObject).cdoSetOID(oid, resource);
  //  }
  //
  //  public static void setOCA(EObject eObject, int oca)
  //  {
  //    ((CDOPersistable) eObject).cdoSetOCA(oca);
  //  }

  public static void incOCA(EObject eObject)
  {
    int oca = ((CDOPersistable) eObject).cdoGetOCA();
    ((CDOPersistable) eObject).cdoSetOCA(oca + 1);
  }

  public static String getLabel(EObject eObject)
  {
    EClass eclass = eObject.eClass();
    String label = eclass.getName();

    try
    {
      EStructuralFeature nameFeature = eclass.getEStructuralFeature("name");
      if (nameFeature != null)
      {
        Object o = eObject.eGet(nameFeature);
        label += " " + ((String) o);
      }
    }
    catch (Throwable ignore)
    {
    }

    try
    {
      label += " " + getOID(eObject) + "v" + getOCA(eObject);
    }
    catch (Throwable ignore)
    {
    }

    return label;
  }

  public void addInvalidationListener(InvalidationListener listener)
  {
    invalidationListeners.add(listener);
  }

  public void removeInvalidationListener(InvalidationListener listener)
  {
    invalidationListeners.remove(listener);
  }

  protected void processDeferredInvalidations()
  {
    long[] oids = new long[deferredInvalidations.size()];
    int i = 0;
    for (Long oid : deferredInvalidations)
    {
      oids[i++] = oid;
    }

    deferredInvalidations.clear();
    processInvalidations(oids);
  }

  protected synchronized void processInvalidations(long[] oids)
  {
    List<EObject> invalidated = new ArrayList<EObject>();
    List<EObject> deferred = new ArrayList<EObject>();
    for (int i = 0; i < oids.length; i++)
    {
      long oid = oids[i];
      EObject object = getObject(oid);
      if (object == null)
      {
        if (TRACER.isEnabled())
        {
          TRACER.trace("Processing invalidation " + packageManager.getOidEncoder().toString(oid)
              + " (IGNORED)");
        }
      }
      else if (transaction.isChanged(object))
      {
        if (TRACER.isEnabled())
        {
          TRACER.trace("Processing invalidation " + packageManager.getOidEncoder().toString(oid)
              + " (DEFERRED)");
        }

        deferred.add(object);
        deferredInvalidations.add(oid);
      }
      else
      {
        if (TRACER.isEnabled())
        {
          TRACER.trace("Processing invalidation " + packageManager.getOidEncoder().toString(oid));
        }

        invalidated.add(object);
        URI uri = createProxyURI(oid);
        ((InternalEObject) object).eSetProxyURI(uri);
        ((CDOPersistable) object).cdoSetOCA(CDOPersistable.NOT_LOADED_YET);
      }
    }

    notifyInvalidationListeners(invalidated, deferred);
  }

  protected void notifyInvalidationListeners(List<EObject> invalidated, List<EObject> deferred)
  {
    for (InvalidationListener listener : invalidationListeners)
    {
      listener.notifyInvalidation(this, invalidated, deferred);
    }
  }


  private final class Invalidator extends Worker
  {
    private BlockingQueue<Entry> queue = new LinkedBlockingQueue<Entry>();

    public Invalidator()
    {
      super("ResourceManager.Invalidator");
    }

    public void enqueue(long[] oids)
    {
      Entry entry = new Entry();
      entry.entered = System.currentTimeMillis();
      entry.oids = oids;

      try
      {
        queue.put(entry);
      }
      catch (InterruptedException ignore)
      {
      }
    }

    @Override
    protected long doWorkStep(int progress)
    {
      try
      {
        Entry entry = queue.poll(50L, TimeUnit.MILLISECONDS);
        if (!isActive())
        {
          return TERMINATE;
        }

        if (entry != null)
        {
          while (System.currentTimeMillis() < entry.entered + 50 || !isRequestingObjects())
          {
            DeadlockDetector.sleep(2);
          }

          processInvalidations(entry.oids);
        }
      }
      catch (InterruptedException ex)
      {
        return TERMINATE;
      }
      catch (NoClassDefFoundError ex)
      {
        if (!isRunning())
        {
          return TERMINATE;
        }

        throw ex;
      }

      return NO_PAUSE;
    }


    private class Entry
    {
      public long entered;

      public long[] oids;
    }
  }
}
