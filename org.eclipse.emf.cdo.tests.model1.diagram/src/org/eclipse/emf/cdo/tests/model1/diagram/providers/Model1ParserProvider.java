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
import org.eclipse.emf.cdo.tests.model1.Model1Package;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CategoryNameEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CustomerNameEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.OrderAddressNameEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.OrderDetailPriceEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.Product1NameEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.PurchaseOrderDateEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.SalesOrderIdEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.SupplierNameEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.parsers.MessageFormatParser;
import org.eclipse.emf.cdo.tests.model1.diagram.part.Model1VisualIDRegistry;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class Model1ParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser supplierName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getSupplierName_5001Parser() {
		if (supplierName_5001Parser == null) {
			supplierName_5001Parser = createSupplierName_5001Parser();
		}
		return supplierName_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createSupplierName_5001Parser() {
		EAttribute[] features = new EAttribute[] { Model1Package.eINSTANCE
				.getAddress_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser categoryName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getCategoryName_5002Parser() {
		if (categoryName_5002Parser == null) {
			categoryName_5002Parser = createCategoryName_5002Parser();
		}
		return categoryName_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCategoryName_5002Parser() {
		EAttribute[] features = new EAttribute[] { Model1Package.eINSTANCE
				.getCategory_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser customerName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getCustomerName_5003Parser() {
		if (customerName_5003Parser == null) {
			customerName_5003Parser = createCustomerName_5003Parser();
		}
		return customerName_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createCustomerName_5003Parser() {
		EAttribute[] features = new EAttribute[] { Model1Package.eINSTANCE
				.getAddress_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser purchaseOrderDate_5004Parser;

	/**
	 * @generated
	 */
	private IParser getPurchaseOrderDate_5004Parser() {
		if (purchaseOrderDate_5004Parser == null) {
			purchaseOrderDate_5004Parser = createPurchaseOrderDate_5004Parser();
		}
		return purchaseOrderDate_5004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPurchaseOrderDate_5004Parser() {
		EAttribute[] features = new EAttribute[] { Model1Package.eINSTANCE
				.getPurchaseOrder_Date(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser salesOrderId_5005Parser;

	/**
	 * @generated
	 */
	private IParser getSalesOrderId_5005Parser() {
		if (salesOrderId_5005Parser == null) {
			salesOrderId_5005Parser = createSalesOrderId_5005Parser();
		}
		return salesOrderId_5005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createSalesOrderId_5005Parser() {
		EAttribute[] features = new EAttribute[] { Model1Package.eINSTANCE
				.getSalesOrder_Id(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser orderAddressName_5006Parser;

	/**
	 * @generated
	 */
	private IParser getOrderAddressName_5006Parser() {
		if (orderAddressName_5006Parser == null) {
			orderAddressName_5006Parser = createOrderAddressName_5006Parser();
		}
		return orderAddressName_5006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createOrderAddressName_5006Parser() {
		EAttribute[] features = new EAttribute[] { Model1Package.eINSTANCE
				.getAddress_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser orderDetailPrice_5007Parser;

	/**
	 * @generated
	 */
	private IParser getOrderDetailPrice_5007Parser() {
		if (orderDetailPrice_5007Parser == null) {
			orderDetailPrice_5007Parser = createOrderDetailPrice_5007Parser();
		}
		return orderDetailPrice_5007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createOrderDetailPrice_5007Parser() {
		EAttribute[] features = new EAttribute[] { Model1Package.eINSTANCE
				.getOrderDetail_Price(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser product1Name_5008Parser;

	/**
	 * @generated
	 */
	private IParser getProduct1Name_5008Parser() {
		if (product1Name_5008Parser == null) {
			product1Name_5008Parser = createProduct1Name_5008Parser();
		}
		return product1Name_5008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createProduct1Name_5008Parser() {
		EAttribute[] features = new EAttribute[] { Model1Package.eINSTANCE
				.getProduct1_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case SupplierNameEditPart.VISUAL_ID:
			return getSupplierName_5001Parser();
		case CategoryNameEditPart.VISUAL_ID:
			return getCategoryName_5002Parser();
		case CustomerNameEditPart.VISUAL_ID:
			return getCustomerName_5003Parser();
		case PurchaseOrderDateEditPart.VISUAL_ID:
			return getPurchaseOrderDate_5004Parser();
		case OrderDetailPriceEditPart.VISUAL_ID:
			return getSalesOrderId_5005Parser();
		case Product1NameEditPart.VISUAL_ID:
			return getOrderAddressName_5006Parser();
		case SalesOrderIdEditPart.VISUAL_ID:
			return getOrderDetailPrice_5007Parser();
		case OrderAddressNameEditPart.VISUAL_ID:
			return getProduct1Name_5008Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(Model1VisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(Model1VisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (Model1ElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
