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
 * $Id: RepositoryImpl.java,v 1.1 2008-08-08 10:10:30 estepper Exp $
 */
package org.eclipse.net4j.pop.project.impl;

import org.eclipse.net4j.pop.base.impl.PopElementImpl;
import org.eclipse.net4j.pop.project.Committer;
import org.eclipse.net4j.pop.project.MainBranch;
import org.eclipse.net4j.pop.project.PopProject;
import org.eclipse.net4j.pop.project.PrimaryModule;
import org.eclipse.net4j.pop.project.ProjectPackage;
import org.eclipse.net4j.pop.project.Repository;
import org.eclipse.net4j.pop.repository.IRepositoryAdapter;

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
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Repository</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.RepositoryImpl#getPopProject <em>Pop Project</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.RepositoryImpl#getAdapter <em>Adapter</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.RepositoryImpl#getAdapterType <em>Adapter Type</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.RepositoryImpl#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.RepositoryImpl#getMainBranch <em>Main Branch</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.RepositoryImpl#getPrimaryModule <em>Primary Module</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.RepositoryImpl#getCommitters <em>Committers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RepositoryImpl extends PopElementImpl implements Repository
{
  /**
   * The default value of the '{@link #getAdapter() <em>Adapter</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getAdapter()
   * @generated
   * @ordered
   */
  protected static final IRepositoryAdapter ADAPTER_EDEFAULT = null;

  /**
   * The default value of the '{@link #getAdapterType() <em>Adapter Type</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getAdapterType()
   * @generated
   * @ordered
   */
  protected static final String ADAPTER_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAdapterType() <em>Adapter Type</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getAdapterType()
   * @generated
   * @ordered
   */
  protected String adapterType = ADAPTER_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getDescriptor() <em>Descriptor</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getDescriptor()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTOR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescriptor() <em>Descriptor</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getDescriptor()
   * @generated
   * @ordered
   */
  protected String descriptor = DESCRIPTOR_EDEFAULT;

  /**
   * The cached value of the '{@link #getMainBranch() <em>Main Branch</em>}' containment reference.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @see #getMainBranch()
   * @generated
   * @ordered
   */
  protected MainBranch mainBranch;

  /**
   * The cached value of the '{@link #getPrimaryModule() <em>Primary Module</em>}' containment reference. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getPrimaryModule()
   * @generated
   * @ordered
   */
  protected PrimaryModule primaryModule;

  /**
   * The cached value of the '{@link #getCommitters() <em>Committers</em>}' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getCommitters()
   * @generated
   * @ordered
   */
  protected EList<Committer> committers;

  /**
   * @ADDED
   */
  private IRepositoryAdapter adapter;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected RepositoryImpl()
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
    return ProjectPackage.Literals.REPOSITORY;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public PopProject getPopProject()
  {
    if (eContainerFeatureID != ProjectPackage.REPOSITORY__POP_PROJECT)
      return null;
    return (PopProject)eContainer();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public PopProject basicGetPopProject()
  {
    if (eContainerFeatureID != ProjectPackage.REPOSITORY__POP_PROJECT)
      return null;
    return (PopProject)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPopProject(PopProject newPopProject, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newPopProject, ProjectPackage.REPOSITORY__POP_PROJECT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setPopProject(PopProject newPopProject)
  {
    if (newPopProject != eInternalContainer()
        || (eContainerFeatureID != ProjectPackage.REPOSITORY__POP_PROJECT && newPopProject != null))
    {
      if (EcoreUtil.isAncestor(this, newPopProject))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newPopProject != null)
        msgs = ((InternalEObject)newPopProject).eInverseAdd(this, ProjectPackage.POP_PROJECT__REPOSITORY,
            PopProject.class, msgs);
      msgs = basicSetPopProject(newPopProject, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.REPOSITORY__POP_PROJECT, newPopProject,
          newPopProject));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public synchronized IRepositoryAdapter getAdapter()
  {
    if (adapter == null)
    {
      adapter = IRepositoryAdapter.Registry.INSTANCE.get(adapterType);
      if (adapter == null)
      {
        throw new IllegalStateException("Unrecognized repository adapter type: " + adapterType);
      }
    }

    return adapter;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getAdapterType()
  {
    return adapterType;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public void setAdapterType(String newAdapterType)
  {
    String oldAdapterType = null;
    synchronized (this)
    {
      oldAdapterType = adapterType;
      adapterType = newAdapterType;
      adapter = null;
    }

    if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.REPOSITORY__ADAPTER_TYPE, oldAdapterType,
          adapterType));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getDescriptor()
  {
    return descriptor;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setDescriptor(String newDescriptor)
  {
    String oldDescriptor = descriptor;
    descriptor = newDescriptor;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.REPOSITORY__DESCRIPTOR, oldDescriptor,
          descriptor));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public PrimaryModule getPrimaryModule()
  {
    if (primaryModule != null && primaryModule.eIsProxy())
    {
      InternalEObject oldPrimaryModule = (InternalEObject)primaryModule;
      primaryModule = (PrimaryModule)eResolveProxy(oldPrimaryModule);
      if (primaryModule != oldPrimaryModule)
      {
        InternalEObject newPrimaryModule = (InternalEObject)primaryModule;
        NotificationChain msgs = oldPrimaryModule.eInverseRemove(this, ProjectPackage.PRIMARY_MODULE__REPOSITORY,
            PrimaryModule.class, null);
        if (newPrimaryModule.eInternalContainer() == null)
        {
          msgs = newPrimaryModule.eInverseAdd(this, ProjectPackage.PRIMARY_MODULE__REPOSITORY, PrimaryModule.class,
              msgs);
        }
        if (msgs != null)
          msgs.dispatch();
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProjectPackage.REPOSITORY__PRIMARY_MODULE,
              oldPrimaryModule, primaryModule));
      }
    }
    return primaryModule;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public PrimaryModule basicGetPrimaryModule()
  {
    return primaryModule;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPrimaryModule(PrimaryModule newPrimaryModule, NotificationChain msgs)
  {
    PrimaryModule oldPrimaryModule = primaryModule;
    primaryModule = newPrimaryModule;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
          ProjectPackage.REPOSITORY__PRIMARY_MODULE, oldPrimaryModule, newPrimaryModule);
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
  public void setPrimaryModule(PrimaryModule newPrimaryModule)
  {
    if (newPrimaryModule != primaryModule)
    {
      NotificationChain msgs = null;
      if (primaryModule != null)
        msgs = ((InternalEObject)primaryModule).eInverseRemove(this, ProjectPackage.PRIMARY_MODULE__REPOSITORY,
            PrimaryModule.class, msgs);
      if (newPrimaryModule != null)
        msgs = ((InternalEObject)newPrimaryModule).eInverseAdd(this, ProjectPackage.PRIMARY_MODULE__REPOSITORY,
            PrimaryModule.class, msgs);
      msgs = basicSetPrimaryModule(newPrimaryModule, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.REPOSITORY__PRIMARY_MODULE,
          newPrimaryModule, newPrimaryModule));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList<Committer> getCommitters()
  {
    if (committers == null)
    {
      committers = new EObjectContainmentWithInverseEList.Resolving<Committer>(Committer.class, this,
          ProjectPackage.REPOSITORY__COMMITTERS, ProjectPackage.COMMITTER__REPOSITORY);
    }
    return committers;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public MainBranch getMainBranch()
  {
    if (mainBranch != null && mainBranch.eIsProxy())
    {
      InternalEObject oldMainBranch = (InternalEObject)mainBranch;
      mainBranch = (MainBranch)eResolveProxy(oldMainBranch);
      if (mainBranch != oldMainBranch)
      {
        InternalEObject newMainBranch = (InternalEObject)mainBranch;
        NotificationChain msgs = oldMainBranch.eInverseRemove(this, ProjectPackage.MAIN_BRANCH__REPOSITORY,
            MainBranch.class, null);
        if (newMainBranch.eInternalContainer() == null)
        {
          msgs = newMainBranch.eInverseAdd(this, ProjectPackage.MAIN_BRANCH__REPOSITORY, MainBranch.class, msgs);
        }
        if (msgs != null)
          msgs.dispatch();
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProjectPackage.REPOSITORY__MAIN_BRANCH,
              oldMainBranch, mainBranch));
      }
    }
    return mainBranch;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public MainBranch basicGetMainBranch()
  {
    return mainBranch;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMainBranch(MainBranch newMainBranch, NotificationChain msgs)
  {
    MainBranch oldMainBranch = mainBranch;
    mainBranch = newMainBranch;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
          ProjectPackage.REPOSITORY__MAIN_BRANCH, oldMainBranch, newMainBranch);
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
  public void setMainBranch(MainBranch newMainBranch)
  {
    if (newMainBranch != mainBranch)
    {
      NotificationChain msgs = null;
      if (mainBranch != null)
        msgs = ((InternalEObject)mainBranch).eInverseRemove(this, ProjectPackage.MAIN_BRANCH__REPOSITORY,
            MainBranch.class, msgs);
      if (newMainBranch != null)
        msgs = ((InternalEObject)newMainBranch).eInverseAdd(this, ProjectPackage.MAIN_BRANCH__REPOSITORY,
            MainBranch.class, msgs);
      msgs = basicSetMainBranch(newMainBranch, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.REPOSITORY__MAIN_BRANCH, newMainBranch,
          newMainBranch));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
    case ProjectPackage.REPOSITORY__POP_PROJECT:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetPopProject((PopProject)otherEnd, msgs);
    case ProjectPackage.REPOSITORY__MAIN_BRANCH:
      if (mainBranch != null)
        msgs = ((InternalEObject)mainBranch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
            - ProjectPackage.REPOSITORY__MAIN_BRANCH, null, msgs);
      return basicSetMainBranch((MainBranch)otherEnd, msgs);
    case ProjectPackage.REPOSITORY__PRIMARY_MODULE:
      if (primaryModule != null)
        msgs = ((InternalEObject)primaryModule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
            - ProjectPackage.REPOSITORY__PRIMARY_MODULE, null, msgs);
      return basicSetPrimaryModule((PrimaryModule)otherEnd, msgs);
    case ProjectPackage.REPOSITORY__COMMITTERS:
      return ((InternalEList<InternalEObject>)(InternalEList<?>)getCommitters()).basicAdd(otherEnd, msgs);
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
    case ProjectPackage.REPOSITORY__POP_PROJECT:
      return basicSetPopProject(null, msgs);
    case ProjectPackage.REPOSITORY__MAIN_BRANCH:
      return basicSetMainBranch(null, msgs);
    case ProjectPackage.REPOSITORY__PRIMARY_MODULE:
      return basicSetPrimaryModule(null, msgs);
    case ProjectPackage.REPOSITORY__COMMITTERS:
      return ((InternalEList<?>)getCommitters()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
    switch (eContainerFeatureID)
    {
    case ProjectPackage.REPOSITORY__POP_PROJECT:
      return eInternalContainer().eInverseRemove(this, ProjectPackage.POP_PROJECT__REPOSITORY, PopProject.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
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
    case ProjectPackage.REPOSITORY__POP_PROJECT:
      if (resolve)
        return getPopProject();
      return basicGetPopProject();
    case ProjectPackage.REPOSITORY__ADAPTER:
      return getAdapter();
    case ProjectPackage.REPOSITORY__ADAPTER_TYPE:
      return getAdapterType();
    case ProjectPackage.REPOSITORY__DESCRIPTOR:
      return getDescriptor();
    case ProjectPackage.REPOSITORY__MAIN_BRANCH:
      if (resolve)
        return getMainBranch();
      return basicGetMainBranch();
    case ProjectPackage.REPOSITORY__PRIMARY_MODULE:
      if (resolve)
        return getPrimaryModule();
      return basicGetPrimaryModule();
    case ProjectPackage.REPOSITORY__COMMITTERS:
      return getCommitters();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
    case ProjectPackage.REPOSITORY__POP_PROJECT:
      setPopProject((PopProject)newValue);
      return;
    case ProjectPackage.REPOSITORY__ADAPTER_TYPE:
      setAdapterType((String)newValue);
      return;
    case ProjectPackage.REPOSITORY__DESCRIPTOR:
      setDescriptor((String)newValue);
      return;
    case ProjectPackage.REPOSITORY__MAIN_BRANCH:
      setMainBranch((MainBranch)newValue);
      return;
    case ProjectPackage.REPOSITORY__PRIMARY_MODULE:
      setPrimaryModule((PrimaryModule)newValue);
      return;
    case ProjectPackage.REPOSITORY__COMMITTERS:
      getCommitters().clear();
      getCommitters().addAll((Collection<? extends Committer>)newValue);
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
    case ProjectPackage.REPOSITORY__POP_PROJECT:
      setPopProject((PopProject)null);
      return;
    case ProjectPackage.REPOSITORY__ADAPTER_TYPE:
      setAdapterType(ADAPTER_TYPE_EDEFAULT);
      return;
    case ProjectPackage.REPOSITORY__DESCRIPTOR:
      setDescriptor(DESCRIPTOR_EDEFAULT);
      return;
    case ProjectPackage.REPOSITORY__MAIN_BRANCH:
      setMainBranch((MainBranch)null);
      return;
    case ProjectPackage.REPOSITORY__PRIMARY_MODULE:
      setPrimaryModule((PrimaryModule)null);
      return;
    case ProjectPackage.REPOSITORY__COMMITTERS:
      getCommitters().clear();
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
    case ProjectPackage.REPOSITORY__POP_PROJECT:
      return basicGetPopProject() != null;
    case ProjectPackage.REPOSITORY__ADAPTER:
      return ADAPTER_EDEFAULT == null ? getAdapter() != null : !ADAPTER_EDEFAULT.equals(getAdapter());
    case ProjectPackage.REPOSITORY__ADAPTER_TYPE:
      return ADAPTER_TYPE_EDEFAULT == null ? adapterType != null : !ADAPTER_TYPE_EDEFAULT.equals(adapterType);
    case ProjectPackage.REPOSITORY__DESCRIPTOR:
      return DESCRIPTOR_EDEFAULT == null ? descriptor != null : !DESCRIPTOR_EDEFAULT.equals(descriptor);
    case ProjectPackage.REPOSITORY__MAIN_BRANCH:
      return mainBranch != null;
    case ProjectPackage.REPOSITORY__PRIMARY_MODULE:
      return primaryModule != null;
    case ProjectPackage.REPOSITORY__COMMITTERS:
      return committers != null && !committers.isEmpty();
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
    result.append(" (adapterType: "); //$NON-NLS-1$
    result.append(adapterType);
    result.append(", descriptor: "); //$NON-NLS-1$
    result.append(descriptor);
    result.append(')');
    return result.toString();
  }

} // RepositoryImpl
