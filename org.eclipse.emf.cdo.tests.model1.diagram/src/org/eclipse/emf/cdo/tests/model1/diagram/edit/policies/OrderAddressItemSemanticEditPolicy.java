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

import org.eclipse.emf.cdo.tests.model1.diagram.edit.commands.CategoryProducts2CreateCommand;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.commands.CategoryProducts2ReorientCommand;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.commands.OrderOrderDetailsCreateCommand;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.commands.OrderOrderDetailsReorientCommand;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CategoryProducts2EditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.OrderOrderDetailsEditPart;
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
public class OrderAddressItemSemanticEditPolicy extends
		Model1BaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyShortcutsCommand(cc);
		View view = (View) getHost().getModel();
		if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
			req.setElementToDestroy(view);
		}
		cc.add(getGEFWrapper(new DestroyElementCommand(req)));
		return cc.unwrap();
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super
				.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (Model1ElementTypes.CategoryProducts_4001 == req.getElementType()) {
			return null;
		}
		if (Model1ElementTypes.OrderDetailProduct_4005 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (Model1ElementTypes.CategoryProducts_4001 == req.getElementType()) {
			return getGEFWrapper(new CategoryProducts2CreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (Model1ElementTypes.OrderDetailProduct_4005 == req.getElementType()) {
			return getGEFWrapper(new OrderOrderDetailsCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case CategoryProducts2EditPart.VISUAL_ID:
			return getGEFWrapper(new CategoryProducts2ReorientCommand(req));
		case OrderOrderDetailsEditPart.VISUAL_ID:
			return getGEFWrapper(new OrderOrderDetailsReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
