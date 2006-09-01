package org.eclipse.emf.cdo.examples.ui.internal.actions;


import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.examples.ui.internal.UIUtils;
import org.eclipse.jface.action.Action;


/**
 * TODO Document type CDOCreateResourceAction<p>
 * The <code>CDOCreateResourceAction</code> class.<p>
 *
 * @author Eike Stepper
 */
public final class CDOCreateResourceAction extends Action
{
  private ResourceManager resourceManager;

  private boolean commit;

  public CDOCreateResourceAction(ResourceManager resourceManager, boolean commit)
  {
    this.resourceManager = resourceManager;
    this.commit = commit;
    setText("Create resource...");
    setToolTipText("Create resource...");
    setImageDescriptor(UIUtils.getImageDescriptor("full/ctool16/NewCDOResource"));
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
