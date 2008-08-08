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
 * $Id: ProjectSwitch.java,v 1.1 2008-08-08 10:10:42 estepper Exp $
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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import java.util.List;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * @see org.eclipse.net4j.pop.project.ProjectPackage
 * @generated
 */
public class ProjectSwitch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected static ProjectPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ProjectSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = ProjectPackage.eINSTANCE;
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  public T doSwitch(EObject theEObject)
  {
    return doSwitch(theEObject.eClass(), theEObject);
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(EClass theEClass, EObject theEObject)
  {
    if (theEClass.eContainer() == modelPackage)
    {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    }
    else
    {
      List<EClass> eSuperTypes = theEClass.getESuperTypes();
      return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0), theEObject);
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
    case ProjectPackage.POP_PROJECT:
    {
      PopProject popProject = (PopProject)theEObject;
      T result = casePopProject(popProject);
      if (result == null)
        result = casePopElement(popProject);
      if (result == null)
        result = caseIdentifiable(popProject);
      if (result == null)
        result = caseDisplayable(popProject);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProjectPackage.REPOSITORY:
    {
      Repository repository = (Repository)theEObject;
      T result = caseRepository(repository);
      if (result == null)
        result = casePopElement(repository);
      if (result == null)
        result = caseIdentifiable(repository);
      if (result == null)
        result = caseDisplayable(repository);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProjectPackage.COMMITTER:
    {
      Committer committer = (Committer)theEObject;
      T result = caseCommitter(committer);
      if (result == null)
        result = casePopElement(committer);
      if (result == null)
        result = caseIdentifiable(committer);
      if (result == null)
        result = caseDisplayable(committer);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProjectPackage.MODULE:
    {
      Module module = (Module)theEObject;
      T result = caseModule(module);
      if (result == null)
        result = casePopElement(module);
      if (result == null)
        result = caseIdentifiable(module);
      if (result == null)
        result = caseDisplayable(module);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProjectPackage.PRIMARY_MODULE:
    {
      PrimaryModule primaryModule = (PrimaryModule)theEObject;
      T result = casePrimaryModule(primaryModule);
      if (result == null)
        result = caseModule(primaryModule);
      if (result == null)
        result = casePopElement(primaryModule);
      if (result == null)
        result = caseIdentifiable(primaryModule);
      if (result == null)
        result = caseDisplayable(primaryModule);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProjectPackage.CHECKOUT:
    {
      Checkout checkout = (Checkout)theEObject;
      T result = caseCheckout(checkout);
      if (result == null)
        result = casePopElement(checkout);
      if (result == null)
        result = caseIdentifiable(checkout);
      if (result == null)
        result = caseDisplayable(checkout);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProjectPackage.CHECKOUT_DISCRIMINATOR:
    {
      CheckoutDiscriminator checkoutDiscriminator = (CheckoutDiscriminator)theEObject;
      T result = caseCheckoutDiscriminator(checkoutDiscriminator);
      if (result == null)
        result = casePopElement(checkoutDiscriminator);
      if (result == null)
        result = caseIdentifiable(checkoutDiscriminator);
      if (result == null)
        result = caseDisplayable(checkoutDiscriminator);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProjectPackage.TAGGED_ELEMENT:
    {
      TaggedElement taggedElement = (TaggedElement)theEObject;
      T result = caseTaggedElement(taggedElement);
      if (result == null)
        result = casePopElement(taggedElement);
      if (result == null)
        result = caseIdentifiable(taggedElement);
      if (result == null)
        result = caseDisplayable(taggedElement);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProjectPackage.TAG:
    {
      Tag tag = (Tag)theEObject;
      T result = caseTag(tag);
      if (result == null)
        result = caseCheckoutDiscriminator(tag);
      if (result == null)
        result = casePopElement(tag);
      if (result == null)
        result = caseIdentifiable(tag);
      if (result == null)
        result = caseDisplayable(tag);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProjectPackage.BRANCH:
    {
      Branch branch = (Branch)theEObject;
      T result = caseBranch(branch);
      if (result == null)
        result = caseCheckoutDiscriminator(branch);
      if (result == null)
        result = casePopElement(branch);
      if (result == null)
        result = caseIdentifiable(branch);
      if (result == null)
        result = caseDisplayable(branch);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProjectPackage.MAIN_BRANCH:
    {
      MainBranch mainBranch = (MainBranch)theEObject;
      T result = caseMainBranch(mainBranch);
      if (result == null)
        result = caseBranch(mainBranch);
      if (result == null)
        result = caseCheckoutDiscriminator(mainBranch);
      if (result == null)
        result = casePopElement(mainBranch);
      if (result == null)
        result = caseIdentifiable(mainBranch);
      if (result == null)
        result = caseDisplayable(mainBranch);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProjectPackage.SUB_BRANCH:
    {
      SubBranch subBranch = (SubBranch)theEObject;
      T result = caseSubBranch(subBranch);
      if (result == null)
        result = caseBranch(subBranch);
      if (result == null)
        result = caseTaggedElement(subBranch);
      if (result == null)
        result = caseCheckoutDiscriminator(subBranch);
      if (result == null)
        result = casePopElement(subBranch);
      if (result == null)
        result = caseIdentifiable(subBranch);
      if (result == null)
        result = caseDisplayable(subBranch);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProjectPackage.STREAM:
    {
      Stream stream = (Stream)theEObject;
      T result = caseStream(stream);
      if (result == null)
        result = casePopElement(stream);
      if (result == null)
        result = caseIdentifiable(stream);
      if (result == null)
        result = caseDisplayable(stream);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProjectPackage.TASK_STREAM:
    {
      TaskStream taskStream = (TaskStream)theEObject;
      T result = caseTaskStream(taskStream);
      if (result == null)
        result = caseStream(taskStream);
      if (result == null)
        result = casePopElement(taskStream);
      if (result == null)
        result = caseIdentifiable(taskStream);
      if (result == null)
        result = caseDisplayable(taskStream);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProjectPackage.INTEGRATION_STREAM:
    {
      IntegrationStream integrationStream = (IntegrationStream)theEObject;
      T result = caseIntegrationStream(integrationStream);
      if (result == null)
        result = caseStream(integrationStream);
      if (result == null)
        result = casePopElement(integrationStream);
      if (result == null)
        result = caseIdentifiable(integrationStream);
      if (result == null)
        result = caseDisplayable(integrationStream);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProjectPackage.DEVELOPMENT_STREAM:
    {
      DevelopmentStream developmentStream = (DevelopmentStream)theEObject;
      T result = caseDevelopmentStream(developmentStream);
      if (result == null)
        result = caseIntegrationStream(developmentStream);
      if (result == null)
        result = caseStream(developmentStream);
      if (result == null)
        result = casePopElement(developmentStream);
      if (result == null)
        result = caseIdentifiable(developmentStream);
      if (result == null)
        result = caseDisplayable(developmentStream);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProjectPackage.MAINTENANCE_STREAM:
    {
      MaintenanceStream maintenanceStream = (MaintenanceStream)theEObject;
      T result = caseMaintenanceStream(maintenanceStream);
      if (result == null)
        result = caseIntegrationStream(maintenanceStream);
      if (result == null)
        result = caseStream(maintenanceStream);
      if (result == null)
        result = casePopElement(maintenanceStream);
      if (result == null)
        result = caseIdentifiable(maintenanceStream);
      if (result == null)
        result = caseDisplayable(maintenanceStream);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProjectPackage.ROOT_STREAM:
    {
      RootStream rootStream = (RootStream)theEObject;
      T result = caseRootStream(rootStream);
      if (result == null)
        result = caseDevelopmentStream(rootStream);
      if (result == null)
        result = caseIntegrationStream(rootStream);
      if (result == null)
        result = caseStream(rootStream);
      if (result == null)
        result = casePopElement(rootStream);
      if (result == null)
        result = caseIdentifiable(rootStream);
      if (result == null)
        result = caseDisplayable(rootStream);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProjectPackage.TARGET:
    {
      Target target = (Target)theEObject;
      T result = caseTarget(target);
      if (result == null)
        result = caseTaggedElement(target);
      if (result == null)
        result = casePopElement(target);
      if (result == null)
        result = caseIdentifiable(target);
      if (result == null)
        result = caseDisplayable(target);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProjectPackage.RELEASE:
    {
      Release release = (Release)theEObject;
      T result = caseRelease(release);
      if (result == null)
        result = caseTarget(release);
      if (result == null)
        result = caseTaggedElement(release);
      if (result == null)
        result = casePopElement(release);
      if (result == null)
        result = caseIdentifiable(release);
      if (result == null)
        result = caseDisplayable(release);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProjectPackage.MILESTONE:
    {
      Milestone milestone = (Milestone)theEObject;
      T result = caseMilestone(milestone);
      if (result == null)
        result = caseTarget(milestone);
      if (result == null)
        result = caseTaggedElement(milestone);
      if (result == null)
        result = casePopElement(milestone);
      if (result == null)
        result = caseIdentifiable(milestone);
      if (result == null)
        result = caseDisplayable(milestone);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProjectPackage.DELIVERY:
    {
      Delivery delivery = (Delivery)theEObject;
      T result = caseDelivery(delivery);
      if (result == null)
        result = caseTaggedElement(delivery);
      if (result == null)
        result = casePopElement(delivery);
      if (result == null)
        result = caseIdentifiable(delivery);
      if (result == null)
        result = caseDisplayable(delivery);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProjectPackage.MERGE:
    {
      Merge merge = (Merge)theEObject;
      T result = caseMerge(merge);
      if (result == null)
        result = caseTaggedElement(merge);
      if (result == null)
        result = casePopElement(merge);
      if (result == null)
        result = caseIdentifiable(merge);
      if (result == null)
        result = caseDisplayable(merge);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    default:
      return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pop Project</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pop Project</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePopProject(PopProject object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Repository</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Repository</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRepository(Repository object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Module</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Module</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModule(Module object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primary Module</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primary Module</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimaryModule(PrimaryModule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Checkout</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Checkout</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCheckout(Checkout object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Checkout Discriminator</em>'. <!--
   * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
   * end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Checkout Discriminator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCheckoutDiscriminator(CheckoutDiscriminator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Committer</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Committer</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommitter(Committer object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tagged Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tagged Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTaggedElement(TaggedElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tag</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tag</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTag(Tag object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Branch</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Branch</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBranch(Branch object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Main Branch</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Main Branch</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMainBranch(MainBranch object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sub Branch</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sub Branch</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubBranch(SubBranch object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Stream</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Stream</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStream(Stream object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Task Stream</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Task Stream</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTaskStream(TaskStream object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Integration Stream</em>'.
   * <!-- begin-user-doc
   * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integration Stream</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntegrationStream(IntegrationStream object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Development Stream</em>'.
   * <!-- begin-user-doc
   * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Development Stream</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDevelopmentStream(DevelopmentStream object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Maintenance Stream</em>'.
   * <!-- begin-user-doc
   * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Maintenance Stream</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMaintenanceStream(MaintenanceStream object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Root Stream</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Root Stream</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRootStream(RootStream object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Target</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Target</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTarget(Target object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Release</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Release</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelease(Release object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Milestone</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Milestone</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMilestone(Milestone object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Delivery</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Delivery</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDelivery(Delivery object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Merge</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Merge</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMerge(Merge object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Identifiable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Identifiable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIdentifiable(Identifiable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Displayable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Displayable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDisplayable(Displayable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pop Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pop Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePopElement(PopElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch, but this is the last case
   * anyway. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  public T defaultCase(EObject object)
  {
    return null;
  }

} // ProjectSwitch
