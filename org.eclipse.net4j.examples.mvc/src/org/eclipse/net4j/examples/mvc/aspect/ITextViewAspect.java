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


import org.eclipse.net4j.examples.mvc.util.Point;
import org.eclipse.net4j.examples.mvc.util.Rectangle;


public interface ITextViewAspect
{
  public void append(String string);

  public void clearSelection();

  public Point computeSize(int wHint, int hHint, boolean changed);

  public Rectangle computeTrim(int x, int y, int width, int height);

  public void copy();

  public void cut();

  public int getCaretLineNumber();

  public Point getCaretLocation();

  public int getCaretPosition();

  public int getCharCount();

  public boolean getDoubleClickEnabled();

  public char getEchoChar();

  public boolean getEditable();

  public int getLineCount();

  public String getLineDelimiter();

  public int getLineHeight();

  public int getOrientation();

  public int getSelectionCount();

  public String getSelectionText();

  public int getTabs();

  public String getText();

  public String getText(int start, int end);

  public int getTextLimit();

  public int getTopIndex();

  public int getTopPixel();

  public void insert(String string);

  public void paste();

  public void selectAll();

  public void setDoubleClickEnabled(boolean doubleClick);

  public void setEchoChar(char echo);

  public void setEditable(boolean editable);

  public void setOrientation(int orientation);

  public void setSelection(int start);

  public void setSelection(int start, int end);

  public void setSelection(Point selection);

  public void setTabs(int tabs);

  public void setText(String string);

  public void setTextLimit(int limit);

  public void setTopIndex(int index);

  public void showSelection();

  public boolean onDefaultSelection(Object item, int detail, int x, int y, int width, int height,
          int stateMask, boolean doit);

  public boolean onSelection(Object item, int detail, int x, int y, int width, int height,
          int stateMask, boolean doit);

  public void onModify();

  public String onVerify(int start, int end, String text, int stateMask);
}
