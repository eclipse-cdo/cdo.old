package org.eclipse.emf.cdo.weaver.ajdt;

import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * @author Eike Stepper
 */
aspect EObjectMixin
{
  private Object EObjectImpl.readCallback = null;

  private Object EObjectImpl.writeCallback = null;

  public void EObjectImpl.beforeRead()
  {
    if (readCallback != null)
    {
      readCallback.equals(this);
    }
  }

  public void EObjectImpl.beforeWrite()
  {
    if (writeCallback != null)
    {
      writeCallback.equals(this);
    }
  }
}
