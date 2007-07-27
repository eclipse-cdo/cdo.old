package org.eclipse.emf.cdo.weaver.ajdt;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.internal.cdo.weaver.IPersistenceAware;
import org.eclipse.emf.internal.cdo.weaver.IPersistenceCallback;

/**
 * @author Eike Stepper
 */
aspect EcoreEListAspect
{
  pointcut writeAccess(EcoreEList ecoreList): target(ecoreList) && (
                                              execution(* add(*)) ||
                                              execution(* add(int, *)) ||
                                              execution(* addAll(*)) ||
                                              execution(* addAll(int, *)) ||
                                              execution(* clear(*)) ||
                                              execution(* move(int, *)) ||
                                              execution(* move(int, int)) ||
                                              execution(* remove(*)) ||
                                              execution(* remove(int)) ||
                                              execution(* removeAll(*)) ||
                                              execution(* retainAll(*)) ||
                                              execution(* set(int, *)));

  pointcut readAccess(EcoreEList ecoreList): target(ecoreList) && (
                                             execution(boolean contains(*)) ||
                                             execution(boolean containsAll(*)) ||
                                             execution(boolean equals(*)) ||
                                             execution(* get(int)) ||
                                             execution(int hashCode()) ||
                                             execution(int indexOf(*)) ||
                                             execution(boolean isEmpty()) ||
                                             execution(int lastIndexOf(*)) ||
                                             execution(int size()) ||
                                             execution(* subList(int, int)) ||
                                             execution(* toArray()) ||
                                             execution(* toArray(*)));

  before(EcoreEList ecoreList): writeAccess(ecoreList) 
  {
    EObject owner = ecoreList.getEObject();
    if (owner instanceof EObjectImpl)
    {
      ((EObjectImpl)owner).beforeWrite();
    }
  }

  before(EcoreEList ecoreList): readAccess(ecoreList) 
  {
    EObject owner = ecoreList.getEObject();
    if (owner instanceof EObjectImpl)
    {
      ((EObjectImpl)owner).beforeRead();
    }
  }
}
