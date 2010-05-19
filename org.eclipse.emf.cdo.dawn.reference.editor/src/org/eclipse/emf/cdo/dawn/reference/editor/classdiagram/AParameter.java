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

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>AParameter</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AParameter#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AParameter#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramPackage#getAParameter()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface AParameter extends CDOObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramPackage#getAParameter_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AParameter#getName
   * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramPackage#getAParameter_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AParameter#getType
   * <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

} // AParameter
