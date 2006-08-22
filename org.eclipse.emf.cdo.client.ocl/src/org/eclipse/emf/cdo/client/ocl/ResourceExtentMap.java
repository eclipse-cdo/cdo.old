package org.eclipse.emf.cdo.client.ocl;


import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.ecore.EClass;

import java.util.Map;
import java.util.Set;


public class ResourceExtentMap extends AbstractLazyExtentMap
{
  protected CDOResource resource;

  public ResourceExtentMap(Map delegate, CDOResource resource)
  {
    super(delegate);
    this.resource = resource;
  }

  public ResourceExtentMap(CDOResource resource)
  {
    this.resource = resource;
  }

  @Override
  protected Set queryExtent(EClass eClass)
  {
    return resource.queryExtent(eClass);
  }
}
