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

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;


public class ListViewAdapter extends AbstractSelectionAdapter
{
  public ListViewAdapter(Factory factory)
  {
    super(factory);
  }

  public List getListControl()
  {
    return (List)getTarget();
  }

  public void add(String string)
  {
    getListControl().add(string);
  }

  public void add(String string, int index)
  {
    getListControl().add(string, index);
  }

  public void deselect(int index)
  {
    getListControl().deselect(index);
  }

  public void deselect(int start, int end)
  {
    getListControl().deselect(start, end);
  }

  public void deselect(int[] indices)
  {
    getListControl().deselect(indices);
  }

  public void deselectAll()
  {
    getListControl().deselectAll();
  }

  public int getFocusIndex()
  {
    return getListControl().getFocusIndex();
  }

  public String getItem(int index)
  {
    return getListControl().getItem(index);
  }

  public int getItemCount()
  {
    return getListControl().getItemCount();
  }

  public int getItemHeight()
  {
    return getListControl().getItemHeight();
  }

  public String[] getItems()
  {
    return getListControl().getItems();
  }

  public String[] getSelection()
  {
    return getListControl().getSelection();
  }

  public int getSelectionCount()
  {
    return getListControl().getSelectionCount();
  }

  public int getSelectionIndex()
  {
    return getListControl().getSelectionIndex();
  }

  public int[] getSelectionIndices()
  {
    return getListControl().getSelectionIndices();
  }

  public int getTopIndex()
  {
    return getListControl().getTopIndex();
  }

  public int getVisibleItemCount()
  {
    return getListControl().getSize().y / getItemHeight();
  }

  public int indexOf(String string)
  {
    return getListControl().indexOf(string);
  }

  public int indexOf(String string, int start)
  {
    return getListControl().indexOf(string, start);
  }

  public boolean isSelected(int index)
  {
    return getListControl().isSelected(index);
  }

  public void remove(String string)
  {
    getListControl().remove(string);
  }

  public void remove(int index)
  {
    getListControl().remove(index);
  }

  public void remove(int start, int end)
  {
    getListControl().remove(start, end);
  }

  public void remove(int[] indices)
  {
    getListControl().remove(indices);
  }

  public void removeAll()
  {
    getListControl().removeAll();
  }

  public void select(int index)
  {
    getListControl().select(index);
  }

  public void select(int start, int end)
  {
    getListControl().select(start, end);
  }

  public void select(int[] indices)
  {
    getListControl().select(indices);
  }

  public void selectAll()
  {
    getListControl().selectAll();
  }

  public void setItem(int index, String string)
  {
    getListControl().setItem(index, string);
  }

  public void setItems(String[] items)
  {
    getListControl().setItems(items);
  }

  public void setSelection(String[] items)
  {
    getListControl().setSelection(items);
  }

  public void setSelection(int index)
  {
    getListControl().setSelection(index);
  }

  public void setSelection(int start, int end)
  {
    getListControl().setSelection(start, end);
  }

  public void setSelection(int[] indices)
  {
    getListControl().setSelection(indices);
  }

  public void setTopIndex(int index)
  {
    getListControl().setTopIndex(index);
  }

  public void setVisibleItemCount(int count)
  {
  }

  public void showSelection()
  {
    getListControl().showSelection();
  }

  protected void connectTarget(Class viewAspect)
  {
    super.connectTarget(viewAspect);

    if (viewAspect == ISelectionViewAspect.class)
    {
      getListControl().addSelectionListener(this);
    }
  }

  protected void disconnectTarget(Class viewAspect)
  {
    if (!getTarget().isDisposed())
    {
      if (viewAspect == ISelectionViewAspect.class)
      {
        getListControl().removeSelectionListener(this);
      }
    }
    super.disconnectTarget(viewAspect);
  }

  public static class Factory extends AbstractFactory<Control>
  {
    private static final Class[] ASPECTS = {IMetaDataAspect.class, IEnablementViewAspect.class,
            IFocusViewAspect.class, IMouseButtonViewAspect.class, IMouseTrackingViewAspect.class,
            IMouseMovementViewAspect.class, ISelectionViewAspect.class};

    private static final Class[] ADAPTABLE_CLASSES = {List.class};

    public IAdapter<Control> createAdapter()
    {
      return new ListViewAdapter(this);
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
