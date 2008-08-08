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
 * $Id: PopProductImpl.java,v 1.1 2008-08-08 10:10:32 estepper Exp $
 */
package org.eclipse.net4j.pop.product.impl;

import org.eclipse.net4j.pop.base.impl.PopElementImpl;
import org.eclipse.net4j.pop.product.PopProduct;
import org.eclipse.net4j.pop.product.ProductPackage;
import org.eclipse.net4j.pop.product.SecondaryModule;
import org.eclipse.net4j.pop.product.WorkingSet;
import org.eclipse.net4j.pop.product.WorkspaceConfigurator;
import org.eclipse.net4j.pop.product.WorkspaceProject;
import org.eclipse.net4j.pop.project.PopProject;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import java.util.Collection;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Pop Product</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.product.impl.PopProductImpl#getPopProject <em>Pop Project</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.product.impl.PopProductImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.product.impl.PopProductImpl#getSecondaryModules <em>Secondary Modules</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.product.impl.PopProductImpl#getProjects <em>Projects</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.product.impl.PopProductImpl#getWorkingSets <em>Working Sets</em>}</li>
 *   <li>{@link org.eclipse.net4j.pop.product.impl.PopProductImpl#getConfigurators <em>Configurators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PopProductImpl extends PopElementImpl implements PopProduct
{
  /**
   * The cached value of the '{@link #getPopProject() <em>Pop Project</em>}' reference.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getPopProject()
   * @generated
   * @ordered
   */
  protected PopProject popProject;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSecondaryModules() <em>Secondary Modules</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecondaryModules()
   * @generated
   * @ordered
   */
  protected EList<SecondaryModule> secondaryModules;

  /**
   * The cached value of the '{@link #getProjects() <em>Projects</em>}' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @see #getProjects()
   * @generated
   * @ordered
   */
  protected EList<WorkspaceProject> projects;

  /**
   * The cached value of the '{@link #getWorkingSets() <em>Working Sets</em>}' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getWorkingSets()
   * @generated
   * @ordered
   */
  protected EList<WorkingSet> workingSets;

  /**
   * The cached value of the '{@link #getConfigurators() <em>Configurators</em>}' containment reference list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getConfigurators()
   * @generated
   * @ordered
   */
  protected EList<WorkspaceConfigurator> configurators;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected PopProductImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ProductPackage.Literals.POP_PRODUCT;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public PopProject getPopProject()
  {
    if (popProject != null && popProject.eIsProxy())
    {
      InternalEObject oldPopProject = (InternalEObject)popProject;
      popProject = (PopProject)eResolveProxy(oldPopProject);
      if (popProject != oldPopProject)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProductPackage.POP_PRODUCT__POP_PROJECT,
              oldPopProject, popProject));
      }
    }
    return popProject;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public PopProject basicGetPopProject()
  {
    return popProject;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setPopProject(PopProject newPopProject)
  {
    PopProject oldPopProject = popProject;
    popProject = newPopProject;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProductPackage.POP_PRODUCT__POP_PROJECT, oldPopProject,
          popProject));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    // TODO: implement this method to return the 'Name' attribute
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SecondaryModule> getSecondaryModules()
  {
    if (secondaryModules == null)
    {
      secondaryModules = new EObjectContainmentWithInverseEList<SecondaryModule>(SecondaryModule.class, this,
          ProductPackage.POP_PRODUCT__SECONDARY_MODULES, ProductPackage.SECONDARY_MODULE__POP_PRODUCT);
    }
    return secondaryModules;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList<WorkspaceProject> getProjects()
  {
    if (projects == null)
    {
      projects = new EObjectContainmentWithInverseEList<WorkspaceProject>(WorkspaceProject.class, this,
          ProductPackage.POP_PRODUCT__PROJECTS, ProductPackage.WORKSPACE_PROJECT__POP_PRODUCT);
    }
    return projects;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList<WorkingSet> getWorkingSets()
  {
    if (workingSets == null)
    {
      workingSets = new EObjectContainmentWithInverseEList<WorkingSet>(WorkingSet.class, this,
          ProductPackage.POP_PRODUCT__WORKING_SETS, ProductPackage.WORKING_SET__POP_PRODUCT);
    }
    return workingSets;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList<WorkspaceConfigurator> getConfigurators()
  {
    if (configurators == null)
    {
      configurators = new EObjectContainmentWithInverseEList<WorkspaceConfigurator>(WorkspaceConfigurator.class, this,
          ProductPackage.POP_PRODUCT__CONFIGURATORS, ProductPackage.WORKSPACE_CONFIGURATOR__POP_PROJECT);
    }
    return configurators;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
    case ProductPackage.POP_PRODUCT__SECONDARY_MODULES:
      return ((InternalEList<InternalEObject>)(InternalEList<?>)getSecondaryModules()).basicAdd(otherEnd, msgs);
    case ProductPackage.POP_PRODUCT__PROJECTS:
      return ((InternalEList<InternalEObject>)(InternalEList<?>)getProjects()).basicAdd(otherEnd, msgs);
    case ProductPackage.POP_PRODUCT__WORKING_SETS:
      return ((InternalEList<InternalEObject>)(InternalEList<?>)getWorkingSets()).basicAdd(otherEnd, msgs);
    case ProductPackage.POP_PRODUCT__CONFIGURATORS:
      return ((InternalEList<InternalEObject>)(InternalEList<?>)getConfigurators()).basicAdd(otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
    case ProductPackage.POP_PRODUCT__SECONDARY_MODULES:
      return ((InternalEList<?>)getSecondaryModules()).basicRemove(otherEnd, msgs);
    case ProductPackage.POP_PRODUCT__PROJECTS:
      return ((InternalEList<?>)getProjects()).basicRemove(otherEnd, msgs);
    case ProductPackage.POP_PRODUCT__WORKING_SETS:
      return ((InternalEList<?>)getWorkingSets()).basicRemove(otherEnd, msgs);
    case ProductPackage.POP_PRODUCT__CONFIGURATORS:
      return ((InternalEList<?>)getConfigurators()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
    case ProductPackage.POP_PRODUCT__POP_PROJECT:
      if (resolve)
        return getPopProject();
      return basicGetPopProject();
    case ProductPackage.POP_PRODUCT__NAME:
      return getName();
    case ProductPackage.POP_PRODUCT__SECONDARY_MODULES:
      return getSecondaryModules();
    case ProductPackage.POP_PRODUCT__PROJECTS:
      return getProjects();
    case ProductPackage.POP_PRODUCT__WORKING_SETS:
      return getWorkingSets();
    case ProductPackage.POP_PRODUCT__CONFIGURATORS:
      return getConfigurators();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
    case ProductPackage.POP_PRODUCT__POP_PROJECT:
      setPopProject((PopProject)newValue);
      return;
    case ProductPackage.POP_PRODUCT__SECONDARY_MODULES:
      getSecondaryModules().clear();
      getSecondaryModules().addAll((Collection<? extends SecondaryModule>)newValue);
      return;
    case ProductPackage.POP_PRODUCT__PROJECTS:
      getProjects().clear();
      getProjects().addAll((Collection<? extends WorkspaceProject>)newValue);
      return;
    case ProductPackage.POP_PRODUCT__WORKING_SETS:
      getWorkingSets().clear();
      getWorkingSets().addAll((Collection<? extends WorkingSet>)newValue);
      return;
    case ProductPackage.POP_PRODUCT__CONFIGURATORS:
      getConfigurators().clear();
      getConfigurators().addAll((Collection<? extends WorkspaceConfigurator>)newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
    case ProductPackage.POP_PRODUCT__POP_PROJECT:
      setPopProject((PopProject)null);
      return;
    case ProductPackage.POP_PRODUCT__SECONDARY_MODULES:
      getSecondaryModules().clear();
      return;
    case ProductPackage.POP_PRODUCT__PROJECTS:
      getProjects().clear();
      return;
    case ProductPackage.POP_PRODUCT__WORKING_SETS:
      getWorkingSets().clear();
      return;
    case ProductPackage.POP_PRODUCT__CONFIGURATORS:
      getConfigurators().clear();
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
    case ProductPackage.POP_PRODUCT__POP_PROJECT:
      return popProject != null;
    case ProductPackage.POP_PRODUCT__NAME:
      return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
    case ProductPackage.POP_PRODUCT__SECONDARY_MODULES:
      return secondaryModules != null && !secondaryModules.isEmpty();
    case ProductPackage.POP_PRODUCT__PROJECTS:
      return projects != null && !projects.isEmpty();
    case ProductPackage.POP_PRODUCT__WORKING_SETS:
      return workingSets != null && !workingSets.isEmpty();
    case ProductPackage.POP_PRODUCT__CONFIGURATORS:
      return configurators != null && !configurators.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // PopProductImpl
