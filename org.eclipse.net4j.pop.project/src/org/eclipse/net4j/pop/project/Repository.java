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
 * $Id: Repository.java,v 1.1 2008-08-08 10:10:38 estepper Exp $
 */
package org.eclipse.net4j.pop.project;

import org.eclipse.net4j.pop.base.PopElement;
import org.eclipse.net4j.pop.repository.IRepositoryAdapter;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Repository</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.project.Repository#getPopProject <em>Pop Project</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.Repository#getAdapter <em>Adapter</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.Repository#getAdapterType <em>Adapter Type</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.Repository#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.Repository#getMainBranch <em>Main Branch</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.Repository#getPrimaryModule <em>Primary Module</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.Repository#getCommitters <em>Committers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.pop.project.ProjectPackage#getRepository()
 * @model
 * @generated
 */
public interface Repository extends PopElement
{
  /**
   * Returns the value of the '<em><b>Pop Project</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.PopProject#getRepository <em>Repository</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pop Project</em>' reference isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pop Project</em>' container reference.
   * @see #setPopProject(PopProject)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getRepository_PopProject()
   * @see org.eclipse.net4j.pop.project.PopProject#getRepository
   * @model opposite="repository" required="true" transient="false"
   * @generated
   */
  PopProject getPopProject();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.Repository#getPopProject <em>Pop Project</em>}' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Pop Project</em>' container reference.
   * @see #getPopProject()
   * @generated
   */
  void setPopProject(PopProject value);

  /**
   * Returns the value of the '<em><b>Adapter</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Adapter</em>' attribute isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Adapter</em>' attribute.
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getRepository_Adapter()
   * @model dataType="org.eclipse.net4j.pop.base.RepositoryAdapter" required="true" transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */
  IRepositoryAdapter getAdapter();

  /**
   * Returns the value of the '<em><b>Adapter Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Adapter Type</em>' attribute isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Adapter Type</em>' attribute.
   * @see #setAdapterType(String)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getRepository_AdapterType()
   * @model required="true"
   * @generated
   */
  String getAdapterType();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.Repository#getAdapterType <em>Adapter Type</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Adapter Type</em>' attribute.
   * @see #getAdapterType()
   * @generated
   */
  void setAdapterType(String value);

  /**
   * Returns the value of the '<em><b>Descriptor</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Descriptor</em>' attribute isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Descriptor</em>' attribute.
   * @see #setDescriptor(String)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getRepository_Descriptor()
   * @model required="true"
   * @generated
   */
  String getDescriptor();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.Repository#getDescriptor <em>Descriptor</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Descriptor</em>' attribute.
   * @see #getDescriptor()
   * @generated
   */
  void setDescriptor(String value);

  /**
   * Returns the value of the '<em><b>Primary Module</b></em>' containment reference. It is bidirectional and its
   * opposite is '{@link org.eclipse.net4j.pop.project.PrimaryModule#getRepository <em>Repository</em>}'. <!--
   * begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Primary Module</em>' containment reference isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Primary Module</em>' containment reference.
   * @see #setPrimaryModule(PrimaryModule)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getRepository_PrimaryModule()
   * @see org.eclipse.net4j.pop.project.PrimaryModule#getRepository
   * @model opposite="repository" containment="true" resolveProxies="true" required="true"
   * @generated
   */
  PrimaryModule getPrimaryModule();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.Repository#getPrimaryModule <em>Primary Module</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Primary Module</em>' containment reference.
   * @see #getPrimaryModule()
   * @generated
   */
  void setPrimaryModule(PrimaryModule value);

  /**
   * Returns the value of the '<em><b>Committers</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.net4j.pop.project.Committer}.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.Committer#getRepository <em>Repository</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Committers</em>' containment reference list isn't clear, there really should be more of
   * a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Committers</em>' containment reference list.
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getRepository_Committers()
   * @see org.eclipse.net4j.pop.project.Committer#getRepository
   * @model opposite="repository" containment="true" resolveProxies="true" required="true"
   * @generated
   */
  EList<Committer> getCommitters();

  /**
   * Returns the value of the '<em><b>Main Branch</b></em>' containment reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.MainBranch#getRepository <em>Repository</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Main Branch</em>' containment reference isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Main Branch</em>' containment reference.
   * @see #setMainBranch(MainBranch)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getRepository_MainBranch()
   * @see org.eclipse.net4j.pop.project.MainBranch#getRepository
   * @model opposite="repository" containment="true" resolveProxies="true" required="true"
   * @generated
   */
  MainBranch getMainBranch();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.Repository#getMainBranch <em>Main Branch</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Main Branch</em>' containment reference.
   * @see #getMainBranch()
   * @generated
   */
  void setMainBranch(MainBranch value);

} // Repository
