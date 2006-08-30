/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.client.impl;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentsEList.FeatureListIterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/**
 * TODO Document type CDOCrossReferenceList<p>
 * The <code>CDOCrossReferenceList</code> class.<p>
 *
 * @author Eike Stepper
 */
public class CDOCrossReferenceList implements EList
{
  private List<EObject> referers;

  private List<EReference> references;

  public CDOCrossReferenceList(List<EObject> referers, List<EReference> references)
  {
    this.referers = referers;
    this.references = references;
  }

  public CDOCrossReferenceList()
  {
    this(new ArrayList<EObject>(), new ArrayList<EReference>());
  }

  /* (non-Javadoc)
   * @see org.eclipse.emf.common.util.EList#move(int, java.lang.Object)
   */
  public void move(int newPosition, Object object)
  {
    throw new UnsupportedOperationException();
  }

  /* (non-Javadoc)
   * @see org.eclipse.emf.common.util.EList#move(int, int)
   */
  public Object move(int newPosition, int oldPosition)
  {
    throw new UnsupportedOperationException();
  }

  /* (non-Javadoc)
   * @see java.util.List#add(java.lang.Object)
   */
  public boolean add(Object o)
  {
    throw new UnsupportedOperationException();
  }

  /* (non-Javadoc)
   * @see java.util.List#add(int, java.lang.Object)
   */
  public void add(int index, Object element)
  {
    throw new UnsupportedOperationException();
  }

  /* (non-Javadoc)
   * @see java.util.List#addAll(java.util.Collection)
   */
  public boolean addAll(Collection c)
  {
    throw new UnsupportedOperationException();
  }

  /* (non-Javadoc)
   * @see java.util.List#addAll(int, java.util.Collection)
   */
  public boolean addAll(int index, Collection c)
  {
    throw new UnsupportedOperationException();
  }

  /* (non-Javadoc)
   * @see java.util.List#clear()
   */
  public void clear()
  {
    throw new UnsupportedOperationException();
  }

  /* (non-Javadoc)
   * @see java.util.List#contains(java.lang.Object)
   */
  public boolean contains(Object o)
  {
    return referers.contains(o);
  }

  /* (non-Javadoc)
   * @see java.util.List#containsAll(java.util.Collection)
   */
  public boolean containsAll(Collection c)
  {
    return referers.containsAll(c);
  }

  /* (non-Javadoc)
   * @see java.util.List#get(int)
   */
  public Object get(int index)
  {
    return referers.get(index);
  }

  /* (non-Javadoc)
   * @see java.util.List#indexOf(java.lang.Object)
   */
  public int indexOf(Object o)
  {
    return referers.indexOf(o);
  }

  /* (non-Javadoc)
   * @see java.util.List#isEmpty()
   */
  public boolean isEmpty()
  {
    return referers.isEmpty();
  }

  /* (non-Javadoc)
   * @see java.util.List#iterator()
   */
  public Iterator iterator()
  {
    return listIterator();
  }

  /* (non-Javadoc)
   * @see java.util.List#lastIndexOf(java.lang.Object)
   */
  public int lastIndexOf(Object o)
  {
    return referers.lastIndexOf(o);
  }

  /* (non-Javadoc)
   * @see java.util.List#listIterator()
   */
  public ListIterator listIterator()
  {
    return listIterator(0);
  }

  /* (non-Javadoc)
   * @see java.util.List#listIterator(int)
   */
  public ListIterator listIterator(int index)
  {
    return new IndexIterator(index);
  }

  /* (non-Javadoc)
   * @see java.util.List#remove(java.lang.Object)
   */
  public boolean remove(Object o)
  {
    throw new UnsupportedOperationException();
  }

  /* (non-Javadoc)
   * @see java.util.List#remove(int)
   */
  public Object remove(int index)
  {
    throw new UnsupportedOperationException();
  }

  /* (non-Javadoc)
   * @see java.util.List#removeAll(java.util.Collection)
   */
  public boolean removeAll(Collection c)
  {
    throw new UnsupportedOperationException();
  }

  /* (non-Javadoc)
   * @see java.util.List#retainAll(java.util.Collection)
   */
  public boolean retainAll(Collection c)
  {
    throw new UnsupportedOperationException();
  }

  /* (non-Javadoc)
   * @see java.util.List#set(int, java.lang.Object)
   */
  public Object set(int index, Object element)
  {
    throw new UnsupportedOperationException();
  }

  /* (non-Javadoc)
   * @see java.util.List#size()
   */
  public int size()
  {
    return referers.size();
  }

  /* (non-Javadoc)
   * @see java.util.List#subList(int, int)
   */
  public List subList(int fromIndex, int toIndex)
  {
    return new CDOCrossReferenceList(referers.subList(fromIndex, toIndex), references.subList(
        fromIndex, toIndex));
  }

  /* (non-Javadoc)
   * @see java.util.List#toArray()
   */
  public Object[] toArray()
  {
    return referers.toArray(new EObject[referers.size()]);
  }

  /* (non-Javadoc)
   * @see java.util.List#toArray(T[])
   */
  public Object[] toArray(Object[] a)
  {
    return referers.toArray(a);
  }

  public void addEntry(EObject object, EReference reference)
  {
    referers.add(object);
    references.add(reference);
  }


  private final class IndexIterator implements FeatureListIterator
  {
    private int index;

    private EReference feature;

    public IndexIterator(int index)
    {
      this.index = index;
    }

    public EStructuralFeature feature()
    {
      return feature;
    }

    public boolean hasNext()
    {
      return index < size();
    }

    public Object next()
    {
      feature = references.get(index);
      return referers.get(index++);
    }

    public void add(Object o)
    {
      throw new UnsupportedOperationException();
    }

    public boolean hasPrevious()
    {
      return index > 0;
    }

    public int nextIndex()
    {
      return index;
    }

    public Object previous()
    {
      feature = references.get(index);
      return referers.get(index--);
    }

    public int previousIndex()
    {
      return index - 1;
    }

    public void set(Object o)
    {
      throw new UnsupportedOperationException();
    }

    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
}
