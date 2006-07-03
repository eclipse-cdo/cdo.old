/***************************************************************************
 * Copyright (c) 2004-2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.examples.prov.impl;


import org.eclipse.net4j.examples.prov.Category;
import org.eclipse.net4j.examples.prov.Feature;
import org.eclipse.net4j.examples.prov.ProvFactory;
import org.eclipse.net4j.examples.prov.ProvPackage;
import org.eclipse.net4j.examples.prov.Site;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;


/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class ProvPackageImpl extends EPackageImpl implements ProvPackage
{
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass siteEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass featureEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EClass categoryEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private EDataType categoriesEDataType = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.net4j.examples.prov.ProvPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ProvPackageImpl()
  {
    super(eNS_URI, ProvFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon
   * which it depends. Simple dependencies are satisfied by calling this method on all dependent
   * packages before doing anything else. This method drives initialization for interdependent
   * packages directly, in parallel with this package, itself.
   * <p>
   * Of this package and its interdependencies, all packages which have not yet been registered by
   * their URI values are first created and registered. The packages are then initialized in two
   * steps: meta-model objects for all of the packages are created before any are initialized, since
   * one package's meta-model objects may refer to those of another.
   * <p>
   * Invocation of this method will not affect any packages that have already been initialized. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ProvPackage init()
  {
    if (isInited) return (ProvPackage)EPackage.Registry.INSTANCE.getEPackage(ProvPackage.eNS_URI);

    // Obtain or create and register package
    ProvPackageImpl theProvPackage = (ProvPackageImpl)(EPackage.Registry.INSTANCE
            .getEPackage(eNS_URI) instanceof ProvPackageImpl ? EPackage.Registry.INSTANCE
            .getEPackage(eNS_URI) : new ProvPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theProvPackage.createPackageContents();

    // Initialize created meta-data
    theProvPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theProvPackage.freeze();

    return theProvPackage;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getSite()
  {
    return siteEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getSite_Categories()
  {
    return (EReference)siteEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSite_Name()
  {
    return (EAttribute)siteEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getSite_Features()
  {
    return (EReference)siteEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getFeature()
  {
    return featureEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeature_Category()
  {
    return (EReference)featureEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFeature_Id()
  {
    return (EAttribute)featureEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFeature_Version()
  {
    return (EAttribute)featureEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFeature_Url()
  {
    return (EAttribute)featureEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeature_Site()
  {
    return (EReference)featureEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeature_Categories()
  {
    return (EReference)featureEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EClass getCategory()
  {
    return categoryEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getCategory_Site()
  {
    return (EReference)categoryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EReference getCategory_Features()
  {
    return (EReference)categoryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCategory_Name()
  {
    return (EAttribute)categoryEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCategory_Label()
  {
    return (EAttribute)categoryEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCategory_Description()
  {
    return (EAttribute)categoryEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EDataType getCategories()
  {
    return categoriesEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProvFactory getProvFactory()
  {
    return (ProvFactory)getEFactoryInstance();
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
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    siteEClass = createEClass(SITE);
    createEReference(siteEClass, SITE__CATEGORIES);
    createEAttribute(siteEClass, SITE__NAME);
    createEReference(siteEClass, SITE__FEATURES);

    categoryEClass = createEClass(CATEGORY);
    createEReference(categoryEClass, CATEGORY__SITE);
    createEReference(categoryEClass, CATEGORY__FEATURES);
    createEAttribute(categoryEClass, CATEGORY__NAME);
    createEAttribute(categoryEClass, CATEGORY__LABEL);
    createEAttribute(categoryEClass, CATEGORY__DESCRIPTION);

    featureEClass = createEClass(FEATURE);
    createEReference(featureEClass, FEATURE__CATEGORY);
    createEAttribute(featureEClass, FEATURE__ID);
    createEAttribute(featureEClass, FEATURE__VERSION);
    createEAttribute(featureEClass, FEATURE__URL);
    createEReference(featureEClass, FEATURE__CATEGORIES);
    createEReference(featureEClass, FEATURE__SITE);

    // Create data types
    categoriesEDataType = createEDataType(CATEGORIES);
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
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(siteEClass, Site.class, "Site", !IS_ABSTRACT, !IS_INTERFACE,
            IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSite_Categories(), this.getCategory(), this.getCategory_Site(), "categories",
            null, 0, -1, Site.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
            !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSite_Name(), ecorePackage.getEString(), "name", null, 0, 1, Site.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
            !IS_DERIVED, IS_ORDERED);
    initEReference(getSite_Features(), this.getFeature(), this.getFeature_Site(), "features", null,
            0, -1, Site.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
            !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    EOperation op = addEOperation(siteEClass, this.getCategory(), "getCategory", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "name", 0, 1);

    op = addEOperation(siteEClass, this.getFeature(), "addFeature", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "id", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "version", 0, 1);

    op = addEOperation(siteEClass, this.getCategory(), "addCategory", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "name", 0, 1);

    op = addEOperation(siteEClass, this.getFeature(), "getFeature", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "id", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "version", 0, 1);

    op = addEOperation(siteEClass, this.getCategories(), "getCategories", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "featureId", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "featureVersion", 0, 1);

    op = addEOperation(siteEClass, this.getCategory(), "removeCategory", 0, 1);
    addEParameter(op, ecorePackage.getEInt(), "index", 0, 1);

    op = addEOperation(siteEClass, this.getFeature(), "removeFeature", 0, 1);
    addEParameter(op, ecorePackage.getEInt(), "index", 0, 1);

    op = addEOperation(siteEClass, this.getCategory(), "removeCategory", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "name", 0, 1);

    op = addEOperation(siteEClass, this.getFeature(), "removeFeature", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "id", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "version", 0, 1);

    initEClass(categoryEClass, Category.class, "Category", !IS_ABSTRACT, !IS_INTERFACE,
            IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCategory_Site(), this.getSite(), this.getSite_Categories(), "site", null, 0,
            1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
            !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCategory_Features(), this.getFeature(), this.getFeature_Category(),
            "features", null, 0, -1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
            IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCategory_Name(), ecorePackage.getEString(), "name", null, 0, 1,
            Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
            IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCategory_Label(), ecorePackage.getEString(), "label", null, 0, 1,
            Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
            IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCategory_Description(), ecorePackage.getEString(), "description", null, 0, 1,
            Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
            IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    op = addEOperation(categoryEClass, this.getFeature(), "getFeature", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "id", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "version", 0, 1);

    op = addEOperation(categoryEClass, this.getFeature(), "addFeature", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "id", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "version", 0, 1);

    op = addEOperation(categoryEClass, this.getFeature(), "removeFeature", 0, 1);
    addEParameter(op, ecorePackage.getEInt(), "index", 0, 1);

    op = addEOperation(categoryEClass, this.getFeature(), "removeFeature", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "id", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "version", 0, 1);

    initEClass(featureEClass, Feature.class, "Feature", !IS_ABSTRACT, !IS_INTERFACE,
            IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFeature_Category(), this.getCategory(), this.getCategory_Features(),
            "category", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
            !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFeature_Id(), ecorePackage.getEString(), "id", null, 0, 1, Feature.class,
            !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
            !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFeature_Version(), ecorePackage.getEString(), "version", null, 0, 1,
            Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
            IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFeature_Url(), ecorePackage.getEString(), "url", null, 0, 1, Feature.class,
            IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
            !IS_DERIVED, IS_ORDERED);
    initEReference(getFeature_Categories(), this.getCategory(), null, "categories", null, 0, -1,
            Feature.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE,
            IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFeature_Site(), this.getSite(), this.getSite_Features(), "site", null, 0, 1,
            Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
            !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize data types
    initEDataType(categoriesEDataType, EList.class, "Categories", IS_SERIALIZABLE,
            !IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} // ProvPackageImpl
