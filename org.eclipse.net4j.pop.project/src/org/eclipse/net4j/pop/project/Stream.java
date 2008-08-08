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
 * $Id: Stream.java,v 1.1 2008-08-08 10:10:38 estepper Exp $
 */
package org.eclipse.net4j.pop.project;

import org.eclipse.net4j.pop.base.PopElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Stream</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.project.Stream#getBranch <em>Branch</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.Stream#getMerges <em>Merges</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.pop.project.ProjectPackage#getStream()
 * @model abstract="true"
 * @generated
 */
public interface Stream extends PopElement
{
  /**
   * Returns the value of the '<em><b>Branch</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.Branch#getStream <em>Stream</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Branch</em>' reference isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Branch</em>' reference.
   * @see #setBranch(Branch)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getStream_Branch()
   * @see org.eclipse.net4j.pop.project.Branch#getStream
   * @model opposite="stream" required="true"
   * @generated
   */
  Branch getBranch();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.Stream#getBranch <em>Branch</em>}' reference. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Branch</em>' reference.
   * @see #getBranch()
   * @generated
   */
  void setBranch(Branch value);

  /**
   * Returns the value of the '<em><b>Merges</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.net4j.pop.project.Merge}.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.Merge#getStream <em>Stream</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Merges</em>' containment reference list isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Merges</em>' containment reference list.
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getStream_Merges()
   * @see org.eclipse.net4j.pop.project.Merge#getStream
   * @model opposite="stream" containment="true" resolveProxies="true"
   * @generated
   */
  EList<Merge> getMerges();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
  PopProject getPopProject();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model kind="operation"
   * @generated
   */
  Stream getParent();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model kind="operation"
   * @generated
   */
  EList<Stream> getStreams();

} // Stream
