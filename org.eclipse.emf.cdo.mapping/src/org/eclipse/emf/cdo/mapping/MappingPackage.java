/*******************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Sympedia Methods and Tools.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.cdo.mapping;


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
 * @see org.eclipse.emf.cdo.mapping.MappingFactory
 * @model kind="package"
 * @generated
 */
public interface MappingPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "mapping";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/net4j/cdo/mapping.ecore";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "org.eclipse.emf.cdo.mapping";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MappingPackage eINSTANCE = org.eclipse.emf.cdo.mapping.impl.MappingPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.emf.cdo.mapping.impl.PackageMappingImpl <em>Package Mapping</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.cdo.mapping.impl.PackageMappingImpl
   * @see org.eclipse.emf.cdo.mapping.impl.MappingPackageImpl#getPackageMapping()
   * @generated
   */
  int PACKAGE_MAPPING = 0;

  /**
   * The feature id for the '<em><b>Classes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_MAPPING__CLASSES = 0;

  /**
   * The feature id for the '<em><b>Package Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_MAPPING__PACKAGE_NAME = 1;

  /**
   * The number of structural features of the '<em>Package Mapping</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_MAPPING_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.emf.cdo.mapping.impl.ClassMappingImpl <em>Class Mapping</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.cdo.mapping.impl.ClassMappingImpl
   * @see org.eclipse.emf.cdo.mapping.impl.MappingPackageImpl#getClassMapping()
   * @generated
   */
  int CLASS_MAPPING = 1;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_MAPPING__ATTRIBUTES = 0;

  /**
   * The feature id for the '<em><b>Class Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_MAPPING__CLASS_NAME = 1;

  /**
   * The feature id for the '<em><b>Table Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_MAPPING__TABLE_NAME = 2;

  /**
   * The number of structural features of the '<em>Class Mapping</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_MAPPING_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.emf.cdo.mapping.impl.AttributeMappingImpl <em>Attribute Mapping</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.cdo.mapping.impl.AttributeMappingImpl
   * @see org.eclipse.emf.cdo.mapping.impl.MappingPackageImpl#getAttributeMapping()
   * @generated
   */
  int ATTRIBUTE_MAPPING = 2;

  /**
   * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_MAPPING__ATTRIBUTE_NAME = 0;

  /**
   * The feature id for the '<em><b>Column Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_MAPPING__COLUMN_NAME = 1;

  /**
   * The feature id for the '<em><b>Column Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_MAPPING__COLUMN_TYPE = 2;

  /**
   * The number of structural features of the '<em>Attribute Mapping</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_MAPPING_FEATURE_COUNT = 3;

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.cdo.mapping.PackageMapping <em>Package Mapping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Package Mapping</em>'.
   * @see org.eclipse.emf.cdo.mapping.PackageMapping
   * @generated
   */
  EClass getPackageMapping();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.cdo.mapping.PackageMapping#getClasses <em>Classes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Classes</em>'.
   * @see org.eclipse.emf.cdo.mapping.PackageMapping#getClasses()
   * @see #getPackageMapping()
   * @generated
   */
  EReference getPackageMapping_Classes();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.cdo.mapping.PackageMapping#getPackageName <em>Package Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Package Name</em>'.
   * @see org.eclipse.emf.cdo.mapping.PackageMapping#getPackageName()
   * @see #getPackageMapping()
   * @generated
   */
  EAttribute getPackageMapping_PackageName();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.cdo.mapping.ClassMapping <em>Class Mapping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class Mapping</em>'.
   * @see org.eclipse.emf.cdo.mapping.ClassMapping
   * @generated
   */
  EClass getClassMapping();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.cdo.mapping.ClassMapping#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see org.eclipse.emf.cdo.mapping.ClassMapping#getAttributes()
   * @see #getClassMapping()
   * @generated
   */
  EReference getClassMapping_Attributes();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.cdo.mapping.ClassMapping#getClassName <em>Class Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Class Name</em>'.
   * @see org.eclipse.emf.cdo.mapping.ClassMapping#getClassName()
   * @see #getClassMapping()
   * @generated
   */
  EAttribute getClassMapping_ClassName();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.cdo.mapping.ClassMapping#getTableName <em>Table Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Table Name</em>'.
   * @see org.eclipse.emf.cdo.mapping.ClassMapping#getTableName()
   * @see #getClassMapping()
   * @generated
   */
  EAttribute getClassMapping_TableName();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.cdo.mapping.AttributeMapping <em>Attribute Mapping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute Mapping</em>'.
   * @see org.eclipse.emf.cdo.mapping.AttributeMapping
   * @generated
   */
  EClass getAttributeMapping();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.cdo.mapping.AttributeMapping#getAttributeName <em>Attribute Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Attribute Name</em>'.
   * @see org.eclipse.emf.cdo.mapping.AttributeMapping#getAttributeName()
   * @see #getAttributeMapping()
   * @generated
   */
  EAttribute getAttributeMapping_AttributeName();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.cdo.mapping.AttributeMapping#getColumnName <em>Column Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Column Name</em>'.
   * @see org.eclipse.emf.cdo.mapping.AttributeMapping#getColumnName()
   * @see #getAttributeMapping()
   * @generated
   */
  EAttribute getAttributeMapping_ColumnName();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.cdo.mapping.AttributeMapping#getColumnType <em>Column Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Column Type</em>'.
   * @see org.eclipse.emf.cdo.mapping.AttributeMapping#getColumnType()
   * @see #getAttributeMapping()
   * @generated
   */
  EAttribute getAttributeMapping_ColumnType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  MappingFactory getMappingFactory();


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
     * The meta object literal for the '{@link org.eclipse.emf.cdo.mapping.impl.PackageMappingImpl <em>Package Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.cdo.mapping.impl.PackageMappingImpl
     * @see org.eclipse.emf.cdo.mapping.impl.MappingPackageImpl#getPackageMapping()
     * @generated
     */
    EClass PACKAGE_MAPPING = eINSTANCE.getPackageMapping();

    /**
     * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGE_MAPPING__CLASSES = eINSTANCE.getPackageMapping_Classes();

    /**
     * The meta object literal for the '<em><b>Package Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PACKAGE_MAPPING__PACKAGE_NAME = eINSTANCE.getPackageMapping_PackageName();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.cdo.mapping.impl.ClassMappingImpl <em>Class Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.cdo.mapping.impl.ClassMappingImpl
     * @see org.eclipse.emf.cdo.mapping.impl.MappingPackageImpl#getClassMapping()
     * @generated
     */
    EClass CLASS_MAPPING = eINSTANCE.getClassMapping();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS_MAPPING__ATTRIBUTES = eINSTANCE.getClassMapping_Attributes();

    /**
     * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASS_MAPPING__CLASS_NAME = eINSTANCE.getClassMapping_ClassName();

    /**
     * The meta object literal for the '<em><b>Table Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASS_MAPPING__TABLE_NAME = eINSTANCE.getClassMapping_TableName();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.cdo.mapping.impl.AttributeMappingImpl <em>Attribute Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.cdo.mapping.impl.AttributeMappingImpl
     * @see org.eclipse.emf.cdo.mapping.impl.MappingPackageImpl#getAttributeMapping()
     * @generated
     */
    EClass ATTRIBUTE_MAPPING = eINSTANCE.getAttributeMapping();

    /**
     * The meta object literal for the '<em><b>Attribute Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE_MAPPING__ATTRIBUTE_NAME = eINSTANCE.getAttributeMapping_AttributeName();

    /**
     * The meta object literal for the '<em><b>Column Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE_MAPPING__COLUMN_NAME = eINSTANCE.getAttributeMapping_ColumnName();

    /**
     * The meta object literal for the '<em><b>Column Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE_MAPPING__COLUMN_TYPE = eINSTANCE.getAttributeMapping_ColumnType();

  }

} //MappingPackage
