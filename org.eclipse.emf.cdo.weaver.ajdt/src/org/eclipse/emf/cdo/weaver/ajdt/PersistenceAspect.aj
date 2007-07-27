package org.eclipse.emf.cdo.weaver.ajdt;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.internal.cdo.weaver.IPersistenceCallback;

/**
 * @author Eike Stepper
 */
aspect PersistenceAspect
{
  pointcut setter(EObjectImpl eObject): target(eObject) && execution(void set*(*));

  pointcut getter(EObjectImpl eObject): target(eObject) && (execution(* get*()) ||
                                                            execution(boolean is*()) ||
                                                            execution(Boolean is*()));

  before(EObjectImpl eObject): setter(eObject) 
  {
    eObject.beforeWrite();
  }

  before(EObjectImpl eObject): getter(eObject) 
  {
    eObject.beforeRead();
  }
}
