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
    CDORevisionImpl revision = timeLine.getFirst();
    return revision.getCDOClass();
  }

  public CDORevisionImpl getRevision(CDOID id, int referenceChunk)
  {
    TimeLine timeLine = getTimeLine(id);
    return timeLine.getRevision(referenceChunk);
  }

  public CDORevisionImpl getRevision(CDOID id, int referenceChunk, long timeStamp)
  {
    TimeLine timeLine = getTimeLine(id);
    return timeLine.getRevision(referenceChunk, timeStamp);
  }

  public void addRevision(CDORevisionImpl revision)
  {
    if (!revision.isCurrent())
    {
      throw new IllegalArgumentException("!revision.isCurrent()");
    }

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

  protected CDORevisionImpl verifyRevision(CDORevisionImpl revision)
  {
    return revision;
  }

  protected abstract CDORevisionImpl loadRevision(CDOID id, int referenceChunk);

  protected abstract CDORevisionImpl loadRevision(CDOID id, int referenceChunk, long timeStamp);

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

    public synchronized CDORevisionImpl getRevision(int referenceChunk)
    {
      CDORevisionImpl revision = isEmpty() ? null : super.getFirst();
      if (revision == null || !revision.isCurrent())
      {
        revision = loadRevision(id, referenceChunk);
        super.addFirst(revision);
      }
      else
      {
        CDORevisionImpl oldRevision = revision;
        revision = verifyRevision(oldRevision);
        if (revision != oldRevision)
        {
          super.addFirst(revision);
        }
      }

      return revision;
    }

    public synchronized CDORevisionImpl getRevision(int referenceChunk, long timeStamp)
    {
      // TODO Binary search? (LinkedList -> ArrayList)
      ListIterator<CDORevisionImpl> it = super.listIterator();
      while (it.hasNext())
      {
        CDORevisionImpl revision = it.next();
        long revised = revision.getRevised();
        if (revised != 0 && revised < timeStamp)
        {
          break;
        }

        long created = revision.getCreated();
        // TODO Replace by revision.isValid()
        if ((revised == 0 || revised >= timeStamp) && timeStamp >= created)
        {
          return revision;
        }
      }

      CDORevisionImpl revision = loadRevision(id, referenceChunk, timeStamp);
      it.add(revision);
      return revision;
    }

    @Override
    public synchronized boolean add(CDORevisionImpl revision)
    {
      CDORevisionImpl previousRevision = isEmpty() ? null : super.getFirst();
      if (previousRevision != null && previousRevision.isCurrent())
      {
        previousRevision.setRevised(revision.getCreated() - 1);
      }

      super.addFirst(revision);
      return true;
    }

    @Override
    public synchronized boolean remove(Object o)
    {
      return super.remove(o);
    }

    @Override
    @Deprecated
    public void addFirst(CDORevisionImpl o)
    {
      throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public CDORevisionImpl getFirst()
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
