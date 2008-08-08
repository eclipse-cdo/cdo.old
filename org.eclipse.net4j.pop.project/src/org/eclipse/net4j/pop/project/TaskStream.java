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
 * $Id: TaskStream.java,v 1.1 2008-08-08 10:10:38 estepper Exp $
 */
package org.eclipse.net4j.pop.project;

import org.eclipse.emf.common.util.EList;

import java.util.Date;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Task Stream</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.project.TaskStream#getTaskId <em>Task Id</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.TaskStream#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.TaskStream#getBaseline <em>Baseline</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.TaskStream#getTargets <em>Targets</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.TaskStream#getDeliveries <em>Deliveries</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.pop.project.ProjectPackage#getTaskStream()
 * @model
 * @generated
 */
public interface TaskStream extends Stream
{
  /**
   * Returns the value of the '<em><b>Task Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Task Id</em>' attribute isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Task Id</em>' attribute.
   * @see #setTaskId(String)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getTaskStream_TaskId()
   * @model required="true"
   * @generated
   */
  String getTaskId();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.TaskStream#getTaskId <em>Task Id</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Task Id</em>' attribute.
   * @see #getTaskId()
   * @generated
   */
  void setTaskId(String value);

  /**
   * Returns the value of the '<em><b>Parent</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.IntegrationStream#getTaskStreams <em>Task Streams</em>}'.
   * <!-- begin-user-doc
   * -->
   * <p>
   * If the meaning of the '<em>Parent</em>' reference isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parent</em>' container reference.
   * @see #setParent(IntegrationStream)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getTaskStream_Parent()
   * @see org.eclipse.net4j.pop.project.IntegrationStream#getTaskStreams
   * @model opposite="taskStreams" required="true" transient="false"
   * @generated
   */
  IntegrationStream getParent();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.TaskStream#getParent <em>Parent</em>}' reference. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Parent</em>' reference.
   * @see #getParent()
   * @generated
   */
  void setParent(IntegrationStream value);

  /**
   * Returns the value of the '<em><b>Baseline</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Baseline</em>' attribute isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Baseline</em>' attribute.
   * @see #setBaseline(Date)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getTaskStream_Baseline()
   * @model required="true"
   * @generated
   */
  Date getBaseline();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.TaskStream#getBaseline <em>Baseline</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Baseline</em>' attribute.
   * @see #getBaseline()
   * @generated
   */
  void setBaseline(Date value);

  /**
   * Returns the value of the '<em><b>Targets</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.net4j.pop.project.Target}.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.Target#getStreams <em>Streams</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Targets</em>' reference list isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Targets</em>' reference list.
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getTaskStream_Targets()
   * @see org.eclipse.net4j.pop.project.Target#getStreams
   * @model opposite="streams" required="true"
   * @generated
   */
  EList<Target> getTargets();

  /**
   * Returns the value of the '<em><b>Deliveries</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.net4j.pop.project.Delivery}.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.Delivery#getStream <em>Stream</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Deliveries</em>' containment reference list isn't clear, there really should be more of
   * a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Deliveries</em>' containment reference list.
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getTaskStream_Deliveries()
   * @see org.eclipse.net4j.pop.project.Delivery#getStream
   * @model opposite="stream" containment="true" resolveProxies="true"
   * @generated
   */
  EList<Delivery> getDeliveries();

} // TaskStream
