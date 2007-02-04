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
package org.eclipse.emf.cdo.internal.protocol.revision;

import org.eclipse.emf.cdo.internal.protocol.bundle.CDOProtocol;
import org.eclipse.emf.cdo.protocol.CDOID;
import org.eclipse.emf.cdo.protocol.revision.CDORevisionResolver;

import org.eclipse.net4j.util.om.trace.ContextTracer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public abstract class CDORevisionResolverImpl implements CDORevisionResolver
{
  private static final ContextTracer TRACER = new ContextTracer(CDOProtocol.DEBUG_REVISION,
      CDORevisionResolverImpl.class);

  private Map<CDOID, TimeLine> revisions = new HashMap();

  public CDORevisionResolverImpl()
  {
  }

  public CDORevisionImpl getActualRevision(CDOID id)
  {
    TimeLine timeLine = getTimeLine(id);
    return timeLine.getActual();
  }

  public CDORevisionImpl getHistoricalRevision(CDOID id, long timeStamp)
  {
    // TODO Implement method CDORevisionManagerImpl.getHistoricalRevision()
    throw new UnsupportedOperationException("Not yet implemented");
  }

  public void addRevision(CDORevisionImpl revision)
  {
    TimeLine timeLine = getTimeLine(revision.getID());
    timeLine.add(revision);
    // xxx();
  }

  private TimeLine getTimeLine(CDOID id)
  {
    TimeLine timeLine = revisions.get(id);
    if (timeLine == null)
    {
      timeLine = new TimeLine(id);
      revisions.put(id, timeLine);
    }

    return timeLine;
  }

  protected abstract CDORevisionImpl loadActual(CDOID id);

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

    public CDORevisionImpl getActual()
    {
      CDORevisionImpl revision = isEmpty() ? null : getFirst();
      if (revision == null || !revision.isActual())
      {
        revision = loadActual(id);
        addFirst(revision);
      }

      return revision;
    }

    @Override
    public boolean add(CDORevisionImpl revision)
    {
      if (TRACER.isEnabled())
      {
        TRACER.format("Adding revision: {0}", revision);
      }

      if (revision.isActual())
      {
        addFirst(revision);
      }
      else
      {
        // TODO Implement method TimeLine.add()
        throw new UnsupportedOperationException("Not yet implemented");
      }

      return true;
    }
  }
}
