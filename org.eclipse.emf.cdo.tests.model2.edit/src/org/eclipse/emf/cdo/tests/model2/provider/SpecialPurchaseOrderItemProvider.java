/**
 * <copyright>
 * </copyright>
 *
 * $Id: SpecialPurchaseOrderItemProvider.java,v 1.4 2008-09-18 12:56:17 estepper Exp $
 */
package org.eclipse.emf.cdo.tests.model2.provider;

import org.eclipse.emf.cdo.tests.model1.Model1Factory;
import org.eclipse.emf.cdo.tests.model1.Model1Package;
import org.eclipse.emf.cdo.tests.model1.provider.PurchaseOrderItemProvider;
import org.eclipse.emf.cdo.tests.model2.Model2Package;
import org.eclipse.emf.cdo.tests.model2.SpecialPurchaseOrder;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * This is the item provider adapter for a {@link org.eclipse.emf.cdo.tests.model2.SpecialPurchaseOrder} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class SpecialPurchaseOrderItemProvider extends PurchaseOrderItemProvider implements IEditingDomainItemProvider,
    IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
  /**
   * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public SpecialPurchaseOrderItemProvider(AdapterFactory adapterFactory)
  {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
  {
    if (itemPropertyDescriptors == null)
    {
      super.getPropertyDescriptors(object);

      addDiscountCodePropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Discount Code feature. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected void addDiscountCodePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
        .getRootAdapterFactory(), getResourceLocator(), getString("_UI_SpecialPurchaseOrder_discountCode_feature"),
        getString("_UI_PropertyDescriptor_description", "_UI_SpecialPurchaseOrder_discountCode_feature",
            "_UI_SpecialPurchaseOrder_type"), Model2Package.Literals.SPECIAL_PURCHASE_ORDER__DISCOUNT_CODE, true,
        false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
  }

  /**
   * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
   * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
   * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object)
  {
    if (childrenFeatures == null)
    {
      super.getChildrenFeatures(object);
      childrenFeatures.add(Model2Package.Literals.SPECIAL_PURCHASE_ORDER__SHIPPING_ADDRESS);
    }
    return childrenFeatures;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
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
   * This returns SpecialPurchaseOrder.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object getImage(Object object)
  {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/SpecialPurchaseOrder"));
  }

  /**
   * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String getText(Object object)
  {
    Date labelValue = ((SpecialPurchaseOrder)object).getDate();
    String label = labelValue == null ? null : labelValue.toString();
    return label == null || label.length() == 0 ? getString("_UI_SpecialPurchaseOrder_type")
        : getString("_UI_SpecialPurchaseOrder_type") + " " + label;
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating a
   * viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification)
  {
    updateChildren(notification);

    switch (notification.getFeatureID(SpecialPurchaseOrder.class))
    {
    case Model2Package.SPECIAL_PURCHASE_ORDER__DISCOUNT_CODE:
      fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
      return;
    case Model2Package.SPECIAL_PURCHASE_ORDER__SHIPPING_ADDRESS:
      fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
      return;
    }
    super.notifyChanged(notification);
  }

  /**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that can be created under
   * this object. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
  {
    super.collectNewChildDescriptors(newChildDescriptors, object);

    newChildDescriptors.add(createChildParameter(Model2Package.Literals.SPECIAL_PURCHASE_ORDER__SHIPPING_ADDRESS,
        Model1Factory.eINSTANCE.createAddress()));

    newChildDescriptors.add(createChildParameter(Model2Package.Literals.SPECIAL_PURCHASE_ORDER__SHIPPING_ADDRESS,
        Model1Factory.eINSTANCE.createCompany()));

    newChildDescriptors.add(createChildParameter(Model2Package.Literals.SPECIAL_PURCHASE_ORDER__SHIPPING_ADDRESS,
        Model1Factory.eINSTANCE.createSupplier()));

    newChildDescriptors.add(createChildParameter(Model2Package.Literals.SPECIAL_PURCHASE_ORDER__SHIPPING_ADDRESS,
        Model1Factory.eINSTANCE.createCustomer()));

    newChildDescriptors.add(createChildParameter(Model2Package.Literals.SPECIAL_PURCHASE_ORDER__SHIPPING_ADDRESS,
        Model1Factory.eINSTANCE.createOrderAddress()));
  }

  /**
   * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection)
  {
    Object childFeature = feature;
    Object childObject = child;

    boolean qualify = childFeature == Model1Package.Literals.ORDER__ORDER_DETAILS
        || childFeature == Model2Package.Literals.SPECIAL_PURCHASE_ORDER__SHIPPING_ADDRESS;

    if (qualify)
    {
      return getString("_UI_CreateChild_text2", new Object[] { getTypeText(childObject), getFeatureText(childFeature),
          getTypeText(owner) });
    }
    return super.getCreateChildText(owner, feature, child, selection);
  }

}
