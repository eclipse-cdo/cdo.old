/*
 * Copyright (c) 2008-2016, 2018 Eike Stepper (Loehne, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Martin Taal - specific hibernate functionality
 */
package org.eclipse.emf.cdo.server.internal.hibernate;

import org.eclipse.emf.cdo.common.branch.CDOBranch;
import org.eclipse.emf.cdo.common.branch.CDOBranchHandler;
import org.eclipse.emf.cdo.common.branch.CDOBranchPoint;
import org.eclipse.emf.cdo.common.branch.CDOBranchVersion;
import org.eclipse.emf.cdo.common.commit.CDOCommitInfo;
import org.eclipse.emf.cdo.common.commit.CDOCommitInfoHandler;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDTemp;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.common.lob.CDOLobHandler;
import org.eclipse.emf.cdo.common.model.CDOClassifierRef;
import org.eclipse.emf.cdo.common.protocol.CDODataInput;
import org.eclipse.emf.cdo.common.protocol.CDODataOutput;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.common.revision.CDORevisionCacheAdder;
import org.eclipse.emf.cdo.common.revision.CDORevisionData;
import org.eclipse.emf.cdo.common.revision.CDORevisionHandler;
import org.eclipse.emf.cdo.common.util.CDOQueryInfo;
import org.eclipse.emf.cdo.eresource.EresourcePackage;
import org.eclipse.emf.cdo.server.IQueryHandler;
import org.eclipse.emf.cdo.server.ISession;
import org.eclipse.emf.cdo.server.ITransaction;
import org.eclipse.emf.cdo.server.hibernate.IHibernateStore;
import org.eclipse.emf.cdo.server.hibernate.IHibernateStoreAccessor;
import org.eclipse.emf.cdo.server.internal.hibernate.bundle.OM;
import org.eclipse.emf.cdo.server.internal.hibernate.tuplizer.PersistableListHolder;
import org.eclipse.emf.cdo.server.internal.hibernate.tuplizer.WrappedHibernateList;
import org.eclipse.emf.cdo.spi.common.commit.CDOChangeSetSegment;
import org.eclipse.emf.cdo.spi.common.commit.CDOCommitInfoUtil;
import org.eclipse.emf.cdo.spi.common.commit.InternalCDOCommitInfoManager;
import org.eclipse.emf.cdo.spi.common.model.InternalCDOPackageUnit;
import org.eclipse.emf.cdo.spi.common.revision.DetachedCDORevision;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDORevision;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDORevisionDelta;
import org.eclipse.emf.cdo.spi.server.InternalCommitContext;
import org.eclipse.emf.cdo.spi.server.Store;
import org.eclipse.emf.cdo.spi.server.StoreAccessor;

