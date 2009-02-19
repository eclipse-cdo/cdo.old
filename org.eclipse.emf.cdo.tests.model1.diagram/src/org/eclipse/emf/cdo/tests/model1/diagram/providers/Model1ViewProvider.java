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
package org.eclipse.emf.cdo.tests.model1.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CategoryEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CategoryNameEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CategoryProducts2EditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CategoryProductsEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CompanyEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CustomerEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CustomerNameEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.OrderAddressEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.OrderAddressNameEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.OrderDetailEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.OrderDetailPriceEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.OrderOrderDetails2EditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.OrderOrderDetailsEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.Product1EditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.Product1NameEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.PurchaseOrderDateEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.PurchaseOrderEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.SalesOrderCustomerEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.SalesOrderEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.SalesOrderIdEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.SupplierEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.SupplierNameEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.part.Model1VisualIDRegistry;
import org.eclipse.emf.cdo.tests.model1.diagram.view.factories.CategoryNameViewFactory;
import org.eclipse.emf.cdo.tests.model1.diagram.view.factories.CategoryProducts2ViewFactory;
import org.eclipse.emf.cdo.tests.model1.diagram.view.factories.CategoryProductsViewFactory;
import org.eclipse.emf.cdo.tests.model1.diagram.view.factories.CategoryViewFactory;
import org.eclipse.emf.cdo.tests.model1.diagram.view.factories.CompanyViewFactory;
import org.eclipse.emf.cdo.tests.model1.diagram.view.factories.CustomerNameViewFactory;
import org.eclipse.emf.cdo.tests.model1.diagram.view.factories.CustomerViewFactory;
import org.eclipse.emf.cdo.tests.model1.diagram.view.factories.OrderAddressNameViewFactory;
import org.eclipse.emf.cdo.tests.model1.diagram.view.factories.OrderAddressViewFactory;
import org.eclipse.emf.cdo.tests.model1.diagram.view.factories.OrderDetailPriceViewFactory;
import org.eclipse.emf.cdo.tests.model1.diagram.view.factories.OrderDetailViewFactory;
import org.eclipse.emf.cdo.tests.model1.diagram.view.factories.OrderOrderDetails2ViewFactory;
import org.eclipse.emf.cdo.tests.model1.diagram.view.factories.OrderOrderDetailsViewFactory;
import org.eclipse.emf.cdo.tests.model1.diagram.view.factories.Product1NameViewFactory;
import org.eclipse.emf.cdo.tests.model1.diagram.view.factories.Product1ViewFactory;
import org.eclipse.emf.cdo.tests.model1.diagram.view.factories.PurchaseOrderDateViewFactory;
import org.eclipse.emf.cdo.tests.model1.diagram.view.factories.PurchaseOrderViewFactory;
import org.eclipse.emf.cdo.tests.model1.diagram.view.factories.SalesOrderCustomerViewFactory;
import org.eclipse.emf.cdo.tests.model1.diagram.view.factories.SalesOrderIdViewFactory;
import org.eclipse.emf.cdo.tests.model1.diagram.view.factories.SalesOrderViewFactory;
import org.eclipse.emf.cdo.tests.model1.diagram.view.factories.SupplierNameViewFactory;
import org.eclipse.emf.cdo.tests.model1.diagram.view.factories.SupplierViewFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class Model1ViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter,
			String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (CompanyEditPart.MODEL_ID.equals(diagramKind)
				&& Model1VisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return CompanyViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		if (containerView == null) {
			return null;
		}
		IElementType elementType = getSemanticElementType(semanticAdapter);
		EObject domainElement = getSemanticElement(semanticAdapter);
		int visualID;
		if (semanticHint == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if (elementType != null || domainElement == null) {
				return null;
			}
			visualID = Model1VisualIDRegistry.getNodeVisualID(containerView,
					domainElement);
		} else {
			visualID = Model1VisualIDRegistry.getVisualID(semanticHint);
			if (elementType != null) {
				// Semantic hint is specified together with element type.
				// Both parameters should describe exactly the same diagram element.
				// In addition we check that visualID returned by VisualIDRegistry.getNodeVisualID() for
				// domainElement (if specified) is the same as in element type.
				if (!Model1ElementTypes.isKnownElementType(elementType)
						|| (!(elementType instanceof IHintedType))) {
					return null; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType)
						.getSemanticHint();
				if (!semanticHint.equals(elementTypeHint)) {
					return null; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null
						&& visualID != Model1VisualIDRegistry.getNodeVisualID(
								containerView, domainElement)) {
					return null; // visual id for node EClass should match visual id from element type
				}
			} else {
				// Element type is not specified. Domain element should be present (except pure design elements).
				// This method is called with EObjectAdapter as parameter from:
				//   - ViewService.createNode(View container, EObject eObject, String type, PreferencesHint preferencesHint) 
				//   - generated ViewFactory.decorateView() for parent element
				if (!CompanyEditPart.MODEL_ID.equals(Model1VisualIDRegistry
						.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case SupplierEditPart.VISUAL_ID:
				case CategoryEditPart.VISUAL_ID:
				case CustomerEditPart.VISUAL_ID:
				case PurchaseOrderEditPart.VISUAL_ID:
				case OrderDetailEditPart.VISUAL_ID:
				case Product1EditPart.VISUAL_ID:
				case SalesOrderEditPart.VISUAL_ID:
				case OrderAddressEditPart.VISUAL_ID:
					if (domainElement == null
							|| visualID != Model1VisualIDRegistry
									.getNodeVisualID(containerView,
											domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case SupplierNameEditPart.VISUAL_ID:
					if (SupplierEditPart.VISUAL_ID != Model1VisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case CategoryNameEditPart.VISUAL_ID:
					if (CategoryEditPart.VISUAL_ID != Model1VisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case CustomerNameEditPart.VISUAL_ID:
					if (CustomerEditPart.VISUAL_ID != Model1VisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case PurchaseOrderDateEditPart.VISUAL_ID:
					if (PurchaseOrderEditPart.VISUAL_ID != Model1VisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case OrderDetailPriceEditPart.VISUAL_ID:
					if (OrderDetailEditPart.VISUAL_ID != Model1VisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case Product1NameEditPart.VISUAL_ID:
					if (Product1EditPart.VISUAL_ID != Model1VisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case SalesOrderIdEditPart.VISUAL_ID:
					if (SalesOrderEditPart.VISUAL_ID != Model1VisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case OrderAddressNameEditPart.VISUAL_ID:
					if (OrderAddressEditPart.VISUAL_ID != Model1VisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				default:
					return null;
				}
			}
		}
		return getNodeViewClass(containerView, visualID);
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(View containerView, int visualID) {
		if (containerView == null
				|| !Model1VisualIDRegistry.canCreateNode(containerView,
						visualID)) {
			return null;
		}
		switch (visualID) {
		case SupplierEditPart.VISUAL_ID:
			return SupplierViewFactory.class;
		case SupplierNameEditPart.VISUAL_ID:
			return SupplierNameViewFactory.class;
		case CategoryEditPart.VISUAL_ID:
			return CategoryViewFactory.class;
		case CategoryNameEditPart.VISUAL_ID:
			return CategoryNameViewFactory.class;
		case CustomerEditPart.VISUAL_ID:
			return CustomerViewFactory.class;
		case CustomerNameEditPart.VISUAL_ID:
			return CustomerNameViewFactory.class;
		case PurchaseOrderEditPart.VISUAL_ID:
			return PurchaseOrderViewFactory.class;
		case PurchaseOrderDateEditPart.VISUAL_ID:
			return PurchaseOrderDateViewFactory.class;
		case OrderDetailEditPart.VISUAL_ID:
			return OrderDetailViewFactory.class;
		case OrderDetailPriceEditPart.VISUAL_ID:
			return OrderDetailPriceViewFactory.class;
		case Product1EditPart.VISUAL_ID:
			return Product1ViewFactory.class;
		case Product1NameEditPart.VISUAL_ID:
			return Product1NameViewFactory.class;
		case SalesOrderEditPart.VISUAL_ID:
			return SalesOrderViewFactory.class;
		case SalesOrderIdEditPart.VISUAL_ID:
			return SalesOrderIdViewFactory.class;
		case OrderAddressEditPart.VISUAL_ID:
			return OrderAddressViewFactory.class;
		case OrderAddressNameEditPart.VISUAL_ID:
			return OrderAddressNameViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (!Model1ElementTypes.isKnownElementType(elementType)
				|| (!(elementType instanceof IHintedType))) {
			return null; // foreign element type
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null) {
			return null; // our hint is visual id and must be specified
		}
		if (semanticHint != null && !semanticHint.equals(elementTypeHint)) {
			return null; // if semantic hint is specified it should be the same as in element type
		}
		int visualID = Model1VisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if (domainElement != null
				&& visualID != Model1VisualIDRegistry
						.getLinkWithClassVisualID(domainElement)) {
			return null; // visual id for link EClass should match visual id from element type
		}
		return getEdgeViewClass(visualID);
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(int visualID) {
		switch (visualID) {
		case CategoryProducts2EditPart.VISUAL_ID:
			return CategoryProducts2ViewFactory.class;
		case CategoryProductsEditPart.VISUAL_ID:
			return CategoryProductsViewFactory.class;
		case SalesOrderCustomerEditPart.VISUAL_ID:
			return SalesOrderCustomerViewFactory.class;
		case OrderOrderDetails2EditPart.VISUAL_ID:
			return OrderOrderDetails2ViewFactory.class;
		case OrderOrderDetailsEditPart.VISUAL_ID:
			return OrderOrderDetailsViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}
}
