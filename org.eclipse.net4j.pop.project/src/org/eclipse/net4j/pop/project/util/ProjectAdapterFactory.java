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
 * $Id: ProjectAdapterFactory.java,v 1.1 2008-08-08 10:10:42 estepper Exp $
 */
package org.eclipse.net4j.pop.project.util;

import org.eclipse.net4j.pop.base.Displayable;
import org.eclipse.net4j.pop.base.Identifiable;
import org.eclipse.net4j.pop.base.PopElement;
import org.eclipse.net4j.pop.project.Branch;
import org.eclipse.net4j.pop.project.Checkout;
import org.eclipse.net4j.pop.project.CheckoutDiscriminator;
import org.eclipse.net4j.pop.project.Committer;
import org.eclipse.net4j.pop.project.Delivery;
import org.eclipse.net4j.pop.project.DevelopmentStream;
import org.eclipse.net4j.pop.project.IntegrationStream;
import org.eclipse.net4j.pop.project.MainBranch;
import org.eclipse.net4j.pop.project.MaintenanceStream;
import org.eclipse.net4j.pop.project.Merge;
import org.eclipse.net4j.pop.project.Milestone;
import org.eclipse.net4j.pop.project.Module;
import org.eclipse.net4j.pop.project.PopProject;
import org.eclipse.net4j.pop.project.PrimaryModule;
import org.eclipse.net4j.pop.project.ProjectPackage;
import org.eclipse.net4j.pop.project.Release;
import org.eclipse.net4j.pop.project.Repository;
import org.eclipse.net4j.pop.project.RootStream;
import org.eclipse.net4j.pop.project.Stream;
import org.eclipse.net4j.pop.project.SubBranch;
import org.eclipse.net4j.pop.project.Tag;
import org.eclipse.net4j.pop.project.TaggedElement;
import org.eclipse.net4j.pop.project.Target;
import org.eclipse.net4j.pop.project.TaskStream;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * @see org.eclipse.net4j.pop.project.ProjectPackage
 * @generated
 */
