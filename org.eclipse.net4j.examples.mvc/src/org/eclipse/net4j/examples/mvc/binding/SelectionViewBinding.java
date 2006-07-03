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
import org.eclipse.net4j.examples.mvc.aspect.ISelectionViewAspect;
import org.eclipse.net4j.examples.mvc.util.NoAdapterException;


public class SelectionViewBinding<TARGET> extends AbstractBinding<TARGET> implements
        ISelectionViewAspect
{
  public SelectionViewBinding(IController<TARGET> controller, String targetName)
  {
    super(controller, targetName);
  }

  public Class getAspect()
  {
    return ISelectionViewAspect.class;
  }

  public ISelectionViewAspect getSelectionViewAdapter()
  {
    IAdapter<TARGET> adapter = getAdapter();

    if (adapter == null)
    {
      throw new NoAdapterException(this);
    }

    return (ISelectionViewAspect)adapter;
  }

  public void add(String string)
  {
    getSelectionViewAdapter().add(string);
  }

  public void add(String string, int index)
  {
    getSelectionViewAdapter().add(string, index);
  }

  public void deselect(int index)
  {
    getSelectionViewAdapter().deselect(index);
  }

  public void deselect(int start, int end)
  {
    getSelectionViewAdapter().deselect(start, end);
  }

  public void deselect(int[] indices)
  {
    getSelectionViewAdapter().deselect(indices);
  }

  public void deselectAll()
  {
    getSelectionViewAdapter().deselectAll();
  }

  public int getFocusIndex()
  {
    return getSelectionViewAdapter().getFocusIndex();
  }

  public String getItem(int index)
  {
    return getSelectionViewAdapter().getItem(index);
  }

  public int getItemCount()
  {
    return getSelectionViewAdapter().getItemCount();
  }

  public int getItemHeight()
  {
    return getSelectionViewAdapter().getItemHeight();
  }

  public String[] getItems()
  {
    return getSelectionViewAdapter().getItems();
  }

  public String[] getSelection()
  {
    return getSelectionViewAdapter().getSelection();
  }

  public int getSelectionCount()
  {
    return getSelectionViewAdapter().getSelectionCount();
  }

  public int getSelectionIndex()
  {
    return getSelectionViewAdapter().getSelectionIndex();
  }

  public int[] getSelectionIndices()
  {
    return getSelectionViewAdapter().getSelectionIndices();
  }

  public String getSelectionText()
  {
    return getSelectionViewAdapter().getSelectionText();
  }

  public int getTopIndex()
  {
    return getSelectionViewAdapter().getTopIndex();
  }

  public int getVisibleItemCount()
  {
    return getSelectionViewAdapter().getVisibleItemCount();
  }

  public int indexOf(String string)
  {
    return getSelectionViewAdapter().indexOf(string);
  }

  public int indexOf(String string, int start)
  {
    return getSelectionViewAdapter().indexOf(string, start);
  }

  public boolean isSelected(int index)
  {
    return getSelectionViewAdapter().isSelected(index);
  }

  public void remove(String string)
  {
    getSelectionViewAdapter().remove(string);
  }

  public void remove(int index)
  {
    getSelectionViewAdapter().remove(index);
  }

  public void remove(int start, int end)
  {
    getSelectionViewAdapter().remove(start, end);
  }

  public void remove(int[] indices)
  {
    getSelectionViewAdapter().remove(indices);
  }

  public void removeAll()
  {
    getSelectionViewAdapter().removeAll();
  }

  public void select(int index)
  {
    getSelectionViewAdapter().select(index);
  }

  public void select(int start, int end)
  {
    getSelectionViewAdapter().select(start, end);
  }

  public void select(int[] indices)
  {
    getSelectionViewAdapter().select(indices);
  }

  public void selectAll()
  {
    getSelectionViewAdapter().selectAll();
  }

  public void setItem(int index, String string)
  {
    getSelectionViewAdapter().setItem(index, string);
  }

  public void setItems(String[] items)
  {
    getSelectionViewAdapter().setItems(items);
  }

  public void setSelection(String[] items)
  {
    getSelectionViewAdapter().setSelection(items);
  }

  public void setSelection(int index)
  {
    getSelectionViewAdapter().setSelection(index);
  }

  public void setSelection(int start, int end)
  {
    getSelectionViewAdapter().setSelection(start, end);
  }

  public void setSelection(int[] indices)
  {
    getSelectionViewAdapter().setSelection(indices);
  }

  public void setTopIndex(int index)
  {
    getSelectionViewAdapter().setTopIndex(index);
  }

  public void setVisibleItemCount(int count)
  {
    getSelectionViewAdapter().setVisibleItemCount(count);
  }

  public void showSelection()
  {
  }

  public boolean onSelection(Object item, int detail, int x, int y, int width, int height,
          int stateMask, boolean doit)
  {
    return false;
  }

  public boolean onDefaultSelection(Object item, int detail, int x, int y, int width, int height,
          int stateMask, boolean doit)
  {
    return onSelection(item, detail, x, y, width, height, stateMask, doit);
  }
}
