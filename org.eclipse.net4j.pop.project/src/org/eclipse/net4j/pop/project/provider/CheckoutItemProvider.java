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
 * $Id: CheckoutItemProvider.java,v 1.1 2008-08-08 10:10:37 estepper Exp $
 */
package org.eclipse.net4j.pop.project.provider;

import org.eclipse.net4j.pop.base.provider.PopElementItemProvider;
import org.eclipse.net4j.pop.project.Checkout;
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
 * This is the item provider adapter for a {@link org.eclipse.net4j.pop.project.Checkout} object.
 * <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * @generated
 */
public class CheckoutItemProvider extends PopElementItemProvider implements IEditingDomainItemProvider,
    IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource,
    IItemColorProvider, IItemFontProvider
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public CheckoutItemProvider(AdapterFactory adapterFactory)
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

      addPopProjectPropertyDescriptor(object);
      addDiscriminatorPropertyDescriptor(object);
      addLocationPropertyDescriptor(object);
      addActivePropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Pop Project feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addPopProjectPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
        .getRootAdapterFactory(), getResourceLocator(), getString("_UI_Checkout_popProject_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Checkout_popProject_feature", "_UI_Checkout_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ProjectPackage.Literals.CHECKOUT__POP_PROJECT, false, false, false, null, null, null));
  }

  /**
   * This adds a property descriptor for the Discriminator feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addDiscriminatorPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
        .getRootAdapterFactory(), getResourceLocator(), getString("_UI_Checkout_discriminator_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Checkout_discriminator_feature", "_UI_Checkout_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ProjectPackage.Literals.CHECKOUT__DISCRIMINATOR, false, false, false, null, null, null));
  }

  /**
   * This adds a property descriptor for the Location feature.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected void addLocationPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
        .getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_Checkout_location_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Checkout_location_feature", "_UI_Checkout_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ProjectPackage.Literals.CHECKOUT__LOCATION, false, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
        null, null));
  }

  /**
   * This adds a property descriptor for the Active feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addActivePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
        .getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_Checkout_active_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_Checkout_active_feature", "_UI_Checkout_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ProjectPackage.Literals.CHECKOUT__ACTIVE, false, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
        null, null));
  }

  /**
   * This returns Checkout.gif.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object)
  {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/Checkout")); //$NON-NLS-1$
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object)
  {
    String label = ((Checkout)object).getId();
    return label == null || label.length() == 0 ? getString("_UI_Checkout_type") : //$NON-NLS-1$
        getString("_UI_Checkout_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

    switch (notification.getFeatureID(Checkout.class))
    {
    case ProjectPackage.CHECKOUT__DISCRIMINATOR:
    case ProjectPackage.CHECKOUT__LOCATION:
    case ProjectPackage.CHECKOUT__ACTIVE:
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
