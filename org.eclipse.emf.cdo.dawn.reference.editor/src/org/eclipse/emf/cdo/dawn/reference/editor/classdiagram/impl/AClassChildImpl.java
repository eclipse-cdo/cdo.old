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

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClassChild;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AccessType;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramPackage;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>AClass Child</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AClassChildImpl#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AClassChildImpl#getAccessright <em>Accessright
 * </em>}</li>
 * <li>{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AClassChildImpl#getDataType <em>Data Type
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AClassChildImpl extends CDOObjectImpl implements AClassChild
{
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected AClassChildImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ClassdiagramPackage.Literals.ACLASS_CHILD;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected int eStaticFeatureCount()
  {
    return 0;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String getName()
  {
    return (String)eGet(ClassdiagramPackage.Literals.ACLASS_CHILD__NAME, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setName(String newName)
  {
    eSet(ClassdiagramPackage.Literals.ACLASS_CHILD__NAME, newName);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public AccessType getAccessright()
  {
    return (AccessType)eGet(ClassdiagramPackage.Literals.ACLASS_CHILD__ACCESSRIGHT, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setAccessright(AccessType newAccessright)
  {
    eSet(ClassdiagramPackage.Literals.ACLASS_CHILD__ACCESSRIGHT, newAccessright);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void unsetAccessright()
  {
    eUnset(ClassdiagramPackage.Literals.ACLASS_CHILD__ACCESSRIGHT);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean isSetAccessright()
  {
    return eIsSet(ClassdiagramPackage.Literals.ACLASS_CHILD__ACCESSRIGHT);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String getDataType()
  {
    return (String)eGet(ClassdiagramPackage.Literals.ACLASS_CHILD__DATA_TYPE, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setDataType(String newDataType)
  {
    eSet(ClassdiagramPackage.Literals.ACLASS_CHILD__DATA_TYPE, newDataType);
  }

} // AClassChildImpl
