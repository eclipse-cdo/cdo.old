/***************************************************************************
 * Copyright (c) 2004-2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.examples.prov;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Site</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.examples.prov.Site#getCategories <em>Categories</em>}</li>
 *   <li>{@link org.eclipse.net4j.examples.prov.Site#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.net4j.examples.prov.Site#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.examples.prov.ProvPackage#getSite()
 * @model
 * @generated
 */
public interface Site extends EObject
{
  /**
   * Returns the value of the '<em><b>Categories</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.net4j.examples.prov.Category}.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.examples.prov.Category#getSite <em>Site</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Categories</em>' containment reference list isn't clear, there
   * really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Categories</em>' containment reference list.
   * @see org.eclipse.net4j.examples.prov.ProvPackage#getSite_Categories()
   * @see org.eclipse.net4j.examples.prov.Category#getSite
   * @model type="org.eclipse.net4j.examples.prov.Category" opposite="site" containment="true"
   * @generated
   */
  EList getCategories();

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of
   * a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.net4j.examples.prov.ProvPackage#getSite_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.examples.prov.Site#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Features</b></em>' containment reference list. The list
   * contents are of type {@link org.eclipse.net4j.examples.prov.Feature}. It is bidirectional and
   * its opposite is '{@link org.eclipse.net4j.examples.prov.Feature#getSite <em>Site</em>}'. <!--
   * begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Features</em>' containment reference list isn't clear, there
   * really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Features</em>' containment reference list.
   * @see org.eclipse.net4j.examples.prov.ProvPackage#getSite_Features()
   * @see org.eclipse.net4j.examples.prov.Feature#getSite
   * @model type="org.eclipse.net4j.examples.prov.Feature" opposite="site" containment="true"
   * @generated
   */
  EList getFeatures();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  Category getCategory(String name);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  Feature addFeature(String id, String version);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  Category addCategory(String name);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  Feature getFeature(String id, String version);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model dataType="org.eclipse.net4j.examples.prov.Categories" many="false"
   * @generated
   */
  EList getCategories(String featureId, String featureVersion);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  Category removeCategory(int index);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  Feature removeFeature(int index);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  Category removeCategory(String name);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  Feature removeFeature(String id, String version);

} // Site
