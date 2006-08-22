/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;


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
    EList result = new BasicEList();

    for (;;)
    {
      long oid = receiveLong();
      if (oid == 0)
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
    //    EObject object = getProxyObject(oid);
    //    if (object == null)
    //    {
    //      throw new ImplementationError("A proxy should be available, when requesting object data!");
    //    }
    //
    //    int rid = getPackageManager().getOidEncoder().getRID(oid);
    //    CDOResource cdoResource = getResourceManager().getResource(rid);
    //    ResourceManagerImpl.initPersistable(object, cdoResource, oid, oca);
    //    ((InternalEObject) object).eSetProxyURI(null);
    //
    //    return object;
  }
}
