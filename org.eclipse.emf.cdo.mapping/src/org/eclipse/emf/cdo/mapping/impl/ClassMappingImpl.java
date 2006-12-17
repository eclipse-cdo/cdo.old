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
package org.eclipse.emf.cdo.mapping.impl;


import org.eclipse.emf.cdo.mapping.AttributeMapping;
import org.eclipse.emf.cdo.mapping.ClassMapping;
import org.eclipse.emf.cdo.mapping.MappingPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import java.util.Collection;
import java.util.Iterator;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.cdo.mapping.impl.ClassMappingImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.mapping.impl.ClassMappingImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.mapping.impl.ClassMappingImpl#getTableName <em>Table Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassMappingImpl extends EObjectImpl implements ClassMapping
{
  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<AttributeMapping> attributes = null;

  /**
   * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassName()
   * @generated
   * @ordered
   */
  protected static final String CLASS_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassName()
   * @generated
   * @ordered
   */
  protected String className = CLASS_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getTableName() <em>Table Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTableName()
   * @generated
   * @ordered
   */
  protected static final String TABLE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTableName() <em>Table Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTableName()
   * @generated
   * @ordered
   */
  protected String tableName = TABLE_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassMappingImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MappingPackage.Literals.CLASS_MAPPING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AttributeMapping> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EObjectContainmentEList<AttributeMapping>(AttributeMapping.class, this,
          MappingPackage.CLASS_MAPPING__ATTRIBUTES);
    }
    return attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getClassName()
  {
    return className;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassName(String newClassName)
  {
    String oldClassName = className;
    className = newClassName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
          MappingPackage.CLASS_MAPPING__CLASS_NAME, oldClassName, className));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTableName()
  {
    return tableName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTableName(String newTableName)
  {
    String oldTableName = tableName;
    tableName = newTableName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
          MappingPackage.CLASS_MAPPING__TABLE_NAME, oldTableName, tableName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public AttributeMapping getAttributeMapping(String name)
  {
    for (Iterator iter = getAttributes().iterator(); iter.hasNext();)
    {
      AttributeMapping attributeMapping = (AttributeMapping) iter.next();
      if (attributeMapping.getAttributeName().equals(name))
      {
        return attributeMapping;
      }
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public String getColumnNames()
  {
    if (cachedColumnNames == null)
    {
      StringBuffer buffer = new StringBuffer();
      boolean first = true;

      for (Iterator iter = getAttributes().iterator(); iter.hasNext();)
      {
        if (first)
        {
          first = false;
        }
        else
        {
          buffer.append(", ");
        }

        AttributeMapping attributeMapping = (AttributeMapping) iter.next();
        buffer.append(attributeMapping.getColumnName());
      }
      cachedColumnNames = buffer.toString();
    }
    return cachedColumnNames;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs)
  {
    switch (featureID)
    {
      case MappingPackage.CLASS_MAPPING__ATTRIBUTES:
        return ((InternalEList<?>) getAttributes()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MappingPackage.CLASS_MAPPING__ATTRIBUTES:
        return getAttributes();
      case MappingPackage.CLASS_MAPPING__CLASS_NAME:
        return getClassName();
      case MappingPackage.CLASS_MAPPING__TABLE_NAME:
        return getTableName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MappingPackage.CLASS_MAPPING__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends AttributeMapping>) newValue);
        return;
      case MappingPackage.CLASS_MAPPING__CLASS_NAME:
        setClassName((String) newValue);
        return;
      case MappingPackage.CLASS_MAPPING__TABLE_NAME:
        setTableName((String) newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MappingPackage.CLASS_MAPPING__ATTRIBUTES:
        getAttributes().clear();
        return;
      case MappingPackage.CLASS_MAPPING__CLASS_NAME:
        setClassName(CLASS_NAME_EDEFAULT);
        return;
      case MappingPackage.CLASS_MAPPING__TABLE_NAME:
        setTableName(TABLE_NAME_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MappingPackage.CLASS_MAPPING__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
      case MappingPackage.CLASS_MAPPING__CLASS_NAME:
        return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT
            .equals(className);
      case MappingPackage.CLASS_MAPPING__TABLE_NAME:
        return TABLE_NAME_EDEFAULT == null ? tableName != null : !TABLE_NAME_EDEFAULT
            .equals(tableName);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (className: ");
    result.append(className);
    result.append(", tableName: ");
    result.append(tableName);
    result.append(')');
    return result.toString();
  }

  /**
   * @ADDED
   */
  private String cachedColumnNames;
} //ClassMappingImpl
