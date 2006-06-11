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
import org.eclipse.emf.cdo.examples.library.Book;
import org.eclipse.emf.cdo.examples.library.Library;
import org.eclipse.emf.cdo.examples.library.LibraryPackage;
import org.eclipse.emf.cdo.examples.library.Topic;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import java.util.Collection;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Topic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.cdo.examples.library.impl.TopicImpl#getBooks <em>Books</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.examples.library.impl.TopicImpl#getLibrary <em>Library</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.examples.library.impl.TopicImpl#getTopics <em>Topics</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.examples.library.impl.TopicImpl#getTopic <em>Topic</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.examples.library.impl.TopicImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TopicImpl extends CDOPersistentImpl implements Topic
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
   * The cached value of the '{@link #getTopics() <em>Topics</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTopics()
   * @generated
   * @ordered
   */
  protected EList topics = null;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TopicImpl()
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
    return LibraryPackage.Literals.TOPIC;
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
      books = new EObjectContainmentWithInverseEList(Book.class, this, LibraryPackage.TOPIC__BOOKS,
          LibraryPackage.BOOK__TOPIC);
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

    if (eContainerFeatureID != LibraryPackage.TOPIC__LIBRARY) return null;
    return (Library) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLibrary(Library newLibrary, NotificationChain msgs)
  {
    cdoLoad();
    msgs = eBasicSetContainer((InternalEObject) newLibrary, LibraryPackage.TOPIC__LIBRARY, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLibrary(Library newLibrary)
  {

    if (newLibrary != eInternalContainer()
        || (eContainerFeatureID != LibraryPackage.TOPIC__LIBRARY && newLibrary != null))
    {
      if (EcoreUtil.isAncestor(this, newLibrary))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null) msgs = eBasicRemoveFromContainer(msgs);
      if (newLibrary != null)
        msgs = ((InternalEObject) newLibrary).eInverseAdd(this, LibraryPackage.LIBRARY__TOPICS,
            Library.class, msgs);
      msgs = basicSetLibrary(newLibrary, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.TOPIC__LIBRARY,
          newLibrary, newLibrary));
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
          LibraryPackage.TOPIC__TOPICS, LibraryPackage.TOPIC__TOPIC);
    }
    return topics;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Topic getTopic()
  {

    if (eContainerFeatureID != LibraryPackage.TOPIC__TOPIC) return null;
    return (Topic) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTopic(Topic newTopic, NotificationChain msgs)
  {
    cdoLoad();
    msgs = eBasicSetContainer((InternalEObject) newTopic, LibraryPackage.TOPIC__TOPIC, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTopic(Topic newTopic)
  {

    if (newTopic != eInternalContainer()
        || (eContainerFeatureID != LibraryPackage.TOPIC__TOPIC && newTopic != null))
    {
      if (EcoreUtil.isAncestor(this, newTopic))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null) msgs = eBasicRemoveFromContainer(msgs);
      if (newTopic != null)
        msgs = ((InternalEObject) newTopic).eInverseAdd(this, LibraryPackage.TOPIC__TOPICS,
            Topic.class, msgs);
      msgs = basicSetTopic(newTopic, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.TOPIC__TOPIC, newTopic,
          newTopic));
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
      eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.TOPIC__NAME, oldName,
          name));
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
      case LibraryPackage.TOPIC__BOOKS:
        return ((InternalEList) getBooks()).basicAdd(otherEnd, msgs);
      case LibraryPackage.TOPIC__LIBRARY:
        if (eInternalContainer() != null) msgs = eBasicRemoveFromContainer(msgs);
        return basicSetLibrary((Library) otherEnd, msgs);
      case LibraryPackage.TOPIC__TOPICS:
        return ((InternalEList) getTopics()).basicAdd(otherEnd, msgs);
      case LibraryPackage.TOPIC__TOPIC:
        if (eInternalContainer() != null) msgs = eBasicRemoveFromContainer(msgs);
        return basicSetTopic((Topic) otherEnd, msgs);
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
      case LibraryPackage.TOPIC__BOOKS:
        return ((InternalEList) getBooks()).basicRemove(otherEnd, msgs);
      case LibraryPackage.TOPIC__LIBRARY:
        return basicSetLibrary(null, msgs);
      case LibraryPackage.TOPIC__TOPICS:
        return ((InternalEList) getTopics()).basicRemove(otherEnd, msgs);
      case LibraryPackage.TOPIC__TOPIC:
        return basicSetTopic(null, msgs);
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
      case LibraryPackage.TOPIC__LIBRARY:
        return eInternalContainer().eInverseRemove(this, LibraryPackage.LIBRARY__TOPICS,
            Library.class, msgs);
      case LibraryPackage.TOPIC__TOPIC:
        return eInternalContainer().eInverseRemove(this, LibraryPackage.TOPIC__TOPICS, Topic.class,
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
      case LibraryPackage.TOPIC__BOOKS:
        return getBooks();
      case LibraryPackage.TOPIC__LIBRARY:
        return getLibrary();
      case LibraryPackage.TOPIC__TOPICS:
        return getTopics();
      case LibraryPackage.TOPIC__TOPIC:
        return getTopic();
      case LibraryPackage.TOPIC__NAME:
        return getName();
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
      case LibraryPackage.TOPIC__BOOKS:
        getBooks().clear();
        getBooks().addAll((Collection) newValue);
        return;
      case LibraryPackage.TOPIC__LIBRARY:
        setLibrary((Library) newValue);
        return;
      case LibraryPackage.TOPIC__TOPICS:
        getTopics().clear();
        getTopics().addAll((Collection) newValue);
        return;
      case LibraryPackage.TOPIC__TOPIC:
        setTopic((Topic) newValue);
        return;
      case LibraryPackage.TOPIC__NAME:
        setName((String) newValue);
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
      case LibraryPackage.TOPIC__BOOKS:
        getBooks().clear();
        return;
      case LibraryPackage.TOPIC__LIBRARY:
        setLibrary((Library) null);
        return;
      case LibraryPackage.TOPIC__TOPICS:
        getTopics().clear();
        return;
      case LibraryPackage.TOPIC__TOPIC:
        setTopic((Topic) null);
        return;
      case LibraryPackage.TOPIC__NAME:
        setName(NAME_EDEFAULT);
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
      case LibraryPackage.TOPIC__BOOKS:
        return books != null && !books.isEmpty();
      case LibraryPackage.TOPIC__LIBRARY:
        return getLibrary() != null;
      case LibraryPackage.TOPIC__TOPICS:
        return topics != null && !topics.isEmpty();
      case LibraryPackage.TOPIC__TOPIC:
        return getTopic() != null;
      case LibraryPackage.TOPIC__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
    }
    return super.eIsSet(featureID);
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

} //TopicImpl
