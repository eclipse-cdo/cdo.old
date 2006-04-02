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


import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.cdo.dbgen.Column#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.dbgen.Column#getTable <em>Table</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.dbgen.Column#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.dbgen.Column#getLength <em>Length</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.dbgen.Column#getConstraint <em>Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.cdo.dbgen.DBGenPackage#getColumn()
 * @model
 * @generated
 */
public interface Column extends EObject
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
   * @see org.eclipse.emf.cdo.dbgen.DBGenPackage#getColumn_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.emf.cdo.dbgen.Column#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Table</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.emf.cdo.dbgen.Table#getColumns <em>Columns</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Table</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Table</em>' container reference.
   * @see #setTable(Table)
   * @see org.eclipse.emf.cdo.dbgen.DBGenPackage#getColumn_Table()
   * @see org.eclipse.emf.cdo.dbgen.Table#getColumns
   * @model opposite="columns" required="true"
   * @generated
   */
  Table getTable();

  /**
   * Sets the value of the '{@link org.eclipse.emf.cdo.dbgen.Column#getTable <em>Table</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Table</em>' container reference.
   * @see #getTable()
   * @generated
   */
  void setTable(Table value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.emf.cdo.dbgen.ColumnType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see org.eclipse.emf.cdo.dbgen.ColumnType
   * @see #setType(ColumnType)
   * @see org.eclipse.emf.cdo.dbgen.DBGenPackage#getColumn_Type()
   * @model
   * @generated
   */
  ColumnType getType();

  /**
   * Sets the value of the '{@link org.eclipse.emf.cdo.dbgen.Column#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see org.eclipse.emf.cdo.dbgen.ColumnType
   * @see #getType()
   * @generated
   */
  void setType(ColumnType value);

  /**
   * Returns the value of the '<em><b>Length</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Length</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Length</em>' attribute.
   * @see #setLength(int)
   * @see org.eclipse.emf.cdo.dbgen.DBGenPackage#getColumn_Length()
   * @model
   * @generated
   */
  int getLength();

  /**
   * Sets the value of the '{@link org.eclipse.emf.cdo.dbgen.Column#getLength <em>Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Length</em>' attribute.
   * @see #getLength()
   * @generated
   */
  void setLength(int value);

  /**
   * Returns the value of the '<em><b>Constraint</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraint</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraint</em>' attribute.
   * @see #setConstraint(String)
   * @see org.eclipse.emf.cdo.dbgen.DBGenPackage#getColumn_Constraint()
   * @model
   * @generated
   */
  String getConstraint();

  /**
   * Sets the value of the '{@link org.eclipse.emf.cdo.dbgen.Column#getConstraint <em>Constraint</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constraint</em>' attribute.
   * @see #getConstraint()
   * @generated
   */
  void setConstraint(String value);

} // Column
