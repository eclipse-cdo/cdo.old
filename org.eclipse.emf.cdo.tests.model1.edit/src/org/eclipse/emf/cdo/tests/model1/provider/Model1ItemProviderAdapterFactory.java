/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.cdo.tests.model1.provider;

import org.eclipse.emf.cdo.tests.model1.Model1Package;
import org.eclipse.emf.cdo.tests.model1.util.Model1AdapterFactory;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ChildCreationExtenderManager;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers. The adapters generated by this
 * factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}. The adapters
 * also support Eclipse property sheets. Note that most of the adapters are shared among multiple instances. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class Model1ItemProviderAdapterFactory extends Model1AdapterFactory implements ComposeableAdapterFactory,
    IChangeNotifier, IDisposable, IChildCreationExtender
{
  /**
   * This keeps track of the root adapter factory that delegates to this adapter factory. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  protected ComposedAdapterFactory parentAdapterFactory;

  /**
   * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  protected IChangeNotifier changeNotifier = new ChangeNotifier();

  /**
   * This helps manage the child creation extenders. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected ChildCreationExtenderManager childCreationExtenderManager = new ChildCreationExtenderManager(
      Model1EditPlugin.INSTANCE, Model1Package.eNS_URI);

  /**
   * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected Collection<Object> supportedTypes = new ArrayList<Object>();

  /**
   * This constructs an instance. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Model1ItemProviderAdapterFactory()
  {
    supportedTypes.add(IEditingDomainItemProvider.class);
    supportedTypes.add(IStructuredItemContentProvider.class);
    supportedTypes.add(ITreeItemContentProvider.class);
    supportedTypes.add(IItemLabelProvider.class);
    supportedTypes.add(IItemPropertySource.class);
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.emf.cdo.tests.model1.Address} instances. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected AddressItemProvider addressItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.emf.cdo.tests.model1.Address}. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Adapter createAddressAdapter()
  {
    if (addressItemProvider == null)
    {
      addressItemProvider = new AddressItemProvider(this);
    }

    return addressItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.emf.cdo.tests.model1.Supplier} instances. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected SupplierItemProvider supplierItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.emf.cdo.tests.model1.Supplier}. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Adapter createSupplierAdapter()
  {
    if (supplierItemProvider == null)
    {
      supplierItemProvider = new SupplierItemProvider(this);
    }

    return supplierItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.emf.cdo.tests.model1.PurchaseOrder} instances.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected PurchaseOrderItemProvider purchaseOrderItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.emf.cdo.tests.model1.PurchaseOrder}. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Adapter createPurchaseOrderAdapter()
  {
    if (purchaseOrderItemProvider == null)
    {
      purchaseOrderItemProvider = new PurchaseOrderItemProvider(this);
    }

    return purchaseOrderItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.emf.cdo.tests.model1.OrderDetail} instances.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected OrderDetailItemProvider orderDetailItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.emf.cdo.tests.model1.OrderDetail}. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Adapter createOrderDetailAdapter()
  {
    if (orderDetailItemProvider == null)
    {
      orderDetailItemProvider = new OrderDetailItemProvider(this);
    }

    return orderDetailItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.emf.cdo.tests.model1.OrderAddress} instances.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected OrderAddressItemProvider orderAddressItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.emf.cdo.tests.model1.OrderAddress}. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Adapter createOrderAddressAdapter()
  {
    if (orderAddressItemProvider == null)
    {
      orderAddressItemProvider = new OrderAddressItemProvider(this);
    }

    return orderAddressItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.emf.cdo.tests.model1.Category} instances. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected CategoryItemProvider categoryItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.emf.cdo.tests.model1.Category}. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Adapter createCategoryAdapter()
  {
    if (categoryItemProvider == null)
    {
      categoryItemProvider = new CategoryItemProvider(this);
    }

    return categoryItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.emf.cdo.tests.model1.Product1} instances. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected Product1ItemProvider product1ItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.emf.cdo.tests.model1.Product1}. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Adapter createProduct1Adapter()
  {
    if (product1ItemProvider == null)
    {
      product1ItemProvider = new Product1ItemProvider(this);
    }

    return product1ItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.emf.cdo.tests.model1.Company} instances. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected CompanyItemProvider companyItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.emf.cdo.tests.model1.Company}. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Adapter createCompanyAdapter()
  {
    if (companyItemProvider == null)
    {
      companyItemProvider = new CompanyItemProvider(this);
    }

    return companyItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.emf.cdo.tests.model1.Customer} instances. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected CustomerItemProvider customerItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.emf.cdo.tests.model1.Customer}. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Adapter createCustomerAdapter()
  {
    if (customerItemProvider == null)
    {
      customerItemProvider = new CustomerItemProvider(this);
    }

    return customerItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.emf.cdo.tests.model1.Order} instances. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected OrderItemProvider orderItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.emf.cdo.tests.model1.Order}. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Adapter createOrderAdapter()
  {
    if (orderItemProvider == null)
    {
      orderItemProvider = new OrderItemProvider(this);
    }

    return orderItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.emf.cdo.tests.model1.SalesOrder} instances.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected SalesOrderItemProvider salesOrderItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.emf.cdo.tests.model1.SalesOrder}. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Adapter createSalesOrderAdapter()
  {
    if (salesOrderItemProvider == null)
    {
      salesOrderItemProvider = new SalesOrderItemProvider(this);
    }

    return salesOrderItemProvider;
  }

  /**
   * This returns the root adapter factory that contains this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public ComposeableAdapterFactory getRootAdapterFactory()
  {
    return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
  }

  /**
   * This sets the composed adapter factory that contains this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory)
  {
    this.parentAdapterFactory = parentAdapterFactory;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object type)
  {
    return supportedTypes.contains(type) || super.isFactoryForType(type);
  }

  /**
   * This implementation substitutes the factory itself as the key for the adapter. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Adapter adapt(Notifier notifier, Object type)
  {
    return super.adapt(notifier, this);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object adapt(Object object, Object type)
  {
    if (isFactoryForType(type))
    {
      Object adapter = super.adapt(object, type);
      if (!(type instanceof Class<?>) || ((Class<?>)type).isInstance(adapter))
      {
        return adapter;
      }
    }

    return null;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public List<IChildCreationExtender> getChildCreationExtenders()
  {
    return childCreationExtenderManager.getChildCreationExtenders();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain)
  {
    return childCreationExtenderManager.getNewChildDescriptors(object, editingDomain);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public ResourceLocator getResourceLocator()
  {
    return childCreationExtenderManager;
  }

  /**
   * This adds a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void addListener(INotifyChangedListener notifyChangedListener)
  {
    changeNotifier.addListener(notifyChangedListener);
  }

  /**
   * This removes a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void removeListener(INotifyChangedListener notifyChangedListener)
  {
    changeNotifier.removeListener(notifyChangedListener);
  }

  /**
   * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  public void fireNotifyChanged(Notification notification)
  {
    changeNotifier.fireNotifyChanged(notification);

    if (parentAdapterFactory != null)
    {
      parentAdapterFactory.fireNotifyChanged(notification);
    }
  }

  /**
   * This disposes all of the item providers created by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void dispose()
  {
    if (addressItemProvider != null)
    {
      addressItemProvider.dispose();
    }
    if (companyItemProvider != null)
    {
      companyItemProvider.dispose();
    }
    if (supplierItemProvider != null)
    {
      supplierItemProvider.dispose();
    }
    if (customerItemProvider != null)
    {
      customerItemProvider.dispose();
    }
    if (orderItemProvider != null)
    {
      orderItemProvider.dispose();
    }
    if (orderDetailItemProvider != null)
    {
      orderDetailItemProvider.dispose();
    }
    if (purchaseOrderItemProvider != null)
    {
      purchaseOrderItemProvider.dispose();
    }
    if (salesOrderItemProvider != null)
    {
      salesOrderItemProvider.dispose();
    }
    if (categoryItemProvider != null)
    {
      categoryItemProvider.dispose();
    }
    if (product1ItemProvider != null)
    {
      product1ItemProvider.dispose();
    }
    if (orderAddressItemProvider != null)
    {
      orderAddressItemProvider.dispose();
    }
  }

}
