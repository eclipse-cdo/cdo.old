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
import org.eclipse.emf.cdo.protocol.revision.CDORevision;
import org.eclipse.emf.cdo.protocol.revision.CDORevisionResolver;

import org.eclipse.net4j.internal.util.lifecycle.Lifecycle;
import org.eclipse.net4j.internal.util.om.trace.ContextTracer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public abstract class CDORevisionResolverImpl extends Lifecycle implements CDORevisionResolver
{
  private static final ContextTracer TRACER = new ContextTracer(OM.DEBUG_REVISION, CDORevisionResolverImpl.class);

  private Map<CDOID, TimeLine> revisions = new HashMap<CDOID, TimeLine>();

  public CDORevisionResolverImpl()
  {
  }

  public CDOClass getObjectType(CDOID id)
  {
    // Synchronization not needed
    TimeLine timeLine = revisions.get(id);
    if (timeLine == null || timeLine.isEmpty())
    {
      return null;
    }

    // Synchronization not needed
    CDORevisionImpl revision = timeLine.getFirstUnsynchronized();
    return revision.getCDOClass();
  }

  public boolean containsRevision(CDOID id)
  {
    TimeLine timeLine = revisions.get(id);
    if (timeLine == null)
    {
      return false;
    }

    return timeLine.getRevision(0, false) != null;
  }

  public boolean containsRevisionByTime(CDOID id, long timeStamp)
  {
    TimeLine timeLine = revisions.get(id);
    if (timeLine == null)
    {
      return false;
    }

    return timeLine.getRevisionByTime(0, timeStamp, false) != null;
  }

  public CDORevisionImpl getRevision(CDOID id, int referenceChunk)
  {
    TimeLine timeLine = getTimeLine(id);
    return timeLine.getRevision(referenceChunk, true);
  }

  public CDORevisionImpl getRevisionByTime(CDOID id, int referenceChunk, long timeStamp)
  {
    TimeLine timeLine = getTimeLine(id);
    return timeLine.getRevisionByTime(referenceChunk, timeStamp, true);
  }

  public CDORevisionImpl getRevisionByVersion(CDOID id, int referenceChunk, int version)
  {
    TimeLine timeLine = getTimeLine(id);
    return timeLine.getRevisionByVersion(referenceChunk, version);
  }

  public List<CDORevisionImpl> getRevisions(Collection<CDOID> ids, int referenceChunk)
  {
    List<CDOID> missingIDs = new ArrayList<CDOID>(0);
    List<TimeLine> missingTimeLines = new ArrayList<TimeLine>(0);
    List<CDORevisionImpl> revisions = new ArrayList<CDORevisionImpl>(ids.size());
    for (CDOID id : ids)
    {
      TimeLine timeLine = getTimeLine(id);
      CDORevisionImpl revision = timeLine.getRevision(referenceChunk, false);
      revisions.add(revision);
      if (revision == null)
      {
        missingIDs.add(id);
        missingTimeLines.add(timeLine);
      }
    }

    if (!missingIDs.isEmpty())
    {
      List<CDORevisionImpl> missingRevisions = loadRevisions(missingIDs, referenceChunk);
      Iterator<CDORevisionImpl> missingRevisionsIt = missingRevisions.iterator();
      Iterator<TimeLine> missingTimeLinesIt = missingTimeLines.iterator();
      for (int i = 0; i < revisions.size(); i++)
      {
        CDORevisionImpl revision = revisions.get(i);
        if (revision == null)
        {
          CDORevisionImpl missingRevision = missingRevisionsIt.next();
          revisions.set(i, missingRevision);

          TimeLine missingTimeLine = missingTimeLinesIt.next();
          missingTimeLine.add(missingRevision);
        }
      }
    }

    return revisions;
  }

  public List<CDORevisionImpl> getRevisionsByTime(Collection<CDOID> ids, int referenceChunk, long timeStamp)
  {
    List<CDOID> missingIDs = new ArrayList<CDOID>(0);
    List<TimeLine> missingTimeLines = new ArrayList<TimeLine>(0);
    List<CDORevisionImpl> revisions = new ArrayList<CDORevisionImpl>(ids.size());
    for (CDOID id : ids)
    {
      TimeLine timeLine = getTimeLine(id);
      CDORevisionImpl revision = timeLine.getRevisionByTime(referenceChunk, timeStamp, false);
      revisions.add(revision);
      if (revision == null)
      {
        missingIDs.add(id);
        missingTimeLines.add(timeLine);
      }
    }

    if (!missingIDs.isEmpty())
    {
      List<CDORevisionImpl> missingRevisions = loadRevisionsByTime(missingIDs, referenceChunk, timeStamp);
      Iterator<CDORevisionImpl> missingRevisionsIt = missingRevisions.iterator();
      Iterator<TimeLine> missingTimeLinesIt = missingTimeLines.iterator();
      for (int i = 0; i < revisions.size(); i++)
      {
        CDORevisionImpl revision = revisions.get(i);
        if (revision == null)
        {
          CDORevisionImpl missingRevision = missingRevisionsIt.next();
          revisions.set(i, missingRevision);

          TimeLine missingTimeLine = missingTimeLinesIt.next();
          missingTimeLine.add(missingRevision);
        }
      }
    }

    return revisions;
  }

  public void addRevision(CDORevisionImpl revision)
  {
    if (TRACER.isEnabled())
    {
      TRACER.format("Adding revision: {0}, created={1,date} {1,time}, revised={2,date} {2,time}, current={3}",
          revision, revision.getCreated(), revision.getRevised(), revision.isCurrent());
    }

    TimeLine timeLine = getTimeLine(revision.getID());
    timeLine.add(revision);
  }

  public void removeRevision(CDORevisionImpl revision)
  {
    if (!revision.isCurrent())
    {
      throw new IllegalArgumentException("!revision.isCurrent()");
    }

    if (TRACER.isEnabled())
    {
      TRACER.format("Removing revision: {0}, created={1,date} {1,time}, revised={2,date} {2,time}, current={3}",
          revision, revision.getCreated(), revision.getRevised(), revision.isCurrent());
    }

    TimeLine timeLine = getTimeLine(revision.getID());
    timeLine.remove(revision);
  }

  private TimeLine getTimeLine(CDOID id)
  {
    if (id.isNull())
    {
      throw new IllegalArgumentException("id.isNull()");
    }

    if (id.isMeta())
    {
      throw new IllegalArgumentException("id.isMeta()");
    }

    if (id.isTemporary())
    {
      throw new IllegalArgumentException("id.isTemporary()");
    }

    synchronized (revisions)
    {
      TimeLine timeLine = revisions.get(id);
      if (timeLine == null)
      {
        timeLine = new TimeLine(id);
        revisions.put(id, timeLine);
      }

      return timeLine;
    }
  }

  protected CDORevisionImpl verifyRevision(CDORevisionImpl revision, int referenceChunk)
  {
    return revision;
  }

  protected abstract CDORevisionImpl loadRevision(CDOID id, int referenceChunk);

  protected abstract CDORevisionImpl loadRevisionByTime(CDOID id, int referenceChunk, long timeStamp);

  protected abstract CDORevisionImpl loadRevisionByVersion(CDOID id, int referenceChunk, int version);

  protected abstract List<CDORevisionImpl> loadRevisions(Collection<CDOID> ids, int referenceChunk);

  protected abstract List<CDORevisionImpl> loadRevisionsByTime(Collection<CDOID> ids, int referenceChunk, long timeStamp);

  /**
   * @author Eike Stepper
   */
  private final class TimeLine extends LinkedList<CDORevisionImpl>
  {
    private static final long serialVersionUID = 1L;

    private CDOID id;

    public TimeLine(CDOID id)
    {
      if (id == null)
      {
        throw new IllegalArgumentException("id == null");
      }

      this.id = id;
    }

    public CDOID getID()
    {
      return id;
    }

    public synchronized CDORevisionImpl getRevision(int referenceChunk, boolean loadOnDemand)
    {
      CDORevisionImpl revision = super.isEmpty() ? null : super.getFirst();
      if (revision == null || !revision.isCurrent())
      {
        if (loadOnDemand)
        {
          revision = loadRevision(id, referenceChunk);
          super.addFirst(revision);
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
          super.addFirst(revision);
        }
      }

      return revision;
    }

    public synchronized CDORevisionImpl getRevisionByTime(int referenceChunk, long timeStamp, boolean loadOnDemand)
    {
      ListIterator<CDORevisionImpl> it = super.listIterator(0);
      while (it.hasNext())
      {
        CDORevisionImpl revision = it.next();
        long revised = revision.getRevised();
        if (revised != CDORevision.UNSPECIFIED_DATE && revised < timeStamp)
        {
          break;
        }

        if (revision.isValid(timeStamp))
        {
          return revision;
        }
      }

      if (loadOnDemand)
      {
        CDORevisionImpl oldRevision = loadRevisionByTime(id, referenceChunk, timeStamp);
        CDORevisionImpl revision = verifyRevision(oldRevision, referenceChunk);
        if (revision != oldRevision)
        {
          it.add(revision);
        }

        return revision;
      }

      return null;
    }

    public synchronized CDORevisionImpl getRevisionByVersion(int referenceChunk, int version)
    {
      ListIterator<CDORevisionImpl> it = super.listIterator(0);
      while (it.hasNext())
      {
        CDORevisionImpl r = it.next();
        int v = r.getVersion();
        if (v == version)
        {
          return r;
        }

        if (v < version)
        {
          break;
        }
      }

      CDORevisionImpl revision = loadRevisionByTime(id, referenceChunk, version);
      it.add(revision);
      return revision;
    }

    @Override
    public synchronized boolean add(CDORevisionImpl revision)
    {
      int version = revision.getVersion();
      ListIterator<CDORevisionImpl> it = super.listIterator(0);
      while (it.hasNext())
      {
        CDORevisionImpl r = it.next();
        int v = r.getVersion();
        if (v == version)
        {
          return false;
        }

        if (v < version)
        {
          it.previous();
          break;
        }
      }

      it.add(revision);
      return true;
    }

    @Override
    public synchronized boolean remove(Object o)
    {
      return super.remove(o);
    }

    public CDORevisionImpl getFirstUnsynchronized()
    {
      return super.getFirst();
    }

    @Override
    @Deprecated
    public CDORevisionImpl getFirst()
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public void addFirst(CDORevisionImpl o)
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public void add(int index, CDORevisionImpl element)
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public boolean addAll(Collection<? extends CDORevisionImpl> c)
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public boolean addAll(int index, Collection<? extends CDORevisionImpl> c)
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public void addLast(CDORevisionImpl o)
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public void clear()
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public Object clone()
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public boolean contains(Object o)
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public boolean containsAll(Collection<?> c)
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public CDORevisionImpl element()
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public boolean equals(Object o)
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public CDORevisionImpl get(int index)
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public CDORevisionImpl getLast()
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public int hashCode()
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public int indexOf(Object o)
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public Iterator<CDORevisionImpl> iterator()
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public int lastIndexOf(Object o)
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public ListIterator<CDORevisionImpl> listIterator()
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public ListIterator<CDORevisionImpl> listIterator(int index)
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public boolean offer(CDORevisionImpl o)
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public CDORevisionImpl peek()
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public CDORevisionImpl poll()
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public CDORevisionImpl remove()
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public CDORevisionImpl remove(int index)
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public boolean removeAll(Collection<?> c)
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public CDORevisionImpl removeFirst()
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public CDORevisionImpl removeLast()
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public boolean retainAll(Collection<?> c)
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public CDORevisionImpl set(int index, CDORevisionImpl element)
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public List<CDORevisionImpl> subList(int fromIndex, int toIndex)
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public Object[] toArray()
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public <T> T[] toArray(T[] a)
    {
      throw new UnsupportedOperationException();
    }
  }
}
