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
package org.eclipse.net4j.examples.mvc.adapter;


import org.eclipse.net4j.examples.mvc.IAdapter;
import org.eclipse.net4j.examples.mvc.aspect.IMetaDataAspect;
import org.eclipse.net4j.examples.mvc.aspect.IRecordModelAspect;
import org.eclipse.net4j.examples.mvc.util.IPair;
import org.eclipse.net4j.examples.mvc.util.NoTargetException;
import org.eclipse.net4j.examples.mvc.util.Pair;
import org.eclipse.net4j.examples.mvc.util.ReflectiveInvocationException;
import org.eclipse.net4j.examples.mvc.util.UnknownFieldException;
import org.eclipse.net4j.util.StringHelper;

import org.apache.log4j.Logger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;


public class ReflectiveRecordModelAdapter extends AbstractRecordModelAdapter<Object>
{
  private static final Logger logger = Logger.getLogger(ReflectiveRecordModelAdapter.class);

  private static final Object[] NO_ARGS = new Object[0];

  private Map<String, Pair<Method, Method>> fields;

  private String[] cachedFieldNames;

  public ReflectiveRecordModelAdapter(Factory factory)
  {
    super(factory);
  }

  public String[] getFieldNames() throws NoTargetException
  {
    if (fields == null)
    {
      throw new NoTargetException();
    }

    if (cachedFieldNames == null)
    {
      cachedFieldNames = fields.keySet().toArray(new String[fields.size()]);
    }

    return cachedFieldNames;
  }

