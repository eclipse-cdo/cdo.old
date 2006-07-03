/***************************************************************************
 * Copyright (c) 2004-2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.examples.mvc.adapter;


import org.eclipse.net4j.examples.mvc.IAdapter;
import org.eclipse.net4j.examples.mvc.aspect.IMetaDataAspect;
import org.eclipse.net4j.examples.mvc.aspect.ISequenceModelAspect;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ListSequenceModelAdapter extends AbstractSequenceModelAdapter<List> implements List
{
  public ListSequenceModelAdapter(Factory factory)
  {
    super(factory);
  }

  public List getList()
  {
    return (List)getTarget();
  }

  public Object[] getMetaDataKeys()
  {
    Annotation[] data = getTarget().getClass().getAnnotations();
    Object[] result = new Object[data.length];

    for (int i = 0; i < data.length; i++)
    {
      result[i] = data[i].annotationType();
    }

    return result;
  }

  public Object getMetaData(Object key)
  {
    return getTarget().getClass().getAnnotation((Class)key);
  }

  public boolean add(Object item)
  {
    getList().add(item);
    onAdd(getList().size() - 1, item);
    return true;
  }

  public void add(int index, Object item)
  {
    getList().add(index, item);
    onAdd(index, item);
  }

  public boolean addAll(Collection coll)
  {
    boolean changed = false;

    for (Object item : coll)
    {
      changed |= add(item);
    }

    return changed;
  }

  public boolean addAll(int index, Collection coll)
  {
    for (Object item : coll)
    {
      add(index++, item);
    }

    return true;
  }

  public void clear()
  {
    while (!getList().isEmpty())
    {
      remove(0);
    }
  }

  public boolean contains(Object item)
  {
    return getList().contains(item);
  }

  public boolean containsAll(Collection coll)
  {
    return getList().containsAll(coll);
  }

  public Object get(int index)
  {
    return getList().get(index);
  }

  public int indexOf(Object item)
  {
    return getList().indexOf(item);
  }

  public boolean isEmpty()
  {
    return getList().isEmpty();
  }

  public Iterator iterator()
  {
    return getList().iterator();
  }

  public int lastIndexOf(Object item)
  {
    return getList().lastIndexOf(item);
  }

  public ListIterator listIterator()
  {
    return getList().listIterator();
  }

  public ListIterator listIterator(int index)
  {
    return getList().listIterator(index);
  }

  public boolean remove(Object item)
  {
    int index = indexOf(item);

    if (index == -1)
    {
      return false;
    }

    remove(index);
    return true;
  }

  public Object remove(int index)
  {
    Object item = getList().remove(index);

    if (item != null)
    {
      onRemove(index, item);
    }

    return item;
  }

  public boolean removeAll(Collection coll)
  {
    Object[] items = coll.toArray(new Object[coll.size()]);
    boolean changed = false;

    for (int i = 0; i < items.length; i++)
    {
      Object item = items[i];
      changed |= remove(item);
    }

    return changed;
  }

  public boolean retainAll(Collection coll)
  {
    Object[] items = getList().toArray(new Object[coll.size()]);
    boolean changed = false;

    for (int i = 0; i < items.length; i++)
    {
      Object item = items[i];

      if (!coll.contains(item))
      {
        remove(i);
        changed = true;
      }
    }

    return changed;
  }

  public Object set(int index, Object item)
  {
    Object oldObject = getList().set(index, item);

    if (oldObject == item)
    {
      return false;
    }

    onSet(index, item, oldObject);
    return false;
  }

  public int size()
  {
    return getList().size();
  }

  public List subList(int fromIndex, int toIndex)
  {
    return getList().subList(fromIndex, toIndex);
  }

  public Object[] toArray()
  {
    return getList().toArray();
  }

  public Object[] toArray(Object[] a)
  {
    return getList().toArray(a);
  }

  @Override
  protected void connectTarget(Class aspect)
  {
  }

  @Override
  protected void disconnectTarget(Class aspect)
  {
  }

  public static class Factory extends AbstractFactory<List>
  {
    private static final Class[] ASPECTS = {IMetaDataAspect.class, ISequenceModelAspect.class};

    private static final Class[] ADAPTABLE_CLASSES = {List.class};

    public IAdapter<List> createAdapter()
    {
      return new ListSequenceModelAdapter(this);
    }

    public Class[] getAspects()
    {
      return ASPECTS;
    }

    public Class[] getAdaptableClasses()
    {
      return ADAPTABLE_CLASSES;
    }
  }
}
