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
import org.eclipse.net4j.examples.mvc.aspect.IFocusViewAspect;
import org.eclipse.net4j.examples.mvc.util.NoAdapterException;


public class FocusViewBinding<TARGET> extends AbstractBinding<TARGET> implements IFocusViewAspect
{
  public FocusViewBinding(IController<TARGET> controller, String targetName)
  {
    super(controller, targetName);
  }

  public Class getAspect()
  {
    return IFocusViewAspect.class;
  }

  public IFocusViewAspect getFocusViewAdapter()
  {
    IAdapter<TARGET> adapter = getAdapter();

    if (adapter == null)
    {
      throw new NoAdapterException(this);
    }

    return (IFocusViewAspect)adapter;
  }

  public boolean hasFocus()
  {
    return getFocusViewAdapter().hasFocus();
  }

  public void setFocus()
  {
    getFocusViewAdapter().setFocus();
  }

  public void onFocusGained()
  {
  }

  public void onFocusLost()
  {
  }
}