public class ProjectAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected static ProjectPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ProjectAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = ProjectPackage.eINSTANCE;
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
  protected ProjectSwitch<Adapter> modelSwitch = new ProjectSwitch<Adapter>()
  {
    @Override
    public Adapter casePopProject(PopProject object)
    {
      return createPopProjectAdapter();
    }

    @Override
    public Adapter caseRepository(Repository object)
    {
      return createRepositoryAdapter();
    }

    @Override
    public Adapter caseCommitter(Committer object)
    {
      return createCommitterAdapter();
    }

    @Override
    public Adapter caseModule(Module object)
    {
      return createModuleAdapter();
    }

    @Override
    public Adapter casePrimaryModule(PrimaryModule object)
    {
      return createPrimaryModuleAdapter();
    }

    @Override
    public Adapter caseCheckout(Checkout object)
    {
      return createCheckoutAdapter();
    }

    @Override
    public Adapter caseCheckoutDiscriminator(CheckoutDiscriminator object)
    {
      return createCheckoutDiscriminatorAdapter();
    }

    @Override
    public Adapter caseTaggedElement(TaggedElement object)
    {
      return createTaggedElementAdapter();
    }

    @Override
    public Adapter caseTag(Tag object)
    {
      return createTagAdapter();
    }

    @Override
    public Adapter caseBranch(Branch object)
    {
      return createBranchAdapter();
    }

    @Override
    public Adapter caseMainBranch(MainBranch object)
    {
      return createMainBranchAdapter();
    }

    @Override
    public Adapter caseSubBranch(SubBranch object)
    {
      return createSubBranchAdapter();
    }

    @Override
    public Adapter caseStream(Stream object)
    {
      return createStreamAdapter();
    }

    @Override
    public Adapter caseTaskStream(TaskStream object)
    {
      return createTaskStreamAdapter();
    }

    @Override
    public Adapter caseIntegrationStream(IntegrationStream object)
    {
      return createIntegrationStreamAdapter();
    }

    @Override
    public Adapter caseDevelopmentStream(DevelopmentStream object)
    {
      return createDevelopmentStreamAdapter();
    }

    @Override
    public Adapter caseMaintenanceStream(MaintenanceStream object)
    {
      return createMaintenanceStreamAdapter();
    }

    @Override
    public Adapter caseRootStream(RootStream object)
    {
      return createRootStreamAdapter();
    }

    @Override
    public Adapter caseTarget(Target object)
    {
      return createTargetAdapter();
    }

    @Override
    public Adapter caseRelease(Release object)
    {
      return createReleaseAdapter();
    }

    @Override
    public Adapter caseMilestone(Milestone object)
    {
      return createMilestoneAdapter();
    }

    @Override
    public Adapter caseDelivery(Delivery object)
    {
      return createDeliveryAdapter();
    }

    @Override
    public Adapter caseMerge(Merge object)
    {
      return createMergeAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.PopProject <em>Pop Project</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
   * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.PopProject
   * @generated
   */
  public Adapter createPopProjectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.Repository <em>Repository</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
   * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.Repository
   * @generated
   */
  public Adapter createRepositoryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.Module <em>Module</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.Module
   * @generated
   */
  public Adapter createModuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.PrimaryModule <em>Primary Module</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily
   * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.PrimaryModule
   * @generated
   */
  public Adapter createPrimaryModuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.Checkout <em>Checkout</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.Checkout
   * @generated
   */
  public Adapter createCheckoutAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.CheckoutDiscriminator <em>Checkout Discriminator</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can
   * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.CheckoutDiscriminator
   * @generated
   */
  public Adapter createCheckoutDiscriminatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.Committer <em>Committer</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.Committer
   * @generated
   */
  public Adapter createCommitterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.TaggedElement <em>Tagged Element</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily
   * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.TaggedElement
   * @generated
   */
  public Adapter createTaggedElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.Tag <em>Tag</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.Tag
   * @generated
   */
  public Adapter createTagAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.Branch <em>Branch</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.Branch
   * @generated
   */
  public Adapter createBranchAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.MainBranch <em>Main Branch</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
   * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.MainBranch
   * @generated
   */
  public Adapter createMainBranchAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.SubBranch <em>Sub Branch</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.SubBranch
   * @generated
   */
  public Adapter createSubBranchAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.Stream <em>Stream</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.Stream
   * @generated
   */
  public Adapter createStreamAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.TaskStream <em>Task Stream</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
   * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.TaskStream
   * @generated
   */
  public Adapter createTaskStreamAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.IntegrationStream <em>Integration Stream</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can
   * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.IntegrationStream
   * @generated
   */
  public Adapter createIntegrationStreamAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.DevelopmentStream <em>Development Stream</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can
   * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.DevelopmentStream
   * @generated
   */
  public Adapter createDevelopmentStreamAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.MaintenanceStream <em>Maintenance Stream</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can
   * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
   * end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.MaintenanceStream
   * @generated
   */
  public Adapter createMaintenanceStreamAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.RootStream <em>Root Stream</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
   * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.RootStream
   * @generated
   */
  public Adapter createRootStreamAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.Target <em>Target</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.Target
   * @generated
   */
  public Adapter createTargetAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.Release <em>Release</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.Release
   * @generated
   */
  public Adapter createReleaseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.Milestone <em>Milestone</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.Milestone
   * @generated
   */
  public Adapter createMilestoneAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.Delivery <em>Delivery</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.Delivery
   * @generated
   */
  public Adapter createDeliveryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.project.Merge <em>Merge</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.project.Merge
   * @generated
   */
  public Adapter createMergeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.net4j.pop.base.Identifiable <em>Identifiable</em>}'.
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
   * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
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
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
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
   * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.net4j.pop.base.PopElement
   * @generated
   */
  public Adapter createPopElementAdapter()
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

} // ProjectAdapterFactory
