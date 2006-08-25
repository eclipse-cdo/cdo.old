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
import org.eclipse.net4j.examples.prov.ProvPackage;
import org.eclipse.net4j.examples.prov.Site;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;


/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.net4j.examples.prov.impl.FeatureImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.eclipse.net4j.examples.prov.impl.FeatureImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.net4j.examples.prov.impl.FeatureImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.net4j.examples.prov.impl.FeatureImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link org.eclipse.net4j.examples.prov.impl.FeatureImpl#getCategories <em>Categories</em>}</li>
 *   <li>{@link org.eclipse.net4j.examples.prov.impl.FeatureImpl#getSite <em>Site</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureImpl extends EObjectImpl implements Feature
{
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The default value of the '{@link #getVersion() <em>Version</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getVersion()
   * @generated
   * @ordered
   */
  protected static final String VERSION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getVersion()
   * @generated
   * @ordered
   */
  protected String version = VERSION_EDEFAULT;

  /**
   * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUrl()
   * @generated
   * @ordered
   */
  protected static final String URL_EDEFAULT = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected FeatureImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass()
  {
    return ProvPackage.Literals.FEATURE;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Category getCategory()
  {
    if (eContainerFeatureID != ProvPackage.FEATURE__CATEGORY) return null;
    return (Category)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCategory(Category newCategory, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newCategory, ProvPackage.FEATURE__CATEGORY, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setCategory(Category newCategory)
  {
    if (newCategory != eInternalContainer()
            || (eContainerFeatureID != ProvPackage.FEATURE__CATEGORY && newCategory != null))
    {
      if (EcoreUtil.isAncestor(this, newCategory))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null) msgs = eBasicRemoveFromContainer(msgs);
      if (newCategory != null)
        msgs = ((InternalEObject)newCategory).eInverseAdd(this, ProvPackage.CATEGORY__FEATURES,
                Category.class, msgs);
      msgs = basicSetCategory(newCategory, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProvPackage.FEATURE__CATEGORY,
              newCategory, newCategory));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setId(String newId)
  {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProvPackage.FEATURE__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getVersion()
  {
    return version;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setVersion(String newVersion)
  {
    String oldVersion = version;
    version = newVersion;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProvPackage.FEATURE__VERSION,
              oldVersion, version));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public String getUrl()
  {
    if (getId() == null) return null;
    return getId() + (getVersion() == null ? "" : "_" + getVersion()) + ".jar";
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Site getSite()
  {
    if (eContainerFeatureID != ProvPackage.FEATURE__SITE) return null;
    return (Site)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSite(Site newSite, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newSite, ProvPackage.FEATURE__SITE, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setSite(Site newSite)
  {
    if (newSite != eInternalContainer()
            || (eContainerFeatureID != ProvPackage.FEATURE__SITE && newSite != null))
    {
      if (EcoreUtil.isAncestor(this, newSite))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null) msgs = eBasicRemoveFromContainer(msgs);
      if (newSite != null)
        msgs = ((InternalEObject)newSite).eInverseAdd(this, ProvPackage.SITE__FEATURES, Site.class,
                msgs);
      msgs = basicSetSite(newSite, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProvPackage.FEATURE__SITE, newSite,
              newSite));
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
    case ProvPackage.FEATURE__CATEGORY:
      if (eInternalContainer() != null) msgs = eBasicRemoveFromContainer(msgs);
      return basicSetCategory((Category)otherEnd, msgs);
    case ProvPackage.FEATURE__SITE:
      if (eInternalContainer() != null) msgs = eBasicRemoveFromContainer(msgs);
      return basicSetSite((Site)otherEnd, msgs);
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
    case ProvPackage.FEATURE__CATEGORY:
      return basicSetCategory(null, msgs);
    case ProvPackage.FEATURE__SITE:
      return basicSetSite(null, msgs);
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
    case ProvPackage.FEATURE__CATEGORY:
      return eInternalContainer().eInverseRemove(this, ProvPackage.CATEGORY__FEATURES,
              Category.class, msgs);
    case ProvPackage.FEATURE__SITE:
      return eInternalContainer()
              .eInverseRemove(this, ProvPackage.SITE__FEATURES, Site.class, msgs);
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
    case ProvPackage.FEATURE__CATEGORY:
      return getCategory();
    case ProvPackage.FEATURE__ID:
      return getId();
    case ProvPackage.FEATURE__VERSION:
      return getVersion();
    case ProvPackage.FEATURE__URL:
      return getUrl();
    case ProvPackage.FEATURE__CATEGORIES:
      return getCategories();
    case ProvPackage.FEATURE__SITE:
      return getSite();
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
    case ProvPackage.FEATURE__CATEGORY:
      setCategory((Category)newValue);
      return;
    case ProvPackage.FEATURE__ID:
      setId((String)newValue);
      return;
    case ProvPackage.FEATURE__VERSION:
      setVersion((String)newValue);
      return;
    case ProvPackage.FEATURE__SITE:
      setSite((Site)newValue);
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
    case ProvPackage.FEATURE__CATEGORY:
      setCategory((Category)null);
      return;
    case ProvPackage.FEATURE__ID:
      setId(ID_EDEFAULT);
      return;
    case ProvPackage.FEATURE__VERSION:
      setVersion(VERSION_EDEFAULT);
      return;
    case ProvPackage.FEATURE__SITE:
      setSite((Site)null);
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
    case ProvPackage.FEATURE__CATEGORY:
      return getCategory() != null;
    case ProvPackage.FEATURE__ID:
      return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
    case ProvPackage.FEATURE__VERSION:
      return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
    case ProvPackage.FEATURE__URL:
      return URL_EDEFAULT == null ? getUrl() != null : !URL_EDEFAULT.equals(getUrl());
    case ProvPackage.FEATURE__CATEGORIES:
      return !getCategories().isEmpty();
    case ProvPackage.FEATURE__SITE:
      return getSite() != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public EList getCategories()
  {
    Site site = getSite();

    if (site == null && getCategory() != null)
    {
      site = getCategory().getSite();
    }

    if (site == null)
    {
      return new BasicEList.UnmodifiableEList(0, new Object[0]);
    }

    return site.getCategories(getId(), getVersion());
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (id: ");
    result.append(id);
    result.append(", version: ");
    result.append(version);
    result.append(')');
    return result.toString();
  }

} // FeatureImpl
