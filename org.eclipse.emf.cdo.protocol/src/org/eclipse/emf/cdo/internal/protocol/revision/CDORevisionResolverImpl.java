/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Simon McDuff - https://bugs.eclipse.org/bugs/show_bug.cgi?id=201266
 **************************************************************************/
package org.eclipse.emf.cdo.internal.protocol.revision;

import org.eclipse.emf.cdo.internal.protocol.bundle.OM;
import org.eclipse.emf.cdo.protocol.CDOID;
import org.eclipse.emf.cdo.protocol.model.CDOClass;
import org.eclipse.emf.cdo.protocol.revision.CDODuplicateRevisionException;
import org.eclipse.emf.cdo.protocol.revision.CDORevisionResolver;

import org.eclipse.net4j.internal.util.lifecycle.Lifecycle;
import org.eclipse.net4j.internal.util.om.trace.ContextTracer;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public abstract class CDORevisionResolverImpl extends Lifecycle implements CDORevisionResolver
{
  private static final ContextTracer TRACER = new ContextTracer(OM.DEBUG_REVISION, CDORevisionResolverImpl.class);

  private Map<CDOID, RevisionHolder> revisions = new HashMap<CDOID, RevisionHolder>();

  private int currentLRUCapacity;

  private int revisedLRUCapacity;

  private LRU currentLRU;

  private LRU revisedLRU;

  public CDORevisionResolverImpl()
  {
  }

  public int getCurrentLRUCapacity()
  {
    return currentLRUCapacity;
  }

  public void setCurrentLRUCapacity(int capacity)
  {
    currentLRUCapacity = capacity;
    if (currentLRU != null)
    {
      currentLRU.capacity(capacity);
    }
  }

  public int getRevisedLRUCapacity()
  {
    return revisedLRUCapacity;
  }

  public void setRevisedLRUCapacity(int capacity)
  {
    revisedLRUCapacity = capacity;
    if (revisedLRU != null)
    {
      revisedLRU.capacity(capacity);
    }
  }

  public CDOClass getObjectType(CDOID id)
  {
    RevisionHolder holder = revisions.get(id);
    if (holder == null)
    {
      return null;
    }

    CDORevisionImpl revision = (CDORevisionImpl)holder.getRevision(true);
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
    CDORevisionImpl revision = holder == null ? null : (CDORevisionImpl)holder.getRevision(true);
    if (revision == null || !revision.isCurrent())
    {
      if (loadOnDemand)
      {
        revision = loadRevision(id, referenceChunk);
        addRevision(revision);
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
        addRevision(revision);
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
    RevisionHolder holder = revisions.get(id);
    while (holder != null)
    {
      int indicator = holder.compareTo(timeStamp);
      if (indicator == 1)
      {
        // timeStamp is after holder timeSpan
        holder = holder.getNext();
      }
      else if (indicator == 0)
      {
        // timeStamp is within holder timeSpan
        CDORevisionImpl oldRevision = (CDORevisionImpl)holder.getRevision(true);
        CDORevisionImpl revision = verifyRevision(oldRevision, referenceChunk);
        if (revision != oldRevision)
        {
          addRevision(revision);
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
        addRevision(revision);
        return revision;
      }
    }

    return null;
  }

  protected abstract CDORevisionImpl loadRevisionByTime(CDOID id, int referenceChunk, long timeStamp);

  public boolean containsRevisionByVersion(CDOID id, int version)
  {
    return getRevisionByVersion(id, 0, version, false) != null;
  }

  public synchronized CDORevisionImpl getRevisionByVersion(CDOID id, int referenceChunk, int version)
  {
    return getRevisionByVersion(id, referenceChunk, version, true);
  }

  public synchronized CDORevisionImpl getRevisionByVersion(CDOID id, int referenceChunk, int version,
      boolean loadOnDemand)
  {
    RevisionHolder holder = revisions.get(id);
    while (holder != null)
    {
      int holderVersion = holder.getVersion();
      if (holderVersion > version)
      {
        holder = holder.getNext();
      }
      else if (holderVersion == version)
      {
        return (CDORevisionImpl)holder.getRevision(true);
      }
      else
      {
        break;
      }
    }

    if (loadOnDemand)
    {
      CDORevisionImpl revision = loadRevisionByVersion(id, referenceChunk, version);
      if (revision != null)
      {
        addRevision(revision);
        return revision;
      }
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

  public void addRevision(CDORevisionImpl revision) throws CDODuplicateRevisionException
  {
    if (TRACER.isEnabled())
    {
      TRACER.format("Adding revision: {0}, created={1,date} {1,time}, revised={2,date} {2,time}, current={3}",
          revision, revision.getCreated(), revision.getRevised(), revision.isCurrent());
    }

    RevisionHolder newHolder = createRevisionHolder(revision);

    LRU list = revision.isCurrent() ? currentLRU : revisedLRU;
    list.add((DLRevisionHolder)newHolder);

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
        throw new CDODuplicateRevisionException(revision);
      }
      else
      {
        break;
      }
    }

    adjustHolder(revision, newHolder, lastHolder, holder);
  }

  private void adjustHolder(CDORevisionImpl revision, RevisionHolder holder, RevisionHolder prevHolder,
      RevisionHolder nextHolder)
  {
    if (prevHolder != null)
    {
      if (nextHolder == null)
      {
        nextHolder = prevHolder.getNext();
      }

      holder.setPrev(prevHolder);
      holder.setNext(nextHolder);
      prevHolder.setNext(holder);
    }
    else
    {
      holder.setNext(nextHolder);
      revisions.put(revision.getID(), holder);
    }

    reviseHolder(holder, nextHolder);
  }

  private void reviseHolder(RevisionHolder holder, RevisionHolder nextHolder)
  {
    if (nextHolder != null)
    {
      nextHolder.setPrev(holder);
      if (holder.isCurrent() && nextHolder.isCurrent())
      {
        currentLRU.remove((DLRevisionHolder)nextHolder);
        revisedLRU.add((DLRevisionHolder)nextHolder);

        CDORevisionImpl oldRevision = (CDORevisionImpl)nextHolder.getRevision(false);
        if (oldRevision != null)
        {
          oldRevision.setRevised(holder.getCreated() - 1);
        }
      }
    }
  }

  protected synchronized void removeRevision(CDOID id, int version)
  {
    RevisionHolder holder = revisions.get(id);
    while (holder != null)
    {
      int holderVersion = holder.getVersion();
      if (holderVersion > version)
      {
        holder = holder.getNext();
      }
      else if (holderVersion == version)
      {
        removeHolder(holder);
        break;
      }
      else
      {
        break;
      }
    }
  }

  private synchronized void removeHolder(RevisionHolder holder)
  {
    CDOID id = holder.getID();
    RevisionHolder prev = holder.getPrev();
    RevisionHolder next = holder.getNext();
    if (next != null)
    {
      next.setPrev(prev);
    }

    if (prev != null)
    {
      prev.setNext(next);
    }
    else
    {
      if (next != null)
      {
        revisions.put(id, next);
      }
      else
      {
        revisions.remove(id);
      }
    }

    holder.setPrev(null);
    holder.setNext(null);
  }

  protected CDORevisionImpl verifyRevision(CDORevisionImpl revision, int referenceChunk)
  {
    return revision;
  }

  protected RevisionHolder createRevisionHolder(CDORevisionImpl revision)
  {
    LRURevisionList list = revision.isCurrent() ? currentLRU : revisedLRU;
    return new LRURevisionHolder(list, revision);
  }

  @Override
  protected void doActivate() throws Exception
  {
    super.doActivate();
    currentLRU = new LRU(currentLRUCapacity);
    revisedLRU = new LRU(revisedLRUCapacity);
  }

  @Override
  protected void doDeactivate() throws Exception
  {
    currentLRU = null;
    revisedLRU = null;
    super.doDeactivate();
  }

  /**
   * @author Eike Stepper
   */
  private final class LRU extends LRURevisionList
  {
    public LRU(int capacity)
    {
      super(capacity);
    }

    @Override
    public String toString()
    {
      return MessageFormat.format("LRU[size={0}, capacity={1}]", size(), capacity());
    }

    @Override
    protected void evict(LRURevisionHolder holder)
    {
      if (TRACER.isEnabled())
      {
        TRACER.format("Evicting revision {0}v{1}", holder.getID(), holder.getVersion());
      }

      super.evict(holder);
      removeHolder(holder);
    }
  }
}
