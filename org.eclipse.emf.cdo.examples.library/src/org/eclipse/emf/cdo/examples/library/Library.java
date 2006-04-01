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
 * A representation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.cdo.example.library.Library#getBooks <em>Books</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.example.library.Library#getAuthors <em>Authors</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.example.library.Library#getTopics <em>Topics</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.cdo.example.library.LibraryPackage#getLibrary()
 * @model
 * @generated
 */
public interface Library extends CdoPersistent
{
  /**
   * Returns the value of the '<em><b>Books</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.cdo.example.library.Book}.
   * It is bidirectional and its opposite is '{@link org.eclipse.emf.cdo.example.library.Book#getLibrary <em>Library</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Books</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Books</em>' containment reference list.
   * @see org.eclipse.emf.cdo.example.library.LibraryPackage#getLibrary_Books()
   * @see org.eclipse.emf.cdo.example.library.Book#getLibrary
   * @model type="org.eclipse.emf.cdo.example.library.Book" opposite="library" containment="true"
   * @generated
   */
  EList getBooks();

  /**
   * Returns the value of the '<em><b>Authors</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.cdo.example.library.Author}.
   * It is bidirectional and its opposite is '{@link org.eclipse.emf.cdo.example.library.Author#getLibrary <em>Library</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Authors</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Authors</em>' containment reference list.
   * @see org.eclipse.emf.cdo.example.library.LibraryPackage#getLibrary_Authors()
   * @see org.eclipse.emf.cdo.example.library.Author#getLibrary
   * @model type="org.eclipse.emf.cdo.example.library.Author" opposite="library" containment="true"
   * @generated
   */
  EList getAuthors();

  /**
   * Returns the value of the '<em><b>Topics</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.cdo.example.library.Topic}.
   * It is bidirectional and its opposite is '{@link org.eclipse.emf.cdo.example.library.Topic#getLibrary <em>Library</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Topics</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Topics</em>' containment reference list.
   * @see org.eclipse.emf.cdo.example.library.LibraryPackage#getLibrary_Topics()
   * @see org.eclipse.emf.cdo.example.library.Topic#getLibrary
   * @model type="org.eclipse.emf.cdo.example.library.Topic" opposite="library" containment="true"
   * @generated
   */
  EList getTopics();

} // Library
