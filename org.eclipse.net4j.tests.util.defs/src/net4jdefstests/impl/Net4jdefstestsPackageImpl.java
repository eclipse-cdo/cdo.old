/**
 * <copyright>
 * </copyright>
 *
 * $Id: Net4jdefstestsPackageImpl.java,v 1.1 2008-12-28 18:07:20 estepper Exp $
 */
package net4jdefstests.impl;

import net4jdefstests.Net4jdefstestsFactory;
import net4jdefstests.Net4jdefstestsPackage;
import net4jdefstests.TestDef;

import org.eclipse.net4j.util.net4jutildefs.Net4jUtilDefsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Net4jdefstestsPackageImpl extends EPackageImpl implements Net4jdefstestsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testDefEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see net4jdefstests.Net4jdefstestsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Net4jdefstestsPackageImpl() {
		super(eNS_URI, Net4jdefstestsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Net4jdefstestsPackage init() {
		if (isInited) return (Net4jdefstestsPackage)EPackage.Registry.INSTANCE.getEPackage(Net4jdefstestsPackage.eNS_URI);

		// Obtain or create and register package
		Net4jdefstestsPackageImpl theNet4jdefstestsPackage = (Net4jdefstestsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof Net4jdefstestsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new Net4jdefstestsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		Net4jUtilDefsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theNet4jdefstestsPackage.createPackageContents();

		// Initialize created meta-data
		theNet4jdefstestsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNet4jdefstestsPackage.freeze();

		return theNet4jdefstestsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestDef() {
		return testDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTestDef_References() {
		return (EReference)testDefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestDef_Attribute() {
		return (EAttribute)testDefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Net4jdefstestsFactory getNet4jdefstestsFactory() {
		return (Net4jdefstestsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		testDefEClass = createEClass(TEST_DEF);
		createEReference(testDefEClass, TEST_DEF__REFERENCES);
		createEAttribute(testDefEClass, TEST_DEF__ATTRIBUTE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		Net4jUtilDefsPackage theNet4jUtilDefsPackage = (Net4jUtilDefsPackage)EPackage.Registry.INSTANCE.getEPackage(Net4jUtilDefsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		testDefEClass.getESuperTypes().add(theNet4jUtilDefsPackage.getDef());

		// Initialize classes and features; add operations and parameters
		initEClass(testDefEClass, TestDef.class, "TestDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestDef_References(), theNet4jUtilDefsPackage.getDef(), null, "references", null, 0, -1, TestDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestDef_Attribute(), ecorePackage.getEString(), "attribute", null, 0, 1, TestDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //Net4jdefstestsPackageImpl
