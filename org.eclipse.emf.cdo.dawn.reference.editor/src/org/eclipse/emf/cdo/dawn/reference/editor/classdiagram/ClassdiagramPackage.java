/*******************************************************************************
 * Copyright (c) 2004 - 2010 Eike Stepper (Berlin, Germany).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fluegge - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramFactory
 * @model kind="package"
 * @generated
 */
public interface ClassdiagramPackage extends EPackage
{
  /**
   * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  String eNAME = "classdiagram";

  /**
   * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  String eNS_URI = "http://class.uml.diagram.mftech.org";

  /**
   * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  String eNS_PREFIX = "classdiagram";

  /**
   * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  ClassdiagramPackage eINSTANCE = org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassdiagramPackageImpl
      .init();

  /**
   * The meta object id for the '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ABasicClassImpl
   * <em>ABasic Class</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ABasicClassImpl
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassdiagramPackageImpl#getABasicClass()
   * @generated
   */
  int ABASIC_CLASS = 5;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int ABASIC_CLASS__OPERATIONS = 0;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int ABASIC_CLASS__ATTRIBUTES = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int ABASIC_CLASS__NAME = 2;

  /**
   * The number of structural features of the '<em>ABasic Class</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int ABASIC_CLASS_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AClassImpl
   * <em>AClass</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AClassImpl
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassdiagramPackageImpl#getAClass()
   * @generated
   */
  int ACLASS = 0;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int ACLASS__OPERATIONS = ABASIC_CLASS__OPERATIONS;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int ACLASS__ATTRIBUTES = ABASIC_CLASS__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int ACLASS__NAME = ABASIC_CLASS__NAME;

  /**
   * The feature id for the '<em><b>Sub Classes</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int ACLASS__SUB_CLASSES = ABASIC_CLASS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Implemented Interfaces</b></em>' reference list. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int ACLASS__IMPLEMENTED_INTERFACES = ABASIC_CLASS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Associations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int ACLASS__ASSOCIATIONS = ABASIC_CLASS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Compositions</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int ACLASS__COMPOSITIONS = ABASIC_CLASS_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Aggregations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int ACLASS__AGGREGATIONS = ABASIC_CLASS_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>AClass</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int ACLASS_FEATURE_COUNT = ABASIC_CLASS_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AInterfaceImpl
   * <em>AInterface</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AInterfaceImpl
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassdiagramPackageImpl#getAInterface()
   * @generated
   */
  int AINTERFACE = 1;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int AINTERFACE__OPERATIONS = ABASIC_CLASS__OPERATIONS;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int AINTERFACE__ATTRIBUTES = ABASIC_CLASS__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int AINTERFACE__NAME = ABASIC_CLASS__NAME;

  /**
   * The number of structural features of the '<em>AInterface</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int AINTERFACE_FEATURE_COUNT = ABASIC_CLASS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassDiagramImpl
   * <em>Class Diagram</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassDiagramImpl
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassdiagramPackageImpl#getClassDiagram()
   * @generated
   */
  int CLASS_DIAGRAM = 2;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int CLASS_DIAGRAM__TITLE = 0;

  /**
   * The feature id for the '<em><b>Classes</b></em>' containment reference list. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int CLASS_DIAGRAM__CLASSES = 1;

  /**
   * The feature id for the '<em><b>Interfaces</b></em>' containment reference list. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int CLASS_DIAGRAM__INTERFACES = 2;

  /**
   * The number of structural features of the '<em>Class Diagram</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int CLASS_DIAGRAM_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AClassChildImpl
   * <em>AClass Child</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AClassChildImpl
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassdiagramPackageImpl#getAClassChild()
   * @generated
   */
  int ACLASS_CHILD = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int ACLASS_CHILD__NAME = 0;

  /**
   * The feature id for the '<em><b>Accessright</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int ACLASS_CHILD__ACCESSRIGHT = 1;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int ACLASS_CHILD__DATA_TYPE = 2;

  /**
   * The number of structural features of the '<em>AClass Child</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int ACLASS_CHILD_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AnAttributeImpl
   * <em>An Attribute</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AnAttributeImpl
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassdiagramPackageImpl#getAnAttribute()
   * @generated
   */
  int AN_ATTRIBUTE = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int AN_ATTRIBUTE__NAME = ACLASS_CHILD__NAME;

