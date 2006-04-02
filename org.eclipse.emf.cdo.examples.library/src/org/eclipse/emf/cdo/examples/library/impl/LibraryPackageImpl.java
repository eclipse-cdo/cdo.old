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
package org.eclipse.emf.cdo.example.library.impl;


import org.eclipse.emf.cdo.client.CDOPackage;
import org.eclipse.emf.cdo.example.library.Author;
import org.eclipse.emf.cdo.example.library.Book;
import org.eclipse.emf.cdo.example.library.EBook;
import org.eclipse.emf.cdo.example.library.Library;
import org.eclipse.emf.cdo.example.library.LibraryFactory;
import org.eclipse.emf.cdo.example.library.LibraryPackage;
import org.eclipse.emf.cdo.example.library.Topic;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LibraryPackageImpl extends EPackageImpl implements LibraryPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass libraryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bookEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass authorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass topicEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eBookEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.emf.cdo.example.library.LibraryPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private LibraryPackageImpl()
  {
    super(eNS_URI, LibraryFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this
   * model, and for any others upon which it depends.  Simple
   * dependencies are satisfied by calling this method on all
   * dependent packages before doing anything else.  This method drives
   * initialization for interdependent packages directly, in parallel
   * with this package, itself.
   * <p>Of this package and its interdependencies, all packages which
   * have not yet been registered by their URI values are first created
   * and registered.  The packages are then initialized in two steps:
   * meta-model objects for all of the packages are created before any
   * are initialized, since one package's meta-model objects may refer to
   * those of another.
   * <p>Invocation of this method will not affect any packages that have
   * already been initialized.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static LibraryPackage init()
  {
    if (isInited)
      return (LibraryPackage) EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI);

    // Obtain or create and register package
    LibraryPackageImpl theLibraryPackage = (LibraryPackageImpl) (EPackage.Registry.INSTANCE
        .getEPackage(eNS_URI) instanceof LibraryPackageImpl ? EPackage.Registry.INSTANCE
        .getEPackage(eNS_URI) : new LibraryPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    CDOPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theLibraryPackage.createPackageContents();

    // Initialize created meta-data
    theLibraryPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theLibraryPackage.freeze();

    return theLibraryPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLibrary()
  {
    return libraryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLibrary_Books()
  {
    return (EReference) libraryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLibrary_Authors()
  {
    return (EReference) libraryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLibrary_Topics()
  {
    return (EReference) libraryEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBook()
  {
    return bookEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBook_Title()
  {
    return (EAttribute) bookEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBook_Authors()
  {
    return (EReference) bookEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBook_Library()
  {
    return (EReference) bookEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBook_Topic()
  {
    return (EReference) bookEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBook_NumberOfPages()
  {
    return (EAttribute) bookEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAuthor()
  {
    return authorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAuthor_Name()
  {
    return (EAttribute) authorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAuthor_Books()
  {
    return (EReference) authorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAuthor_Library()
  {
    return (EReference) authorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTopic()
  {
    return topicEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTopic_Books()
  {
    return (EReference) topicEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTopic_Library()
  {
    return (EReference) topicEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTopic_Topics()
  {
    return (EReference) topicEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTopic_Topic()
  {
    return (EReference) topicEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTopic_Name()
  {
    return (EAttribute) topicEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEBook()
  {
    return eBookEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEBook_Url()
  {
    return (EAttribute) eBookEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LibraryFactory getLibraryFactory()
  {
    return (LibraryFactory) getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    libraryEClass = createEClass(LIBRARY);
    createEReference(libraryEClass, LIBRARY__BOOKS);
    createEReference(libraryEClass, LIBRARY__AUTHORS);
    createEReference(libraryEClass, LIBRARY__TOPICS);

    bookEClass = createEClass(BOOK);
    createEAttribute(bookEClass, BOOK__TITLE);
    createEReference(bookEClass, BOOK__AUTHORS);
    createEReference(bookEClass, BOOK__LIBRARY);
    createEReference(bookEClass, BOOK__TOPIC);
    createEAttribute(bookEClass, BOOK__NUMBER_OF_PAGES);

    authorEClass = createEClass(AUTHOR);
    createEAttribute(authorEClass, AUTHOR__NAME);
    createEReference(authorEClass, AUTHOR__BOOKS);
    createEReference(authorEClass, AUTHOR__LIBRARY);

    topicEClass = createEClass(TOPIC);
    createEReference(topicEClass, TOPIC__BOOKS);
    createEReference(topicEClass, TOPIC__LIBRARY);
    createEReference(topicEClass, TOPIC__TOPICS);
    createEReference(topicEClass, TOPIC__TOPIC);
    createEAttribute(topicEClass, TOPIC__NAME);

    eBookEClass = createEClass(EBOOK);
    createEAttribute(eBookEClass, EBOOK__URL);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    CDOPackage theCdoPackage = (CDOPackage) EPackage.Registry.INSTANCE
        .getEPackage(CDOPackage.eNS_URI);

    // Add supertypes to classes
    libraryEClass.getESuperTypes().add(theCdoPackage.getCdoPersistent());
    bookEClass.getESuperTypes().add(theCdoPackage.getCdoPersistent());
    authorEClass.getESuperTypes().add(theCdoPackage.getCdoPersistent());
    topicEClass.getESuperTypes().add(theCdoPackage.getCdoPersistent());
    eBookEClass.getESuperTypes().add(this.getBook());

    // Initialize classes and features; add operations and parameters
    initEClass(libraryEClass, Library.class, "Library", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLibrary_Books(), this.getBook(), this.getBook_Library(), "books", null, 0,
        -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLibrary_Authors(), this.getAuthor(), this.getAuthor_Library(), "authors",
        null, 0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLibrary_Topics(), this.getTopic(), this.getTopic_Library(), "topics", null,
        0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bookEClass, Book.class, "Book", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBook_Title(), ecorePackage.getEString(), "title", null, 0, 1, Book.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEReference(getBook_Authors(), this.getAuthor(), this.getAuthor_Books(), "authors", null, 0,
        -1, Book.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
        IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBook_Library(), this.getLibrary(), this.getLibrary_Books(), "library", null,
        0, 1, Book.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBook_Topic(), this.getTopic(), this.getTopic_Books(), "topic", null, 0, 1,
        Book.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
        !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBook_NumberOfPages(), ecorePackage.getEInt(), "numberOfPages", null, 0, 1,
        Book.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
        !IS_DERIVED, IS_ORDERED);

    initEClass(authorEClass, Author.class, "Author", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAuthor_Name(), ecorePackage.getEString(), "name", null, 0, 1, Author.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);
    initEReference(getAuthor_Books(), this.getBook(), this.getBook_Authors(), "books", null, 0, -1,
        Author.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
        IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAuthor_Library(), this.getLibrary(), this.getLibrary_Authors(), "library",
        null, 1, 1, Author.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(topicEClass, Topic.class, "Topic", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTopic_Books(), this.getBook(), this.getBook_Topic(), "books", null, 0, -1,
        Topic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
        !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTopic_Library(), this.getLibrary(), this.getLibrary_Topics(), "library",
        null, 0, 1, Topic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTopic_Topics(), this.getTopic(), this.getTopic_Topic(), "topics", null, 0,
        -1, Topic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTopic_Topic(), this.getTopic(), this.getTopic_Topics(), "topic", null, 0, 1,
        Topic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
        !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTopic_Name(), ecorePackage.getEString(), "name", null, 0, 1, Topic.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);

    initEClass(eBookEClass, EBook.class, "EBook", !IS_ABSTRACT, !IS_INTERFACE,
        IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEBook_Url(), ecorePackage.getEString(), "url", null, 0, 1, EBook.class,
        !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
        IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //LibraryPackageImpl
