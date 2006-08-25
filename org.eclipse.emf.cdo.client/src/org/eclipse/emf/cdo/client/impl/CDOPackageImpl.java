/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.client.impl;


import org.eclipse.emf.cdo.client.CDOFactory;
import org.eclipse.emf.cdo.client.CDOPackage;
import org.eclipse.emf.cdo.client.CDOPersistable;
import org.eclipse.emf.cdo.client.CDOPersistent;
import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CDOPackageImpl extends EPackageImpl implements CDOPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cdoPersistableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cdoPersistentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType cdoResourceEDataType = null;

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
   * @see org.eclipse.emf.cdo.client.CDOPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private CDOPackageImpl()
  {
    super(eNS_URI, CDOFactory.eINSTANCE);
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
  public static CDOPackage init()
  {
    if (isInited) return (CDOPackage) EPackage.Registry.INSTANCE.getEPackage(CDOPackage.eNS_URI);

    // Obtain or create and register package
    CDOPackageImpl theCDOPackage = (CDOPackageImpl) (EPackage.Registry.INSTANCE
        .getEPackage(eNS_URI) instanceof CDOPackageImpl ? EPackage.Registry.INSTANCE
        .getEPackage(eNS_URI) : new CDOPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theCDOPackage.createPackageContents();

    // Initialize created meta-data
    theCDOPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theCDOPackage.freeze();

    return theCDOPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCDOPersistable()
  {
    return cdoPersistableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCDOPersistent()
  {
    return cdoPersistentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getCDOResource()
  {
    return cdoResourceEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CDOFactory getCDOFactory()
  {
    return (CDOFactory) getEFactoryInstance();
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
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    cdoPersistableEClass = createEClass(CDO_PERSISTABLE);

    cdoPersistentEClass = createEClass(CDO_PERSISTENT);

    // Create data types
    cdoResourceEDataType = createEDataType(CDO_RESOURCE);
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
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Add supertypes to classes
    cdoPersistentEClass.getESuperTypes().add(this.getCDOPersistable());

    // Initialize classes and features; add operations and parameters
    initEClass(cdoPersistableEClass, CDOPersistable.class, "CDOPersistable", IS_ABSTRACT,
        IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    addEOperation(cdoPersistableEClass, ecorePackage.getELong(), "cdoGetOID", 0, 1);

    EOperation op = addEOperation(cdoPersistableEClass, null, "cdoSetOID");
    addEParameter(op, ecorePackage.getELong(), "oid", 0, 1);

    addEOperation(cdoPersistableEClass, ecorePackage.getEInt(), "cdoGetOCA", 0, 1);

    op = addEOperation(cdoPersistableEClass, null, "cdoSetOCA");
    addEParameter(op, ecorePackage.getEInt(), "oca", 0, 1);

    addEOperation(cdoPersistableEClass, null, "cdoLoad");

    addEOperation(cdoPersistableEClass, ecorePackage.getEBoolean(), "cdoIsNew", 0, 1);

    addEOperation(cdoPersistableEClass, ecorePackage.getEBoolean(), "cdoIsLoaded", 0, 1);

    addEOperation(cdoPersistableEClass, this.getCDOResource(), "cdoGetResource", 0, 1);

    op = addEOperation(cdoPersistableEClass, null, "cdoSetResource");
    addEParameter(op, this.getCDOResource(), "resource", 0, 1);

    addEOperation(cdoPersistableEClass, ecorePackage.getELong(), "cdoSetNew", 0, 1);

    initEClass(cdoPersistentEClass, CDOPersistent.class, "CDOPersistent", IS_ABSTRACT,
        !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Initialize data types
    initEDataType(cdoResourceEDataType, CDOResource.class, "CDOResource", IS_SERIALIZABLE,
        !IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //CDOPackageImpl
