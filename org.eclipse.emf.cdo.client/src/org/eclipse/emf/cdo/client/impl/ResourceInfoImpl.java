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
package org.eclipse.emf.cdo.client.impl;


import org.eclipse.net4j.util.StringHelper;

import org.eclipse.emf.cdo.client.ResourceInfo;


public final class ResourceInfoImpl implements ResourceInfo
{
  private String path;

  private int rid;

  private boolean existing;

  public ResourceInfoImpl(String path, int rid, boolean existing)
  {
    this.path = path;
    this.rid = rid;
    this.existing = existing;
  }

  public String getPath()
  {
    return path;
  }

  public void setPath(String path)
  {
    this.path = path;
  }

  public int getRid()
  {
    return rid;
  }

  public boolean isExisting()
  {
    return existing;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj instanceof ResourceInfo)
    {
      ResourceInfo that = (ResourceInfo) obj;
      return rid == that.getRid() && StringHelper.equals(path, that.getPath())
          && existing == that.isExisting();
    }

    return false;
  }

  @Override
  public int hashCode()
  {
    return rid ^ (path == null ? 0 : path.hashCode()) ^ (existing ? 1 : 2);
  }

  @Override
  public String toString()
  {
    return "ResourceInfo[" + rid + ", " + path + ", existing=" + existing + "]";
  }
}