  /**
   * The feature id for the '<em><b>Accessright</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int AN_ATTRIBUTE__ACCESSRIGHT = ACLASS_CHILD__ACCESSRIGHT;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int AN_ATTRIBUTE__DATA_TYPE = ACLASS_CHILD__DATA_TYPE;

  /**
   * The number of structural features of the '<em>An Attribute</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int AN_ATTRIBUTE_FEATURE_COUNT = ACLASS_CHILD_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AnOperationImpl
   * <em>An Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AnOperationImpl
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassdiagramPackageImpl#getAnOperation()
   * @generated
   */
  int AN_OPERATION = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int AN_OPERATION__NAME = ACLASS_CHILD__NAME;

  /**
   * The feature id for the '<em><b>Accessright</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int AN_OPERATION__ACCESSRIGHT = ACLASS_CHILD__ACCESSRIGHT;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int AN_OPERATION__DATA_TYPE = ACLASS_CHILD__DATA_TYPE;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int AN_OPERATION__PARAMETERS = ACLASS_CHILD_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>An Operation</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int AN_OPERATION_FEATURE_COUNT = ACLASS_CHILD_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AParameterImpl
   * <em>AParameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AParameterImpl
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassdiagramPackageImpl#getAParameter()
   * @generated
   */
  int APARAMETER = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int APARAMETER__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int APARAMETER__TYPE = 1;

  /**
   * The number of structural features of the '<em>AParameter</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int APARAMETER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AccessType
   * <em>Access Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AccessType
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassdiagramPackageImpl#getAccessType()
   * @generated
   */
  int ACCESS_TYPE = 8;

  /**
   * The meta object id for the '<em>Access Type Object</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AccessType
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassdiagramPackageImpl#getAccessTypeObject()
   * @generated
   */
  int ACCESS_TYPE_OBJECT = 9;

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClass
   * <em>AClass</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for class '<em>AClass</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClass
   * @generated
   */
  EClass getAClass();

  /**
   * Returns the meta object for the reference list '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClass#getSubClasses <em>Sub Classes</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the reference list '<em>Sub Classes</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClass#getSubClasses()
   * @see #getAClass()
   * @generated
   */
  EReference getAClass_SubClasses();

  /**
   * Returns the meta object for the reference list '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClass#getImplementedInterfaces
   * <em>Implemented Interfaces</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the reference list '<em>Implemented Interfaces</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClass#getImplementedInterfaces()
   * @see #getAClass()
   * @generated
   */
  EReference getAClass_ImplementedInterfaces();

  /**
   * Returns the meta object for the reference list '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClass#getAssociations <em>Associations</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the reference list '<em>Associations</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClass#getAssociations()
   * @see #getAClass()
   * @generated
   */
  EReference getAClass_Associations();

  /**
   * Returns the meta object for the reference list '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClass#getCompositions <em>Compositions</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the reference list '<em>Compositions</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClass#getCompositions()
   * @see #getAClass()
   * @generated
   */
  EReference getAClass_Compositions();

  /**
   * Returns the meta object for the reference list '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClass#getAggregations <em>Aggregations</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the reference list '<em>Aggregations</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClass#getAggregations()
   * @see #getAClass()
   * @generated
   */
  EReference getAClass_Aggregations();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AInterface
   * <em>AInterface</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for class '<em>AInterface</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AInterface
   * @generated
   */
  EClass getAInterface();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassDiagram
   * <em>Class Diagram</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for class '<em>Class Diagram</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassDiagram
   * @generated
   */
  EClass getClassDiagram();

  /**
   * Returns the meta object for the attribute '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassDiagram#getTitle <em>Title</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassDiagram#getTitle()
   * @see #getClassDiagram()
   * @generated
   */
  EAttribute getClassDiagram_Title();

  /**
   * Returns the meta object for the containment reference list '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassDiagram#getClasses <em>Classes</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the containment reference list '<em>Classes</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassDiagram#getClasses()
   * @see #getClassDiagram()
   * @generated
   */
  EReference getClassDiagram_Classes();

  /**
   * Returns the meta object for the containment reference list '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassDiagram#getInterfaces <em>Interfaces</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the containment reference list '<em>Interfaces</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassDiagram#getInterfaces()
   * @see #getClassDiagram()
   * @generated
   */
  EReference getClassDiagram_Interfaces();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AnAttribute
   * <em>An Attribute</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for class '<em>An Attribute</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AnAttribute
   * @generated
   */
  EClass getAnAttribute();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AnOperation
   * <em>An Operation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for class '<em>An Operation</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AnOperation
   * @generated
   */
  EClass getAnOperation();

