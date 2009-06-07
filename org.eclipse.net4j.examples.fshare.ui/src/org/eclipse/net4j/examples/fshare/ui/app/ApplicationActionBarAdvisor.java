package org.eclipse.net4j.examples.fshare.ui.app;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor
{
  // private IWorkbenchAction exitAction;

  public ApplicationActionBarAdvisor(IActionBarConfigurer configurer)
  {
    super(configurer);
  }

  @Override
  protected void makeActions(final IWorkbenchWindow window)
  {
    // exitAction = ActionFactory.QUIT.create(window);
    // register(exitAction);
  }

  @Override
  protected void fillMenuBar(IMenuManager menuBar)
  {
    // MenuManager fileMenu = new MenuManager("&File", IWorkbenchActionConstants.M_FILE);
    // menuBar.add(fileMenu);
    // fileMenu.add(exitAction);
  }
}
