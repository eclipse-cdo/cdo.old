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


import org.eclipse.emf.cdo.client.impl.CDOCrossReferenceList;
import org.eclipse.emf.cdo.core.CDOProtocol;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;


public class QueryXRefsRequest extends AbstractDataRequest
{
  private long oid;

  private int rid;

  public QueryXRefsRequest(long oid, int rid)
  {
    this.oid = oid;
    this.rid = rid;
  }

  public short getSignalId()
  {
    return CDOProtocol.QUERY_XREFS;
  }

  public void request()
  {
    transmitLong(oid);
    transmitInt(rid);
  }

  public Object confirm()
  {
    CDOCrossReferenceList result = new CDOCrossReferenceList();

    for (;;)
    {
      long oid = receiveLong();
      if (oid == CDOProtocol.NO_MORE_OBJECTS)
      {
        break;
      }

      int feature = receiveInt();
      int cid = receiveInt();

      EObject object = provideObject(oid, cid);
      EReference reference = (EReference) object.eClass().getEStructuralFeature(feature);
      result.addEntry(object, reference);
    }

    return result;
  }

  protected EObject provideObject(EClass eClass, long oid, int oca)
  {
    throw new UnsupportedOperationException();
  }
}
