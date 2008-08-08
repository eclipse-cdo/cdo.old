/**
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *
 * $Id: PopProjectImpl.java,v 1.1 2008-08-08 10:10:30 estepper Exp $
 */
package org.eclipse.net4j.pop.project.impl;

import org.eclipse.net4j.pop.base.impl.PopElementImpl;
import org.eclipse.net4j.pop.project.Checkout;
import org.eclipse.net4j.pop.project.ICheckoutManager;
import org.eclipse.net4j.pop.project.PopProject;
import org.eclipse.net4j.pop.project.ProjectPackage;
import org.eclipse.net4j.pop.project.Repository;
import org.eclipse.net4j.pop.project.RootStream;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Pop Project</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.PopProjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.PopProjectImpl#getRepository <em>Repository</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.PopProjectImpl#getRootStream <em>Root Stream</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.PopProjectImpl#getCheckouts <em>Checkouts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PopProjectImpl extends PopElementImpl implements PopProject
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getRepository() <em>Repository</em>}' containment reference.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @see #getRepository()
   * @generated
   * @ordered
   */
  protected Repository repository;

  /**
   * The cached value of the '{@link #getRootStream() <em>Root Stream</em>}' containment reference.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @see #getRootStream()
   * @generated
   * @ordered
   */
  protected RootStream rootStream;

  /**
   * @ADDED
   */
  private ICheckoutManager checkoutManager;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected PopProjectImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ProjectPackage.Literals.POP_PROJECT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.POP_PROJECT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Repository getRepository()
  {
    if (repository != null && repository.eIsProxy())
    {
      InternalEObject oldRepository = (InternalEObject)repository;
      repository = (Repository)eResolveProxy(oldRepository);
      if (repository != oldRepository)
      {
        InternalEObject newRepository = (InternalEObject)repository;
        NotificationChain msgs = oldRepository.eInverseRemove(this, ProjectPackage.REPOSITORY__POP_PROJECT,
            Repository.class, null);
        if (newRepository.eInternalContainer() == null)
        {
          msgs = newRepository.eInverseAdd(this, ProjectPackage.REPOSITORY__POP_PROJECT, Repository.class, msgs);
        }
        if (msgs != null)
          msgs.dispatch();
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProjectPackage.POP_PROJECT__REPOSITORY,
              oldRepository, repository));
      }
    }
    return repository;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Repository basicGetRepository()
  {
    return repository;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRepository(Repository newRepository, NotificationChain msgs)
  {
    Repository oldRepository = repository;
    repository = newRepository;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
          ProjectPackage.POP_PROJECT__REPOSITORY, oldRepository, newRepository);
      if (msgs == null)
        msgs = notification;
      else
        msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setRepository(Repository newRepository)
  {
    if (newRepository != repository)
    {
      NotificationChain msgs = null;
      if (repository != null)
        msgs = ((InternalEObject)repository).eInverseRemove(this, ProjectPackage.REPOSITORY__POP_PROJECT,
            Repository.class, msgs);
      if (newRepository != null)
        msgs = ((InternalEObject)newRepository).eInverseAdd(this, ProjectPackage.REPOSITORY__POP_PROJECT,
            Repository.class, msgs);
      msgs = basicSetRepository(newRepository, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.POP_PROJECT__REPOSITORY, newRepository,
          newRepository));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public RootStream getRootStream()
  {
    if (rootStream != null && rootStream.eIsProxy())
    {
      InternalEObject oldRootStream = (InternalEObject)rootStream;
      rootStream = (RootStream)eResolveProxy(oldRootStream);
      if (rootStream != oldRootStream)
      {
        InternalEObject newRootStream = (InternalEObject)rootStream;
        NotificationChain msgs = oldRootStream.eInverseRemove(this, ProjectPackage.ROOT_STREAM__POP_PROJECT,
            RootStream.class, null);
        if (newRootStream.eInternalContainer() == null)
        {
          msgs = newRootStream.eInverseAdd(this, ProjectPackage.ROOT_STREAM__POP_PROJECT, RootStream.class, msgs);
        }
        if (msgs != null)
          msgs.dispatch();
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProjectPackage.POP_PROJECT__ROOT_STREAM,
              oldRootStream, rootStream));
      }
    }
    return rootStream;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public RootStream basicGetRootStream()
  {
    return rootStream;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRootStream(RootStream newRootStream, NotificationChain msgs)
  {
    RootStream oldRootStream = rootStream;
    rootStream = newRootStream;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
          ProjectPackage.POP_PROJECT__ROOT_STREAM, oldRootStream, newRootStream);
      if (msgs == null)
        msgs = notification;
      else
        msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setRootStream(RootStream newRootStream)
  {
    if (newRootStream != rootStream)
    {
      NotificationChain msgs = null;
      if (rootStream != null)
        msgs = ((InternalEObject)rootStream).eInverseRemove(this, ProjectPackage.ROOT_STREAM__POP_PROJECT,
            RootStream.class, msgs);
      if (newRootStream != null)
        msgs = ((InternalEObject)newRootStream).eInverseAdd(this, ProjectPackage.ROOT_STREAM__POP_PROJECT,
            RootStream.class, msgs);
      msgs = basicSetRootStream(newRootStream, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.POP_PROJECT__ROOT_STREAM, newRootStream,
          newRootStream));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public EList<Checkout> getCheckouts()
  {
    if (checkoutManager == null)
    {
      return ECollections.emptyEList();
    }

    Checkout[] checkouts = checkoutManager.getCheckouts();
    return new BasicEList.UnmodifiableEList<Checkout>(checkouts.length, checkouts);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
    case ProjectPackage.POP_PROJECT__REPOSITORY:
      if (repository != null)
        msgs = ((InternalEObject)repository).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
            - ProjectPackage.POP_PROJECT__REPOSITORY, null, msgs);
      return basicSetRepository((Repository)otherEnd, msgs);
    case ProjectPackage.POP_PROJECT__ROOT_STREAM:
      if (rootStream != null)
        msgs = ((InternalEObject)rootStream).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
            - ProjectPackage.POP_PROJECT__ROOT_STREAM, null, msgs);
      return basicSetRootStream((RootStream)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
    case ProjectPackage.POP_PROJECT__REPOSITORY:
      return basicSetRepository(null, msgs);
    case ProjectPackage.POP_PROJECT__ROOT_STREAM:
      return basicSetRootStream(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
    case ProjectPackage.POP_PROJECT__NAME:
      return getName();
    case ProjectPackage.POP_PROJECT__REPOSITORY:
      if (resolve)
        return getRepository();
      return basicGetRepository();
    case ProjectPackage.POP_PROJECT__ROOT_STREAM:
      if (resolve)
        return getRootStream();
      return basicGetRootStream();
    case ProjectPackage.POP_PROJECT__CHECKOUTS:
      return getCheckouts();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
    case ProjectPackage.POP_PROJECT__NAME:
      setName((String)newValue);
      return;
    case ProjectPackage.POP_PROJECT__REPOSITORY:
      setRepository((Repository)newValue);
      return;
    case ProjectPackage.POP_PROJECT__ROOT_STREAM:
      setRootStream((RootStream)newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
    case ProjectPackage.POP_PROJECT__NAME:
      setName(NAME_EDEFAULT);
      return;
    case ProjectPackage.POP_PROJECT__REPOSITORY:
      setRepository((Repository)null);
      return;
    case ProjectPackage.POP_PROJECT__ROOT_STREAM:
      setRootStream((RootStream)null);
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
    case ProjectPackage.POP_PROJECT__NAME:
      return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
    case ProjectPackage.POP_PROJECT__REPOSITORY:
      return repository != null;
    case ProjectPackage.POP_PROJECT__ROOT_STREAM:
      return rootStream != null;
    case ProjectPackage.POP_PROJECT__CHECKOUTS:
      return !getCheckouts().isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy())
      return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: "); //$NON-NLS-1$
    result.append(name);
    result.append(')');
    return result.toString();
  }

  /**
   * @ADDED
   */
  public ICheckoutManager getCheckoutManager()
  {
    return checkoutManager;
  }

  /**
   * @ADDED
   */
  public void setCheckoutManager(ICheckoutManager checkoutManager)
  {
    this.checkoutManager = checkoutManager;
  }
} // PopProjectImpl
