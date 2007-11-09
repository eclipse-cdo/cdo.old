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
package org.eclipse.net4j.fileshare.internal.ui;

import org.eclipse.net4j.buddies.internal.ui.views.FacilityPane;
import org.eclipse.net4j.fileshare.ISharedFile;
import org.eclipse.net4j.internal.fileshare.SharedFileEvent;
import org.eclipse.net4j.util.StringUtil;
import org.eclipse.net4j.util.event.IEvent;

import org.eclipse.jface.action.IContributionManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;

/**
 * @author Eike Stepper
 */
public class SharedFilePane extends FacilityPane
{
  private List list;

  public SharedFilePane(Composite parent, int style)
  {
    super(parent, style);
  }

  @Override
  protected void handleEvent(IEvent event) throws Exception
  {
    if (event instanceof SharedFileEvent)
    {
      SharedFileEvent e = (SharedFileEvent)event;
      ISharedFile sharedFile = e.getSharedFile();
      String text = sharedFile.getName();
      list.add(sharedFile.getCreatorID() + ": " + text + StringUtil.NL);
    }
  }

  @Override
  protected Control createUI(Composite parent)
  {
    return list = new List(parent, SWT.NONE);
  }

  @Override
  protected void fillCoolBar(IContributionManager manager)
  {
    // manager.add(new SafeAction("Vertical Layout", "Vertical Layout", SharedIcons
    // .getDescriptor(SharedIcons.ETOOL_VERTICAL))
    // {
    // @Override
    // protected void safeRun() throws Exception
    // {
    // sashComposite.setVertical(false);
    // }
    // });
    //
    // manager.add(new SafeAction("Horizontal Layout", "Horizontal Layout", SharedIcons
    // .getDescriptor(SharedIcons.ETOOL_HORIZONTAL))
    // {
    // @Override
    // protected void safeRun() throws Exception
    // {
    // sashComposite.setVertical(true);
    // }
    // });
  }
}
