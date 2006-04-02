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
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.cdo.dbgen.Table#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.dbgen.Table#getDatabase <em>Database</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.dbgen.Table#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.dbgen.Table#getIndices <em>Indices</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.cdo.dbgen.DbgenPackage#getTable()
 * @model
 * @generated
 */
public interface Table extends EObject
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
   * @see org.eclipse.emf.cdo.dbgen.DbgenPackage#getTable_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.emf.cdo.dbgen.Table#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Database</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.emf.cdo.dbgen.Database#getTables <em>Tables</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Database</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Database</em>' container reference.
   * @see #setDatabase(Database)
   * @see org.eclipse.emf.cdo.dbgen.DbgenPackage#getTable_Database()
   * @see org.eclipse.emf.cdo.dbgen.Database#getTables
   * @model opposite="tables" required="true"
   * @generated
   */
  Database getDatabase();

  /**
   * Sets the value of the '{@link org.eclipse.emf.cdo.dbgen.Table#getDatabase <em>Database</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Database</em>' container reference.
   * @see #getDatabase()
   * @generated
   */
  void setDatabase(Database value);

  /**
   * Returns the value of the '<em><b>Columns</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.cdo.dbgen.Column}.
   * It is bidirectional and its opposite is '{@link org.eclipse.emf.cdo.dbgen.Column#getTable <em>Table</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Columns</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Columns</em>' containment reference list.
   * @see org.eclipse.emf.cdo.dbgen.DbgenPackage#getTable_Columns()
   * @see org.eclipse.emf.cdo.dbgen.Column#getTable
   * @model type="org.eclipse.emf.cdo.dbgen.Column" opposite="table" containment="true"
   * @generated
   */
  EList getColumns();

  /**
   * Returns the value of the '<em><b>Indices</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.cdo.dbgen.Index}.
   * It is bidirectional and its opposite is '{@link org.eclipse.emf.cdo.dbgen.Index#getTable <em>Table</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Indices</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Indices</em>' containment reference list.
   * @see org.eclipse.emf.cdo.dbgen.DbgenPackage#getTable_Indices()
   * @see org.eclipse.emf.cdo.dbgen.Index#getTable
   * @model type="org.eclipse.emf.cdo.dbgen.Index" opposite="table" containment="true"
   * @generated
   */
  EList getIndices();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   * @generated
   */
  Index getPrimaryIndex();

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
  Column addColumn(String name, ColumnType type, int length, String constraint);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  Column addColumn(String name, ColumnType type, String constraint);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  Column addColumn(String name, ColumnType type, int length);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  Column addColumn(String name, ColumnType type);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  Index getIndex(String name);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  Index addIndex(String name, IndexType type);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  Index addSimpleIndex(String columnName, IndexType indexType);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  Index addCompoundIndex(String columnNames, IndexType indexType);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model 
   * @generated NOT
   */
  Index addCompoundIndex(String[] columnNames, IndexType indexType);

} // Table
