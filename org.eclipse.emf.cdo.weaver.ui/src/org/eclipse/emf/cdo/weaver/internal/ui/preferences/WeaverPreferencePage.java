/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.weaver.internal.ui.preferences;

import org.eclipse.emf.cdo.weaver.internal.ui.bundle.OM;
import org.eclipse.emf.cdo.weaver.internal.ui.dialogs.ConfirmWeaveDialog;

import org.eclipse.net4j.util.ui.UIUtil;
import org.eclipse.net4j.util.ui.prefs.OMPreferencePage;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author Eike Stepper
 */
public class WeaverPreferencePage extends OMPreferencePage
{
  private Button check;

  private Button now;

  public WeaverPreferencePage()
  {
    super(OM.PREFS);
  }

  @Override
  protected Control createUI(Composite parent)
  {
    Composite composite = UIUtil.createGridComposite(parent, 2);
    composite.setLayoutData(UIUtil.createGridData());

    check = new Button(composite, SWT.CHECK);
    check.setText("Check during startup");
    check.setSelection(OM.PREF_CHECK_DURING_STARTUP.getValue());

    now = new Button(composite, SWT.PUSH);
    now.setText("Check Now!");
    now.addSelectionListener(new SelectionAdapter()
    {
      @Override
      public void widgetSelected(SelectionEvent e)
      {
        // TODO Add synchronization with ConfirmWeaveJob
        ConfirmWeaveDialog dialog = new ConfirmWeaveDialog(OM.getUnwovenBundles());
        dialog.open();
      }
    });

    return composite;
  }

  @Override
  public boolean performOk()
  {
    OM.PREF_CHECK_DURING_STARTUP.setValue(check.getSelection());
    return super.performOk();
  }
}
