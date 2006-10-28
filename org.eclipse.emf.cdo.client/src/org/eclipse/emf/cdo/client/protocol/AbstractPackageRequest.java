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
import org.eclipse.net4j.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.stream.ExtendedDataInputStream;

import org.eclipse.emf.cdo.client.ClassInfo;
import org.eclipse.emf.cdo.client.PackageManager;
import org.eclipse.emf.cdo.client.internal.CDOClient;
import org.eclipse.emf.cdo.core.ImplementationError;

import java.util.Iterator;

import java.io.IOException;


public abstract class AbstractPackageRequest<RESULT> extends AbstractCDOClientRequest<RESULT>
{
  private static final ContextTracer TRACER = new ContextTracer(CDOClient.DEBUG_PROTOCOL,
      AbstractPackageRequest.class);

  public AbstractPackageRequest(Channel channel)
  {
    super(channel);
  }

  protected void handlePackageResponse(ExtendedDataInputStream in, int count) throws IOException
  {
    for (int i = 0; i < count; i++)
    {
      int cid = in.readInt();
      String className = in.readString();

      if (TRACER.isEnabled())
      {
        TRACER.trace(this, "Responded class " + className + " = " + cid);
      }

      setCIDOnClassInfo(className, cid);
    }
  }

  private void setCIDOnClassInfo(String className, int cid)
  {
    PackageManager packageManager = getPackageManager();
    for (Iterator<?> classInfoIt = packageManager.getClassInfos(); classInfoIt.hasNext();)
    {
      ClassInfo classInfo = (ClassInfo) classInfoIt.next();
      if (classInfo.getFullName().equals(className))
      {
        classInfo.setCID(cid);
        return;
      }
    }

    throw new ImplementationError("No ClassInfo found for class " + className);
  }
}
