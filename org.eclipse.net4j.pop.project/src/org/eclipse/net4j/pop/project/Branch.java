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
 * $Id: Branch.java,v 1.1 2008-08-08 10:10:38 estepper Exp $
 */
package org.eclipse.net4j.pop.project;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Branch</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.project.Branch#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.Branch#getBranches <em>Branches</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.Branch#getTags <em>Tags</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.Branch#getStream <em>Stream</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.pop.project.ProjectPackage#getBranch()
 * @model abstract="true"
 * @generated
 */
public interface Branch extends CheckoutDiscriminator
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getBranch_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.Branch#getName <em>Name</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Branches</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.net4j.pop.project.SubBranch}.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.SubBranch#getParent <em>Parent</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Branches</em>' containment reference list isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Branches</em>' containment reference list.
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getBranch_Branches()
   * @see org.eclipse.net4j.pop.project.SubBranch#getParent
   * @model opposite="parent" containment="true" resolveProxies="true"
   * @generated
   */
  EList<SubBranch> getBranches();

  /**
   * Returns the value of the '<em><b>Tags</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.net4j.pop.project.Tag}.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.Tag#getBranch <em>Branch</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tags</em>' containment reference list isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tags</em>' containment reference list.
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getBranch_Tags()
   * @see org.eclipse.net4j.pop.project.Tag#getBranch
   * @model opposite="branch" containment="true" resolveProxies="true"
   * @generated
   */
  EList<Tag> getTags();

  /**
   * Returns the value of the '<em><b>Stream</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.Stream#getBranch <em>Branch</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stream</em>' reference isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stream</em>' reference.
   * @see #setStream(Stream)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getBranch_Stream()
   * @see org.eclipse.net4j.pop.project.Stream#getBranch
   * @model opposite="branch"
   * @generated
   */
  Stream getStream();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.Branch#getStream <em>Stream</em>}' reference. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Stream</em>' reference.
   * @see #getStream()
   * @generated
   */
  void setStream(Stream value);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
  MainBranch getMainBranch();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model kind="operation"
   * @generated
   */
  Branch getParent();

} // Branch
