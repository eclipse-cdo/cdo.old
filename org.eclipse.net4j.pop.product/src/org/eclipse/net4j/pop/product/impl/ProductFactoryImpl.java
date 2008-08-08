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
 * $Id: ProductFactoryImpl.java,v 1.1 2008-08-08 10:10:32 estepper Exp $
 */
package org.eclipse.net4j.pop.product.impl;

import org.eclipse.net4j.pop.product.Archive;
import org.eclipse.net4j.pop.product.ArchiveContent;
import org.eclipse.net4j.pop.product.File;
import org.eclipse.net4j.pop.product.Folder;
import org.eclipse.net4j.pop.product.PopProduct;
import org.eclipse.net4j.pop.product.ProductFactory;
import org.eclipse.net4j.pop.product.ProductPackage;
import org.eclipse.net4j.pop.product.SecondaryModule;
import org.eclipse.net4j.pop.product.WorkingSet;
import org.eclipse.net4j.pop.product.WorkspaceProject;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class ProductFactoryImpl extends EFactoryImpl implements ProductFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public static ProductFactory init()
  {
    try
    {
      ProductFactory theProductFactory = (ProductFactory)EPackage.Registry.INSTANCE
          .getEFactory("http://www.eclipse.org/pop/product/1.0.0"); //$NON-NLS-1$ 
      if (theProductFactory != null)
      {
        return theProductFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ProductFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ProductFactoryImpl()
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
    case ProductPackage.POP_PRODUCT:
      return createPopProduct();
    case ProductPackage.SECONDARY_MODULE:
      return createSecondaryModule();
    case ProductPackage.WORKING_SET:
      return createWorkingSet();
    case ProductPackage.WORKSPACE_PROJECT:
      return createWorkspaceProject();
    case ProductPackage.FILE:
      return createFile();
    case ProductPackage.FOLDER:
      return createFolder();
    case ProductPackage.ARCHIVE:
      return createArchive();
    case ProductPackage.ARCHIVE_CONTENT:
      return createArchiveContent();
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public PopProduct createPopProduct()
  {
    PopProductImpl popProduct = new PopProductImpl();
    return popProduct;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SecondaryModule createSecondaryModule()
  {
    SecondaryModuleImpl secondaryModule = new SecondaryModuleImpl();
    return secondaryModule;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public WorkingSet createWorkingSet()
  {
    WorkingSetImpl workingSet = new WorkingSetImpl();
    return workingSet;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public WorkspaceProject createWorkspaceProject()
  {
    WorkspaceProjectImpl workspaceProject = new WorkspaceProjectImpl();
    return workspaceProject;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public File createFile()
  {
    FileImpl file = new FileImpl();
    return file;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Folder createFolder()
  {
    FolderImpl folder = new FolderImpl();
    return folder;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Archive createArchive()
  {
    ArchiveImpl archive = new ArchiveImpl();
    return archive;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ArchiveContent createArchiveContent()
  {
    ArchiveContentImpl archiveContent = new ArchiveContentImpl();
    return archiveContent;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ProductPackage getProductPackage()
  {
    return (ProductPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ProductPackage getPackage()
  {
    return ProductPackage.eINSTANCE;
  }

} // ProductFactoryImpl
