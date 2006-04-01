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
 * An implementation of the model object '<em><b>Author</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.cdo.example.library.impl.AuthorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.example.library.impl.AuthorImpl#getBooks <em>Books</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.example.library.impl.AuthorImpl#getLibrary <em>Library</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AuthorImpl extends CdoPersistentImpl implements Author
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
   * The cached value of the '{@link #getBooks() <em>Books</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBooks()
   * @generated
   * @ordered
   */
  protected EList books = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AuthorImpl()
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
    return LibraryPackage.eINSTANCE.getAuthor();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    cdoLoad();
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    cdoLoad();
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.AUTHOR__NAME, oldName,
          name));
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
      books = new EObjectWithInverseResolvingEList.ManyInverse(Book.class, this,
          LibraryPackage.AUTHOR__BOOKS, LibraryPackage.BOOK__AUTHORS);
    }
    return books;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Library getLibrary()
  {
    cdoLoad();
    if (eContainerFeatureID != LibraryPackage.AUTHOR__LIBRARY) return null;
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
        || (eContainerFeatureID != LibraryPackage.AUTHOR__LIBRARY && newLibrary != null))
    {
      if (EcoreUtil.isAncestor(this, newLibrary))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eContainer != null) msgs = eBasicRemoveFromContainer(msgs);
      if (newLibrary != null)
        msgs = ((InternalEObject) newLibrary).eInverseAdd(this, LibraryPackage.LIBRARY__AUTHORS,
            Library.class, msgs);
      msgs = eBasicSetContainer((InternalEObject) newLibrary, LibraryPackage.AUTHOR__LIBRARY, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.AUTHOR__LIBRARY,
          newLibrary, newLibrary));
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
        case LibraryPackage.AUTHOR__BOOKS:
          return ((InternalEList) getBooks()).basicAdd(otherEnd, msgs);
        case LibraryPackage.AUTHOR__LIBRARY:
          if (eContainer != null) msgs = eBasicRemoveFromContainer(msgs);
          return eBasicSetContainer(otherEnd, LibraryPackage.AUTHOR__LIBRARY, msgs);
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
        case LibraryPackage.AUTHOR__BOOKS:
          return ((InternalEList) getBooks()).basicRemove(otherEnd, msgs);
        case LibraryPackage.AUTHOR__LIBRARY:
          return eBasicSetContainer(null, LibraryPackage.AUTHOR__LIBRARY, msgs);
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
        case LibraryPackage.AUTHOR__LIBRARY:
          return ((InternalEObject) eContainer).eInverseRemove(this,
              LibraryPackage.LIBRARY__AUTHORS, Library.class, msgs);
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
      case LibraryPackage.AUTHOR__NAME:
        return getName();
      case LibraryPackage.AUTHOR__BOOKS:
        return getBooks();
      case LibraryPackage.AUTHOR__LIBRARY:
        return getLibrary();
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
      case LibraryPackage.AUTHOR__NAME:
        setName((String) newValue);
        return;
      case LibraryPackage.AUTHOR__BOOKS:
        getBooks().clear();
        getBooks().addAll((Collection) newValue);
        return;
      case LibraryPackage.AUTHOR__LIBRARY:
        setLibrary((Library) newValue);
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
      case LibraryPackage.AUTHOR__NAME:
        setName(NAME_EDEFAULT);
        return;
      case LibraryPackage.AUTHOR__BOOKS:
        getBooks().clear();
        return;
      case LibraryPackage.AUTHOR__LIBRARY:
        setLibrary((Library) null);
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
      case LibraryPackage.AUTHOR__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case LibraryPackage.AUTHOR__BOOKS:
        return books != null && !books.isEmpty();
      case LibraryPackage.AUTHOR__LIBRARY:
        return getLibrary() != null;
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //AuthorImpl
