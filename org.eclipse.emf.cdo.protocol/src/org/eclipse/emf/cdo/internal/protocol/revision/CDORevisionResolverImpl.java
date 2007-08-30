/***************************************************************************
 * Copyright (c) 2004-2007 Eike Stepper, Germany.
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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public abstract class CDORevisionResolverImpl extends Lifecycle implements CDORevisionResolver
{
  private static final ContextTracer TRACER = new ContextTracer(OM.DEBUG_REVISION, CDORevisionResolverImpl.class);

  private Map<CDOID, TimeLine> revisions = new HashMap();

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

  @Deprecated
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
      CDORevisionImpl revision = isEmpty() ? null : getFirst();
      if (revision == null || !revision.isCurrent())
      {
        revision = loadRevision(id, referenceChunk);
        addFirst(revision);
      }
      else
      {
        CDORevisionImpl oldRevision = revision;
        revision = verifyRevision(oldRevision);
        if (revision != oldRevision)
        {
          addFirst(revision);
        }
      }

      return revision;
    }

    public synchronized CDORevisionImpl getRevision(int referenceChunk, long timeStamp)
    {
      // TODO Binary search? (LinkedList -> ArrayList)
      ListIterator<CDORevisionImpl> it = listIterator();
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
      CDORevisionImpl previousRevision = isEmpty() ? null : getFirst();
      if (previousRevision != null && previousRevision.isCurrent())
      {
        previousRevision.setRevised(revision.getCreated() - 1);
      }

      addFirst(revision);
      return true;
    }

    @Override
    public synchronized boolean remove(Object o)
    {
      return super.remove(o);
    }

  }
}
