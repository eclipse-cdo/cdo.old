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
package org.eclipse.emf.ecore.util;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

public class EcoreEMap<K, V> extends BasicEMap<K, V> implements InternalEList.Unsettable<Map.Entry<K, V>>,
    EStructuralFeature.Setting
{
  private static final long serialVersionUID = 1L;

  public static class Unsettable<K, V> extends EcoreEMap<K, V>
  {
    private static final long serialVersionUID = 1L;

    public Unsettable(EClass entryEClass, Class<?> entryClass, InternalEObject owner, int featureID)
    {
      super(entryEClass, entryClass, null);
      delegateEList = new UnsettableDelegateEObjectContainmentEList<Entry<K, V>>(entryClass, owner, featureID);
    }

    protected class UnsettableDelegateEObjectContainmentEList<E extends Object & Entry<K, V>> extends
        DelegateEObjectContainmentEList<E>
    {
      private static final long serialVersionUID = 1L;

      protected boolean isSet;

      public UnsettableDelegateEObjectContainmentEList(Class<?> dataClass, InternalEObject owner, int featureID)
      {
        super(dataClass, owner, featureID);
      }

      @Override
      protected void didChange()
      {
        isSet = true;
      }

      @Override
      public boolean isSet()
      {
        return isSet;
      }

      @Override
      public void unset()
      {
        super.unset();
        if (isNotificationRequired())
        {
          boolean oldIsSet = isSet;
          isSet = false;
          owner.eNotify(createNotification(Notification.UNSET, oldIsSet, false));
        }
        else
        {
          isSet = false;
        }
      }
    }
  }

  protected EClass entryEClass;

  protected Class<?> entryClass;

  public EcoreEMap(EClass entryEClass, Class<?> entryClass, InternalEObject owner, int featureID)
  {
    this.entryClass = entryClass;
    this.entryEClass = entryEClass;
    delegateEList = new DelegateEObjectContainmentEList<Entry<K, V>>(entryClass, owner, featureID);
  }

  public EcoreEMap(EClass entryEClass, Class<?> entryClass, EList<Entry<K, V>> delegateEList)
  {
    this.entryClass = entryClass;
    this.entryEClass = entryEClass;
    this.delegateEList = delegateEList;
  }

  @Override
  protected void initializeDelegateEList()
  {
    // Do nothing.
  }

  protected class DelegateEObjectContainmentEList<E extends Object & Entry<K, V>> extends EObjectContainmentEList<E>
  {
    private static final long serialVersionUID = 1L;

    public DelegateEObjectContainmentEList(Class<?> entryClass, InternalEObject owner, int featureID)
    {
      super(entryClass, owner, featureID);
    }

    @Override
    protected void didAdd(int index, E newObject)
    {
      EcoreEMap.this.doPut(newObject);
    }

    @Override
    protected void didSet(int index, E newObject, E oldObject)
    {
      didRemove(index, oldObject);
      didAdd(index, newObject);
    }

    @Override
    protected void didRemove(int index, E oldObject)
    {
      EcoreEMap.this.doRemove(oldObject);
    }

    @Override
    protected void didClear(int size, Object[] oldObjects)
    {
      EcoreEMap.this.doClear();
    }

    @Override
    protected void didMove(int index, E movedObject, int oldIndex)
    {
      EcoreEMap.this.doMove(movedObject);
    }
  }

  @Override
  protected BasicEList<Entry<K, V>> newList()
  {
    return new BasicEList<Entry<K, V>>()
    {
      private static final long serialVersionUID = 1L;

      @Override
      public Object[] newData(int listCapacity)
      {
        return (Object[])Array.newInstance(entryClass, listCapacity);
      }
    };
  }

  @Override
  protected Entry<K, V> newEntry(int hash, K key, V value)
  {
    @SuppressWarnings("unchecked")
    Entry<K, V> entry = (Entry<K, V>)entryEClass.getEPackage().getEFactoryInstance().create(entryEClass);
    entry.setHash(hash);
    entry.setKey(key);
    entry.setValue(value);
    return entry;
  }

  public Entry<K, V> basicGet(int index)
  {
    return ((InternalEList<Entry<K, V>>)delegateEList).basicGet(index);
  }

  @SuppressWarnings("unchecked")
  public List<Map.Entry<K, V>> basicList()
  {
    return ((InternalEList<Map.Entry<K, V>>)(InternalEList<?>)delegateEList).basicList();
  }

  /**
   * Returns an iterator that yields unresolved values.
   */
  @SuppressWarnings("unchecked")
  public Iterator<Map.Entry<K, V>> basicIterator()
  {
    return ((InternalEList<Map.Entry<K, V>>)(InternalEList<?>)delegateEList).basicIterator();
  }

  /**
   * Returns a list iterator that yields unresolved values.
   */
  @SuppressWarnings("unchecked")
  public ListIterator<Map.Entry<K, V>> basicListIterator()
  {
    return ((InternalEList<Map.Entry<K, V>>)(InternalEList<?>)delegateEList).basicListIterator();
  }

  /**
   * Returns a list iterator that yields unresolved values.
   */
  @SuppressWarnings("unchecked")
  public ListIterator<Map.Entry<K, V>> basicListIterator(int index)
  {
    return ((InternalEList<Map.Entry<K, V>>)(InternalEList<?>)delegateEList).basicListIterator(index);
  }

  /**
   * Remove the object with without updating the inverse.
   */
  public NotificationChain basicRemove(Object object, NotificationChain notifications)
  {
    return ((InternalEList<?>)delegateEList).basicRemove(object, notifications);
  }

  /**
   * Add the object without updating the inverse.
   */
  @SuppressWarnings("unchecked")
  public NotificationChain basicAdd(Map.Entry<K, V> object, NotificationChain notifications)
  {
    return ((InternalEList<Map.Entry<K, V>>)(InternalEList<?>)delegateEList).basicAdd(object, notifications);
  }

  /**
   * Add the object without verifying uniqueness.
   */
  @SuppressWarnings("unchecked")
  public void addUnique(Map.Entry<K, V> object)
  {
    ((InternalEList<Map.Entry<K, V>>)(InternalEList<?>)delegateEList).addUnique(object);
  }

  /**
   * Add the object without verifying uniqueness.
   */
  @SuppressWarnings("unchecked")
  public void addUnique(int index, Map.Entry<K, V> object)
  {
    ((InternalEList<Map.Entry<K, V>>)(InternalEList<?>)delegateEList).addUnique(index, object);
  }

  /**
   * Set the object without verifying uniqueness.
   */
  @SuppressWarnings("unchecked")
  public Map.Entry<K, V> setUnique(int index, Map.Entry<K, V> object)
  {
    return ((InternalEList<Map.Entry<K, V>>)(InternalEList<?>)delegateEList).setUnique(index, object);
  }

  public EObject getEObject()
  {
    return ((EStructuralFeature.Setting)delegateEList).getEObject();
  }

  public EStructuralFeature getEStructuralFeature()
  {
    return ((EStructuralFeature.Setting)delegateEList).getEStructuralFeature();
  }

  public Object get(boolean resolve)
  {
    return ((EStructuralFeature.Setting)delegateEList).get(resolve);
  }

  public void set(Object value)
  {
    if (value instanceof Map)
    {
      ((EStructuralFeature.Setting)delegateEList).unset();
      @SuppressWarnings("unchecked")
      Map<? extends K, ? extends V> mapValue = (Map<? extends K, ? extends V>)value;
      putAll(mapValue);
    }
    else
    {
      ((EStructuralFeature.Setting)delegateEList).set(value);
    }
  }

  public boolean isSet()
  {
    return ((EStructuralFeature.Setting)delegateEList).isSet();
  }

  public void unset()
  {
    ((EStructuralFeature.Setting)delegateEList).unset();
  }
}
