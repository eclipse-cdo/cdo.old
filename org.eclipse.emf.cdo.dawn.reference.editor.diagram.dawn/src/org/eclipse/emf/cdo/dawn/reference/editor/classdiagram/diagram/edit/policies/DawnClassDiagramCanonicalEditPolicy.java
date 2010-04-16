package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.policies;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.cdo.dawn.logging.logger.LOG;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;

public class DawnClassDiagramCanonicalEditPolicy extends ClassDiagramCanonicalEditPolicy
{

  public DawnClassDiagramCanonicalEditPolicy()
  {
    super();
    LOG.info("Running DawnClassDiagramCanonicalEditPolicy instead of original one");
  }

  /**
   * removes the creation of nodes TODO find a way to call refreshConnections without changing the visibility in the
   * paretn class
   */
  // @Override
  // public void refreshSemantic()
  // {
  // LOG.info("DawnClassDiagramCanonicalEditPolicy refresh");
  //
  // List<View> oldViews = getViewChildren();
  //
  // super.refreshSemantic();
  //
  // List<View> newViews = getViewChildren();
  // List<View> toBeDeleted = new ArrayList<View>();
  //
  // for (View newView : newViews)
  // {
  // if (!oldViews.contains(newView))
  // {
  // toBeDeleted.add(newView);
  // }
  // }
  //
  // deleteViews(toBeDeleted.iterator());
  // }

  /**
   * @generated
   */
  @Override
  public void refreshSemantic()
  {
    System.out.println("ClassDiagramCanonicalEditPolicy refresh");
    List createdViews = new LinkedList();
    // createdViews.addAll(refreshSemanticChildren());
    List createdConnectionViews = new LinkedList();
    createdConnectionViews.addAll(refreshSemanticConnections());
    createdConnectionViews.addAll(refreshConnections());

    if (createdViews.size() > 1)
    {
      // perform a layout of the container
      DeferredLayoutCommand layoutCmd = new DeferredLayoutCommand(host().getEditingDomain(), createdViews, host());
      executeCommand(new ICommandProxy(layoutCmd));
    }

    createdViews.addAll(createdConnectionViews);
    makeViewsImmutable(createdViews);
  }
}
