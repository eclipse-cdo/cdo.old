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
package org.eclipse.net4j.examples.prov;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;


/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.net4j.examples.prov.ProvFactory
 * @model kind="package"
 * @generated
 */
public interface ProvPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "prov";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/net4j/2006/prov";

  /**
   * The package namespace name.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "prov";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  ProvPackage eINSTANCE = org.eclipse.net4j.examples.prov.impl.ProvPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.net4j.examples.prov.impl.SiteImpl <em>Site</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.net4j.examples.prov.impl.SiteImpl
   * @see org.eclipse.net4j.examples.prov.impl.ProvPackageImpl#getSite()
   * @generated
   */
  int SITE = 0;

  /**
   * The feature id for the '<em><b>Categories</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int SITE__CATEGORIES = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int SITE__NAME = 1;

  /**
   * The feature id for the '<em><b>Features</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int SITE__FEATURES = 2;

  /**
   * The number of structural features of the '<em>Site</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SITE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.net4j.examples.prov.impl.FeatureImpl <em>Feature</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.net4j.examples.prov.impl.FeatureImpl
   * @see org.eclipse.net4j.examples.prov.impl.ProvPackageImpl#getFeature()
   * @generated
   */
  int FEATURE = 2;

  /**
   * The meta object id for the '{@link org.eclipse.net4j.examples.prov.impl.CategoryImpl <em>Category</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.net4j.examples.prov.impl.CategoryImpl
   * @see org.eclipse.net4j.examples.prov.impl.ProvPackageImpl#getCategory()
   * @generated
   */
  int CATEGORY = 1;

  /**
   * The feature id for the '<em><b>Site</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY__SITE = 0;

  /**
   * The feature id for the '<em><b>Features</b></em>' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int CATEGORY__FEATURES = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY__NAME = 2;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY__LABEL = 3;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY__DESCRIPTION = 4;

  /**
   * The number of structural features of the '<em>Category</em>' class.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FEATURE_COUNT = 5;

  /**
   * The feature id for the '<em><b>Category</b></em>' container reference.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__CATEGORY = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__ID = 1;

  /**
   * The feature id for the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__VERSION = 2;

  /**
   * The feature id for the '<em><b>Url</b></em>' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__URL = 3;

  /**
   * The feature id for the '<em><b>Categories</b></em>' reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__CATEGORIES = 4;

  /**
   * The feature id for the '<em><b>Site</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__SITE = 5;

  /**
   * The number of structural features of the '<em>Feature</em>' class.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '<em>Categories</em>' data type.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see org.eclipse.emf.common.util.EList
   * @see org.eclipse.net4j.examples.prov.impl.ProvPackageImpl#getCategories()
   * @generated
   */
  int CATEGORIES = 3;

  /**
   * Returns the meta object for class '{@link org.eclipse.net4j.examples.prov.Site <em>Site</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Site</em>'.
   * @see org.eclipse.net4j.examples.prov.Site
   * @generated
   */
  EClass getSite();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.net4j.examples.prov.Site#getCategories <em>Categories</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Categories</em>'.
   * @see org.eclipse.net4j.examples.prov.Site#getCategories()
   * @see #getSite()
   * @generated
   */
  EReference getSite_Categories();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.net4j.examples.prov.Site#getName <em>Name</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.net4j.examples.prov.Site#getName()
   * @see #getSite()
   * @generated
   */
  EAttribute getSite_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.net4j.examples.prov.Site#getFeatures <em>Features</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Features</em>'.
   * @see org.eclipse.net4j.examples.prov.Site#getFeatures()
   * @see #getSite()
   * @generated
   */
  EReference getSite_Features();

  /**
   * Returns the meta object for class '{@link org.eclipse.net4j.examples.prov.Feature <em>Feature</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Feature</em>'.
   * @see org.eclipse.net4j.examples.prov.Feature
   * @generated
   */
  EClass getFeature();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.net4j.examples.prov.Feature#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Category</em>'.
   * @see org.eclipse.net4j.examples.prov.Feature#getCategory()
   * @see #getFeature()
   * @generated
   */
  EReference getFeature_Category();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.net4j.examples.prov.Feature#getId <em>Id</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.eclipse.net4j.examples.prov.Feature#getId()
   * @see #getFeature()
   * @generated
   */
  EAttribute getFeature_Id();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.net4j.examples.prov.Feature#getVersion <em>Version</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Version</em>'.
   * @see org.eclipse.net4j.examples.prov.Feature#getVersion()
   * @see #getFeature()
   * @generated
   */
  EAttribute getFeature_Version();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.net4j.examples.prov.Feature#getUrl <em>Url</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Url</em>'.
   * @see org.eclipse.net4j.examples.prov.Feature#getUrl()
   * @see #getFeature()
   * @generated
   */
  EAttribute getFeature_Url();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.net4j.examples.prov.Feature#getSite <em>Site</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Site</em>'.
   * @see org.eclipse.net4j.examples.prov.Feature#getSite()
   * @see #getFeature()
   * @generated
   */
  EReference getFeature_Site();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.net4j.examples.prov.Feature#getCategories <em>Categories</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Categories</em>'.
   * @see org.eclipse.net4j.examples.prov.Feature#getCategories()
   * @see #getFeature()
   * @generated
   */
  EReference getFeature_Categories();

  /**
   * Returns the meta object for class '{@link org.eclipse.net4j.examples.prov.Category <em>Category</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Category</em>'.
   * @see org.eclipse.net4j.examples.prov.Category
   * @generated
   */
  EClass getCategory();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.net4j.examples.prov.Category#getSite <em>Site</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Site</em>'.
   * @see org.eclipse.net4j.examples.prov.Category#getSite()
   * @see #getCategory()
   * @generated
   */
  EReference getCategory_Site();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.net4j.examples.prov.Category#getFeatures <em>Features</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Features</em>'.
   * @see org.eclipse.net4j.examples.prov.Category#getFeatures()
   * @see #getCategory()
   * @generated
   */
  EReference getCategory_Features();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.net4j.examples.prov.Category#getName <em>Name</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.net4j.examples.prov.Category#getName()
   * @see #getCategory()
   * @generated
   */
  EAttribute getCategory_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.net4j.examples.prov.Category#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see org.eclipse.net4j.examples.prov.Category#getLabel()
   * @see #getCategory()
   * @generated
   */
  EAttribute getCategory_Label();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.net4j.examples.prov.Category#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see org.eclipse.net4j.examples.prov.Category#getDescription()
   * @see #getCategory()
   * @generated
   */
  EAttribute getCategory_Description();

  /**
   * Returns the meta object for data type '{@link org.eclipse.emf.common.util.EList <em>Categories</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for data type '<em>Categories</em>'.
   * @see org.eclipse.emf.common.util.EList
   * @model instanceClass="org.eclipse.emf.common.util.EList"
   * @generated
   */
  EDataType getCategories();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ProvFactory getProvFactory();

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
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.net4j.examples.prov.impl.SiteImpl <em>Site</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.net4j.examples.prov.impl.SiteImpl
     * @see org.eclipse.net4j.examples.prov.impl.ProvPackageImpl#getSite()
     * @generated
     */
    EClass SITE = eINSTANCE.getSite();

    /**
     * The meta object literal for the '<em><b>Categories</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SITE__CATEGORIES = eINSTANCE.getSite_Categories();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SITE__NAME = eINSTANCE.getSite_Name();

    /**
     * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SITE__FEATURES = eINSTANCE.getSite_Features();

    /**
     * The meta object literal for the '{@link org.eclipse.net4j.examples.prov.impl.CategoryImpl <em>Category</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.net4j.examples.prov.impl.CategoryImpl
     * @see org.eclipse.net4j.examples.prov.impl.ProvPackageImpl#getCategory()
     * @generated
     */
    EClass CATEGORY = eINSTANCE.getCategory();

    /**
     * The meta object literal for the '<em><b>Site</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORY__SITE = eINSTANCE.getCategory_Site();

    /**
     * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORY__FEATURES = eINSTANCE.getCategory_Features();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CATEGORY__NAME = eINSTANCE.getCategory_Name();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CATEGORY__LABEL = eINSTANCE.getCategory_Label();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CATEGORY__DESCRIPTION = eINSTANCE.getCategory_Description();

    /**
     * The meta object literal for the '{@link org.eclipse.net4j.examples.prov.impl.FeatureImpl <em>Feature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.net4j.examples.prov.impl.FeatureImpl
     * @see org.eclipse.net4j.examples.prov.impl.ProvPackageImpl#getFeature()
     * @generated
     */
    EClass FEATURE = eINSTANCE.getFeature();

    /**
     * The meta object literal for the '<em><b>Category</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE__CATEGORY = eINSTANCE.getFeature_Category();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEATURE__ID = eINSTANCE.getFeature_Id();

    /**
     * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEATURE__VERSION = eINSTANCE.getFeature_Version();

    /**
     * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEATURE__URL = eINSTANCE.getFeature_Url();

    /**
     * The meta object literal for the '<em><b>Categories</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE__CATEGORIES = eINSTANCE.getFeature_Categories();

    /**
     * The meta object literal for the '<em><b>Site</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE__SITE = eINSTANCE.getFeature_Site();

    /**
     * The meta object literal for the '<em>Categories</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.EList
     * @see org.eclipse.net4j.examples.prov.impl.ProvPackageImpl#getCategories()
     * @generated
     */
    EDataType CATEGORIES = eINSTANCE.getCategories();

  }

} // ProvPackage
