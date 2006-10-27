package org.eclipse.emf.cdo.examples.ui.internal.actions;

import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.cdo.examples.ui.UIUtils;
import org.eclipse.emf.cdo.examples.ui.internal.wizards.CDOExportWizard;

import org.eclipse.jface.action.Action;

public final class CDOExportResourceAction extends Action
{
  public static final String ACTION_ID = "CDOExportResourceAction";

  public static final String TITLE = CDOExportWizard.TITLE + "...";

  private CDOResource resource;

  public CDOExportResourceAction(CDOResource resource)
  {
    this.resource = resource;
    setId(ACTION_ID);
    setText(TITLE);
    setToolTipText(TITLE);
    setImageDescriptor(UIUtils.getImageDescriptor("full/ctool16/ExportCDOResource"));
  }

  public CDOExportResourceAction()
  {
    this(null);
  }

  public CDOResource getResource()
  {
    return resource;
  }

  public void setResource(CDOResource resource)
  {
    this.resource = resource;
  }

  public void run()
  {
    UIUtils.openCDOExportWizard(resource);
  }
}
