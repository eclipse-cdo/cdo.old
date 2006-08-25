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
package org.eclipse.net4j.examples.mvc;


import java.util.Map;


public interface IController<TARGET>
{
  public IAdapter.Manager<TARGET> getAdapterManager();

  public String getName();

  public boolean hasAspect(Class aspect);

  public Class[] getAspects();

  public IAdapter<TARGET> adapt(Class aspect, TARGET target);

  public void addBinding(IBinding<TARGET> binding);

  public void removeBinding(IBinding<TARGET> binding);

  public TARGET putTarget(String name, TARGET target);

  public TARGET removeTarget(String name);

  public TARGET getTarget(String name);

  public Map<String, TARGET> getTargets();

  public void afterTargetsSet();

  public boolean mayClose();

  public void dispose();
}
