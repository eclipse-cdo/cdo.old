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
 * $Id: BasePackage.java,v 1.1 2008-08-08 10:10:32 estepper Exp $
 */
package org.eclipse.net4j.pop.base;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.net4j.pop.base.BaseFactory
 * @model kind="package"
 * @generated
 */
public interface BasePackage extends EPackage
{
  /**
   * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  String eNAME = "base"; //$NON-NLS-1$

  /**
   * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/pop/base/1.0.0"; //$NON-NLS-1$

  /**
   * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  String eNS_PREFIX = "pop.base"; //$NON-NLS-1$

  /**
   * The package content type ID. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  String eCONTENT_TYPE = "pop.base"; //$NON-NLS-1$

  /**
   * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  BasePackage eINSTANCE = org.eclipse.net4j.pop.base.impl.BasePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.net4j.pop.base.Identifiable <em>Identifiable</em>}' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.net4j.pop.base.Identifiable
   * @see org.eclipse.net4j.pop.base.impl.BasePackageImpl#getIdentifiable()
   * @generated
   */
  int IDENTIFIABLE = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int IDENTIFIABLE__ID = 0;

  /**
   * The number of structural features of the '<em>Identifiable</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int IDENTIFIABLE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.net4j.pop.base.Displayable <em>Displayable</em>}' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.net4j.pop.base.Displayable
   * @see org.eclipse.net4j.pop.base.impl.BasePackageImpl#getDisplayable()
   * @generated
   */
  int DISPLAYABLE = 1;

  /**
   * The number of structural features of the '<em>Displayable</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int DISPLAYABLE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.net4j.pop.base.impl.PopElementImpl <em>Pop Element</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.net4j.pop.base.impl.PopElementImpl
   * @see org.eclipse.net4j.pop.base.impl.BasePackageImpl#getPopElement()
   * @generated
   */
  int POP_ELEMENT = 2;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int POP_ELEMENT__ID = IDENTIFIABLE__ID;

  /**
   * The feature id for the '<em><b>Class</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   * @ordered
   */
  int POP_ELEMENT__CLASS = IDENTIFIABLE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Pop Element</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  int POP_ELEMENT_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '<em>Version</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.net4j.pop.base.Version
   * @see org.eclipse.net4j.pop.base.impl.BasePackageImpl#getVersion()
   * @generated
   */
  int VERSION = 3;

  /**
   * The meta object id for the '<em>Path</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.core.runtime.IPath
   * @see org.eclipse.net4j.pop.base.impl.BasePackageImpl#getPath()
   * @generated
   */
  int PATH = 4;

  /**
   * The meta object id for the '<em>Repository Adapter</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.net4j.pop.repository.IRepositoryAdapter
   * @see org.eclipse.net4j.pop.base.impl.BasePackageImpl#getRepositoryAdapter()
   * @generated
   */
  int REPOSITORY_ADAPTER = 5;

  /**
   * The meta object id for the '<em>Repository Session</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.net4j.pop.repository.IRepositorySession
   * @see org.eclipse.net4j.pop.base.impl.BasePackageImpl#getRepositorySession()
   * @generated
   */
  int REPOSITORY_SESSION = 6;

  /**
   * The meta object id for the '<em>Repository Folder</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.net4j.pop.repository.IRepositoryFolder
   * @see org.eclipse.net4j.pop.base.impl.BasePackageImpl#getRepositoryFolder()
   * @generated
   */
  int REPOSITORY_FOLDER = 7;

  /**
   * The meta object id for the '<em>Repository Tag</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see org.eclipse.net4j.pop.repository.IRepositoryTag
   * @see org.eclipse.net4j.pop.base.impl.BasePackageImpl#getRepositoryTag()
   * @generated
   */
  int REPOSITORY_TAG = 8;

  /**
   * Returns the meta object for class '{@link org.eclipse.net4j.pop.base.Identifiable <em>Identifiable</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for class '<em>Identifiable</em>'.
   * @see org.eclipse.net4j.pop.base.Identifiable
   * @generated
   */
  EClass getIdentifiable();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.net4j.pop.base.Identifiable#getId <em>Id</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.eclipse.net4j.pop.base.Identifiable#getId()
   * @see #getIdentifiable()
   * @generated
   */
  EAttribute getIdentifiable_Id();

  /**
   * Returns the meta object for class '{@link org.eclipse.net4j.pop.base.Displayable <em>Displayable</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for class '<em>Displayable</em>'.
   * @see org.eclipse.net4j.pop.base.Displayable
   * @generated
   */
  EClass getDisplayable();

  /**
   * Returns the meta object for class '{@link org.eclipse.net4j.pop.base.PopElement <em>Pop Element</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for class '<em>Pop Element</em>'.
   * @see org.eclipse.net4j.pop.base.PopElement
   * @generated
   */
  EClass getPopElement();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.net4j.pop.base.PopElement#getClass_ <em>Class</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for the attribute '<em>Class</em>'.
   * @see org.eclipse.net4j.pop.base.PopElement#getClass_()
   * @see #getPopElement()
   * @generated
   */
  EAttribute getPopElement_Class();

  /**
   * Returns the meta object for data type '{@link org.eclipse.net4j.pop.base.Version <em>Version</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for data type '<em>Version</em>'.
   * @see org.eclipse.net4j.pop.base.Version
   * @model instanceClass="org.eclipse.net4j.pop.base.Version"
   * @generated
   */
  EDataType getVersion();

