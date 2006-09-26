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


import org.eclipse.emf.cdo.core.CDOProtocol;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import java.util.HashSet;
import java.util.Set;


public class QueryExtentRequest extends AbstractDataRequest
{
  private int cid;

  private boolean exactMatch;

  private int rid;

  public QueryExtentRequest(int cid, boolean exactMatch, int rid)
  {
    this.cid = cid;
    this.exactMatch = exactMatch;
    this.rid = rid;
  }

  public short getSignalId()
  {
    return CDOProtocol.QUERY_EXTENT;
  }

  public void request()
  {
    transmitInt(cid);
    transmitBoolean(exactMatch);
    transmitInt(rid);
  }

  public Object confirm()
  {
    Set result = new HashSet();

    for (;;)
    {
      long oid = receiveLong();
      if (oid == CDOProtocol.NO_MORE_OBJECTS)
      {
        break;
      }

      int classifierId = (exactMatch ? cid : receiveInt());
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