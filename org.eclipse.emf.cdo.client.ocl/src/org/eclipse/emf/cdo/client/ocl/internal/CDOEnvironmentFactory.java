/**
 * 
 */
package org.eclipse.emf.cdo.client.ocl.internal;


import org.eclipse.emf.cdo.client.CDOPersistable;
import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.cdo.client.ocl.GlobalExtentMap;
import org.eclipse.emf.cdo.client.ocl.ResourceExtentMap;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.EnvironmentFactory;
import org.eclipse.emf.ocl.parser.EvaluationEnvironment;

import java.util.List;
import java.util.Map;


public final class CDOEnvironmentFactory implements EnvironmentFactory
{
  protected EnvironmentFactory delegate = EnvironmentFactory.ECORE_INSTANCE;

  protected boolean globalExtents;

  public CDOEnvironmentFactory(boolean globalExtents)
  {
    this.globalExtents = globalExtents;
  }

  public Environment createClassifierContext(Object context)
  {
    return delegate.createClassifierContext(context);
  }

  public Environment createEnvironment(Environment parent)
  {
    return delegate.createEnvironment(parent);
  }

  public EvaluationEnvironment createEvaluationEnvironment()
  {
    return delegate.createEvaluationEnvironment();
  }

  public Map createExtentMap(Object object)
  {
    if (object instanceof CDOPersistable)
    {
      CDOPersistable persistable = (CDOPersistable) object;
      CDOResource resource = persistable.cdoGetResource();

      if (globalExtents)
      {
        return new GlobalExtentMap(resource.getResourceManager());
      }
      else
      {
        return new ResourceExtentMap(resource);
      }
    }

    return delegate.createExtentMap(object);
  }

  public Environment createOperationContext(Object context, Object operation)
  {
    return delegate.createOperationContext(context, operation);
  }

  public Environment createPackageContext(List pathname)
  {
    return delegate.createPackageContext(pathname);
  }

  public Environment createPropertyContext(Object context, Object property)
  {
    return delegate.createPropertyContext(context, property);
  }

}