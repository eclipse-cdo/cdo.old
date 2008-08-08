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
 * $Id: Release.java,v 1.1 2008-08-08 10:10:38 estepper Exp $
 */
package org.eclipse.net4j.pop.project;

import org.eclipse.net4j.pop.base.Version;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Release</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.project.Release#getMaintenance <em>Maintenance</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.Release#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.Release#getStream <em>Stream</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.Release#getMilestones <em>Milestones</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.pop.project.ProjectPackage#getRelease()
 * @model
 * @generated
 */
public interface Release extends Target
{
  /**
   * Returns the value of the '<em><b>Maintenance</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.MaintenanceStream#getBaseline <em>Baseline</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Maintenance</em>' reference isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Maintenance</em>' reference.
   * @see #setMaintenance(MaintenanceStream)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getRelease_Maintenance()
   * @see org.eclipse.net4j.pop.project.MaintenanceStream#getBaseline
   * @model opposite="baseline"
   * @generated
   */
  MaintenanceStream getMaintenance();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.Release#getMaintenance <em>Maintenance</em>}' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Maintenance</em>' reference.
   * @see #getMaintenance()
   * @generated
   */
  void setMaintenance(MaintenanceStream value);

  /**
   * Returns the value of the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Version</em>' attribute isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Version</em>' attribute.
   * @see #setVersion(Version)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getRelease_Version()
   * @model dataType="org.eclipse.net4j.pop.base.Version" required="true"
   * @generated
   */
  Version getVersion();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.Release#getVersion <em>Version</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Version</em>' attribute.
   * @see #getVersion()
   * @generated
   */
  void setVersion(Version value);

  /**
   * Returns the value of the '<em><b>Stream</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.IntegrationStream#getReleases <em>Releases</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stream</em>' container reference isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stream</em>' container reference.
   * @see #setStream(IntegrationStream)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getRelease_Stream()
   * @see org.eclipse.net4j.pop.project.IntegrationStream#getReleases
   * @model opposite="releases" required="true" transient="false"
   * @generated
   */
  IntegrationStream getStream();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.Release#getStream <em>Stream</em>}' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Stream</em>' container reference.
   * @see #getStream()
   * @generated
   */
  void setStream(IntegrationStream value);

  /**
   * Returns the value of the '<em><b>Milestones</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.net4j.pop.project.Milestone}.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.Milestone#getRelease <em>Release</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Milestones</em>' containment reference list isn't clear, there really should be more of
   * a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Milestones</em>' containment reference list.
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getRelease_Milestones()
   * @see org.eclipse.net4j.pop.project.Milestone#getRelease
   * @model opposite="release" containment="true" resolveProxies="true"
   * @generated
   */
  EList<Milestone> getMilestones();

} // Release
