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


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Feature</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.examples.prov.Feature#getCategory <em>Category</em>}</li>
 *   <li>{@link org.eclipse.net4j.examples.prov.Feature#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.net4j.examples.prov.Feature#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.net4j.examples.prov.Feature#getUrl <em>Url</em>}</li>
 *   <li>{@link org.eclipse.net4j.examples.prov.Feature#getCategories <em>Categories</em>}</li>
 *   <li>{@link org.eclipse.net4j.examples.prov.Feature#getSite <em>Site</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.examples.prov.ProvPackage#getFeature()
 * @model
 * @generated
 */
public interface Feature extends EObject
{
  /**
   * Returns the value of the '<em><b>Category</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.examples.prov.Category#getFeatures <em>Features</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Category</em>' container reference isn't clear, there really
   * should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Category</em>' container reference.
   * @see #setCategory(Category)
   * @see org.eclipse.net4j.examples.prov.ProvPackage#getFeature_Category()
   * @see org.eclipse.net4j.examples.prov.Category#getFeatures
   * @model opposite="features"
   * @generated
   */
  Category getCategory();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.examples.prov.Feature#getCategory <em>Category</em>}' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Category</em>' container reference.
   * @see #getCategory()
   * @generated
   */
  void setCategory(Category value);

  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see org.eclipse.net4j.examples.prov.ProvPackage#getFeature_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.examples.prov.Feature#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Version</em>' attribute isn't clear, there really should be more
   * of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Version</em>' attribute.
   * @see #setVersion(String)
   * @see org.eclipse.net4j.examples.prov.ProvPackage#getFeature_Version()
   * @model
   * @generated
   */
  String getVersion();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.examples.prov.Feature#getVersion <em>Version</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Version</em>' attribute.
   * @see #getVersion()
   * @generated
   */
  void setVersion(String value);

  /**
   * Returns the value of the '<em><b>Url</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Url</em>' attribute isn't clear, there really should be more of
   * a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Url</em>' attribute.
   * @see org.eclipse.net4j.examples.prov.ProvPackage#getFeature_Url()
   * @model transient="true" changeable="false" volatile="true"
   * @generated
   */
  String getUrl();

  /**
   * Returns the value of the '<em><b>Site</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.examples.prov.Site#getFeatures <em>Features</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Site</em>' reference isn't clear, there really should be more of
   * a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Site</em>' container reference.
   * @see #setSite(Site)
   * @see org.eclipse.net4j.examples.prov.ProvPackage#getFeature_Site()
   * @see org.eclipse.net4j.examples.prov.Site#getFeatures
   * @model opposite="features"
   * @generated
   */
  Site getSite();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.examples.prov.Feature#getSite <em>Site</em>}' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Site</em>' container reference.
   * @see #getSite()
   * @generated
   */
  void setSite(Site value);

  /**
   * Returns the value of the '<em><b>Categories</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.net4j.examples.prov.Category}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Categories</em>' reference list isn't clear, there really should
   * be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Categories</em>' reference list.
   * @see org.eclipse.net4j.examples.prov.ProvPackage#getFeature_Categories()
   * @model type="org.eclipse.net4j.examples.prov.Category" transient="true" changeable="false" volatile="true"
   * @generated
   */
  EList getCategories();

} // Feature
