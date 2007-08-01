/***************************************************************************
 * Copyright (c) 2004 - 2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.ecore.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreEList;

/**
 * @author Eike Stepper
 */
aspect CDOAspectList
{
  pointcut writeAccess(EcoreEList list): target(list) && (
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

  pointcut readAccess(EcoreEList list): target(list) && (
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

  before(EcoreEList list): writeAccess(list) 
  {
    EObject owner = list.getEObject();
    if (owner instanceof EObjectImpl)
    {
      ((EObjectImpl)owner).beforeWrite();
    }
  }

  before(EcoreEList list): readAccess(list) 
  {
    EObject owner = list.getEObject();
    if (owner instanceof EObjectImpl)
    {
      ((EObjectImpl)owner).beforeRead();
    }
  }
}
