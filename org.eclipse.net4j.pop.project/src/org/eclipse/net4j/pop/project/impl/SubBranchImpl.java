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
 * $Id: SubBranchImpl.java,v 1.1 2008-08-08 10:10:30 estepper Exp $
 */
package org.eclipse.net4j.pop.project.impl;

import org.eclipse.net4j.pop.project.Branch;
import org.eclipse.net4j.pop.project.MainBranch;
import org.eclipse.net4j.pop.project.ProjectPackage;
import org.eclipse.net4j.pop.project.Repository;
import org.eclipse.net4j.pop.project.SubBranch;
import org.eclipse.net4j.pop.project.Tag;
import org.eclipse.net4j.pop.project.TaggedElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Sub Branch</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.SubBranchImpl#getTag <em>Tag</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.SubBranchImpl#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubBranchImpl extends BranchImpl implements SubBranch
{
  /**
   * The cached value of the '{@link #getTag() <em>Tag</em>}' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getTag()
   * @generated
   * @ordered
   */
  protected Tag tag;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected SubBranchImpl()
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
    return ProjectPackage.Literals.SUB_BRANCH;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Tag getTag()
  {
    if (tag != null && tag.eIsProxy())
    {
      InternalEObject oldTag = (InternalEObject)tag;
      tag = (Tag)eResolveProxy(oldTag);
      if (tag != oldTag)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProjectPackage.SUB_BRANCH__TAG, oldTag, tag));
      }
    }
    return tag;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Tag basicGetTag()
  {
    return tag;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTag(Tag newTag, NotificationChain msgs)
  {
    Tag oldTag = tag;
    tag = newTag;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProjectPackage.SUB_BRANCH__TAG,
          oldTag, newTag);
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
  public void setTag(Tag newTag)
  {
    if (newTag != tag)
    {
      NotificationChain msgs = null;
      if (tag != null)
        msgs = ((InternalEObject)tag).eInverseRemove(this, ProjectPackage.TAG__TAGGED_ELEMENT, Tag.class, msgs);
      if (newTag != null)
        msgs = ((InternalEObject)newTag).eInverseAdd(this, ProjectPackage.TAG__TAGGED_ELEMENT, Tag.class, msgs);
      msgs = basicSetTag(newTag, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.SUB_BRANCH__TAG, newTag, newTag));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Branch getParent()
  {
    if (eContainerFeatureID != ProjectPackage.SUB_BRANCH__PARENT)
      return null;
    return (Branch)eContainer();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Branch basicGetParent()
  {
    if (eContainerFeatureID != ProjectPackage.SUB_BRANCH__PARENT)
      return null;
    return (Branch)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParent(Branch newParent, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newParent, ProjectPackage.SUB_BRANCH__PARENT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setParent(Branch newParent)
  {
    if (newParent != eInternalContainer()
        || (eContainerFeatureID != ProjectPackage.SUB_BRANCH__PARENT && newParent != null))
    {
      if (EcoreUtil.isAncestor(this, newParent))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newParent != null)
        msgs = ((InternalEObject)newParent).eInverseAdd(this, ProjectPackage.BRANCH__BRANCHES, Branch.class, msgs);
      msgs = basicSetParent(newParent, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.SUB_BRANCH__PARENT, newParent, newParent));
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
    case ProjectPackage.SUB_BRANCH__TAG:
      if (tag != null)
        msgs = ((InternalEObject)tag).eInverseRemove(this, ProjectPackage.TAG__TAGGED_ELEMENT, Tag.class, msgs);
      return basicSetTag((Tag)otherEnd, msgs);
    case ProjectPackage.SUB_BRANCH__PARENT:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetParent((Branch)otherEnd, msgs);
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
    case ProjectPackage.SUB_BRANCH__TAG:
      return basicSetTag(null, msgs);
    case ProjectPackage.SUB_BRANCH__PARENT:
      return basicSetParent(null, msgs);
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
    case ProjectPackage.SUB_BRANCH__PARENT:
      return eInternalContainer().eInverseRemove(this, ProjectPackage.BRANCH__BRANCHES, Branch.class, msgs);
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
    case ProjectPackage.SUB_BRANCH__TAG:
      if (resolve)
        return getTag();
      return basicGetTag();
    case ProjectPackage.SUB_BRANCH__PARENT:
      if (resolve)
        return getParent();
      return basicGetParent();
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
    case ProjectPackage.SUB_BRANCH__TAG:
      setTag((Tag)newValue);
      return;
    case ProjectPackage.SUB_BRANCH__PARENT:
      setParent((Branch)newValue);
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
    case ProjectPackage.SUB_BRANCH__TAG:
      setTag((Tag)null);
      return;
    case ProjectPackage.SUB_BRANCH__PARENT:
      setParent((Branch)null);
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
    case ProjectPackage.SUB_BRANCH__TAG:
      return tag != null;
    case ProjectPackage.SUB_BRANCH__PARENT:
      return basicGetParent() != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == TaggedElement.class)
    {
      switch (derivedFeatureID)
      {
      case ProjectPackage.SUB_BRANCH__TAG:
        return ProjectPackage.TAGGED_ELEMENT__TAG;
      default:
        return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == TaggedElement.class)
    {
      switch (baseFeatureID)
      {
      case ProjectPackage.TAGGED_ELEMENT__TAG:
        return ProjectPackage.SUB_BRANCH__TAG;
      default:
        return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

  /**
   * @ADDED
   */
  @Override
  public Repository getRepository()
  {
    return getMainBranch().getRepository();
  }

  /**
   * @ADDED
   */
  @Override
  public MainBranch getMainBranch()
  {
    return getParent().getMainBranch();
  }
} // SubBranchImpl
