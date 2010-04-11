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
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>ABasic Class</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ABasicClass#getOperations <em>Operations</em>}</li>
 * <li>{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ABasicClass#getAttributes <em>Attributes</em>}</li>
 * <li>{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ABasicClass#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramPackage#getABasicClass()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface ABasicClass extends CDOObject
{
  /**
   * Returns the value of the '<em><b>Operations</b></em>' containment reference list. The list contents are of type
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AnOperation}. <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operations</em>' containment reference list isn't clear, there really should be more of
   * a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Operations</em>' containment reference list.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramPackage#getABasicClass_Operations()
   * @model containment="true"
   * @generated
   */
  EList<AnOperation> getOperations();

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list. The list contents are of type
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AnAttribute}. <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear, there really should be more of
   * a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramPackage#getABasicClass_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<AnAttribute> getAttributes();

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramPackage#getABasicClass_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ABasicClass#getName
   * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // ABasicClass
