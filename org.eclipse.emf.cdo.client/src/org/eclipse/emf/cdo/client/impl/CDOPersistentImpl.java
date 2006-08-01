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


import org.eclipse.net4j.util.thread.DeadlockDetector;

import org.eclipse.emf.cdo.client.CDOPackage;
import org.eclipse.emf.cdo.client.CDOPersistable;
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
  public void cdoSetOID(long oid, CDOResource resource)
  {
    this.oid = oid;

    if (resource != null && eDirectResource() == null && eContainer() == null)
    {
      eSetResource((Resource.Internal) resource, null);
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
        if (eResource() == null || !(eResource() instanceof CDOResource))
        {
          // XXX       throw new ImplementationError(
          //            "eResource() == null || !(eResource() instanceof CDOResource)");
        }
        else
        {
          CDOResource cdoResource = (CDOResource) eResource();
          ResourceManager resourceManager = cdoResource.getResourceManager();

          if (resourceManager.isRequestingObjects())
          {
            resourceManager.requestObject(this);
          }
          //          else
          //          {
          //            System.err.println("ResourceManager IN USE: " + Thread.currentThread());
          //            System.err.println(DeadlockDetector.identifySource());
          //          }
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
      long oldOID = oid;
      oid = cdoResource.getNextTempOID();
      oca = NOT_LOADED_YET;
      return oldOID;
    }

    throw new IllegalStateException("Not a CDOResourceImpl:" + eResource());
  }

  /**
   * @ADDED
   */
  protected long oid;

  /**
   * @ADDED
   */
  protected int oca = NOT_LOADED_YET;
} //CDOPersistentImpl
