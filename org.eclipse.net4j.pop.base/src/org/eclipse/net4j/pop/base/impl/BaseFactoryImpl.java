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
 * $Id: BaseFactoryImpl.java,v 1.1 2008-08-08 10:10:36 estepper Exp $
 */
package org.eclipse.net4j.pop.base.impl;

import org.eclipse.net4j.pop.base.BaseFactory;
import org.eclipse.net4j.pop.base.BasePackage;
import org.eclipse.net4j.pop.base.Version;
import org.eclipse.net4j.pop.repository.IRepositoryAdapter;
import org.eclipse.net4j.pop.repository.IRepositoryFolder;
import org.eclipse.net4j.pop.repository.IRepositorySession;
import org.eclipse.net4j.pop.repository.IRepositoryTag;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.core.runtime.IPath;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class BaseFactoryImpl extends EFactoryImpl implements BaseFactory
{
  /**
   * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public static BaseFactory init()
  {
    try
    {
      BaseFactory theBaseFactory = (BaseFactory)EPackage.Registry.INSTANCE
          .getEFactory("http://www.eclipse.org/pop/base/1.0.0"); //$NON-NLS-1$ 
      if (theBaseFactory != null)
      {
        return theBaseFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new BaseFactoryImpl();
  }

  /**
   * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public BaseFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
    case BasePackage.VERSION:
      return createVersionFromString(eDataType, initialValue);
    case BasePackage.PATH:
      return createPathFromString(eDataType, initialValue);
    case BasePackage.REPOSITORY_ADAPTER:
      return createRepositoryAdapterFromString(eDataType, initialValue);
    case BasePackage.REPOSITORY_SESSION:
      return createRepositorySessionFromString(eDataType, initialValue);
    case BasePackage.REPOSITORY_FOLDER:
      return createRepositoryFolderFromString(eDataType, initialValue);
    case BasePackage.REPOSITORY_TAG:
      return createRepositoryTagFromString(eDataType, initialValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
    case BasePackage.VERSION:
      return convertVersionToString(eDataType, instanceValue);
    case BasePackage.PATH:
      return convertPathToString(eDataType, instanceValue);
    case BasePackage.REPOSITORY_ADAPTER:
      return convertRepositoryAdapterToString(eDataType, instanceValue);
    case BasePackage.REPOSITORY_SESSION:
      return convertRepositorySessionToString(eDataType, instanceValue);
    case BasePackage.REPOSITORY_FOLDER:
      return convertRepositoryFolderToString(eDataType, instanceValue);
    case BasePackage.REPOSITORY_TAG:
      return convertRepositoryTagToString(eDataType, instanceValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Version createVersionFromString(EDataType eDataType, String initialValue)
  {
    return new Version(initialValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public String convertVersionToString(EDataType eDataType, Object instanceValue)
  {
    return ((Version)instanceValue).toString();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public IPath createPathFromString(EDataType eDataType, String initialValue)
  {
    return (IPath)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String convertPathToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public IRepositoryAdapter createRepositoryAdapterFromString(EDataType eDataType, String initialValue)
  {
    return (IRepositoryAdapter)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String convertRepositoryAdapterToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public IRepositorySession createRepositorySessionFromString(EDataType eDataType, String initialValue)
  {
    return (IRepositorySession)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String convertRepositorySessionToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public IRepositoryFolder createRepositoryFolderFromString(EDataType eDataType, String initialValue)
  {
    return (IRepositoryFolder)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String convertRepositoryFolderToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public IRepositoryTag createRepositoryTagFromString(EDataType eDataType, String initialValue)
  {
    return (IRepositoryTag)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String convertRepositoryTagToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public BasePackage getBasePackage()
  {
    return (BasePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @deprecated
   * @generated
   */
  @Deprecated
  public static BasePackage getPackage()
  {
    return BasePackage.eINSTANCE;
  }

} // BaseFactoryImpl
