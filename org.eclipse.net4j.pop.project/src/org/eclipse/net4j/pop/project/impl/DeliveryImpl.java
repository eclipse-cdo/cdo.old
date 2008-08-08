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
 * $Id: DeliveryImpl.java,v 1.1 2008-08-08 10:10:30 estepper Exp $
 */
package org.eclipse.net4j.pop.project.impl;

import org.eclipse.net4j.pop.project.Delivery;
import org.eclipse.net4j.pop.project.Merge;
import org.eclipse.net4j.pop.project.ProjectPackage;
import org.eclipse.net4j.pop.project.TaskStream;

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
import java.util.Date;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Delivery</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.DeliveryImpl#getStream <em>Stream</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.DeliveryImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.DeliveryImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.DeliveryImpl#getMerges <em>Merges</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeliveryImpl extends TaggedElementImpl implements Delivery
{
  /**
   * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getNumber()
   * @generated
   * @ordered
   */
  protected static final int NUMBER_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @see #getNumber()
   * @generated
   * @ordered
   */
  protected int number = NUMBER_EDEFAULT;

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
   * The cached value of the '{@link #getMerges() <em>Merges</em>}' reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getMerges()
   * @generated
   * @ordered
   */
  protected EList<Merge> merges;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected DeliveryImpl()
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
    return ProjectPackage.Literals.DELIVERY;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public TaskStream getStream()
  {
    if (eContainerFeatureID != ProjectPackage.DELIVERY__STREAM)
      return null;
    return (TaskStream)eContainer();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public TaskStream basicGetStream()
  {
    if (eContainerFeatureID != ProjectPackage.DELIVERY__STREAM)
      return null;
    return (TaskStream)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStream(TaskStream newStream, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newStream, ProjectPackage.DELIVERY__STREAM, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setStream(TaskStream newStream)
  {
    if (newStream != eInternalContainer()
        || (eContainerFeatureID != ProjectPackage.DELIVERY__STREAM && newStream != null))
    {
      if (EcoreUtil.isAncestor(this, newStream))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newStream != null)
        msgs = ((InternalEObject)newStream).eInverseAdd(this, ProjectPackage.TASK_STREAM__DELIVERIES, TaskStream.class,
            msgs);
      msgs = basicSetStream(newStream, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.DELIVERY__STREAM, newStream, newStream));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public int getNumber()
  {
    return number;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setNumber(int newNumber)
  {
    int oldNumber = number;
    number = newNumber;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.DELIVERY__NUMBER, oldNumber, number));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.DELIVERY__DATE, oldDate, date));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList<Merge> getMerges()
  {
    if (merges == null)
    {
      merges = new EObjectWithInverseResolvingEList<Merge>(Merge.class, this, ProjectPackage.DELIVERY__MERGES,
          ProjectPackage.MERGE__DELIVERY);
    }
    return merges;
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
    case ProjectPackage.DELIVERY__STREAM:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetStream((TaskStream)otherEnd, msgs);
    case ProjectPackage.DELIVERY__MERGES:
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
    case ProjectPackage.DELIVERY__STREAM:
      return basicSetStream(null, msgs);
    case ProjectPackage.DELIVERY__MERGES:
      return ((InternalEList<?>)getMerges()).basicRemove(otherEnd, msgs);
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
    case ProjectPackage.DELIVERY__STREAM:
      return eInternalContainer().eInverseRemove(this, ProjectPackage.TASK_STREAM__DELIVERIES, TaskStream.class, msgs);
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
    case ProjectPackage.DELIVERY__STREAM:
      if (resolve)
        return getStream();
      return basicGetStream();
    case ProjectPackage.DELIVERY__NUMBER:
      return new Integer(getNumber());
    case ProjectPackage.DELIVERY__DATE:
      return getDate();
    case ProjectPackage.DELIVERY__MERGES:
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
    case ProjectPackage.DELIVERY__STREAM:
      setStream((TaskStream)newValue);
      return;
    case ProjectPackage.DELIVERY__NUMBER:
      setNumber(((Integer)newValue).intValue());
      return;
    case ProjectPackage.DELIVERY__DATE:
      setDate((Date)newValue);
      return;
    case ProjectPackage.DELIVERY__MERGES:
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
    case ProjectPackage.DELIVERY__STREAM:
      setStream((TaskStream)null);
      return;
    case ProjectPackage.DELIVERY__NUMBER:
      setNumber(NUMBER_EDEFAULT);
      return;
    case ProjectPackage.DELIVERY__DATE:
      setDate(DATE_EDEFAULT);
      return;
    case ProjectPackage.DELIVERY__MERGES:
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
    case ProjectPackage.DELIVERY__STREAM:
      return basicGetStream() != null;
    case ProjectPackage.DELIVERY__NUMBER:
      return number != NUMBER_EDEFAULT;
    case ProjectPackage.DELIVERY__DATE:
      return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
    case ProjectPackage.DELIVERY__MERGES:
      return merges != null && !merges.isEmpty();
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
    result.append(" (number: "); //$NON-NLS-1$
    result.append(number);
    result.append(", date: "); //$NON-NLS-1$
    result.append(date);
    result.append(')');
    return result.toString();
  }

} // DeliveryImpl
