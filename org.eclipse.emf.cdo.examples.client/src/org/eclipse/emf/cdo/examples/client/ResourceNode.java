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
package org.eclipse.emf.cdo.examples.client;


import org.eclipse.emf.cdo.client.ResourceInfo;

import java.util.List;


/**
 * @deprecated
 */
public final class ResourceNode
{
  private ResourceNode parent;

  private List<ResourceNode> children;

  private ResourceInfo resourceInfo;

  public ResourceNode(ResourceNode parent, ResourceInfo resourceInfo)
  {
    this.parent = parent;
    this.resourceInfo = resourceInfo;
  }

  public List<ResourceNode> getChildren()
  {
    return children;
  }

  public ResourceNode getParent()
  {
    return parent;
  }

  public ResourceInfo getResourceInfo()
  {
    return resourceInfo;
  }

  public void setResourceInfo(ResourceInfo resourceInfo)
  {
    this.resourceInfo = resourceInfo;
  }

  public void addChild(ResourceNode child)
  {
    children.add(child);
  }
}
