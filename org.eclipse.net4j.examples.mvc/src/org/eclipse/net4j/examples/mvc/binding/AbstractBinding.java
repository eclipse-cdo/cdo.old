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
import org.eclipse.net4j.examples.mvc.IBinding;
import org.eclipse.net4j.examples.mvc.IController;
import org.eclipse.net4j.util.StringHelper;


public abstract class AbstractBinding<TARGET> implements IBinding<TARGET>
{
  private IController<TARGET> controller;

  private String targetName;

  private IAdapter<TARGET> adapter;

  public AbstractBinding(IController<TARGET> controller, String targetName)
  {
    this.controller = controller;
    this.targetName = targetName;

    controller.addBinding(this);
  }

  public IController<TARGET> getController()
  {
    return controller;
  }

  public String getTargetName()
  {
    return targetName;
  }

  public TARGET getTarget()
  {
    return adapter == null ? null : adapter.getTarget();
  }

  public TARGET setTarget(TARGET target)
  {
    TARGET oldTarget = adapter == null ? null : adapter.getTarget();

    if (target == oldTarget)
    {
      return target;
    }

    if (oldTarget != null)
    {
      adapter.removeBinding(this);
    }

    if (target != null)
    {
      adapter = controller.adapt(getAspect(), target);
      adapter.addBinding(this);
    }

    return oldTarget;
  }

  public IAdapter<TARGET> getAdapter()
  {
    return adapter;
  }

  public Object[] getMetaDataKeys()
  {
    return adapter.getMetaDataKeys();
  }

  public Object getMetaData(Object key)
  {
    return adapter.getMetaData(key);
  }

  public String toString()
  {
    return StringHelper.getSimpleClassName(getClass()) + "(aspect: "
            + StringHelper.getSimpleClassName(getAspect()) + ", adapter: " + adapter + ")";
  }
}
