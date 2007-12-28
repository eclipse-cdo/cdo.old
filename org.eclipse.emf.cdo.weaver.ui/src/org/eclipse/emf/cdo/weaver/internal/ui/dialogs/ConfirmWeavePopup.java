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
package org.eclipse.emf.cdo.weaver.internal.ui.dialogs;

import org.eclipse.emf.cdo.weaver.BundleInfo;
import org.eclipse.emf.cdo.weaver.internal.ui.SharedIcons;
import org.eclipse.emf.cdo.weaver.internal.ui.bundle.OM;

import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;

import java.util.HashSet;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class ConfirmWeavePopup extends PopupDialog
{
  private static final String LABEL_NOTIFICATION = "CDO Weaver Notification";

  private Map<String, BundleInfo> bundleMap;

  private HashSet<String> unignoredBundles;

  private Form form;

  private Rectangle bounds;

  private Composite sectionClient;

  private FormToolkit toolkit;

  public ConfirmWeavePopup(Shell parent, Map<String, BundleInfo> bundleMap, HashSet<String> unignoredBundles)
  {
    super(parent, PopupDialog.INFOPOPUP_SHELLSTYLE | SWT.ON_TOP, false, false, false, false, null, null);
    toolkit = new FormToolkit(parent.getDisplay());
    this.bundleMap = bundleMap;
    this.unignoredBundles = unignoredBundles;
  }

  @Override
  protected Control createContents(Composite parent)
  {
    getShell().setBackground(getShell().getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY));
    return createDialogArea(parent);
  }

  @Override
  protected final Control createDialogArea(final Composite parent)
  {
    getShell().setText(LABEL_NOTIFICATION);

    form = toolkit.createForm(parent);
    form.getBody().setLayout(new GridLayout());

    Section section = toolkit.createSection(form.getBody(), Section.TITLE_BAR);
    section.setText(LABEL_NOTIFICATION);
    section.setLayout(new GridLayout());

    sectionClient = toolkit.createComposite(section);
    sectionClient.setLayout(new GridLayout(1, false));

    toolkit.createLabel(sectionClient, "Bundles with unwoven models:");
    for (String bundleName : unignoredBundles)
    {
      toolkit.createLabel(sectionClient, "- " + bundleName);
    }

    toolkit.createLabel(sectionClient, "");
    Hyperlink weaverLink = toolkit.createHyperlink(sectionClient, "Open Weaver Dialog", SWT.NONE);
    weaverLink.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
    weaverLink.addHyperlinkListener(new HyperlinkAdapter()
    {
      @Override
      public void linkActivated(HyperlinkEvent e)
      {
        openWeaverDialog();
      }
    });

    final Button check = toolkit.createButton(sectionClient, "Check during startup", SWT.CHECK);
    check.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
    check.setSelection(OM.PREF_CHECK_DURING_STARTUP.getValue());
    check.addSelectionListener(new SelectionAdapter()
    {
      @Override
      public void widgetSelected(SelectionEvent e)
      {
        OM.PREF_CHECK_DURING_STARTUP.setValue(check.getSelection());
      }
    });

    toolkit.createLabel(sectionClient, "");
    section.setClient(sectionClient);

    ImageHyperlink closeLink = new ImageHyperlink(section, SWT.NONE);
    toolkit.adapt(closeLink, true, true);
    closeLink.setImage(SharedIcons.getImage(SharedIcons.EVIEW_CLOSE));
    closeLink.setBackground(null);
    closeLink.addHyperlinkListener(new HyperlinkAdapter()
    {
      @Override
      public void linkActivated(HyperlinkEvent e)
      {
        close();
      }
    });

    section.setTextClient(closeLink);

    parent.pack();
    return form;
  }

  protected void openWeaverDialog()
  {
    ConfirmWeaveDialog dialog = new ConfirmWeaveDialog(bundleMap);
    dialog.open();
  }

  @Override
  public void initializeBounds()
  {
    getShell().setBounds(restoreBounds());
  }

  private Rectangle restoreBounds()
  {
    bounds = getShell().getBounds();
    Rectangle maxBounds = null;

    IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    if (window != null)
    {
      maxBounds = window.getShell().getMonitor().getClientArea();
    }
    else
    {
      // fallback
      Display display = Display.getCurrent();
      if (display == null)
      {
        display = Display.getDefault();
      }

      if (display != null && !display.isDisposed())
      {
        maxBounds = display.getPrimaryMonitor().getClientArea();
      }
    }

    if (bounds.width > -1 && bounds.height > -1)
    {
      if (maxBounds != null)
      {
        bounds.width = Math.min(bounds.width, maxBounds.width);
        bounds.height = Math.min(bounds.height, maxBounds.height);
      }

      // Enforce an absolute minimal size
      bounds.width = Math.max(bounds.width, 30);
      bounds.height = Math.max(bounds.height, 30);
    }

    if (bounds.x > -1 && bounds.y > -1 && maxBounds != null)
    {
      // bounds.x = Math.max(bounds.x, maxBounds.x);
      // bounds.y = Math.max(bounds.y, maxBounds.y);
      if (bounds.width > -1 && bounds.height > -1)
      {
        bounds.x = maxBounds.x + maxBounds.width - bounds.width;
        bounds.y = maxBounds.y + maxBounds.height - bounds.height;
      }
    }

    return bounds;
  }

  @Override
  public boolean close()
  {
    if (toolkit != null)
    {
      if (toolkit.getColors() != null)
      {
        toolkit.dispose();
      }
    }

    return super.close();
  }
}
