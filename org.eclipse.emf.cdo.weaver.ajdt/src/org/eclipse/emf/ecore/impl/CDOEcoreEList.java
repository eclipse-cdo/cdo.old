/**
 * <copyright>
 *
 * Copyright (c) 2002-2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.ecore.impl;

import org.eclipse.emf.common.notify.impl.NotifyingListImpl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CDOEcoreEList<E> extends NotifyingListImpl<E>
{
  private static final long serialVersionUID = 1L;

  public CDOEcoreEList()
  {
  }

  @Override
  public boolean add(E object)
  {
    return super.add(object);
  }

  @Override
  public void add(int index, E object)
  {
    super.add(index, object);
  }

  @Override
  public boolean addAll(Collection<? extends E> collection)
  {
    return super.addAll(collection);
  }

  @Override
  public boolean addAll(int index, Collection<? extends E> collection)
  {
    return super.addAll(index, collection);
  }

  @Override
  public boolean addAllUnique(Collection<? extends E> collection)
  {
    return super.addAllUnique(collection);
  }

  @Override
  public boolean addAllUnique(int index, Collection<? extends E> collection)
  {
    return super.addAllUnique(index, collection);
  }

  @Override
  public boolean addAllUnique(int index, Object[] objects, int start, int end)
  {
    return super.addAllUnique(index, objects, start, end);
  }

  @Override
  public boolean addAllUnique(Object[] objects, int start, int end)
  {
    return super.addAllUnique(objects, start, end);
  }

  @Override
  public void addUnique(E object)
  {
    super.addUnique(object);
  }

  @Override
  public void addUnique(int index, E object)
  {
    super.addUnique(index, object);
  }

  @Override
  public void clear()
  {
    super.clear();
  }

  @Override
  public Object clone()
  {
    return super.clone();
  }

  @Override
  public boolean contains(Object object)
  {
    return super.contains(object);
  }

  @Override
  public boolean containsAll(Collection<?> collection)
  {
    return super.containsAll(collection);
  }

  @Override
  public boolean equals(Object object)
  {
    return super.equals(object);
  }

  @Override
  public E get(int index)
  {
    return super.get(index);
  }

  @Override
  public int hashCode()
  {
    return super.hashCode();
  }

  @Override
  public int indexOf(Object object)
  {
    return super.indexOf(object);
  }

  @Override
  public boolean isEmpty()
  {
    return super.isEmpty();
  }

  @Override
  public Iterator<E> iterator()
  {
    return super.iterator();
  }

  @Override
  public int lastIndexOf(Object object)
  {
    return super.lastIndexOf(object);
  }

  @Override
  public ListIterator<E> listIterator()
  {
    return super.listIterator();
  }

  @Override
  public ListIterator<E> listIterator(int index)
  {
    return super.listIterator(index);
  }

  @Override
  public void move(int index, E object)
  {
    super.move(index, object);
  }

  @Override
  public E move(int targetIndex, int sourceIndex)
  {
    return super.move(targetIndex, sourceIndex);
  }

  @Override
  public E remove(int index)
  {
    return super.remove(index);
  }

  @Override
  public boolean remove(Object object)
  {
    return super.remove(object);
  }

  @Override
  public boolean removeAll(Collection<?> collection)
  {
    return super.removeAll(collection);
  }

  @Override
  public boolean retainAll(Collection<?> collection)
  {
    return super.retainAll(collection);
  }

  @Override
  public E set(int index, E object)
  {
    return super.set(index, object);
  }

  @Override
  public E setUnique(int index, E object)
  {
    return super.setUnique(index, object);
  }

  @Override
  public int size()
  {
    return super.size();
  }

  @Override
  public List<E> subList(int fromIndex, int toIndex)
  {
    return super.subList(fromIndex, toIndex);
  }

  @Override
  public Object[] toArray()
  {
    return super.toArray();
  }

  @Override
  public String toString()
  {
    return super.toString();
  }
}
