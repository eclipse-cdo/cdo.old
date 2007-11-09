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

import org.eclipse.net4j.buddies.internal.ui.views.CollaborationsPane;
import org.eclipse.net4j.buddies.internal.ui.views.FacilityPane;
import org.eclipse.net4j.fileshare.ISharedFile;
import org.eclipse.net4j.fileshare.ISharedFileFacility;
import org.eclipse.net4j.fileshare.internal.ui.bundle.OM;
import org.eclipse.net4j.internal.fileshare.SharedFileEvent;
import org.eclipse.net4j.util.StringUtil;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.ui.actions.LongRunningAction;

import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.EditorSelectionDialog;
import org.eclipse.ui.ide.IDE;

/**
 * @author Eike Stepper
 */
public class SharedFilePane extends FacilityPane
{
  private List list;

  public SharedFilePane(CollaborationsPane collaborationsPane, int style)
  {
    super(collaborationsPane, style);
  }

  @Override
  protected void handleEvent(IEvent event) throws Exception
  {
    if (event instanceof SharedFileEvent)
    {
      SharedFileEvent e = (SharedFileEvent)event;
      ISharedFile sharedFile = e.getSharedFile();
      list.add(sharedFile.getName());
    }
  }

  @Override
  protected Control createUI(Composite parent)
  {
    list = new List(parent, SWT.NONE);
    list.addMouseListener(new MouseAdapter()
    {
      @Override
      public void mouseDoubleClick(MouseEvent e)
      {
        if (list.getSelectionCount() != 1)
        {
          return;
        }

        String name = list.getSelection()[0];
        ISharedFileFacility facility = (ISharedFileFacility)getFacility();
        ISharedFile sharedFile = facility.getSharedFile(name);

        IWorkbenchPart view = getCollaborationsPane().getCollaborationsView();
        IWorkbenchPage page = view.getSite().getPage();
        IWorkbench workbench = page.getWorkbenchWindow().getWorkbench();

        IEditorRegistry editorRegistry = workbench.getEditorRegistry();
        IEditorDescriptor descriptor = editorRegistry.getDefaultEditor(name);
        if (descriptor == null)
        {
          EditorSelectionDialog dialog = new EditorSelectionDialog(getShell());
          dialog.open();
          descriptor = dialog.getSelectedEditor();
          if (descriptor == null)
          {
            return;
          }
        }

        try
        {
          IDE.openEditor(page, sharedFile.getFile().toURI(), descriptor.getId(), true);
        }
        catch (PartInitException ex)
        {
          OM.LOG.error(ex);
        }
      }
    });

    return list;
  }

  @Override
  protected void fillCoolBar(IContributionManager manager)
  {
    manager.add(new LongRunningAction("Add File", "Add File", SharedIcons.getDescriptor(SharedIcons.OBJ_FILESHARE))
    {
      private String path;

      @Override
      protected void preRun() throws Exception
      {
        InputDialog dialog = new InputDialog(getShell(), "Add File", "Absolute path:", null, null);
        dialog.open();
        path = dialog.getValue();
        if (StringUtil.isEmpty(path))
        {
          cancel();
        }
      }

      @Override
      protected void doRun() throws Exception
      {
        ISharedFileFacility facility = (ISharedFileFacility)getFacility();
        facility.addSharedFile(path);
      }
    });
  }
}
