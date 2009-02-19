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
package org.eclipse.emf.cdo.tests.model1.diagram.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.cdo.tests.model1.diagram.part.Model1VisualIDRegistry;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

/**
 * @generated
 */
public class Model1EditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (Model1VisualIDRegistry.getVisualID(view)) {

			case CompanyEditPart.VISUAL_ID:
				return new CompanyEditPart(view);

			case SupplierEditPart.VISUAL_ID:
				return new SupplierEditPart(view);

			case SupplierNameEditPart.VISUAL_ID:
				return new SupplierNameEditPart(view);

			case CategoryEditPart.VISUAL_ID:
				return new CategoryEditPart(view);

			case CategoryNameEditPart.VISUAL_ID:
				return new CategoryNameEditPart(view);

			case CustomerEditPart.VISUAL_ID:
				return new CustomerEditPart(view);

			case CustomerNameEditPart.VISUAL_ID:
				return new CustomerNameEditPart(view);

			case PurchaseOrderEditPart.VISUAL_ID:
				return new PurchaseOrderEditPart(view);

			case PurchaseOrderDateEditPart.VISUAL_ID:
				return new PurchaseOrderDateEditPart(view);

			case OrderDetailEditPart.VISUAL_ID:
				return new OrderDetailEditPart(view);

			case OrderDetailPriceEditPart.VISUAL_ID:
				return new OrderDetailPriceEditPart(view);

			case Product1EditPart.VISUAL_ID:
				return new Product1EditPart(view);

			case Product1NameEditPart.VISUAL_ID:
				return new Product1NameEditPart(view);

			case SalesOrderEditPart.VISUAL_ID:
				return new SalesOrderEditPart(view);

			case SalesOrderIdEditPart.VISUAL_ID:
				return new SalesOrderIdEditPart(view);

			case OrderAddressEditPart.VISUAL_ID:
				return new OrderAddressEditPart(view);

			case OrderAddressNameEditPart.VISUAL_ID:
				return new OrderAddressNameEditPart(view);

			case CategoryProducts2EditPart.VISUAL_ID:
				return new CategoryProducts2EditPart(view);

			case CategoryProductsEditPart.VISUAL_ID:
				return new CategoryProductsEditPart(view);

			case SalesOrderCustomerEditPart.VISUAL_ID:
				return new SalesOrderCustomerEditPart(view);

			case OrderOrderDetails2EditPart.VISUAL_ID:
				return new OrderOrderDetails2EditPart(view);

			case OrderOrderDetailsEditPart.VISUAL_ID:
				return new OrderOrderDetailsEditPart(view);
			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		if (source.getFigure() instanceof WrappingLabel)
			return new TextCellEditorLocator((WrappingLabel) source.getFigure());
		else {
			return new LabelCellEditorLocator((Label) source.getFigure());
		}
	}

	/**
	 * @generated
	 */
	static private class TextCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private WrappingLabel wrapLabel;

		/**
		 * @generated
		 */
		public TextCellEditorLocator(WrappingLabel wrapLabel) {
			this.wrapLabel = wrapLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getWrapLabel() {
			return wrapLabel;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);
			if (getWrapLabel().isTextWrapOn()
					&& getWrapLabel().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width,
						SWT.DEFAULT)));
			} else {
				int avr = FigureUtilities.getFontMetrics(text.getFont())
						.getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
						SWT.DEFAULT)).expand(avr * 2, 0));
			}
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}

	/**
	 * @generated
	 */
	private static class LabelCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private Label label;

		/**
		 * @generated
		 */
		public LabelCellEditorLocator(Label label) {
			this.label = label;
		}

		/**
		 * @generated
		 */
		public Label getLabel() {
			return label;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getLabel().getTextBounds().getCopy();
			getLabel().translateToAbsolute(rect);
			int avr = FigureUtilities.getFontMetrics(text.getFont())
					.getAverageCharWidth();
			rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
					SWT.DEFAULT)).expand(avr * 2, 0));
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
