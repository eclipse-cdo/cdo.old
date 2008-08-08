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
 * $Id: WorkingSetImpl.java,v 1.1 2008-08-08 10:10:32 estepper Exp $
 */
package org.eclipse.net4j.pop.product.impl;

import org.eclipse.net4j.pop.base.impl.PopElementImpl;
import org.eclipse.net4j.pop.product.PopProduct;
import org.eclipse.net4j.pop.product.ProductPackage;
import org.eclipse.net4j.pop.product.WorkingSet;
import org.eclipse.net4j.pop.product.WorkspaceProject;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import java.util.Collection;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Working Set</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.product.impl.WorkingSetImpl#getPopProduct <em>Pop Product</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.product.impl.WorkingSetImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.product.impl.WorkingSetImpl#getProjects <em>Projects</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkingSetImpl extends PopElementImpl implements WorkingSet
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
   * The cached value of the '{@link #getProjects() <em>Projects</em>}' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getProjects()
   * @generated
   * @ordered
   */
  protected EList<WorkspaceProject> projects;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected WorkingSetImpl()
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
    return ProductPackage.Literals.WORKING_SET;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PopProduct getPopProduct()
  {
    if (eContainerFeatureID != ProductPackage.WORKING_SET__POP_PRODUCT)
      return null;
    return (PopProduct)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPopProduct(PopProduct newPopProduct, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newPopProduct, ProductPackage.WORKING_SET__POP_PRODUCT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPopProduct(PopProduct newPopProduct)
  {
    if (newPopProduct != eInternalContainer()
        || (eContainerFeatureID != ProductPackage.WORKING_SET__POP_PRODUCT && newPopProduct != null))
    {
      if (EcoreUtil.isAncestor(this, newPopProduct))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newPopProduct != null)
        msgs = ((InternalEObject)newPopProduct).eInverseAdd(this, ProductPackage.POP_PRODUCT__WORKING_SETS,
            PopProduct.class, msgs);
      msgs = basicSetPopProduct(newPopProduct, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProductPackage.WORKING_SET__POP_PRODUCT, newPopProduct,
          newPopProduct));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ProductPackage.WORKING_SET__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList<WorkspaceProject> getProjects()
  {
    if (projects == null)
    {
      projects = new EObjectWithInverseResolvingEList.ManyInverse<WorkspaceProject>(WorkspaceProject.class, this,
          ProductPackage.WORKING_SET__PROJECTS, ProductPackage.WORKSPACE_PROJECT__WORKING_SETS);
    }
    return projects;
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
    case ProductPackage.WORKING_SET__POP_PRODUCT:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetPopProduct((PopProduct)otherEnd, msgs);
    case ProductPackage.WORKING_SET__PROJECTS:
      return ((InternalEList<InternalEObject>)(InternalEList<?>)getProjects()).basicAdd(otherEnd, msgs);
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
    case ProductPackage.WORKING_SET__POP_PRODUCT:
      return basicSetPopProduct(null, msgs);
    case ProductPackage.WORKING_SET__PROJECTS:
      return ((InternalEList<?>)getProjects()).basicRemove(otherEnd, msgs);
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
    case ProductPackage.WORKING_SET__POP_PRODUCT:
      return eInternalContainer()
          .eInverseRemove(this, ProductPackage.POP_PRODUCT__WORKING_SETS, PopProduct.class, msgs);
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
    case ProductPackage.WORKING_SET__POP_PRODUCT:
      return getPopProduct();
    case ProductPackage.WORKING_SET__NAME:
      return getName();
    case ProductPackage.WORKING_SET__PROJECTS:
      return getProjects();
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
    case ProductPackage.WORKING_SET__POP_PRODUCT:
      setPopProduct((PopProduct)newValue);
      return;
    case ProductPackage.WORKING_SET__NAME:
      setName((String)newValue);
      return;
    case ProductPackage.WORKING_SET__PROJECTS:
      getProjects().clear();
      getProjects().addAll((Collection<? extends WorkspaceProject>)newValue);
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
    case ProductPackage.WORKING_SET__POP_PRODUCT:
      setPopProduct((PopProduct)null);
      return;
    case ProductPackage.WORKING_SET__NAME:
      setName(NAME_EDEFAULT);
      return;
    case ProductPackage.WORKING_SET__PROJECTS:
      getProjects().clear();
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
    case ProductPackage.WORKING_SET__POP_PRODUCT:
      return getPopProduct() != null;
    case ProductPackage.WORKING_SET__NAME:
      return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
    case ProductPackage.WORKING_SET__PROJECTS:
      return projects != null && !projects.isEmpty();
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

} // WorkingSetImpl