  /**
   * Returns the meta object for data type '{@link org.eclipse.core.runtime.IPath <em>Path</em>}'. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * 
   * @return the meta object for data type '<em>Path</em>'.
   * @see org.eclipse.core.runtime.IPath
   * @model instanceClass="org.eclipse.core.runtime.IPath"
   * @generated
   */
  EDataType getPath();

  /**
   * Returns the meta object for data type '{@link org.eclipse.net4j.pop.repository.IRepositoryAdapter
   * <em>Repository Adapter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for data type '<em>Repository Adapter</em>'.
   * @see org.eclipse.net4j.pop.repository.IRepositoryAdapter
   * @model instanceClass="org.eclipse.net4j.pop.repository.IRepositoryAdapter"
   * @generated
   */
  EDataType getRepositoryAdapter();

  /**
   * Returns the meta object for data type '{@link org.eclipse.net4j.pop.repository.IRepositorySession
   * <em>Repository Session</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for data type '<em>Repository Session</em>'.
   * @see org.eclipse.net4j.pop.repository.IRepositorySession
   * @model instanceClass="org.eclipse.net4j.pop.repository.IRepositorySession"
   * @generated
   */
  EDataType getRepositorySession();

  /**
   * Returns the meta object for data type '{@link org.eclipse.net4j.pop.repository.IRepositoryFolder
   * <em>Repository Folder</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for data type '<em>Repository Folder</em>'.
   * @see org.eclipse.net4j.pop.repository.IRepositoryFolder
   * @model instanceClass="org.eclipse.net4j.pop.repository.IRepositoryFolder"
   * @generated
   */
  EDataType getRepositoryFolder();

  /**
   * Returns the meta object for data type '{@link org.eclipse.net4j.pop.repository.IRepositoryTag
   * <em>Repository Tag</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the meta object for data type '<em>Repository Tag</em>'.
   * @see org.eclipse.net4j.pop.repository.IRepositoryTag
   * @model instanceClass="org.eclipse.net4j.pop.repository.IRepositoryTag"
   * @generated
   */
  EDataType getRepositoryTag();

  /**
   * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the factory that creates the instances of the model.
   * @generated
   */
  BaseFactory getBaseFactory();

  /**
   * <!-- begin-user-doc --> Defines literals for the meta objects that represent
   * <ul>
   * <li>each class,</li>
   * <li>each feature of each class,</li>
   * <li>each enum,</li>
   * <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.net4j.pop.base.Identifiable <em>Identifiable</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.net4j.pop.base.Identifiable
     * @see org.eclipse.net4j.pop.base.impl.BasePackageImpl#getIdentifiable()
     * @generated
     */
    EClass IDENTIFIABLE = eINSTANCE.getIdentifiable();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    EAttribute IDENTIFIABLE__ID = eINSTANCE.getIdentifiable_Id();

    /**
     * The meta object literal for the '{@link org.eclipse.net4j.pop.base.Displayable <em>Displayable</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.net4j.pop.base.Displayable
     * @see org.eclipse.net4j.pop.base.impl.BasePackageImpl#getDisplayable()
     * @generated
     */
    EClass DISPLAYABLE = eINSTANCE.getDisplayable();

    /**
     * The meta object literal for the '{@link org.eclipse.net4j.pop.base.impl.PopElementImpl <em>Pop Element</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.net4j.pop.base.impl.PopElementImpl
     * @see org.eclipse.net4j.pop.base.impl.BasePackageImpl#getPopElement()
     * @generated
     */
    EClass POP_ELEMENT = eINSTANCE.getPopElement();

    /**
     * The meta object literal for the '<em><b>Class</b></em>' attribute feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    EAttribute POP_ELEMENT__CLASS = eINSTANCE.getPopElement_Class();

    /**
     * The meta object literal for the '<em>Version</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.net4j.pop.base.Version
     * @see org.eclipse.net4j.pop.base.impl.BasePackageImpl#getVersion()
     * @generated
     */
    EDataType VERSION = eINSTANCE.getVersion();

    /**
     * The meta object literal for the '<em>Path</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.core.runtime.IPath
     * @see org.eclipse.net4j.pop.base.impl.BasePackageImpl#getPath()
     * @generated
     */
    EDataType PATH = eINSTANCE.getPath();

    /**
     * The meta object literal for the '<em>Repository Adapter</em>' data type. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see org.eclipse.net4j.pop.repository.IRepositoryAdapter
     * @see org.eclipse.net4j.pop.base.impl.BasePackageImpl#getRepositoryAdapter()
     * @generated
     */
    EDataType REPOSITORY_ADAPTER = eINSTANCE.getRepositoryAdapter();

    /**
     * The meta object literal for the '<em>Repository Session</em>' data type. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see org.eclipse.net4j.pop.repository.IRepositorySession
     * @see org.eclipse.net4j.pop.base.impl.BasePackageImpl#getRepositorySession()
     * @generated
     */
    EDataType REPOSITORY_SESSION = eINSTANCE.getRepositorySession();

    /**
     * The meta object literal for the '<em>Repository Folder</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see org.eclipse.net4j.pop.repository.IRepositoryFolder
     * @see org.eclipse.net4j.pop.base.impl.BasePackageImpl#getRepositoryFolder()
     * @generated
     */
    EDataType REPOSITORY_FOLDER = eINSTANCE.getRepositoryFolder();

    /**
     * The meta object literal for the '<em>Repository Tag</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see org.eclipse.net4j.pop.repository.IRepositoryTag
     * @see org.eclipse.net4j.pop.base.impl.BasePackageImpl#getRepositoryTag()
     * @generated
     */
    EDataType REPOSITORY_TAG = eINSTANCE.getRepositoryTag();

  }

} // BasePackage
