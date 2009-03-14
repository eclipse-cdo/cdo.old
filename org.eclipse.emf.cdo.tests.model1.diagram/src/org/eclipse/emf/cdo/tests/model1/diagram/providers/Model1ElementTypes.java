/*
 * Copyright (c) 2008 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Victor Roldan Betancort - GMF models creation and initial generation
 *    Eike Stepper - maintenance
 */
package org.eclipse.emf.cdo.tests.model1.diagram.providers;

import org.eclipse.emf.cdo.tests.model1.Model1Package;
import org.eclipse.emf.cdo.tests.model1.diagram.part.Model1DiagramEditorPlugin;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @generated
 */
public class Model1ElementTypes extends ElementInitializers
{

  /**
   * @generated
   */
  private Model1ElementTypes()
  {
  }

  /**
   * @generated
   */
  private static Map elements;

  /**
   * @generated
   */
  private static ImageRegistry imageRegistry;

  /**
   * @generated
   */
  private static Set KNOWN_ELEMENT_TYPES;

  /**
   * @generated
   */
  public static final IElementType Company_1000 = getElementType("org.eclipse.emf.cdo.tests.model1.diagram.Company_1000"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType Supplier_2001 = getElementType("org.eclipse.emf.cdo.tests.model1.diagram.Supplier_2001"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType Category_2002 = getElementType("org.eclipse.emf.cdo.tests.model1.diagram.Category_2002"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType Customer_2003 = getElementType("org.eclipse.emf.cdo.tests.model1.diagram.Customer_2003"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType PurchaseOrder_2004 = getElementType("org.eclipse.emf.cdo.tests.model1.diagram.PurchaseOrder_2004"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType SalesOrder_2005 = getElementType("org.eclipse.emf.cdo.tests.model1.diagram.SalesOrder_2005"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType OrderAddress_2006 = getElementType("org.eclipse.emf.cdo.tests.model1.diagram.OrderAddress_2006"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType OrderDetail_2007 = getElementType("org.eclipse.emf.cdo.tests.model1.diagram.OrderDetail_2007"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType Product1_2008 = getElementType("org.eclipse.emf.cdo.tests.model1.diagram.Product1_2008"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType CategoryProducts_4001 = getElementType("org.eclipse.emf.cdo.tests.model1.diagram.CategoryProducts_4001"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType PurchaseOrderSupplier_4002 = getElementType("org.eclipse.emf.cdo.tests.model1.diagram.PurchaseOrderSupplier_4002"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType SalesOrderCustomer_4003 = getElementType("org.eclipse.emf.cdo.tests.model1.diagram.SalesOrderCustomer_4003"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType OrderOrderDetails_4004 = getElementType("org.eclipse.emf.cdo.tests.model1.diagram.OrderOrderDetails_4004"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType OrderDetailProduct_4005 = getElementType("org.eclipse.emf.cdo.tests.model1.diagram.OrderDetailProduct_4005"); //$NON-NLS-1$

  /**
   * @generated
   */
  private static ImageRegistry getImageRegistry()
  {
    if (imageRegistry == null)
    {
      imageRegistry = new ImageRegistry();
    }
    return imageRegistry;
  }

  /**
   * @generated
   */
  private static String getImageRegistryKey(ENamedElement element)
  {
    return element.getName();
  }

  /**
   * @generated
   */
  private static ImageDescriptor getProvidedImageDescriptor(ENamedElement element)
  {
    if (element instanceof EStructuralFeature)
    {
      EStructuralFeature feature = ((EStructuralFeature)element);
      EClass eContainingClass = feature.getEContainingClass();
      EClassifier eType = feature.getEType();
      if (eContainingClass != null && !eContainingClass.isAbstract())
      {
        element = eContainingClass;
      }
      else if (eType instanceof EClass && !((EClass)eType).isAbstract())
      {
        element = eType;
      }
    }
    if (element instanceof EClass)
    {
      EClass eClass = (EClass)element;
      if (!eClass.isAbstract())
      {
        return Model1DiagramEditorPlugin.getInstance().getItemImageDescriptor(
            eClass.getEPackage().getEFactoryInstance().create(eClass));
      }
    }
    // TODO : support structural features
    return null;
  }

  /**
   * @generated
   */
  public static ImageDescriptor getImageDescriptor(ENamedElement element)
  {
    String key = getImageRegistryKey(element);
    ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
    if (imageDescriptor == null)
    {
      imageDescriptor = getProvidedImageDescriptor(element);
      if (imageDescriptor == null)
      {
        imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
      }
      getImageRegistry().put(key, imageDescriptor);
    }
    return imageDescriptor;
  }

  /**
   * @generated
   */
  public static Image getImage(ENamedElement element)
  {
    String key = getImageRegistryKey(element);
    Image image = getImageRegistry().get(key);
    if (image == null)
    {
      ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
      if (imageDescriptor == null)
      {
        imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
      }
      getImageRegistry().put(key, imageDescriptor);
      image = getImageRegistry().get(key);
    }
    return image;
  }

  /**
   * @generated
   */
  public static ImageDescriptor getImageDescriptor(IAdaptable hint)
  {
    ENamedElement element = getElement(hint);
    if (element == null)
    {
      return null;
    }
    return getImageDescriptor(element);
  }

  /**
   * @generated
   */
  public static Image getImage(IAdaptable hint)
  {
    ENamedElement element = getElement(hint);
    if (element == null)
    {
      return null;
    }
    return getImage(element);
  }

  /**
   * Returns 'type' of the ecore object associated with the hint.
   * 
   * @generated
   */
  public static ENamedElement getElement(IAdaptable hint)
  {
    Object type = hint.getAdapter(IElementType.class);
    if (elements == null)
    {
      elements = new IdentityHashMap();

      elements.put(Company_1000, Model1Package.eINSTANCE.getCompany());

      elements.put(Supplier_2001, Model1Package.eINSTANCE.getSupplier());

      elements.put(Category_2002, Model1Package.eINSTANCE.getCategory());

      elements.put(Customer_2003, Model1Package.eINSTANCE.getCustomer());

      elements.put(PurchaseOrder_2004, Model1Package.eINSTANCE.getPurchaseOrder());

      elements.put(SalesOrder_2005, Model1Package.eINSTANCE.getSalesOrder());

      elements.put(OrderAddress_2006, Model1Package.eINSTANCE.getOrderAddress());

      elements.put(OrderDetail_2007, Model1Package.eINSTANCE.getOrderDetail());

      elements.put(Product1_2008, Model1Package.eINSTANCE.getProduct1());

      elements.put(CategoryProducts_4001, Model1Package.eINSTANCE.getCategory_Products());

      elements.put(PurchaseOrderSupplier_4002, Model1Package.eINSTANCE.getPurchaseOrder_Supplier());

      elements.put(SalesOrderCustomer_4003, Model1Package.eINSTANCE.getSalesOrder_Customer());

      elements.put(OrderOrderDetails_4004, Model1Package.eINSTANCE.getOrder_OrderDetails());

      elements.put(OrderDetailProduct_4005, Model1Package.eINSTANCE.getOrderDetail_Product());
    }
    return (ENamedElement)elements.get(type);
  }

  /**
   * @generated
   */
  private static IElementType getElementType(String id)
  {
    return ElementTypeRegistry.getInstance().getType(id);
  }

  /**
   * @generated
   */
  public static boolean isKnownElementType(IElementType elementType)
  {
    if (KNOWN_ELEMENT_TYPES == null)
    {
      KNOWN_ELEMENT_TYPES = new HashSet();
      KNOWN_ELEMENT_TYPES.add(Company_1000);
      KNOWN_ELEMENT_TYPES.add(Supplier_2001);
      KNOWN_ELEMENT_TYPES.add(Category_2002);
      KNOWN_ELEMENT_TYPES.add(Customer_2003);
      KNOWN_ELEMENT_TYPES.add(PurchaseOrder_2004);
      KNOWN_ELEMENT_TYPES.add(SalesOrder_2005);
      KNOWN_ELEMENT_TYPES.add(OrderAddress_2006);
      KNOWN_ELEMENT_TYPES.add(OrderDetail_2007);
      KNOWN_ELEMENT_TYPES.add(Product1_2008);
      KNOWN_ELEMENT_TYPES.add(CategoryProducts_4001);
      KNOWN_ELEMENT_TYPES.add(PurchaseOrderSupplier_4002);
      KNOWN_ELEMENT_TYPES.add(SalesOrderCustomer_4003);
      KNOWN_ELEMENT_TYPES.add(OrderOrderDetails_4004);
      KNOWN_ELEMENT_TYPES.add(OrderDetailProduct_4005);
    }
    return KNOWN_ELEMENT_TYPES.contains(elementType);
  }

}
