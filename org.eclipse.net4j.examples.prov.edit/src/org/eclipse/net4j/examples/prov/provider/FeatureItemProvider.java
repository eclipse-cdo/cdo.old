/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.examples.prov.provider;


import org.eclipse.net4j.examples.prov.Feature;
import org.eclipse.net4j.examples.prov.ProvPackage;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import java.util.Collection;
import java.util.List;


/**
 * This is the item provider adapter for a {@link org.eclipse.net4j.examples.prov.Feature} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class FeatureItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
        IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  public FeatureItemProvider(AdapterFactory adapterFactory)
  {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  public List getPropertyDescriptors(Object object)
  {
    if (itemPropertyDescriptors == null)
    {
      super.getPropertyDescriptors(object);

      addIdPropertyDescriptor(object);
      addVersionPropertyDescriptor(object);
      addUrlPropertyDescriptor(object);
      addCategoriesPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Id feature. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   */
  protected void addIdPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(
            ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
            getResourceLocator(), getString("_UI_Feature_id_feature"), getString(
                    "_UI_PropertyDescriptor_description", "_UI_Feature_id_feature",
                    "_UI_Feature_type"), ProvPackage.Literals.FEATURE__ID, true, false, false,
            ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
  }

  /**
   * This adds a property descriptor for the Version feature.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  protected void addVersionPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(
            ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
            getResourceLocator(), getString("_UI_Feature_version_feature"), getString(
                    "_UI_PropertyDescriptor_description", "_UI_Feature_version_feature",
                    "_UI_Feature_type"), ProvPackage.Literals.FEATURE__VERSION, true, false, false,
            ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
  }

  /**
   * This adds a property descriptor for the Url feature. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   */
  protected void addUrlPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(
            ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
            getResourceLocator(), getString("_UI_Feature_url_feature"), getString(
                    "_UI_PropertyDescriptor_description", "_UI_Feature_url_feature",
                    "_UI_Feature_type"), ProvPackage.Literals.FEATURE__URL, false, false, false,
            ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
  }

  /**
   * This adds a property descriptor for the Categories feature.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  protected void addCategoriesPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(
            ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
            getResourceLocator(), getString("_UI_Feature_categories_feature"), getString(
                    "_UI_PropertyDescriptor_description", "_UI_Feature_categories_feature",
                    "_UI_Feature_type"), ProvPackage.Literals.FEATURE__CATEGORIES, false, false,
            false, null, null, null));
  }

  /**
   * This returns Feature.gif.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Object getImage(Object object)
  {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/Feature"));
  }

  /**
   * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated NOT
   */
  public String getText(Object object)
  {
    String id = ((Feature)object).getId();

    if (id == null || id.length() == 0)
    {
      return getString("_UI_Feature_type");
    }

    String version = ((Feature)object).getVersion();
    return id + (version == null || version.length() == 0 ? "" : " - " + version);
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void notifyChanged(Notification notification)
  {
    updateChildren(notification);

    switch (notification.getFeatureID(Feature.class))
    {
    case ProvPackage.FEATURE__ID:
    case ProvPackage.FEATURE__VERSION:
    case ProvPackage.FEATURE__URL:
      fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false,
              true));
      return;
    }
    super.notifyChanged(notification);
  }

  /**
   * This adds to the collection of {@link org.eclipse.emf.edit.command.CommandParameter}s
   * describing all of the children that can be created under this object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object)
  {
    super.collectNewChildDescriptors(newChildDescriptors, object);
  }

  /**
   * Return the resource locator for this item provider's resources.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  public ResourceLocator getResourceLocator()
  {
    return ProvEditPlugin.INSTANCE;
  }

}
