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
 * $Id: PopElementImpl.java,v 1.1 2008-08-08 10:10:36 estepper Exp $
 */
package org.eclipse.net4j.pop.base.impl;

import org.eclipse.net4j.pop.base.BasePackage;
import org.eclipse.net4j.pop.base.PopElement;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Pop Element</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.net4j.pop.base.impl.PopElementImpl#getId <em>Id</em>}</li>
 * <li>{@link org.eclipse.net4j.pop.base.impl.PopElementImpl#getClass_ <em>Class</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class PopElementImpl extends EObjectImpl implements PopElement
{
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The default value of the '{@link #getClass_() <em>Class</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getClass_()
   * @generated
   * @ordered
   */
  protected static final String CLASS_EDEFAULT = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected PopElementImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return BasePackage.Literals.POP_ELEMENT;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public String getId()
  {
    Resource resource = eResource();
    if (resource instanceof XMLResource)
    {
      XMLResource xmlResource = (XMLResource)resource;
      return xmlResource.getID(this);
    }

    return null;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public String getDisplayString()
  {
    return toString();
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
    case BasePackage.POP_ELEMENT__ID:
      return getId();
    case BasePackage.POP_ELEMENT__CLASS:
      return getClass_();
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
    case BasePackage.POP_ELEMENT__ID:
      return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
    case BasePackage.POP_ELEMENT__CLASS:
      return CLASS_EDEFAULT == null ? getClass_() != null : !CLASS_EDEFAULT.equals(getClass_());
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public String getClass_()
  {
    return eClass().getName();
  }
} // PopElementImpl
