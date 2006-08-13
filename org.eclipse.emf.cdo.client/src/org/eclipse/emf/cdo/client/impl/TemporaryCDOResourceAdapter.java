package org.eclipse.emf.cdo.client.impl;


import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.common.notify.impl.AdapterImpl;


public class TemporaryCDOResourceAdapter extends AdapterImpl
{
  private CDOResource resource;

  public TemporaryCDOResourceAdapter(CDOResource resource)
  {
    this.resource = resource;
  }

  protected CDOResource getResource()
  {
    return resource;
  }
}