  /**
   * Returns the meta object for the containment reference list '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AnOperation#getParameters <em>Parameters</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AnOperation#getParameters()
   * @see #getAnOperation()
   * @generated
   */
  EReference getAnOperation_Parameters();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ABasicClass
   * <em>ABasic Class</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for class '<em>ABasic Class</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ABasicClass
   * @generated
   */
  EClass getABasicClass();

  /**
   * Returns the meta object for the containment reference list '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ABasicClass#getOperations <em>Operations</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the containment reference list '<em>Operations</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ABasicClass#getOperations()
   * @see #getABasicClass()
   * @generated
   */
  EReference getABasicClass_Operations();

  /**
   * Returns the meta object for the containment reference list '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ABasicClass#getAttributes <em>Attributes</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ABasicClass#getAttributes()
   * @see #getABasicClass()
   * @generated
   */
  EReference getABasicClass_Attributes();

  /**
   * Returns the meta object for the attribute '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ABasicClass#getName <em>Name</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ABasicClass#getName()
   * @see #getABasicClass()
   * @generated
   */
  EAttribute getABasicClass_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AParameter
   * <em>AParameter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for class '<em>AParameter</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AParameter
   * @generated
   */
  EClass getAParameter();

  /**
   * Returns the meta object for the attribute '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AParameter#getName <em>Name</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AParameter#getName()
   * @see #getAParameter()
   * @generated
   */
  EAttribute getAParameter_Name();

  /**
   * Returns the meta object for the attribute '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AParameter#getType <em>Type</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AParameter#getType()
   * @see #getAParameter()
   * @generated
   */
  EAttribute getAParameter_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClassChild
   * <em>AClass Child</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for class '<em>AClass Child</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClassChild
   * @generated
   */
  EClass getAClassChild();

  /**
   * Returns the meta object for the attribute '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClassChild#getName <em>Name</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClassChild#getName()
   * @see #getAClassChild()
   * @generated
   */
  EAttribute getAClassChild_Name();

  /**
   * Returns the meta object for the attribute '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClassChild#getAccessright <em>Accessright</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the attribute '<em>Accessright</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClassChild#getAccessright()
   * @see #getAClassChild()
   * @generated
   */
  EAttribute getAClassChild_Accessright();

  /**
   * Returns the meta object for the attribute '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClassChild#getDataType <em>Data Type</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the attribute '<em>Data Type</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClassChild#getDataType()
   * @see #getAClassChild()
   * @generated
   */
  EAttribute getAClassChild_DataType();

  /**
   * Returns the meta object for enum '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AccessType
   * <em>Access Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for enum '<em>Access Type</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AccessType
   * @generated
   */
  EEnum getAccessType();

  /**
   * Returns the meta object for data type '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AccessType
   * <em>Access Type Object</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for data type '<em>Access Type Object</em>'.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AccessType
   * @model instanceClass="org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AccessType"
   *        extendedMetaData="name='AccessType:Object' baseType='AccessType'"
   * @generated
   */
  EDataType getAccessTypeObject();

  /**
   * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ClassdiagramFactory getClassdiagramFactory();

  /**
   * <!-- begin-user-doc --> Defines literals for the meta objects that represent
   * <ul>
   * <li>each class,</li>
   * <li>each feature of each class,</li>
   * <li>each enum,</li>
   * <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AClassImpl
     * <em>AClass</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AClassImpl
     * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassdiagramPackageImpl#getAClass()
     * @generated
     */
    EClass ACLASS = eINSTANCE.getAClass();

