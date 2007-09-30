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
package org.eclipse.emf.cdo.internal.protocol.revision;

import org.eclipse.emf.cdo.internal.protocol.bundle.OM;
import org.eclipse.emf.cdo.protocol.CDOID;
import org.eclipse.emf.cdo.protocol.model.CDOClass;
import org.eclipse.emf.cdo.protocol.revision.CDORevisionResolver;

import org.eclipse.net4j.internal.util.lifecycle.Lifecycle;
import org.eclipse.net4j.internal.util.om.trace.ContextTracer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Eike Stepper
 */
public abstract class CDORevisionResolverImpl extends Lifecycle implements CDORevisionResolver
{
  private static final ContextTracer TRACER = new ContextTracer(OM.DEBUG_REVISION, CDORevisionResolverImpl.class);

  private ConcurrentMap<CDOID, RevisionHolder> revisions = new ConcurrentHashMap<CDOID, RevisionHolder>();

  public CDORevisionResolverImpl()
  {
  }

  public CDOClass getObjectType(CDOID id)
  {
    RevisionHolder holder = revisions.get(id);
    if (holder == null)
    {
      return null;
    }

    CDORevisionImpl revision = holder.getRevision(true);
    return revision.getCDOClass();
  }

  public boolean containsRevision(CDOID id)
  {
    return revisions.containsKey(id);
  }

  public CDORevisionImpl getRevision(CDOID id, int referenceChunk)
  {
    return getRevision(id, referenceChunk, true);
  }

  protected CDORevisionImpl getRevision(CDOID id, int referenceChunk, boolean loadOnDemand)
  {
    RevisionHolder holder = revisions.get(id);
    CDORevisionImpl revision = holder == null ? null : holder.getRevision(true);
    if (revision == null || !revision.isCurrent())
    {
      if (loadOnDemand)
      {
        revision = loadRevision(id, referenceChunk);
        addRevisionFirst(revision);
      }
      else
      {
        revision = null;
      }
    }
    else
    {
      CDORevisionImpl oldRevision = revision;
      revision = verifyRevision(oldRevision, referenceChunk);
      if (revision != oldRevision)
      {
        // TODO Discard or adjust old revision
        addRevisionFirst(revision);
      }
    }

    return revision;
  }

  protected abstract CDORevisionImpl loadRevision(CDOID id, int referenceChunk);

  public boolean containsRevisionByTime(CDOID id, long timeStamp)
  {
    return getRevisionByTime(id, 0, timeStamp, false) != null;
  }

  public CDORevisionImpl getRevisionByTime(CDOID id, int referenceChunk, long timeStamp)
  {
    return getRevisionByTime(id, referenceChunk, timeStamp, true);
  }

  protected synchronized CDORevisionImpl getRevisionByTime(CDOID id, int referenceChunk, long timeStamp,
      boolean loadOnDemand)
  {
    RevisionHolder lastHolder = null;
    RevisionHolder holder = revisions.get(id);
    while (holder != null)
    {
      int indicator = holder.compareTo(timeStamp);
      if (indicator == 1)
      {
        // timeStamp is after holder timeSpan
        lastHolder = holder;
        holder = holder.getNext();
      }
      else if (indicator == 0)
      {
        // timeStamp is within holder timeSpan
        CDORevisionImpl oldRevision = holder.getRevision(true);
        CDORevisionImpl revision = verifyRevision(oldRevision, referenceChunk);
        if (revision != oldRevision)
        {
          addRevisionBetween(revision, lastHolder, holder);
        }

        return revision;
      }
      else
      {
        // timeStamp is before holder timeSpan
        break;
      }
    }

    if (loadOnDemand)
    {
      CDORevisionImpl revision = loadRevisionByTime(id, referenceChunk, timeStamp);
      if (revision != null)
      {
        addRevisionBetween(revision, lastHolder, holder);
        return revision;
      }
    }

    return null;
  }

  protected abstract CDORevisionImpl loadRevisionByTime(CDOID id, int referenceChunk, long timeStamp);

  public synchronized CDORevisionImpl getRevisionByVersion(CDOID id, int referenceChunk, int version)
  {
    RevisionHolder lastHolder = null;
    RevisionHolder holder = revisions.get(id);
    while (holder != null)
    {
      int holderVersion = holder.getVersion();
      if (holderVersion > version)
      {
        lastHolder = holder;
        holder = holder.getNext();
      }
      else if (holderVersion == version)
      {
        return holder.getRevision(true);
      }
      else
      {
        break;
      }
    }

    CDORevisionImpl revision = loadRevisionByVersion(id, referenceChunk, version);
    if (revision != null)
    {
      addRevisionBetween(revision, lastHolder, holder);
      return revision;
    }

    return null;
  }

  protected abstract CDORevisionImpl loadRevisionByVersion(CDOID id, int referenceChunk, int version);

