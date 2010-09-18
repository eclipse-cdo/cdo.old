package org.eclipse.net4j.tools.workingset.ui;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.dialogs.PreferencesUtil;

public class SampleAction implements IWorkbenchWindowActionDelegate
{
  private IWorkbenchWindow window;

  public void init(IWorkbenchWindow window)
  {
    this.window = window;
  }

  public void selectionChanged(IAction action, ISelection selection)
  {
  }

  public void dispose()
  {
  }

  public void run(IAction action)
  {
    try
    {
      PreferenceDialog dialog = PreferencesUtil.createPreferenceDialogOn(window.getShell(),
          "org.eclipse.net4j.tools.workingset", new String[] { "org.eclipse.net4j.tools.workingset.coloring",
              "org.eclipse.net4j.tools.workingset.templates" }, null);
      dialog.open();

      // Dialog dialog = new TitleAreaDialog(window.getShell())
      // {
      // @Override
      // protected Control createDialogArea(Composite parent)
      // {
      // Composite area = (Composite)super.createDialogArea(parent);
      // Composite contents = new Composite(area, SWT.NONE);
      // contents.setLayout(new GridLayout());
      // contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
      //
      // setTitle("Net4j Tools WorkingSet");
      // setMessage("Enter an expression.");
      //
      // Injector injector = DslActivator.getInstance().getInjector("org.eclipse.net4j.tools.workingset.Dsl");
      //
      // EmbeddedXtextEditor editor = new EmbeddedXtextEditor(contents, injector, SWT.BORDER);
      // editor.getViewer().getAnnotationModel().addAnnotationModelListener(new IAnnotationModelListener()
      // {
      // private String errorMessage;
      //
      // public void modelChanged(IAnnotationModel model)
      // {
      // String text = "";
      // Iterator<?> it = model.getAnnotationIterator();
      // if (it.hasNext())
      // {
      // XtextAnnotation annotation = (XtextAnnotation)it.next();
      // text = annotation.getText();
      // }
      //
      // if (!text.equals(errorMessage))
      // {
      // errorMessage = text.length() == 0 ? null : text;
      // getShell().getDisplay().asyncExec(new Runnable()
      // {
      // public void run()
      // {
      // setErrorMessage(errorMessage);
      // }
      // });
      // }
      // }
      // });
      //
      // editor.getDocument().addModelListener(new IXtextModelListener()
      // {
      // public void modelChanged(XtextResource resource)
      // {
      // System.out.println(resource.getContents());
      // }
      // });
      //
      // return area;
      // }
      // };
      //
      // dialog.open();
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }
}
