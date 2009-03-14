/*
 * Copyright (c) 2008 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Victor Roldan Betancort - GMF models creation and initial generation
 *    Eike Stepper - maintenance
 */
package org.eclipse.emf.cdo.tests.model1.diagram.edit.policies;

import org.eclipse.emf.cdo.tests.model1.diagram.edit.commands.CategoryProductsCreateCommand;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.commands.CategoryProductsReorientCommand;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.commands.OrderOrderDetails2CreateCommand;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.commands.OrderOrderDetails2ReorientCommand;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CategoryProductsEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.OrderOrderDetails2EditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.providers.Model1ElementTypes;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class PurchaseOrderItemSemanticEditPolicy extends Model1BaseItemSemanticEditPolicy
{

  /**
   * @generated
   */
  protected Command getDestroyElementCommand(DestroyElementRequest req)
  {
    CompoundCommand cc = getDestroyEdgesCommand();
    addDestroyShortcutsCommand(cc);
    View view = (View)getHost().getModel();
    if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
      req.setElementToDestroy(view);
    }
    cc.add(getGEFWrapper(new DestroyElementCommand(req)));
    return cc.unwrap();
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
    if (Model1ElementTypes.PurchaseOrderSupplier_4002 == req.getElementType())
    {
      return getGEFWrapper(new CategoryProductsCreateCommand(req, req.getSource(), req.getTarget()));
    }
    if (Model1ElementTypes.OrderOrderDetails_4004 == req.getElementType())
    {
      return getGEFWrapper(new OrderOrderDetails2CreateCommand(req, req.getSource(), req.getTarget()));
    }
    return null;
  }

  /**
   * @generated
   */
  protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req)
  {
    if (Model1ElementTypes.PurchaseOrderSupplier_4002 == req.getElementType())
    {
      return null;
    }
    if (Model1ElementTypes.OrderOrderDetails_4004 == req.getElementType())
    {
      return null;
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
    case CategoryProductsEditPart.VISUAL_ID:
      return getGEFWrapper(new CategoryProductsReorientCommand(req));
    case OrderOrderDetails2EditPart.VISUAL_ID:
      return getGEFWrapper(new OrderOrderDetails2ReorientCommand(req));
    }
    return super.getReorientReferenceRelationshipCommand(req);
  }

}
