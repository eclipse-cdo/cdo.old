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
 * $Id: MaintenanceStreamImpl.java,v 1.1 2008-08-08 10:10:30 estepper Exp $
 */
package org.eclipse.net4j.pop.project.impl;

import org.eclipse.net4j.pop.project.DevelopmentStream;
import org.eclipse.net4j.pop.project.MaintenanceStream;
import org.eclipse.net4j.pop.project.PopProject;
import org.eclipse.net4j.pop.project.ProjectPackage;
import org.eclipse.net4j.pop.project.Release;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Maintenance Stream</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.net4j.pop.project.impl.MaintenanceStreamImpl#getParent <em>Parent</em>}</li>
 * <li>{@link org.eclipse.net4j.pop.project.impl.MaintenanceStreamImpl#getBaseline <em>Baseline</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MaintenanceStreamImpl extends IntegrationStreamImpl implements MaintenanceStream
{
  /**
   * The cached value of the '{@link #getBaseline() <em>Baseline</em>}' reference.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getBaseline()
   * @generated
   * @ordered
   */
  protected Release baseline;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected MaintenanceStreamImpl()
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
    return ProjectPackage.Literals.MAINTENANCE_STREAM;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DevelopmentStream getParent()
  {
    if (eContainerFeatureID != ProjectPackage.MAINTENANCE_STREAM__PARENT)
      return null;
    return (DevelopmentStream)eContainer();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public DevelopmentStream basicGetParent()
  {
    if (eContainerFeatureID != ProjectPackage.MAINTENANCE_STREAM__PARENT)
      return null;
    return (DevelopmentStream)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParent(DevelopmentStream newParent, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newParent, ProjectPackage.MAINTENANCE_STREAM__PARENT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setParent(DevelopmentStream newParent)
  {
    if (newParent != eInternalContainer()
        || (eContainerFeatureID != ProjectPackage.MAINTENANCE_STREAM__PARENT && newParent != null))
    {
      if (EcoreUtil.isAncestor(this, newParent))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newParent != null)
        msgs = ((InternalEObject)newParent).eInverseAdd(this, ProjectPackage.DEVELOPMENT_STREAM__MAINTENANCE_STREAMS,
            DevelopmentStream.class, msgs);
      msgs = basicSetParent(newParent, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.MAINTENANCE_STREAM__PARENT, newParent,
          newParent));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Release getBaseline()
  {
    if (baseline != null && baseline.eIsProxy())
    {
      InternalEObject oldBaseline = (InternalEObject)baseline;
      baseline = (Release)eResolveProxy(oldBaseline);
      if (baseline != oldBaseline)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProjectPackage.MAINTENANCE_STREAM__BASELINE,
              oldBaseline, baseline));
      }
    }
    return baseline;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Release basicGetBaseline()
  {
    return baseline;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBaseline(Release newBaseline, NotificationChain msgs)
  {
    Release oldBaseline = baseline;
    baseline = newBaseline;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
          ProjectPackage.MAINTENANCE_STREAM__BASELINE, oldBaseline, newBaseline);
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
  public void setBaseline(Release newBaseline)
  {
    if (newBaseline != baseline)
    {
      NotificationChain msgs = null;
      if (baseline != null)
        msgs = ((InternalEObject)baseline).eInverseRemove(this, ProjectPackage.RELEASE__MAINTENANCE, Release.class,
            msgs);
      if (newBaseline != null)
        msgs = ((InternalEObject)newBaseline).eInverseAdd(this, ProjectPackage.RELEASE__MAINTENANCE, Release.class,
            msgs);
      msgs = basicSetBaseline(newBaseline, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.MAINTENANCE_STREAM__BASELINE, newBaseline,
          newBaseline));
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
    case ProjectPackage.MAINTENANCE_STREAM__PARENT:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetParent((DevelopmentStream)otherEnd, msgs);
    case ProjectPackage.MAINTENANCE_STREAM__BASELINE:
      if (baseline != null)
        msgs = ((InternalEObject)baseline).eInverseRemove(this, ProjectPackage.RELEASE__MAINTENANCE, Release.class,
            msgs);
      return basicSetBaseline((Release)otherEnd, msgs);
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
    case ProjectPackage.MAINTENANCE_STREAM__PARENT:
      return basicSetParent(null, msgs);
    case ProjectPackage.MAINTENANCE_STREAM__BASELINE:
      return basicSetBaseline(null, msgs);
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
    case ProjectPackage.MAINTENANCE_STREAM__PARENT:
      return eInternalContainer().eInverseRemove(this, ProjectPackage.DEVELOPMENT_STREAM__MAINTENANCE_STREAMS,
          DevelopmentStream.class, msgs);
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
    case ProjectPackage.MAINTENANCE_STREAM__PARENT:
      if (resolve)
        return getParent();
      return basicGetParent();
    case ProjectPackage.MAINTENANCE_STREAM__BASELINE:
      if (resolve)
        return getBaseline();
      return basicGetBaseline();
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
    case ProjectPackage.MAINTENANCE_STREAM__PARENT:
      setParent((DevelopmentStream)newValue);
      return;
    case ProjectPackage.MAINTENANCE_STREAM__BASELINE:
      setBaseline((Release)newValue);
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
    case ProjectPackage.MAINTENANCE_STREAM__PARENT:
      setParent((DevelopmentStream)null);
      return;
    case ProjectPackage.MAINTENANCE_STREAM__BASELINE:
      setBaseline((Release)null);
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
    case ProjectPackage.MAINTENANCE_STREAM__PARENT:
      return basicGetParent() != null;
    case ProjectPackage.MAINTENANCE_STREAM__BASELINE:
      return baseline != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * @ADDED
   */
  @Override
  public PopProject getPopProject()
  {
    return getParent().getPopProject();
  }

} // MaintenanceStreamImpl
