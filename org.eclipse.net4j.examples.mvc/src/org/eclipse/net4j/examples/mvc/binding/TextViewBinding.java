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
import org.eclipse.net4j.examples.mvc.aspect.ITextViewAspect;
import org.eclipse.net4j.examples.mvc.util.NoAdapterException;
import org.eclipse.net4j.examples.mvc.util.Point;
import org.eclipse.net4j.examples.mvc.util.Rectangle;


public class TextViewBinding<TARGET> extends AbstractBinding<TARGET> implements ITextViewAspect
{
  public TextViewBinding(IController<TARGET> controller, String targetName)
  {
    super(controller, targetName);
  }

  public Class getAspect()
  {
    return ITextViewAspect.class;
  }

  public ITextViewAspect getTextViewAspect()
  {
    IAdapter<TARGET> adapter = getAdapter();

    if (adapter == null)
    {
      throw new NoAdapterException(this);
    }

    return (ITextViewAspect)adapter;
  }

  public void append(String string)
  {
    getTextViewAspect().append(string);
  }

  public void clearSelection()
  {
    getTextViewAspect().clearSelection();
  }

  public Point computeSize(int wHint, int hHint, boolean changed)
  {
    return getTextViewAspect().computeSize(wHint, hHint, changed);
  }

  public Rectangle computeTrim(int x, int y, int width, int height)
  {
    return getTextViewAspect().computeTrim(x, y, width, height);
  }

  public void copy()
  {
    getTextViewAspect().copy();
  }

  public void cut()
  {
    getTextViewAspect().cut();
  }

  public int getCaretLineNumber()
  {
    return getTextViewAspect().getCaretLineNumber();
  }

  public Point getCaretLocation()
  {
    return getTextViewAspect().getCaretLocation();
  }

  public int getCaretPosition()
  {
    return getTextViewAspect().getCaretPosition();
  }

  public int getCharCount()
  {
    return getTextViewAspect().getCharCount();
  }

  public boolean getDoubleClickEnabled()
  {
    return getTextViewAspect().getDoubleClickEnabled();
  }

  public char getEchoChar()
  {
    return getTextViewAspect().getEchoChar();
  }

  public boolean getEditable()
  {
    return getTextViewAspect().getEditable();
  }

  public int getLineCount()
  {
    return getTextViewAspect().getLineCount();
  }

  public String getLineDelimiter()
  {
    return getTextViewAspect().getLineDelimiter();
  }

  public int getLineHeight()
  {
    return getTextViewAspect().getLineHeight();
  }

  public int getOrientation()
  {
    return getTextViewAspect().getOrientation();
  }

  public int getSelectionCount()
  {
    return getTextViewAspect().getSelectionCount();
  }

  public String getSelectionText()
  {
    return getTextViewAspect().getSelectionText();
  }

  public int getTabs()
  {
    return getTextViewAspect().getTabs();
  }

  public String getText()
  {
    return getTextViewAspect().getText();
  }

  public String getText(int start, int end)
  {
    return getTextViewAspect().getText(start, end);
  }

  public int getTextLimit()
  {
    return getTextViewAspect().getTextLimit();
  }

  public int getTopIndex()
  {
    return getTextViewAspect().getTopIndex();
  }

  public int getTopPixel()
  {
    return getTextViewAspect().getTopPixel();
  }

  public void insert(String string)
  {
    getTextViewAspect().insert(string);
  }

  public void paste()
  {
    getTextViewAspect().paste();
  }

  public void selectAll()
  {
    getTextViewAspect().selectAll();
  }

  public void setDoubleClickEnabled(boolean doubleClick)
  {
    getTextViewAspect().setDoubleClickEnabled(doubleClick);
  }

  public void setEchoChar(char echo)
  {
    getTextViewAspect().setEchoChar(echo);
  }

  public void setEditable(boolean editable)
  {
    getTextViewAspect().setEditable(editable);
  }

  public void setOrientation(int orientation)
  {
    getTextViewAspect().setOrientation(orientation);
  }

  public void setSelection(Point selection)
  {
    getTextViewAspect().setSelection(selection);
  }

  public void setSelection(int start)
  {
    getTextViewAspect().setSelection(start);
  }

  public void setSelection(int start, int end)
  {
    getTextViewAspect().setSelection(start, end);
  }

  public void setTabs(int tabs)
  {
    getTextViewAspect().setTabs(tabs);
  }

  public void setText(String string)
  {
    getTextViewAspect().setText(string);
  }

  public void setTextLimit(int limit)
  {
    getTextViewAspect().setTextLimit(limit);
  }

  public void setTopIndex(int index)
  {
    getTextViewAspect().setTopIndex(index);
  }

  public void showSelection()
  {
    getTextViewAspect().showSelection();
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

  public void onModify()
  {
  }

  public String onVerify(int start, int end, String text, int stateMask)
  {
    return text;
  }
}
