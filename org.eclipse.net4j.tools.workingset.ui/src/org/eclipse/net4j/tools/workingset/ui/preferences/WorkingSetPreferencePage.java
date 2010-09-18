/**
 * Copyright (c) 2004 - 2009 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.net4j.tools.workingset.ui.preferences;

import org.eclipse.net4j.tools.workingset.ui.embedded.EmbeddedXtextEditor;
import org.eclipse.net4j.tools.workingset.ui.internal.DslActivator;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.validation.XtextAnnotation;

import com.google.inject.Injector;

import java.util.Iterator;

public class WorkingSetPreferencePage extends MyPreferencePage
{
  public WorkingSetPreferencePage()
  {
  }

  @Override
  public Control createContents(Composite parent)
  {
    Control contents = super.createContents(parent);
    embedEditor(getEditorComposite());

    getPreviewer().setContentProvider(new IStructuredContentProvider()
    {
      public void dispose()
      {
      }

      public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
      {
      }

      public Object[] getElements(Object inputElement)
      {
        return ResourcesPlugin.getWorkspace().getRoot().getProjects();
      }
    });

    getPreviewer().setInput(ResourcesPlugin.getWorkspace());
    return contents;
  }

  protected EmbeddedXtextEditor embedEditor(Composite contents)
  {
    Injector injector = DslActivator.getInstance().getInjector("org.eclipse.net4j.tools.workingset.Dsl");
    final EmbeddedXtextEditor editor = new EmbeddedXtextEditor(contents, injector, SWT.BORDER);

    editor.getViewer().getAnnotationModel().addAnnotationModelListener(new IAnnotationModelListener()
    {
      private String errorMessage;

      public void modelChanged(IAnnotationModel model)
      {
        String text = "";
        Iterator<?> it = model.getAnnotationIterator();
        if (it.hasNext())
        {
          XtextAnnotation annotation = (XtextAnnotation)it.next();
          text = annotation.getText();
        }

        if (!text.equals(errorMessage))
        {
          errorMessage = text.length() == 0 ? null : text;
          getWorkbench().getDisplay().asyncExec(new Runnable()
          {
            public void run()
            {
              setErrorMessage(errorMessage);
            }
          });

          updatePreview(errorMessage == null ? null : editor.getResource());
        }
      }
    });

    return editor;
  }

  protected void updatePreview(XtextResource resource)
  {
  }
}
