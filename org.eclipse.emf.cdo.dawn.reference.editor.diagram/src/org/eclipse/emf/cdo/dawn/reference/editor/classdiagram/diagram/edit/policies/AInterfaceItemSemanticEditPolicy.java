/*******************************************************************************
 * Copyright (c) 2010 Martin Fluegge (Berlin, Germany).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fluegge - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.commands.AClassImplementedInterfacesCreateCommand;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.commands.AClassImplementedInterfacesReorientCommand;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassImplementedInterfacesEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AInterfaceAnAttributeInterfaceCompartmentEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AInterfaceAnOperationInterfaceCompartmentEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnAttributeEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnOperationEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramVisualIDRegistry;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.providers.ClassdiagramElementTypes;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class AInterfaceItemSemanticEditPolicy extends ClassdiagramBaseItemSemanticEditPolicy
{

  /**
   * @generated
   */
  public AInterfaceItemSemanticEditPolicy()
  {
    super(ClassdiagramElementTypes.AInterface_2001);
  }

  /**
   * @generated
   */
  protected Command getDestroyElementCommand(DestroyElementRequest req)
  {
    View view = (View)getHost().getModel();
    CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
    cmd.setTransactionNestingEnabled(false);
    for (Iterator it = view.getTargetEdges().iterator(); it.hasNext();)
    {
      Edge incomingLink = (Edge)it.next();
      if (ClassdiagramVisualIDRegistry.getVisualID(incomingLink) == AClassImplementedInterfacesEditPart.VISUAL_ID)
      {
        DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
            incomingLink.getTarget().getElement(), false);
        cmd.add(new DestroyReferenceCommand(r));
        cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
        continue;
      }
    }
    EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
    if (annotation == null)
    {
      // there are indirectly referenced children, need extra commands: false
      addDestroyChildNodesCommand(cmd);
      addDestroyShortcutsCommand(cmd, view);
      // delete host element
      cmd.add(new DestroyElementCommand(req));
    }
    else
    {
      cmd.add(new DeleteCommand(getEditingDomain(), view));
    }
    return getGEFWrapper(cmd.reduce());
  }

  /**
   * @generated
   */
  private void addDestroyChildNodesCommand(ICompositeCommand cmd)
  {
    View view = (View)getHost().getModel();
    for (Iterator nit = view.getChildren().iterator(); nit.hasNext();)
    {
      Node node = (Node)nit.next();
      switch (ClassdiagramVisualIDRegistry.getVisualID(node))
      {
      case AInterfaceAnAttributeInterfaceCompartmentEditPart.VISUAL_ID:
        for (Iterator cit = node.getChildren().iterator(); cit.hasNext();)
        {
          Node cnode = (Node)cit.next();
          switch (ClassdiagramVisualIDRegistry.getVisualID(cnode))
          {
          case AnAttributeEditPart.VISUAL_ID:
            cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned:
                                                                                                                          // true
            // don't need explicit deletion of cnode as parent's view deletion would clean child views as well
            // cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
            break;
          }
        }
        break;
      case AInterfaceAnOperationInterfaceCompartmentEditPart.VISUAL_ID:
        for (Iterator cit = node.getChildren().iterator(); cit.hasNext();)
        {
          Node cnode = (Node)cit.next();
          switch (ClassdiagramVisualIDRegistry.getVisualID(cnode))
          {
          case AnOperationEditPart.VISUAL_ID:
            cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned:
                                                                                                                          // true
            // don't need explicit deletion of cnode as parent's view deletion would clean child views as well
            // cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
            break;
          }
        }
        break;
      }
    }
  }

  /**
   * @generated
   */
  protected Command getCreateRelationshipCommand(CreateRelationshipRequest req)
  {
    Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
        : getCompleteCreateRelationshipCommand(req);
    return command != null ? command : super.getCreateRelationshipCommand(req);
  }

  /**
   * @generated
   */
  protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req)
  {
    if (ClassdiagramElementTypes.AClassImplementedInterfaces_4002 == req.getElementType())
    {
      return null;
    }
    return null;
  }

  /**
   * @generated
   */
  protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req)
  {
    if (ClassdiagramElementTypes.AClassImplementedInterfaces_4002 == req.getElementType())
    {
      return getGEFWrapper(new AClassImplementedInterfacesCreateCommand(req, req.getSource(), req.getTarget()));
    }
    return null;
  }

  /**
   * Returns command to reorient EReference based link. New link target or source should be the domain model element
   * associated with this node.
   * 
   * @generated
   */
  protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req)
  {
    switch (getVisualID(req))
    {
    case AClassImplementedInterfacesEditPart.VISUAL_ID:
      return getGEFWrapper(new AClassImplementedInterfacesReorientCommand(req));
    }
    return super.getReorientReferenceRelationshipCommand(req);
  }

}
