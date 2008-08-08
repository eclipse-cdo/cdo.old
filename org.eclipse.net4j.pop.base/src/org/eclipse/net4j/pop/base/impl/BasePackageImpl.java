/**
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *
 * $Id: BasePackageImpl.java,v 1.1 2008-08-08 10:10:36 estepper Exp $
 */
package org.eclipse.net4j.pop.base.impl;

import org.eclipse.net4j.pop.base.BaseFactory;
import org.eclipse.net4j.pop.base.BasePackage;
import org.eclipse.net4j.pop.base.Displayable;
import org.eclipse.net4j.pop.base.Identifiable;
import org.eclipse.net4j.pop.base.PopElement;
import org.eclipse.net4j.pop.base.Version;
import org.eclipse.net4j.pop.repository.IRepositoryAdapter;
import org.eclipse.net4j.pop.repository.IRepositoryFolder;
import org.eclipse.net4j.pop.repository.IRepositorySession;
import org.eclipse.net4j.pop.repository.IRepositoryTag;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.core.runtime.IPath;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class BasePackageImpl extends EPackageImpl implements BasePackage
{
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EClass identifiableEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EClass displayableEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EClass popElementEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EDataType versionEDataType = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EDataType pathEDataType = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EDataType repositoryAdapterEDataType = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EDataType repositorySessionEDataType = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EDataType repositoryFolderEDataType = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private EDataType repositoryTagEDataType = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
   * EPackage.Registry} by the package package URI value.
   * <p>
   * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
   * performs initialization of the package, or returns the registered package, if one already exists. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.net4j.pop.base.BasePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private BasePackageImpl()
  {
    super(eNS_URI, BaseFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * Simple dependencies are satisfied by calling this method on all dependent packages before doing anything else. This
   * method drives initialization for interdependent packages directly, in parallel with this package, itself.
   * <p>
   * Of this package and its interdependencies, all packages which have not yet been registered by their URI values are
   * first created and registered. The packages are then initialized in two steps: meta-model objects for all of the
   * packages are created before any are initialized, since one package's meta-model objects may refer to those of
   * another.
   * <p>
   * Invocation of this method will not affect any packages that have already been initialized. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static BasePackage init()
  {
    if (isInited)
      return (BasePackage)EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI);

    // Obtain or create and register package
    BasePackageImpl theBasePackage = (BasePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof BasePackageImpl ? EPackage.Registry.INSTANCE
        .getEPackage(eNS_URI)
        : new BasePackageImpl());

    isInited = true;

    // Create package meta-data objects
    theBasePackage.createPackageContents();

    // Initialize created meta-data
    theBasePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theBasePackage.freeze();

    return theBasePackage;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EClass getIdentifiable()
  {
    return identifiableEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EAttribute getIdentifiable_Id()
  {
    return (EAttribute)identifiableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EClass getDisplayable()
  {
    return displayableEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EClass getPopElement()
  {
    return popElementEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EAttribute getPopElement_Class()
  {
    return (EAttribute)popElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EDataType getVersion()
  {
    return versionEDataType;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EDataType getPath()
  {
    return pathEDataType;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EDataType getRepositoryAdapter()
  {
    return repositoryAdapterEDataType;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EDataType getRepositorySession()
  {
    return repositorySessionEDataType;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EDataType getRepositoryFolder()
  {
    return repositoryFolderEDataType;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EDataType getRepositoryTag()
  {
    return repositoryTagEDataType;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public BaseFactory getBaseFactory()
  {
    return (BaseFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package. This method is guarded to have no affect on any invocation but its
   * first. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated)
      return;
    isCreated = true;

    // Create classes and their features
    identifiableEClass = createEClass(IDENTIFIABLE);
    createEAttribute(identifiableEClass, IDENTIFIABLE__ID);

    displayableEClass = createEClass(DISPLAYABLE);

    popElementEClass = createEClass(POP_ELEMENT);
    createEAttribute(popElementEClass, POP_ELEMENT__CLASS);

    // Create data types
    versionEDataType = createEDataType(VERSION);
    pathEDataType = createEDataType(PATH);
    repositoryAdapterEDataType = createEDataType(REPOSITORY_ADAPTER);
    repositorySessionEDataType = createEDataType(REPOSITORY_SESSION);
    repositoryFolderEDataType = createEDataType(REPOSITORY_FOLDER);
    repositoryTagEDataType = createEDataType(REPOSITORY_TAG);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model. This method is guarded to have no affect on any
   * invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized)
      return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    popElementEClass.getESuperTypes().add(this.getIdentifiable());
    popElementEClass.getESuperTypes().add(this.getDisplayable());

    // Initialize classes and features; add operations and parameters
    initEClass(identifiableEClass, Identifiable.class,
        "Identifiable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(
        getIdentifiable_Id(),
        ecorePackage.getEString(),
        "id", null, 1, 1, Identifiable.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(displayableEClass, Displayable.class,
        "Displayable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    addEOperation(displayableEClass, ecorePackage.getEString(), "getDisplayString", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    initEClass(popElementEClass, PopElement.class,
        "PopElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(
        getPopElement_Class(),
        ecorePackage.getEString(),
        "class", null, 1, 1, PopElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    // Initialize data types
    initEDataType(versionEDataType, Version.class, "Version", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEDataType(pathEDataType, IPath.class, "Path", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEDataType(repositoryAdapterEDataType, IRepositoryAdapter.class,
        "RepositoryAdapter", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEDataType(repositorySessionEDataType, IRepositorySession.class,
        "RepositorySession", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEDataType(repositoryFolderEDataType, IRepositoryFolder.class,
        "RepositoryFolder", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEDataType(repositoryTagEDataType, IRepositoryTag.class,
        "RepositoryTag", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    // Create resource
    createResource(eNS_URI);
  }

} // BasePackageImpl
