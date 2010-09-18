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

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * @author Eike Stepper
 */
public class MyPreferencePage extends PreferencePage implements IWorkbenchPreferencePage
{
  private IWorkbench workbench;

  private SashForm sashForm;

  private SashForm sashForm_1;

  private Composite workingsetComposite;

  private Composite definitionComposite;

  private Composite previewComposite;

  private Label lblWorkingSets;

  private Label lblDefinition;

  private Label lblPreview;

  private Composite composite_3;

  private Table workingsets;

  private TableViewer tableViewer;

  private Composite composite_4;

  private Button add;

  private Button remove;

  private Composite editorComposite;

  private Table table;

  private TableViewer previewer;

  /**
   * Create the preference page.
   */
  public MyPreferencePage()
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

  public Composite getEditorComposite()
  {
    return editorComposite;
  }

  public TableViewer getPreviewer()
  {
    return previewer;
  }

  /**
   * Create contents of the preference page.
   * 
   * @param parent
   */
  @Override
  public Control createContents(Composite parent)
  {
    Composite container = new Composite(parent, SWT.NULL);
    container.setLayout(new FillLayout(SWT.HORIZONTAL));

    sashForm = new SashForm(container, SWT.SMOOTH);
    sashForm.setOrientation(SWT.VERTICAL);

    workingsetComposite = new Composite(sashForm, SWT.NONE);
    GridLayout gl_workingsetComposite = new GridLayout(1, false);
    gl_workingsetComposite.verticalSpacing = 0;
    gl_workingsetComposite.marginWidth = 0;
    gl_workingsetComposite.marginHeight = 0;
    gl_workingsetComposite.horizontalSpacing = 0;
    workingsetComposite.setLayout(gl_workingsetComposite);

    lblWorkingSets = new Label(workingsetComposite, SWT.NONE);
    lblWorkingSets.setText("Working Sets:");

    composite_3 = new Composite(workingsetComposite, SWT.NONE);
    composite_3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
    GridLayout gl_composite_3 = new GridLayout(2, false);
    gl_composite_3.verticalSpacing = 0;
    gl_composite_3.marginWidth = 0;
    gl_composite_3.marginHeight = 0;
    composite_3.setLayout(gl_composite_3);

    tableViewer = new TableViewer(composite_3, SWT.BORDER | SWT.FULL_SELECTION);
    workingsets = tableViewer.getTable();
    workingsets.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

    composite_4 = new Composite(composite_3, SWT.NONE);
    composite_4.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
    GridLayout gl_composite_4 = new GridLayout(1, false);
    gl_composite_4.verticalSpacing = 0;
    gl_composite_4.marginWidth = 0;
    gl_composite_4.marginHeight = 0;
    composite_4.setLayout(gl_composite_4);

    add = new Button(composite_4, SWT.NONE);
    add.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
    add.setBounds(0, 0, 75, 25);
    add.setText("Add");

    remove = new Button(composite_4, SWT.NONE);
    remove.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
    remove.setBounds(0, 0, 75, 25);
    remove.setText("Remove");

    sashForm_1 = new SashForm(sashForm, SWT.SMOOTH);
    sashForm_1.setOrientation(SWT.VERTICAL);

    definitionComposite = new Composite(sashForm_1, SWT.NONE);
    GridLayout gl_definitionComposite = new GridLayout(1, false);
    gl_definitionComposite.verticalSpacing = 0;
    gl_definitionComposite.marginWidth = 0;
    gl_definitionComposite.marginHeight = 0;
    gl_definitionComposite.horizontalSpacing = 0;
    definitionComposite.setLayout(gl_definitionComposite);

    lblDefinition = new Label(definitionComposite, SWT.NONE);
    lblDefinition.setText("Definition:");

    editorComposite = new Composite(definitionComposite, SWT.BORDER);
    editorComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
    GridLayout gl_editorComposite = new GridLayout(1, false);
    gl_editorComposite.verticalSpacing = 0;
    gl_editorComposite.marginWidth = 0;
    gl_editorComposite.marginHeight = 0;
    gl_editorComposite.horizontalSpacing = 0;
    editorComposite.setLayout(gl_editorComposite);

    previewComposite = new Composite(sashForm_1, SWT.NONE);
    GridLayout gl_previewComposite = new GridLayout(1, false);
    gl_previewComposite.verticalSpacing = 0;
    gl_previewComposite.marginWidth = 0;
    gl_previewComposite.marginHeight = 0;
    gl_previewComposite.horizontalSpacing = 0;
    previewComposite.setLayout(gl_previewComposite);

    lblPreview = new Label(previewComposite, SWT.NONE);
    lblPreview.setText("Preview:");

    previewer = new TableViewer(previewComposite, SWT.BORDER | SWT.FULL_SELECTION);
    previewer.setLabelProvider(createLabelProvider());

    table = previewer.getTable();
    table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
    sashForm_1.setWeights(new int[] { 1, 1 });
    sashForm.setWeights(new int[] { 1, 1 });
    return container;
  }

  private IBaseLabelProvider createLabelProvider()
  {
    ILabelDecorator labelDecorator = workbench.getDecoratorManager().getLabelDecorator();
    return new DecoratingLabelProvider(new WorkbenchLabelProvider(), labelDecorator);
  }
}
