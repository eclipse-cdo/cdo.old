package org.eclipse.emf.cdo.examples.ui.internal.actions;


import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.examples.ui.UIUtils;
import org.eclipse.emf.cdo.examples.ui.internal.wizards.CDOImportWizard;
import org.eclipse.jface.action.Action;


public final class CDOImportResourceAction extends Action
{
  public static final String ACTION_ID = "CDOImportResourceAction";

  public static final String TITLE = CDOImportWizard.TITLE + "...";

  private ResourceManager resourceManager;

  private boolean commit;

  public CDOImportResourceAction(ResourceManager resourceManager, boolean commit)
  {
    this.resourceManager = resourceManager;
    this.commit = commit;
    setId(ACTION_ID);
    setText(TITLE);
    setToolTipText(TITLE);
    setImageDescriptor(UIUtils.getImageDescriptor("full/ctool16/ImportCDOResource"));
  }

  public CDOImportResourceAction()
  {
    this(null, true);
  }

  public boolean isCommit()
  {
    return commit;
  }

  public void setCommit(boolean commit)
  {
    this.commit = commit;
  }

  public ResourceManager getResourceManager()
  {
    return resourceManager;
  }

  public void setResourceManager(ResourceManager resourceManager)
  {
    this.resourceManager = resourceManager;
  }

  public void run()
  {
    UIUtils.openCDOImportWizard(resourceManager, commit);
  }
}
