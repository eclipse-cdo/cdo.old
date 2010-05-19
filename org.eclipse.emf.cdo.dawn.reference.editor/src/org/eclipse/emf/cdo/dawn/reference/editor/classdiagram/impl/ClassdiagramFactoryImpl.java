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
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl;

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ABasicClass;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClass;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClassChild;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AInterface;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AParameter;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AccessType;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AnAttribute;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AnOperation;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassDiagram;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramFactory;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ClassdiagramFactoryImpl extends EFactoryImpl implements ClassdiagramFactory
{
  /**
   * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public static ClassdiagramFactory init()
  {
    try
    {
      ClassdiagramFactory theClassdiagramFactory = (ClassdiagramFactory)EPackage.Registry.INSTANCE
          .getEFactory("http://class.uml.diagram.mftech.org");
      if (theClassdiagramFactory != null)
      {
        return theClassdiagramFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ClassdiagramFactoryImpl();
  }

  /**
   * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public ClassdiagramFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
    case ClassdiagramPackage.ACLASS:
      return (EObject)createAClass();
    case ClassdiagramPackage.AINTERFACE:
      return (EObject)createAInterface();
    case ClassdiagramPackage.CLASS_DIAGRAM:
      return (EObject)createClassDiagram();
    case ClassdiagramPackage.AN_ATTRIBUTE:
      return (EObject)createAnAttribute();
    case ClassdiagramPackage.AN_OPERATION:
      return (EObject)createAnOperation();
    case ClassdiagramPackage.ABASIC_CLASS:
      return (EObject)createABasicClass();
    case ClassdiagramPackage.APARAMETER:
      return (EObject)createAParameter();
    case ClassdiagramPackage.ACLASS_CHILD:
      return (EObject)createAClassChild();
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
    case ClassdiagramPackage.ACCESS_TYPE:
      return createAccessTypeFromString(eDataType, initialValue);
    case ClassdiagramPackage.ACCESS_TYPE_OBJECT:
      return createAccessTypeObjectFromString(eDataType, initialValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
    case ClassdiagramPackage.ACCESS_TYPE:
      return convertAccessTypeToString(eDataType, instanceValue);
    case ClassdiagramPackage.ACCESS_TYPE_OBJECT:
      return convertAccessTypeObjectToString(eDataType, instanceValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public AClass createAClass()
  {
    AClassImpl aClass = new AClassImpl();
    return aClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public AInterface createAInterface()
  {
    AInterfaceImpl aInterface = new AInterfaceImpl();
    return aInterface;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public ClassDiagram createClassDiagram()
  {
    ClassDiagramImpl classDiagram = new ClassDiagramImpl();
    return classDiagram;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public AnAttribute createAnAttribute()
  {
    AnAttributeImpl anAttribute = new AnAttributeImpl();
    return anAttribute;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public AnOperation createAnOperation()
  {
    AnOperationImpl anOperation = new AnOperationImpl();
    return anOperation;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public ABasicClass createABasicClass()
  {
    ABasicClassImpl aBasicClass = new ABasicClassImpl();
    return aBasicClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public AParameter createAParameter()
  {
    AParameterImpl aParameter = new AParameterImpl();
    return aParameter;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public AClassChild createAClassChild()
  {
    AClassChildImpl aClassChild = new AClassChildImpl();
    return aClassChild;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public AccessType createAccessTypeFromString(EDataType eDataType, String initialValue)
  {
    AccessType result = AccessType.get(initialValue);
    if (result == null)
      throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
          + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String convertAccessTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public AccessType createAccessTypeObjectFromString(EDataType eDataType, String initialValue)
  {
    return createAccessTypeFromString(ClassdiagramPackage.Literals.ACCESS_TYPE, initialValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String convertAccessTypeObjectToString(EDataType eDataType, Object instanceValue)
  {
    return convertAccessTypeToString(ClassdiagramPackage.Literals.ACCESS_TYPE, instanceValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public ClassdiagramPackage getClassdiagramPackage()
  {
    return (ClassdiagramPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ClassdiagramPackage getPackage()
  {
    return ClassdiagramPackage.eINSTANCE;
  }

} // ClassdiagramFactoryImpl
