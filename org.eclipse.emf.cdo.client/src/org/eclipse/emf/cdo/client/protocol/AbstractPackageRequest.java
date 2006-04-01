/*******************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Sympedia Methods and Tools.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.cdo.client.protocol;


import org.eclipse.net4j.util.ImplementationError;

import org.eclipse.emf.cdo.client.ClassInfo;
import org.eclipse.emf.cdo.client.PackageManager;

import java.util.Iterator;


public abstract class AbstractPackageRequest extends AbstractCdoClientRequest
{
  protected void handlePackageResponse(int count)
  {
    for (int i = 0; i < count; i++)
    {
      int cid = receiveInt();
      String className = receiveString();

      if (isDebugEnabled())
      {
        debug("Responded class " + className + " = " + cid);
      }

      setCidOnClassInfo(className, cid);
    }
  }

  private void setCidOnClassInfo(String className, int cid)
  {
    PackageManager packageManager = getPackageManager();
    for (Iterator classInfoIt = packageManager.getClassInfos(); classInfoIt.hasNext();)
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
