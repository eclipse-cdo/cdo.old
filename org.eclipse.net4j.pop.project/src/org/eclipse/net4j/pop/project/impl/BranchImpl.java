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
 * $Id: BranchImpl.java,v 1.1 2008-08-08 10:10:30 estepper Exp $
 */
package org.eclipse.net4j.pop.project.impl;

import org.eclipse.net4j.pop.project.Branch;
import org.eclipse.net4j.pop.project.MainBranch;
import org.eclipse.net4j.pop.project.ProjectPackage;
import org.eclipse.net4j.pop.project.Stream;
import org.eclipse.net4j.pop.project.SubBranch;
import org.eclipse.net4j.pop.project.Tag;
import org.eclipse.net4j.pop.repository.IRepositoryTag;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import java.util.Collection;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Branch</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.BranchImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.BranchImpl#getBranches <em>Branches</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.BranchImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.BranchImpl#getStream <em>Stream</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class BranchImpl extends CheckoutDiscriminatorImpl implements Branch
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
   * The cached value of the '{@link #getBranches() <em>Branches</em>}' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @see #getBranches()
   * @generated
   * @ordered
   */
  protected EList<SubBranch> branches;

  /**
   * The cached value of the '{@link #getTags() <em>Tags</em>}' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getTags()
   * @generated
   * @ordered
   */
  protected EList<Tag> tags;

  /**
   * The cached value of the '{@link #getStream() <em>Stream</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getStream()
   * @generated
   * @ordered
   */
  protected Stream stream;

  /**
   * @ADDED
   */
  private IRepositoryTag.Branch repositoryTag;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected BranchImpl()
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
    return ProjectPackage.Literals.BRANCH;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.BRANCH__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList<SubBranch> getBranches()
  {
    if (branches == null)
    {
      branches = new EObjectContainmentWithInverseEList.Resolving<SubBranch>(SubBranch.class, this,
          ProjectPackage.BRANCH__BRANCHES, ProjectPackage.SUB_BRANCH__PARENT);
    }
    return branches;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList<Tag> getTags()
  {
    if (tags == null)
    {
      tags = new EObjectContainmentWithInverseEList.Resolving<Tag>(Tag.class, this, ProjectPackage.BRANCH__TAGS,
          ProjectPackage.TAG__BRANCH);
    }
    return tags;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Stream getStream()
  {
    if (stream != null && stream.eIsProxy())
    {
      InternalEObject oldStream = (InternalEObject)stream;
      stream = (Stream)eResolveProxy(oldStream);
      if (stream != oldStream)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProjectPackage.BRANCH__STREAM, oldStream, stream));
      }
    }
    return stream;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Stream basicGetStream()
  {
    return stream;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStream(Stream newStream, NotificationChain msgs)
  {
    Stream oldStream = stream;
    stream = newStream;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProjectPackage.BRANCH__STREAM,
          oldStream, newStream);
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
  public void setStream(Stream newStream)
  {
    if (newStream != stream)
    {
      NotificationChain msgs = null;
      if (stream != null)
        msgs = ((InternalEObject)stream).eInverseRemove(this, ProjectPackage.STREAM__BRANCH, Stream.class, msgs);
      if (newStream != null)
        msgs = ((InternalEObject)newStream).eInverseAdd(this, ProjectPackage.STREAM__BRANCH, Stream.class, msgs);
      msgs = basicSetStream(newStream, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.BRANCH__STREAM, newStream, newStream));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public abstract MainBranch getMainBranch();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public abstract Branch getParent();

  /**
   * @ADDED
   */
  @Override
  public synchronized IRepositoryTag getRepositoryTag()
  {
    if (repositoryTag == null)
    {
      // TODO Listen to repository for adapter type changes
      repositoryTag = getRepository().getAdapter().createBranchTag(name);
    }

    return repositoryTag;
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
    case ProjectPackage.BRANCH__BRANCHES:
      return ((InternalEList<InternalEObject>)(InternalEList<?>)getBranches()).basicAdd(otherEnd, msgs);
    case ProjectPackage.BRANCH__TAGS:
      return ((InternalEList<InternalEObject>)(InternalEList<?>)getTags()).basicAdd(otherEnd, msgs);
    case ProjectPackage.BRANCH__STREAM:
      if (stream != null)
        msgs = ((InternalEObject)stream).eInverseRemove(this, ProjectPackage.STREAM__BRANCH, Stream.class, msgs);
      return basicSetStream((Stream)otherEnd, msgs);
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
    case ProjectPackage.BRANCH__BRANCHES:
      return ((InternalEList<?>)getBranches()).basicRemove(otherEnd, msgs);
    case ProjectPackage.BRANCH__TAGS:
      return ((InternalEList<?>)getTags()).basicRemove(otherEnd, msgs);
    case ProjectPackage.BRANCH__STREAM:
      return basicSetStream(null, msgs);
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
    case ProjectPackage.BRANCH__NAME:
      return getName();
    case ProjectPackage.BRANCH__BRANCHES:
      return getBranches();
    case ProjectPackage.BRANCH__TAGS:
      return getTags();
    case ProjectPackage.BRANCH__STREAM:
      if (resolve)
        return getStream();
      return basicGetStream();
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
    case ProjectPackage.BRANCH__NAME:
      setName((String)newValue);
      return;
    case ProjectPackage.BRANCH__BRANCHES:
      getBranches().clear();
      getBranches().addAll((Collection<? extends SubBranch>)newValue);
      return;
    case ProjectPackage.BRANCH__TAGS:
      getTags().clear();
      getTags().addAll((Collection<? extends Tag>)newValue);
      return;
    case ProjectPackage.BRANCH__STREAM:
      setStream((Stream)newValue);
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
    case ProjectPackage.BRANCH__NAME:
      setName(NAME_EDEFAULT);
      return;
    case ProjectPackage.BRANCH__BRANCHES:
      getBranches().clear();
      return;
    case ProjectPackage.BRANCH__TAGS:
      getTags().clear();
      return;
    case ProjectPackage.BRANCH__STREAM:
      setStream((Stream)null);
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
    case ProjectPackage.BRANCH__NAME:
      return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
    case ProjectPackage.BRANCH__BRANCHES:
      return branches != null && !branches.isEmpty();
    case ProjectPackage.BRANCH__TAGS:
      return tags != null && !tags.isEmpty();
    case ProjectPackage.BRANCH__STREAM:
      return stream != null;
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
} // BranchImpl
