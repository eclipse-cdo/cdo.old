package org.eclipse.emf.cdo.weaver.ajdt;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.internal.cdo.weaver.IPersistenceCallback;

/**
 * @author Eike Stepper
 */
aspect EObjectAspect
{
  pointcut writeAccess(EObjectImpl eObject): target(eObject) && execution(void set*(*));

  pointcut readAccess(EObjectImpl eObject): target(eObject) && (execution(* get*()) ||
                                                                execution(boolean is*()) ||
                                                                execution(Boolean is*()));

  before(EObjectImpl eObject): writeAccess(eObject) 
  {
    eObject.beforeWrite();
  }

  before(EObjectImpl eObject): readAccess(eObject) 
  {
    eObject.beforeRead();
  }
}
