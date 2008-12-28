/**
 * <copyright>
 * </copyright>
 *
 * $Id: Net4jdefstestsFactoryImpl.java,v 1.1 2008-12-28 18:07:20 estepper Exp $
 */
package net4jdefstests.impl;

import net4jdefstests.Net4jdefstestsFactory;
import net4jdefstests.Net4jdefstestsPackage;
import net4jdefstests.TestDef;

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
public class Net4jdefstestsFactoryImpl extends EFactoryImpl implements Net4jdefstestsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Net4jdefstestsFactory init() {
		try {
			Net4jdefstestsFactory theNet4jdefstestsFactory = (Net4jdefstestsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/NET4J/defs/tests/1.0.0"); 
			if (theNet4jdefstestsFactory != null) {
				return theNet4jdefstestsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Net4jdefstestsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Net4jdefstestsFactoryImpl() {
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
			case Net4jdefstestsPackage.TEST_DEF: return createTestDef();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestDef createTestDef() {
		TestDefImpl testDef = new TestDefImpl();
		return testDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Net4jdefstestsPackage getNet4jdefstestsPackage() {
		return (Net4jdefstestsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Net4jdefstestsPackage getPackage() {
		return Net4jdefstestsPackage.eINSTANCE;
	}

} //Net4jdefstestsFactoryImpl
