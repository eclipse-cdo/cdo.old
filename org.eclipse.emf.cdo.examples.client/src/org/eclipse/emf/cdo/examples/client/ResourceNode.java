package org.eclipse.emf.cdo.example.client;


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
