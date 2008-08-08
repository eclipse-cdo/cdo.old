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
 * $Id: PopProject.java,v 1.1 2008-08-08 10:10:38 estepper Exp $
 */
package org.eclipse.net4j.pop.project;

import org.eclipse.net4j.pop.base.PopElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Pop Project</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.project.PopProject#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.PopProject#getRepository <em>Repository</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.PopProject#getRootStream <em>Root Stream</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.PopProject#getCheckouts <em>Checkouts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.pop.project.ProjectPackage#getPopProject()
 * @model
 * @generated
 */
public interface PopProject extends PopElement
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
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getPopProject_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.PopProject#getName <em>Name</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Repository</b></em>' containment reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.Repository#getPopProject <em>Pop Project</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Repository</em>' containment reference isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Repository</em>' containment reference.
   * @see #setRepository(Repository)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getPopProject_Repository()
   * @see org.eclipse.net4j.pop.project.Repository#getPopProject
   * @model opposite="popProject" containment="true" resolveProxies="true" required="true"
   * @generated
   */
  Repository getRepository();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.PopProject#getRepository <em>Repository</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Repository</em>' containment reference.
   * @see #getRepository()
   * @generated
   */
  void setRepository(Repository value);

  /**
   * Returns the value of the '<em><b>Root Stream</b></em>' containment reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.RootStream#getPopProject <em>Pop Project</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Root Stream</em>' reference isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Root Stream</em>' containment reference.
   * @see #setRootStream(RootStream)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getPopProject_RootStream()
   * @see org.eclipse.net4j.pop.project.RootStream#getPopProject
   * @model opposite="popProject" containment="true" resolveProxies="true" required="true"
   * @generated
   */
  RootStream getRootStream();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.PopProject#getRootStream <em>Root Stream</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Root Stream</em>' containment reference.
   * @see #getRootStream()
   * @generated
   */
  void setRootStream(RootStream value);

  /**
   * Returns the value of the '<em><b>Checkouts</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.net4j.pop.project.Checkout}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Checkouts</em>' reference list isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Checkouts</em>' reference list.
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getPopProject_Checkouts()
   * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */
  EList<Checkout> getCheckouts();

} // PopProject
