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
package org.eclipse.emf.cdo.client.ocl;


import org.eclipse.emf.ecore.EClass;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public abstract class AbstractLazyExtentMap implements Map
{
  protected Map delegate;

  protected AbstractLazyExtentMap(Map delegate)
  {
    this.delegate = delegate;
  }

  protected AbstractLazyExtentMap()
  {
    this(new HashMap());
  }

  public void clear()
  {
    delegate.clear();
  }

  public boolean containsKey(Object key)
  {
    return delegate.containsKey(key);
  }

  public boolean containsValue(Object value)
  {
    return delegate.containsValue(value);
  }

  public Set entrySet()
  {
    return delegate.entrySet();
  }

  public boolean equals(Object o)
  {
    return delegate.equals(o);
  }

  public Object get(Object key)
  {
    Object result = delegate.get(key);
    if (result == null && key instanceof EClass)
    {
      EClass eClass = (EClass) key;
      result = queryExtent(eClass);
      delegate.put(eClass, result);
    }

    return result;
  }

  public int hashCode()
  {
    return delegate.hashCode();
  }

  public boolean isEmpty()
  {
    return delegate.isEmpty();
  }

  public Set keySet()
  {
    return delegate.keySet();
  }

  public Object put(Object key, Object value)
  {
    return delegate.put(key, value);
  }

  public void putAll(Map t)
  {
    delegate.putAll(t);
  }

  public Object remove(Object key)
  {
    return delegate.remove(key);
  }

  public int size()
  {
    return delegate.size();
  }

  public Collection values()
  {
    return delegate.values();
  }

  protected abstract Set queryExtent(EClass eClass);
}
