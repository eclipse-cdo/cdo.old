/**
 * <copyright>
 * </copyright>
 *
 * $Id: LegacyFactoryImpl.java,v 1.1 2008-09-14 16:47:42 estepper Exp $
 */
package org.eclipse.emf.cdo.tests.legacy.impl;

import org.eclipse.emf.cdo.tests.legacy.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LegacyFactoryImpl extends EFactoryImpl implements LegacyFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LegacyFactory init() {
		try {
			LegacyFactory theLegacyFactory = (LegacyFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://www.eclipse.org/emf/CDO/tests/legacy/1.0.0");
			if (theLegacyFactory != null) {
				return theLegacyFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LegacyFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LegacyFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case LegacyPackage.HOOK:
			return createHook();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hook createHook() {
		HookImpl hook = new HookImpl();
		return hook;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LegacyPackage getLegacyPackage() {
		return (LegacyPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LegacyPackage getPackage() {
		return LegacyPackage.eINSTANCE;
	}

} //LegacyFactoryImpl
