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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbenchPropertyPage;

public class WorkingSetPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage,
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
  protected void createFieldEditors()
  {

  }
}
