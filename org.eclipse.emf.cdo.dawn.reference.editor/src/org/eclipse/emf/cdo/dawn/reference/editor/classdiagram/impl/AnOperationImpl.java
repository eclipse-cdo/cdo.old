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

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AParameter;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AnOperation;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramPackage;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>An Operation</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.AnOperationImpl#getParameters <em>Parameters
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AnOperationImpl extends AClassChildImpl implements AnOperation
{
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected AnOperationImpl()
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
    return ClassdiagramPackage.Literals.AN_OPERATION;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<AParameter> getParameters()
  {
    return (EList<AParameter>)eGet(ClassdiagramPackage.Literals.AN_OPERATION__PARAMETERS, true);
  }

} // AnOperationImpl
