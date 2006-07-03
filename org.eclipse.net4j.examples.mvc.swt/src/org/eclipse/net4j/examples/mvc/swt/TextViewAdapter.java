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
import org.eclipse.net4j.examples.mvc.IBinding;
import org.eclipse.net4j.examples.mvc.aspect.IEnablementViewAspect;
import org.eclipse.net4j.examples.mvc.aspect.IFocusViewAspect;
import org.eclipse.net4j.examples.mvc.aspect.IMetaDataAspect;
import org.eclipse.net4j.examples.mvc.aspect.IMouseButtonViewAspect;
import org.eclipse.net4j.examples.mvc.aspect.IMouseMovementViewAspect;
import org.eclipse.net4j.examples.mvc.aspect.IMouseTrackingViewAspect;
import org.eclipse.net4j.examples.mvc.aspect.ITextViewAspect;
import org.eclipse.net4j.examples.mvc.util.Point;
import org.eclipse.net4j.examples.mvc.util.Rectangle;

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;


public class TextViewAdapter extends AbstractControlAdapter implements ITextViewAspect,
        ModifyListener, SelectionListener, VerifyListener
{
  public TextViewAdapter(Factory factory)
  {
    super(factory);
  }

  public Text getTextControl()
  {
    return (Text)getTarget();
  }

  public void append(String string)
  {
    getTextControl().append(string);
  }

  public void clearSelection()
  {
    getTextControl().clearSelection();
  }

  public Point computeSize(int wHint, int hHint, boolean changed)
  {
    return fromSwt(getTextControl().computeSize(wHint, hHint, changed));
  }

  public Rectangle computeTrim(int x, int y, int width, int height)
  {
    return fromSwt(getTextControl().computeTrim(x, y, width, height));
  }

  public void copy()
  {
    getTextControl().copy();
  }

  public void cut()
  {
    getTextControl().cut();
  }

  public int getCaretLineNumber()
  {
    return getTextControl().getCaretLineNumber();
  }

  public Point getCaretLocation()
  {
    return fromSwt(getTextControl().getCaretLocation());
  }

  public int getCaretPosition()
  {
    return getTextControl().getCaretPosition();
  }

  public int getCharCount()
  {
    return getTextControl().getCharCount();
  }

  public boolean getDoubleClickEnabled()
  {
    return getTextControl().getDoubleClickEnabled();
  }

  public char getEchoChar()
  {
    return getTextControl().getEchoChar();
  }

  public boolean getEditable()
  {
    return getTextControl().getEditable();
  }

  public int getLineCount()
  {
    return getTextControl().getLineCount();
  }

  public String getLineDelimiter()
  {
    return getTextControl().getLineDelimiter();
  }

  public int getLineHeight()
  {
    return getTextControl().getLineHeight();
  }

  public int getOrientation()
  {
    return getTextControl().getOrientation();
  }

  public Point getSelectionPoint()
  {
    return fromSwt(getTextControl().getSelection());
  }

  public int getSelectionCount()
  {
    return getTextControl().getSelectionCount();
  }

  public String getSelectionText()
  {
    return getTextControl().getSelectionText();
  }

  public int getTabs()
  {
    return getTextControl().getTabs();
  }

  public String getText()
  {
    return getTextControl().getText();
  }

  public String getText(int start, int end)
  {
    return getTextControl().getText(start, end);
  }

  public int getTextLimit()
  {
    return getTextControl().getTextLimit();
  }

  public int getTopIndex()
  {
    return getTextControl().getTopIndex();
  }

  public int getTopPixel()
  {
    return getTextControl().getTopPixel();
  }

  public void insert(String string)
  {
    getTextControl().insert(string);
  }

  public void paste()
  {
    getTextControl().paste();
  }

  public void selectAll()
  {
    getTextControl().selectAll();
  }

  public void setDoubleClickEnabled(boolean doubleClick)
  {
    getTextControl().setDoubleClickEnabled(doubleClick);
  }

  public void setEchoChar(char echo)
  {
    getTextControl().setEchoChar(echo);
  }

  public void setEditable(boolean editable)
  {
    getTextControl().setEditable(editable);
  }

  public void setOrientation(int orientation)
  {
    getTextControl().setOrientation(orientation);
  }

  public void setSelection(Point selection)
  {
    getTextControl().setSelection(toSwt(selection));
  }

  public void setSelection(int start)
  {
    getTextControl().setSelection(start);
  }

  public void setSelection(int start, int end)
  {
    getTextControl().setSelection(start, end);
  }

  public void setTabs(int tabs)
  {
    getTextControl().setTabs(tabs);
  }

  public void setText(String string)
  {
    getTextControl().setText(string == null ? "" : string);
  }

  public void setTextLimit(int limit)
  {
    getTextControl().setTextLimit(limit);
  }

  public void setTopIndex(int index)
  {
    getTextControl().setTopIndex(index);
  }

  public void showSelection()
  {
    getTextControl().showSelection();
  }

  public boolean onSelection(final Object item, final int detail, final int x, final int y,
          final int width, final int height, final int stateMask, final boolean doit)
  {
    for (IBinding<Control> binding : getBindings(ITextViewAspect.class))
    {
      ((ITextViewAspect)binding).onSelection(item, detail, x, y, width, height, stateMask, doit);
    }

    return false;
  }

  public boolean onDefaultSelection(final Object item, final int detail, final int x, final int y,
          final int width, final int height, final int stateMask, final boolean doit)
  {
    for (IBinding<Control> binding : getBindings(ITextViewAspect.class))
    {
      ((ITextViewAspect)binding).onDefaultSelection(item, detail, x, y, width, height, stateMask,
              doit);
    }

    return false;
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

  public void widgetSelected(SelectionEvent e)
  {
    onSelection(e.item, e.detail, e.x, e.y, e.width, e.height, e.stateMask, e.doit);
  }

  public void widgetDefaultSelected(SelectionEvent e)
  {
    onDefaultSelection(e.item, e.detail, e.x, e.y, e.width, e.height, e.stateMask, e.doit);
  }

  public void modifyText(ModifyEvent e)
  {
    onModify();
  }

  public void verifyText(VerifyEvent e)
  {
    e.text = onVerify(e.start, e.end, e.text, e.stateMask);
  }

  protected void connectTarget(Class viewAspect)
  {
    super.connectTarget(viewAspect);

    if (viewAspect == ITextViewAspect.class)
    {
      getTextControl().addSelectionListener(this);
      getTextControl().addModifyListener(this);
      getTextControl().addVerifyListener(this);
    }
  }

  protected void disconnectTarget(Class viewAspect)
  {
    if (!getTarget().isDisposed())
    {
      if (viewAspect == ITextViewAspect.class)
      {
        getTextControl().removeSelectionListener(this);
        getTextControl().removeModifyListener(this);
        getTextControl().removeVerifyListener(this);
      }
    }

    super.disconnectTarget(viewAspect);
  }

  public static class Factory extends AbstractFactory<Control>
  {
    private static final Class[] ASPECTS = {IMetaDataAspect.class, IEnablementViewAspect.class,
            IFocusViewAspect.class, IMouseButtonViewAspect.class, IMouseTrackingViewAspect.class,
            IMouseMovementViewAspect.class, ITextViewAspect.class};

    private static final Class[] ADAPTABLE_CLASSES = {Text.class};

    public IAdapter<Control> createAdapter()
    {
      return new TextViewAdapter(this);
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
