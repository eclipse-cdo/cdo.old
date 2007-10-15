/***************************************************************************
 * Copyright (c) 2004 - 2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.chat.internal.ui;

import org.eclipse.net4j.buddies.internal.ui.views.FacilityPane;
import org.eclipse.net4j.util.ui.actions.SafeAction;
import org.eclipse.net4j.util.ui.widgets.SashComposite;

import org.eclipse.jface.action.IContributionManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

/**
 * @author Eike Stepper
 */
public class ChatPane extends FacilityPane
{
  public ChatPane(Composite parent, int style)
  {
    super(parent, style);
  }

  @Override
  protected Control createUI(Composite parent)
  {
    int height = parent.getFont().getFontData()[0].getHeight();
    Composite composite = new SashComposite(parent, SWT.NONE, height, 80, false)
    {
      @Override
      protected Control createControl1(Composite parent)
      {
        return new Text(parent, SWT.NONE);
      }

      @Override
      protected Control createControl2(Composite parent)
      {
        Text text = new Text(parent, SWT.NONE);
        int height = text.getClientArea().height;
        System.out.println(height);
        return text;
      }
    };

    return composite;
  }

  @Override
  protected void fillCoolBar(IContributionManager manager)
  {
    manager.add(new SafeAction("Test", SharedIcons.getDescriptor(SharedIcons.OBJ_CHAT))
    {
      @Override
      protected void safeRun() throws Exception
      {
      }
    });
  }
}
