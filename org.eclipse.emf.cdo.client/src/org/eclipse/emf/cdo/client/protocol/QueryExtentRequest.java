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
package org.eclipse.emf.cdo.client.protocol;


import org.eclipse.net4j.transport.Channel;
import org.eclipse.net4j.util.stream.ExtendedDataInputStream;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import org.eclipse.emf.cdo.core.CDOProtocol;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import java.util.HashSet;
import java.util.Set;

import java.io.IOException;


public class QueryExtentRequest extends AbstractDataRequest<Set<EObject>>
{
  private int cid;

  private boolean exactMatch;

  private int rid;

  public QueryExtentRequest(Channel channel, int cid, boolean exactMatch, int rid)
  {
    super(channel);
    this.cid = cid;
    this.exactMatch = exactMatch;
    this.rid = rid;
  }

  @Override
  protected short getSignalID()
  {
    return CDOProtocol.QUERY_EXTENT;
  }

  @Override
  protected void requesting(ExtendedDataOutputStream out) throws IOException
  {
    out.writeInt(cid);
    out.writeBoolean(exactMatch);
    out.writeInt(rid);
  }

  @Override
  protected Set<EObject> confirming(ExtendedDataInputStream in) throws IOException
  {
    Set<EObject> result = new HashSet();
    for (;;)
    {
      long oid = in.readLong();
      if (oid == CDOProtocol.NO_MORE_OBJECTS)
      {
        break;
      }

      int classifierId = (exactMatch ? cid : in.readInt());
      EObject object = provideObject(oid, classifierId);
      result.add(object);
    }

    return result;
  }

  protected EObject provideObject(EClass eClass, long oid, int oca)
  {
    throw new UnsupportedOperationException();
  }
}
