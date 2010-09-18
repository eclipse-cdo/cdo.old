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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.editor.validation.XtextAnnotation;

import com.google.inject.Injector;

import java.util.Iterator;

public class WorkingSetPreferencePage extends PreferencePage implements IWorkbenchPreferencePage,
    IWorkbenchPropertyPage
{
  private IWorkbench workbench;

  private IAdaptable element;

  public WorkingSetPreferencePage()
  {
  }

  public void init(IWorkbench workbench)
  {
    this.workbench = workbench;
  }

  public IWorkbench getWorkbench()
  {
    return workbench;
  }

  public IAdaptable getElement()
  {
    return element;
  }

  public void setElement(IAdaptable element)
  {
    this.element = element;
  }

  @Override
  protected Control createContents(Composite parent)
  {
    Composite contents = new Composite(parent, SWT.NONE);
    contents.setLayout(new GridLayout());
    contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    setTitle("Net4j Tools WorkingSet");
    setMessage("Enter an expression.");

    Injector injector = DslActivator.getInstance().getInjector("org.eclipse.net4j.tools.workingset.Dsl");

    EmbeddedXtextEditor editor = new EmbeddedXtextEditor(contents, injector, SWT.BORDER);
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
          workbench.getDisplay().asyncExec(new Runnable()
          {
            public void run()
            {
              setErrorMessage(errorMessage);
            }
          });
        }
      }
    });

    editor.getDocument().addModelListener(new IXtextModelListener()
    {
      public void modelChanged(XtextResource resource)
      {
        System.out.println(resource.getContents());
      }
    });

    return contents;
  }
}
