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


import org.eclipse.net4j.examples.mvc.IAdapter;
import org.eclipse.net4j.examples.mvc.aspect.IEnablementViewAspect;
import org.eclipse.net4j.examples.mvc.aspect.IFocusViewAspect;
import org.eclipse.net4j.examples.mvc.aspect.IMetaDataAspect;
import org.eclipse.net4j.examples.mvc.aspect.IMouseButtonViewAspect;
import org.eclipse.net4j.examples.mvc.aspect.IMouseMovementViewAspect;
import org.eclipse.net4j.examples.mvc.aspect.IMouseTrackingViewAspect;
import org.eclipse.net4j.examples.mvc.aspect.ISelectionViewAspect;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;


public class ButtonViewAdapter extends AbstractSelectionAdapter
{
  private String[] items = {"false", "true"};

  private boolean released;

  public ButtonViewAdapter(Factory factory)
  {
    super(factory);
  }

  public Button getButtonControl()
  {
    return (Button)getTarget();
  }

  public void add(String string, int index)
  {
    throw new UnsupportedOperationException("Button does only support 2 items");
  }

  public void add(String string)
  {
    throw new UnsupportedOperationException("Button does only support 2 items");
  }

  public void deselect(int index)
  {
    checkIndexArgument(index);
    select(1 - index);
  }

  public void deselect(int start, int end)
  {
    throw new UnsupportedOperationException("Button does not support multiple selection");
  }

  public void deselect(int[] indices)
  {
    throw new UnsupportedOperationException("Button does not support multiple selection");
  }

  public void deselectAll()
  {
    throw new UnsupportedOperationException("Button does not support multiple selection");
  }

  public String getItem(int index)
  {
    checkIndexArgument(index);
    return items[index];
  }

  public int getItemCount()
  {
    return items.length;
  }

  public int getItemHeight()
  {
    return getButtonControl().getSize().y;
  }

  public String[] getItems()
  {
    return items;
  }

  public String[] getSelection()
  {
    return new String[] {items[getSelectionIndex()]};
  }

  public int getSelectionCount()
  {
    return 1;
  }

  public int getSelectionIndex()
  {
    return getButtonControl().getSelection() ? 1 : 0;
  }

  public int[] getSelectionIndices()
  {
    return new int[] {getSelectionIndex()};
  }

  public int getFocusIndex()
  {
    if (!getButtonControl().isFocusControl())
    {
      return -1;
    }

    return getSelectionIndex();
  }

  public int getTopIndex()
  {
    return 0;
  }

  public int getVisibleItemCount()
  {
    return 1;
  }

  public int indexOf(String string)
  {
    return indexOf(string, 0);
  }

  public int indexOf(String string, int start)
  {
    if (string == null)
    {
      throw new IllegalArgumentException("string == null");
    }

    if (start <= 0 && string.equals(items[0]))
    {
      return 0;
    }

    if (start <= 1 && string.equals(items[1]))
    {
      return 1;
    }

    return -1;
  }

  public boolean isSelected(int index)
  {
    return index == getSelectionIndex();
  }

  public void remove(int index)
  {
    throw new UnsupportedOperationException("Button does only support 2 items");
  }

  public void remove(int start, int end)
  {
    throw new UnsupportedOperationException("Button does only support 2 items");
  }

  public void remove(int[] indices)
  {
    throw new UnsupportedOperationException("Button does only support 2 items");
  }

  public void remove(String string)
  {
    throw new UnsupportedOperationException("Button does only support 2 items");
  }

  public void removeAll()
  {
    throw new UnsupportedOperationException("Button does only support 2 items");
  }

  public void select(int index)
  {
    checkIndexArgument(index);
    getButtonControl().setEnabled(index != 0);
  }

  public void select(int start, int end)
  {
    throw new UnsupportedOperationException("Button does not support multiple selection");
  }

  public void select(int[] indices)
  {
    throw new UnsupportedOperationException("Button does not support multiple selection");
  }

  public void selectAll()
  {
    throw new UnsupportedOperationException("Button does not support multiple selection");
  }

  public void setItem(int index, String string)
  {
    checkIndexArgument(index);
    items[index] = string;
  }

  public void setItems(String[] items)
  {
    if (items == null)
    {
      throw new IllegalArgumentException("items == null");
    }

    if (items.length != 2)
    {
      throw new IllegalArgumentException("items.length != 2");
    }

    this.items = items;
  }

  public void setSelection(int index)
  {
    select(index);
  }

  public void setSelection(int start, int end)
  {
    select(start, end);
  }

  public void setSelection(int[] indices)
  {
    throw new UnsupportedOperationException("Button does not support multiple selection");
  }

  public void setSelection(String[] items)
  {
    throw new UnsupportedOperationException("Button does not support multiple selection");
  }

  public void setTopIndex(int index)
  {
  }

  public void setVisibleItemCount(int count)
  {
  }

  public void showSelection()
  {
  }

  public boolean onSelection(Object item, int detail, int x, int y, int width, int height,
          int stateMask, boolean doit)
  {
    try
    {
      if (released)
      {
        return super.onSelection(item, detail, x, y, width, height, stateMask, doit);
      }
      else
      {
        return false;
      }
    }
    finally
    {
      released = !released;
    }
  }

  protected void connectTarget(Class viewAspect)
  {
    super.connectTarget(viewAspect);

    if (viewAspect == ISelectionViewAspect.class)
    {
      getButtonControl().addSelectionListener(this);
    }
  }

  protected void disconnectTarget(Class viewAspect)
  {
    if (!getTarget().isDisposed())
    {
      if (viewAspect == ISelectionViewAspect.class)
      {
        getButtonControl().removeSelectionListener(this);
      }
    }

    super.disconnectTarget(viewAspect);
  }

  public static class Factory extends AbstractFactory<Control>
  {
    private static final Class[] ASPECTS = {IMetaDataAspect.class, IEnablementViewAspect.class,
            IFocusViewAspect.class, IMouseButtonViewAspect.class, IMouseTrackingViewAspect.class,
            IMouseMovementViewAspect.class, ISelectionViewAspect.class};

    private static final Class[] ADAPTABLE_CLASSES = {Button.class};

    public IAdapter<Control> createAdapter()
    {
      return new ButtonViewAdapter(this);
    }

    public Class[] getAspects()
    {
      return ASPECTS;
    }

    public Class[] getAdaptableClasses()
    {
      return ADAPTABLE_CLASSES;
    }
  }
}
