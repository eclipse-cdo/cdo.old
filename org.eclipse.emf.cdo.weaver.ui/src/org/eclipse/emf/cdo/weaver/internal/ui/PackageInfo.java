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
package org.eclipse.emf.cdo.weaver.internal.ui;

import org.eclipse.net4j.util.ObjectUtil;
import org.eclipse.net4j.util.StringUtil;

import java.text.MessageFormat;

/**
 * @author Eike Stepper
 */
public final class PackageInfo implements Comparable
{
  private String packageURI;

  private String bundleSymbolicName;

  public PackageInfo(String packageURI, String bundleSymbolicName)
  {
    this.packageURI = packageURI;
    this.bundleSymbolicName = bundleSymbolicName;
  }

  public String getPackageURI()
  {
    return packageURI;
  }

  public String getBundleSymbolicName()
  {
    return bundleSymbolicName;
  }

  public int compareTo(Object obj)
  {
    return StringUtil.compare(packageURI, ((PackageInfo)obj).packageURI);
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj instanceof PackageInfo)
    {
      return ObjectUtil.equals(packageURI, ((PackageInfo)obj).packageURI);
    }

    return false;
  }

  @Override
  public int hashCode()
  {
    return ObjectUtil.hashCode(packageURI);
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("{0} --> {1}", packageURI, bundleSymbolicName);
  }
}
