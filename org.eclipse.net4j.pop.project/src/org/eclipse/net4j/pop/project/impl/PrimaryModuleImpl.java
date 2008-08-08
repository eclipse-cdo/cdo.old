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
 * $Id: PrimaryModuleImpl.java,v 1.1 2008-08-08 10:10:30 estepper Exp $
 */
package org.eclipse.net4j.pop.project.impl;

import org.eclipse.net4j.pop.project.PrimaryModule;
import org.eclipse.net4j.pop.project.ProjectPackage;
import org.eclipse.net4j.pop.project.Repository;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Primary Module</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.PrimaryModuleImpl#getRepository <em>Repository</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.PrimaryModuleImpl#getProductModelPath <em>Product Model Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimaryModuleImpl extends ModuleImpl implements PrimaryModule
{
  /**
   * The default value of the '{@link #getProductModelPath() <em>Product Model Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProductModelPath()
   * @generated
   * @ordered
   */
  protected static final String PRODUCT_MODEL_PATH_EDEFAULT = "product.xml"; //$NON-NLS-1$

  /**
   * The cached value of the '{@link #getProductModelPath() <em>Product Model Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProductModelPath()
   * @generated
   * @ordered
   */
  protected String productModelPath = PRODUCT_MODEL_PATH_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected PrimaryModuleImpl()
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
    return ProjectPackage.Literals.PRIMARY_MODULE;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Repository getRepository()
  {
    if (eContainerFeatureID != ProjectPackage.PRIMARY_MODULE__REPOSITORY)
      return null;
    return (Repository)eContainer();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Repository basicGetRepository()
  {
    if (eContainerFeatureID != ProjectPackage.PRIMARY_MODULE__REPOSITORY)
      return null;
    return (Repository)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRepository(Repository newRepository, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newRepository, ProjectPackage.PRIMARY_MODULE__REPOSITORY, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setRepository(Repository newRepository)
  {
    if (newRepository != eInternalContainer()
        || (eContainerFeatureID != ProjectPackage.PRIMARY_MODULE__REPOSITORY && newRepository != null))
    {
      if (EcoreUtil.isAncestor(this, newRepository))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newRepository != null)
        msgs = ((InternalEObject)newRepository).eInverseAdd(this, ProjectPackage.REPOSITORY__PRIMARY_MODULE,
            Repository.class, msgs);
      msgs = basicSetRepository(newRepository, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.PRIMARY_MODULE__REPOSITORY, newRepository,
          newRepository));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getProductModelPath()
  {
    return productModelPath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProductModelPath(String newProductModelPath)
  {
    String oldProductModelPath = productModelPath;
    productModelPath = newProductModelPath;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.PRIMARY_MODULE__PRODUCT_MODEL_PATH,
          oldProductModelPath, productModelPath));
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
    case ProjectPackage.PRIMARY_MODULE__REPOSITORY:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetRepository((Repository)otherEnd, msgs);
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
    case ProjectPackage.PRIMARY_MODULE__REPOSITORY:
      return basicSetRepository(null, msgs);
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
    case ProjectPackage.PRIMARY_MODULE__REPOSITORY:
      return eInternalContainer().eInverseRemove(this, ProjectPackage.REPOSITORY__PRIMARY_MODULE, Repository.class,
          msgs);
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
    case ProjectPackage.PRIMARY_MODULE__REPOSITORY:
      if (resolve)
        return getRepository();
      return basicGetRepository();
    case ProjectPackage.PRIMARY_MODULE__PRODUCT_MODEL_PATH:
      return getProductModelPath();
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
    case ProjectPackage.PRIMARY_MODULE__REPOSITORY:
      setRepository((Repository)newValue);
      return;
    case ProjectPackage.PRIMARY_MODULE__PRODUCT_MODEL_PATH:
      setProductModelPath((String)newValue);
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
    case ProjectPackage.PRIMARY_MODULE__REPOSITORY:
      setRepository((Repository)null);
      return;
    case ProjectPackage.PRIMARY_MODULE__PRODUCT_MODEL_PATH:
      setProductModelPath(PRODUCT_MODEL_PATH_EDEFAULT);
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
    case ProjectPackage.PRIMARY_MODULE__REPOSITORY:
      return basicGetRepository() != null;
    case ProjectPackage.PRIMARY_MODULE__PRODUCT_MODEL_PATH:
      return PRODUCT_MODEL_PATH_EDEFAULT == null ? productModelPath != null : !PRODUCT_MODEL_PATH_EDEFAULT
          .equals(productModelPath);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy())
      return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (productModelPath: "); //$NON-NLS-1$
    result.append(productModelPath);
    result.append(')');
    return result.toString();
  }

} // PrimaryModuleImpl
