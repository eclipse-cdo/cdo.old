/***************************************************************************
 * Copyright (c) 2004-2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.internal.protocol.model;

import org.eclipse.emf.cdo.protocol.model.CDOClass;
import org.eclipse.emf.cdo.protocol.model.CDOPackage;

import org.eclipse.net4j.util.io.ExtendedDataOutputStream;

import java.io.IOException;

/**
 * @author Eike Stepper
 */
public final class CDOPackageProxy implements CDOPackage
{
  private CDOPackageManagerImpl packageManager;

  private String packageURI;

  private CDOPackageImpl delegate;

  public CDOPackageProxy(CDOPackageManagerImpl packageManager, String packageURI)
  {
    this.packageManager = packageManager;
    this.packageURI = packageURI;
  }

  public CDOPackageManagerImpl getPackageManager()
  {
    return packageManager;
  }

  public String getPackageURI()
  {
    return packageURI;
  }

  public synchronized CDOPackageImpl getDelegate()
  {
    if (delegate == null)
    {
      delegate = packageManager.resolve(packageURI);
    }

    return delegate;
  }

  public synchronized boolean isDelegated()
  {
    return delegate != null;
  }

  public void write(ExtendedDataOutputStream out) throws IOException
  {
    getDelegate().write(out);
  }

  public void initialize()
  {
    getDelegate().initialize();
  }

  public String getName()
  {
    return getDelegate().getName();
  }

  public int getClassCount()
  {
    return getDelegate().getClassCount();
  }

  public CDOClass[] getClasses()
  {
    return getDelegate().getClasses();
  }

  public CDOClass[] getConcreteClasses()
  {
    return getDelegate().getConcreteClasses();
  }

  public CDOClassImpl lookupClass(int classifierID)
  {
    return getDelegate().lookupClass(classifierID);
  }

  public Object getClientInfo()
  {
    return getDelegate().getClientInfo();
  }

  public void setClientInfo(Object clientInfo)
  {
    getDelegate().setClientInfo(clientInfo);
  }

  public Object getServerInfo()
  {
    return getDelegate().getServerInfo();
  }

  public void setServerInfo(Object serverInfo)
  {
    getDelegate().setServerInfo(serverInfo);
  }

  public void addClass(CDOClassImpl cdoClass)
  {
    getDelegate().addClass(cdoClass);
  }

  @Override
  public String toString()
  {
    return getDelegate().toString();
  }

  @Override
  public boolean equals(Object obj)
  {
    return getDelegate().equals(obj);
  }

  @Override
  public int hashCode()
  {
    return getDelegate().hashCode();
  }
}
