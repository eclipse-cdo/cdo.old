/*******************************************************************************
 * Copyright (c) 2010 Martin Fluegge (Berlin, Germany).
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
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AnAttribute;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AnOperation;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramPackage;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>ABasic Class</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ABasicClassImpl#getOperations <em>Operations
 * </em>}</li>
 * <li>{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ABasicClassImpl#getAttributes <em>Attributes
 * </em>}</li>
 * <li>{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ABasicClassImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ABasicClassImpl extends CDOObjectImpl implements ABasicClass
{
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected ABasicClassImpl()
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
    return ClassdiagramPackage.Literals.ABASIC_CLASS;
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
  @SuppressWarnings("unchecked")
  public EList<AnOperation> getOperations()
  {
    return (EList<AnOperation>)eGet(ClassdiagramPackage.Literals.ABASIC_CLASS__OPERATIONS, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<AnAttribute> getAttributes()
  {
    return (EList<AnAttribute>)eGet(ClassdiagramPackage.Literals.ABASIC_CLASS__ATTRIBUTES, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String getName()
  {
    return (String)eGet(ClassdiagramPackage.Literals.ABASIC_CLASS__NAME, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setName(String newName)
  {
    eSet(ClassdiagramPackage.Literals.ABASIC_CLASS__NAME, newName);
  }

} // ABasicClassImpl
