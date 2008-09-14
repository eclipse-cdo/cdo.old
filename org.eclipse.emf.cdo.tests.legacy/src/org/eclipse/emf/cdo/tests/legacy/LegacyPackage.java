/**
 * <copyright>
 * </copyright>
 *
 * $Id: LegacyPackage.java,v 1.1 2008-09-14 16:47:43 estepper Exp $
 */
package org.eclipse.emf.cdo.tests.legacy;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.cdo.tests.legacy.LegacyFactory
 * @model kind="package"
 * @generated
 */
public interface LegacyPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "legacy";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/CDO/tests/legacy/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "legacy";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LegacyPackage eINSTANCE = org.eclipse.emf.cdo.tests.legacy.impl.LegacyPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.cdo.tests.legacy.impl.HookImpl <em>Hook</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.cdo.tests.legacy.impl.HookImpl
	 * @see org.eclipse.emf.cdo.tests.legacy.impl.LegacyPackageImpl#getHook()
	 * @generated
	 */
	int HOOK = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOOK__NAME = 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOOK__CHILDREN = 1;

	/**
	 * The number of structural features of the '<em>Hook</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOOK_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.cdo.tests.legacy.Hook <em>Hook</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hook</em>'.
	 * @see org.eclipse.emf.cdo.tests.legacy.Hook
	 * @generated
	 */
	EClass getHook();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.cdo.tests.legacy.Hook#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.cdo.tests.legacy.Hook#getName()
	 * @see #getHook()
	 * @generated
	 */
	EAttribute getHook_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.cdo.tests.legacy.Hook#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.emf.cdo.tests.legacy.Hook#getChildren()
	 * @see #getHook()
	 * @generated
	 */
	EReference getHook_Children();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LegacyFactory getLegacyFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.emf.cdo.tests.legacy.impl.HookImpl <em>Hook</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.cdo.tests.legacy.impl.HookImpl
		 * @see org.eclipse.emf.cdo.tests.legacy.impl.LegacyPackageImpl#getHook()
		 * @generated
		 */
		EClass HOOK = eINSTANCE.getHook();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOOK__NAME = eINSTANCE.getHook_Name();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HOOK__CHILDREN = eINSTANCE.getHook_Children();

	}

} //LegacyPackage
