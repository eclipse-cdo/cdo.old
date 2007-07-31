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
package org.eclipse.emf.cdo.weaver;

import org.eclipse.net4j.util.ObjectUtil;
import org.eclipse.net4j.util.StringUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eike Stepper
 */
public final class BundleInfo implements Comparable
{
  private String name;

  private String version;

  private File location;

  private List<String> packageURIs = new ArrayList();

  public BundleInfo(String name, String version, File location)
  {
    this.name = name;
    this.version = version;
    this.location = location;
  }

  public String getName()
  {
    return name;
  }

  public String getVersion()
  {
    return version;
  }

  public File getLocation()
  {
    return location;
  }

  public void setLocation(File location)
  {
    this.location = location;
  }

  public List<String> getPackageURIs()
  {
    return packageURIs;
  }

  public void addPackageURI(String uri)
  {
    packageURIs.add(uri);
  }

  public boolean isArchive()
  {
    return location.getName().endsWith(ICDOWeaver.JAR_SUFFIX);
  }

  public boolean isFolder()
  {
    return !isArchive();
  }

  public int compareTo(Object obj)
  {
    return StringUtil.compare(name, ((BundleInfo)obj).name);
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj == this) return true;
    if (obj == null) return false;
    if (!(obj instanceof BundleInfo)) return false;

    BundleInfo that = (BundleInfo)obj;
    return ObjectUtil.equals(this.name, that.name);
  }

  @Override
  public int hashCode()
  {
    return ObjectUtil.hashCode(name);
  }

  @Override
  public String toString()
  {
    return name;
  }
}
