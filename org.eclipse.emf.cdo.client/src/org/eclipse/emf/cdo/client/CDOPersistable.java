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
package org.eclipse.emf.cdo.client;


import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Persistable</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.emf.cdo.client.CDOPackage#getCDOPersistable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface CDOPersistable extends EObject
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  long cdoGetOID();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  void cdoSetOID(long oid);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  int cdoGetOCA();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  void cdoSetOCA(int oca);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  void cdoLoad();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  boolean cdoIsNew();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  boolean cdoIsLoaded();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model dataType="org.eclipse.emf.cdo.client.CDOResource"
   * @generated
   */
  CDOResource cdoGetResource();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model resourceDataType="org.eclipse.emf.cdo.client.CDOResource"
   * @generated
   */
  void cdoSetResource(CDOResource resource);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  long cdoSetNew();

  /**
   * @ADDED
   */
  public static final int NOT_LOADED_YET = -1;
} // CDOPersistable
