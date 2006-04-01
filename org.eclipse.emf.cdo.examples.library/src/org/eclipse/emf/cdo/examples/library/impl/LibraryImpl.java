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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import java.util.Collection;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.cdo.example.library.impl.LibraryImpl#getBooks <em>Books</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.example.library.impl.LibraryImpl#getAuthors <em>Authors</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.example.library.impl.LibraryImpl#getTopics <em>Topics</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LibraryImpl extends CdoPersistentImpl implements Library
{
  /**
   * The cached value of the '{@link #getBooks() <em>Books</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBooks()
   * @generated
   * @ordered
   */
  protected EList books = null;

  /**
   * The cached value of the '{@link #getAuthors() <em>Authors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAuthors()
   * @generated
   * @ordered
   */
  protected EList authors = null;

  /**
   * The cached value of the '{@link #getTopics() <em>Topics</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTopics()
   * @generated
   * @ordered
   */
  protected EList topics = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LibraryImpl()
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
    return LibraryPackage.eINSTANCE.getLibrary();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getBooks()
  {
    cdoLoad();
    if (books == null)
    {
      books = new EObjectContainmentWithInverseEList(Book.class, this,
          LibraryPackage.LIBRARY__BOOKS, LibraryPackage.BOOK__LIBRARY);
    }
    return books;
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
      authors = new EObjectContainmentWithInverseEList(Author.class, this,
          LibraryPackage.LIBRARY__AUTHORS, LibraryPackage.AUTHOR__LIBRARY);
    }
    return authors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getTopics()
  {
    cdoLoad();
    if (topics == null)
    {
      topics = new EObjectContainmentWithInverseEList(Topic.class, this,
          LibraryPackage.LIBRARY__TOPICS, LibraryPackage.TOPIC__LIBRARY);
    }
    return topics;
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
        case LibraryPackage.LIBRARY__BOOKS:
          return ((InternalEList) getBooks()).basicAdd(otherEnd, msgs);
        case LibraryPackage.LIBRARY__AUTHORS:
          return ((InternalEList) getAuthors()).basicAdd(otherEnd, msgs);
        case LibraryPackage.LIBRARY__TOPICS:
          return ((InternalEList) getTopics()).basicAdd(otherEnd, msgs);
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
        case LibraryPackage.LIBRARY__BOOKS:
          return ((InternalEList) getBooks()).basicRemove(otherEnd, msgs);
        case LibraryPackage.LIBRARY__AUTHORS:
          return ((InternalEList) getAuthors()).basicRemove(otherEnd, msgs);
        case LibraryPackage.LIBRARY__TOPICS:
          return ((InternalEList) getTopics()).basicRemove(otherEnd, msgs);
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
  public Object eGet(EStructuralFeature eFeature, boolean resolve)
  {
    switch (eDerivedStructuralFeatureID(eFeature))
    {
      case LibraryPackage.LIBRARY__BOOKS:
        return getBooks();
      case LibraryPackage.LIBRARY__AUTHORS:
        return getAuthors();
      case LibraryPackage.LIBRARY__TOPICS:
        return getTopics();
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
      case LibraryPackage.LIBRARY__BOOKS:
        getBooks().clear();
        getBooks().addAll((Collection) newValue);
        return;
      case LibraryPackage.LIBRARY__AUTHORS:
        getAuthors().clear();
        getAuthors().addAll((Collection) newValue);
        return;
      case LibraryPackage.LIBRARY__TOPICS:
        getTopics().clear();
        getTopics().addAll((Collection) newValue);
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
      case LibraryPackage.LIBRARY__BOOKS:
        getBooks().clear();
        return;
      case LibraryPackage.LIBRARY__AUTHORS:
        getAuthors().clear();
        return;
      case LibraryPackage.LIBRARY__TOPICS:
        getTopics().clear();
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
      case LibraryPackage.LIBRARY__BOOKS:
        return books != null && !books.isEmpty();
      case LibraryPackage.LIBRARY__AUTHORS:
        return authors != null && !authors.isEmpty();
      case LibraryPackage.LIBRARY__TOPICS:
        return topics != null && !topics.isEmpty();
    }
    return eDynamicIsSet(eFeature);
  }

} //LibraryImpl
