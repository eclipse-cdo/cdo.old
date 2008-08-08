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
 * $Id: WorkspaceConfigurator.java,v 1.1 2008-08-08 10:10:38 estepper Exp $
 */
package org.eclipse.net4j.pop.product;

import org.eclipse.net4j.pop.base.PopElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Workspace Configurator</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.product.WorkspaceConfigurator#getPopProject <em>Pop Project</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.product.WorkspaceConfigurator#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.pop.product.ProductPackage#getWorkspaceConfigurator()
 * @model abstract="true"
 * @generated
 */
public interface WorkspaceConfigurator extends PopElement
{
  /**
   * Returns the value of the '<em><b>Pop Project</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.product.PopProduct#getConfigurators <em>Configurators</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pop Project</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pop Project</em>' container reference.
   * @see #setPopProject(PopProduct)
   * @see org.eclipse.net4j.pop.product.ProductPackage#getWorkspaceConfigurator_PopProject()
   * @see org.eclipse.net4j.pop.product.PopProduct#getConfigurators
   * @model opposite="configurators" required="true" transient="false"
   * @generated
   */
  PopProduct getPopProject();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.product.WorkspaceConfigurator#getPopProject <em>Pop Project</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pop Project</em>' container reference.
   * @see #getPopProject()
   * @generated
   */
  void setPopProject(PopProduct value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.net4j.pop.product.ProductPackage#getWorkspaceConfigurator_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.product.WorkspaceConfigurator#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  void configureWorkspace();

} // WorkspaceConfigurator
