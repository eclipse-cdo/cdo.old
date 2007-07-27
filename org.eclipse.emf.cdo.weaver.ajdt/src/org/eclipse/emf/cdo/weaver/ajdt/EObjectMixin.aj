package org.eclipse.emf.cdo.weaver.ajdt;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.internal.cdo.weaver.IPersistenceAware;
import org.eclipse.emf.internal.cdo.weaver.IPersistenceCallback;

/**
 * @author Eike Stepper
 */
aspect EObjectMixin
{
  declare parents: EObjectImpl implements IPersistenceAware;

  private IPersistenceCallback EObjectImpl.persistenceCallback = null;

  public IPersistenceCallback EObjectImpl.getPersistenceCallback()
  {
    return persistenceCallback;
  }

  public void EObjectImpl.setPersistenceCallback(IPersistenceCallback callback)
  {
    persistenceCallback = callback;
  }

  public void EObjectImpl.beforeRead()
  {
    if (persistenceCallback != null)
    {
      persistenceCallback.beforeRead(this);
    }
  }

  public void EObjectImpl.beforeWrite()
  {
    if (persistenceCallback != null)
    {
      persistenceCallback.beforeWrite(this);
    }
  }
}
