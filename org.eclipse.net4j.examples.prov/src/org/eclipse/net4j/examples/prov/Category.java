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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.examples.prov.Category#getSite <em>Site</em>}</li>
 *   <li>{@link org.eclipse.net4j.examples.prov.Category#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.eclipse.net4j.examples.prov.Category#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.net4j.examples.prov.Category#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.net4j.examples.prov.Category#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.examples.prov.ProvPackage#getCategory()
 * @model
 * @generated
 */
public interface Category extends EObject
{
  /**
   * Returns the value of the '<em><b>Site</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.examples.prov.Site#getCategories <em>Categories</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Site</em>' container reference isn't clear, there really should
   * be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Site</em>' container reference.
   * @see #setSite(Site)
   * @see org.eclipse.net4j.examples.prov.ProvPackage#getCategory_Site()
   * @see org.eclipse.net4j.examples.prov.Site#getCategories
   * @model opposite="categories"
   * @generated
   */
  Site getSite();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.examples.prov.Category#getSite <em>Site</em>}' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Site</em>' container reference.
   * @see #getSite()
   * @generated
   */
  void setSite(Site value);

  /**
   * Returns the value of the '<em><b>Features</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.net4j.examples.prov.Feature}.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.examples.prov.Feature#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Features</em>' reference list isn't clear, there really should
   * be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Features</em>' containment reference list.
   * @see org.eclipse.net4j.examples.prov.ProvPackage#getCategory_Features()
   * @see org.eclipse.net4j.examples.prov.Feature#getCategory
   * @model type="org.eclipse.net4j.examples.prov.Feature" opposite="category" containment="true"
   * @generated
   */
  EList getFeatures();

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
   * @see org.eclipse.net4j.examples.prov.ProvPackage#getCategory_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.examples.prov.Category#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Label</em>' attribute isn't clear, there really should be more
   * of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Label</em>' attribute.
   * @see #setLabel(String)
   * @see org.eclipse.net4j.examples.prov.ProvPackage#getCategory_Label()
   * @model
   * @generated
   */
  String getLabel();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.examples.prov.Category#getLabel <em>Label</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Label</em>' attribute.
   * @see #getLabel()
   * @generated
   */
  void setLabel(String value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear, there really should be
   * more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see org.eclipse.net4j.examples.prov.ProvPackage#getCategory_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.examples.prov.Category#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  Feature getFeature(String id, String version);

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
  Feature removeFeature(int index);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @model
   * @generated
   */
  Feature removeFeature(String id, String version);

} // Category
