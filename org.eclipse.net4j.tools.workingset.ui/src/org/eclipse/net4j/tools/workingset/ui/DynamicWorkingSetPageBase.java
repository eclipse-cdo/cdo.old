package org.eclipse.net4j.tools.workingset.ui;

import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.IWorkingSetPage;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public abstract class DynamicWorkingSetPageBase extends WizardPage implements IWorkingSetPage
{
  private IWorkingSet workingSet;

  private Text workingSetName;

  private Composite editorPane;

  private TableViewer previewer;

  public DynamicWorkingSetPageBase()
  {
    super("definition");
    setMessage("Enter a name and a definition expression for the new dynamic working set.");
    setTitle("Dynamic Working Set");
  }

  public IWorkingSet getSelection()
  {
    return workingSet;
  }

  public void setSelection(IWorkingSet workingSet)
  {
    this.workingSet = workingSet;
  }

  public Text getWorkingSetName()
  {
    return workingSetName;
  }

  public Composite getEditorPane()
  {
    return editorPane;
  }

  public TableViewer getPreviewer()
  {
    return previewer;
  }

  public void createControl(Composite parent)
  {
    SashForm sashForm = new SashForm(parent, SWT.SMOOTH);
    sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
    sashForm.setOrientation(SWT.VERTICAL);
    setControl(sashForm);

    Composite composite1 = new Composite(sashForm, SWT.NONE);
    GridLayout gl_composite1 = new GridLayout(1, false);
    gl_composite1.marginWidth = 0;
    gl_composite1.marginHeight = 0;
    gl_composite1.horizontalSpacing = 0;
    composite1.setLayout(gl_composite1);

    Label label1 = new Label(composite1, SWT.NONE);
    label1.setText("Name:");

    workingSetName = new Text(composite1, SWT.BORDER);
    workingSetName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    workingSetName.setFocus();
    if (workingSet != null)
    {
      workingSetName.setText(workingSet.getLabel());
    }

    Label label2 = new Label(composite1, SWT.NONE);
    label2.setText("Definition:");

    editorPane = new Composite(composite1, SWT.BORDER);
    GridLayout gl_pane = new GridLayout(1, false);
    gl_pane.verticalSpacing = 0;
    gl_pane.marginWidth = 0;
    gl_pane.marginHeight = 0;
    gl_pane.horizontalSpacing = 0;
    editorPane.setLayout(gl_pane);
    editorPane.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

    Composite composite2 = new Composite(sashForm, SWT.NONE);
    GridLayout gl_composite2 = new GridLayout(1, false);
    gl_composite2.marginWidth = 0;
    gl_composite2.marginHeight = 0;
    gl_composite2.horizontalSpacing = 0;
    composite2.setLayout(gl_composite2);

    Label label3 = new Label(composite2, SWT.NONE);
    label3.setText("Preview:");

    previewer = new TableViewer(composite2, SWT.BORDER | SWT.FULL_SELECTION);
    previewer.setLabelProvider(createLabelProvider());

    Table table = previewer.getTable();
    table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
    table.setBounds(0, 0, 85, 85);
    sashForm.setWeights(new int[] { 1, 2 });
  }

  private IBaseLabelProvider createLabelProvider()
  {
    ILabelDecorator labelDecorator = PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator();
    return new DecoratingLabelProvider(new WorkbenchLabelProvider(), labelDecorator);
  }
}
