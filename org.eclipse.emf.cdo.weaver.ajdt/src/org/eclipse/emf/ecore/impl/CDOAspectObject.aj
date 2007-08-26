/***************************************************************************
 * Copyright (c) 2004 - 2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.ecore.impl;

// import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Eike Stepper
 */
public aspect CDOAspectObject
{
  pointcut writeAccess(EObjectImpl eObject): target(eObject) && execution(void set*(*));

  pointcut readAccess(EObjectImpl eObject): target(eObject) && (execution(* get*()) ||
                                                                execution(boolean is*()) ||
                                                                execution(Boolean is*()));

// pointcut eResource(BasicEObjectImpl eObject): target(eObject) &&
// execution(Resource eResource());

  before(EObjectImpl eObject): writeAccess(eObject) 
  {
    eObject.beforeWrite();
  }

  before(EObjectImpl eObject): readAccess(eObject) 
  {
    eObject.beforeRead();
  }

// Resource around(BasicEObjectImpl eObject) : eResource(eObject)
// {
// Resource resource = eObject.internalResource();
// if (resource == null)
// {
// resource = proceed(eObject);
// }
//    
// return resource;
// }
}
