/*******************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Sympedia Methods and Tools.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.cdo.example.library;


import org.eclipse.emf.cdo.client.CdoPersistent;
import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Topic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.cdo.example.library.Topic#getBooks <em>Books</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.example.library.Topic#getLibrary <em>Library</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.example.library.Topic#getTopics <em>Topics</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.example.library.Topic#getTopic <em>Topic</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.example.library.Topic#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.cdo.example.library.LibraryPackage#getTopic()
 * @model
 * @generated
 */
public interface Topic extends CdoPersistent
{
  /**
   * Returns the value of the '<em><b>Books</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.cdo.example.library.Book}.
   * It is bidirectional and its opposite is '{@link org.eclipse.emf.cdo.example.library.Book#getTopic <em>Topic</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Books</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Books</em>' containment reference list.
   * @see org.eclipse.emf.cdo.example.library.LibraryPackage#getTopic_Books()
   * @see org.eclipse.emf.cdo.example.library.Book#getTopic
   * @model type="org.eclipse.emf.cdo.example.library.Book" opposite="topic" containment="true"
   * @generated
   */
  EList getBooks();

  /**
   * Returns the value of the '<em><b>Library</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.emf.cdo.example.library.Library#getTopics <em>Topics</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Library</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Library</em>' container reference.
   * @see #setLibrary(Library)
   * @see org.eclipse.emf.cdo.example.library.LibraryPackage#getTopic_Library()
   * @see org.eclipse.emf.cdo.example.library.Library#getTopics
   * @model opposite="topics"
   * @generated
   */
  Library getLibrary();

  /**
   * Sets the value of the '{@link org.eclipse.emf.cdo.example.library.Topic#getLibrary <em>Library</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Library</em>' container reference.
   * @see #getLibrary()
   * @generated
   */
  void setLibrary(Library value);

  /**
   * Returns the value of the '<em><b>Topics</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.cdo.example.library.Topic}.
   * It is bidirectional and its opposite is '{@link org.eclipse.emf.cdo.example.library.Topic#getTopic <em>Topic</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Topics</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Topics</em>' containment reference list.
   * @see org.eclipse.emf.cdo.example.library.LibraryPackage#getTopic_Topics()
   * @see org.eclipse.emf.cdo.example.library.Topic#getTopic
   * @model type="org.eclipse.emf.cdo.example.library.Topic" opposite="topic" containment="true"
   * @generated
   */
  EList getTopics();

  /**
   * Returns the value of the '<em><b>Topic</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.emf.cdo.example.library.Topic#getTopics <em>Topics</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Topic</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Topic</em>' container reference.
   * @see #setTopic(Topic)
   * @see org.eclipse.emf.cdo.example.library.LibraryPackage#getTopic_Topic()
   * @see org.eclipse.emf.cdo.example.library.Topic#getTopics
   * @model opposite="topics"
   * @generated
   */
  Topic getTopic();

  /**
   * Sets the value of the '{@link org.eclipse.emf.cdo.example.library.Topic#getTopic <em>Topic</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Topic</em>' container reference.
   * @see #getTopic()
   * @generated
   */
  void setTopic(Topic value);

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
   * @see org.eclipse.emf.cdo.example.library.LibraryPackage#getTopic_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.emf.cdo.example.library.Topic#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // Topic
