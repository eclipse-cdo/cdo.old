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


import org.eclipse.net4j.util.StringHelper;

import org.eclipse.emf.cdo.dbgen.Column;
import org.eclipse.emf.cdo.dbgen.ColumnNotFoundException;
import org.eclipse.emf.cdo.dbgen.ColumnType;
import org.eclipse.emf.cdo.dbgen.DBGenFactory;
import org.eclipse.emf.cdo.dbgen.DBGenPackage;
import org.eclipse.emf.cdo.dbgen.Database;
import org.eclipse.emf.cdo.dbgen.Index;
import org.eclipse.emf.cdo.dbgen.IndexNotFoundException;
import org.eclipse.emf.cdo.dbgen.IndexType;
import org.eclipse.emf.cdo.dbgen.Table;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import java.util.Collection;
import java.util.Iterator;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.cdo.dbgen.impl.TableImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.dbgen.impl.TableImpl#getDatabase <em>Database</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.dbgen.impl.TableImpl#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.dbgen.impl.TableImpl#getIndices <em>Indices</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TableImpl extends EObjectImpl implements Table
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getColumns() <em>Columns</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getColumns()
   * @generated
   * @ordered
   */
  protected EList columns = null;

  /**
   * The cached value of the '{@link #getIndices() <em>Indices</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndices()
   * @generated
   * @ordered
   */
  protected EList indices = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TableImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass()
  {
    return DBGenPackage.Literals.TABLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DBGenPackage.TABLE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Database getDatabase()
  {
    if (eContainerFeatureID != DBGenPackage.TABLE__DATABASE) return null;
    return (Database) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDatabase(Database newDatabase, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject) newDatabase, DBGenPackage.TABLE__DATABASE, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDatabase(Database newDatabase)
  {
    if (newDatabase != eInternalContainer()
        || (eContainerFeatureID != DBGenPackage.TABLE__DATABASE && newDatabase != null))
    {
      if (EcoreUtil.isAncestor(this, newDatabase))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null) msgs = eBasicRemoveFromContainer(msgs);
      if (newDatabase != null)
        msgs = ((InternalEObject) newDatabase).eInverseAdd(this, DBGenPackage.DATABASE__TABLES,
            Database.class, msgs);
      msgs = basicSetDatabase(newDatabase, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DBGenPackage.TABLE__DATABASE,
          newDatabase, newDatabase));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getColumns()
  {
    if (columns == null)
    {
      columns = new EObjectContainmentWithInverseEList(Column.class, this,
          DBGenPackage.TABLE__COLUMNS, DBGenPackage.COLUMN__TABLE);
    }
    return columns;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getIndices()
  {
    if (indices == null)
    {
      indices = new EObjectContainmentWithInverseEList(Index.class, this,
          DBGenPackage.TABLE__INDICES, DBGenPackage.INDEX__TABLE);
    }
    return indices;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Index getPrimaryIndex()
  {
    for (Iterator iter = getIndices().iterator(); iter.hasNext();)
    {
      Index index = (Index) iter.next();
      if (index.getType().getValue() == IndexType.PRIMARY)
      {
        return index;
      }
    }

    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Column getColumn(String name)
  {
    for (Iterator iter = getColumns().iterator(); iter.hasNext();)
    {
      Column column = (Column) iter.next();
      if (column.getName().equals(name))
      {
        return column;
      }
    }

    throw new ColumnNotFoundException("column " + name + " not found in table " + getName());
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Column addColumn(String name, ColumnType type, int length, String constraint)
  {
    Column column = DBGenFactory.eINSTANCE.createColumn();
    column.setName(name);
    column.setType(type);
    column.setLength(length);
    column.setConstraint(constraint);
    column.setTable(this);
    return column;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Column addColumn(String name, ColumnType type, int length)
  {
    return addColumn(name, type, length, null);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Column addColumn(String name, ColumnType type, String constraint)
  {
    return addColumn(name, type, 0, constraint);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Column addColumn(String name, ColumnType type)
  {
    return addColumn(name, type, 0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Index getIndex(String name)
  {
    for (Iterator iter = getIndices().iterator(); iter.hasNext();)
    {
      Index index = (Index) iter.next();
      if (index.getName().equals(name))
      {
        return index;
      }
    }

    throw new IndexNotFoundException("index " + name + " not found in table " + getName());
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Index addIndex(String name, IndexType type)
  {
    Index index = DBGenFactory.eINSTANCE.createIndex();
    index.setName(name);
    index.setType(type);
    index.setTable(this);
    return index;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Index addSimpleIndex(String columnName, IndexType indexType)
  {
    Index index = addIndex(columnName, indexType);
    index.addColumn(columnName);
    return index;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Index addCompoundIndex(String columnNames, IndexType indexType)
  {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
      NotificationChain msgs)
  {
    switch (featureID)
    {
      case DBGenPackage.TABLE__DATABASE:
        if (eInternalContainer() != null) msgs = eBasicRemoveFromContainer(msgs);
        return basicSetDatabase((Database) otherEnd, msgs);
      case DBGenPackage.TABLE__COLUMNS:
        return ((InternalEList) getColumns()).basicAdd(otherEnd, msgs);
      case DBGenPackage.TABLE__INDICES:
        return ((InternalEList) getIndices()).basicAdd(otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs)
  {
    switch (featureID)
    {
      case DBGenPackage.TABLE__DATABASE:
        return basicSetDatabase(null, msgs);
      case DBGenPackage.TABLE__COLUMNS:
        return ((InternalEList) getColumns()).basicRemove(otherEnd, msgs);
      case DBGenPackage.TABLE__INDICES:
        return ((InternalEList) getIndices()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
    switch (eContainerFeatureID)
    {
      case DBGenPackage.TABLE__DATABASE:
        return eInternalContainer().eInverseRemove(this, DBGenPackage.DATABASE__TABLES,
            Database.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case DBGenPackage.TABLE__NAME:
        return getName();
      case DBGenPackage.TABLE__DATABASE:
        return getDatabase();
      case DBGenPackage.TABLE__COLUMNS:
        return getColumns();
      case DBGenPackage.TABLE__INDICES:
        return getIndices();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case DBGenPackage.TABLE__NAME:
        setName((String) newValue);
        return;
      case DBGenPackage.TABLE__DATABASE:
        setDatabase((Database) newValue);
        return;
      case DBGenPackage.TABLE__COLUMNS:
        getColumns().clear();
        getColumns().addAll((Collection) newValue);
        return;
      case DBGenPackage.TABLE__INDICES:
        getIndices().clear();
        getIndices().addAll((Collection) newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case DBGenPackage.TABLE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case DBGenPackage.TABLE__DATABASE:
        setDatabase((Database) null);
        return;
      case DBGenPackage.TABLE__COLUMNS:
        getColumns().clear();
        return;
      case DBGenPackage.TABLE__INDICES:
        getIndices().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case DBGenPackage.TABLE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case DBGenPackage.TABLE__DATABASE:
        return getDatabase() != null;
      case DBGenPackage.TABLE__COLUMNS:
        return columns != null && !columns.isEmpty();
      case DBGenPackage.TABLE__INDICES:
        return indices != null && !indices.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Index addCompoundIndex(String[] columnNames, IndexType indexType)
  {
    if (columnNames == null) throw new IllegalArgumentException("columnNames is null");
    if (columnNames.length == 0) throw new IllegalArgumentException("columnNames is empty");

    String indexName = StringHelper.implode(columnNames, "_");
    Index index = addIndex(indexName, indexType);

    for (int i = 0; i < columnNames.length; i++)
    {
      index.addColumn(columnNames[i]);
    }

    return index;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //TableImpl
