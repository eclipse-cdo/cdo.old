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
package org.eclipse.net4j.examples.mvc;


import org.eclipse.net4j.examples.mvc.aspect.IMetaDataAspect;

import java.util.Map;
import java.util.Set;


public interface IAdapter<TARGET> extends IMetaDataAspect
{
  public boolean hasAspect(Class aspect);

  public Class[] getAspects();

  public void addBinding(IBinding<TARGET> binding);

  /**
   * 
   * @param binding
   * @return true, if this IAdapter has no more bindings after removal
   */
  public boolean removeBinding(IBinding<TARGET> binding);

  public TARGET getTarget();

  public void setTarget(TARGET target);

  /**
   * 
   */
  public static interface Factory<TARGET>
  {
    public Manager<TARGET> getAdapterManager();

    public Class[] getAspects();

    public Class[] getAdaptableClasses();

    public IAdapter<TARGET> createAdapter();
  }

  /**
   * 
   */
  public static interface Manager<TARGET>
  {
    public boolean hasAspect(Class aspect);

    public Class[] getAspects();

    public Set<IAdapter.Factory<TARGET>> getAdapterFactories(Class aspect);

    public Map<TARGET, IAdapter<TARGET>> getAdapters(Class aspect);

    public void addAdapterFactory(IAdapter.Factory<TARGET> adapterFactory);

    public void removeAdapterFactory(IAdapter.Factory<TARGET> adapterFactory);

    public IAdapter<TARGET> adapt(Class aspect, TARGET target);

    public void removeAdapter(TARGET target);
  }
}
