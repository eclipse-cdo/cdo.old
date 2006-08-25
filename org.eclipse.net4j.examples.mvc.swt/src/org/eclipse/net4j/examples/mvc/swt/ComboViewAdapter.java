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
package org.eclipse.net4j.examples.mvc.swt;


import org.eclipse.net4j.examples.mvc.IAdapter;
import org.eclipse.net4j.examples.mvc.IBinding;
import org.eclipse.net4j.examples.mvc.aspect.IEnablementViewAspect;
import org.eclipse.net4j.examples.mvc.aspect.IFocusViewAspect;
import org.eclipse.net4j.examples.mvc.aspect.IMetaDataAspect;
import org.eclipse.net4j.examples.mvc.aspect.IMouseButtonViewAspect;
import org.eclipse.net4j.examples.mvc.aspect.IMouseMovementViewAspect;
import org.eclipse.net4j.examples.mvc.aspect.IMouseTrackingViewAspect;
import org.eclipse.net4j.examples.mvc.aspect.ISelectionViewAspect;
import org.eclipse.net4j.examples.mvc.aspect.ITextViewAspect;
import org.eclipse.net4j.examples.mvc.util.Point;
import org.eclipse.net4j.examples.mvc.util.Rectangle;

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;

import java.util.Arrays;


public class ComboViewAdapter extends AbstractSelectionAdapter implements ITextViewAspect,
        ModifyListener
{
  public ComboViewAdapter(Factory factory)
  {
    super(factory);
  }

  public Combo getComboControl()
  {
    return (Combo)getTarget();
  }

  public void add(String string)
  {
    getComboControl().add(string);
  }

  public void add(String string, int index)
  {
    getComboControl().add(string, index);
  }

  public void deselect(int index)
  {
    getComboControl().deselect(index);
  }

  public void deselect(int start, int end)
  {
    throw new UnsupportedOperationException("Combo does not support multiple selection");
  }

  public void deselect(int[] indices)
  {
    throw new UnsupportedOperationException("Combo does not support multiple selection");
  }

  public void deselectAll()
  {
    getComboControl().deselectAll();
  }

  public int getFocusIndex()
  {
    if (!hasFocus())
    {
      return -1;
    }

    return getSelectionIndex();
  }

  public String getItem(int index)
  {
    return getComboControl().getItem(index);
  }

  public int getItemCount()
  {
    return getComboControl().getItemCount();
  }

  public int getItemHeight()
  {
    return getComboControl().getItemHeight();
  }

  public String[] getItems()
  {
    return getComboControl().getItems();
  }

  public String[] getSelection()
  {
    return new String[] {getSelectionText()};
  }

  public int getSelectionCount()
  {
    return getSelectionIndices().length;
  }

  public int getSelectionIndex()
  {
    return getComboControl().getSelectionIndex();
  }

  public int[] getSelectionIndices()
  {
    int index = getSelectionIndex();

    if (index == -1)
    {
      return new int[0];
    }

    return new int[] {index};
  }

  public int getTopIndex()
  {
    return getSelectionIndex();
  }

  public int getVisibleItemCount()
  {
    return getComboControl().getVisibleItemCount();
  }

  public int indexOf(String string)
  {
    return getComboControl().indexOf(string);
  }

  public int indexOf(String string, int start)
  {
    return getComboControl().indexOf(string, start);
  }

  public boolean isSelected(int index)
  {
    return index == getSelectionIndex();
  }

  public void remove(String string)
  {
    getComboControl().remove(string);
  }

  public void remove(int index)
  {
    getComboControl().remove(index);
  }

  public void remove(int start, int end)
  {
    getComboControl().remove(start, end);
  }

  public void remove(int[] indices)
  {
    if (indices == null)
    {
      throw new IllegalArgumentException("indices == null");
    }

    if (indices.length == 0)
    {
      return;
    }

    Arrays.sort(indices);

    for (int i = 0; i < indices.length; i++)
    {
      remove(indices[i]);

      for (int j = i + 1; j < indices.length; j++)
      {
        --indices[j];
      }
    }
  }

  public void removeAll()
  {
    getComboControl().removeAll();
  }

  public void select(int index)
  {
    getComboControl().select(index);
  }

  public void select(int start, int end)
  {
    throw new UnsupportedOperationException("Combo does not support multiple selection");
  }

  public void select(int[] indices)
  {
    throw new UnsupportedOperationException("Combo does not support multiple selection");
  }

  public void selectAll()
  {
    throw new UnsupportedOperationException("Combo does not support multiple selection");
  }

  public void setItem(int index, String string)
  {
    getComboControl().setItem(index, string);
  }

  public void setItems(String[] items)
  {
    getComboControl().setItems(items);
  }

  public void setSelection(String[] items)
  {
    throw new UnsupportedOperationException("Combo does not support multiple selection");
  }

  public void setSelection(int index)
  {
    select(index);
  }

  public void setSelection(int start, int end)
  {
    throw new UnsupportedOperationException("Combo does not support multiple selection");
  }

  public void setSelection(int[] indices)
  {
    throw new UnsupportedOperationException("Combo does not support multiple selection");
  }

  public void setTopIndex(int index)
  {
  }

  public void setVisibleItemCount(int count)
  {
    getComboControl().setVisibleItemCount(count);
  }

  public void showSelection()
  {
  }

  /*
   * Text methods
   */

  public void append(String string)
  {
    String newText = getText() + string;
    setText(newText);
  }

  public void clearSelection()
  {
    getComboControl().clearSelection();
  }

  public Point computeSize(int wHint, int hHint, boolean changed)
  {
    return fromSwt(getComboControl().computeSize(wHint, hHint, changed));
  }

  public Rectangle computeTrim(int x, int y, int width, int height)
  {
    return fromSwt(getComboControl().computeTrim(x, y, width, height));
  }

  public void copy()
  {
    getComboControl().copy();
  }

  public void cut()
  {
    getComboControl().cut();
  }

  public int getCaretLineNumber()
  {
    return 0;
  }

  public Point getCaretLocation()
  {
    throw new UnsupportedOperationException("Combo does not support caret");
  }

  public int getCaretPosition()
  {
    throw new UnsupportedOperationException("Combo does not support caret");
  }

  public int getCharCount()
  {
    return getText().length();
  }

  public boolean getDoubleClickEnabled()
  {
    return false;
  }

  public char getEchoChar()
  {
    return 0;
  }

  public boolean getEditable()
  {
    return true;
  }

  public int getLineCount()
  {
    return 1;
  }

  public String getLineDelimiter()
  {
    return null;
  }

  public int getLineHeight()
  {
    return getComboControl().getTextHeight();
  }

  public int getOrientation()
  {
    return getComboControl().getOrientation();
  }

  public int getTabs()
  {
    return 0;
  }

  public String getText()
  {
    return getComboControl().getText();
  }

  public String getText(int start, int end)
  {
    return getComboControl().getText().substring(start, end - start);
  }

  public int getTextLimit()
  {
    return getComboControl().getTextLimit();
  }

  public int getTopPixel()
  {
    return 0;
  }

  public void insert(String string)
  {
    // TODO Handle text selection
    append(string);
  }

  public void paste()
  {
    getComboControl().paste();
  }

  public void setDoubleClickEnabled(boolean doubleClick)
  {
  }

  public void setEchoChar(char echo)
  {
    throw new UnsupportedOperationException("Combo does not support echoChar");
  }

  public void setEditable(boolean editable)
  {
    throw new UnsupportedOperationException("Combo does not support editable");
  }

  public void setOrientation(int orientation)
  {
    getComboControl().setOrientation(orientation);
  }

  public void setSelection(Point selection)
  {
    getComboControl().setSelection(toSwt(selection));
  }

  public void setTabs(int tabs)
  {
    throw new UnsupportedOperationException("Combo does not support tabs");
  }

  public void setText(String string)
  {
    getComboControl().setText(string == null ? "" : string);
  }

  public void setTextLimit(int limit)
  {
    getComboControl().setTextLimit(limit);
  }

  public void onModify()
  {
    for (IBinding<Control> binding : getBindings(ITextViewAspect.class))
    {
      ((ITextViewAspect)binding).onModify();
    }
  }

  public String onVerify(int start, int end, String text, int stateMask)
  {
    for (IBinding<Control> binding : getBindings(ITextViewAspect.class))
    {
      text = ((ITextViewAspect)binding).onVerify(start, end, text, stateMask);
    }

    return text;
  }

  public void modifyText(ModifyEvent e)
  {
    onModify();
  }

  /*
   * Control methods
   */

  protected void connectTarget(Class viewAspect)
  {
    super.connectTarget(viewAspect);

    if (viewAspect == ISelectionViewAspect.class)
    {
      getComboControl().addSelectionListener(this);
      getComboControl().addModifyListener(this);
    }
  }

  protected void disconnectTarget(Class viewAspect)
  {
    if (!getTarget().isDisposed())
    {
      if (viewAspect == ISelectionViewAspect.class)
      {
        getComboControl().removeSelectionListener(this);
        getComboControl().removeModifyListener(this);
      }
    }
    super.disconnectTarget(viewAspect);
  }

  public static class Factory extends AbstractFactory<Control>
  {
    private static final Class[] ASPECTS = {IMetaDataAspect.class, IEnablementViewAspect.class,
            IFocusViewAspect.class, IMouseButtonViewAspect.class, IMouseTrackingViewAspect.class,
            IMouseMovementViewAspect.class, ISelectionViewAspect.class, ITextViewAspect.class};

    private static final Class[] ADAPTABLE_CLASSES = {Combo.class};

    public IAdapter<Control> createAdapter()
    {
      return new ComboViewAdapter(this);
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
