/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.examples.library.impl;


import org.eclipse.emf.cdo.client.impl.CDOPersistentImpl;
import org.eclipse.emf.cdo.examples.library.Author;
import org.eclipse.emf.cdo.examples.library.Book;
import org.eclipse.emf.cdo.examples.library.Library;
import org.eclipse.emf.cdo.examples.library.LibraryPackage;
import org.eclipse.emf.cdo.examples.library.Topic;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
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
 *   <li>{@link org.eclipse.emf.cdo.examples.library.impl.LibraryImpl#getBooks <em>Books</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.examples.library.impl.LibraryImpl#getAuthors <em>Authors</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.examples.library.impl.LibraryImpl#getTopics <em>Topics</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LibraryImpl extends CDOPersistentImpl implements Library
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
    return LibraryPackage.Literals.LIBRARY;
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
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
      NotificationChain msgs)
  {
    switch (featureID)
    {
      case LibraryPackage.LIBRARY__BOOKS:
        return ((InternalEList) getBooks()).basicAdd(otherEnd, msgs);
      case LibraryPackage.LIBRARY__AUTHORS:
        return ((InternalEList) getAuthors()).basicAdd(otherEnd, msgs);
      case LibraryPackage.LIBRARY__TOPICS:
        return ((InternalEList) getTopics()).basicAdd(otherEnd, msgs);
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
      case LibraryPackage.LIBRARY__BOOKS:
        return ((InternalEList) getBooks()).basicRemove(otherEnd, msgs);
      case LibraryPackage.LIBRARY__AUTHORS:
        return ((InternalEList) getAuthors()).basicRemove(otherEnd, msgs);
      case LibraryPackage.LIBRARY__TOPICS:
        return ((InternalEList) getTopics()).basicRemove(otherEnd, msgs);
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
      case LibraryPackage.LIBRARY__BOOKS:
        return getBooks();
      case LibraryPackage.LIBRARY__AUTHORS:
        return getAuthors();
      case LibraryPackage.LIBRARY__TOPICS:
        return getTopics();
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
      case LibraryPackage.LIBRARY__BOOKS:
        return books != null && !books.isEmpty();
      case LibraryPackage.LIBRARY__AUTHORS:
        return authors != null && !authors.isEmpty();
      case LibraryPackage.LIBRARY__TOPICS:
        return topics != null && !topics.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //LibraryImpl
