/**
 * <copyright>
 * </copyright>
 *
 * $Id: LegacyFactory.java,v 1.1 2008-09-14 16:47:43 estepper Exp $
 */
package org.eclipse.emf.cdo.tests.legacy;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.cdo.tests.legacy.LegacyPackage
 * @generated
 */
public interface LegacyFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LegacyFactory eINSTANCE = org.eclipse.emf.cdo.tests.legacy.impl.LegacyFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Hook</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hook</em>'.
	 * @generated
	 */
	Hook createHook();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LegacyPackage getLegacyPackage();

} //LegacyFactory
