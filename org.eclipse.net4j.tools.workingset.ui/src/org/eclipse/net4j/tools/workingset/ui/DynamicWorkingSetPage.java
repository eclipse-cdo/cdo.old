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
package org.eclipse.net4j.tools.workingset.ui;

import org.eclipse.net4j.tools.workingset.dsl.BooleanExpression;
import org.eclipse.net4j.tools.workingset.evaluation.BooleanEvaluator;
import org.eclipse.net4j.tools.workingset.ui.embedded.EmbeddedXtextEditor;
import org.eclipse.net4j.tools.workingset.ui.internal.DslActivator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelListener;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.editor.validation.XtextAnnotation;

import com.google.inject.Injector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class DynamicWorkingSetPage extends DynamicWorkingSetPageBase
{
  private EmbeddedXtextEditor editor;

  private String errorMessage;

  private XtextResource resource;

  private List<IResource> result = new ArrayList<IResource>();

  public DynamicWorkingSetPage()
  {
  }

  public XtextResource getResource()
  {
    return resource;
  }

  public void setResource(XtextResource resource)
  {
    this.resource = resource;
  }

  @Override
  public void dispose()
  {
    super.dispose();
  }

  @Override
  public void createControl(Composite parent)
  {
    try
    {
      super.createControl(parent);
      embedEditor(getEditorPane());

      getPreviewer().setContentProvider(new ArrayContentProvider());
      getPreviewer().setInput(result);
    }
    catch (RuntimeException ex)
    {
      ex.printStackTrace();
      throw ex;
    }
  }

  protected EmbeddedXtextEditor embedEditor(Composite contents)
  {
    Injector injector = DslActivator.getInstance().getInjector("org.eclipse.net4j.tools.workingset.Dsl");
    editor = new EmbeddedXtextEditor(contents, injector, SWT.BORDER);
    IWorkingSet workingSet = getSelection();
    if (workingSet != null)
    {
      editor.getDocument().set(workingSet.getName());
    }

    editor.getViewer().getAnnotationModel().addAnnotationModelListener(new IAnnotationModelListener()
    {
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
          getShell().getDisplay().asyncExec(new Runnable()
          {
            public void run()
            {
              setErrorMessage(errorMessage);
            }
          });
        }

        updatePreview(errorMessage == null ? editor.getResource() : null);
      }
    });

    editor.getDocument().addModelListener(new IXtextModelListener()
    {
      public void modelChanged(XtextResource resource)
      {
        updatePreview(errorMessage == null ? editor.getResource() : null);
      }
    });

    return editor;
  }

  protected void updatePreview(XtextResource resource)
  {
    this.resource = resource;
    result.clear();

    if (resource != null)
    {
      final EList<EObject> contents = resource.getContents();
      if (!contents.isEmpty())
      {
        final BooleanEvaluator evaluator = new BooleanEvaluator();

        try
        {
          ResourcesPlugin.getWorkspace().getRoot().accept(new IResourceVisitor()
          {
            public boolean visit(IResource resource) throws CoreException
            {
              if (resource.getType() == IResource.ROOT)
              {
                return true;
              }

              BooleanExpression expression = (BooleanExpression)contents.get(0);
              if (evaluator.evaluate(expression, resource))
              {
                result.add(resource);
                return false;
              }

              return true;
            }
          });
        }
        catch (CoreException ex)
        {
          ex.printStackTrace();
        }
      }
    }

    getShell().getDisplay().syncExec(new Runnable()
    {
      public void run()
      {
        getPreviewer().refresh();
      }
    });
  }

  public void finish()
  {
    String definition = editor.getDocument().get();
    IResource[] elements = result.toArray(new IResource[result.size()]);

    IWorkingSet workingSet = getSelection();
    if (workingSet == null)
    {
      IWorkingSetManager workingSetManager = PlatformUI.getWorkbench().getWorkingSetManager();
      workingSet = workingSetManager.createWorkingSet(definition, elements);
      workingSet.setId("org.eclipse.net4j.tools.workingset.ui.DynamicWorkingSet");
    }
    else
    {
      workingSet.setName(definition);
      workingSet.setElements(elements);
    }

    String label = getWorkingSetName().getText().trim();
    workingSet.setLabel(label);

    setSelection(workingSet);
  }
}
