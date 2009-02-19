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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.cdo.tests.model1.diagram.providers.Model1ElementTypes;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

/**
 * @generated
 */
public class Model1PaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createElements1Group());
		paletteRoot.add(createLinks2Group());
	}

	/**
	 * Creates "Elements" palette tool group
	 * @generated
	 */
	private PaletteContainer createElements1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Elements1Group_title);
		paletteContainer.add(createCategory1CreationTool());
		paletteContainer.add(createSupplier2CreationTool());
		paletteContainer.add(createCustomer3CreationTool());
		paletteContainer.add(createPurchaseOrder4CreationTool());
		paletteContainer.add(createSalesOrder5CreationTool());
		paletteContainer.add(createOrderDetail6CreationTool());
		paletteContainer.add(createProduct17CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Links" palette tool group
	 * @generated
	 */
	private PaletteContainer createLinks2Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Links2Group_title);
		paletteContainer.add(createSupplier1CreationTool());
		paletteContainer.add(createCustomer2CreationTool());
		paletteContainer.add(createOrderDetail3CreationTool());
		paletteContainer.add(createProduct4CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCategory1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(Model1ElementTypes.Category_2002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Category1CreationTool_title, null, types);
		entry.setSmallIcon(Model1ElementTypes
				.getImageDescriptor(Model1ElementTypes.Category_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSupplier2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(Model1ElementTypes.Supplier_2001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Supplier2CreationTool_title, null, types);
		entry.setSmallIcon(Model1ElementTypes
				.getImageDescriptor(Model1ElementTypes.Supplier_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCustomer3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(Model1ElementTypes.Customer_2003);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Customer3CreationTool_title, null, types);
		entry.setSmallIcon(Model1ElementTypes
				.getImageDescriptor(Model1ElementTypes.Customer_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPurchaseOrder4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(Model1ElementTypes.PurchaseOrder_2004);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.PurchaseOrder4CreationTool_title, null, types);
		entry.setSmallIcon(Model1ElementTypes
				.getImageDescriptor(Model1ElementTypes.PurchaseOrder_2004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSalesOrder5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(Model1ElementTypes.SalesOrder_2005);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SalesOrder5CreationTool_title, null, types);
		entry.setSmallIcon(Model1ElementTypes
				.getImageDescriptor(Model1ElementTypes.SalesOrder_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOrderDetail6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(Model1ElementTypes.OrderAddress_2006);
		types.add(Model1ElementTypes.OrderDetail_2007);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.OrderDetail6CreationTool_title, null, types);
		entry.setSmallIcon(Model1ElementTypes
				.getImageDescriptor(Model1ElementTypes.OrderAddress_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProduct17CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(Model1ElementTypes.Product1_2008);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Product17CreationTool_title, null, types);
		entry.setSmallIcon(Model1ElementTypes
				.getImageDescriptor(Model1ElementTypes.Product1_2008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSupplier1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(Model1ElementTypes.PurchaseOrderSupplier_4002);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Supplier1CreationTool_title, null, types);
		entry.setSmallIcon(Model1DiagramEditorPlugin
				.findImageDescriptor("../icons/myobjects/SolidLine.gif")); //$NON-NLS-1$
		entry.setLargeIcon(Model1DiagramEditorPlugin
				.findImageDescriptor("../icons/myobjects/SolidLine.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCustomer2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(Model1ElementTypes.SalesOrderCustomer_4003);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Customer2CreationTool_title, null, types);
		entry.setSmallIcon(Model1DiagramEditorPlugin
				.findImageDescriptor("../icons/myobjects/SolidLine.gif")); //$NON-NLS-1$
		entry.setLargeIcon(Model1DiagramEditorPlugin
				.findImageDescriptor("../icons/myobjects/SolidLine.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOrderDetail3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(Model1ElementTypes.OrderOrderDetails_4004);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.OrderDetail3CreationTool_title, null, types);
		entry
				.setSmallIcon(Model1DiagramEditorPlugin
						.findImageDescriptor("../icons/myobjects/Association_composite.gif")); //$NON-NLS-1$
		entry
				.setLargeIcon(Model1DiagramEditorPlugin
						.findImageDescriptor("../icons/myobjects/Association_composite.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProduct4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(Model1ElementTypes.CategoryProducts_4001);
		types.add(Model1ElementTypes.OrderDetailProduct_4005);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Product4CreationTool_title, null, types);
		entry.setSmallIcon(Model1DiagramEditorPlugin
				.findImageDescriptor("../icons/myobjects/SolidLine.gif")); //$NON-NLS-1$
		entry.setLargeIcon(Model1DiagramEditorPlugin
				.findImageDescriptor("../icons/myobjects/SolidLine.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
