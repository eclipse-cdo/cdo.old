package org.eclipse.emf.cdo.examples.ui.internal.actions;

import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.examples.ui.UIUtils;
import org.eclipse.emf.cdo.examples.ui.internal.wizards.CDONewWizard;

import org.eclipse.jface.action.Action;

public final class CDOCreateResourceAction extends Action
{
  public static final String ACTION_ID = "CDOCreateResourceAction";

  public static final String TITLE = CDONewWizard.TITLE + "...";

  private ResourceManager resourceManager;

  private boolean commit;

  public CDOCreateResourceAction(ResourceManager resourceManager, boolean commit)
  {
    this.resourceManager = resourceManager;
    this.commit = commit;
    setId(ACTION_ID);
    setText(TITLE);
    setToolTipText(TITLE);
    setImageDescriptor(UIUtils.getImageDescriptor("full/ctool16/CreateCDOResource"));
  }

  public CDOCreateResourceAction()
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
    UIUtils.openCDONewWizard(resourceManager, commit);
  }
}
