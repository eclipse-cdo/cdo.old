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

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.cdo.tests.model1.Category;
import org.eclipse.emf.cdo.tests.model1.Company;
import org.eclipse.emf.cdo.tests.model1.Customer;
import org.eclipse.emf.cdo.tests.model1.Model1Package;
import org.eclipse.emf.cdo.tests.model1.Order;
import org.eclipse.emf.cdo.tests.model1.OrderAddress;
import org.eclipse.emf.cdo.tests.model1.OrderDetail;
import org.eclipse.emf.cdo.tests.model1.Product1;
import org.eclipse.emf.cdo.tests.model1.PurchaseOrder;
import org.eclipse.emf.cdo.tests.model1.SalesOrder;
import org.eclipse.emf.cdo.tests.model1.Supplier;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CategoryEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CategoryProducts2EditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CategoryProductsEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CompanyEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CustomerEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.OrderAddressEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.OrderDetailEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.OrderOrderDetails2EditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.OrderOrderDetailsEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.Product1EditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.PurchaseOrderEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.SalesOrderCustomerEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.SalesOrderEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.SupplierEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.providers.Model1ElementTypes;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class Model1DiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (Model1VisualIDRegistry.getVisualID(view)) {
		case CompanyEditPart.VISUAL_ID:
			return getCompany_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCompany_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Company modelElement = (Company) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getSuppliers().iterator(); it.hasNext();) {
			Supplier childElement = (Supplier) it.next();
			int visualID = Model1VisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == SupplierEditPart.VISUAL_ID) {
				result.add(new Model1NodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getCategories().iterator(); it
				.hasNext();) {
			Category childElement = (Category) it.next();
			int visualID = Model1VisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == CategoryEditPart.VISUAL_ID) {
				result.add(new Model1NodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getCustomers().iterator(); it.hasNext();) {
			Customer childElement = (Customer) it.next();
			int visualID = Model1VisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == CustomerEditPart.VISUAL_ID) {
				result.add(new Model1NodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getPurchaseOrders().iterator(); it
				.hasNext();) {
			PurchaseOrder childElement = (PurchaseOrder) it.next();
			int visualID = Model1VisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == PurchaseOrderEditPart.VISUAL_ID) {
				result.add(new Model1NodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getSalesOrders().iterator(); it
				.hasNext();) {
			SalesOrder childElement = (SalesOrder) it.next();
			int visualID = Model1VisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == OrderDetailEditPart.VISUAL_ID) {
				result.add(new Model1NodeDescriptor(childElement, visualID));
				continue;
			}
		}
		Resource resource = modelElement.eResource();
		for (Iterator semanticIterator = getPhantomNodesIterator(resource); semanticIterator
				.hasNext();) {
			EObject childElement = (EObject) semanticIterator.next();
			if (childElement == modelElement) {
				continue;
			}
			if (Model1VisualIDRegistry.getNodeVisualID(view, childElement) == Product1EditPart.VISUAL_ID) {
				result.add(new Model1NodeDescriptor(childElement,
						Product1EditPart.VISUAL_ID));
				continue;
			}
			if (Model1VisualIDRegistry.getNodeVisualID(view, childElement) == SalesOrderEditPart.VISUAL_ID) {
				result.add(new Model1NodeDescriptor(childElement,
						SalesOrderEditPart.VISUAL_ID));
				continue;
			}
			if (Model1VisualIDRegistry.getNodeVisualID(view, childElement) == OrderAddressEditPart.VISUAL_ID) {
				result.add(new Model1NodeDescriptor(childElement,
						OrderAddressEditPart.VISUAL_ID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Iterator getPhantomNodesIterator(Resource resource) {
		return resource.getAllContents();
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (Model1VisualIDRegistry.getVisualID(view)) {
		case CompanyEditPart.VISUAL_ID:
			return getCompany_1000ContainedLinks(view);
		case SupplierEditPart.VISUAL_ID:
			return getSupplier_2001ContainedLinks(view);
		case CategoryEditPart.VISUAL_ID:
			return getCategory_2002ContainedLinks(view);
		case CustomerEditPart.VISUAL_ID:
			return getCustomer_2003ContainedLinks(view);
		case PurchaseOrderEditPart.VISUAL_ID:
			return getPurchaseOrder_2004ContainedLinks(view);
		case OrderDetailEditPart.VISUAL_ID:
			return getSalesOrder_2005ContainedLinks(view);
		case Product1EditPart.VISUAL_ID:
			return getOrderAddress_2006ContainedLinks(view);
		case SalesOrderEditPart.VISUAL_ID:
			return getOrderDetail_2007ContainedLinks(view);
		case OrderAddressEditPart.VISUAL_ID:
			return getProduct1_2008ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (Model1VisualIDRegistry.getVisualID(view)) {
		case SupplierEditPart.VISUAL_ID:
			return getSupplier_2001IncomingLinks(view);
		case CategoryEditPart.VISUAL_ID:
			return getCategory_2002IncomingLinks(view);
		case CustomerEditPart.VISUAL_ID:
			return getCustomer_2003IncomingLinks(view);
		case PurchaseOrderEditPart.VISUAL_ID:
			return getPurchaseOrder_2004IncomingLinks(view);
		case OrderDetailEditPart.VISUAL_ID:
			return getSalesOrder_2005IncomingLinks(view);
		case Product1EditPart.VISUAL_ID:
			return getOrderAddress_2006IncomingLinks(view);
		case SalesOrderEditPart.VISUAL_ID:
			return getOrderDetail_2007IncomingLinks(view);
		case OrderAddressEditPart.VISUAL_ID:
			return getProduct1_2008IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (Model1VisualIDRegistry.getVisualID(view)) {
		case SupplierEditPart.VISUAL_ID:
			return getSupplier_2001OutgoingLinks(view);
		case CategoryEditPart.VISUAL_ID:
			return getCategory_2002OutgoingLinks(view);
		case CustomerEditPart.VISUAL_ID:
			return getCustomer_2003OutgoingLinks(view);
		case PurchaseOrderEditPart.VISUAL_ID:
			return getPurchaseOrder_2004OutgoingLinks(view);
		case OrderDetailEditPart.VISUAL_ID:
			return getSalesOrder_2005OutgoingLinks(view);
		case Product1EditPart.VISUAL_ID:
			return getOrderAddress_2006OutgoingLinks(view);
		case SalesOrderEditPart.VISUAL_ID:
			return getOrderDetail_2007OutgoingLinks(view);
		case OrderAddressEditPart.VISUAL_ID:
			return getProduct1_2008OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCompany_1000ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getSupplier_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCategory_2002ContainedLinks(View view) {
		Category modelElement = (Category) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Category_Products_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCustomer_2003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPurchaseOrder_2004ContainedLinks(View view) {
		PurchaseOrder modelElement = (PurchaseOrder) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_PurchaseOrder_Supplier_4002(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Order_OrderDetails_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSalesOrder_2005ContainedLinks(View view) {
		SalesOrder modelElement = (SalesOrder) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_SalesOrder_Customer_4003(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Order_OrderDetails_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOrderAddress_2006ContainedLinks(View view) {
		OrderAddress modelElement = (OrderAddress) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Order_OrderDetails_4004(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_OrderDetail_Product_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOrderDetail_2007ContainedLinks(View view) {
		OrderDetail modelElement = (OrderDetail) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_OrderDetail_Product_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProduct1_2008ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getSupplier_2001IncomingLinks(View view) {
		Supplier modelElement = (Supplier) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_PurchaseOrder_Supplier_4002(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCategory_2002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCustomer_2003IncomingLinks(View view) {
		Customer modelElement = (Customer) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_SalesOrder_Customer_4003(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPurchaseOrder_2004IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getSalesOrder_2005IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOrderAddress_2006IncomingLinks(View view) {
		OrderAddress modelElement = (OrderAddress) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_Order_OrderDetails_4004(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOrderDetail_2007IncomingLinks(View view) {
		OrderDetail modelElement = (OrderDetail) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_Order_OrderDetails_4004(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProduct1_2008IncomingLinks(View view) {
		Product1 modelElement = (Product1) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Category_Products_4001(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_OrderDetail_Product_4005(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSupplier_2001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getCategory_2002OutgoingLinks(View view) {
		Category modelElement = (Category) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Category_Products_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getCustomer_2003OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPurchaseOrder_2004OutgoingLinks(View view) {
		PurchaseOrder modelElement = (PurchaseOrder) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_PurchaseOrder_Supplier_4002(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Order_OrderDetails_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSalesOrder_2005OutgoingLinks(View view) {
		SalesOrder modelElement = (SalesOrder) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_SalesOrder_Customer_4003(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Order_OrderDetails_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOrderAddress_2006OutgoingLinks(View view) {
		OrderAddress modelElement = (OrderAddress) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Order_OrderDetails_4004(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_OrderDetail_Product_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getOrderDetail_2007OutgoingLinks(View view) {
		OrderDetail modelElement = (OrderDetail) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_OrderDetail_Product_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProduct1_2008OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Category_Products_4001(
			Product1 target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == Model1Package.eINSTANCE
					.getCategory_Products()) {
				result.add(new Model1LinkDescriptor(setting.getEObject(),
						target, Model1ElementTypes.CategoryProducts_4001,
						CategoryProducts2EditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_PurchaseOrder_Supplier_4002(
			Supplier target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == Model1Package.eINSTANCE
					.getPurchaseOrder_Supplier()) {
				result.add(new Model1LinkDescriptor(setting.getEObject(),
						target, Model1ElementTypes.PurchaseOrderSupplier_4002,
						CategoryProductsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_SalesOrder_Customer_4003(
			Customer target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == Model1Package.eINSTANCE
					.getSalesOrder_Customer()) {
				result.add(new Model1LinkDescriptor(setting.getEObject(),
						target, Model1ElementTypes.SalesOrderCustomer_4003,
						SalesOrderCustomerEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Order_OrderDetails_4004(
			OrderDetail target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == Model1Package.eINSTANCE
					.getOrder_OrderDetails()) {
				result.add(new Model1LinkDescriptor(setting.getEObject(),
						target, Model1ElementTypes.OrderOrderDetails_4004,
						OrderOrderDetails2EditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_OrderDetail_Product_4005(
			Product1 target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == Model1Package.eINSTANCE
					.getOrderDetail_Product()) {
				result.add(new Model1LinkDescriptor(setting.getEObject(),
						target, Model1ElementTypes.OrderDetailProduct_4005,
						OrderOrderDetailsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Category_Products_4001(
			Category source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getProducts().iterator(); destinations
				.hasNext();) {
			Product1 destination = (Product1) destinations.next();
			result.add(new Model1LinkDescriptor(source, destination,
					Model1ElementTypes.CategoryProducts_4001,
					CategoryProducts2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_PurchaseOrder_Supplier_4002(
			PurchaseOrder source) {
		Collection result = new LinkedList();
		Supplier destination = source.getSupplier();
		if (destination == null) {
			return result;
		}
		result.add(new Model1LinkDescriptor(source, destination,
				Model1ElementTypes.PurchaseOrderSupplier_4002,
				CategoryProductsEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_SalesOrder_Customer_4003(
			SalesOrder source) {
		Collection result = new LinkedList();
		Customer destination = source.getCustomer();
		if (destination == null) {
			return result;
		}
		result.add(new Model1LinkDescriptor(source, destination,
				Model1ElementTypes.SalesOrderCustomer_4003,
				SalesOrderCustomerEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Order_OrderDetails_4004(
			Order source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getOrderDetails().iterator(); destinations
				.hasNext();) {
			OrderDetail destination = (OrderDetail) destinations.next();
			result.add(new Model1LinkDescriptor(source, destination,
					Model1ElementTypes.OrderOrderDetails_4004,
					OrderOrderDetails2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_OrderDetail_Product_4005(
			OrderDetail source) {
		Collection result = new LinkedList();
		Product1 destination = source.getProduct();
		if (destination == null) {
			return result;
		}
		result.add(new Model1LinkDescriptor(source, destination,
				Model1ElementTypes.OrderDetailProduct_4005,
				OrderOrderDetailsEditPart.VISUAL_ID));
		return result;
	}

}
