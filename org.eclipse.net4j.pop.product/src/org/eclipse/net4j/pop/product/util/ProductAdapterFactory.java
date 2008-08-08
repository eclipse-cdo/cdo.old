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
 * $Id: ProductAdapterFactory.java,v 1.1 2008-08-08 10:10:40 estepper Exp $
 */
package org.eclipse.net4j.pop.product.util;

import org.eclipse.net4j.pop.base.Displayable;
import org.eclipse.net4j.pop.base.Identifiable;
import org.eclipse.net4j.pop.base.PopElement;
import org.eclipse.net4j.pop.product.Archive;
import org.eclipse.net4j.pop.product.ArchiveContent;
import org.eclipse.net4j.pop.product.Artifact;
import org.eclipse.net4j.pop.product.File;
import org.eclipse.net4j.pop.product.Folder;
import org.eclipse.net4j.pop.product.PopProduct;
import org.eclipse.net4j.pop.product.ProductPackage;
import org.eclipse.net4j.pop.product.SecondaryModule;
import org.eclipse.net4j.pop.product.WorkingSet;
import org.eclipse.net4j.pop.product.WorkspaceConfigurator;
import org.eclipse.net4j.pop.product.WorkspaceProject;
import org.eclipse.net4j.pop.project.Module;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * @see org.eclipse.net4j.pop.product.ProductPackage
 * @generated
 */
public class ProductAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected static ProductPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ProductAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = ProductPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc --> This implementation
   * returns <code>true</code> if the object is either the model's package or is an instance object of the model. <!--
   * end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected ProductSwitch<Adapter> modelSwitch = new ProductSwitch<Adapter>()
  {
    @Override
    public Adapter casePopProduct(PopProduct object)
    {
      return createPopProductAdapter();
    }

    @Override
    public Adapter caseSecondaryModule(SecondaryModule object)
    {
      return createSecondaryModuleAdapter();
    }

    @Override
    public Adapter caseWorkingSet(WorkingSet object)
    {
      return createWorkingSetAdapter();
    }

    @Override
    public Adapter caseWorkspaceProject(WorkspaceProject object)
    {
      return createWorkspaceProjectAdapter();
    }

    @Override
    public Adapter caseWorkspaceConfigurator(WorkspaceConfigurator object)
    {
      return createWorkspaceConfiguratorAdapter();
    }

    @Override
    public Adapter caseArtifact(Artifact object)
    {
      return createArtifactAdapter();
    }

    @Override
    public Adapter caseFile(File object)
    {
      return createFileAdapter();
    }

    @Override
    public Adapter caseFolder(Folder object)
    {
      return createFolderAdapter();
    }

    @Override
    public Adapter caseArchive(Archive object)
    {
      return createArchiveAdapter();
    }

    @Override
    public Adapter caseArchiveContent(ArchiveContent object)
    {
      return createArchiveContentAdapter();
    }

    @Override
    public Adapter caseIdentifiable(Identifiable object)
    {
      return createIdentifiableAdapter();
    }

    @Override
    public Adapter caseDisplayable(Displayable object)
    {
      return createDisplayableAdapter();
    }

    @Override
    public Adapter casePopElement(PopElement object)
    {
      return createPopElementAdapter();
    }

    @Override
    public Adapter caseModule(Module object)
    {
      return createModuleAdapter();
    }

    @Override
    public Adapter defaultCase(EObject object)
    {
      return createEObjectAdapter();
    }
  };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.product.PopProduct <em>Pop Product</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
   * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.product.PopProduct
   * @generated
   */
  public Adapter createPopProductAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.product.SecondaryModule <em>Secondary Module</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.product.SecondaryModule
   * @generated
   */
  public Adapter createSecondaryModuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.product.WorkingSet <em>Working Set</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
   * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.product.WorkingSet
   * @generated
   */
  public Adapter createWorkingSetAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.product.WorkspaceProject <em>Workspace Project</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can
   * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.product.WorkspaceProject
   * @generated
   */
  public Adapter createWorkspaceProjectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.product.WorkspaceConfigurator <em>Workspace Configurator</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can
   * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.product.WorkspaceConfigurator
   * @generated
   */
  public Adapter createWorkspaceConfiguratorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.product.Artifact <em>Artifact</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.product.Artifact
   * @generated
   */
  public Adapter createArtifactAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.product.File <em>File</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.product.File
   * @generated
   */
  public Adapter createFileAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.product.Folder <em>Folder</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.product.Folder
   * @generated
   */
  public Adapter createFolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.product.Archive <em>Archive</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.product.Archive
   * @generated
   */
  public Adapter createArchiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.product.ArchiveContent <em>Archive Content</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily
   * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.product.ArchiveContent
   * @generated
   */
  public Adapter createArchiveContentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.base.Identifiable <em>Identifiable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.base.Identifiable
   * @generated
   */
  public Adapter createIdentifiableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.base.Displayable <em>Displayable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.base.Displayable
   * @generated
   */
  public Adapter createDisplayableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.base.PopElement <em>Pop Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.base.PopElement
   * @generated
   */
  public Adapter createPopElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.Module <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.Module
   * @generated
   */
  public Adapter createModuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc --> This default implementation returns null. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} // ProductAdapterFactory
