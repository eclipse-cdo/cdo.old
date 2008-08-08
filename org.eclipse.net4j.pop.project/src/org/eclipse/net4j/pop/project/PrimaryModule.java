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
 * $Id: PrimaryModule.java,v 1.1 2008-08-08 10:10:38 estepper Exp $
 */
package org.eclipse.net4j.pop.project;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Primary Module</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.project.PrimaryModule#getRepository <em>Repository</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.PrimaryModule#getProductModelPath <em>Product Model Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.pop.project.ProjectPackage#getPrimaryModule()
 * @model
 * @generated
 */
public interface PrimaryModule extends Module
{
  /**
   * Returns the value of the '<em><b>Repository</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.Repository#getPrimaryModule <em>Primary Module</em>}'.
   * <!-- begin-user-doc
   * -->
   * <p>
   * If the meaning of the '<em>Repository</em>' container reference isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Repository</em>' container reference.
   * @see #setRepository(Repository)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getPrimaryModule_Repository()
   * @see org.eclipse.net4j.pop.project.Repository#getPrimaryModule
   * @model opposite="primaryModule" required="true" transient="false"
   * @generated
   */
  Repository getRepository();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.PrimaryModule#getRepository <em>Repository</em>}' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Repository</em>' container reference.
   * @see #getRepository()
   * @generated
   */
  void setRepository(Repository value);

  /**
   * Returns the value of the '<em><b>Product Model Path</b></em>' attribute.
   * The default value is <code>"product.xml"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Product Model Path</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Product Model Path</em>' attribute.
   * @see #setProductModelPath(String)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getPrimaryModule_ProductModelPath()
   * @model default="product.xml" required="true"
   * @generated
   */
  String getProductModelPath();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.PrimaryModule#getProductModelPath <em>Product Model Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Product Model Path</em>' attribute.
   * @see #getProductModelPath()
   * @generated
   */
  void setProductModelPath(String value);

} // PrimaryModule
