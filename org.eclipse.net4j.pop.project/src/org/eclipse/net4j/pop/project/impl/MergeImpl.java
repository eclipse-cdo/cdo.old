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
 * $Id: MergeImpl.java,v 1.1 2008-08-08 10:10:30 estepper Exp $
 */
package org.eclipse.net4j.pop.project.impl;

import org.eclipse.net4j.pop.project.Delivery;
import org.eclipse.net4j.pop.project.Merge;
import org.eclipse.net4j.pop.project.ProjectPackage;
import org.eclipse.net4j.pop.project.Stream;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.Date;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Merge</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.MergeImpl#getStream <em>Stream</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.MergeImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.MergeImpl#getDelivery <em>Delivery</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MergeImpl extends TaggedElementImpl implements Merge
{
  /**
   * The default value of the '{@link #getDate() <em>Date</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getDate()
   * @generated
   * @ordered
   */
  protected static final Date DATE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getDate()
   * @generated
   * @ordered
   */
  protected Date date = DATE_EDEFAULT;

  /**
   * The cached value of the '{@link #getDelivery() <em>Delivery</em>}' reference.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getDelivery()
   * @generated
   * @ordered
   */
  protected Delivery delivery;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected MergeImpl()
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
    return ProjectPackage.Literals.MERGE;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Stream getStream()
  {
    if (eContainerFeatureID != ProjectPackage.MERGE__STREAM)
      return null;
    return (Stream)eContainer();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Stream basicGetStream()
  {
    if (eContainerFeatureID != ProjectPackage.MERGE__STREAM)
      return null;
    return (Stream)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStream(Stream newStream, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newStream, ProjectPackage.MERGE__STREAM, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setStream(Stream newStream)
  {
    if (newStream != eInternalContainer() || (eContainerFeatureID != ProjectPackage.MERGE__STREAM && newStream != null))
    {
      if (EcoreUtil.isAncestor(this, newStream))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newStream != null)
        msgs = ((InternalEObject)newStream).eInverseAdd(this, ProjectPackage.STREAM__MERGES, Stream.class, msgs);
      msgs = basicSetStream(newStream, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.MERGE__STREAM, newStream, newStream));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Date getDate()
  {
    return date;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setDate(Date newDate)
  {
    Date oldDate = date;
    date = newDate;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.MERGE__DATE, oldDate, date));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Delivery getDelivery()
  {
    if (delivery != null && delivery.eIsProxy())
    {
      InternalEObject oldDelivery = (InternalEObject)delivery;
      delivery = (Delivery)eResolveProxy(oldDelivery);
      if (delivery != oldDelivery)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProjectPackage.MERGE__DELIVERY, oldDelivery,
              delivery));
      }
    }
    return delivery;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Delivery basicGetDelivery()
  {
    return delivery;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDelivery(Delivery newDelivery, NotificationChain msgs)
  {
    Delivery oldDelivery = delivery;
    delivery = newDelivery;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProjectPackage.MERGE__DELIVERY,
          oldDelivery, newDelivery);
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
  public void setDelivery(Delivery newDelivery)
  {
    if (newDelivery != delivery)
    {
      NotificationChain msgs = null;
      if (delivery != null)
        msgs = ((InternalEObject)delivery).eInverseRemove(this, ProjectPackage.DELIVERY__MERGES, Delivery.class, msgs);
      if (newDelivery != null)
        msgs = ((InternalEObject)newDelivery).eInverseAdd(this, ProjectPackage.DELIVERY__MERGES, Delivery.class, msgs);
      msgs = basicSetDelivery(newDelivery, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.MERGE__DELIVERY, newDelivery, newDelivery));
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
    case ProjectPackage.MERGE__STREAM:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetStream((Stream)otherEnd, msgs);
    case ProjectPackage.MERGE__DELIVERY:
      if (delivery != null)
        msgs = ((InternalEObject)delivery).eInverseRemove(this, ProjectPackage.DELIVERY__MERGES, Delivery.class, msgs);
      return basicSetDelivery((Delivery)otherEnd, msgs);
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
    case ProjectPackage.MERGE__STREAM:
      return basicSetStream(null, msgs);
    case ProjectPackage.MERGE__DELIVERY:
      return basicSetDelivery(null, msgs);
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
    case ProjectPackage.MERGE__STREAM:
      return eInternalContainer().eInverseRemove(this, ProjectPackage.STREAM__MERGES, Stream.class, msgs);
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
    case ProjectPackage.MERGE__STREAM:
      if (resolve)
        return getStream();
      return basicGetStream();
    case ProjectPackage.MERGE__DATE:
      return getDate();
    case ProjectPackage.MERGE__DELIVERY:
      if (resolve)
        return getDelivery();
      return basicGetDelivery();
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
    case ProjectPackage.MERGE__STREAM:
      setStream((Stream)newValue);
      return;
    case ProjectPackage.MERGE__DATE:
      setDate((Date)newValue);
      return;
    case ProjectPackage.MERGE__DELIVERY:
      setDelivery((Delivery)newValue);
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
    case ProjectPackage.MERGE__STREAM:
      setStream((Stream)null);
      return;
    case ProjectPackage.MERGE__DATE:
      setDate(DATE_EDEFAULT);
      return;
    case ProjectPackage.MERGE__DELIVERY:
      setDelivery((Delivery)null);
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
    case ProjectPackage.MERGE__STREAM:
      return basicGetStream() != null;
    case ProjectPackage.MERGE__DATE:
      return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
    case ProjectPackage.MERGE__DELIVERY:
      return delivery != null;
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
    result.append(" (date: "); //$NON-NLS-1$
    result.append(date);
    result.append(')');
    return result.toString();
  }

} // MergeImpl
