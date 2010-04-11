/*******************************************************************************
 * Copyright (c) 2010 Martin Fluegge (Berlin, Germany).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fluegge - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * 
 * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramPackage
 * @generated
 */
public interface ClassdiagramFactory extends EFactory
{
  /**
   * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  ClassdiagramFactory eINSTANCE = org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassdiagramFactoryImpl
      .init();

  /**
   * Returns a new object of class '<em>AClass</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return a new object of class '<em>AClass</em>'.
   * @generated
   */
  AClass createAClass();

  /**
   * Returns a new object of class '<em>AInterface</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return a new object of class '<em>AInterface</em>'.
   * @generated
   */
  AInterface createAInterface();

  /**
   * Returns a new object of class '<em>Class Diagram</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return a new object of class '<em>Class Diagram</em>'.
   * @generated
   */
  ClassDiagram createClassDiagram();

  /**
   * Returns a new object of class '<em>An Attribute</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return a new object of class '<em>An Attribute</em>'.
   * @generated
   */
  AnAttribute createAnAttribute();

  /**
   * Returns a new object of class '<em>An Operation</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return a new object of class '<em>An Operation</em>'.
   * @generated
   */
  AnOperation createAnOperation();

  /**
   * Returns a new object of class '<em>ABasic Class</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return a new object of class '<em>ABasic Class</em>'.
   * @generated
   */
  ABasicClass createABasicClass();

  /**
   * Returns a new object of class '<em>AParameter</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return a new object of class '<em>AParameter</em>'.
   * @generated
   */
  AParameter createAParameter();

  /**
   * Returns a new object of class '<em>AClass Child</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return a new object of class '<em>AClass Child</em>'.
   * @generated
   */
  AClassChild createAClassChild();

  /**
   * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the package supported by this factory.
   * @generated
   */
  ClassdiagramPackage getClassdiagramPackage();

} // ClassdiagramFactory
