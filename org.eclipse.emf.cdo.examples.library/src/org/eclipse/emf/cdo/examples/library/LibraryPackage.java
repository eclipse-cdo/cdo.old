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


import org.eclipse.emf.cdo.client.CDOPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;


/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.cdo.example.library.LibraryFactory
 * @model kind="package"
 * @generated
 */
public interface LibraryPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "library";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://library";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "library";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  LibraryPackage eINSTANCE = org.eclipse.emf.cdo.example.library.impl.LibraryPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.emf.cdo.example.library.impl.LibraryImpl <em>Library</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.cdo.example.library.impl.LibraryImpl
   * @see org.eclipse.emf.cdo.example.library.impl.LibraryPackageImpl#getLibrary()
   * @generated
   */
  int LIBRARY = 0;

  /**
   * The feature id for the '<em><b>Books</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIBRARY__BOOKS = CDOPackage.CDO_PERSISTENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Authors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIBRARY__AUTHORS = CDOPackage.CDO_PERSISTENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Topics</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIBRARY__TOPICS = CDOPackage.CDO_PERSISTENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Library</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIBRARY_FEATURE_COUNT = CDOPackage.CDO_PERSISTENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.emf.cdo.example.library.impl.BookImpl <em>Book</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.cdo.example.library.impl.BookImpl
   * @see org.eclipse.emf.cdo.example.library.impl.LibraryPackageImpl#getBook()
   * @generated
   */
  int BOOK = 1;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOK__TITLE = CDOPackage.CDO_PERSISTENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Authors</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOK__AUTHORS = CDOPackage.CDO_PERSISTENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Library</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOK__LIBRARY = CDOPackage.CDO_PERSISTENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Topic</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOK__TOPIC = CDOPackage.CDO_PERSISTENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Number Of Pages</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOK__NUMBER_OF_PAGES = CDOPackage.CDO_PERSISTENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Book</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOK_FEATURE_COUNT = CDOPackage.CDO_PERSISTENT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.eclipse.emf.cdo.example.library.impl.AuthorImpl <em>Author</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.cdo.example.library.impl.AuthorImpl
   * @see org.eclipse.emf.cdo.example.library.impl.LibraryPackageImpl#getAuthor()
   * @generated
   */
  int AUTHOR = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUTHOR__NAME = CDOPackage.CDO_PERSISTENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Books</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUTHOR__BOOKS = CDOPackage.CDO_PERSISTENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Library</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUTHOR__LIBRARY = CDOPackage.CDO_PERSISTENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Author</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUTHOR_FEATURE_COUNT = CDOPackage.CDO_PERSISTENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.emf.cdo.example.library.impl.TopicImpl <em>Topic</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.cdo.example.library.impl.TopicImpl
   * @see org.eclipse.emf.cdo.example.library.impl.LibraryPackageImpl#getTopic()
   * @generated
   */
  int TOPIC = 3;

  /**
   * The feature id for the '<em><b>Books</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOPIC__BOOKS = CDOPackage.CDO_PERSISTENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Library</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOPIC__LIBRARY = CDOPackage.CDO_PERSISTENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Topics</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOPIC__TOPICS = CDOPackage.CDO_PERSISTENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Topic</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOPIC__TOPIC = CDOPackage.CDO_PERSISTENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOPIC__NAME = CDOPackage.CDO_PERSISTENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Topic</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOPIC_FEATURE_COUNT = CDOPackage.CDO_PERSISTENT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.eclipse.emf.cdo.example.library.impl.EBookImpl <em>EBook</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.cdo.example.library.impl.EBookImpl
   * @see org.eclipse.emf.cdo.example.library.impl.LibraryPackageImpl#getEBook()
   * @generated
   */
  int EBOOK = 4;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EBOOK__TITLE = BOOK__TITLE;

  /**
   * The feature id for the '<em><b>Authors</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EBOOK__AUTHORS = BOOK__AUTHORS;

  /**
   * The feature id for the '<em><b>Library</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EBOOK__LIBRARY = BOOK__LIBRARY;

  /**
   * The feature id for the '<em><b>Topic</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EBOOK__TOPIC = BOOK__TOPIC;

  /**
   * The feature id for the '<em><b>Number Of Pages</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EBOOK__NUMBER_OF_PAGES = BOOK__NUMBER_OF_PAGES;

  /**
   * The feature id for the '<em><b>Url</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EBOOK__URL = BOOK_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>EBook</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EBOOK_FEATURE_COUNT = BOOK_FEATURE_COUNT + 1;

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.cdo.example.library.Library <em>Library</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Library</em>'.
   * @see org.eclipse.emf.cdo.example.library.Library
   * @generated
   */
  EClass getLibrary();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.cdo.example.library.Library#getBooks <em>Books</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Books</em>'.
   * @see org.eclipse.emf.cdo.example.library.Library#getBooks()
   * @see #getLibrary()
   * @generated
   */
  EReference getLibrary_Books();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.cdo.example.library.Library#getAuthors <em>Authors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Authors</em>'.
   * @see org.eclipse.emf.cdo.example.library.Library#getAuthors()
   * @see #getLibrary()
   * @generated
   */
  EReference getLibrary_Authors();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.cdo.example.library.Library#getTopics <em>Topics</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Topics</em>'.
   * @see org.eclipse.emf.cdo.example.library.Library#getTopics()
   * @see #getLibrary()
   * @generated
   */
  EReference getLibrary_Topics();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.cdo.example.library.Book <em>Book</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Book</em>'.
   * @see org.eclipse.emf.cdo.example.library.Book
   * @generated
   */
  EClass getBook();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.cdo.example.library.Book#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.eclipse.emf.cdo.example.library.Book#getTitle()
   * @see #getBook()
   * @generated
   */
  EAttribute getBook_Title();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.emf.cdo.example.library.Book#getAuthors <em>Authors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Authors</em>'.
   * @see org.eclipse.emf.cdo.example.library.Book#getAuthors()
   * @see #getBook()
   * @generated
   */
  EReference getBook_Authors();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.emf.cdo.example.library.Book#getLibrary <em>Library</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Library</em>'.
   * @see org.eclipse.emf.cdo.example.library.Book#getLibrary()
   * @see #getBook()
   * @generated
   */
  EReference getBook_Library();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.emf.cdo.example.library.Book#getTopic <em>Topic</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Topic</em>'.
   * @see org.eclipse.emf.cdo.example.library.Book#getTopic()
   * @see #getBook()
   * @generated
   */
  EReference getBook_Topic();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.cdo.example.library.Book#getNumberOfPages <em>Number Of Pages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Number Of Pages</em>'.
   * @see org.eclipse.emf.cdo.example.library.Book#getNumberOfPages()
   * @see #getBook()
   * @generated
   */
  EAttribute getBook_NumberOfPages();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.cdo.example.library.Author <em>Author</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Author</em>'.
   * @see org.eclipse.emf.cdo.example.library.Author
   * @generated
   */
  EClass getAuthor();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.cdo.example.library.Author#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.emf.cdo.example.library.Author#getName()
   * @see #getAuthor()
   * @generated
   */
  EAttribute getAuthor_Name();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.emf.cdo.example.library.Author#getBooks <em>Books</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Books</em>'.
   * @see org.eclipse.emf.cdo.example.library.Author#getBooks()
   * @see #getAuthor()
   * @generated
   */
  EReference getAuthor_Books();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.emf.cdo.example.library.Author#getLibrary <em>Library</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Library</em>'.
   * @see org.eclipse.emf.cdo.example.library.Author#getLibrary()
   * @see #getAuthor()
   * @generated
   */
  EReference getAuthor_Library();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.cdo.example.library.Topic <em>Topic</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Topic</em>'.
   * @see org.eclipse.emf.cdo.example.library.Topic
   * @generated
   */
  EClass getTopic();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.cdo.example.library.Topic#getBooks <em>Books</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Books</em>'.
   * @see org.eclipse.emf.cdo.example.library.Topic#getBooks()
   * @see #getTopic()
   * @generated
   */
  EReference getTopic_Books();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.emf.cdo.example.library.Topic#getLibrary <em>Library</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Library</em>'.
   * @see org.eclipse.emf.cdo.example.library.Topic#getLibrary()
   * @see #getTopic()
   * @generated
   */
  EReference getTopic_Library();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.cdo.example.library.Topic#getTopics <em>Topics</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Topics</em>'.
   * @see org.eclipse.emf.cdo.example.library.Topic#getTopics()
   * @see #getTopic()
   * @generated
   */
  EReference getTopic_Topics();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.emf.cdo.example.library.Topic#getTopic <em>Topic</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Topic</em>'.
   * @see org.eclipse.emf.cdo.example.library.Topic#getTopic()
   * @see #getTopic()
   * @generated
   */
  EReference getTopic_Topic();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.cdo.example.library.Topic#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.emf.cdo.example.library.Topic#getName()
   * @see #getTopic()
   * @generated
   */
  EAttribute getTopic_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.cdo.example.library.EBook <em>EBook</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EBook</em>'.
   * @see org.eclipse.emf.cdo.example.library.EBook
   * @generated
   */
  EClass getEBook();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.cdo.example.library.EBook#getUrl <em>Url</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Url</em>'.
   * @see org.eclipse.emf.cdo.example.library.EBook#getUrl()
   * @see #getEBook()
   * @generated
   */
  EAttribute getEBook_Url();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  LibraryFactory getLibraryFactory();


  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.emf.cdo.example.library.impl.LibraryImpl <em>Library</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.cdo.example.library.impl.LibraryImpl
     * @see org.eclipse.emf.cdo.example.library.impl.LibraryPackageImpl#getLibrary()
     * @generated
     */
    EClass LIBRARY = eINSTANCE.getLibrary();

    /**
     * The meta object literal for the '<em><b>Books</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LIBRARY__BOOKS = eINSTANCE.getLibrary_Books();

    /**
     * The meta object literal for the '<em><b>Authors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LIBRARY__AUTHORS = eINSTANCE.getLibrary_Authors();

    /**
     * The meta object literal for the '<em><b>Topics</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LIBRARY__TOPICS = eINSTANCE.getLibrary_Topics();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.cdo.example.library.impl.BookImpl <em>Book</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.cdo.example.library.impl.BookImpl
     * @see org.eclipse.emf.cdo.example.library.impl.LibraryPackageImpl#getBook()
     * @generated
     */
    EClass BOOK = eINSTANCE.getBook();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOK__TITLE = eINSTANCE.getBook_Title();

    /**
     * The meta object literal for the '<em><b>Authors</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BOOK__AUTHORS = eINSTANCE.getBook_Authors();

    /**
     * The meta object literal for the '<em><b>Library</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BOOK__LIBRARY = eINSTANCE.getBook_Library();

    /**
     * The meta object literal for the '<em><b>Topic</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BOOK__TOPIC = eINSTANCE.getBook_Topic();

    /**
     * The meta object literal for the '<em><b>Number Of Pages</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOK__NUMBER_OF_PAGES = eINSTANCE.getBook_NumberOfPages();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.cdo.example.library.impl.AuthorImpl <em>Author</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.cdo.example.library.impl.AuthorImpl
     * @see org.eclipse.emf.cdo.example.library.impl.LibraryPackageImpl#getAuthor()
     * @generated
     */
    EClass AUTHOR = eINSTANCE.getAuthor();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AUTHOR__NAME = eINSTANCE.getAuthor_Name();

    /**
     * The meta object literal for the '<em><b>Books</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AUTHOR__BOOKS = eINSTANCE.getAuthor_Books();

    /**
     * The meta object literal for the '<em><b>Library</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AUTHOR__LIBRARY = eINSTANCE.getAuthor_Library();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.cdo.example.library.impl.TopicImpl <em>Topic</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.cdo.example.library.impl.TopicImpl
     * @see org.eclipse.emf.cdo.example.library.impl.LibraryPackageImpl#getTopic()
     * @generated
     */
    EClass TOPIC = eINSTANCE.getTopic();

    /**
     * The meta object literal for the '<em><b>Books</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TOPIC__BOOKS = eINSTANCE.getTopic_Books();

    /**
     * The meta object literal for the '<em><b>Library</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TOPIC__LIBRARY = eINSTANCE.getTopic_Library();

    /**
     * The meta object literal for the '<em><b>Topics</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TOPIC__TOPICS = eINSTANCE.getTopic_Topics();

    /**
     * The meta object literal for the '<em><b>Topic</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TOPIC__TOPIC = eINSTANCE.getTopic_Topic();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TOPIC__NAME = eINSTANCE.getTopic_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.cdo.example.library.impl.EBookImpl <em>EBook</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.cdo.example.library.impl.EBookImpl
     * @see org.eclipse.emf.cdo.example.library.impl.LibraryPackageImpl#getEBook()
     * @generated
     */
    EClass EBOOK = eINSTANCE.getEBook();

    /**
     * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EBOOK__URL = eINSTANCE.getEBook_Url();

  }

} //LibraryPackage
