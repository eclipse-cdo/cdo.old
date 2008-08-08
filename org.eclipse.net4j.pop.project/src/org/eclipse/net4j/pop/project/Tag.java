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
 * $Id: Tag.java,v 1.1 2008-08-08 10:10:38 estepper Exp $
 */
package org.eclipse.net4j.pop.project;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Tag</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.project.Tag#getBranch <em>Branch</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.Tag#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.project.Tag#getTaggedElement <em>Tagged Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.pop.project.ProjectPackage#getTag()
 * @model
 * @generated
 */
public interface Tag extends CheckoutDiscriminator
{
  /**
   * Returns the value of the '<em><b>Branch</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.Branch#getTags <em>Tags</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Branch</em>' container reference isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Branch</em>' container reference.
   * @see #setBranch(Branch)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getTag_Branch()
   * @see org.eclipse.net4j.pop.project.Branch#getTags
   * @model opposite="tags" required="true" transient="false"
   * @generated
   */
  Branch getBranch();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.Tag#getBranch <em>Branch</em>}' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Branch</em>' container reference.
   * @see #getBranch()
   * @generated
   */
  void setBranch(Branch value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getTag_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.Tag#getName <em>Name</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Tagged Element</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.TaggedElement#getTag <em>Tag</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tagged Element</em>' reference isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tagged Element</em>' reference.
   * @see #setTaggedElement(TaggedElement)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getTag_TaggedElement()
   * @see org.eclipse.net4j.pop.project.TaggedElement#getTag
   * @model opposite="tag"
   * @generated
   */
  TaggedElement getTaggedElement();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.Tag#getTaggedElement <em>Tagged Element</em>}' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Tagged Element</em>' reference.
   * @see #getTaggedElement()
   * @generated
   */
  void setTaggedElement(TaggedElement value);

} // Tag