  public Class getFieldType(String fieldName)
  {
    return getPair(fieldName).getFirst().getReturnType();
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

  public Object getValue(String fieldName)
  {
    Method getter = getPair(fieldName).getFirst();

    Object result;

    try
    {
      result = getter.invoke(getTarget(), NO_ARGS);
    }
    catch (IllegalArgumentException ex)
    {
      throw ex;
    }
    catch (Exception ex)
    {
      throw new ReflectiveInvocationException(getter);
    }

    if (result instanceof List)
    {
      result = new ListWrapper(fieldName, (List)result);
    }
    else if (result instanceof Collection)
    {
      result = new CollectionWrapper(fieldName, (Collection)result);
    }
    else if (result instanceof Map)
    {
      result = new MapWrapper(fieldName, (Map)result);
    }

    return result;
  }

  public void setValue(String fieldName, Object value)
  {
    Object oldValue = getValue(fieldName);
    Object newValue = onVerify(fieldName, value);

    if (newValue == oldValue)
    {
      return;
    }

    Method setter = getPair(fieldName).getSecond();

    try
    {
      setter.invoke(getTarget(), new Object[] {value});
    }
    catch (IllegalArgumentException ex)
    {
      throw ex;
    }
    catch (Exception ex)
    {
      throw new ReflectiveInvocationException(setter);
    }

    onSet(fieldName, newValue, oldValue);
  }

  @Override
  protected void onRetarget()
  {
    cachedFieldNames = null;

    if (getTarget() == null)
    {
      fields = null;
    }
    else
    {
      initMetaData();
    }
  }

  private IPair<Method, Method> getPair(String fieldName)
  {
    if (fields == null)
    {
      throw new NoTargetException();
    }

    Pair<Method, Method> pair = fields.get(fieldName);

    if (pair == null)
    {
      throw new UnknownFieldException(fieldName);
    }

    return pair;
  }

  private void initMetaData()
  {
    Object target = getTarget();
    if (target == null)
    {
      throw new NoTargetException();
    }

    fields = new HashMap<String, Pair<Method, Method>>();
    for (Method method : target.getClass().getMethods())
    {
      if (method.isAccessible())
      {
        if (method.getReturnType() != void.class && method.getParameterTypes().length == 0)
        {
          if (method.getName().startsWith("is"))
          {
            initMethod("is", method, true);
          }
          else if (method.getName().startsWith("get"))
          {
            initMethod("get", method, true);
          }
        }
        else if (method.getReturnType() == void.class && method.getParameterTypes().length == 1)
        {
          if (method.getName().startsWith("set"))
          {
            initMethod("set", method, false);
          }
        }
      }
    }

    for (Map.Entry<String, Pair<Method, Method>> entry : fields.entrySet())
    {
      if (entry.getValue().getFirst() == null)
      {
        String name = entry.getKey();
        fields.remove(name);
        logger.warn("Dropped field " + name + " due to missing getter");
      }
      else if (entry.getValue().getSecond() != null)
      {
        Class getterType = entry.getValue().getFirst().getReturnType();
        Class setterType = entry.getValue().getSecond().getParameterTypes()[0];

        if (getterType != setterType)
        {
          String name = entry.getKey();
          fields.remove(name);
          logger.warn("Dropped field " + name + " due to ambiguous getter/setter types");
        }
      }
    }
  }

  private void initMethod(String prefix, Method method, boolean isGetter)
  {
    String name = StringHelper.firstToLower(method.getName().substring(prefix.length()));
    Pair<Method, Method> data = fields.get(name);

    if (data == null)
    {
      data = new Pair<Method, Method>();
      fields.put(name, data);
    }

    if (isGetter)
    {
      data.setFirst(method);
    }
    else
    {
      data.setSecond(method);
    }
  }

  public static class Factory extends AbstractFactory<Object>
  {
    private static final Class[] ASPECTS = {IMetaDataAspect.class, IRecordModelAspect.class};

    private static final Class[] ADAPTABLE_CLASSES = {Object.class};

    public IAdapter<Object> createAdapter()
    {
      return new ReflectiveRecordModelAdapter(this);
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

  public class Wrapper
  {
    private String fieldName;

    public Wrapper(String fieldName)
    {
      this.fieldName = fieldName;
    }

    public String getFieldName()
    {
      return fieldName;
    }
  }

  public class CollectionWrapper extends Wrapper implements Collection
  {
    private Collection data;

    public CollectionWrapper(String fieldName, Collection data)
    {
      super(fieldName);
      this.data = data;
    }

    public Collection getCollection()
    {
      return data;
    }

    public boolean add(Object item)
    {
      boolean changed = data.add(item);

      if (changed)
      {
        onAdd(getFieldName(), item);
      }

      return changed;
    }

    public boolean addAll(Collection c)
    {
      boolean changed = false;

      for (Object item : c)
      {
        changed |= add(item);
      }

      return changed;
    }

    public void clear()
    {
      Object[] tmp = data.toArray(new Object[data.size()]);

      data.clear();

      for (int i = 0; i < tmp.length; i++)
      {
        onRemove(getFieldName(), tmp[i]);
      }
    }

    public boolean contains(Object item)
    {
      return data.contains(item);
    }

    public boolean containsAll(Collection c)
    {
      return data.containsAll(c);
    }

    public boolean isEmpty()
    {
      return data.isEmpty();
    }

    public Iterator iterator()
    {
      return data.iterator();
    }

    public boolean remove(Object item)
    {
      boolean changed = data.remove(item);

      if (changed)
      {
        onRemove(getFieldName(), item);
      }

      return changed;
    }

    public boolean removeAll(Collection c)
    {
      boolean changed = false;

      for (Object item : c)
      {
        changed |= remove(item);
      }

      return changed;
    }

    public boolean retainAll(Collection c)
    {
      boolean changed = false;

      for (Object item : data)
      {
        if (!c.contains(item))
        {
          remove(item);
          changed = true;
        }
      }

      return changed;
    }

    public int size()
    {
      return data.size();
    }

    public Object[] toArray()
    {
      return data.toArray();
    }

    public Object[] toArray(Object[] a)
    {
      return data.toArray(a);
    }
  }

  public class ListWrapper extends CollectionWrapper implements List
  {
    public ListWrapper(String fieldName, List data)
    {
      super(fieldName, data);
    }

    public List getList()
    {
      return (List)getCollection();
    }

    public void add(int index, Object element)
    {
      getList().add(index, element);
    }

    public boolean addAll(int index, Collection c)
    {
      return getList().addAll(index, c);
    }

    public Object get(int index)
    {
      return getList().get(index);
    }

    public int indexOf(Object item)
    {
      return getList().indexOf(item);
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

    public Object remove(int index)
    {
      return getList().remove(index);
    }

    public Object set(int index, Object element)
    {
      return getList().set(index, element);
    }

    public List subList(int fromIndex, int toIndex)
    {
      return getList().subList(fromIndex, toIndex);
    }
  }

  public class MapWrapper extends Wrapper implements Map
  {
    private Map data;

    public MapWrapper(String fieldName, Map data)
    {
      super(fieldName);
      this.data = data;
    }

    public Map getMap()
    {
      return data;
    }

    public void clear()
    {
      List<Map.Entry> tmp = new ArrayList<Map.Entry>();

      for (Object object : data.entrySet())
      {
        Map.Entry entry = (Map.Entry)object;
        tmp.add(entry);
      }

      data.clear();

      for (Map.Entry entry : tmp)
      {
        onRemove(getFieldName(), entry.getKey(), entry.getValue());
      }
    }

    public boolean containsKey(Object key)
    {
      return data.containsKey(key);
    }

    public boolean containsValue(Object value)
    {
      return data.containsValue(value);
    }

    public Set entrySet()
    {
      return data.entrySet();
    }

    public Object get(Object key)
    {
      return data.get(key);
    }

    public boolean isEmpty()
    {
      return data.isEmpty();
    }

    public Set keySet()
    {
      return data.keySet();
    }

    public Object put(Object key, Object value)
    {
      Object oldValue = data.put(key, value);

      if (oldValue != null)
      {
        onRemove(getFieldName(), key, oldValue);
      }

      if (value != null)
      {
        onAdd(getFieldName(), key, value);
      }

      return oldValue;
    }

    public void putAll(Map t)
    {
      data.putAll(t);

      for (Object object : t.entrySet())
      {
        Map.Entry entry = (Map.Entry)object;
        onAdd(getFieldName(), entry.getKey(), entry.getValue());
      }
    }

    public Object remove(Object key)
    {
      Object oldValue = data.remove(key);

      if (oldValue != null)
      {
        onRemove(getFieldName(), key, oldValue);
      }

      return oldValue;
    }

    public int size()
    {
      return data.size();
    }

    public Collection values()
    {
      return data.values();
    }
  }
}
