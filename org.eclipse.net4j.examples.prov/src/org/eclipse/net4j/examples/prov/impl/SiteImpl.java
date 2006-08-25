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
package org.eclipse.net4j.examples.prov.impl;


import org.eclipse.net4j.examples.prov.Category;
import org.eclipse.net4j.examples.prov.Feature;
import org.eclipse.net4j.examples.prov.ProvFactory;
import org.eclipse.net4j.examples.prov.ProvPackage;
import org.eclipse.net4j.examples.prov.Site;
import org.eclipse.net4j.util.StringHelper;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Site</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.net4j.examples.prov.impl.SiteImpl#getCategories <em>Categories</em>}</li>
 *   <li>{@link org.eclipse.net4j.examples.prov.impl.SiteImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.net4j.examples.prov.impl.SiteImpl#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SiteImpl extends EObjectImpl implements Site
{
  /**
   * The cached value of the '{@link #getCategories() <em>Categories</em>}' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getCategories()
   * @generated
   * @ordered
   */
  protected EList categories = null;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
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
   * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getFeatures()
   * @generated
   * @ordered
   */
  protected EList features = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected SiteImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass()
  {
    return ProvPackage.Literals.SITE;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList getCategories()
  {
    if (categories == null)
    {
      categories = new EObjectContainmentWithInverseEList(Category.class, this,
              ProvPackage.SITE__CATEGORIES, ProvPackage.CATEGORY__SITE);
    }
    return categories;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProvPackage.SITE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList getFeatures()
  {
    if (features == null)
    {
      features = new EObjectContainmentWithInverseEList(Feature.class, this,
              ProvPackage.SITE__FEATURES, ProvPackage.FEATURE__SITE);
    }
    return features;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Category getCategory(String name)
  {
    for (Iterator it = getCategories().iterator(); it.hasNext();)
    {
      Category category = (Category)it.next();
      if (StringHelper.equals(category.getName(), name))
      {
        return category;
      }
    }

    return null;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Feature addFeature(String id, String version)
  {
    Feature feature = getFeature(id, version);

    if (feature != null)
    {
      return null;
    }

    feature = ProvFactory.eINSTANCE.createFeature();
    feature.setId(id);
    feature.setVersion(version);

    getFeatures().add(feature);
    return feature;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Category addCategory(String name)
  {
    Category category = getCategory(name);

    if (category != null)
    {
      return null;
    }

    category = ProvFactory.eINSTANCE.createCategory();
    category.setName(name);

    getCategories().add(category);
    return category;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Feature getFeature(String id, String version)
  {
    for (Iterator it = getFeatures().iterator(); it.hasNext();)
    {
      Feature feature = (Feature)it.next();
      if (StringHelper.equals(feature.getId(), id)
              && (version == null || version.equals(feature.getVersion())))
      {
        return feature;
      }
    }

    return null;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public EList getCategories(String featureId, String featureVersion)
  {
    List list = new ArrayList();
    for (Iterator it = getCategories().iterator(); it.hasNext();)
    {
      Category category = (Category)it.next();

      if (category.getFeature(featureId, featureVersion) != null)
      {
        list.add(category);
      }
    }

    return new BasicEList.UnmodifiableEList(list.size(), list.toArray());
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Category removeCategory(int index)
  {
    return (Category)getCategories().remove(index);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Feature removeFeature(int index)
  {
    Feature feature = (Feature)getFeatures().remove(index);

    EList categories = feature.getCategories();
    for (Iterator it = categories.iterator(); it.hasNext();)
    {
      Category category = (Category)it.next();
      category.removeFeature(feature.getId(), feature.getVersion());
    }

    return feature;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Feature removeFeature(String id, String version)
  {
    for (Iterator it = getFeatures().listIterator(); it.hasNext();)
    {
      Feature feature = (Feature)it.next();
      if (StringHelper.equals(feature.getId(), id)
              && (version == null || version.equals(feature.getVersion())))
      {
        it.remove();
        return feature;
      }
    }

    return null;
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
    case ProvPackage.SITE__CATEGORIES:
      return ((InternalEList)getCategories()).basicAdd(otherEnd, msgs);
    case ProvPackage.SITE__FEATURES:
      return ((InternalEList)getFeatures()).basicAdd(otherEnd, msgs);
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
    case ProvPackage.SITE__CATEGORIES:
      return ((InternalEList)getCategories()).basicRemove(otherEnd, msgs);
    case ProvPackage.SITE__FEATURES:
      return ((InternalEList)getFeatures()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
    case ProvPackage.SITE__CATEGORIES:
      return getCategories();
    case ProvPackage.SITE__NAME:
      return getName();
    case ProvPackage.SITE__FEATURES:
      return getFeatures();
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
    case ProvPackage.SITE__CATEGORIES:
      getCategories().clear();
      getCategories().addAll((Collection)newValue);
      return;
    case ProvPackage.SITE__NAME:
      setName((String)newValue);
      return;
    case ProvPackage.SITE__FEATURES:
      getFeatures().clear();
      getFeatures().addAll((Collection)newValue);
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
    case ProvPackage.SITE__CATEGORIES:
      getCategories().clear();
      return;
    case ProvPackage.SITE__NAME:
      setName(NAME_EDEFAULT);
      return;
    case ProvPackage.SITE__FEATURES:
      getFeatures().clear();
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
    case ProvPackage.SITE__CATEGORIES:
      return categories != null && !categories.isEmpty();
    case ProvPackage.SITE__NAME:
      return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
    case ProvPackage.SITE__FEATURES:
      return features != null && !features.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Category removeCategory(String name)
  {
    for (Iterator it = getCategories().listIterator(); it.hasNext();)
    {
      Category category = (Category)it.next();
      if (StringHelper.equals(category.getName(), name))
      {
        it.remove();
        return category;
      }
    }

    return null;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
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

} // SiteImpl
