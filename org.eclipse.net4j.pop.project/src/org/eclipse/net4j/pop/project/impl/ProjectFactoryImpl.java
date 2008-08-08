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
 * $Id: ProjectFactoryImpl.java,v 1.1 2008-08-08 10:10:30 estepper Exp $
 */
package org.eclipse.net4j.pop.project.impl;

import org.eclipse.net4j.pop.project.Checkout;
import org.eclipse.net4j.pop.project.Committer;
import org.eclipse.net4j.pop.project.Delivery;
import org.eclipse.net4j.pop.project.MainBranch;
import org.eclipse.net4j.pop.project.MaintenanceStream;
import org.eclipse.net4j.pop.project.Merge;
import org.eclipse.net4j.pop.project.Milestone;
import org.eclipse.net4j.pop.project.PopProject;
import org.eclipse.net4j.pop.project.PrimaryModule;
import org.eclipse.net4j.pop.project.ProjectFactory;
import org.eclipse.net4j.pop.project.ProjectPackage;
import org.eclipse.net4j.pop.project.Release;
import org.eclipse.net4j.pop.project.Repository;
import org.eclipse.net4j.pop.project.RootStream;
import org.eclipse.net4j.pop.project.SubBranch;
import org.eclipse.net4j.pop.project.Tag;
import org.eclipse.net4j.pop.project.TaskStream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class ProjectFactoryImpl extends EFactoryImpl implements ProjectFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public static ProjectFactory init()
  {
    try
    {
      ProjectFactory theProjectFactory = (ProjectFactory)EPackage.Registry.INSTANCE
          .getEFactory("http://www.eclipse.org/pop/project/1.0.0"); //$NON-NLS-1$ 
      if (theProjectFactory != null)
      {
        return theProjectFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ProjectFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ProjectFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
    case ProjectPackage.POP_PROJECT:
      return createPopProject();
    case ProjectPackage.REPOSITORY:
      return createRepository();
    case ProjectPackage.COMMITTER:
      return createCommitter();
    case ProjectPackage.PRIMARY_MODULE:
      return createPrimaryModule();
    case ProjectPackage.CHECKOUT:
      return createCheckout();
    case ProjectPackage.TAG:
      return createTag();
    case ProjectPackage.MAIN_BRANCH:
      return createMainBranch();
    case ProjectPackage.SUB_BRANCH:
      return createSubBranch();
    case ProjectPackage.TASK_STREAM:
      return createTaskStream();
    case ProjectPackage.MAINTENANCE_STREAM:
      return createMaintenanceStream();
    case ProjectPackage.ROOT_STREAM:
      return createRootStream();
    case ProjectPackage.RELEASE:
      return createRelease();
    case ProjectPackage.MILESTONE:
      return createMilestone();
    case ProjectPackage.DELIVERY:
      return createDelivery();
    case ProjectPackage.MERGE:
      return createMerge();
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public PopProject createPopProject()
  {
    PopProjectImpl popProject = new PopProjectImpl();
    return popProject;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Repository createRepository()
  {
    RepositoryImpl repository = new RepositoryImpl();
    return repository;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public PrimaryModule createPrimaryModule()
  {
    PrimaryModuleImpl primaryModule = new PrimaryModuleImpl();
    return primaryModule;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Checkout createCheckout()
  {
    CheckoutImpl checkout = new CheckoutImpl();
    return checkout;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Committer createCommitter()
  {
    CommitterImpl committer = new CommitterImpl();
    return committer;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Tag createTag()
  {
    TagImpl tag = new TagImpl();
    return tag;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public MainBranch createMainBranch()
  {
    MainBranchImpl mainBranch = new MainBranchImpl();
    return mainBranch;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public SubBranch createSubBranch()
  {
    SubBranchImpl subBranch = new SubBranchImpl();
    return subBranch;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public TaskStream createTaskStream()
  {
    TaskStreamImpl taskStream = new TaskStreamImpl();
    return taskStream;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public MaintenanceStream createMaintenanceStream()
  {
    MaintenanceStreamImpl maintenanceStream = new MaintenanceStreamImpl();
    return maintenanceStream;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public RootStream createRootStream()
  {
    RootStreamImpl rootStream = new RootStreamImpl();
    return rootStream;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Release createRelease()
  {
    ReleaseImpl release = new ReleaseImpl();
    return release;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Milestone createMilestone()
  {
    MilestoneImpl milestone = new MilestoneImpl();
    return milestone;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Delivery createDelivery()
  {
    DeliveryImpl delivery = new DeliveryImpl();
    return delivery;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Merge createMerge()
  {
    MergeImpl merge = new MergeImpl();
    return merge;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ProjectPackage getProjectPackage()
  {
    return (ProjectPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ProjectPackage getPackage()
  {
    return ProjectPackage.eINSTANCE;
  }

} // ProjectFactoryImpl
