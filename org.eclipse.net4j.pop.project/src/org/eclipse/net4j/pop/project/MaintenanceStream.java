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
 * $Id: MaintenanceStream.java,v 1.1 2008-08-08 10:10:38 estepper Exp $
 */
package org.eclipse.net4j.pop.project;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Maintenance Stream</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.net4j.pop.project.MaintenanceStream#getParent <em>Parent</em>}</li>
 * <li>{@link org.eclipse.net4j.pop.project.MaintenanceStream#getBaseline <em>Baseline</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.net4j.pop.project.ProjectPackage#getMaintenanceStream()
 * @model
 * @generated
 */
public interface MaintenanceStream extends IntegrationStream
{
  /**
   * Returns the value of the '<em><b>Parent</b></em>' reference. It is bidirectional and its opposite is '
   * {@link org.eclipse.net4j.pop.project.DevelopmentStream#getMaintenanceStreams <em>Maintenance Streams</em>}'. <!--
   * begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parent</em>' reference isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Parent</em>' reference.
   * @see #setParent(DevelopmentStream)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getMaintenanceStream_Parent()
   * @see org.eclipse.net4j.pop.project.DevelopmentStream#getMaintenanceStreams
   * @model opposite="maintenanceStreams" required="true"
   * @generated
   */
  DevelopmentStream getParent();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.MaintenanceStream#getParent <em>Parent</em>}' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Parent</em>' container reference.
   * @see #getParent()
   * @generated
   */
  void setParent(DevelopmentStream value);

  /**
   * Returns the value of the '<em><b>Baseline</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.Release#getMaintenance <em>Maintenance</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Baseline</em>' reference isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Baseline</em>' reference.
   * @see #setBaseline(Release)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getMaintenanceStream_Baseline()
   * @see org.eclipse.net4j.pop.project.Release#getMaintenance
   * @model opposite="maintenance" required="true"
   * @generated
   */
  Release getBaseline();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.MaintenanceStream#getBaseline <em>Baseline</em>}' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Baseline</em>' reference.
   * @see #getBaseline()
   * @generated
   */
  void setBaseline(Release value);

} // MaintenanceStream
