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
 * $Id: ProjectFactory.java,v 1.1 2008-08-08 10:10:38 estepper Exp $
 */
package org.eclipse.net4j.pop.project;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * @see org.eclipse.net4j.pop.project.ProjectPackage
 * @generated
 */
public interface ProjectFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  ProjectFactory eINSTANCE = org.eclipse.net4j.pop.project.impl.ProjectFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Pop Project</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Pop Project</em>'.
   * @generated
   */
  PopProject createPopProject();

  /**
   * Returns a new object of class '<em>Repository</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Repository</em>'.
   * @generated
   */
  Repository createRepository();

  /**
   * Returns a new object of class '<em>Primary Module</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Primary Module</em>'.
   * @generated
   */
  PrimaryModule createPrimaryModule();

  /**
   * Returns a new object of class '<em>Checkout</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Checkout</em>'.
   * @generated
   */
  Checkout createCheckout();

  /**
   * Returns a new object of class '<em>Committer</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Committer</em>'.
   * @generated
   */
  Committer createCommitter();

  /**
   * Returns a new object of class '<em>Tag</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Tag</em>'.
   * @generated
   */
  Tag createTag();

  /**
   * Returns a new object of class '<em>Main Branch</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Main Branch</em>'.
   * @generated
   */
  MainBranch createMainBranch();

  /**
   * Returns a new object of class '<em>Sub Branch</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Sub Branch</em>'.
   * @generated
   */
  SubBranch createSubBranch();

  /**
   * Returns a new object of class '<em>Task Stream</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Task Stream</em>'.
   * @generated
   */
  TaskStream createTaskStream();

  /**
   * Returns a new object of class '<em>Maintenance Stream</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Maintenance Stream</em>'.
   * @generated
   */
  MaintenanceStream createMaintenanceStream();

  /**
   * Returns a new object of class '<em>Root Stream</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Root Stream</em>'.
   * @generated
   */
  RootStream createRootStream();

  /**
   * Returns a new object of class '<em>Release</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Release</em>'.
   * @generated
   */
  Release createRelease();

  /**
   * Returns a new object of class '<em>Milestone</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Milestone</em>'.
   * @generated
   */
  Milestone createMilestone();

  /**
   * Returns a new object of class '<em>Delivery</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Delivery</em>'.
   * @generated
   */
  Delivery createDelivery();

  /**
   * Returns a new object of class '<em>Merge</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return a new object of class '<em>Merge</em>'.
   * @generated
   */
  Merge createMerge();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ProjectPackage getProjectPackage();

} // ProjectFactory
