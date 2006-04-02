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
package org.eclipse.emf.cdo.dbgen.impl;


import org.eclipse.emf.cdo.dbgen.Column;
import org.eclipse.emf.cdo.dbgen.ColumnType;
import org.eclipse.emf.cdo.dbgen.Database;
import org.eclipse.emf.cdo.dbgen.DbgenFactory;
import org.eclipse.emf.cdo.dbgen.DbgenPackage;
import org.eclipse.emf.cdo.dbgen.Index;
import org.eclipse.emf.cdo.dbgen.IndexType;
import org.eclipse.emf.cdo.dbgen.Table;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DbgenFactoryImpl extends EFactoryImpl implements DbgenFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static DbgenFactory init()
  {
    try
    {
      DbgenFactory theDbgenFactory = (DbgenFactory)EPackage.Registry.INSTANCE
              .getEFactory("http://www.eclipse.org/net4j/dbgen.ecore");
      if (theDbgenFactory != null)
      {
        return theDbgenFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new DbgenFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DbgenFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
    case DbgenPackage.DATABASE:
      return createDatabase();
    case DbgenPackage.TABLE:
      return createTable();
    case DbgenPackage.COLUMN:
      return createColumn();
    case DbgenPackage.INDEX:
      return createIndex();
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName()
              + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
    case DbgenPackage.COLUMN_TYPE:
      return createColumnTypeFromString(eDataType, initialValue);
    case DbgenPackage.INDEX_TYPE:
      return createIndexTypeFromString(eDataType, initialValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName()
              + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
    case DbgenPackage.COLUMN_TYPE:
      return convertColumnTypeToString(eDataType, instanceValue);
    case DbgenPackage.INDEX_TYPE:
      return convertIndexTypeToString(eDataType, instanceValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName()
              + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Database createDatabase()
  {
    DatabaseImpl database = new DatabaseImpl();
    return database;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Table createTable()
  {
    TableImpl table = new TableImpl();
    return table;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Column createColumn()
  {
    ColumnImpl column = new ColumnImpl();
    return column;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Index createIndex()
  {
    IndexImpl index = new IndexImpl();
    return index;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ColumnType createColumnTypeFromString(EDataType eDataType, String initialValue)
  {
    ColumnType result = ColumnType.get(initialValue);
    if (result == null)
      throw new IllegalArgumentException("The value '" + initialValue
              + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertColumnTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IndexType createIndexTypeFromString(EDataType eDataType, String initialValue)
  {
    IndexType result = IndexType.get(initialValue);
    if (result == null)
      throw new IllegalArgumentException("The value '" + initialValue
              + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertIndexTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DbgenPackage getDbgenPackage()
  {
    return (DbgenPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  public static DbgenPackage getPackage()
  {
    return DbgenPackage.eINSTANCE;
  }

} //DbgenFactoryImpl
