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
package org.eclipse.emf.cdo.tests.model1.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.cdo.tests.model1.Company;
import org.eclipse.emf.cdo.tests.model1.Model1Package;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CategoryEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CategoryNameEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CompanyEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CustomerEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CustomerNameEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.OrderAddressEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.OrderAddressNameEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.OrderDetailEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.OrderDetailPriceEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.Product1EditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.Product1NameEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.PurchaseOrderDateEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.PurchaseOrderEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.SalesOrderEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.SalesOrderIdEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.SupplierEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.SupplierNameEditPart;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class Model1VisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.eclipse.emf.cdo.tests.model1.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (CompanyEditPart.MODEL_ID.equals(view.getType())) {
				return CompanyEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.emf.cdo.tests.model1.diagram.part.Model1VisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				Model1DiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (Model1Package.eINSTANCE.getCompany().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Company) domainElement)) {
			return CompanyEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.eclipse.emf.cdo.tests.model1.diagram.part.Model1VisualIDRegistry
				.getModelID(containerView);
		if (!CompanyEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (CompanyEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.emf.cdo.tests.model1.diagram.part.Model1VisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = CompanyEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case CompanyEditPart.VISUAL_ID:
			if (Model1Package.eINSTANCE.getSupplier().isSuperTypeOf(
					domainElement.eClass())) {
				return SupplierEditPart.VISUAL_ID;
			}
			if (Model1Package.eINSTANCE.getCategory().isSuperTypeOf(
					domainElement.eClass())) {
				return CategoryEditPart.VISUAL_ID;
			}
			if (Model1Package.eINSTANCE.getCustomer().isSuperTypeOf(
					domainElement.eClass())) {
				return CustomerEditPart.VISUAL_ID;
			}
			if (Model1Package.eINSTANCE.getPurchaseOrder().isSuperTypeOf(
					domainElement.eClass())) {
				return PurchaseOrderEditPart.VISUAL_ID;
			}
			if (Model1Package.eINSTANCE.getSalesOrder().isSuperTypeOf(
					domainElement.eClass())) {
				return OrderDetailEditPart.VISUAL_ID;
			}
			if (Model1Package.eINSTANCE.getOrderAddress().isSuperTypeOf(
					domainElement.eClass())) {
				return Product1EditPart.VISUAL_ID;
			}
			if (Model1Package.eINSTANCE.getOrderDetail().isSuperTypeOf(
					domainElement.eClass())) {
				return SalesOrderEditPart.VISUAL_ID;
			}
			if (Model1Package.eINSTANCE.getProduct1().isSuperTypeOf(
					domainElement.eClass())) {
				return OrderAddressEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.emf.cdo.tests.model1.diagram.part.Model1VisualIDRegistry
				.getModelID(containerView);
		if (!CompanyEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (CompanyEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.emf.cdo.tests.model1.diagram.part.Model1VisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = CompanyEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case SupplierEditPart.VISUAL_ID:
			if (SupplierNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CategoryEditPart.VISUAL_ID:
			if (CategoryNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CustomerEditPart.VISUAL_ID:
			if (CustomerNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PurchaseOrderEditPart.VISUAL_ID:
			if (PurchaseOrderDateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OrderDetailEditPart.VISUAL_ID:
			if (OrderDetailPriceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Product1EditPart.VISUAL_ID:
			if (Product1NameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SalesOrderEditPart.VISUAL_ID:
			if (SalesOrderIdEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OrderAddressEditPart.VISUAL_ID:
			if (OrderAddressNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CompanyEditPart.VISUAL_ID:
			if (SupplierEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CategoryEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CustomerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PurchaseOrderEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OrderDetailEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Product1EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SalesOrderEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OrderAddressEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Company element) {
		return true;
	}

}
