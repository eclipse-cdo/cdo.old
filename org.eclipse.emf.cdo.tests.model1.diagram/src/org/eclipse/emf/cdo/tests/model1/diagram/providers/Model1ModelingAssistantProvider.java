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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CategoryEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CompanyEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CustomerEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.OrderAddressEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.OrderDetailEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.PurchaseOrderEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.SalesOrderEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.SupplierEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.part.Messages;
import org.eclipse.emf.cdo.tests.model1.diagram.part.Model1DiagramEditorPlugin;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * @generated
 */
public class Model1ModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof CompanyEditPart) {
			List types = new ArrayList();
			types.add(Model1ElementTypes.Supplier_2001);
			types.add(Model1ElementTypes.Category_2002);
			types.add(Model1ElementTypes.Customer_2003);
			types.add(Model1ElementTypes.PurchaseOrder_2004);
			types.add(Model1ElementTypes.SalesOrder_2005);
			types.add(Model1ElementTypes.OrderAddress_2006);
			types.add(Model1ElementTypes.OrderDetail_2007);
			types.add(Model1ElementTypes.Product1_2008);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof CategoryEditPart) {
			List types = new ArrayList();
			types.add(Model1ElementTypes.CategoryProducts_4001);
			return types;
		}
		if (sourceEditPart instanceof PurchaseOrderEditPart) {
			List types = new ArrayList();
			types.add(Model1ElementTypes.PurchaseOrderSupplier_4002);
			return types;
		}
		if (sourceEditPart instanceof OrderDetailEditPart) {
			List types = new ArrayList();
			types.add(Model1ElementTypes.SalesOrderCustomer_4003);
			return types;
		}
		if (sourceEditPart instanceof SalesOrderEditPart) {
			List types = new ArrayList();
			types.add(Model1ElementTypes.OrderDetailProduct_4005);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof SupplierEditPart) {
			List types = new ArrayList();
			types.add(Model1ElementTypes.PurchaseOrderSupplier_4002);
			return types;
		}
		if (targetEditPart instanceof CustomerEditPart) {
			List types = new ArrayList();
			types.add(Model1ElementTypes.SalesOrderCustomer_4003);
			return types;
		}
		if (targetEditPart instanceof SalesOrderEditPart) {
			List types = new ArrayList();
			types.add(Model1ElementTypes.OrderOrderDetails_4004);
			return types;
		}
		if (targetEditPart instanceof OrderAddressEditPart) {
			List types = new ArrayList();
			types.add(Model1ElementTypes.CategoryProducts_4001);
			types.add(Model1ElementTypes.OrderDetailProduct_4005);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof CategoryEditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof OrderAddressEditPart) {
				types.add(Model1ElementTypes.CategoryProducts_4001);
			}
			return types;
		}
		if (sourceEditPart instanceof PurchaseOrderEditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof SupplierEditPart) {
				types.add(Model1ElementTypes.PurchaseOrderSupplier_4002);
			}
			return types;
		}
		if (sourceEditPart instanceof OrderDetailEditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof CustomerEditPart) {
				types.add(Model1ElementTypes.SalesOrderCustomer_4003);
			}
			return types;
		}
		if (sourceEditPart instanceof SalesOrderEditPart) {
			List types = new ArrayList();
			if (targetEditPart instanceof OrderAddressEditPart) {
				types.add(Model1ElementTypes.OrderDetailProduct_4005);
			}
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof SupplierEditPart) {
			List types = new ArrayList();
			if (relationshipType == Model1ElementTypes.PurchaseOrderSupplier_4002) {
				types.add(Model1ElementTypes.PurchaseOrder_2004);
			}
			return types;
		}
		if (targetEditPart instanceof CustomerEditPart) {
			List types = new ArrayList();
			if (relationshipType == Model1ElementTypes.SalesOrderCustomer_4003) {
				types.add(Model1ElementTypes.SalesOrder_2005);
			}
			return types;
		}
		if (targetEditPart instanceof SalesOrderEditPart) {
			List types = new ArrayList();
			return types;
		}
		if (targetEditPart instanceof OrderAddressEditPart) {
			List types = new ArrayList();
			if (relationshipType == Model1ElementTypes.CategoryProducts_4001) {
				types.add(Model1ElementTypes.Category_2002);
			}
			if (relationshipType == Model1ElementTypes.OrderDetailProduct_4005) {
				types.add(Model1ElementTypes.OrderDetail_2007);
			}
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof CategoryEditPart) {
			List types = new ArrayList();
			if (relationshipType == Model1ElementTypes.CategoryProducts_4001) {
				types.add(Model1ElementTypes.Product1_2008);
			}
			return types;
		}
		if (sourceEditPart instanceof PurchaseOrderEditPart) {
			List types = new ArrayList();
			if (relationshipType == Model1ElementTypes.PurchaseOrderSupplier_4002) {
				types.add(Model1ElementTypes.Supplier_2001);
			}
			return types;
		}
		if (sourceEditPart instanceof OrderDetailEditPart) {
			List types = new ArrayList();
			if (relationshipType == Model1ElementTypes.SalesOrderCustomer_4003) {
				types.add(Model1ElementTypes.Customer_2003);
			}
			return types;
		}
		if (sourceEditPart instanceof SalesOrderEditPart) {
			List types = new ArrayList();
			if (relationshipType == Model1ElementTypes.OrderDetailProduct_4005) {
				types.add(Model1ElementTypes.Product1_2008);
			}
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target,
			IElementType relationshipType) {
		return selectExistingElement(target, getTypesForSource(target,
				relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source,
			IElementType relationshipType) {
		return selectExistingElement(source, getTypesForTarget(source,
				relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		Collection elements = new HashSet();
		for (Iterator it = diagram.getElement().eAllContents(); it.hasNext();) {
			EObject element = (EObject) it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements
				.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(
				element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
				Model1DiagramEditorPlugin.getInstance()
						.getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, labelProvider);
		dialog.setMessage(Messages.Model1ModelingAssistantProviderMessage);
		dialog.setTitle(Messages.Model1ModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
