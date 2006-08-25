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
import org.eclipse.net4j.examples.mvc.IBinding;
import org.eclipse.net4j.examples.mvc.util.AbstractAspectDataMap;
import org.eclipse.net4j.examples.mvc.util.NoTargetException;
import org.eclipse.net4j.util.StringHelper;

import java.util.HashSet;
import java.util.Set;


public abstract class AbstractAdapter<TARGET> extends
        AbstractAspectDataMap<AdapterAspectData<TARGET>, TARGET> implements IAdapter<TARGET>
{
  private TARGET target;

  public AbstractAdapter(IAdapter.Factory<TARGET> factory)
  {
    Class[] aspects = factory.getAspects();
    for (Class aspect : aspects)
    {
      ensureAspectData(aspect);
    }

  }

  public TARGET getTarget() throws NoTargetException
  {
    return target;
  }

  public void setTarget(TARGET target)
  {
    if (this.target == target)
    {
      return;
    }

    Class[] aspects = getAspects();

    if (this.target != null)
    {
      for (Class aspect : aspects)
      {
        disconnectTarget(aspect);
      }
    }

    this.target = target;

    if (this.target != null)
    {
      for (Class aspect : aspects)
      {
        connectTarget(aspect);
      }
    }

    onRetarget();
  }

  /**
   * 
   * @param aspect
   * @return
   */
  protected Set<IBinding<TARGET>> getBindings(Class aspect)
  {
    AdapterAspectData<TARGET> data = getAspectData(aspect);
    return data.getBindings();
  }

  public void addBinding(IBinding<TARGET> binding)
  {
    Set<IBinding<TARGET>> bindings = getBindings(binding.getAspect());
    bindings.add(binding);

    if (bindings.size() == 1)
    {
      connectTarget(binding.getAspect());
    }
  }

  public boolean removeBinding(IBinding<TARGET> binding)
  {
    Set<IBinding<TARGET>> bindings = getBindings(binding.getAspect());
    bindings.remove(binding);

    if (bindings.size() == 0)
    {
      disconnectTarget(binding.getAspect());

      for (Class aspect : getAspects())
      {
        if (getBindings(aspect).size() > 0)
        {
          return false;
        }
      }

      return true;
    }

    return false;
  }

  public String toString()
  {
    return StringHelper.getSimpleClassName(getClass()) + "(target: " + target + ")";
  }

  protected AdapterAspectData<TARGET> createData()
  {
    return new AdapterAspectData<TARGET>();
  }

  protected void onRetarget()
  {
  }

  protected abstract void connectTarget(Class aspect);

  protected abstract void disconnectTarget(Class aspect);

  public static abstract class AbstractFactory<TARGET> implements IAdapter.Factory<TARGET>
  {
    private Manager<TARGET> adapterManager;

    public Manager<TARGET> getAdapterManager()
    {
      return adapterManager;
    }

    public void setAdapterManager(Manager<TARGET> adapterManager)
    {
      this.adapterManager = adapterManager;
    }
  }
}


class AdapterAspectData<TARGET>
{
  private Set<IBinding<TARGET>> bindings = new HashSet<IBinding<TARGET>>();

  public Set<IBinding<TARGET>> getBindings()
  {
    return bindings;
  }
}