import org.eclipse.net4j.util.HexUtil;
import org.eclipse.net4j.util.ObjectUtil;
import org.eclipse.net4j.util.StringUtil;
import org.eclipse.net4j.util.WrappedException;
import org.eclipse.net4j.util.collection.Pair;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.IOUtil;
import org.eclipse.net4j.util.io.LimitedInputStream;
import org.eclipse.net4j.util.om.monitor.OMMonitor;
import org.eclipse.net4j.util.om.monitor.OMMonitor.Async;
import org.eclipse.net4j.util.om.trace.ContextTracer;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.teneo.Constants;
import org.eclipse.emf.teneo.PackageRegistryProvider;
import org.eclipse.emf.teneo.hibernate.auditing.model.teneoauditing.TeneoAuditCommitInfo;
import org.eclipse.emf.teneo.hibernate.auditing.model.teneoauditing.TeneoAuditEntry;
import org.eclipse.emf.teneo.hibernate.auditing.model.teneoauditing.TeneoauditingPackage;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Implements the runtime behavior of accessing the hibernate store using queries and doing write and commit. The
 * HibernateStoreAccessor corresponds roughly to a Hibernate session. It offers methods to create and close them and
 * implements transaction handling. The main update/create/delete operations are done in the
 * {@link #write(InternalCommitContext, OMMonitor)} method.
 *
 * @see HibernateStore
 * @see HibernatePackageHandler
 * @author Eike Stepper
 * @author Martin Taal
 */
public class HibernateStoreAccessor extends StoreAccessor implements IHibernateStoreAccessor
{
  private static final ContextTracer TRACER = new ContextTracer(OM.DEBUG, HibernateStoreAccessor.class);

  private static final String NAME_EFEATURE_NAME = "name";//$NON-NLS-1$

  // used to tag an ereference
  private static final String TENEO_MAPPED_SOURCE = "teneo.mapped";

  private static final String TENEO_UNMAPPED_SOURCE = "teneo.unmapped";

  private Session hibernateSession;

  private boolean errorOccured;

  private int currentListChunk = -1;

  private HibernateRawCommitContext rawCommitContext = new HibernateRawCommitContext();

  public void addToRevisionCache(Object object)
  {
    if (object instanceof CDORevision)
    {
      getStore().getRepository().getRevisionManager().addRevision((CDORevision)object);
    }
    else if (object instanceof Object[])
    {
      // handle hibernate query result
      final Object[] objects = (Object[])object;
      for (Object o : objects)
      {
        addToRevisionCache(o);
      }
    }

    // also primitive types can get here, ignore those
  }

  /**
   * Constructor
   *
   * @param store
   *          the {@link Store} used by the accessor.
   * @param session
   *          the client session (not a Hibernate Session)
   */
  public HibernateStoreAccessor(HibernateStore store, ISession session)
  {
    super(store, session);
    if (TRACER.isEnabled())
    {
      TRACER.trace("Created " + this.getClass().getName() + " for repository " + store.getRepository().getName()); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * Constructor for a specific transaction
   *
   * @param store
   *          the HibernateStore backing this accessor
   * @param transaction
   *          the client transaction (not the a Hibernate transaction)
   */
  public HibernateStoreAccessor(HibernateStore store, ITransaction transaction)
  {
    super(store, transaction);
    if (TRACER.isEnabled())
    {
      TRACER.trace("Created " + this.getClass().getName() + " for repository " + store.getRepository().getName()); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * @return the backing store
   */
  @Override
  public HibernateStore getStore()
  {
    return (HibernateStore)super.getStore();
  }

  /**
   * Starts a hibernate session and begins a transaction.
   *
   * @since 2.0
   */
  public void beginHibernateSession()
  {
    if (TRACER.isEnabled())
    {
      TRACER.trace("Creating hibernate session and transaction"); //$NON-NLS-1$
    }

    assert hibernateSession == null;
    final SessionFactory sessionFactory = getStore().getHibernateSessionFactory();
    hibernateSession = sessionFactory.openSession();
    hibernateSession.setDefaultReadOnly(true);
    hibernateSession.setFlushMode(FlushMode.MANUAL);
    hibernateSession.beginTransaction();
  }

  /**
   * Calls {@link #endHibernateSession()}, commits the transaction and closes the session.
   *
   * @since 2.0
   */
  public void commitRollbackHibernateSession()
  {
    endHibernateSession();
  }

  /**
   * Commits/rollbacks and closes the session
   *
   * @since 2.0
   */
  public void endHibernateSession()
  {
    if (TRACER.isEnabled())
    {
      TRACER.trace("Closing hibernate session"); //$NON-NLS-1$
    }

    if (hibernateSession != null && hibernateSession.isOpen())
    {
      try
      {
        if (hibernateSession.getTransaction().isActive())
        {
          if (TRACER.isEnabled())
          {
            TRACER.trace("Commiting hibernate session"); //$NON-NLS-1$
          }

          if (isErrorOccured())
          {
            if (TRACER.isEnabled())
            {
              TRACER.trace("Rolling back hb transaction"); //$NON-NLS-1$
            }

            hibernateSession.getTransaction().rollback();
          }
          else
          {
            if (TRACER.isEnabled())
            {
              TRACER.trace("Committing hb transaction"); //$NON-NLS-1$
            }

            hibernateSession.getTransaction().commit();
          }
        }
      }
      finally
      {
        hibernateSession.close();
      }
    }

    hibernateSession = null;
  }

  /**
   * @return the current hibernate session. If there is none then a new one is created and a transaction is started.
   *
   * Note the default is a readonly flushmode manual session.
   */
  public Session getHibernateSession()
  {
    if (hibernateSession == null)
    {
      beginHibernateSession();
    }
    return hibernateSession;
  }

  /**
   * Closes/commits the current hibernate session if there is one, and starts a new one and begins a transaction.
   *
   * @return a newly created Hibernate Session
   */
  public Session getNewHibernateSession(boolean readOnly)
  {
    if (hibernateSession != null)
    {
      endHibernateSession();
    }

    if (hibernateSession != null)
    {
      throw new IllegalStateException("Hibernate session should be null"); //$NON-NLS-1$
    }

    beginHibernateSession();
    return hibernateSession;
  }

  /**
   * @return true if an error occured during database actions. Normally means that the transaction will be rolled back
   *         and not committed.
   * @since 2.0
   */
  public boolean isErrorOccured()
  {
    return errorOccured;
  }

  /**
   * @since 2.0
   */
  public void setErrorOccured(boolean errorOccured)
  {
    this.errorOccured = errorOccured;
  }

  /**
   * @return a {@link HibernateStoreChunkReader}
   */
  public HibernateStoreChunkReader createChunkReader(InternalCDORevision revision, EStructuralFeature feature)
  {
    return new HibernateStoreChunkReader(this, revision, feature);
  }

  /**
   * @return the current collection of package units.
   * @see HibernateStore
   * @see HibernatePackageHandler
   */
  public Collection<InternalCDOPackageUnit> readPackageUnits()
  {
    return getStore().getPackageHandler().getPackageUnits();
  }

  /**
   * Loads the package units from the database and returns the EPackage instances.
   *
   * @return the loaded EPackage instances.
   * @see HibernatePackageHandler
   */
  public EPackage[] loadPackageUnit(InternalCDOPackageUnit packageUnit)
  {
    return getStore().getPackageHandler().loadPackageUnit(packageUnit);
  }

  /**
   * Reads the revision from the database. using the passed id.
   *
   * @param id
   *          identifies the CDORevision to read
   * @param branchPoint
   *          ignored until auditing is supported.
   * @param listChunk
   *          not used by Hibernate
   * @param cache
   *          the revision cache, the read revision is added to the cache
   * @return the read revision
   */
  public InternalCDORevision readRevision(CDOID id, CDOBranchPoint branchPoint, int listChunk, CDORevisionCacheAdder cache)
  {
    if (!HibernateUtil.getInstance().isStoreCreatedID(id))
    {
      return null;
    }
    currentListChunk = listChunk;
    try
    {
      if (getStore().isAuditing() && getStore().getHibernateAuditHandler().getCDOAuditHandler().isAudited(id))
      {
        InternalCDORevision revision = getStore().getHibernateAuditHandler().readRevision(getHibernateSession(), id, branchPoint.getTimeStamp());
        // found one, use it
        if (revision != null)
        {

          if (cache != null)
          {
            cache.addRevision(revision);
          }
          revision.freeze();

          return revision;
        }
      }

      final InternalCDORevision revision = HibernateUtil.getInstance().getCDORevision(id);
      if (revision == null)
      {
        final CDOClassifierRef classifierRef = CDOIDUtil.getClassifierRef(id);
        if (classifierRef == null)
        {
          throw new IllegalArgumentException("This CDOID type of " + id + " is not supported by this store."); //$NON-NLS-1$ //$NON-NLS-2$
        }

        final EClass eClass = HibernateUtil.getInstance().getEClass(classifierRef);
        return new DetachedCDORevision(eClass, id, branchPoint.getBranch(), 0, 0);
      }

      revision.setBranchPoint(getStore().getMainBranchHead());
      revision.freeze();

      if (cache != null)
      {
        cache.addRevision(revision);
      }

      return revision;
    }
    finally
    {
      currentListChunk = -1;
    }
  }

  public Pair<Integer, Long> createBranch(int branchID, BranchInfo branchInfo)
  {
    // TODO: implement HibernateStoreAccessor.createBranch(branchID, branchInfo)
    throw new UnsupportedOperationException();
  }

  public BranchInfo loadBranch(int branchID)
  {
    // TODO: implement HibernateStoreAccessor.loadBranch(branchID)
    throw new UnsupportedOperationException();
  }

  public SubBranchInfo[] loadSubBranches(int branchID)
  {
    // TODO: implement HibernateStoreAccessor.loadSubBranches(branchID)
    throw new UnsupportedOperationException();
  }

  public int loadBranches(int startID, int endID, CDOBranchHandler branchHandler)
  {
    // TODO: implement HibernateStoreAccessor.loadBranches(startID, endID, branchHandler)
    throw new UnsupportedOperationException();
  }

  public void loadCommitInfos(CDOBranch branch, long startTime, long endTime, CDOCommitInfoHandler handler)
  {
    // no commit info support
    if (!getStore().isAuditing())
    {
      return;
    }

    final Session session = getHibernateSession();
    final InternalCDOCommitInfoManager commitInfoManager = getStore().getRepository().getCommitInfoManager();

    // only get a specific range of objects
    String direction = " desc ";
    int count = 0;
    if (endTime < CDOBranchPoint.UNSPECIFIED_DATE)
    {
      count = CDOCommitInfoUtil.decodeCount(endTime);
      if (count < 0)
      {
        direction = " desc ";
        count = -1 * count;
      }
      else
      {
        direction = " asc ";
      }
    }

    final String qryStr = "select e from TeneoAuditCommitInfo e where e.commitTime>=:startTime and e.commitTime<=:endTime order by e.commitTime " + direction;
    final Query qry = session.createQuery(qryStr);
    if (count > 0)
    {
      qry.setMaxResults(count);
    }
    qry.setParameter("startTime", startTime);
    qry.setParameter("endTime", endTime == CDOBranchPoint.UNSPECIFIED_DATE || endTime < 0 ? Long.MAX_VALUE : endTime);
    for (Object o : qry.list())
    {
      final TeneoAuditCommitInfo teneoCommitInfo = (TeneoAuditCommitInfo)o;
      final CDOCommitInfo cdoCommitInfo = commitInfoManager.createCommitInfo(getStore().getRepository().getBranchManager().getMainBranch(),
          teneoCommitInfo.getCommitTime(), teneoCommitInfo.getCommitTime() - 1, teneoCommitInfo.getUser(), teneoCommitInfo.getComment(), null, null);
      handler.handleCommitInfo(cdoCommitInfo);
    }
  }

  public Set<CDOID> readChangeSet(OMMonitor monitor, CDOChangeSetSegment... segments)
  {
    // TODO: implement HibernateStoreAccessor.readChangeSet(segments)
    throw new UnsupportedOperationException();
  }

  // should only return revisions of the eclass itself and not of its subclasses.
  public void handleRevisions(EClass eClass, CDOBranch branch, long timeStamp, boolean exactTime, CDORevisionHandler handler)
  {

    if (eClass != null)
    {
      if (!getStore().isMapped(eClass))
      {
        return;
      }

      handleRevisionsByEClass(eClass, handler, timeStamp);
    }
    else
    {
      for (EPackage ePackage : getStore().getPackageHandler().getEPackages())
      {
        // an auditing epackage
        if (ePackage == TeneoauditingPackage.eINSTANCE || ePackage.getEAnnotation(Constants.ANNOTATION_SOURCE_AUDITING) != null)
        {
          continue;
        }

        for (EClassifier eClassifier : ePackage.getEClassifiers())
        {
          if (eClassifier instanceof EClass)
          {
            final EClass eClazz = (EClass)eClassifier;
            if (!getStore().isMapped(eClazz))
            {
              continue;
            }
            handleRevisionsByEClass(eClazz, handler, timeStamp);
          }
        }
      }
    }
  }

  private void handleRevisionsByEClass(EClass eClass, CDORevisionHandler handler, long timeStamp)
  {
    // get a transaction, the hibernateStoreAccessor is placed in a threadlocal
    // so all db access uses the same session.
    final Session session = getHibernateSession();
    try
    {
      if (timeStamp > 0)
      {
        getStore().getHibernateAuditHandler().handleRevisionsByEClass(session, eClass, handler, timeStamp);
        return;
      }

      // create the query
      final Query query = session.createQuery("select e from " + getStore().getEntityName(eClass) + " e");
      for (Object o : query.list())
      {
        CDORevision cdoRevision = (CDORevision)o;

        // if a subclass ignore
        if (cdoRevision.getEClass() != eClass)
        {
          continue;
        }

        if (!handler.handleRevision(cdoRevision))
        {
          return;
        }
      }
    }
    finally
    {
      session.clear();
    }
  }

  /**
   * @see #readRevision(CDOID, CDOBranchPoint, int, CDORevisionCacheAdder)
   */
  public InternalCDORevision readRevisionByVersion(CDOID id, CDOBranchVersion branchVersion, int listChunk, CDORevisionCacheAdder cache)
  {
    InternalCDORevision revision = null;
    if (getStore().getHibernateAuditHandler().getCDOAuditHandler().isAudited(id))
    {
      revision = getStore().getHibernateAuditHandler().readRevisionByVersion(getHibernateSession(), id, branchVersion.getVersion());
    }
    else
    {
      revision = readRevision(id, branchVersion.getBranch().getPoint(System.currentTimeMillis()), listChunk, cache);
      if (revision != null)
      {
        // otherwise CDO gets confused and we get wrong version numbers later
        revision.setVersion(branchVersion.getVersion());
      }
    }

    if (revision != null && !(revision instanceof DetachedCDORevision))
    {
      revision.freeze();
    }

    if (cache != null)
    {
      cache.addRevision(revision);
    }

    return revision;
  }

  /**
   * Queries for resources in a certain folder and returns them in the context object
   *
   * @param context
   *          the context provides input parameters (the folder) and is used to store the results of the query.
   * @since 2.0
   */
  public void queryResources(QueryResourcesContext context)
  {
    final Session session = getHibernateSession();

    final CDOID folderID = getHibernateID(context.getFolderID());
    String name = context.getName();
    boolean exactMatch = context.exactMatch();
    final HibernateAuditHandler hibernateAuditHandler = getStore().getHibernateAuditHandler();

    List<?> result = null;
    if (context.getTimeStamp() == 0 || !getStore().isAuditing())
    {

      final Criteria criteria = session.createCriteria(EresourcePackage.eINSTANCE.getCDOResourceNode().getName());
      if (folderID == null)
      {
        criteria.add(org.hibernate.criterion.Restrictions.isNull("folder"));
      }
      else
      {
        criteria.add(org.hibernate.criterion.Restrictions.eq("folder.id", CDOIDUtil.getLong(folderID)));
      }

      result = criteria.list();
    }
    else
    {
      result = hibernateAuditHandler.getCDOResources(session, folderID, context.getTimeStamp());
    }

    for (Object o : result)
    {
      final CDORevision revision;
      if (o instanceof CDORevision)
      {
        revision = (CDORevision)o;
      }
      else
      {
        final TeneoAuditEntry teneoAuditEntry = (TeneoAuditEntry)o;
        revision = hibernateAuditHandler.getCDORevision(session, teneoAuditEntry);
      }

      ((InternalCDORevision)revision).freeze();

      final EStructuralFeature feature = revision.getEClass().getEStructuralFeature(NAME_EFEATURE_NAME);
      if (feature != null)
      {
        Object value = revision.data().get(feature, 0);
        if (value == CDORevisionData.NIL)
        {
          value = null;
        }

        final String revisionName = (String)value;
        final boolean match = exactMatch || revisionName == null || name == null ? ObjectUtil.equals(revisionName, name) : revisionName.startsWith(name);

        if (match && !context.addResource(HibernateUtil.getInstance().getCDOID(revision)))
        {
          // No more results allowed
          break;
        }
      }
    }
  }

  public void queryXRefs(QueryXRefsContext context)
  {
    final Session session = getHibernateSession();
    for (CDOID targetCdoId : context.getTargetObjects().keySet())
    {
      final CDORevision revision = HibernateUtil.getInstance().getCDORevision(targetCdoId);
      final EClass targetEClass = context.getTargetObjects().get(targetCdoId);

      if (!getStore().isMapped(targetEClass))
      {
        continue;
      }

      final String targetEntityName = getStore().getEntityName(targetEClass);
      final Map<EClass, List<EReference>> sourceCandidates = context.getSourceCandidates();
      for (EClass sourceEClass : sourceCandidates.keySet())
      {

        if (!getStore().isMapped(sourceEClass))
        {
          continue;
        }

        final String sourceEntityName = getStore().getEntityName(sourceEClass);
        for (EReference eref : sourceCandidates.get(sourceEClass))
        {
          // handle transient ereferences
          if (!isEReferenceMapped(session, sourceEntityName, eref))
          {
            continue;
          }

          final String hql;
          if (eref.isMany())
          {
            hql = "select ref from " + sourceEntityName + " as ref, " + targetEntityName + " as refTo where refTo = :to and refTo in elements(ref."
                + eref.getName() + ")";
          }
          else
          {
            hql = "select ref from " + sourceEntityName + " as ref where :to = ref." + eref.getName();
          }

          final Query qry = session.createQuery(hql);
          qry.setEntity("to", revision);
          ScrollableResults result = qry.scroll(ScrollMode.FORWARD_ONLY);
          while (result.next())
          {
            final InternalCDORevision sourceRevision = (InternalCDORevision)result.get()[0];

            sourceRevision.freeze();

            int sourceIndex = 0;
            if (eref.isMany())
            {
              // note this takes performance for sure as the list is read,
              // consider not supporting sourceIndex, or doing it differently
              final WrappedHibernateList cdoList = (WrappedHibernateList)sourceRevision.getOrCreateList(eref);
              sourceIndex = cdoList.getDelegate().indexOf(revision);
            }

            boolean more = context.addXRef(targetCdoId, sourceRevision.getID(), eref, sourceIndex);
            if (!more)
            {
              return;
            }
          }
        }
      }
    }
  }

  private boolean isEReferenceMapped(Session session, String entityName, EReference eref)
  {
    // mapped
    if (null != eref.getEAnnotation(TENEO_MAPPED_SOURCE))
    {
      return true;
    }
    else
    // not mapped
    if (null != eref.getEAnnotation(TENEO_UNMAPPED_SOURCE))
    {
      return false;
    }

    // not computed yet
    for (String propName : session.getSessionFactory().getClassMetadata(entityName).getPropertyNames())
    {
      if (propName.equals(eref.getName()))
      {
        final EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
        eAnnotation.setSource(TENEO_MAPPED_SOURCE);
        eref.getEAnnotations().add(eAnnotation);
        return true;
      }
    }
    // not mapped
    final EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
    eAnnotation.setSource(TENEO_UNMAPPED_SOURCE);
    eref.getEAnnotations().add(eAnnotation);
    return false;
  }

  private CDOID getHibernateID(CDOID id)
  {
    if (!CDOIDUtil.isNull(id))
    {
      if (HibernateUtil.getInstance().isStoreCreatedID(id))
      {
        return id;
      }

      // TODO Can this happen? When?
      // the folder id is always a long
      final Long idValue = CDOIDUtil.getLong(id);
      return CDOIDUtil.createLongWithClassifier(idValue, new CDOClassifierRef(EresourcePackage.eINSTANCE.getCDOResourceNode()));
    }

    return null;
  }

  /**
   * @param info
   *          the query information, is not used actively in this method.
   * @return a new instance of {@link HibernateQueryHandler}
   */
  public IQueryHandler getQueryHandler(CDOQueryInfo info)
  {
    String queryLanguage = info.getQueryLanguage();
    if (StringUtil.equalsUpperOrLowerCase(queryLanguage, IHibernateStore.QUERY_LANGUAGE))
    {
      final HibernateQueryHandler queryHandler = new HibernateQueryHandler();
      queryHandler.setHibernateStoreAccessor(this);
      return queryHandler;
    }

    return null;
  }

  /**
   * Commits the session, see {@link #commitRollbackHibernateSession()}.
   *
   * @param monitor
   *          not used
   */
  @Override
  protected void doCommit(OMMonitor monitor)
  {
    commitRollbackHibernateSession();
    HibernateThreadContext.setCommitContext(null);
  }

  /**
   * Performs the main write and update actions. Persists new EPackages, updates changed objects, creates new ones and
   * removes deleted objects. Updates both container as well as resource associations.
   *
   * @param context
   *          the context contains the changed, new and to-be-removed objects
   * @param monitor
   *          not used by this method
   */
  @Override
  public void doWrite(InternalCommitContext context, OMMonitor monitor)
  {
    // NOTE: the same flow is also present in the super class (StoreAccessor)
    // changes in flow can mean that the flow here also has to change

    monitor.begin(3);
    HibernateThreadContext.setCommitContext(context);
    if (context.getNewPackageUnits().length > 0)
    {
      writePackageUnits(context.getNewPackageUnits(), monitor.fork());
    }

    // Note: instead of an Async here, we could do much more fine-grained monitoring below. But this
    // simplistic solution is sufficient to prevent timeout errors.
    final Async async = monitor.forkAsync();
    HibernateThreadContext.getCommitContext().setInDoWrite(true);
    try
    {
      // start with fresh hibernate session to prevent side effects
      final Session session = context instanceof HibernateRawCommitContext ? getHibernateSession() : getNewHibernateSession(false);
      session.setDefaultReadOnly(false);

      // decrement version, hibernate will increment it
      decrementVersions(context);

      // order is 1) insert, 2) update and then delete
      // this order is the most stable! Do not change it without testing

      // System.err.println(getStore().getMappingXml());

      final List<InternalCDORevision> repairContainerIDs = new ArrayList<InternalCDORevision>();
      final List<InternalCDORevision> repairResourceIDs = new ArrayList<InternalCDORevision>();
      for (InternalCDORevision revision : context.getNewObjects())
      {
        revision.setListPreserving();

        // keep track for which cdoRevisions the container id needs to be repaired afterwards
        final CDOID containerID = (CDOID)revision.getContainerID();
        if (containerID instanceof CDOIDTemp && !containerID.isNull())
        {
          repairContainerIDs.add(revision);
        }

        final CDOID resourceID = revision.getResourceID();
        if (resourceID instanceof CDOIDTemp && !resourceID.isNull())
        {
          repairResourceIDs.add(revision);
        }

        final String entityName = getStore().getEntityName(revision.getEClass());
        session.saveOrUpdate(entityName, revision);
      }

      // now apply all the changes
      if (context.getDirtyObjectDeltas() != null)
      {
        for (InternalCDORevisionDelta delta : context.getDirtyObjectDeltas())
        {
          final String entityName = HibernateUtil.getInstance().getEntityName(delta.getID());
          final Serializable idValue = HibernateUtil.getInstance().getIdValue(delta.getID());
          final InternalCDORevision cdoRevision = (InternalCDORevision)session.get(entityName, idValue);
          cdoRevision.setListPreserving();
          delta.applyTo(cdoRevision);
        }
      }

      // preserve old behavior for the hibernate raw commit
      if (context instanceof HibernateRawCommitContext)
      {
        // now check the versions and store the hibernate revision to repair
        // versions later on. The versions can be updated when inserting new objects
        // this will result in a version difference when the object gets merged
        // this repair is done just before the merge
        final Map<CDOID, InternalCDORevision> existingRevisions = CDOIDUtil.createMap();
        for (InternalCDORevision revision : context.getDirtyObjects())
        {
          final String entityName = HibernateUtil.getInstance().getEntityName(revision.getID());
          final Serializable idValue = HibernateUtil.getInstance().getIdValue(revision.getID());
          final InternalCDORevision cdoRevision = (InternalCDORevision)session.get(entityName, idValue);
          if (cdoRevision != null)
          {
            if (cdoRevision.getVersion() != revision.getVersion())
            {
              throw new IllegalStateException("Revision " + cdoRevision + " was already updated by another transaction");
            }
            existingRevisions.put(revision.getID(), cdoRevision);
          }
        }

        for (InternalCDORevision revision : context.getDirtyObjects())
        {
          final String entityName = HibernateUtil.getInstance().getEntityName(revision.getID());
          final InternalCDORevision existingRevision = existingRevisions.get(revision.getID());
          if (existingRevision != null)
          {
            revision.setVersion(existingRevision.getVersion());
          }

          final InternalCDORevision cdoRevision = (InternalCDORevision)session.merge(entityName, revision);
          if (getStore().isAuditing() && cdoRevision.getVersion() == revision.getVersion())
          {
            // do a direct update of the version in the db to get it in sync with
            // hibernate, a special case, hibernate does not send the change back, do it ourselves
            // only needs to be done in case of auditing
            cdoRevision.setVersion(cdoRevision.getVersion() + 1);
          }

          if (TRACER.isEnabled())
          {
            TRACER.trace("Updated Object " + revision.getEClass().getName() + " id: " + revision.getID()); //$NON-NLS-1$ //$NON-NLS-2$
          }
        }
      }

      // and increment the versions stored in the context
      // note that this is needed because above the cdorevision read from the db
      // is updated and its version gets incremented, and not the revision currently
      // in the cache
      incrementVersions(context);

      session.flush();

      // delete all objects
      for (CDOID id : context.getDetachedObjects())
      {
        try
        {
          final CDORevision revision = HibernateUtil.getInstance().getCDORevision(id);

          // maybe deleted in parallell?
          if (revision != null)
          {
            session.delete(revision);
          }
        }
        catch (org.hibernate.ObjectNotFoundException ex)
        {
          // ignore these, an object can be removed through cascade deletes
        }
      }

      session.flush();

      // now do an update of the container without incrementing the version
      repairContainerIDs(repairContainerIDs, session);
      repairResourceIDs(repairResourceIDs, session);

      session.flush();

      // write the blobs
      ExtendedDataInputStream in = context.getLobs();
      if (in != null)
      {
        try
        {
          int count = in.readInt();
          for (int i = 0; i < count; i++)
          {
            byte[] id = in.readByteArray();
            long size = in.readLong();
            if (size > 0)
            {
              writeBlob(id, size, new LimitedInputStream(in, size));
            }
            else
            {
              writeClob(id, -size, new InputStreamReader(new LimitedInputStream(in, -size)));
            }
          }
        }
        catch (IOException ex)
        {
          throw WrappedException.wrap(ex);
        }
      }

      session.flush();

    }
    catch (Exception e)
    {
      OM.LOG.error(e);
      throw WrappedException.wrap(e);
    }
    finally
    {
      HibernateThreadContext.getCommitContext().setInDoWrite(false);
      async.stop();
    }

    context.applyIDMappings(monitor.fork());
    monitor.done();
  }

  // set the version one back, hibernate will update it
  private void decrementVersions(CommitContext context)
  {
    for (InternalCDORevision revision : context.getNewObjects())
    {
      revision.setVersion(revision.getVersion() - 1);
    }
    for (InternalCDORevision revision : context.getDirtyObjects())
    {
      revision.setVersion(revision.getVersion() - 1);
    }
  }

  private void incrementVersions(CommitContext context)
  {
    for (InternalCDORevision revision : context.getNewObjects())
    {
      revision.setVersion(1);
    }
    for (InternalCDORevision revision : context.getDirtyObjects())
    {
      revision.setVersion(revision.getVersion() + 1);
    }
  }

  private void repairContainerIDs(List<InternalCDORevision> repairContainerIDs, Session session)
  {
    for (InternalCDORevision revision : repairContainerIDs)
    {
      final CDORevision container = HibernateUtil.getInstance().getCDORevision((CDOID)revision.getContainerID());
      final String entityName = getStore().getEntityName(revision.getEClass());
      final CDOID id = revision.getID();
      final String hqlUpdate = "update " + entityName + " set " + CDOHibernateConstants.CONTAINER_PROPERTY //$NON-NLS-1$ //$NON-NLS-2$
          + " = :containerInfo where " + getStore().getIdentifierPropertyName(entityName) + " = :id"; //$NON-NLS-1$ //$NON-NLS-2$
      final Query qry = session.createQuery(hqlUpdate);
      qry.setParameter("containerInfo", ContainerInfoConverter.getInstance().convertContainerRelationToString(revision, //$NON-NLS-1$
          container.getID()));
      qry.setParameter("id", HibernateUtil.getInstance().getIdValue(id)); //$NON-NLS-1$
      if (qry.executeUpdate() != 1)
      {
        // OM.LOG.error("Not able to update container columns of " + entityName + " with id " + id); //$NON-NLS-1$
        // //$NON-NLS-2$
        throw new IllegalStateException("Not able to update container columns of " + entityName + " with id " + id); //$NON-NLS-1$ //$NON-NLS-2$
      }
    }
  }

  private void repairResourceIDs(List<InternalCDORevision> repairResourceIDs, Session session)
  {
    for (InternalCDORevision revision : repairResourceIDs)
    {
      final CDORevision resource = HibernateUtil.getInstance().getCDORevision(revision.getResourceID());
      final String entityName = getStore().getEntityName(revision.getEClass());
      final CDOID id = revision.getID();
      final String hqlUpdate = "update " + entityName + " set " + CDOHibernateConstants.RESOURCE_PROPERTY //$NON-NLS-1$ //$NON-NLS-2$
          + " = :resourceInfo where " + getStore().getIdentifierPropertyName(entityName) + " = :id"; //$NON-NLS-1$ //$NON-NLS-2$
      final Query qry = session.createQuery(hqlUpdate);
      qry.setParameter("resourceInfo", resource.getID()); //$NON-NLS-1$
      qry.setParameter("id", HibernateUtil.getInstance().getIdValue(id)); //$NON-NLS-1$
      if (qry.executeUpdate() != 1)
      {
        // OM.LOG.error("Not able to update resource ids of " + entityName + " with id " + id); //$NON-NLS-1$
        // //$NON-NLS-2$
        throw new IllegalStateException("Not able to update resource ids of " + entityName + " with id " + id); //$NON-NLS-1$ //$NON-NLS-2$
      }
    }
  }

  @Override
  protected void detachObjects(CDOID[] detachedObjects, CDOBranch branch, long timeStamp, OMMonitor monitor)
  {
    // handled by the write method
  }

  @Override
  protected void doRollback(CommitContext context)
  {
    setErrorOccured(true);
    endHibernateSession();
    HibernateThreadContext.setCommitContext(null);
  }

  /**
   * Writes package units to the datbaase.
   *
   * @param packageUnits
   *          the package units to write to the database
   * @param monitor
   *          not used by the store
   * @see HibernatePackageHandler
   */
  public void writePackageUnits(InternalCDOPackageUnit[] packageUnits, OMMonitor monitor)
  {
    if (packageUnits != null && packageUnits.length != 0)
    {
      getStore().getPackageHandler().writePackageUnits(packageUnits);
    }
  }

  @SuppressWarnings("deprecation")
  @Override
  protected void writeCommitInfo(CDOBranch branch, long timeStamp, long previousTimeStamp, String userID, String comment, OMMonitor monitor)
  {
    // is done in dowrite
  }

  @Override
  protected void writeRevisions(InternalCDORevision[] revisions, CDOBranch branch, OMMonitor monitor)
  {
    // Doesn't do anything. It is done in commit().
  }

  @Override
  public void addIDMappings(InternalCommitContext commitContext, OMMonitor monitor)
  {
    // Do nothing
  }

  @Override
  public CDOID getNextCDOID(CDORevision revision)
  {
    // Never called
    throw new UnsupportedOperationException();
  }

  @Override
  protected void writeRevisionDeltas(InternalCDORevisionDelta[] revisionDeltas, CDOBranch branch, long created, OMMonitor monitor)
  {
    // TODO: implement HibernateStoreAccessor.writeRevisionDeltas(revisionDeltas, branch, created, monitor)
    throw new UnsupportedOperationException();
  }

  public void queryLobs(List<byte[]> ids)
  {
    for (Iterator<byte[]> it = ids.iterator(); it.hasNext();)
    {
      byte[] id = it.next();
      final HibernateStoreLob lob = getCreateHibernateStoreLob(id);
      if (lob.isNew())
      {
        it.remove();
      }
    }
  }

  public void handleLobs(long fromTime, long toTime, CDOLobHandler handler) throws IOException
  {
    final Session session = getHibernateSession();
    final Query qry = session.createQuery("select c from " + HibernateStoreLob.class.getName() + " as c");

    try
    {
      for (Object o : qry.list())
      {
        final HibernateStoreLob lob = (HibernateStoreLob)o;
        if (lob.getBlob() != null)
        {
          final OutputStream out = handler.handleBlob(HexUtil.hexToBytes(lob.getId()), lob.getSize());
          if (out != null)
          {
            final InputStream in = lob.getBlob().getBinaryStream();
            try
            {
              IOUtil.copyBinary(in, out, lob.getSize());
            }
            finally
            {
              IOUtil.close(out);
            }
          }
        }
        else
        {
          final Clob clob = lob.getClob();
          Reader in = clob.getCharacterStream();
          Writer out = handler.handleClob(HexUtil.hexToBytes(lob.getId()), lob.getSize());
          if (out != null)
          {
            try
            {
              IOUtil.copyCharacter(in, out, lob.getSize());
            }
            finally
            {
              IOUtil.close(out);
            }
          }
        }
      }
    }
    catch (SQLException ex)
    {
      throw new IllegalStateException(ex);
    }
  }

  public void loadLob(byte[] id, OutputStream out) throws IOException
  {
    final HibernateStoreLob lob = getCreateHibernateStoreLob(id);
    // can this ever occur?
    // TODO: how should non-existence be handled? Currently results in a timeout
    // on the client.
    if (lob.isNew())
    {
      throw new IllegalStateException("Lob with id " + HexUtil.bytesToHex(id) + " does not exist");
    }

    final long size = lob.getSize();
    try
    {
      if (lob.getBlob() != null)
      {
        InputStream in = lob.getBlob().getBinaryStream();
        IOUtil.copyBinary(in, out, size);
      }
      else
      {
        Clob clob = lob.getClob();
        Reader in = clob.getCharacterStream();
        IOUtil.copyCharacter(in, new OutputStreamWriter(out), size);
      }
    }
    catch (Exception e)
    {
      throw new IllegalStateException(e);
    }
  }

  @Override
  protected void writeBlob(byte[] id, long size, InputStream inputStream) throws IOException
  {
    final HibernateStoreLob lob = getCreateHibernateStoreLob(id);
    if ((inputStream == null || size == 0) && !lob.isNew())
    {
      getHibernateSession().delete(lob);
    }
    else
    {
      // deprecated usage, non-deprecated api uses a session
      // TODO: research which session to use
      lob.setBlob(getHibernateSession().getLobHelper().createBlob(inputStream, (int)size));
      lob.setSize((int)size);
      lob.setClob(null);
      getHibernateSession().saveOrUpdate(lob);
    }
  }

  @Override
  protected void writeClob(byte[] id, long size, Reader reader) throws IOException
  {
    final HibernateStoreLob lob = getCreateHibernateStoreLob(id);
    if ((reader == null || size == 0) && !lob.isNew())
    {
      getHibernateSession().delete(lob);
    }
    else
    {
      // deprecated usage, non-deprecated api uses a session
      // TODO: research which session to use
      lob.setClob(getHibernateSession().getLobHelper().createClob(reader, (int)size));
      lob.setSize((int)size);
      lob.setBlob(null);
      getHibernateSession().saveOrUpdate(lob);
    }
  }

  private HibernateStoreLob getCreateHibernateStoreLob(byte[] idBytes)
  {
    final String id = HexUtil.bytesToHex(idBytes);
    final Session session = getHibernateSession();
    session.setDefaultReadOnly(false);
    HibernateStoreLob lob = (HibernateStoreLob)session.get(HibernateStoreLob.class, id);
    if (lob == null)
    {
      lob = new HibernateStoreLob();
      lob.setId(id);
    }

    return lob;
  }

  public void rawExport(CDODataOutput out, int fromBranchID, int toBranchID, long fromCommitTime, long toCommitTime) throws IOException
  {
    // we won't export any store specific stuff...
    // throw new UnsupportedOperationException();
  }

  public void rawImport(CDODataInput in, int fromBranchID, int toBranchID, long fromCommitTime, long toCommitTime, OMMonitor monitor) throws IOException
  {
    throw new UnsupportedOperationException();
  }

  public void rawStore(InternalCDOPackageUnit[] packageUnits, OMMonitor monitor)
  {
    if (packageUnits != null && packageUnits.length != 0)
    {
      getStore().getPackageHandler().writePackageUnits(packageUnits);
    }
    // forces a new hibernate session
    commit(monitor);
  }

  public void rawStore(InternalCDORevision revision, OMMonitor monitor)
  {
    final String entityName = HibernateUtil.getInstance().getEntityName(revision.getID());
    final Serializable idValue = HibernateUtil.getInstance().getIdValue(revision.getID());
    final CDORevision existingRevision = (CDORevision)getHibernateSession().get(entityName, idValue);
    if (existingRevision == null)
    {
      rawCommitContext.addNewObject(revision);
    }
    else
    {
      revision.setVersion(1 + existingRevision.getVersion());
      rawCommitContext.addDirtyObject(revision);
    }
  }

  public void rawStore(byte[] id, long size, InputStream inputStream) throws IOException
  {
    writeBlob(id, size, inputStream);
  }

  public void rawStore(byte[] id, long size, Reader reader) throws IOException
  {
    writeClob(id, size, reader);
  }

  public void rawStore(CDOBranch branch, long timeStamp, long previousTimeStamp, String userID, String comment, OMMonitor monitor)
  {
    // TODO: support export and import and auditing
  }

  public void rawCommit(double commitWork, OMMonitor monitor)
  {
    doWrite(rawCommitContext, monitor);
    commit(monitor);
  }

  public void rawDelete(CDOID id, int version, CDOBranch branch, EClass eClass, OMMonitor monitor)
  {
    throw new UnsupportedOperationException();
  }

  @Override
  protected void doDeactivate() throws Exception
  {
    // TODO This method is called when this accessor is not needed anymore
    if (TRACER.isEnabled())
    {
      TRACER.trace("Committing/rollback and closing hibernate session"); //$NON-NLS-1$
    }

    try
    {
      endHibernateSession();
    }
    finally
    {
      clearThreadState();
    }
  }

  @Override
  public void release()
  {
    super.release();
    getStore().ensureCorrectPackageRegistry();
  }

  @Override
  protected void doPassivate() throws Exception
  {
    clearThreadState();
  }

  private void clearThreadState()
  {
    PersistableListHolder.getInstance().clearListMapping();
    HibernateThreadContext.setCommitContext(null);
    PackageRegistryProvider.getInstance().setThreadPackageRegistry(null);
  }

  @Override
  protected void doActivate() throws Exception
  {
    PackageRegistryProvider.getInstance().setThreadPackageRegistry(getStore().getRepository().getPackageRegistry());
  }

  @Override
  protected void doUnpassivate() throws Exception
  {
  }

  public int getCurrentListChunk()
  {
    return currentListChunk;
  }
}
