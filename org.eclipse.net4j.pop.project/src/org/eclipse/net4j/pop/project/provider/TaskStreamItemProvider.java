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
 * $Id: TaskStreamItemProvider.java,v 1.1 2008-08-08 10:10:37 estepper Exp $
 */
package org.eclipse.net4j.pop.project.provider;

import org.eclipse.net4j.pop.project.ProjectFactory;
import org.eclipse.net4j.pop.project.ProjectPackage;
import org.eclipse.net4j.pop.project.TaskStream;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
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
 * This is the item provider adapter for a {@link org.eclipse.net4j.pop.project.TaskStream} object.
 * <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * @generated
 */
public class TaskStreamItemProvider extends StreamItemProvider implements IEditingDomainItemProvider,
    IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource,
    IItemColorProvider, IItemFontProvider
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public TaskStreamItemProvider(AdapterFactory adapterFactory)
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

      addTaskIdPropertyDescriptor(object);
      addParentPropertyDescriptor(object);
      addBaselinePropertyDescriptor(object);
      addTargetsPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Task Id feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addTaskIdPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
        .getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_TaskStream_taskId_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_TaskStream_taskId_feature", "_UI_TaskStream_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ProjectPackage.Literals.TASK_STREAM__TASK_ID, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
        null, null));
  }

  /**
   * This adds a property descriptor for the Parent feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addParentPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
        .getRootAdapterFactory(), getResourceLocator(), getString("_UI_TaskStream_parent_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_TaskStream_parent_feature", "_UI_TaskStream_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ProjectPackage.Literals.TASK_STREAM__PARENT, false, false, true, null, null, null));
  }

  /**
   * This adds a property descriptor for the Baseline feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addBaselinePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
        .getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_TaskStream_baseline_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_TaskStream_baseline_feature", "_UI_TaskStream_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ProjectPackage.Literals.TASK_STREAM__BASELINE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
        null, null));
  }

  /**
   * This adds a property descriptor for the Targets feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addTargetsPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
        .getRootAdapterFactory(), getResourceLocator(), getString("_UI_TaskStream_targets_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_TaskStream_targets_feature", "_UI_TaskStream_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ProjectPackage.Literals.TASK_STREAM__TARGETS, true, false, true, null, null, null));
  }

  /**
   * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
   * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
   * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  @Override
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object)
  {
    if (childrenFeatures == null)
    {
      super.getChildrenFeatures(object);
      childrenFeatures.add(ProjectPackage.Literals.TASK_STREAM__DELIVERIES);
    }
    return childrenFeatures;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EStructuralFeature getChildFeature(Object object, Object child)
  {
    // Check the type of the specified child object and return the proper feature to use for
    // adding (see {@link AddCommand}) it as a child.

    return super.getChildFeature(object, child);
  }

  /**
   * This returns TaskStream.gif.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object)
  {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/TaskStream")); //$NON-NLS-1$
  }

  /**
   * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @Override
  public String getText(Object object)
  {
    String label = ((TaskStream)object).getTaskId();
    return label == null || label.length() == 0 ? getString("_UI_TaskStream_type") : //$NON-NLS-1$
        "Task " + label;
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

    switch (notification.getFeatureID(TaskStream.class))
    {
    case ProjectPackage.TASK_STREAM__TASK_ID:
    case ProjectPackage.TASK_STREAM__PARENT:
    case ProjectPackage.TASK_STREAM__BASELINE:
      fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
      return;
    case ProjectPackage.TASK_STREAM__DELIVERIES:
      fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

    newChildDescriptors.add(createChildParameter(ProjectPackage.Literals.TASK_STREAM__DELIVERIES,
        ProjectFactory.eINSTANCE.createDelivery()));
  }

}
