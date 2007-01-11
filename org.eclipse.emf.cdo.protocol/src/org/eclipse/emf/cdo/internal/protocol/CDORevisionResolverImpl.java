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
package org.eclipse.emf.cdo.internal.protocol;

import org.eclipse.emf.cdo.protocol.CDOID;
import org.eclipse.emf.cdo.protocol.CDORevision;
import org.eclipse.emf.cdo.protocol.CDORevisionResolver;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class CDORevisionResolverImpl implements CDORevisionResolver
{
  private Map<CDOID, TimeLine> revisions = new HashMap();

  public CDORevisionResolverImpl()
  {
  }

  public CDORevision getActualRevision(CDOID id)
  {
    TimeLine timeLine = getTimeLine(id);
    return timeLine.getActual();
  }

  public CDORevision getHistoricalRevision(CDOID id, long timeStamp)
  {
    // TODO Implement method CDORevisionManagerImpl.getHistoricalRevision()
    throw new UnsupportedOperationException("Not yet implemented");
  }

  public CDORevision loadActual(CDOID id)
  {
    // TODO Implement method CDORevisionManagerImpl.loadActual()
    throw new UnsupportedOperationException("Not yet implemented");
  }

  public void addRevision(CDORevision revision)
  {
    TimeLine timeLine = getTimeLine(revision.getID());
    timeLine.add(revision);
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

  private final class TimeLine extends LinkedList<CDORevision>
  {
    private static final long serialVersionUID = 1L;

    private CDOID id;

    public TimeLine(CDOID id)
    {
      this.id = id;
    }

    public CDOID getID()
    {
      return id;
    }

    public CDORevision getActual()
    {
      CDORevision revision = isEmpty() ? null : getFirst();
      if (revision == null || !revision.isActual())
      {
        revision = loadActual(id);
        addFirst(revision);
      }

      return revision;
    }

    @Override
    public boolean add(CDORevision revision)
    {
      if (revision.isActual())
      {
        addFirst(revision);
      }
      else
      {
        throw new ImplementationError();
      }

      return true;
    }
  }
}
