/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.examples.prov;


import org.eclipse.emf.ecore.EFactory;


/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * @see org.eclipse.net4j.examples.prov.ProvPackage
 * @generated
 */
public interface ProvFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  ProvFactory eINSTANCE = org.eclipse.net4j.examples.prov.impl.ProvFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Site</em>'. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @return a new object of class '<em>Site</em>'.
   * @generated
   */
  Site createSite();

  /**
   * Returns a new object of class '<em>Feature</em>'. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @return a new object of class '<em>Feature</em>'.
   * @generated
   */
  Feature createFeature();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ProvPackage getProvPackage();

  /**
   * Returns a new object of class '<em>Category</em>'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return a new object of class '<em>Category</em>'.
   * @generated
   */
  Category createCategory();

} // ProvFactory
