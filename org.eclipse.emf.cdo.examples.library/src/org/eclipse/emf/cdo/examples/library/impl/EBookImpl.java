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
package org.eclipse.emf.cdo.example.library.impl;


import org.eclipse.emf.cdo.example.library.EBook;
import org.eclipse.emf.cdo.example.library.Library;
import org.eclipse.emf.cdo.example.library.LibraryPackage;
import org.eclipse.emf.cdo.example.library.Topic;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;

import java.util.Collection;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EBook</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.cdo.example.library.impl.EBookImpl#getUrl <em>Url</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EBookImpl extends BookImpl implements EBook
{
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
   * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUrl()
   * @generated
   * @ordered
   */
  protected String url = URL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EBookImpl()
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
    return LibraryPackage.eINSTANCE.getEBook();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUrl()
  {
    cdoLoad();
    return url;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUrl(String newUrl)
  {
    cdoLoad();
    String oldUrl = url;
    url = newUrl;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.EBOOK__URL, oldUrl, url));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass,
      NotificationChain msgs)
  {
    if (featureID >= 0)
    {
      switch (eDerivedStructuralFeatureID(featureID, baseClass))
      {
        case LibraryPackage.EBOOK__AUTHORS:
          return ((InternalEList) getAuthors()).basicAdd(otherEnd, msgs);
        case LibraryPackage.EBOOK__LIBRARY:
          if (eContainer != null) msgs = eBasicRemoveFromContainer(msgs);
          return eBasicSetContainer(otherEnd, LibraryPackage.EBOOK__LIBRARY, msgs);
        case LibraryPackage.EBOOK__TOPIC:
          if (eContainer != null) msgs = eBasicRemoveFromContainer(msgs);
          return eBasicSetContainer(otherEnd, LibraryPackage.EBOOK__TOPIC, msgs);
        default:
          return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
      }
    }
    if (eContainer != null) msgs = eBasicRemoveFromContainer(msgs);
    return eBasicSetContainer(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass,
      NotificationChain msgs)
  {
    if (featureID >= 0)
    {
      switch (eDerivedStructuralFeatureID(featureID, baseClass))
      {
        case LibraryPackage.EBOOK__AUTHORS:
          return ((InternalEList) getAuthors()).basicRemove(otherEnd, msgs);
        case LibraryPackage.EBOOK__LIBRARY:
          return eBasicSetContainer(null, LibraryPackage.EBOOK__LIBRARY, msgs);
        case LibraryPackage.EBOOK__TOPIC:
          return eBasicSetContainer(null, LibraryPackage.EBOOK__TOPIC, msgs);
        default:
          return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
      }
    }
    return eBasicSetContainer(null, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs)
  {
    if (eContainerFeatureID >= 0)
    {
      switch (eContainerFeatureID)
      {
        case LibraryPackage.EBOOK__LIBRARY:
          return ((InternalEObject) eContainer).eInverseRemove(this, LibraryPackage.LIBRARY__BOOKS,
              Library.class, msgs);
        case LibraryPackage.EBOOK__TOPIC:
          return ((InternalEObject) eContainer).eInverseRemove(this, LibraryPackage.TOPIC__BOOKS,
              Topic.class, msgs);
        default:
          return eDynamicBasicRemoveFromContainer(msgs);
      }
    }
    return ((InternalEObject) eContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
        - eContainerFeatureID, null, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object eGet(EStructuralFeature eFeature, boolean resolve)
  {
    switch (eDerivedStructuralFeatureID(eFeature))
    {
      case LibraryPackage.EBOOK__TITLE:
        return getTitle();
      case LibraryPackage.EBOOK__AUTHORS:
        return getAuthors();
      case LibraryPackage.EBOOK__LIBRARY:
        return getLibrary();
      case LibraryPackage.EBOOK__TOPIC:
        return getTopic();
      case LibraryPackage.EBOOK__NUMBER_OF_PAGES:
        return new Integer(getNumberOfPages());
      case LibraryPackage.EBOOK__URL:
        return getUrl();
    }
    return eDynamicGet(eFeature, resolve);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eSet(EStructuralFeature eFeature, Object newValue)
  {
    switch (eDerivedStructuralFeatureID(eFeature))
    {
      case LibraryPackage.EBOOK__TITLE:
        setTitle((String) newValue);
        return;
      case LibraryPackage.EBOOK__AUTHORS:
        getAuthors().clear();
        getAuthors().addAll((Collection) newValue);
        return;
      case LibraryPackage.EBOOK__LIBRARY:
        setLibrary((Library) newValue);
        return;
      case LibraryPackage.EBOOK__TOPIC:
        setTopic((Topic) newValue);
        return;
      case LibraryPackage.EBOOK__NUMBER_OF_PAGES:
        setNumberOfPages(((Integer) newValue).intValue());
        return;
      case LibraryPackage.EBOOK__URL:
        setUrl((String) newValue);
        return;
    }
    eDynamicSet(eFeature, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eUnset(EStructuralFeature eFeature)
  {
    switch (eDerivedStructuralFeatureID(eFeature))
    {
      case LibraryPackage.EBOOK__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case LibraryPackage.EBOOK__AUTHORS:
        getAuthors().clear();
        return;
      case LibraryPackage.EBOOK__LIBRARY:
        setLibrary((Library) null);
        return;
      case LibraryPackage.EBOOK__TOPIC:
        setTopic((Topic) null);
        return;
      case LibraryPackage.EBOOK__NUMBER_OF_PAGES:
        setNumberOfPages(NUMBER_OF_PAGES_EDEFAULT);
        return;
      case LibraryPackage.EBOOK__URL:
        setUrl(URL_EDEFAULT);
        return;
    }
    eDynamicUnset(eFeature);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean eIsSet(EStructuralFeature eFeature)
  {
    switch (eDerivedStructuralFeatureID(eFeature))
    {
      case LibraryPackage.EBOOK__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case LibraryPackage.EBOOK__AUTHORS:
        return authors != null && !authors.isEmpty();
      case LibraryPackage.EBOOK__LIBRARY:
        return getLibrary() != null;
      case LibraryPackage.EBOOK__TOPIC:
        return getTopic() != null;
      case LibraryPackage.EBOOK__NUMBER_OF_PAGES:
        return numberOfPages != NUMBER_OF_PAGES_EDEFAULT;
      case LibraryPackage.EBOOK__URL:
        return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
    }
    return eDynamicIsSet(eFeature);
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
    result.append(" (url: ");
    result.append(url);
    result.append(')');
    return result.toString();
  }

} //EBookImpl
