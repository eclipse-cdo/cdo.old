/**
 * <copyright>
 * </copyright>
 *
 * $Id: Net4jdefstestsFactory.java,v 1.1 2008-12-28 18:07:20 estepper Exp $
 */
package net4jdefstests;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see net4jdefstests.Net4jdefstestsPackage
 * @generated
 */
public interface Net4jdefstestsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Net4jdefstestsFactory eINSTANCE = net4jdefstests.impl.Net4jdefstestsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Test Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Def</em>'.
	 * @generated
	 */
	TestDef createTestDef();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Net4jdefstestsPackage getNet4jdefstestsPackage();

} //Net4jdefstestsFactory
