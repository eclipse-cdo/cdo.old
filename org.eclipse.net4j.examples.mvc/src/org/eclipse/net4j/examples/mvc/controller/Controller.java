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
package org.eclipse.net4j.examples.mvc.controller;


import org.eclipse.net4j.examples.mvc.IAdapter;
import org.eclipse.net4j.examples.mvc.IBinding;
import org.eclipse.net4j.examples.mvc.IController;
import org.eclipse.net4j.examples.mvc.IAdapter.Manager;
import org.eclipse.net4j.examples.mvc.util.AbstractAspectDataMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Controller<TARGET> extends AbstractAspectDataMap<ControllerAspectData<TARGET>, TARGET>
        implements IController<TARGET>
{
  private IAdapter.Manager<TARGET> adapterManager;

  private String name;

  private Map<String, TARGET> targets = new HashMap<String, TARGET>();

  public Controller(Manager<TARGET> adapterManager, String name)
  {
    this.adapterManager = adapterManager;
    this.name = name;

    Class[] aspects = adapterManager.getAspects();
    for (int i = 0; i < aspects.length; i++)
    {
      ensureAspectData(aspects[i]);
    }
  }

  public IAdapter.Manager<TARGET> getAdapterManager()
  {
    return adapterManager;
  }

  /**
   * 
   * @param aspect
   * @return
   */
  public Set<IBinding<TARGET>> getBindings(Class aspect)
  {
    ControllerAspectData<TARGET> data = getAspectData(aspect);
    return data.getBindings();
  }

  /**
   * 
   * @param binding
   */
  public void addBinding(IBinding<TARGET> binding)
  {
    getBindings(binding).add(binding);

    String targetName = binding.getTargetName();
    TARGET target = getTarget(targetName);

    if (target != null)
    {
      retargetBingings(targetName, target);
    }
  }

  public boolean mayClose()
  {
    return true;
  }

  public void dispose()
  {
    Class[] aspects = adapterManager.getAspects();
    for (int i = 0; i < aspects.length; i++)
    {
      Set<IBinding<TARGET>> bindings = getBindings(aspects[i]);
      IBinding[] array = bindings.toArray(new IBinding[bindings.size()]);

      for (int j = 0; j < array.length; j++)
      {
        IBinding binding = array[j];
        IAdapter<TARGET> adapter = binding.getAdapter();

        if (adapter != null && adapter.removeBinding(binding))
        {
          adapterManager.removeAdapter(adapter.getTarget());
        }

        removeBinding(binding);
      }
    }
  }

  /**
   * 
   * @param binding
   */
  public void removeBinding(IBinding<TARGET> binding)
  {
    getBindings(binding).remove(binding);
  }

  /**
   * 
   * @param aspect
   * @param target
   * @return
   */
  public IAdapter<TARGET> adapt(Class aspect, TARGET target)
  {
    return getAdapterManager().adapt(aspect, target);
  }

  public TARGET putTarget(String name, TARGET target)
  {
    TARGET oldTarget = targets.put(name, target);

    if (target == oldTarget)
    {
      return target;
    }

    retargetBingings(name, target);
    onRetarget(name, target, oldTarget);
    return oldTarget;
  }

  protected void onRetarget(String name, TARGET newTarget, TARGET oldTarget)
  {
  }

  private void retargetBingings(String targetName, TARGET target)
  {
    Class[] aspects = adapterManager.getAspects();
    for (int i = 0; i < aspects.length; i++)
    {
      Set<IBinding<TARGET>> bindings = getBindings(aspects[i]);
      for (IBinding<TARGET> binding : bindings)
      {
        if (binding.getTargetName().equals(targetName))
        {
          binding.setTarget(target);
        }
      }
    }
  }

  public TARGET removeTarget(String name)
  {
    return targets.remove(name);
  }

  public TARGET getTarget(String name)
  {
    return targets.get(name);
  }

  public Map<String, TARGET> getTargets()
  {
    return targets;
  }

  protected ControllerAspectData<TARGET> createData()
  {
    return new ControllerAspectData<TARGET>();
  }

  /**
   * 
   * @param binding
   * @return
   */
  private Set<IBinding<TARGET>> getBindings(IBinding<TARGET> binding)
  {
    Class aspect = binding.getAspect();
    return getBindings(aspect);
  }

  public String getName()
  {
    return name;
  }

  public void afterTargetsSet()
  {
  }
}


class ControllerAspectData<TARGET>
{
  private Set<IBinding<TARGET>> bindings = new HashSet<IBinding<TARGET>>();

  public Set<IBinding<TARGET>> getBindings()
  {
    return bindings;
  }
}
