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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import java.util.Collection;
import java.util.Iterator;


/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Category</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.net4j.examples.prov.impl.CategoryImpl#getSite <em>Site</em>}</li>
 *   <li>{@link org.eclipse.net4j.examples.prov.impl.CategoryImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.eclipse.net4j.examples.prov.impl.CategoryImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.net4j.examples.prov.impl.CategoryImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.net4j.examples.prov.impl.CategoryImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CategoryImpl extends EObjectImpl implements Category
{
  /**
   * The cached value of the '{@link #getFeatures() <em>Features</em>}' reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getFeatures()
   * @generated
   * @ordered
   */
  protected EList features = null;

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
   * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @see #getLabel()
   * @generated
   * @ordered
   */
  protected static final String LABEL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @see #getLabel()
   * @generated
   * @ordered
   */
  protected String label = LABEL_EDEFAULT;

  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected CategoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass()
  {
    return ProvPackage.Literals.CATEGORY;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Site getSite()
  {
    if (eContainerFeatureID != ProvPackage.CATEGORY__SITE) return null;
    return (Site)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSite(Site newSite, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newSite, ProvPackage.CATEGORY__SITE, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setSite(Site newSite)
  {
    if (newSite != eInternalContainer()
            || (eContainerFeatureID != ProvPackage.CATEGORY__SITE && newSite != null))
    {
      if (EcoreUtil.isAncestor(this, newSite))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null) msgs = eBasicRemoveFromContainer(msgs);
      if (newSite != null)
        msgs = ((InternalEObject)newSite).eInverseAdd(this, ProvPackage.SITE__CATEGORIES,
                Site.class, msgs);
      msgs = basicSetSite(newSite, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProvPackage.CATEGORY__SITE, newSite,
              newSite));
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
              ProvPackage.CATEGORY__FEATURES, ProvPackage.FEATURE__CATEGORY);
    }
    return features;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ProvPackage.CATEGORY__NAME, oldName,
              name));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getLabel()
  {
    return label;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setLabel(String newLabel)
  {
    String oldLabel = label;
    label = newLabel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProvPackage.CATEGORY__LABEL, oldLabel,
              label));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(String newDescription)
  {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProvPackage.CATEGORY__DESCRIPTION,
              oldDescription, description));
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
    getSite().addFeature(id, version);
    return feature;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Feature removeFeature(int index)
  {
    return (Feature)getFeatures().remove(index);
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
    case ProvPackage.CATEGORY__SITE:
      if (eInternalContainer() != null) msgs = eBasicRemoveFromContainer(msgs);
      return basicSetSite((Site)otherEnd, msgs);
    case ProvPackage.CATEGORY__FEATURES:
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
    case ProvPackage.CATEGORY__SITE:
      return basicSetSite(null, msgs);
    case ProvPackage.CATEGORY__FEATURES:
      return ((InternalEList)getFeatures()).basicRemove(otherEnd, msgs);
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
    case ProvPackage.CATEGORY__SITE:
      return eInternalContainer().eInverseRemove(this, ProvPackage.SITE__CATEGORIES, Site.class,
              msgs);
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
    case ProvPackage.CATEGORY__SITE:
      return getSite();
    case ProvPackage.CATEGORY__FEATURES:
      return getFeatures();
    case ProvPackage.CATEGORY__NAME:
      return getName();
    case ProvPackage.CATEGORY__LABEL:
      return getLabel();
    case ProvPackage.CATEGORY__DESCRIPTION:
      return getDescription();
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
    case ProvPackage.CATEGORY__SITE:
      setSite((Site)newValue);
      return;
    case ProvPackage.CATEGORY__FEATURES:
      getFeatures().clear();
      getFeatures().addAll((Collection)newValue);
      return;
    case ProvPackage.CATEGORY__NAME:
      setName((String)newValue);
      return;
    case ProvPackage.CATEGORY__LABEL:
      setLabel((String)newValue);
      return;
    case ProvPackage.CATEGORY__DESCRIPTION:
      setDescription((String)newValue);
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
    case ProvPackage.CATEGORY__SITE:
      setSite((Site)null);
      return;
    case ProvPackage.CATEGORY__FEATURES:
      getFeatures().clear();
      return;
    case ProvPackage.CATEGORY__NAME:
      setName(NAME_EDEFAULT);
      return;
    case ProvPackage.CATEGORY__LABEL:
      setLabel(LABEL_EDEFAULT);
      return;
    case ProvPackage.CATEGORY__DESCRIPTION:
      setDescription(DESCRIPTION_EDEFAULT);
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
    case ProvPackage.CATEGORY__SITE:
      return getSite() != null;
    case ProvPackage.CATEGORY__FEATURES:
      return features != null && !features.isEmpty();
    case ProvPackage.CATEGORY__NAME:
      return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
    case ProvPackage.CATEGORY__LABEL:
      return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
    case ProvPackage.CATEGORY__DESCRIPTION:
      return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT
              .equals(description);
    }
    return super.eIsSet(featureID);
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
    result.append(", label: ");
    result.append(label);
    result.append(", description: ");
    result.append(description);
    result.append(')');
    return result.toString();
  }

} // CategoryImpl
