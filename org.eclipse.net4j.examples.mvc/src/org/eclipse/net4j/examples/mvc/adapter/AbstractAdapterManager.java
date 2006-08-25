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
import org.eclipse.net4j.examples.mvc.IAdapter.Factory;
import org.eclipse.net4j.examples.mvc.IAdapter.Manager;
import org.eclipse.net4j.examples.mvc.util.AbstractAspectDataMap;
import org.eclipse.net4j.examples.mvc.util.AmbiguousFactoriesException;
import org.eclipse.net4j.examples.mvc.util.MissingFactoryException;
import org.eclipse.net4j.examples.mvc.util.Pair;
import org.eclipse.net4j.util.BeanHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public abstract class AbstractAdapterManager<TARGET> extends
        AbstractAspectDataMap<ManagerAspectData<TARGET>, TARGET> implements Manager<TARGET>
{
  /**
   * 
   * @param aspect
   * @return
   */
  public Set<IAdapter.Factory<TARGET>> getAdapterFactories(Class aspect)
  {
    ManagerAspectData<TARGET> data = getAspectData(aspect);
    return data.getAdapterFactories();
  }

  /**
   * 
   * @param aspect
   * @return
   */
  public Map<TARGET, IAdapter<TARGET>> getAdapters(Class aspect)
  {
    ManagerAspectData<TARGET> data = getAspectData(aspect);
    return data.getAdapters();
  }

  public void addAdapterFactory(Factory<TARGET> adapterFactory)
  {
    for (Class aspect : adapterFactory.getAspects())
    {
      ManagerAspectData<TARGET> data = ensureAspectData(aspect);
      data.getAdapterFactories().add(adapterFactory);
    }
  }

  public void removeAdapterFactory(Factory<TARGET> adapterFactory)
  {
    for (Class aspect : adapterFactory.getAspects())
    {
      getAdapterFactories(aspect).remove(adapterFactory);
    }
  }

  /**
   * 
   * @param aspect
   * @param target
   * @return
   */
  public IAdapter<TARGET> adapt(Class aspect, TARGET target)
  {
    Map<TARGET, IAdapter<TARGET>> adapters = getAdapters(aspect);
    IAdapter<TARGET> adapter = adapters.get(target);

    if (adapter == null)
    {
      adapter = createAdapter(aspect, target);

      for (Class a : adapter.getAspects())
      {
        getAdapters(a).put(target, adapter);
      }
    }

    return adapter;
  }

  /**
   * 
   * @param target
   */
  public void removeAdapter(TARGET target)
  {
    for (Class a : getAspects())
    {
      getAdapters(a).remove(target);
    }
  }

  /**
   * 
   * @param aspect
   * @param target
   * @return
   * @throws AmbiguousFactoriesException
   * @throws MissingFactoryException
   */
  protected IAdapter<TARGET> createAdapter(Class aspect, TARGET target)
          throws AmbiguousFactoriesException, MissingFactoryException
  {
    IAdapter.Factory<TARGET> factory = getFactory(aspect, target.getClass());
    IAdapter<TARGET> adapter = factory.createAdapter();
    adapter.setTarget(target);
    return adapter;
  }

  protected Factory<TARGET> getFactory(Class aspect, Class targetClass)
  {
    Set<IAdapter.Factory<TARGET>> allFactories = getAdapterFactories(aspect);
    List<Pair<Class, IAdapter.Factory<TARGET>>> possibleFactories = new ArrayList<Pair<Class, IAdapter.Factory<TARGET>>>();

    for (IAdapter.Factory<TARGET> factory : allFactories)
    {
      Class[] adaptableClasses = factory.getAdaptableClasses();
      for (int i = 0; i < adaptableClasses.length; i++)
      {
        Class adaptableClass = adaptableClasses[i];

        if (adaptableClass.isAssignableFrom(targetClass))
        {
          possibleFactories.add(new Pair<Class, IAdapter.Factory<TARGET>>(adaptableClass, factory));
        }
      }
    }

    if (possibleFactories.size() == 0)
    {
      throw new MissingFactoryException(aspect, targetClass);
    }

    if (possibleFactories.size() == 1)
    {
      return possibleFactories.iterator().next().getSecond();
    }
    else
    {
      return resolveAmbiguousFactories(possibleFactories);
    }
  }

  /**
   * 
   * @param possibleFactories
   * @return
   * @throws AmbiguousFactoriesException
   */
  protected IAdapter.Factory<TARGET> resolveAmbiguousFactories(
          List<Pair<Class, IAdapter.Factory<TARGET>>> possibleFactories)
  {
    Class[] array = new Class[possibleFactories.size()];
    int i = 0;

    for (Pair<Class, IAdapter.Factory<TARGET>> pair : possibleFactories)
    {
      array[i++] = pair.getFirst();
    }

    try
    {
      Class result = BeanHelper.mostSpecificClass(array);

      for (Pair<Class, IAdapter.Factory<TARGET>> pair : possibleFactories)
      {
        if (pair.getFirst() == result)
        {
          return pair.getSecond();
        }
      }
    }
    catch (Exception ignore)
    {
    }

    return null;
  }

  protected ManagerAspectData<TARGET> createData()
  {
    return new ManagerAspectData<TARGET>();
  }
}


class ManagerAspectData<TARGET>
{
  private Set<IAdapter.Factory<TARGET>> adapterFactories = new HashSet<IAdapter.Factory<TARGET>>();

  private Map<TARGET, IAdapter<TARGET>> adapters = new HashMap<TARGET, IAdapter<TARGET>>();;

  public Set<IAdapter.Factory<TARGET>> getAdapterFactories()
  {
    return adapterFactories;
  }

  public Map<TARGET, IAdapter<TARGET>> getAdapters()
  {
    return adapters;
  }
}
