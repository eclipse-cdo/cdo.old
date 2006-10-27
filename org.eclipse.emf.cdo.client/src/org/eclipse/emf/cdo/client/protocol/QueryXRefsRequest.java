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

import org.eclipse.emf.cdo.client.impl.CDOCrossReferenceList;
import org.eclipse.emf.cdo.core.CDOProtocol;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import java.io.IOException;


public class QueryXRefsRequest extends AbstractDataRequest<EList>
{
  private long oid;

  private int rid;

  public QueryXRefsRequest(Channel channel, long oid, int rid)
  {
    super(channel);
    this.oid = oid;
    this.rid = rid;
  }

  @Override
  protected short getSignalID()
  {
    return CDOProtocol.QUERY_XREFS;
  }

  @Override
  protected void requesting(ExtendedDataOutputStream out) throws IOException
  {
    out.writeLong(oid);
    out.writeInt(rid);
  }

  @Override
  protected EList confirming(ExtendedDataInputStream in) throws IOException
  {
    CDOCrossReferenceList result = new CDOCrossReferenceList();
    for (;;)
    {
      long oid = in.readLong();
      if (oid == CDOProtocol.NO_MORE_OBJECTS)
      {
        break;
      }

      int feature = in.readInt();
      int cid = in.readInt();

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
