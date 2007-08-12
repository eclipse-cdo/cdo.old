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
import org.eclipse.emf.cdo.protocol.revision.CDORevisionResolver;

import org.eclipse.net4j.internal.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.ReflectUtil;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public abstract class CDORevisionResolverImpl implements CDORevisionResolver
{
  private static final ContextTracer TRACER = new ContextTracer(OM.DEBUG_REVISION, CDORevisionResolverImpl.class);

  private Map<CDOID, TimeLine> revisions = new HashMap();

  public CDORevisionResolverImpl()
  {
  }

  public CDORevisionImpl getRevision(CDOID id)
  {
    TimeLine timeLine = getTimeLine(id);
    return timeLine.getRevision();
  }

  public CDORevisionImpl getRevision(CDOID id, long timeStamp)
  {
    TimeLine timeLine = getTimeLine(id);
    return timeLine.getRevision(timeStamp);
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

  @Override
  public String toString()
  {
    return ReflectUtil.getSimpleClassName(this) + revisions;
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

    TimeLine timeLine = revisions.get(id);
    if (timeLine == null)
    {
      timeLine = new TimeLine(id);
      revisions.put(id, timeLine);
    }

    return timeLine;
  }

  protected abstract CDORevisionImpl loadRevision(CDOID id);

  protected abstract CDORevisionImpl loadRevision(CDOID id, long timeStamp);

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

    public CDORevisionImpl getRevision()
    {
      CDORevisionImpl revision = isEmpty() ? null : getFirst();
      if (revision == null || !revision.isCurrent())
      {
        revision = loadRevision(id);
        addFirst(revision);
      }

      return revision;
    }

    public CDORevisionImpl getRevision(long timeStamp)
    {
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

      CDORevisionImpl revision = loadRevision(id, timeStamp);
      it.add(revision);
      return revision;
    }

    @Override
    public boolean add(CDORevisionImpl revision)
    {
      CDORevisionImpl previousRevision = isEmpty() ? null : getFirst();
      if (previousRevision != null && previousRevision.isCurrent())
      {
        previousRevision.setRevised(revision.getCreated() - 1);
      }

      addFirst(revision);
      return true;
    }
  }
}
