/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.client.impl;


import org.eclipse.emf.cdo.client.CDOPackage;
import org.eclipse.emf.cdo.client.CDOPersistent;
import org.eclipse.emf.cdo.client.CDOResource;
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
public abstract class CDOPersistentImpl extends EObjectImpl implements CDOPersistent
{
  /**
   * @ADDED
   */
  private static final Logger logger = Logger.getLogger(CDOPersistentImpl.class);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CDOPersistentImpl()
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
    return CDOPackage.Literals.CDO_PERSISTENT;
  }

  /**
   * @ADDED
   */
  @Override
  public Resource eResource()
  {
    Resource resource = super.eResource();
    if (resource == null)
    {
      resource = cdoResource;
    }

    return resource;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public long cdoGetOID()
  {
    return cdoOID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void cdoSetOID(long oid)
  {
    cdoOID = oid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public int cdoGetOCA()
  {
    return cdoOCA;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void cdoSetOCA(int oca)
  {
    cdoOCA = oca;
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
        ResourceManager resourceManager = cdoResource.getResourceManager();
        if (resourceManager.isRequestingObjects())
        {
          resourceManager.requestObject(this);
        }
        else
        {
          if (logger.isDebugEnabled())
          {
            logger.debug("ResourceManager IN USE: " + Thread.currentThread());
            // logger.debug(DeadlockDetector.identifySource());
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
    return cdoOID <= 0;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean cdoIsLoaded()
  {
    return cdoOCA != NOT_LOADED_YET;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public CDOResource cdoGetResource()
  {
    return cdoResource;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void cdoSetResource(CDOResource resource)
  {
    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX " + eProxyURI());
    cdoResource = resource;
  }

  /**
   * <!-- begin-user-doc -->
   * Sets the OID to the next temporary OID and the OCA to NOT_LOADED_YET.
   * Requires this object to be contained in a CDOResourceImpl.
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public long cdoSetNew()
  {
    if (eResource() instanceof CDOResourceImpl)
    {
      CDOResourceImpl cdoResource = (CDOResourceImpl) eResource();
      long oldOID = cdoOID;
      cdoOID = cdoResource.getNextTempOID();
      cdoOCA = NOT_LOADED_YET;
      return oldOID;
    }

    throw new IllegalStateException("Not a CDOResourceImpl:" + eResource());
  }

  /**
   * @ADDED
   */
  private CDOResource cdoResource;

  /**
   * @ADDED
   */
  private long cdoOID;

  /**
   * @ADDED
   */
  private int cdoOCA = NOT_LOADED_YET;
} //CDOPersistentImpl
