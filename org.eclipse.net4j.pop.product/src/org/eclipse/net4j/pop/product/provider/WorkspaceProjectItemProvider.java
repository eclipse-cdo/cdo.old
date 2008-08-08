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
 * $Id: WorkspaceProjectItemProvider.java,v 1.1 2008-08-08 10:10:39 estepper Exp $
 */
package org.eclipse.net4j.pop.product.provider;

import org.eclipse.net4j.pop.base.provider.PopElementItemProvider;
import org.eclipse.net4j.pop.product.ProductPackage;
import org.eclipse.net4j.pop.product.WorkspaceProject;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import java.util.Collection;
import java.util.List;

/**
 * This is the item provider adapter for a {@link org.eclipse.net4j.pop.product.WorkspaceProject} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class WorkspaceProjectItemProvider extends PopElementItemProvider implements IEditingDomainItemProvider,
    IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource,
    IItemColorProvider, IItemFontProvider
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public WorkspaceProjectItemProvider(AdapterFactory adapterFactory)
  {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
  {
    if (itemPropertyDescriptors == null)
    {
      super.getPropertyDescriptors(object);

      addPopProductPropertyDescriptor(object);
      addNamePropertyDescriptor(object);
      addWorkingSetsPropertyDescriptor(object);
      addModulePropertyDescriptor(object);
      addModulePathPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Pop Product feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addPopProductPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors
        .add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
            getResourceLocator(),
            getString("_UI_WorkspaceProject_popProduct_feature"), //$NON-NLS-1$
            getString(
                "_UI_PropertyDescriptor_description", "_UI_WorkspaceProject_popProduct_feature", "_UI_WorkspaceProject_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            ProductPackage.Literals.WORKSPACE_PROJECT__POP_PRODUCT, false, false, false, null, null, null));
  }

  /**
   * This adds a property descriptor for the Name feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addNamePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
        .getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_WorkspaceProject_name_feature"), //$NON-NLS-1$
        getString(
            "_UI_PropertyDescriptor_description", "_UI_WorkspaceProject_name_feature", "_UI_WorkspaceProject_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ProductPackage.Literals.WORKSPACE_PROJECT__NAME, true, false, false,
        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
  }

  /**
   * This adds a property descriptor for the Working Sets feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addWorkingSetsPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors
        .add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
            getResourceLocator(),
            getString("_UI_WorkspaceProject_workingSets_feature"), //$NON-NLS-1$
            getString(
                "_UI_PropertyDescriptor_description", "_UI_WorkspaceProject_workingSets_feature", "_UI_WorkspaceProject_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            ProductPackage.Literals.WORKSPACE_PROJECT__WORKING_SETS, true, false, true, null, null, null));
  }

  /**
   * This adds a property descriptor for the Module feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addModulePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
        .getRootAdapterFactory(), getResourceLocator(), getString("_UI_WorkspaceProject_module_feature"), //$NON-NLS-1$
        getString(
            "_UI_PropertyDescriptor_description", "_UI_WorkspaceProject_module_feature", "_UI_WorkspaceProject_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ProductPackage.Literals.WORKSPACE_PROJECT__MODULE, true, false, true, null, null, null));
  }

  /**
   * This adds a property descriptor for the Module Path feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addModulePathPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors
        .add(createItemPropertyDescriptor(
            ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
            getResourceLocator(),
            getString("_UI_WorkspaceProject_modulePath_feature"), //$NON-NLS-1$
            getString(
                "_UI_PropertyDescriptor_description", "_UI_WorkspaceProject_modulePath_feature", "_UI_WorkspaceProject_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            ProductPackage.Literals.WORKSPACE_PROJECT__MODULE_PATH, true, false, false,
            ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
  }

  /**
   * This returns WorkspaceProject.gif.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object)
  {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/WorkspaceProject")); //$NON-NLS-1$
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object)
  {
    String label = ((WorkspaceProject)object).getName();
    return label == null || label.length() == 0 ? getString("_UI_WorkspaceProject_type") : //$NON-NLS-1$
        getString("_UI_WorkspaceProject_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification)
  {
    updateChildren(notification);

    switch (notification.getFeatureID(WorkspaceProject.class))
    {
    case ProductPackage.WORKSPACE_PROJECT__POP_PRODUCT:
    case ProductPackage.WORKSPACE_PROJECT__NAME:
    case ProductPackage.WORKSPACE_PROJECT__WORKING_SETS:
    case ProductPackage.WORKSPACE_PROJECT__MODULE:
    case ProductPackage.WORKSPACE_PROJECT__MODULE_PATH:
      fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
      return;
    }
    super.notifyChanged(notification);
  }

  /**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
   * that can be created under this object.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
  {
    super.collectNewChildDescriptors(newChildDescriptors, object);
  }

}
