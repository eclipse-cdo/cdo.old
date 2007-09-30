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

import org.eclipse.emf.cdo.protocol.CDOID;
import org.eclipse.emf.cdo.protocol.revision.CDORevision;

/**
 * @author Eike Stepper
 */
public class RevisionHolder
{
  private CDOID id;

  private int version;

  private long created;

  private long revised;

  private RevisionHolder prev;

  private RevisionHolder next;

  private CDORevision revision;

  public RevisionHolder(CDORevision revision)
  {
    setRevision(revision);
  }

  public CDOID getID()
  {
    return id;
  }

  public int getVersion()
  {
    return version;
  }

  public long getCreated()
  {
    return created;
  }

  public long getRevised()
  {
    return revised;
  }

  public boolean isCurrent()
  {
    return revised == CDORevision.UNSPECIFIED_DATE;
  }

  public boolean isValid(long timeStamp)
  {
    return (revised == CDORevision.UNSPECIFIED_DATE || revised >= timeStamp) && timeStamp >= created;
  }

  public int compareTo(long timeStamp)
  {
    if (timeStamp < created)
    {
      return -1;
    }

    if (revised != CDORevision.UNSPECIFIED_DATE && timeStamp > revised)
    {
      return 1;
    }

    return 0;
  }

  public RevisionHolder getPrev()
  {
    return prev;
  }

  public void setPrev(RevisionHolder prev)
  {
    this.prev = prev;
  }

  public RevisionHolder getNext()
  {
    return next;
  }

  public void setNext(RevisionHolder next)
  {
    this.next = next;
  }

  public boolean isLoaded()
  {
    return revision != null;
  }

  public CDORevision getRevision(boolean loadOnDemand)
  {
    if (revision == null && loadOnDemand)
    {
      revision = loadRevision();
    }

    return revision;
  }

  public void setRevision(CDORevision revision)
  {
    this.revision = revision;
    id = revision.getID();
    version = revision.getVersion();
    created = revision.getCreated();
    revised = revision.getRevised();
  }

  protected CDORevisionImpl loadRevision()
  {
    throw new UnsupportedOperationException();
  }
}
