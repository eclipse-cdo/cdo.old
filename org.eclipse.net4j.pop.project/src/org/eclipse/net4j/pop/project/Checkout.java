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
 * $Id: Checkout.java,v 1.1 2008-08-08 10:10:38 estepper Exp $
 */
package org.eclipse.net4j.pop.project;

import org.eclipse.net4j.pop.base.PopElement;

import org.eclipse.core.runtime.IPath;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Checkout</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.project.Checkout#getPopProject <em>Pop Project</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.Checkout#getDiscriminator <em>Discriminator</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.Checkout#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.Checkout#isActive <em>Active</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.pop.project.ProjectPackage#getCheckout()
 * @model
 * @generated
 */
public interface Checkout extends PopElement
{
  /**
   * Returns the value of the '<em><b>Pop Project</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pop Project</em>' reference isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pop Project</em>' reference.
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getCheckout_PopProject()
   * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */
  PopProject getPopProject();

  /**
   * Returns the value of the '<em><b>Discriminator</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Discriminator</em>' reference isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Discriminator</em>' reference.
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getCheckout_Discriminator()
   * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */
  CheckoutDiscriminator getDiscriminator();

  /**
   * Returns the value of the '<em><b>Location</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Location</em>' attribute isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Location</em>' attribute.
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getCheckout_Location()
   * @model dataType="org.eclipse.net4j.pop.base.Path" required="true" transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */
  IPath getLocation();

  /**
   * Returns the value of the '<em><b>Active</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Active</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Active</em>' attribute.
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getCheckout_Active()
   * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */
  boolean isActive();

} // Checkout
