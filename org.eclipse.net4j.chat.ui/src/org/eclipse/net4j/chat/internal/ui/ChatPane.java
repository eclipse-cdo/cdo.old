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
import org.eclipse.net4j.chat.IChat;
import org.eclipse.net4j.chat.IComment;
import org.eclipse.net4j.internal.chat.CommentEvent;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.ui.actions.SafeAction;
import org.eclipse.net4j.util.ui.widgets.SashComposite;

import org.eclipse.jface.action.IContributionManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

/**
 * @author Eike Stepper
 */
public class ChatPane extends FacilityPane
{
  private SashComposite sashComposite;

  private Text input;

  private Text output;

  public ChatPane(Composite parent, int style)
  {
    super(parent, style);
  }

  @Override
  protected void handleEvent(IEvent event) throws Exception
  {
    if (event instanceof CommentEvent)
    {
      CommentEvent e = (CommentEvent)event;
      IComment comment = e.getComment();
      output.append(comment.getSenderID() + ": " + comment.getText() + "\n");
    }
  }

  @Override
  protected Control createUI(Composite parent)
  {
    sashComposite = new SashComposite(parent, SWT.NONE, 16, 80, false)
    {
      @Override
      protected Control createControl1(Composite parent)
      {
        output = new Text(parent, SWT.NONE);
        return output;
      }

      @Override
      protected Control createControl2(Composite parent)
      {
        input = new Text(parent, SWT.NONE);
        input.addKeyListener(new KeyListener()
        {
          public void keyPressed(KeyEvent e)
          {
            if (e.character == SWT.CR)
            {
              ((IChat)getFacility()).sendComment(input.getText());
            }
          }

          public void keyReleased(KeyEvent e)
          {
          }
        });

        return input;
      }
    };

    return sashComposite;
  }

  @Override
  protected void fillCoolBar(IContributionManager manager)
  {
    manager.add(new SafeAction("Horizontal Layout", "Horizontal Layout", SharedIcons
        .getDescriptor(SharedIcons.ETOOL_HORIZONTAL))
    {
      @Override
      protected void safeRun() throws Exception
      {
        sashComposite.setVertical(true);
      }
    });

    manager.add(new SafeAction("Vertical Layout", "Vertical Layout", SharedIcons
        .getDescriptor(SharedIcons.ETOOL_VERTICAL))
    {
      @Override
      protected void safeRun() throws Exception
      {
        sashComposite.setVertical(false);
      }
    });
  }
}