  public List<CDORevisionImpl> getRevisions(Collection<CDOID> ids, int referenceChunk)
  {
    List<CDOID> missingIDs = new ArrayList<CDOID>(0);
    List<CDORevisionImpl> revisions = new ArrayList<CDORevisionImpl>(ids.size());
    for (CDOID id : ids)
    {
      CDORevisionImpl revision = getRevision(id, referenceChunk, false);
      revisions.add(revision);
      if (revision == null)
      {
        missingIDs.add(id);
      }
    }

    if (!missingIDs.isEmpty())
    {
      List<CDORevisionImpl> missingRevisions = loadRevisions(missingIDs, referenceChunk);
      handleMissingRevisions(revisions, missingRevisions);
    }

    return revisions;
  }

  protected abstract List<CDORevisionImpl> loadRevisions(Collection<CDOID> ids, int referenceChunk);

  public List<CDORevisionImpl> getRevisionsByTime(Collection<CDOID> ids, int referenceChunk, long timeStamp)
  {
    List<CDOID> missingIDs = new ArrayList<CDOID>(0);
    List<CDORevisionImpl> revisions = new ArrayList<CDORevisionImpl>(ids.size());
    for (CDOID id : ids)
    {
      CDORevisionImpl revision = getRevisionByTime(id, referenceChunk, timeStamp, false);
      revisions.add(revision);
      if (revision == null)
      {
        missingIDs.add(id);
      }
    }

    if (!missingIDs.isEmpty())
    {
      List<CDORevisionImpl> missingRevisions = loadRevisions(missingIDs, referenceChunk);
      handleMissingRevisions(revisions, missingRevisions);
    }

    return revisions;
  }

  protected void handleMissingRevisions(List<CDORevisionImpl> revisions, List<CDORevisionImpl> missingRevisions)
  {
    Iterator<CDORevisionImpl> it = missingRevisions.iterator();
    for (int i = 0; i < revisions.size(); i++)
    {
      CDORevisionImpl revision = revisions.get(i);
      if (revision == null)
      {
        CDORevisionImpl missingRevision = it.next();
        revisions.set(i, missingRevision);
        addRevision(missingRevision);
      }
    }
  }

  protected abstract List<CDORevisionImpl> loadRevisionsByTime(Collection<CDOID> ids, int referenceChunk, long timeStamp);

  public void addRevision(CDORevisionImpl revision)
  {
    if (TRACER.isEnabled())
    {
      TRACER.format("Adding revision: {0}, created={1,date} {1,time}, revised={2,date} {2,time}, current={3}",
          revision, revision.getCreated(), revision.getRevised(), revision.isCurrent());
    }

    int version = revision.getVersion();
    RevisionHolder lastHolder = null;
    RevisionHolder holder = revisions.get(revision.getID());
    while (holder != null)
    {
      int holderVersion = holder.getVersion();
      if (holderVersion > version)
      {
        lastHolder = holder;
        holder = holder.getNext();
      }
      else if (holderVersion == version)
      {
        throw new IllegalStateException("Duplicate version: " + revision);
      }
      else
      {
        break;
      }
    }

    addRevisionBetween(revision, lastHolder, holder);
  }

  protected RevisionHolder createRevisionHolder(CDORevisionImpl revision)
  {
    return new RevisionHolder(revision);
  }

  protected void addRevisionFirst(CDORevisionImpl revision)
  {
    RevisionHolder newHolder = createRevisionHolder(revision);
    RevisionHolder oldHolder = revisions.put(revision.getID(), newHolder);
    if (oldHolder != null)
    {
      oldHolder.setPrev(newHolder);
      newHolder.setNext(oldHolder);
    }
  }

  protected void addRevisionBetween(CDORevisionImpl revision, RevisionHolder prevHolder, RevisionHolder nextHolder)
  {
    RevisionHolder holder = createRevisionHolder(revision);
    if (prevHolder != null)
    {
      if (nextHolder == null)
      {
        nextHolder = prevHolder.getNext();
      }

      holder.setPrev(prevHolder);
      holder.setNext(nextHolder);
      prevHolder.setNext(holder);
      if (nextHolder != null)
      {
        nextHolder.setPrev(holder);
      }
    }
    else
    {
      holder.setNext(nextHolder);
      if (nextHolder != null)
      {
        nextHolder.setPrev(holder);
      }

      revisions.put(revision.getID(), holder);
    }
  }

  public void removeRevision(CDORevisionImpl revision)
  {
    if (TRACER.isEnabled())
    {
      TRACER.format("Removing revision: {0}, created={1,date} {1,time}, revised={2,date} {2,time}, current={3}",
          revision, revision.getCreated(), revision.getRevised(), revision.isCurrent());
    }

    // TODO Implement method CDORevisionResolverImpl.removeRevision()
    throw new UnsupportedOperationException("Not yet implemented");
  }

  protected CDORevisionImpl verifyRevision(CDORevisionImpl revision, int referenceChunk)
  {
    return revision;
  }
}
