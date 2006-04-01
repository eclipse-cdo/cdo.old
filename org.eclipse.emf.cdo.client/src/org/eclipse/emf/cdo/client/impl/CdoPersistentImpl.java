/*******************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Sympedia Methods and Tools.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.cdo.client.impl;


import org.eclipse.emf.cdo.client.CdoPackage;
import org.eclipse.emf.cdo.client.CdoPersistent;
import org.eclipse.emf.cdo.client.CdoResource;
import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;

import org.apache.log4j.Logger;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Persistent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class CdoPersistentImpl extends EObjectImpl implements CdoPersistent
{
  /**
   * @ADDED
   */
  private static final Logger logger = Logger.getLogger(CdoPersistentImpl.class);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CdoPersistentImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass()
  {
    return CdoPackage.Literals.CDO_PERSISTENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public long cdoGetOID()
  {
    return oid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void cdoSetOID(long oid, CdoResource resource)
  {
    this.oid = oid;

    if (resource != null && eDirectResource() == null && eContainer() == null)
    {
      eSetResource((Resource.Internal)resource, null);
      //      eProperties().setEResource((Resource.Internal) resource);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public int cdoGetOCA()
  {
    return oca;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void cdoSetOCA(int oca)
  {
    this.oca = oca;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void cdoLoad()
  {
    try
    {
      if (!cdoIsNew() && !cdoIsLoaded())
      {
        if (eResource() == null || !(eResource() instanceof CdoResource))
        {
          // XXX       throw new ImplementationError(
          //            "eResource() == null || !(eResource() instanceof CdoResource)");
        }
        else
        {
          CdoResource cdoResource = (CdoResource)eResource();
          ResourceManager resourceManager = cdoResource.getResourceManager();

          if (resourceManager.isRequestingObjects())
          {
            resourceManager.requestObject(this);
          }
        }
      }
    }
    catch (RuntimeException ex)
    {
      logger.error("Problem while loading object", ex);
      throw ex;
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean cdoIsNew()
  {
    return oid <= 0;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean cdoIsLoaded()
  {
    return oca != NOT_LOADED_YET;
  }

  /**
   * @ADDED
   */
  protected long oid;

  /**
   * @ADDED
   */
  protected int oca = NOT_LOADED_YET;
} //CdoPersistentImpl
