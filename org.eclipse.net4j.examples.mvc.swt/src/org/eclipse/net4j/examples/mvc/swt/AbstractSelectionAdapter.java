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
package org.eclipse.net4j.examples.mvc.swt;


import org.eclipse.net4j.examples.mvc.IBinding;
import org.eclipse.net4j.examples.mvc.aspect.ISelectionViewAspect;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Control;


public abstract class AbstractSelectionAdapter extends AbstractControlAdapter implements
        ISelectionViewAspect, SelectionListener
{

  public AbstractSelectionAdapter(Factory<Control> factory)
  {
    super(factory);
  }

  public String getSelectionText()
  {
    return getItem(getSelectionIndex());
  }

  public boolean onSelection(final Object item, final int detail, final int x, final int y,
          final int width, final int height, final int stateMask, final boolean doit)
  {
    for (IBinding<Control> binding : getBindings(ISelectionViewAspect.class))
    {
      ((ISelectionViewAspect)binding).onSelection(item, detail, x, y, width, height, stateMask,
              doit);
    }

    return false;
  }

  public boolean onDefaultSelection(final Object item, final int detail, final int x, final int y,
          final int width, final int height, final int stateMask, final boolean doit)
  {
    for (IBinding<Control> binding : getBindings(ISelectionViewAspect.class))
    {
      ((ISelectionViewAspect)binding).onDefaultSelection(item, detail, x, y, width, height,
              stateMask, doit);
    }

    return false;
  }

  public void widgetSelected(SelectionEvent e)
  {
    onSelection(e.item, e.detail, e.x, e.y, e.width, e.height, e.stateMask, e.doit);
  }

  public void widgetDefaultSelected(SelectionEvent e)
  {
    onDefaultSelection(e.item, e.detail, e.x, e.y, e.width, e.height, e.stateMask, e.doit);
  }

  protected void checkIndexArgument(int index)
  {
    if (index < 0 || index >= getItemCount())
    {
      throw new IllegalArgumentException("index: " + index + ", count: " + getItemCount());
    }
  }
}
