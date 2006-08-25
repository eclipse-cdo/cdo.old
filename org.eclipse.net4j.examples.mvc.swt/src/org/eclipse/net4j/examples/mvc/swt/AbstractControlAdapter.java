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


import org.eclipse.net4j.examples.mvc.IBinding;
import org.eclipse.net4j.examples.mvc.adapter.AbstractAdapter;
import org.eclipse.net4j.examples.mvc.aspect.IEnablementViewAspect;
import org.eclipse.net4j.examples.mvc.aspect.IFocusViewAspect;
import org.eclipse.net4j.examples.mvc.aspect.IMouseButtonViewAspect;
import org.eclipse.net4j.examples.mvc.aspect.IMouseMovementViewAspect;
import org.eclipse.net4j.examples.mvc.aspect.IMouseTrackingViewAspect;

import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractControlAdapter extends AbstractAdapter<Control> implements
        IFocusViewAspect, IEnablementViewAspect, IMouseButtonViewAspect, IMouseMovementViewAspect,
        IMouseTrackingViewAspect, FocusListener, MouseListener, MouseTrackListener,
        MouseMoveListener
// ControlListener,
// HelpListener,
// KeyListener,
// TraverseListener,
{
  public AbstractControlAdapter(Factory<Control> factory)
  {
    super(factory);
  }

  public Object[] getMetaDataKeys()
  {
    try
    {
      Object[] data = (Object[])getTarget().getData();
      List result = new ArrayList();

      for (int i = 0; i < data.length / 2; i++)
      {
        Object key = data[2 * i];

        if (key instanceof String && getTarget().getData((String)key) != null)
        {
          result.add(key);
        }
      }

      return result.toArray(new Object[result.size()]);
    }
    catch (Exception ex)
    {
      return new Object[0];
    }
  }

  public Object getMetaData(Object key)
  {
    return getTarget().getData((String)key);
  }

  public void setFocus()
  {
    getTarget().setFocus();
  }

  public boolean hasFocus()
  {
    return getTarget().isFocusControl();
  }

  public void onFocusLost()
  {
    for (IBinding<Control> binding : getBindings(IFocusViewAspect.class))
    {
      ((IFocusViewAspect)binding).onFocusLost();
    }
  }

  public void onFocusGained()
  {
    for (IBinding<Control> binding : getBindings(IFocusViewAspect.class))
    {
      ((IFocusViewAspect)binding).onFocusGained();
    }
  }

  public void setEnabled(boolean on)
  {
    boolean wasOn = isEnabled();
    getTarget().setEnabled(on);

    if (on && !wasOn)
    {
      onEnabled();
    }
    else if (!on && wasOn)
    {
      onDisabled();
    }
  }

  public boolean isEnabled()
  {
    return getTarget().isEnabled();
  }

  public void onEnabled()
  {
    for (IBinding<Control> binding : getBindings(IEnablementViewAspect.class))
    {
      if (binding != AbstractControlAdapter.this)
      {
        ((IEnablementViewAspect)binding).onEnabled();
      }
    }
  }

  public void onDisabled()
  {
    for (IBinding<Control> binding : getBindings(IEnablementViewAspect.class))
    {
      if (binding != AbstractControlAdapter.this)
      {
        ((IEnablementViewAspect)binding).onDisabled();
      }
    }
  }

  public void onMouseDoubleClick(final int button, final int stateMask, final int x, final int y)
  {
    for (IBinding<Control> binding : getBindings(IMouseButtonViewAspect.class))
    {
      ((IMouseButtonViewAspect)binding).onMouseDoubleClick(button, stateMask, x, y);
    }
  }

  public void onMouseDown(final int button, final int stateMask, final int x, final int y)
  {
    for (IBinding<Control> binding : getBindings(IMouseButtonViewAspect.class))
    {
      ((IMouseButtonViewAspect)binding).onMouseDown(button, stateMask, x, y);
    }
  }

  public void onMouseUp(final int button, final int stateMask, final int x, final int y)
  {
    for (IBinding<Control> binding : getBindings(IMouseButtonViewAspect.class))
    {
      ((IMouseButtonViewAspect)binding).onMouseUp(button, stateMask, x, y);
    }
  }

  public void onMouseMove(final int button, final int stateMask, final int x, final int y)
  {
    for (IBinding<Control> binding : getBindings(IMouseMovementViewAspect.class))
    {
      ((IMouseMovementViewAspect)binding).onMouseMove(button, stateMask, x, y);
    }
  }

  public void onMouseEnter(final int button, final int stateMask, final int x, final int y)
  {
    for (IBinding<Control> binding : getBindings(IMouseTrackingViewAspect.class))
    {
      ((IMouseTrackingViewAspect)binding).onMouseHover(button, stateMask, x, y);
    }
  }

  public void onMouseExit(final int button, final int stateMask, final int x, final int y)
  {
    for (IBinding<Control> binding : getBindings(IMouseTrackingViewAspect.class))
    {
      ((IMouseTrackingViewAspect)binding).onMouseHover(button, stateMask, x, y);
    }
  }

  public void onMouseHover(final int button, final int stateMask, final int x, final int y)
  {
    for (IBinding<Control> binding : getBindings(IMouseTrackingViewAspect.class))
    {
      ((IMouseTrackingViewAspect)binding).onMouseHover(button, stateMask, x, y);
    }
  }

  public void focusGained(FocusEvent e)
  {
    onFocusGained();
  }

  public void focusLost(FocusEvent e)
  {
    onFocusLost();
  }

  public void mouseDoubleClick(MouseEvent e)
  {
    onMouseDoubleClick(e.button, e.stateMask, e.x, e.y);
  }

  public void mouseDown(MouseEvent e)
  {
    onMouseDown(e.button, e.stateMask, e.x, e.y);
  }

  public void mouseUp(MouseEvent e)
  {
    onMouseUp(e.button, e.stateMask, e.x, e.y);
  }

  public void mouseEnter(MouseEvent e)
  {
    onMouseEnter(e.button, e.stateMask, e.x, e.y);
  }

  public void mouseExit(MouseEvent e)
  {
    onMouseExit(e.button, e.stateMask, e.x, e.y);
  }

  public void mouseHover(MouseEvent e)
  {
    onMouseHover(e.button, e.stateMask, e.x, e.y);
  }

  public void mouseMove(MouseEvent e)
  {
    onMouseMove(e.button, e.stateMask, e.x, e.y);
  }

  public static Point toSwt(org.eclipse.net4j.examples.mvc.util.Point point)
  {
    return new Point(point.x, point.y);
  }

  public static Rectangle toSwt(org.eclipse.net4j.examples.mvc.util.Rectangle rect)
  {
    return new Rectangle(rect.x, rect.y, rect.width, rect.height);
  }

  public static org.eclipse.net4j.examples.mvc.util.Point fromSwt(Point point)
  {
    return new org.eclipse.net4j.examples.mvc.util.Point(point.x, point.y);
  }

  public static org.eclipse.net4j.examples.mvc.util.Rectangle fromSwt(Rectangle rect)
  {
    return new org.eclipse.net4j.examples.mvc.util.Rectangle(rect.x, rect.y, rect.width,
            rect.height);
  }

  protected void connectTarget(Class viewAspect)
  {
    if (viewAspect == IFocusViewAspect.class)
    {
      getTarget().addFocusListener(this);
    }
    else if (viewAspect == IMouseButtonViewAspect.class)
    {
      getTarget().addMouseListener(this);
    }
    else if (viewAspect == IMouseMovementViewAspect.class)
    {
      getTarget().addMouseMoveListener(this);
    }
    else if (viewAspect == IMouseTrackingViewAspect.class)
    {
      getTarget().addMouseTrackListener(this);
    }
  }

  protected void disconnectTarget(Class viewAspect)
  {
    if (!getTarget().isDisposed())
    {
      if (viewAspect == IFocusViewAspect.class)
      {
        getTarget().removeFocusListener(this);
      }
      else if (viewAspect == IMouseButtonViewAspect.class)
      {
        getTarget().removeMouseListener(this);
      }
      else if (viewAspect == IMouseMovementViewAspect.class)
      {
        getTarget().removeMouseMoveListener(this);
      }
      else if (viewAspect == IMouseTrackingViewAspect.class)
      {
        getTarget().removeMouseTrackListener(this);
      }
    }
  }
}
