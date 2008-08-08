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
 * $Id: ReleaseImpl.java,v 1.1 2008-08-08 10:10:30 estepper Exp $
 */
package org.eclipse.net4j.pop.project.impl;

import org.eclipse.net4j.pop.base.Version;
import org.eclipse.net4j.pop.project.IntegrationStream;
import org.eclipse.net4j.pop.project.MaintenanceStream;
import org.eclipse.net4j.pop.project.Milestone;
import org.eclipse.net4j.pop.project.ProjectPackage;
import org.eclipse.net4j.pop.project.Release;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import java.util.Collection;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Release</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.ReleaseImpl#getMaintenance <em>Maintenance</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.ReleaseImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.ReleaseImpl#getStream <em>Stream</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.impl.ReleaseImpl#getMilestones <em>Milestones</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReleaseImpl extends TargetImpl implements Release
{
  /**
   * The cached value of the '{@link #getMaintenance() <em>Maintenance</em>}' reference.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getMaintenance()
   * @generated
   * @ordered
   */
  protected MaintenanceStream maintenance;

  /**
   * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getVersion()
   * @generated
   * @ordered
   */
  protected static final Version VERSION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getVersion()
   * @generated
   * @ordered
   */
  protected Version version = VERSION_EDEFAULT;

  /**
   * The cached value of the '{@link #getMilestones() <em>Milestones</em>}' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getMilestones()
   * @generated
   * @ordered
   */
  protected EList<Milestone> milestones;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected ReleaseImpl()
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
    return ProjectPackage.Literals.RELEASE;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public MaintenanceStream getMaintenance()
  {
    if (maintenance != null && maintenance.eIsProxy())
    {
      InternalEObject oldMaintenance = (InternalEObject)maintenance;
      maintenance = (MaintenanceStream)eResolveProxy(oldMaintenance);
      if (maintenance != oldMaintenance)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProjectPackage.RELEASE__MAINTENANCE,
              oldMaintenance, maintenance));
      }
    }
    return maintenance;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public MaintenanceStream basicGetMaintenance()
  {
    return maintenance;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMaintenance(MaintenanceStream newMaintenance, NotificationChain msgs)
  {
    MaintenanceStream oldMaintenance = maintenance;
    maintenance = newMaintenance;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
          ProjectPackage.RELEASE__MAINTENANCE, oldMaintenance, newMaintenance);
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
  public void setMaintenance(MaintenanceStream newMaintenance)
  {
    if (newMaintenance != maintenance)
    {
      NotificationChain msgs = null;
      if (maintenance != null)
        msgs = ((InternalEObject)maintenance).eInverseRemove(this, ProjectPackage.MAINTENANCE_STREAM__BASELINE,
            MaintenanceStream.class, msgs);
      if (newMaintenance != null)
        msgs = ((InternalEObject)newMaintenance).eInverseAdd(this, ProjectPackage.MAINTENANCE_STREAM__BASELINE,
            MaintenanceStream.class, msgs);
      msgs = basicSetMaintenance(newMaintenance, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.RELEASE__MAINTENANCE, newMaintenance,
          newMaintenance));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Version getVersion()
  {
    return version;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setVersion(Version newVersion)
  {
    Version oldVersion = version;
    version = newVersion;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.RELEASE__VERSION, oldVersion, version));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public IntegrationStream getStream()
  {
    if (eContainerFeatureID != ProjectPackage.RELEASE__STREAM)
      return null;
    return (IntegrationStream)eContainer();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public IntegrationStream basicGetStream()
  {
    if (eContainerFeatureID != ProjectPackage.RELEASE__STREAM)
      return null;
    return (IntegrationStream)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStream(IntegrationStream newStream, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newStream, ProjectPackage.RELEASE__STREAM, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setStream(IntegrationStream newStream)
  {
    if (newStream != eInternalContainer()
        || (eContainerFeatureID != ProjectPackage.RELEASE__STREAM && newStream != null))
    {
      if (EcoreUtil.isAncestor(this, newStream))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newStream != null)
        msgs = ((InternalEObject)newStream).eInverseAdd(this, ProjectPackage.INTEGRATION_STREAM__RELEASES,
            IntegrationStream.class, msgs);
      msgs = basicSetStream(newStream, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProjectPackage.RELEASE__STREAM, newStream, newStream));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList<Milestone> getMilestones()
  {
    if (milestones == null)
    {
      milestones = new EObjectContainmentWithInverseEList.Resolving<Milestone>(Milestone.class, this,
          ProjectPackage.RELEASE__MILESTONES, ProjectPackage.MILESTONE__RELEASE);
    }
    return milestones;
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
    case ProjectPackage.RELEASE__MAINTENANCE:
      if (maintenance != null)
        msgs = ((InternalEObject)maintenance).eInverseRemove(this, ProjectPackage.MAINTENANCE_STREAM__BASELINE,
            MaintenanceStream.class, msgs);
      return basicSetMaintenance((MaintenanceStream)otherEnd, msgs);
    case ProjectPackage.RELEASE__STREAM:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetStream((IntegrationStream)otherEnd, msgs);
    case ProjectPackage.RELEASE__MILESTONES:
      return ((InternalEList<InternalEObject>)(InternalEList<?>)getMilestones()).basicAdd(otherEnd, msgs);
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
    case ProjectPackage.RELEASE__MAINTENANCE:
      return basicSetMaintenance(null, msgs);
    case ProjectPackage.RELEASE__STREAM:
      return basicSetStream(null, msgs);
    case ProjectPackage.RELEASE__MILESTONES:
      return ((InternalEList<?>)getMilestones()).basicRemove(otherEnd, msgs);
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
    case ProjectPackage.RELEASE__STREAM:
      return eInternalContainer().eInverseRemove(this, ProjectPackage.INTEGRATION_STREAM__RELEASES,
          IntegrationStream.class, msgs);
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
    case ProjectPackage.RELEASE__MAINTENANCE:
      if (resolve)
        return getMaintenance();
      return basicGetMaintenance();
    case ProjectPackage.RELEASE__VERSION:
      return getVersion();
    case ProjectPackage.RELEASE__STREAM:
      if (resolve)
        return getStream();
      return basicGetStream();
    case ProjectPackage.RELEASE__MILESTONES:
      return getMilestones();
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
    case ProjectPackage.RELEASE__MAINTENANCE:
      setMaintenance((MaintenanceStream)newValue);
      return;
    case ProjectPackage.RELEASE__VERSION:
      setVersion((Version)newValue);
      return;
    case ProjectPackage.RELEASE__STREAM:
      setStream((IntegrationStream)newValue);
      return;
    case ProjectPackage.RELEASE__MILESTONES:
      getMilestones().clear();
      getMilestones().addAll((Collection<? extends Milestone>)newValue);
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
    case ProjectPackage.RELEASE__MAINTENANCE:
      setMaintenance((MaintenanceStream)null);
      return;
    case ProjectPackage.RELEASE__VERSION:
      setVersion(VERSION_EDEFAULT);
      return;
    case ProjectPackage.RELEASE__STREAM:
      setStream((IntegrationStream)null);
      return;
    case ProjectPackage.RELEASE__MILESTONES:
      getMilestones().clear();
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
    case ProjectPackage.RELEASE__MAINTENANCE:
      return maintenance != null;
    case ProjectPackage.RELEASE__VERSION:
      return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
    case ProjectPackage.RELEASE__STREAM:
      return basicGetStream() != null;
    case ProjectPackage.RELEASE__MILESTONES:
      return milestones != null && !milestones.isEmpty();
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
    result.append(" (version: "); //$NON-NLS-1$
    result.append(version);
    result.append(')');
    return result.toString();
  }

} // ReleaseImpl
