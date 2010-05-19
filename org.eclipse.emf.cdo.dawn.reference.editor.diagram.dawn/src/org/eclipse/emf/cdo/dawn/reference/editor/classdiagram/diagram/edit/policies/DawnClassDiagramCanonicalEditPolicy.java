/*******************************************************************************
 * Copyright (c) 2004 - 2010 Eike Stepper (Berlin, Germany).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fluegge - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.policies;

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramDiagramEditorPlugin;

/**
 * @author Martin Fluegge
 */
public class DawnClassDiagramCanonicalEditPolicy extends ClassDiagramCanonicalEditPolicy
{

  public DawnClassDiagramCanonicalEditPolicy()
  {
    super();
    ClassdiagramDiagramEditorPlugin.getInstance().logInfo(
        "Running DawnClassDiagramCanonicalEditPolicy instead of original one");
  }

  // @Override
  // protected List getSemanticChildrenList()
  // {
  // List semanticChildren = super.getSemanticChildrenList();
  // List<View> viewChildren = getViewChildren();
  //
  // //remove all semantic children that do not have a view because the have one in another resource,
  // //or the child should not have one
  // semanticChildren.removeAll(cleanCanonicalSemanticChildren(viewChildren, semanticChildren));
  // return semanticChildren;
  // }

  // /**
  // * @generated
  // */
  // @Override
  // public void refreshSemantic()
  // {
  // List createdViews = new LinkedList();
  // // createdViews.addAll(refreshSemanticChildren());
  // List createdConnectionViews = new LinkedList();
  // createdConnectionViews.addAll(refreshSemanticConnections());
  // createdConnectionViews.addAll(refreshConnections());
  //
  // if (createdViews.size() > 1)
  // {
  // // perform a layout of the container
  // DeferredLayoutCommand layoutCmd = new DeferredLayoutCommand(host().getEditingDomain(), createdViews, host());
  // executeCommand(new ICommandProxy(layoutCmd));
  // }
  //
  // createdViews.addAll(createdConnectionViews);
  // makeViewsImmutable(createdViews);
  // }
}
