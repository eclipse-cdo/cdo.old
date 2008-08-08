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
 * $Id: ProductPackageImpl.java,v 1.1 2008-08-08 10:10:32 estepper Exp $
 */
package org.eclipse.net4j.pop.product.impl;

import org.eclipse.net4j.pop.base.BasePackage;
import org.eclipse.net4j.pop.product.Archive;
import org.eclipse.net4j.pop.product.ArchiveContent;
import org.eclipse.net4j.pop.product.Artifact;
import org.eclipse.net4j.pop.product.File;
import org.eclipse.net4j.pop.product.Folder;
import org.eclipse.net4j.pop.product.PopProduct;
import org.eclipse.net4j.pop.product.ProductFactory;
import org.eclipse.net4j.pop.product.ProductPackage;
import org.eclipse.net4j.pop.product.SecondaryModule;
import org.eclipse.net4j.pop.product.WorkingSet;
import org.eclipse.net4j.pop.product.WorkspaceConfigurator;
import org.eclipse.net4j.pop.product.WorkspaceProject;
import org.eclipse.net4j.pop.project.ProjectPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class ProductPackageImpl extends EPackageImpl implements ProductPackage
{
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass popProductEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass secondaryModuleEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass workingSetEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass workspaceProjectEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass workspaceConfiguratorEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass artifactEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass fileEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass folderEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass archiveEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass archiveContentEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
   * EPackage.Registry} by the package package URI value.
   * <p>
   * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
   * performs initialization of the package, or returns the registered package, if one already exists. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.net4j.pop.product.ProductPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ProductPackageImpl()
  {
    super(eNS_URI, ProductFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
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
  public static ProductPackage init()
  {
    if (isInited)
      return (ProductPackage)EPackage.Registry.INSTANCE.getEPackage(ProductPackage.eNS_URI);

    // Obtain or create and register package
    ProductPackageImpl theProductPackage = (ProductPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ProductPackageImpl ? EPackage.Registry.INSTANCE
        .getEPackage(eNS_URI)
        : new ProductPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    ProjectPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theProductPackage.createPackageContents();

    // Initialize created meta-data
    theProductPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theProductPackage.freeze();

    return theProductPackage;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getPopProduct()
  {
    return popProductEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getPopProduct_PopProject()
  {
    return (EReference)popProductEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPopProduct_Name()
  {
    return (EAttribute)popProductEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPopProduct_SecondaryModules()
  {
    return (EReference)popProductEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getPopProduct_Projects()
  {
    return (EReference)popProductEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getPopProduct_WorkingSets()
  {
    return (EReference)popProductEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getPopProduct_Configurators()
  {
    return (EReference)popProductEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSecondaryModule()
  {
    return secondaryModuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSecondaryModule_PopProduct()
  {
    return (EReference)secondaryModuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getWorkingSet()
  {
    return workingSetEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWorkingSet_PopProduct()
  {
    return (EReference)workingSetEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWorkingSet_Name()
  {
    return (EAttribute)workingSetEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getWorkingSet_Projects()
  {
    return (EReference)workingSetEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getWorkspaceProject()
  {
    return workspaceProjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWorkspaceProject_PopProduct()
  {
    return (EReference)workspaceProjectEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWorkspaceProject_Name()
  {
    return (EAttribute)workspaceProjectEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getWorkspaceProject_WorkingSets()
  {
    return (EReference)workspaceProjectEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getWorkspaceProject_Module()
  {
    return (EReference)workspaceProjectEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWorkspaceProject_ModulePath()
  {
    return (EAttribute)workspaceProjectEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getWorkspaceConfigurator()
  {
    return workspaceConfiguratorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWorkspaceConfigurator_PopProject()
  {
    return (EReference)workspaceConfiguratorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWorkspaceConfigurator_Name()
  {
    return (EAttribute)workspaceConfiguratorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getArtifact()
  {
    return artifactEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getArtifact_Parent()
  {
    return (EReference)artifactEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getFile()
  {
    return fileEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getFolder()
  {
    return folderEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getFolder_Members()
  {
    return (EReference)folderEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getArchive()
  {
    return archiveEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getArchive_Content()
  {
    return (EReference)archiveEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getArchiveContent()
  {
    return archiveContentEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getArchiveContent_Archive()
  {
    return (EReference)archiveContentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ProductFactory getProductFactory()
  {
    return (ProductFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated)
      return;
    isCreated = true;

    // Create classes and their features
    popProductEClass = createEClass(POP_PRODUCT);
    createEReference(popProductEClass, POP_PRODUCT__POP_PROJECT);
    createEAttribute(popProductEClass, POP_PRODUCT__NAME);
    createEReference(popProductEClass, POP_PRODUCT__SECONDARY_MODULES);
    createEReference(popProductEClass, POP_PRODUCT__PROJECTS);
    createEReference(popProductEClass, POP_PRODUCT__WORKING_SETS);
    createEReference(popProductEClass, POP_PRODUCT__CONFIGURATORS);

    secondaryModuleEClass = createEClass(SECONDARY_MODULE);
    createEReference(secondaryModuleEClass, SECONDARY_MODULE__POP_PRODUCT);

    workingSetEClass = createEClass(WORKING_SET);
    createEReference(workingSetEClass, WORKING_SET__POP_PRODUCT);
    createEAttribute(workingSetEClass, WORKING_SET__NAME);
    createEReference(workingSetEClass, WORKING_SET__PROJECTS);

    workspaceProjectEClass = createEClass(WORKSPACE_PROJECT);
    createEReference(workspaceProjectEClass, WORKSPACE_PROJECT__POP_PRODUCT);
    createEAttribute(workspaceProjectEClass, WORKSPACE_PROJECT__NAME);
    createEReference(workspaceProjectEClass, WORKSPACE_PROJECT__WORKING_SETS);
    createEReference(workspaceProjectEClass, WORKSPACE_PROJECT__MODULE);
    createEAttribute(workspaceProjectEClass, WORKSPACE_PROJECT__MODULE_PATH);

    workspaceConfiguratorEClass = createEClass(WORKSPACE_CONFIGURATOR);
    createEReference(workspaceConfiguratorEClass, WORKSPACE_CONFIGURATOR__POP_PROJECT);
    createEAttribute(workspaceConfiguratorEClass, WORKSPACE_CONFIGURATOR__NAME);

    artifactEClass = createEClass(ARTIFACT);
    createEReference(artifactEClass, ARTIFACT__PARENT);

    fileEClass = createEClass(FILE);

    folderEClass = createEClass(FOLDER);
    createEReference(folderEClass, FOLDER__MEMBERS);

    archiveEClass = createEClass(ARCHIVE);
    createEReference(archiveEClass, ARCHIVE__CONTENT);

    archiveContentEClass = createEClass(ARCHIVE_CONTENT);
    createEReference(archiveContentEClass, ARCHIVE_CONTENT__ARCHIVE);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
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

    // Obtain other dependent packages
    BasePackage theBasePackage = (BasePackage)EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI);
    ProjectPackage theProjectPackage = (ProjectPackage)EPackage.Registry.INSTANCE.getEPackage(ProjectPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    popProductEClass.getESuperTypes().add(theBasePackage.getPopElement());
    secondaryModuleEClass.getESuperTypes().add(theProjectPackage.getModule());
    workingSetEClass.getESuperTypes().add(theBasePackage.getPopElement());
    workspaceProjectEClass.getESuperTypes().add(theBasePackage.getPopElement());
    workspaceConfiguratorEClass.getESuperTypes().add(theBasePackage.getPopElement());
    fileEClass.getESuperTypes().add(this.getArtifact());
    folderEClass.getESuperTypes().add(this.getArtifact());
    archiveEClass.getESuperTypes().add(this.getFile());
    archiveContentEClass.getESuperTypes().add(this.getFolder());

    // Initialize classes and features; add operations and parameters
    initEClass(popProductEClass, PopProduct.class,
        "PopProduct", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(
        getPopProduct_PopProject(),
        theProjectPackage.getPopProject(),
        null,
        "popProject", null, 1, 1, PopProduct.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(
        getPopProduct_Name(),
        ecorePackage.getEString(),
        "name", null, 1, 1, PopProduct.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(
        getPopProduct_SecondaryModules(),
        this.getSecondaryModule(),
        this.getSecondaryModule_PopProduct(),
        "secondaryModules", null, 0, -1, PopProduct.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(
        getPopProduct_Projects(),
        this.getWorkspaceProject(),
        this.getWorkspaceProject_PopProduct(),
        "projects", null, 0, -1, PopProduct.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(
        getPopProduct_WorkingSets(),
        this.getWorkingSet(),
        this.getWorkingSet_PopProduct(),
        "workingSets", null, 0, -1, PopProduct.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(
        getPopProduct_Configurators(),
        this.getWorkspaceConfigurator(),
        this.getWorkspaceConfigurator_PopProject(),
        "configurators", null, 0, -1, PopProduct.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(secondaryModuleEClass, SecondaryModule.class,
        "SecondaryModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(
        getSecondaryModule_PopProduct(),
        this.getPopProduct(),
        this.getPopProduct_SecondaryModules(),
        "popProduct", null, 1, 1, SecondaryModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(workingSetEClass, WorkingSet.class,
        "WorkingSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(
        getWorkingSet_PopProduct(),
        this.getPopProduct(),
        this.getPopProduct_WorkingSets(),
        "popProduct", null, 1, 1, WorkingSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(
        getWorkingSet_Name(),
        ecorePackage.getEString(),
        "name", null, 1, 1, WorkingSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(
        getWorkingSet_Projects(),
        this.getWorkspaceProject(),
        this.getWorkspaceProject_WorkingSets(),
        "projects", null, 0, -1, WorkingSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(workspaceProjectEClass, WorkspaceProject.class,
        "WorkspaceProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(
        getWorkspaceProject_PopProduct(),
        this.getPopProduct(),
        this.getPopProduct_Projects(),
        "popProduct", null, 1, 1, WorkspaceProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(
        getWorkspaceProject_Name(),
        ecorePackage.getEString(),
        "name", null, 1, 1, WorkspaceProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(
        getWorkspaceProject_WorkingSets(),
        this.getWorkingSet(),
        this.getWorkingSet_Projects(),
        "workingSets", null, 0, -1, WorkspaceProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEReference(
        getWorkspaceProject_Module(),
        theProjectPackage.getModule(),
        null,
        "module", null, 1, 1, WorkspaceProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(
        getWorkspaceProject_ModulePath(),
        ecorePackage.getEString(),
        "modulePath", null, 0, 1, WorkspaceProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(workspaceConfiguratorEClass, WorkspaceConfigurator.class,
        "WorkspaceConfigurator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(
        getWorkspaceConfigurator_PopProject(),
        this.getPopProduct(),
        this.getPopProduct_Configurators(),
        "popProject", null, 1, 1, WorkspaceConfigurator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(
        getWorkspaceConfigurator_Name(),
        ecorePackage.getEString(),
        "name", null, 1, 1, WorkspaceConfigurator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    addEOperation(workspaceConfiguratorEClass, null, "configureWorkspace", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    initEClass(artifactEClass, Artifact.class, "Artifact", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(
        getArtifact_Parent(),
        this.getFolder(),
        this.getFolder_Members(),
        "parent", null, 0, 1, Artifact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(fileEClass, File.class, "File", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    initEClass(folderEClass, Folder.class, "Folder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(
        getFolder_Members(),
        this.getArtifact(),
        this.getArtifact_Parent(),
        "members", null, 0, -1, Folder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(archiveEClass, Archive.class, "Archive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(
        getArchive_Content(),
        this.getArchiveContent(),
        this.getArchiveContent_Archive(),
        "content", null, 0, 1, Archive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(archiveContentEClass, ArchiveContent.class,
        "ArchiveContent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEReference(
        getArchiveContent_Archive(),
        this.getArchive(),
        this.getArchive_Content(),
        "archive", null, 1, 1, ArchiveContent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    // Create resource
    createResource(eNS_URI);
  }

} // ProductPackageImpl
