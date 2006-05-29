/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.examples.library;


import org.eclipse.emf.cdo.client.CDOPersistent;
import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.cdo.examples.library.Book#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.examples.library.Book#getAuthors <em>Authors</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.examples.library.Book#getLibrary <em>Library</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.examples.library.Book#getTopic <em>Topic</em>}</li>
 *   <li>{@link org.eclipse.emf.cdo.examples.library.Book#getNumberOfPages <em>Number Of Pages</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.cdo.examples.library.LibraryPackage#getBook()
 * @model
 * @generated
 */
public interface Book extends CDOPersistent
{
  /**
   * Returns the value of the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Title</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Title</em>' attribute.
   * @see #setTitle(String)
   * @see org.eclipse.emf.cdo.examples.library.LibraryPackage#getBook_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.eclipse.emf.cdo.examples.library.Book#getTitle <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' attribute.
   * @see #getTitle()
   * @generated
   */
  void setTitle(String value);

  /**
   * Returns the value of the '<em><b>Authors</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.emf.cdo.examples.library.Author}.
   * It is bidirectional and its opposite is '{@link org.eclipse.emf.cdo.examples.library.Author#getBooks <em>Books</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Authors</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Authors</em>' reference list.
   * @see org.eclipse.emf.cdo.examples.library.LibraryPackage#getBook_Authors()
   * @see org.eclipse.emf.cdo.examples.library.Author#getBooks
   * @model type="org.eclipse.emf.cdo.examples.library.Author" opposite="books"
   * @generated
   */
  EList getAuthors();

  /**
   * Returns the value of the '<em><b>Library</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.emf.cdo.examples.library.Library#getBooks <em>Books</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Library</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Library</em>' container reference.
   * @see #setLibrary(Library)
   * @see org.eclipse.emf.cdo.examples.library.LibraryPackage#getBook_Library()
   * @see org.eclipse.emf.cdo.examples.library.Library#getBooks
   * @model opposite="books"
   * @generated
   */
  Library getLibrary();

  /**
   * Sets the value of the '{@link org.eclipse.emf.cdo.examples.library.Book#getLibrary <em>Library</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Library</em>' container reference.
   * @see #getLibrary()
   * @generated
   */
  void setLibrary(Library value);

  /**
   * Returns the value of the '<em><b>Topic</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.emf.cdo.examples.library.Topic#getBooks <em>Books</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Topic</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Topic</em>' container reference.
   * @see #setTopic(Topic)
   * @see org.eclipse.emf.cdo.examples.library.LibraryPackage#getBook_Topic()
   * @see org.eclipse.emf.cdo.examples.library.Topic#getBooks
   * @model opposite="books"
   * @generated
   */
  Topic getTopic();

  /**
   * Sets the value of the '{@link org.eclipse.emf.cdo.examples.library.Book#getTopic <em>Topic</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Topic</em>' container reference.
   * @see #getTopic()
   * @generated
   */
  void setTopic(Topic value);

  /**
   * Returns the value of the '<em><b>Number Of Pages</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Number Of Pages</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Number Of Pages</em>' attribute.
   * @see #setNumberOfPages(int)
   * @see org.eclipse.emf.cdo.examples.library.LibraryPackage#getBook_NumberOfPages()
   * @model
   * @generated
   */
  int getNumberOfPages();

  /**
   * Sets the value of the '{@link org.eclipse.emf.cdo.examples.library.Book#getNumberOfPages <em>Number Of Pages</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Number Of Pages</em>' attribute.
   * @see #getNumberOfPages()
   * @generated
   */
  void setNumberOfPages(int value);

} // Book
