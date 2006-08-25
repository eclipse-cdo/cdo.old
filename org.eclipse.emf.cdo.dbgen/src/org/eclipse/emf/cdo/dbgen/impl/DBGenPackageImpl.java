/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.dbgen.impl;


import org.eclipse.emf.cdo.dbgen.Column;
import org.eclipse.emf.cdo.dbgen.ColumnType;
import org.eclipse.emf.cdo.dbgen.DBGenFactory;
import org.eclipse.emf.cdo.dbgen.DBGenPackage;
import org.eclipse.emf.cdo.dbgen.Database;
import org.eclipse.emf.cdo.dbgen.Index;
import org.eclipse.emf.cdo.dbgen.IndexType;
import org.eclipse.emf.cdo.dbgen.Table;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DBGenPackageImpl extends EPackageImpl implements DBGenPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass databaseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass columnEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass indexEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum columnTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum indexTypeEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.emf.cdo.dbgen.DBGenPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private DBGenPackageImpl()
  {
    super(eNS_URI, DBGenFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this
   * model, and for any others upon which it depends.  Simple
   * dependencies are satisfied by calling this method on all
   * dependent packages before doing anything else.  This method drives
   * initialization for interdependent packages directly, in parallel
   * with this package, itself.
   * <p>Of this package and its interdependencies, all packages which
   * have not yet been registered by their URI values are first created
   * and registered.  The packages are then initialized in two steps:
   * meta-model objects for all of the packages are created before any
   * are initialized, since one package's meta-model objects may refer to
   * those of another.
   * <p>Invocation of this method will not affect any packages that have
   * already been initialized.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static DBGenPackage init()
  {
    if (isInited)
      return (DBGenPackage) EPackage.Registry.INSTANCE.getEPackage(DBGenPackage.eNS_URI);

    // Obtain or create and register package
    DBGenPackageImpl theDBGenPackage = (DBGenPackageImpl) (EPackage.Registry.INSTANCE
        .getEPackage(eNS_URI) instanceof DBGenPackageImpl ? EPackage.Registry.INSTANCE
        .getEPackage(eNS_URI) : new DBGenPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theDBGenPackage.createPackageContents();

    // Initialize created meta-data
    theDBGenPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theDBGenPackage.freeze();

    return theDBGenPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDatabase()
  {
    return databaseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDatabase_Name()
  {
    return (EAttribute) databaseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDatabase_Tables()
  {
    return (EReference) databaseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTable()
  {
    return tableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTable_Name()
  {
    return (EAttribute) tableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTable_Database()
  {
    return (EReference) tableEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTable_Columns()
  {
    return (EReference) tableEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTable_Indices()
  {
    return (EReference) tableEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getColumn()
  {
    return columnEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getColumn_Name()
  {
    return (EAttribute) columnEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getColumn_Table()
  {
    return (EReference) columnEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getColumn_Type()
  {
    return (EAttribute) columnEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getColumn_Length()
  {
    return (EAttribute) columnEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getColumn_Constraint()
  {
    return (EAttribute) columnEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIndex()
  {
    return indexEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIndex_Name()
  {
    return (EAttribute) indexEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIndex_Table()
  {
    return (EReference) indexEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIndex_Columns()
  {
    return (EReference) indexEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIndex_Type()
  {
    return (EAttribute) indexEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getColumnType()
  {
    return columnTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getIndexType()
  {
    return indexTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DBGenFactory getDBGenFactory()
  {
    return (DBGenFactory) getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    databaseEClass = createEClass(DATABASE);
    createEAttribute(databaseEClass, DATABASE__NAME);
    createEReference(databaseEClass, DATABASE__TABLES);

    tableEClass = createEClass(TABLE);
    createEAttribute(tableEClass, TABLE__NAME);
    createEReference(tableEClass, TABLE__DATABASE);
    createEReference(tableEClass, TABLE__COLUMNS);
    createEReference(tableEClass, TABLE__INDICES);

    columnEClass = createEClass(COLUMN);
    createEAttribute(columnEClass, COLUMN__NAME);
    createEReference(columnEClass, COLUMN__TABLE);
    createEAttribute(columnEClass, COLUMN__TYPE);
    createEAttribute(columnEClass, COLUMN__LENGTH);
    createEAttribute(columnEClass, COLUMN__CONSTRAINT);

    indexEClass = createEClass(INDEX);
    createEAttribute(indexEClass, INDEX__NAME);
    createEReference(indexEClass, INDEX__TABLE);
    createEReference(indexEClass, INDEX__COLUMNS);
    createEAttribute(indexEClass, INDEX__TYPE);

    // Create enums
    columnTypeEEnum = createEEnum(COLUMN_TYPE);
    indexTypeEEnum = createEEnum(INDEX_TYPE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(databaseEClass, Database.class, "Database", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDatabase_Name(), ecorePackage.getEString(), "name", null, 0, 1,
        Database.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDatabase_Tables(), this.getTable(), this.getTable_Database(), "tables", null,
        0, -1, Database.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    EOperation op = addEOperation(databaseEClass, this.getTable(), "getTable", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "name", 0, 1);

    op = addEOperation(databaseEClass, this.getTable(), "addTable", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "name", 0, 1);

    initEClass(tableEClass, Table.class, "Table", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTable_Name(), ecorePackage.getEString(), "name", null, 0, 1, Table.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEReference(getTable_Database(), this.getDatabase(), this.getDatabase_Tables(), "database",
        null, 1, 1, Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTable_Columns(), this.getColumn(), this.getColumn_Table(), "columns", null,
        0, -1, Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTable_Indices(), this.getIndex(), this.getIndex_Table(), "indices", null, 0,
        -1, Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(tableEClass, this.getIndex(), "getPrimaryIndex", 0, 1);

    op = addEOperation(tableEClass, this.getColumn(), "getColumn", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "name", 0, 1);

    op = addEOperation(tableEClass, this.getColumn(), "addColumn", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "name", 0, 1);
    addEParameter(op, this.getColumnType(), "type", 0, 1);
    addEParameter(op, ecorePackage.getEInt(), "length", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "constraint", 0, 1);

    op = addEOperation(tableEClass, this.getColumn(), "addColumn", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "name", 0, 1);
    addEParameter(op, this.getColumnType(), "type", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "constraint", 0, 1);

    op = addEOperation(tableEClass, this.getColumn(), "addColumn", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "name", 0, 1);
    addEParameter(op, this.getColumnType(), "type", 0, 1);
    addEParameter(op, ecorePackage.getEInt(), "length", 0, 1);

    op = addEOperation(tableEClass, this.getColumn(), "addColumn", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "name", 0, 1);
    addEParameter(op, this.getColumnType(), "type", 0, 1);

    op = addEOperation(tableEClass, this.getIndex(), "getIndex", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "name", 0, 1);

    op = addEOperation(tableEClass, this.getIndex(), "addIndex", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "name", 0, 1);
    addEParameter(op, this.getIndexType(), "type", 0, 1);

    op = addEOperation(tableEClass, this.getIndex(), "addSimpleIndex", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "columnName", 0, 1);
    addEParameter(op, this.getIndexType(), "indexType", 0, 1);

    op = addEOperation(tableEClass, this.getIndex(), "addCompoundIndex", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "columnNames", 0, 1);
    addEParameter(op, this.getIndexType(), "indexType", 0, 1);

    initEClass(columnEClass, Column.class, "Column", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getColumn_Name(), ecorePackage.getEString(), "name", null, 0, 1, Column.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEReference(getColumn_Table(), this.getTable(), this.getTable_Columns(), "table", null, 1,
        1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getColumn_Type(), this.getColumnType(), "type", null, 0, 1, Column.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEAttribute(getColumn_Length(), ecorePackage.getEInt(), "length", null, 0, 1, Column.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEAttribute(getColumn_Constraint(), ecorePackage.getEString(), "constraint", null, 0, 1,
        Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
        IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(indexEClass, Index.class, "Index", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIndex_Name(), ecorePackage.getEString(), "name", null, 0, 1, Index.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEReference(getIndex_Table(), this.getTable(), this.getTable_Indices(), "table", null, 1, 1,
        Index.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIndex_Columns(), this.getColumn(), null, "columns", null, 0, -1, Index.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
        !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIndex_Type(), this.getIndexType(), "type", null, 0, 1, Index.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);

    op = addEOperation(indexEClass, this.getColumn(), "getColumn", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "name", 0, 1);

    op = addEOperation(indexEClass, this.getColumn(), "addColumn", 0, 1);
    addEParameter(op, ecorePackage.getEString(), "name", 0, 1);

    op = addEOperation(indexEClass, this.getColumn(), "addColumn", 0, 1);
    addEParameter(op, ecorePackage.getEInt(), "index", 0, 1);

    // Initialize enums and add enum literals
    initEEnum(columnTypeEEnum, ColumnType.class, "ColumnType");
    addEEnumLiteral(columnTypeEEnum, ColumnType.BOOLEAN_LITERAL);
    addEEnumLiteral(columnTypeEEnum, ColumnType.BIT_LITERAL);
    addEEnumLiteral(columnTypeEEnum, ColumnType.TINYINT_LITERAL);
    addEEnumLiteral(columnTypeEEnum, ColumnType.SMALLINT_LITERAL);
    addEEnumLiteral(columnTypeEEnum, ColumnType.INTEGER_LITERAL);
    addEEnumLiteral(columnTypeEEnum, ColumnType.BIGINT_LITERAL);
    addEEnumLiteral(columnTypeEEnum, ColumnType.FLOAT_LITERAL);
    addEEnumLiteral(columnTypeEEnum, ColumnType.REAL_LITERAL);
    addEEnumLiteral(columnTypeEEnum, ColumnType.DOUBLE_LITERAL);
    addEEnumLiteral(columnTypeEEnum, ColumnType.NUMERIC_LITERAL);
    addEEnumLiteral(columnTypeEEnum, ColumnType.DECIMAL_LITERAL);
    addEEnumLiteral(columnTypeEEnum, ColumnType.CHAR_LITERAL);
    addEEnumLiteral(columnTypeEEnum, ColumnType.VARCHAR_LITERAL);
    addEEnumLiteral(columnTypeEEnum, ColumnType.LONGVARCHAR_LITERAL);
    addEEnumLiteral(columnTypeEEnum, ColumnType.DATE_LITERAL);
    addEEnumLiteral(columnTypeEEnum, ColumnType.TIME_LITERAL);
    addEEnumLiteral(columnTypeEEnum, ColumnType.TIMESTAMP_LITERAL);
    addEEnumLiteral(columnTypeEEnum, ColumnType.BINARY_LITERAL);
    addEEnumLiteral(columnTypeEEnum, ColumnType.VARBINARY_LITERAL);
    addEEnumLiteral(columnTypeEEnum, ColumnType.LONGVARBINARY_LITERAL);
    addEEnumLiteral(columnTypeEEnum, ColumnType.BLOB_LITERAL);
    addEEnumLiteral(columnTypeEEnum, ColumnType.CLOB_LITERAL);

    initEEnum(indexTypeEEnum, IndexType.class, "IndexType");
    addEEnumLiteral(indexTypeEEnum, IndexType.NON_UNIQUE_LITERAL);
    addEEnumLiteral(indexTypeEEnum, IndexType.UNIQUE_LITERAL);
    addEEnumLiteral(indexTypeEEnum, IndexType.PRIMARY_LITERAL);

    // Create resource
    createResource(eNS_URI);
  }

} //DBGenPackageImpl
