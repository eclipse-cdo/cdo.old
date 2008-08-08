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
 * $Id: ProductSwitch.java,v 1.1 2008-08-08 10:10:40 estepper Exp $
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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import java.util.List;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * @see org.eclipse.net4j.pop.product.ProductPackage
 * @generated
 */
public class ProductSwitch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected static ProductPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ProductSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = ProductPackage.eINSTANCE;
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
    case ProductPackage.POP_PRODUCT:
    {
      PopProduct popProduct = (PopProduct)theEObject;
      T result = casePopProduct(popProduct);
      if (result == null)
        result = casePopElement(popProduct);
      if (result == null)
        result = caseIdentifiable(popProduct);
      if (result == null)
        result = caseDisplayable(popProduct);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProductPackage.SECONDARY_MODULE:
    {
      SecondaryModule secondaryModule = (SecondaryModule)theEObject;
      T result = caseSecondaryModule(secondaryModule);
      if (result == null)
        result = caseModule(secondaryModule);
      if (result == null)
        result = casePopElement(secondaryModule);
      if (result == null)
        result = caseIdentifiable(secondaryModule);
      if (result == null)
        result = caseDisplayable(secondaryModule);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProductPackage.WORKING_SET:
    {
      WorkingSet workingSet = (WorkingSet)theEObject;
      T result = caseWorkingSet(workingSet);
      if (result == null)
        result = casePopElement(workingSet);
      if (result == null)
        result = caseIdentifiable(workingSet);
      if (result == null)
        result = caseDisplayable(workingSet);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProductPackage.WORKSPACE_PROJECT:
    {
      WorkspaceProject workspaceProject = (WorkspaceProject)theEObject;
      T result = caseWorkspaceProject(workspaceProject);
      if (result == null)
        result = casePopElement(workspaceProject);
      if (result == null)
        result = caseIdentifiable(workspaceProject);
      if (result == null)
        result = caseDisplayable(workspaceProject);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProductPackage.WORKSPACE_CONFIGURATOR:
    {
      WorkspaceConfigurator workspaceConfigurator = (WorkspaceConfigurator)theEObject;
      T result = caseWorkspaceConfigurator(workspaceConfigurator);
      if (result == null)
        result = casePopElement(workspaceConfigurator);
      if (result == null)
        result = caseIdentifiable(workspaceConfigurator);
      if (result == null)
        result = caseDisplayable(workspaceConfigurator);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProductPackage.ARTIFACT:
    {
      Artifact artifact = (Artifact)theEObject;
      T result = caseArtifact(artifact);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProductPackage.FILE:
    {
      File file = (File)theEObject;
      T result = caseFile(file);
      if (result == null)
        result = caseArtifact(file);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProductPackage.FOLDER:
    {
      Folder folder = (Folder)theEObject;
      T result = caseFolder(folder);
      if (result == null)
        result = caseArtifact(folder);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProductPackage.ARCHIVE:
    {
      Archive archive = (Archive)theEObject;
      T result = caseArchive(archive);
      if (result == null)
        result = caseFile(archive);
      if (result == null)
        result = caseArtifact(archive);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProductPackage.ARCHIVE_CONTENT:
    {
      ArchiveContent archiveContent = (ArchiveContent)theEObject;
      T result = caseArchiveContent(archiveContent);
      if (result == null)
        result = caseFolder(archiveContent);
      if (result == null)
        result = caseArtifact(archiveContent);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    default:
      return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pop Product</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pop Product</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePopProduct(PopProduct object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Secondary Module</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Secondary Module</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSecondaryModule(SecondaryModule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Working Set</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Working Set</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWorkingSet(WorkingSet object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Workspace Project</em>'.
   * <!-- begin-user-doc
   * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Workspace Project</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWorkspaceProject(WorkspaceProject object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Workspace Configurator</em>'. <!--
   * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
   * end-user-doc -->
   * 
   * @param object
   *          the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Workspace Configurator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWorkspaceConfigurator(WorkspaceConfigurator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Artifact</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Artifact</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArtifact(Artifact object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>File</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>File</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFile(File object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Folder</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Folder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFolder(Folder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Archive</em>'.
   * <!-- begin-user-doc --> This
   * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Archive</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArchive(Archive object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Archive Content</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Archive Content</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArchiveContent(ArchiveContent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Identifiable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
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
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
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
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
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
   * Returns the result of interpreting the object as an instance of '<em>Module</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
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

} // ProductSwitch
