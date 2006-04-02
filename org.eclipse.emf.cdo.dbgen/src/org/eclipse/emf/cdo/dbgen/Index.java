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
package org.eclipse.emf.cdo.dbgen;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Index</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.cdo.dbgen.Index#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.dbgen.Index#getTable <em>Table</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.dbgen.Index#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.dbgen.Index#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.cdo.dbgen.DBGenPackage#getIndex()
 * @model
 * @generated
 */
public interface Index extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.emf.cdo.dbgen.DBGenPackage#getIndex_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.emf.cdo.dbgen.Index#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Table</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.emf.cdo.dbgen.Table#getIndices <em>Indices</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Table</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Table</em>' container reference.
   * @see #setTable(Table)
   * @see org.eclipse.emf.cdo.dbgen.DBGenPackage#getIndex_Table()
   * @see org.eclipse.emf.cdo.dbgen.Table#getIndices
   * @model opposite="indices" required="true"
   * @generated
   */
  Table getTable();

  /**
   * Sets the value of the '{@link org.eclipse.emf.cdo.dbgen.Index#getTable <em>Table</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Table</em>' container reference.
   * @see #getTable()
   * @generated
   */
  void setTable(Table value);

  /**
   * Returns the value of the '<em><b>Columns</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.emf.cdo.dbgen.Column}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Columns</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Columns</em>' reference list.
   * @see org.eclipse.emf.cdo.dbgen.DBGenPackage#getIndex_Columns()
   * @model type="org.eclipse.emf.cdo.dbgen.Column"
   * @generated
   */
  EList getColumns();

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.emf.cdo.dbgen.IndexType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see org.eclipse.emf.cdo.dbgen.IndexType
   * @see #setType(IndexType)
   * @see org.eclipse.emf.cdo.dbgen.DBGenPackage#getIndex_Type()
   * @model
   * @generated
   */
  IndexType getType();

  /**
   * Sets the value of the '{@link org.eclipse.emf.cdo.dbgen.Index#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see org.eclipse.emf.cdo.dbgen.IndexType
   * @see #getType()
   * @generated
   */
  void setType(IndexType value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  Column getColumn(String name);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  Column addColumn(String name);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  Column addColumn(int index);

} // Index
