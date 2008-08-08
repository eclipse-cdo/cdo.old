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
 * $Id: ArchiveContentImpl.java,v 1.1 2008-08-08 10:10:32 estepper Exp $
 */
package org.eclipse.net4j.pop.product.impl;

import org.eclipse.net4j.pop.product.Archive;
import org.eclipse.net4j.pop.product.ArchiveContent;
import org.eclipse.net4j.pop.product.ProductPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Archive Content</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.net4j.pop.product.impl.ArchiveContentImpl#getArchive <em>Archive</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ArchiveContentImpl extends FolderImpl implements ArchiveContent
{
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected ArchiveContentImpl()
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
    return ProductPackage.Literals.ARCHIVE_CONTENT;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Archive getArchive()
  {
    if (eContainerFeatureID != ProductPackage.ARCHIVE_CONTENT__ARCHIVE)
      return null;
    return (Archive)eContainer();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArchive(Archive newArchive, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newArchive, ProductPackage.ARCHIVE_CONTENT__ARCHIVE, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setArchive(Archive newArchive)
  {
    if (newArchive != eInternalContainer()
        || (eContainerFeatureID != ProductPackage.ARCHIVE_CONTENT__ARCHIVE && newArchive != null))
    {
      if (EcoreUtil.isAncestor(this, newArchive))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newArchive != null)
        msgs = ((InternalEObject)newArchive).eInverseAdd(this, ProductPackage.ARCHIVE__CONTENT, Archive.class, msgs);
      msgs = basicSetArchive(newArchive, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProductPackage.ARCHIVE_CONTENT__ARCHIVE, newArchive,
          newArchive));
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
    case ProductPackage.ARCHIVE_CONTENT__ARCHIVE:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetArchive((Archive)otherEnd, msgs);
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
    case ProductPackage.ARCHIVE_CONTENT__ARCHIVE:
      return basicSetArchive(null, msgs);
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
    case ProductPackage.ARCHIVE_CONTENT__ARCHIVE:
      return eInternalContainer().eInverseRemove(this, ProductPackage.ARCHIVE__CONTENT, Archive.class, msgs);
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
    case ProductPackage.ARCHIVE_CONTENT__ARCHIVE:
      return getArchive();
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
    case ProductPackage.ARCHIVE_CONTENT__ARCHIVE:
      setArchive((Archive)newValue);
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
    case ProductPackage.ARCHIVE_CONTENT__ARCHIVE:
      setArchive((Archive)null);
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
    case ProductPackage.ARCHIVE_CONTENT__ARCHIVE:
      return getArchive() != null;
    }
    return super.eIsSet(featureID);
  }

} // ArchiveContentImpl
