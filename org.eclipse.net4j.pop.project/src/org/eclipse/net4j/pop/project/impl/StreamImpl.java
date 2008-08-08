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
 * $Id: StreamImpl.java,v 1.1 2008-08-08 10:10:30 estepper Exp $
 */
package org.eclipse.net4j.pop.project.impl;

import org.eclipse.net4j.pop.base.impl.PopElementImpl;
import org.eclipse.net4j.pop.project.Branch;
import org.eclipse.net4j.pop.project.Merge;
import org.eclipse.net4j.pop.project.PopProject;
import org.eclipse.net4j.pop.project.ProjectPackage;
import org.eclipse.net4j.pop.project.Stream;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import java.util.Collection;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Stream</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.StreamImpl#getBranch <em>Branch</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.StreamImpl#getMerges <em>Merges</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class StreamImpl extends PopElementImpl implements Stream
{
  /**
   * The cached value of the '{@link #getBranch() <em>Branch</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getBranch()
   * @generated
   * @ordered
   */
  protected Branch branch;

  /**
   * The cached value of the '{@link #getMerges() <em>Merges</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMerges()
   * @generated
   * @ordered
   */
  protected EList<Merge> merges;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected StreamImpl()
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
    return ProjectPackage.Literals.STREAM;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Branch getBranch()
  {
    if (branch != null && branch.eIsProxy())
    {
      InternalEObject oldBranch = (InternalEObject)branch;
      branch = (Branch)eResolveProxy(oldBranch);
      if (branch != oldBranch)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProjectPackage.STREAM__BRANCH, oldBranch, branch));
      }
    }
    return branch;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Branch basicGetBranch()
  {
    return branch;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBranch(Branch newBranch, NotificationChain msgs)
  {
    Branch oldBranch = branch;
    branch = newBranch;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProjectPackage.STREAM__BRANCH,
          oldBranch, newBranch);
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
  public void setBranch(Branch newBranch)
  {
    if (newBranch != branch)
    {
      NotificationChain msgs = null;
      if (branch != null)
        msgs = ((InternalEObject)branch).eInverseRemove(this, ProjectPackage.BRANCH__STREAM, Branch.class, msgs);
      if (newBranch != null)
        msgs = ((InternalEObject)newBranch).eInverseAdd(this, ProjectPackage.BRANCH__STREAM, Branch.class, msgs);
      msgs = basicSetBranch(newBranch, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.STREAM__BRANCH, newBranch, newBranch));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList<Merge> getMerges()
  {
    if (merges == null)
    {
      merges = new EObjectContainmentWithInverseEList.Resolving<Merge>(Merge.class, this,
          ProjectPackage.STREAM__MERGES, ProjectPackage.MERGE__STREAM);
    }
    return merges;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public abstract PopProject getPopProject();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public abstract Stream getParent();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public EList<Stream> getStreams()
  {
    EList<Stream> streams = new BasicEList<Stream>();
    collectStreams(streams);
    return streams;
  }

  /**
   * @ADDED
   */
  public abstract void collectStreams(EList<Stream> streams);

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
    case ProjectPackage.STREAM__BRANCH:
      if (branch != null)
        msgs = ((InternalEObject)branch).eInverseRemove(this, ProjectPackage.BRANCH__STREAM, Branch.class, msgs);
      return basicSetBranch((Branch)otherEnd, msgs);
    case ProjectPackage.STREAM__MERGES:
      return ((InternalEList<InternalEObject>)(InternalEList<?>)getMerges()).basicAdd(otherEnd, msgs);
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
    case ProjectPackage.STREAM__BRANCH:
      return basicSetBranch(null, msgs);
    case ProjectPackage.STREAM__MERGES:
      return ((InternalEList<?>)getMerges()).basicRemove(otherEnd, msgs);
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
    case ProjectPackage.STREAM__BRANCH:
      if (resolve)
        return getBranch();
      return basicGetBranch();
    case ProjectPackage.STREAM__MERGES:
      return getMerges();
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
    case ProjectPackage.STREAM__BRANCH:
      setBranch((Branch)newValue);
      return;
    case ProjectPackage.STREAM__MERGES:
      getMerges().clear();
      getMerges().addAll((Collection<? extends Merge>)newValue);
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
    case ProjectPackage.STREAM__BRANCH:
      setBranch((Branch)null);
      return;
    case ProjectPackage.STREAM__MERGES:
      getMerges().clear();
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
    case ProjectPackage.STREAM__BRANCH:
      return branch != null;
    case ProjectPackage.STREAM__MERGES:
      return merges != null && !merges.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // StreamImpl
