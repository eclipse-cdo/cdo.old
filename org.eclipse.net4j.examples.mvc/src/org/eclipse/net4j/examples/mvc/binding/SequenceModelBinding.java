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
package org.eclipse.net4j.examples.mvc.binding;


import org.eclipse.net4j.examples.mvc.IAdapter;
import org.eclipse.net4j.examples.mvc.IController;
import org.eclipse.net4j.examples.mvc.aspect.ISequenceModelAspect;
import org.eclipse.net4j.examples.mvc.util.NoAdapterException;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class SequenceModelBinding<TARGET> extends AbstractBinding<TARGET> implements
        ISequenceModelAspect
{
  public SequenceModelBinding(IController<TARGET> controller, String targetName)
  {
    super(controller, targetName);
  }

  public Class getAspect()
  {
    return ISequenceModelAspect.class;
  }

  public ISequenceModelAspect getSequenceModelAspect()
  {
    IAdapter<TARGET> adapter = getAdapter();

    if (adapter == null)
    {
      throw new NoAdapterException(this);
    }

    return (ISequenceModelAspect)adapter;
  }

  public boolean add(Object o)
  {
    return getSequenceModelAspect().add(o);
  }

  public void add(int index, Object element)
  {
    getSequenceModelAspect().add(index, element);
  }

  public boolean addAll(Collection c)
  {
    return getSequenceModelAspect().addAll(c);
  }

  public boolean addAll(int index, Collection c)
  {
    return getSequenceModelAspect().addAll(index, c);
  }

  public void clear()
  {
    getSequenceModelAspect().clear();
  }

  public boolean contains(Object o)
  {
    return getSequenceModelAspect().contains(o);
  }

  public boolean containsAll(Collection c)
  {
    return getSequenceModelAspect().containsAll(c);
  }

  public Object get(int index)
  {
    return getSequenceModelAspect().get(index);
  }

  public int indexOf(Object o)
  {
    return getSequenceModelAspect().indexOf(o);
  }

  public boolean isEmpty()
  {
    return getSequenceModelAspect().isEmpty();
  }

  public Iterator iterator()
  {
    return getSequenceModelAspect().iterator();
  }

  public int lastIndexOf(Object o)
  {
    return getSequenceModelAspect().lastIndexOf(o);
  }

  public ListIterator listIterator()
  {
    return getSequenceModelAspect().listIterator();
  }

  public ListIterator listIterator(int index)
  {
    return getSequenceModelAspect().listIterator(index);
  }

  public boolean remove(Object o)
  {
    return getSequenceModelAspect().remove(o);
  }

  public Object remove(int index)
  {
    return getSequenceModelAspect().remove(index);
  }

  public boolean removeAll(Collection c)
  {
    return getSequenceModelAspect().removeAll(c);
  }

  public boolean retainAll(Collection c)
  {
    return getSequenceModelAspect().retainAll(c);
  }

  public Object set(int index, Object element)
  {
    return getSequenceModelAspect().set(index, element);
  }

  public int size()
  {
    return getSequenceModelAspect().size();
  }

  public List subList(int fromIndex, int toIndex)
  {
    return getSequenceModelAspect().subList(fromIndex, toIndex);
  }

  public Object[] toArray()
  {
    return getSequenceModelAspect().toArray();
  }

  public Object[] toArray(Object[] a)
  {
    return getSequenceModelAspect().toArray(a);
  }

  public void onAdd(int index, Object item)
  {
  }

  public void onMove(int fromIndex, int toIndex)
  {
  }

  public void onRemove(int index, Object item)
  {
  }

  public void onSet(int index, Object newItem, Object oldItem)
  {
  }

  public Object onVerify(int index, Object newItem)
  {
    return newItem;
  }
}
