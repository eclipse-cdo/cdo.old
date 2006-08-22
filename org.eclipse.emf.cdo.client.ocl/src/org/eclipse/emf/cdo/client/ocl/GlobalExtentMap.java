package org.eclipse.emf.cdo.client.ocl;


import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.ecore.EClass;

import java.util.Map;
import java.util.Set;


public class GlobalExtentMap extends AbstractLazyExtentMap
{
  protected ResourceManager resourceManager;

  public GlobalExtentMap(Map delegate, ResourceManager resourceManager)
  {
    super(delegate);
    this.resourceManager = resourceManager;
  }

  public GlobalExtentMap(ResourceManager resourceManager)
  {
    this.resourceManager = resourceManager;
  }

  @Override
  protected Set queryExtent(EClass eClass)
  {
    return resourceManager.queryExtent(eClass);
  }
}
