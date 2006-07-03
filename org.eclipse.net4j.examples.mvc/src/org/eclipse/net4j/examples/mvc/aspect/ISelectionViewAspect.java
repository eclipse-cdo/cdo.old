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
package org.eclipse.net4j.examples.mvc.aspect;


public interface ISelectionViewAspect
{
  public void add(String string);

  public void add(String string, int index);

  public void deselect(int index);

  public void deselect(int start, int end);

  public void deselect(int[] indices);

  public void deselectAll();

  public String getItem(int index);

  public int getItemCount();

  public int getItemHeight();

  public String[] getItems();

  public String[] getSelection();

  public int getSelectionCount();

  public int getSelectionIndex();

  public String getSelectionText();

  public int[] getSelectionIndices();

  public int getFocusIndex();

  public int getTopIndex();

  public int getVisibleItemCount();

  public int indexOf(String string);

  public int indexOf(String string, int start);

  public boolean isSelected(int index);

  public void remove(int index);

  public void remove(int start, int end);

  public void remove(int[] indices);

  public void remove(String string);

  public void removeAll();

  public void select(int index);

  public void select(int start, int end);

  public void select(int[] indices);

  public void selectAll();

  public void setItem(int index, String string);

  public void setItems(String[] items);

  public void setSelection(int index);

  public void setSelection(int start, int end);

  public void setSelection(int[] indices);

  public void setSelection(String[] items);

  public void setTopIndex(int index);

  public void setVisibleItemCount(int count);

  public void showSelection();

  public boolean onDefaultSelection(Object item, int detail, int x, int y, int width, int height,
          int stateMask, boolean doit);

  public boolean onSelection(Object item, int detail, int x, int y, int width, int height,
          int stateMask, boolean doit);
}
