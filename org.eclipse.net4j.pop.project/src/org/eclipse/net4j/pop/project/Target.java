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
 * $Id: Target.java,v 1.1 2008-08-08 10:10:38 estepper Exp $
 */
package org.eclipse.net4j.pop.project;

import org.eclipse.emf.common.util.EList;

import java.util.Date;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Target</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.project.Target#getDate <em>Date</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.Target#getStreams <em>Streams</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.pop.project.ProjectPackage#getTarget()
 * @model abstract="true"
 * @generated
 */
public interface Target extends TaggedElement
{
  /**
   * Returns the value of the '<em><b>Date</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Date</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Date</em>' attribute.
   * @see #setDate(Date)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getTarget_Date()
   * @model
   * @generated
   */
  Date getDate();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.Target#getDate <em>Date</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Date</em>' attribute.
   * @see #getDate()
   * @generated
   */
  void setDate(Date value);

  /**
   * Returns the value of the '<em><b>Streams</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.net4j.pop.project.TaskStream}.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.TaskStream#getTargets <em>Targets</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Streams</em>' reference list isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Streams</em>' reference list.
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getTarget_Streams()
   * @see org.eclipse.net4j.pop.project.TaskStream#getTargets
   * @model opposite="targets"
   * @generated
   */
  EList<TaskStream> getStreams();

} // Target
