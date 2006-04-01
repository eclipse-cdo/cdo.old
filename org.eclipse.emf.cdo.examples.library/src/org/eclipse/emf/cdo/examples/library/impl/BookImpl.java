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


import org.eclipse.emf.cdo.client.impl.CdoPersistentImpl;
import org.eclipse.emf.cdo.example.library.Author;
import org.eclipse.emf.cdo.example.library.Book;
import org.eclipse.emf.cdo.example.library.Library;
import org.eclipse.emf.cdo.example.library.LibraryPackage;
import org.eclipse.emf.cdo.example.library.Topic;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import java.util.Collection;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.cdo.example.library.impl.BookImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.example.library.impl.BookImpl#getAuthors <em>Authors</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.example.library.impl.BookImpl#getLibrary <em>Library</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.example.library.impl.BookImpl#getTopic <em>Topic</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.example.library.impl.BookImpl#getNumberOfPages <em>Number Of Pages</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BookImpl extends CdoPersistentImpl implements Book
{
  /**
   * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTitle()
   * @generated
   * @ordered
   */
  protected static final String TITLE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTitle()
   * @generated
   * @ordered
   */
  protected String title = TITLE_EDEFAULT;

  /**
   * The cached value of the '{@link #getAuthors() <em>Authors</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAuthors()
   * @generated
   * @ordered
   */
  protected EList authors = null;

  /**
   * The default value of the '{@link #getNumberOfPages() <em>Number Of Pages</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumberOfPages()
   * @generated
   * @ordered
   */
  protected static final int NUMBER_OF_PAGES_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getNumberOfPages() <em>Number Of Pages</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumberOfPages()
   * @generated
   * @ordered
   */
  protected int numberOfPages = NUMBER_OF_PAGES_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BookImpl()
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
    return LibraryPackage.eINSTANCE.getBook();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTitle()
  {
    cdoLoad();
    return title;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTitle(String newTitle)
  {
    cdoLoad();
    String oldTitle = title;
    title = newTitle;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.BOOK__TITLE, oldTitle,
          title));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getAuthors()
  {
    cdoLoad();
    if (authors == null)
    {
      authors = new EObjectWithInverseResolvingEList.ManyInverse(Author.class, this,
          LibraryPackage.BOOK__AUTHORS, LibraryPackage.AUTHOR__BOOKS);
    }
    return authors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Library getLibrary()
  {
    cdoLoad();
    if (eContainerFeatureID != LibraryPackage.BOOK__LIBRARY) return null;
    return (Library) eContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLibrary(Library newLibrary)
  {
    cdoLoad();
    if (newLibrary != eContainer
        || (eContainerFeatureID != LibraryPackage.BOOK__LIBRARY && newLibrary != null))
    {
      if (EcoreUtil.isAncestor(this, newLibrary))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eContainer != null) msgs = eBasicRemoveFromContainer(msgs);
      if (newLibrary != null)
        msgs = ((InternalEObject) newLibrary).eInverseAdd(this, LibraryPackage.LIBRARY__BOOKS,
            Library.class, msgs);
      msgs = eBasicSetContainer((InternalEObject) newLibrary, LibraryPackage.BOOK__LIBRARY, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.BOOK__LIBRARY,
          newLibrary, newLibrary));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Topic getTopic()
  {
    cdoLoad();
    if (eContainerFeatureID != LibraryPackage.BOOK__TOPIC) return null;
    return (Topic) eContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTopic(Topic newTopic)
  {
    cdoLoad();
    if (newTopic != eContainer
        || (eContainerFeatureID != LibraryPackage.BOOK__TOPIC && newTopic != null))
    {
      if (EcoreUtil.isAncestor(this, newTopic))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eContainer != null) msgs = eBasicRemoveFromContainer(msgs);
      if (newTopic != null)
        msgs = ((InternalEObject) newTopic).eInverseAdd(this, LibraryPackage.TOPIC__BOOKS,
            Topic.class, msgs);
      msgs = eBasicSetContainer((InternalEObject) newTopic, LibraryPackage.BOOK__TOPIC, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.BOOK__TOPIC, newTopic,
          newTopic));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getNumberOfPages()
  {
    cdoLoad();
    return numberOfPages;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNumberOfPages(int newNumberOfPages)
  {
    cdoLoad();
    int oldNumberOfPages = numberOfPages;
    numberOfPages = newNumberOfPages;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.BOOK__NUMBER_OF_PAGES,
          oldNumberOfPages, numberOfPages));
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
        case LibraryPackage.BOOK__AUTHORS:
          return ((InternalEList) getAuthors()).basicAdd(otherEnd, msgs);
        case LibraryPackage.BOOK__LIBRARY:
          if (eContainer != null) msgs = eBasicRemoveFromContainer(msgs);
          return eBasicSetContainer(otherEnd, LibraryPackage.BOOK__LIBRARY, msgs);
        case LibraryPackage.BOOK__TOPIC:
          if (eContainer != null) msgs = eBasicRemoveFromContainer(msgs);
          return eBasicSetContainer(otherEnd, LibraryPackage.BOOK__TOPIC, msgs);
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
        case LibraryPackage.BOOK__AUTHORS:
          return ((InternalEList) getAuthors()).basicRemove(otherEnd, msgs);
        case LibraryPackage.BOOK__LIBRARY:
          return eBasicSetContainer(null, LibraryPackage.BOOK__LIBRARY, msgs);
        case LibraryPackage.BOOK__TOPIC:
          return eBasicSetContainer(null, LibraryPackage.BOOK__TOPIC, msgs);
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
        case LibraryPackage.BOOK__LIBRARY:
          return ((InternalEObject) eContainer).eInverseRemove(this, LibraryPackage.LIBRARY__BOOKS,
              Library.class, msgs);
        case LibraryPackage.BOOK__TOPIC:
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
      case LibraryPackage.BOOK__TITLE:
        return getTitle();
      case LibraryPackage.BOOK__AUTHORS:
        return getAuthors();
      case LibraryPackage.BOOK__LIBRARY:
        return getLibrary();
      case LibraryPackage.BOOK__TOPIC:
        return getTopic();
      case LibraryPackage.BOOK__NUMBER_OF_PAGES:
        return new Integer(getNumberOfPages());
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
      case LibraryPackage.BOOK__TITLE:
        setTitle((String) newValue);
        return;
      case LibraryPackage.BOOK__AUTHORS:
        getAuthors().clear();
        getAuthors().addAll((Collection) newValue);
        return;
      case LibraryPackage.BOOK__LIBRARY:
        setLibrary((Library) newValue);
        return;
      case LibraryPackage.BOOK__TOPIC:
        setTopic((Topic) newValue);
        return;
      case LibraryPackage.BOOK__NUMBER_OF_PAGES:
        setNumberOfPages(((Integer) newValue).intValue());
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
      case LibraryPackage.BOOK__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case LibraryPackage.BOOK__AUTHORS:
        getAuthors().clear();
        return;
      case LibraryPackage.BOOK__LIBRARY:
        setLibrary((Library) null);
        return;
      case LibraryPackage.BOOK__TOPIC:
        setTopic((Topic) null);
        return;
      case LibraryPackage.BOOK__NUMBER_OF_PAGES:
        setNumberOfPages(NUMBER_OF_PAGES_EDEFAULT);
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
      case LibraryPackage.BOOK__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case LibraryPackage.BOOK__AUTHORS:
        return authors != null && !authors.isEmpty();
      case LibraryPackage.BOOK__LIBRARY:
        return getLibrary() != null;
      case LibraryPackage.BOOK__TOPIC:
        return getTopic() != null;
      case LibraryPackage.BOOK__NUMBER_OF_PAGES:
        return numberOfPages != NUMBER_OF_PAGES_EDEFAULT;
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
    result.append(" (title: ");
    result.append(title);
    result.append(", numberOfPages: ");
    result.append(numberOfPages);
    result.append(')');
    return result.toString();
  }

} //BookImpl
