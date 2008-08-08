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
 * $Id: CommitterItemProvider.java,v 1.1 2008-08-08 10:10:37 estepper Exp $
 */
package org.eclipse.net4j.pop.project.provider;

import org.eclipse.net4j.pop.base.provider.PopElementItemProvider;
import org.eclipse.net4j.pop.project.Committer;
import org.eclipse.net4j.pop.project.ProjectPackage;

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
 * This is the item provider adapter for a {@link org.eclipse.net4j.pop.project.Committer} object.
 * <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * @generated
 */
public class CommitterItemProvider extends PopElementItemProvider implements IEditingDomainItemProvider,
    IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource,
    IItemColorProvider, IItemFontProvider
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public CommitterItemProvider(AdapterFactory adapterFactory)
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

      addRepositoryPropertyDescriptor(object);
      addLoginPropertyDescriptor(object);
      addNamePropertyDescriptor(object);
      addEmailPropertyDescriptor(object);
      addEntryPropertyDescriptor(object);
      addExitPropertyDescriptor(object);
      addActivePropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Repository feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addRepositoryPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
        .getRootAdapterFactory(), getResourceLocator(), getString("_UI_Committer_repository_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Committer_repository_feature", "_UI_Committer_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ProjectPackage.Literals.COMMITTER__REPOSITORY, false, false, false, null, null, null));
  }

  /**
   * This adds a property descriptor for the Login feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addLoginPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
        .getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_Committer_login_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Committer_login_feature", "_UI_Committer_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ProjectPackage.Literals.COMMITTER__LOGIN, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
        null));
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
        getString("_UI_Committer_name_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Committer_name_feature", "_UI_Committer_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ProjectPackage.Literals.COMMITTER__NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
        null));
  }

  /**
   * This adds a property descriptor for the Email feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addEmailPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
        .getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_Committer_email_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Committer_email_feature", "_UI_Committer_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ProjectPackage.Literals.COMMITTER__EMAIL, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
        null));
  }

  /**
   * This adds a property descriptor for the Entry feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addEntryPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
        .getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_Committer_entry_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Committer_entry_feature", "_UI_Committer_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ProjectPackage.Literals.COMMITTER__ENTRY, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
        null));
  }

  /**
   * This adds a property descriptor for the Exit feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addExitPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
        .getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_Committer_exit_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Committer_exit_feature", "_UI_Committer_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ProjectPackage.Literals.COMMITTER__EXIT, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
        null));
  }

  /**
   * This adds a property descriptor for the Active feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addActivePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
        .getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_Committer_active_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Committer_active_feature", "_UI_Committer_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ProjectPackage.Literals.COMMITTER__ACTIVE, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
        null, null));
  }

  /**
   * This returns Committer.gif.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object)
  {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/Committer")); //$NON-NLS-1$
  }

  /**
   * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @Override
  public String getText(Object object)
  {
    String label = ((Committer)object).getName();
    return label == null || label.length() == 0 ? getString("_UI_Committer_type") : //$NON-NLS-1$
        label;
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

    switch (notification.getFeatureID(Committer.class))
    {
    case ProjectPackage.COMMITTER__LOGIN:
    case ProjectPackage.COMMITTER__NAME:
    case ProjectPackage.COMMITTER__EMAIL:
    case ProjectPackage.COMMITTER__ENTRY:
    case ProjectPackage.COMMITTER__EXIT:
    case ProjectPackage.COMMITTER__ACTIVE:
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
