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
 * $Id: MainBranch.java,v 1.1 2008-08-08 10:10:38 estepper Exp $
 */
package org.eclipse.net4j.pop.project;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Main Branch</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.project.MainBranch#getRepository <em>Repository</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.pop.project.ProjectPackage#getMainBranch()
 * @model
 * @generated
 */
public interface MainBranch extends Branch
{
  /**
   * Returns the value of the '<em><b>Repository</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.Repository#getMainBranch <em>Main Branch</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Repository</em>' container reference isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Repository</em>' container reference.
   * @see #setRepository(Repository)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getMainBranch_Repository()
   * @see org.eclipse.net4j.pop.project.Repository#getMainBranch
   * @model opposite="mainBranch" required="true" transient="false"
   * @generated
   */
  Repository getRepository();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.MainBranch#getRepository <em>Repository</em>}' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Repository</em>' container reference.
   * @see #getRepository()
   * @generated
   */
  void setRepository(Repository value);

} // MainBranch
