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
 * $Id: SecondaryModule.java,v 1.1 2008-08-08 10:10:38 estepper Exp $
 */
package org.eclipse.net4j.pop.product;

import org.eclipse.net4j.pop.project.Module;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Secondary Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.product.SecondaryModule#getPopProduct <em>Pop Product</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.pop.product.ProductPackage#getSecondaryModule()
 * @model
 * @generated
 */
public interface SecondaryModule extends Module
{
  /**
   * Returns the value of the '<em><b>Pop Product</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.product.PopProduct#getSecondaryModules <em>Secondary Modules</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pop Product</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pop Product</em>' container reference.
   * @see #setPopProduct(PopProduct)
   * @see org.eclipse.net4j.pop.product.ProductPackage#getSecondaryModule_PopProduct()
   * @see org.eclipse.net4j.pop.product.PopProduct#getSecondaryModules
   * @model opposite="secondaryModules" required="true" transient="false"
   * @generated
   */
  PopProduct getPopProduct();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.product.SecondaryModule#getPopProduct <em>Pop Product</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pop Product</em>' container reference.
   * @see #getPopProduct()
   * @generated
   */
  void setPopProduct(PopProduct value);

} // SecondaryModule
