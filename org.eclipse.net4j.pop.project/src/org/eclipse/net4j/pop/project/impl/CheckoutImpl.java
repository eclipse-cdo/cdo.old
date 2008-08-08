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
 * $Id: CheckoutImpl.java,v 1.1 2008-08-08 10:10:30 estepper Exp $
 */
package org.eclipse.net4j.pop.project.impl;

import org.eclipse.net4j.pop.base.impl.PopElementImpl;
import org.eclipse.net4j.pop.project.Checkout;
import org.eclipse.net4j.pop.project.CheckoutDiscriminator;
import org.eclipse.net4j.pop.project.ICheckoutManager;
import org.eclipse.net4j.pop.project.PopProject;
import org.eclipse.net4j.pop.project.ProjectPackage;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.core.runtime.IPath;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Checkout</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.net4j.pop.project.impl.CheckoutImpl#getPopProject <em>Pop Project</em>}</li>
 * <li>{@link org.eclipse.net4j.pop.project.impl.CheckoutImpl#getDiscriminator <em>Discriminator</em>}</li>
 * <li>{@link org.eclipse.net4j.pop.project.impl.CheckoutImpl#getLocation <em>Location</em>}</li>
 * <li>{@link org.eclipse.net4j.pop.project.impl.CheckoutImpl#isActive <em>Active</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CheckoutImpl extends PopElementImpl implements Checkout
{
  /**
   * The default value of the '{@link #getLocation() <em>Location</em>}' attribute. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @see #getLocation()
   * @generated
   * @ordered
   */
  protected static final IPath LOCATION_EDEFAULT = null;

  /**
   * The default value of the '{@link #isActive() <em>Active</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #isActive()
   * @generated
   * @ordered
   */
  protected static final boolean ACTIVE_EDEFAULT = false;

  /**
   * @ADDED
   */
  private CheckoutDiscriminator discriminator;

  /**
   * @ADDED
   */
  private IPath location;

  /**
   * @ADDED
   */
  private ICheckoutManager manager;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public CheckoutImpl()
  {
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ProjectPackage.Literals.CHECKOUT;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public PopProject getPopProject()
  {
    return getDiscriminator().getRepository().getPopProject();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public CheckoutDiscriminator getDiscriminator()
  {
    return discriminator;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public IPath getLocation()
  {
    return location;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public boolean isActive()
  {
    if (manager == null)
    {
      return false;
    }

    return manager.isCheckoutActive(this);
  }

  /**
   * @ADDED
   */
  public void setLocation(IPath location)
  {
    this.location = location;
  }

  /**
   * @ADDED
   */
  public void setDiscriminator(CheckoutDiscriminator discriminator)
  {
    this.discriminator = discriminator;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
    case ProjectPackage.CHECKOUT__POP_PROJECT:
      return getPopProject();
    case ProjectPackage.CHECKOUT__DISCRIMINATOR:
      return getDiscriminator();
    case ProjectPackage.CHECKOUT__LOCATION:
      return getLocation();
    case ProjectPackage.CHECKOUT__ACTIVE:
      return isActive() ? Boolean.TRUE : Boolean.FALSE;
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
    case ProjectPackage.CHECKOUT__POP_PROJECT:
      return getPopProject() != null;
    case ProjectPackage.CHECKOUT__DISCRIMINATOR:
      return getDiscriminator() != null;
    case ProjectPackage.CHECKOUT__LOCATION:
      return LOCATION_EDEFAULT == null ? getLocation() != null : !LOCATION_EDEFAULT.equals(getLocation());
    case ProjectPackage.CHECKOUT__ACTIVE:
      return isActive() != ACTIVE_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * @ADDED
   */
  public ICheckoutManager getManager()
  {
    return manager;
  }

  /**
   * @ADDED
   */
  public void setManager(ICheckoutManager manager)
  {
    this.manager = manager;
  }

} // CheckoutImpl
