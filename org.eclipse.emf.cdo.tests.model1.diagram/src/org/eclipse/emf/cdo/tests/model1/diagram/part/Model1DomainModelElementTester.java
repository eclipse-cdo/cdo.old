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

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.cdo.tests.model1.Model1Package;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * @generated
 */
public class Model1DomainModelElementTester extends PropertyTester {

	/**
	 * @generated
	 */
	public boolean test(Object receiver, String method, Object[] args,
			Object expectedValue) {
		if (false == receiver instanceof EObject) {
			return false;
		}
		EObject eObject = (EObject) receiver;
		EClass eClass = eObject.eClass();
		if (eClass == Model1Package.eINSTANCE.getAddress()) {
			return true;
		}
		if (eClass == Model1Package.eINSTANCE.getCompany()) {
			return true;
		}
		if (eClass == Model1Package.eINSTANCE.getSupplier()) {
			return true;
		}
		if (eClass == Model1Package.eINSTANCE.getCustomer()) {
			return true;
		}
		if (eClass == Model1Package.eINSTANCE.getOrder()) {
			return true;
		}
		if (eClass == Model1Package.eINSTANCE.getOrderDetail()) {
			return true;
		}
		if (eClass == Model1Package.eINSTANCE.getPurchaseOrder()) {
			return true;
		}
		if (eClass == Model1Package.eINSTANCE.getSalesOrder()) {
			return true;
		}
		if (eClass == Model1Package.eINSTANCE.getCategory()) {
			return true;
		}
		if (eClass == Model1Package.eINSTANCE.getProduct1()) {
			return true;
		}
		if (eClass == Model1Package.eINSTANCE.getOrderAddress()) {
			return true;
		}
		return false;
	}

}
