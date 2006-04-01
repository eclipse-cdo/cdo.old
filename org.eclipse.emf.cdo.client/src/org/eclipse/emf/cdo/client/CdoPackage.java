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
package org.eclipse.emf.cdo.client;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;


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
 * @see org.eclipse.emf.cdo.client.CdoFactory
 * @model kind="package"
 * @generated
 */
public interface CdoPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "client";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/net4j/cdo/client.ecore";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "org.eclipse.emf.cdo.client";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CdoPackage eINSTANCE = org.eclipse.emf.cdo.client.impl.CdoPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.emf.cdo.client.CdoPersistable <em>Persistable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.cdo.client.CdoPersistable
   * @see org.eclipse.emf.cdo.client.impl.CdoPackageImpl#getCdoPersistable()
   * @generated
   */
  int CDO_PERSISTABLE = 0;

  /**
   * The number of structural features of the '<em>Persistable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CDO_PERSISTABLE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.emf.cdo.client.impl.CdoPersistentImpl <em>Persistent</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.cdo.client.impl.CdoPersistentImpl
   * @see org.eclipse.emf.cdo.client.impl.CdoPackageImpl#getCdoPersistent()
   * @generated
   */
  int CDO_PERSISTENT = 1;

  /**
   * The number of structural features of the '<em>Persistent</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CDO_PERSISTENT_FEATURE_COUNT = CDO_PERSISTABLE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '<em>Resource Manager</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.cdo.client.ResourceManager
   * @see org.eclipse.emf.cdo.client.impl.CdoPackageImpl#getResourceManager()
   * @generated
   */
  int RESOURCE_MANAGER = 2;

  /**
   * The meta object id for the '<em>Resource</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.cdo.client.CdoResource
   * @see org.eclipse.emf.cdo.client.impl.CdoPackageImpl#getCdoResource()
   * @generated
   */
  int CDO_RESOURCE = 3;

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.cdo.client.CdoPersistable <em>Persistable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Persistable</em>'.
   * @see org.eclipse.emf.cdo.client.CdoPersistable
   * @generated
   */
  EClass getCdoPersistable();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.cdo.client.CdoPersistent <em>Persistent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Persistent</em>'.
   * @see org.eclipse.emf.cdo.client.CdoPersistent
   * @generated
   */
  EClass getCdoPersistent();

  /**
   * Returns the meta object for data type '{@link org.eclipse.emf.cdo.client.ResourceManager <em>Resource Manager</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Resource Manager</em>'.
   * @see org.eclipse.emf.cdo.client.ResourceManager
   * @model instanceClass="org.eclipse.emf.cdo.client.ResourceManager"
   * @generated
   */
  EDataType getResourceManager();

  /**
   * Returns the meta object for data type '{@link org.eclipse.emf.cdo.client.CdoResource <em>Resource</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Resource</em>'.
   * @see org.eclipse.emf.cdo.client.CdoResource
   * @model instanceClass="org.eclipse.emf.cdo.client.CdoResource" serializable="false"
   * @generated
   */
  EDataType getCdoResource();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  CdoFactory getCdoFactory();

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
     * The meta object literal for the '{@link org.eclipse.emf.cdo.client.CdoPersistable <em>Persistable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.cdo.client.CdoPersistable
     * @see org.eclipse.emf.cdo.client.impl.CdoPackageImpl#getCdoPersistable()
     * @generated
     */
    EClass CDO_PERSISTABLE = eINSTANCE.getCdoPersistable();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.cdo.client.impl.CdoPersistentImpl <em>Persistent</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.cdo.client.impl.CdoPersistentImpl
     * @see org.eclipse.emf.cdo.client.impl.CdoPackageImpl#getCdoPersistent()
     * @generated
     */
    EClass CDO_PERSISTENT = eINSTANCE.getCdoPersistent();

    /**
     * The meta object literal for the '<em>Resource Manager</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.cdo.client.ResourceManager
     * @see org.eclipse.emf.cdo.client.impl.CdoPackageImpl#getResourceManager()
     * @generated
     */
    EDataType RESOURCE_MANAGER = eINSTANCE.getResourceManager();

    /**
     * The meta object literal for the '<em>Resource</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.cdo.client.CdoResource
     * @see org.eclipse.emf.cdo.client.impl.CdoPackageImpl#getCdoResource()
     * @generated
     */
    EDataType CDO_RESOURCE = eINSTANCE.getCdoResource();

  }

} //CdoPackage
