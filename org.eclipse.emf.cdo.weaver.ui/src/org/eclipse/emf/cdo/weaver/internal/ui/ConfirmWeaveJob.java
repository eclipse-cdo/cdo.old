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
package org.eclipse.emf.cdo.weaver.internal.ui;

import org.eclipse.emf.cdo.weaver.BundleInfo;
import org.eclipse.emf.cdo.weaver.internal.ui.bundle.OM;
import org.eclipse.emf.cdo.weaver.internal.ui.dialogs.ConfirmWeavePopup;

import org.eclipse.net4j.util.concurrent.Sleeper;
import org.eclipse.net4j.util.om.monitor.MonitoredJob;
import org.eclipse.net4j.util.ui.UIUtil;

import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.util.HashSet;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class ConfirmWeaveJob extends MonitoredJob
{
  private ConfirmWeavePopup popup;

  private ShellListener shellListener = new ShellAdapter()
  {
    @Override
    public void shellDeactivated(ShellEvent e)
    {
      closePopup();
      cancel();
    }
  };

  public ConfirmWeaveJob()
  {
    super(OM.BUNDLE_ID, "Confirm Weave Job");
  }

  @Override
  protected void run() throws Exception
  {
    Sleeper sleeper = new Sleeper();
    final Map<String, BundleInfo> bundleMap = OM.getUnwovenBundles();
    final HashSet<String> unignoredBundles = new HashSet<String>(bundleMap.keySet());
    unignoredBundles.removeAll(OM.getIgnoredBundles());
    if (unignoredBundles.isEmpty())
    {
      return;
    }

    sleeper.sleep(0L);
    final Display display = UIUtil.getDisplay();
    if (!display.isDisposed())
    {
      display.asyncExec(new Runnable()
      {
        public void run()
        {
          popup = new ConfirmWeavePopup(new Shell(display), bundleMap, unignoredBundles);
          popup.setBlockOnOpen(false);
          popup.open();
          popup.getShell().addShellListener(shellListener);
        }
      });
    }

    sleeper.resleep(10000L);
    if (!display.isDisposed())
    {
      display.asyncExec(new Runnable()
      {
        public void run()
        {
          closePopup();
        }
      });
    }
  }

  protected void closePopup()
  {
    if (popup != null)
    {
      popup.close();
      popup = null;
    }
  }
}
