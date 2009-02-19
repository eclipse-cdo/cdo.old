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
package org.eclipse.emf.cdo.tests.model1.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.cdo.tests.model1.Company;
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
import org.eclipse.emf.cdo.tests.model1.diagram.part.Model1DiagramEditorPlugin;
import org.eclipse.emf.cdo.tests.model1.diagram.part.Model1VisualIDRegistry;
import org.eclipse.emf.cdo.tests.model1.diagram.providers.Model1ElementTypes;
import org.eclipse.emf.cdo.tests.model1.diagram.providers.Model1ParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
public class Model1NavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		Model1DiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		Model1DiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof Model1NavigatorItem
				&& !isOwnView(((Model1NavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof Model1NavigatorGroup) {
			Model1NavigatorGroup group = (Model1NavigatorGroup) element;
			return Model1DiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof Model1NavigatorItem) {
			Model1NavigatorItem navigatorItem = (Model1NavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (Model1VisualIDRegistry.getVisualID(view)) {
		case CompanyEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://www.eclipse.org/emf/CDO/tests/model1/1.0.0?Company", Model1ElementTypes.Company_1000); //$NON-NLS-1$
		case SupplierEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.eclipse.org/emf/CDO/tests/model1/1.0.0?Supplier", Model1ElementTypes.Supplier_2001); //$NON-NLS-1$
		case CategoryEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.eclipse.org/emf/CDO/tests/model1/1.0.0?Category", Model1ElementTypes.Category_2002); //$NON-NLS-1$
		case CustomerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.eclipse.org/emf/CDO/tests/model1/1.0.0?Customer", Model1ElementTypes.Customer_2003); //$NON-NLS-1$
		case PurchaseOrderEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.eclipse.org/emf/CDO/tests/model1/1.0.0?PurchaseOrder", Model1ElementTypes.PurchaseOrder_2004); //$NON-NLS-1$
		case OrderDetailEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.eclipse.org/emf/CDO/tests/model1/1.0.0?SalesOrder", Model1ElementTypes.SalesOrder_2005); //$NON-NLS-1$
		case Product1EditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.eclipse.org/emf/CDO/tests/model1/1.0.0?OrderAddress", Model1ElementTypes.OrderAddress_2006); //$NON-NLS-1$
		case SalesOrderEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.eclipse.org/emf/CDO/tests/model1/1.0.0?OrderDetail", Model1ElementTypes.OrderDetail_2007); //$NON-NLS-1$
		case OrderAddressEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.eclipse.org/emf/CDO/tests/model1/1.0.0?Product1", Model1ElementTypes.Product1_2008); //$NON-NLS-1$
		case CategoryProducts2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.eclipse.org/emf/CDO/tests/model1/1.0.0?Category?products", Model1ElementTypes.CategoryProducts_4001); //$NON-NLS-1$
		case CategoryProductsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.eclipse.org/emf/CDO/tests/model1/1.0.0?PurchaseOrder?supplier", Model1ElementTypes.PurchaseOrderSupplier_4002); //$NON-NLS-1$
		case SalesOrderCustomerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.eclipse.org/emf/CDO/tests/model1/1.0.0?SalesOrder?customer", Model1ElementTypes.SalesOrderCustomer_4003); //$NON-NLS-1$
		case OrderOrderDetails2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.eclipse.org/emf/CDO/tests/model1/1.0.0?Order?orderDetails", Model1ElementTypes.OrderOrderDetails_4004); //$NON-NLS-1$
		case OrderOrderDetailsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.eclipse.org/emf/CDO/tests/model1/1.0.0?OrderDetail?product", Model1ElementTypes.OrderDetailProduct_4005); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = Model1DiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& Model1ElementTypes.isKnownElementType(elementType)) {
			image = Model1ElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof Model1NavigatorGroup) {
			Model1NavigatorGroup group = (Model1NavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof Model1NavigatorItem) {
			Model1NavigatorItem navigatorItem = (Model1NavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (Model1VisualIDRegistry.getVisualID(view)) {
		case CompanyEditPart.VISUAL_ID:
			return getCompany_1000Text(view);
		case SupplierEditPart.VISUAL_ID:
			return getSupplier_2001Text(view);
		case CategoryEditPart.VISUAL_ID:
			return getCategory_2002Text(view);
		case CustomerEditPart.VISUAL_ID:
			return getCustomer_2003Text(view);
		case PurchaseOrderEditPart.VISUAL_ID:
			return getPurchaseOrder_2004Text(view);
		case OrderDetailEditPart.VISUAL_ID:
			return getSalesOrder_2005Text(view);
		case Product1EditPart.VISUAL_ID:
			return getOrderAddress_2006Text(view);
		case SalesOrderEditPart.VISUAL_ID:
			return getOrderDetail_2007Text(view);
		case OrderAddressEditPart.VISUAL_ID:
			return getProduct1_2008Text(view);
		case CategoryProducts2EditPart.VISUAL_ID:
			return getCategoryProducts_4001Text(view);
		case CategoryProductsEditPart.VISUAL_ID:
			return getPurchaseOrderSupplier_4002Text(view);
		case SalesOrderCustomerEditPart.VISUAL_ID:
			return getSalesOrderCustomer_4003Text(view);
		case OrderOrderDetails2EditPart.VISUAL_ID:
			return getOrderOrderDetails_4004Text(view);
		case OrderOrderDetailsEditPart.VISUAL_ID:
			return getOrderDetailProduct_4005Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getCompany_1000Text(View view) {
		Company domainModelElement = (Company) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			Model1DiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSupplier_2001Text(View view) {
		IAdaptable hintAdapter = new Model1ParserProvider.HintAdapter(
				Model1ElementTypes.Supplier_2001,
				(view.getElement() != null ? view.getElement() : view),
				Model1VisualIDRegistry.getType(SupplierNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			Model1DiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getCategory_2002Text(View view) {
		IAdaptable hintAdapter = new Model1ParserProvider.HintAdapter(
				Model1ElementTypes.Category_2002,
				(view.getElement() != null ? view.getElement() : view),
				Model1VisualIDRegistry.getType(CategoryNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			Model1DiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getCustomer_2003Text(View view) {
		IAdaptable hintAdapter = new Model1ParserProvider.HintAdapter(
				Model1ElementTypes.Customer_2003,
				(view.getElement() != null ? view.getElement() : view),
				Model1VisualIDRegistry.getType(CustomerNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			Model1DiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getPurchaseOrder_2004Text(View view) {
		IAdaptable hintAdapter = new Model1ParserProvider.HintAdapter(
				Model1ElementTypes.PurchaseOrder_2004,
				(view.getElement() != null ? view.getElement() : view),
				Model1VisualIDRegistry
						.getType(PurchaseOrderDateEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			Model1DiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getSalesOrder_2005Text(View view) {
		IAdaptable hintAdapter = new Model1ParserProvider.HintAdapter(
				Model1ElementTypes.SalesOrder_2005,
				(view.getElement() != null ? view.getElement() : view),
				Model1VisualIDRegistry
						.getType(OrderDetailPriceEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			Model1DiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getOrderAddress_2006Text(View view) {
		IAdaptable hintAdapter = new Model1ParserProvider.HintAdapter(
				Model1ElementTypes.OrderAddress_2006,
				(view.getElement() != null ? view.getElement() : view),
				Model1VisualIDRegistry.getType(Product1NameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			Model1DiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getOrderDetail_2007Text(View view) {
		IAdaptable hintAdapter = new Model1ParserProvider.HintAdapter(
				Model1ElementTypes.OrderDetail_2007,
				(view.getElement() != null ? view.getElement() : view),
				Model1VisualIDRegistry.getType(SalesOrderIdEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			Model1DiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getProduct1_2008Text(View view) {
		IAdaptable hintAdapter = new Model1ParserProvider.HintAdapter(
				Model1ElementTypes.Product1_2008,
				(view.getElement() != null ? view.getElement() : view),
				Model1VisualIDRegistry
						.getType(OrderAddressNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			Model1DiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getCategoryProducts_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getPurchaseOrderSupplier_4002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getSalesOrderCustomer_4003Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getOrderOrderDetails_4004Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getOrderDetailProduct_4005Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return CompanyEditPart.MODEL_ID.equals(Model1VisualIDRegistry
				.getModelID(view));
	}

}
