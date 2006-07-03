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
package org.eclipse.net4j.examples.mvc.binding;


import org.eclipse.net4j.examples.mvc.IAdapter;
import org.eclipse.net4j.examples.mvc.IController;
import org.eclipse.net4j.examples.mvc.aspect.IEnablementViewAspect;
import org.eclipse.net4j.examples.mvc.util.NoAdapterException;


public class EnablementViewBinding<TARGET> extends AbstractBinding<TARGET> implements
        IEnablementViewAspect
{
  public EnablementViewBinding(IController<TARGET> controller, String targetName)
  {
    super(controller, targetName);
  }

  public Class getAspect()
  {
    return IEnablementViewAspect.class;
  }

  public IEnablementViewAspect getEnablementViewAspect()
  {
    IAdapter<TARGET> adapter = getAdapter();

    if (adapter == null)
    {
      throw new NoAdapterException(this);
    }

    return (IEnablementViewAspect)adapter;
  }

  public void setEnabled(boolean on)
  {
    getEnablementViewAspect().setEnabled(on);
  }

  public boolean isEnabled()
  {
    return getEnablementViewAspect().isEnabled();
  }

  public void onEnabled()
  {
  }

  public void onDisabled()
  {
  }
}
