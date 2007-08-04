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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Eike Stepper
 */
aspect CDOAspectList
{  
  public boolean EcoreEList.add(E object)
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeWrite();
    return super.add(object);
  }
  
  public void EcoreEList.add(int index, E object)
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeWrite();
    super.add(index, object);
  }
  
  public boolean EcoreEList.addAll(Collection<? extends E> collection)
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeWrite();
    return super.addAll(collection);
  }
  
  public boolean EcoreEList.addAll(int index, Collection<? extends E> collection)
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeWrite();
    return super.addAll(index, collection);
  }
  
  public boolean EcoreEList.addAllUnique(Collection<? extends E> collection)
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeWrite();
    return super.addAllUnique(collection);
  }
  
  public boolean EcoreEList.addAllUnique(int index, Collection<? extends E> collection)
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeWrite();
    return super.addAllUnique(index, collection);
  }
  
  public boolean EcoreEList.addAllUnique(int index, Object[] objects, int start, int end)
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeWrite();
    return super.addAllUnique(index, objects, start, end);
  }
  
  public boolean EcoreEList.addAllUnique(Object[] objects, int start, int end)
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeWrite();
    return super.addAllUnique(objects, start, end);
  }
  
  public void EcoreEList.addUnique(E object)
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeWrite();
    super.addUnique(object);
  }
  
  public void EcoreEList.addUnique(int index, E object)
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeWrite();
    super.addUnique(index, object);
  }
  
  public void EcoreEList.clear()
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeWrite();
    super.clear();
  }
  
  public Object EcoreEList.clone()
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeRead();
    return super.clone();
  }
  
  public boolean EcoreEList.containsAll(Collection<?> collection)
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeRead();
    return super.containsAll(collection);
  }
  
  public boolean EcoreEList.equals(Object object)
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeRead();
    return super.equals(object);
  }
  
  public E EcoreEList.get(int index)
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeRead();
    return super.get(index);
  }
  
  public int EcoreEList.hashCode()
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeRead();
    return super.hashCode();
  }
  
  public boolean EcoreEList.isEmpty()
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeRead();
    return super.isEmpty();
  }
  
  public Iterator<E> EcoreEList.iterator()
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeRead();
    return super.iterator();
  }
  
  public ListIterator<E> EcoreEList.listIterator()
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeRead();
    return super.listIterator();
  }
  
  public ListIterator<E> EcoreEList.listIterator(int index)
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeRead();
    return super.listIterator(index);
  }
  
  public void EcoreEList.move(int index, E object)
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeWrite();
    super.move(index, object);
  }
  
  /*
   * public E EcoreEList.move(int targetIndex, int sourceIndex) { return
   * super.move(targetIndex, sourceIndex); } public E EcoreEList.remove(int
   * index) { return super.remove(index); }
   */
  
  public boolean EcoreEList.remove(Object object)
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeWrite();
    return super.remove(object);
  }
  
  public boolean EcoreEList.removeAll(Collection<?> collection)
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeWrite();
    return super.removeAll(collection);
  }
  
  public boolean EcoreEList.retainAll(Collection<?> collection)
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeWrite();
    return super.retainAll(collection);
  }

  public E EcoreEList.set(int index, E object)
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeWrite();
    return super.set(index, object);
  }

  public E EcoreEList.setUnique(int index, E object)
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeWrite();
    return super.setUnique(index, object);
  }

  public int EcoreEList.size()
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeRead();
    return super.size();
  }

  public List<E> EcoreEList.subList(int fromIndex, int toIndex)
  {
    EObject owner = getEObject();
    if (owner instanceof EObjectImpl) ((EObjectImpl)owner).beforeRead();
    return super.subList(fromIndex, toIndex);
  }

  pointcut writeAccess(EcoreEList list): target(list) && (
                                         execution(boolean add(Object)) ||
                                         execution(void add(int, Object)) ||
                                         execution(boolean addAll(Collection)) ||
                                         execution(boolean addAll(int, Collection)) ||
                                         execution(boolean addAllUnique(int, Object[], int, int)) ||
                                         execution(boolean addAllUnique(int, Collection)) ||
                                         execution(boolean addAllUnique(Object[], int, int)) ||
                                         execution(boolean addAllUnique(Collection)) ||
                                         execution(void addUnique(int, Object)) ||
                                         execution(void addUnique(Object)) ||
                                         execution(void clear()) ||
                                         execution(void move(int, Object)) ||
                                         execution(Object move(int, int)) ||
                                         execution(Object remove(int)) ||
                                         execution(boolean remove(Object)) ||
                                         execution(boolean removeAll(Collection)) ||
                                         execution(boolean retainAll(Collection)) ||
                                         execution(Object setUnique(int, Object)) ||
                                         execution(Object set(int, Object)));

  pointcut readAccess(EcoreEList list): target(list) && (
                                        execution(Object clone()) ||
                                        execution(boolean contains(Object)) ||
                                        execution(boolean containsAll(Collection)) ||
                                        execution(boolean equals(Object)) ||
                                        execution(Object get(int)) ||
                                        execution(int hashCode()) ||
                                        execution(int indexOf(Object)) ||
                                        execution(boolean isEmpty()) ||
                                        execution(Iterator iterator()) ||
                                        execution(int lastIndexOf(Object)) ||
                                        execution(ListIterator listIterator()) ||
                                        execution(ListIterator listIterator(int)) ||
                                        execution(int size()) ||
                                        execution(List subList(int, int)) ||
                                        execution(Object[] toArray()) ||
                                        execution(Object[] toArray(Object[])));

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