    /**
     * The meta object literal for the '<em><b>Sub Classes</b></em>' reference list feature. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    EReference ACLASS__SUB_CLASSES = eINSTANCE.getAClass_SubClasses();

    /**
     * The meta object literal for the '<em><b>Implemented Interfaces</b></em>' reference list feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    EReference ACLASS__IMPLEMENTED_INTERFACES = eINSTANCE.getAClass_ImplementedInterfaces();

    /**
     * The meta object literal for the '<em><b>Associations</b></em>' reference list feature. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    EReference ACLASS__ASSOCIATIONS = eINSTANCE.getAClass_Associations();

    /**
     * The meta object literal for the '<em><b>Compositions</b></em>' reference list feature. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    EReference ACLASS__COMPOSITIONS = eINSTANCE.getAClass_Compositions();

    /**
     * The meta object literal for the '<em><b>Aggregations</b></em>' reference list feature. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    EReference ACLASS__AGGREGATIONS = eINSTANCE.getAClass_Aggregations();

    /**
     * The meta object literal for the '
     * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AInterfaceImpl <em>AInterface</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AInterfaceImpl
     * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassdiagramPackageImpl#getAInterface()
     * @generated
     */
    EClass AINTERFACE = eINSTANCE.getAInterface();

    /**
     * The meta object literal for the '
     * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassDiagramImpl <em>Class Diagram</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassDiagramImpl
     * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassdiagramPackageImpl#getClassDiagram()
     * @generated
     */
    EClass CLASS_DIAGRAM = eINSTANCE.getClassDiagram();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    EAttribute CLASS_DIAGRAM__TITLE = eINSTANCE.getClassDiagram_Title();

    /**
     * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    EReference CLASS_DIAGRAM__CLASSES = eINSTANCE.getClassDiagram_Classes();

    /**
     * The meta object literal for the '<em><b>Interfaces</b></em>' containment reference list feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    EReference CLASS_DIAGRAM__INTERFACES = eINSTANCE.getClassDiagram_Interfaces();

    /**
     * The meta object literal for the '
     * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AnAttributeImpl <em>An Attribute</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AnAttributeImpl
     * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassdiagramPackageImpl#getAnAttribute()
     * @generated
     */
    EClass AN_ATTRIBUTE = eINSTANCE.getAnAttribute();

    /**
     * The meta object literal for the '
     * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AnOperationImpl <em>An Operation</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AnOperationImpl
     * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassdiagramPackageImpl#getAnOperation()
     * @generated
     */
    EClass AN_OPERATION = eINSTANCE.getAnOperation();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    EReference AN_OPERATION__PARAMETERS = eINSTANCE.getAnOperation_Parameters();

    /**
     * The meta object literal for the '
     * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ABasicClassImpl <em>ABasic Class</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ABasicClassImpl
     * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassdiagramPackageImpl#getABasicClass()
     * @generated
     */
    EClass ABASIC_CLASS = eINSTANCE.getABasicClass();

    /**
     * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    EReference ABASIC_CLASS__OPERATIONS = eINSTANCE.getABasicClass_Operations();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    EReference ABASIC_CLASS__ATTRIBUTES = eINSTANCE.getABasicClass_Attributes();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    EAttribute ABASIC_CLASS__NAME = eINSTANCE.getABasicClass_Name();

    /**
     * The meta object literal for the '
     * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AParameterImpl <em>AParameter</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AParameterImpl
     * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassdiagramPackageImpl#getAParameter()
     * @generated
     */
    EClass APARAMETER = eINSTANCE.getAParameter();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    EAttribute APARAMETER__NAME = eINSTANCE.getAParameter_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    EAttribute APARAMETER__TYPE = eINSTANCE.getAParameter_Type();

    /**
     * The meta object literal for the '
     * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AClassChildImpl <em>AClass Child</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AClassChildImpl
     * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassdiagramPackageImpl#getAClassChild()
     * @generated
     */
    EClass ACLASS_CHILD = eINSTANCE.getAClassChild();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    EAttribute ACLASS_CHILD__NAME = eINSTANCE.getAClassChild_Name();

    /**
     * The meta object literal for the '<em><b>Accessright</b></em>' attribute feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    EAttribute ACLASS_CHILD__ACCESSRIGHT = eINSTANCE.getAClassChild_Accessright();

    /**
     * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    EAttribute ACLASS_CHILD__DATA_TYPE = eINSTANCE.getAClassChild_DataType();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AccessType
     * <em>Access Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AccessType
     * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassdiagramPackageImpl#getAccessType()
     * @generated
     */
    EEnum ACCESS_TYPE = eINSTANCE.getAccessType();

    /**
     * The meta object literal for the '<em>Access Type Object</em>' data type. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AccessType
     * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassdiagramPackageImpl#getAccessTypeObject()
     * @generated
     */
    EDataType ACCESS_TYPE_OBJECT = eINSTANCE.getAccessTypeObject();

  }

} // ClassdiagramPackage
