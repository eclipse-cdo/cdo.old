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

import org.eclipse.emf.cdo.tests.model1.Model1Package;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.commands.CategoryCreateCommand;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.commands.CustomerCreateCommand;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.commands.OrderAddressCreateCommand;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.commands.OrderDetailCreateCommand;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.commands.Product1CreateCommand;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.commands.PurchaseOrderCreateCommand;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.commands.SalesOrderCreateCommand;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.commands.SupplierCreateCommand;
import org.eclipse.emf.cdo.tests.model1.diagram.providers.Model1ElementTypes;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

/**
 * @generated
 */
public class CompanyItemSemanticEditPolicy extends
		Model1BaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (Model1ElementTypes.Supplier_2001 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(Model1Package.eINSTANCE
						.getCompany_Suppliers());
			}
			return getGEFWrapper(new SupplierCreateCommand(req));
		}
		if (Model1ElementTypes.Category_2002 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(Model1Package.eINSTANCE
						.getCompany_Categories());
			}
			return getGEFWrapper(new CategoryCreateCommand(req));
		}
		if (Model1ElementTypes.Customer_2003 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(Model1Package.eINSTANCE
						.getCompany_Customers());
			}
			return getGEFWrapper(new CustomerCreateCommand(req));
		}
		if (Model1ElementTypes.PurchaseOrder_2004 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(Model1Package.eINSTANCE
						.getCompany_PurchaseOrders());
			}
			return getGEFWrapper(new PurchaseOrderCreateCommand(req));
		}
		if (Model1ElementTypes.SalesOrder_2005 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(Model1Package.eINSTANCE
						.getCompany_SalesOrders());
			}
			return getGEFWrapper(new OrderDetailCreateCommand(req));
		}
		if (Model1ElementTypes.OrderAddress_2006 == req.getElementType()) {
			return getGEFWrapper(new Product1CreateCommand(req));
		}
		if (Model1ElementTypes.OrderDetail_2007 == req.getElementType()) {
			return getGEFWrapper(new SalesOrderCreateCommand(req));
		}
		if (Model1ElementTypes.Product1_2008 == req.getElementType()) {
			return getGEFWrapper(new OrderAddressCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}

	}

}
