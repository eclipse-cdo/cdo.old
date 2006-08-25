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
package org.eclipse.net4j.examples.prov.impl;


import org.eclipse.net4j.examples.prov.Category;
import org.eclipse.net4j.examples.prov.Feature;
import org.eclipse.net4j.examples.prov.ProvFactory;
import org.eclipse.net4j.examples.prov.ProvPackage;
import org.eclipse.net4j.examples.prov.Site;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.net4j.examples.prov.*;


/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class ProvFactoryImpl extends EFactoryImpl implements ProvFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ProvFactory init()
  {
    try
    {
      ProvFactory theProvFactory = (ProvFactory)EPackage.Registry.INSTANCE
              .getEFactory("http://www.eclipse.org/net4j/2006/prov");
      if (theProvFactory != null)
      {
        return theProvFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ProvFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ProvFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
    case ProvPackage.SITE:
      return createSite();
    case ProvPackage.CATEGORY:
      return createCategory();
    case ProvPackage.FEATURE:
      return createFeature();
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName()
              + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
    case ProvPackage.CATEGORIES:
      return createCategoriesFromString(eDataType, initialValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName()
              + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
    case ProvPackage.CATEGORIES:
      return convertCategoriesToString(eDataType, instanceValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName()
              + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Site createSite()
  {
    SiteImpl site = new SiteImpl();
    return site;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Feature createFeature()
  {
    FeatureImpl feature = new FeatureImpl();
    return feature;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Category createCategory()
  {
    CategoryImpl category = new CategoryImpl();
    return category;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList createCategoriesFromString(EDataType eDataType, String initialValue)
  {
    return (EList)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String convertCategoriesToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProvPackage getProvPackage()
  {
    return (ProvPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  public static ProvPackage getPackage()
  {
    return ProvPackage.eINSTANCE;
  }

} // ProvFactoryImpl
