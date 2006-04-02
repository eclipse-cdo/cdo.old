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
package org.eclipse.emf.cdo.client.protocol;


import org.eclipse.net4j.util.ImplementationError;

import org.eclipse.emf.cdo.client.AttributeConverter;
import org.eclipse.emf.cdo.client.AttributeInfo;
import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.cdo.client.ClassInfo;
import org.eclipse.emf.cdo.client.impl.ResourceManagerImpl;
import org.eclipse.emf.cdo.core.OIDEncoder;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;


public abstract class AbstractDataRequest extends AbstractCDOClientRequest
{
  protected EObject receiveObject(long oid, int oca, int cid)
  {
    ClassInfo classInfo = getPackageManager().getClassInfo(cid);
    if (classInfo == null) throw new ImplementationError("Unknown cid " + cid);

    if (isDebugEnabled())
      debug("Receiving object " + classInfo.getName() + " "
          + getPackageManager().getOidEncoder().toString(oid) + "v" + oca);

    receiveContainers();

    EClass eClass = classInfo.getEClass();
    EObject eObject = provideObject(eClass, oid, oca);

    receiveAttributes(eObject, classInfo);
    receiveReferences(eObject);

    return eObject;
  }

  protected void receiveContainers()
  {
    int count = receiveInt();
    for (int i = 0; i < count; i++)
    {
      long oid = receiveLong();
      int cid = receiveInt();

      if (isDebugEnabled())
        debug("Receiving container oid=" + getPackageManager().getOidEncoder().toString(oid)
            + ", cid=" + cid);

      EObject container = getResourceManager().getObject(oid);
      if (container == null)
      {
        container = getProxyObject(oid);

        if (container == null)
        {
          ClassInfo classInfo = getPackageManager().getClassInfo(cid);
          if (classInfo == null) throw new ImplementationError("Unknown cid " + cid);

          createProxyObject(classInfo.getEClass(), oid);
        }
      }
    }
  }

  protected abstract EObject provideObject(EClass eClass, long oid, int oca);

  protected EObject createProxyObject(EClass eClass, long oid)
  {
    OIDEncoder oidEncoder = getPackageManager().getOidEncoder();

    if (isDebugEnabled())
      debug("Creating proxy " + eClass.getName() + " " + oidEncoder.toString(oid));

    int rid = oidEncoder.getRID(oid);
    CDOResource cDOResource = getResourceManager().getResource(rid);
    URI uri = getResourceManager().createProxyURI(oid);

    EObject object = ResourceManagerImpl.createEObject(eClass, oid, -1, cDOResource);

    ((InternalEObject) object).eSetProxyURI(uri);

    getResourceManager().registerObject(oid, object);
    return object;
  }

  protected EObject getProxyObject(long oid)
  {
    if (isDebugEnabled())
    {
      OIDEncoder oidEncoder = getPackageManager().getOidEncoder();
      debug("Searching proxy " + oidEncoder.toString(oid));
    }

    EObject object = getResourceManager().getProxyObject(oid);
    return object;
  }

  protected void receiveAttributes(EObject object, ClassInfo classInfo)
  {
    AttributeConverter converter = getPackageManager().getAttributeConverter();

    while (classInfo != null)
    {
      AttributeInfo[] attributeInfos = classInfo.getAttributeInfos();

      for (int i = 0; i < attributeInfos.length; i++)
      {
        AttributeInfo attributeInfo = attributeInfos[i];
        converter.fromChannel(object, attributeInfo.getEAttribute(), channel);
      }

      classInfo = classInfo.getParent();
    }
  }

  protected void receiveReferences(EObject object)
  {
    //    boolean deliver = ((InternalEObject) object).eDeliver();
    //    if (deliver)
    //    {
    //      ((InternalEObject) object).eSetDeliver(false);
    //    }
    //
    //    EList features = object.eClass().getEAllStructuralFeatures();
    //    for (Iterator iter = features.iterator(); iter.hasNext();)
    //    {
    //      try
    //      {
    //        EStructuralFeature feature = (EStructuralFeature) iter.next();
    //        if (feature instanceof EReference)
    //        {
    //          object.eUnset(feature);
    //        }
    //      }
    //      catch (Throwable ignore)
    //      {
    //      }
    //    }

    try
    {
      for (;;)
      {
        int featureId = receiveInt();
        if (featureId == -1)
        {
          break;
        }

        EReference reference = (EReference) object.eClass().getEStructuralFeature(featureId);
        if (reference == null)
        {
          throw new ImplementationError("Reference " + featureId
              + " is not known. Maybe signalling is out of sequence.");
        }

        long targetId = receiveLong();

        int cid = receiveInt();
        ClassInfo classInfo = getPackageManager().getClassInfo(cid);
        if (classInfo == null) throw new ImplementationError("Unknown cid " + cid);

        if (isDebugEnabled())
          debug("Receiving reference \"" + reference.getName() + "\": "
              + getPackageManager().getOidEncoder().toString(targetId) + ", cid=" + cid
              + ", feature=" + featureId);

        EObject targetObject = getResourceManager().getObject(targetId);
        if (targetObject == null)
        {
          targetObject = getProxyObject(targetId);

          if (targetObject == null)
          {
            targetObject = createProxyObject(classInfo.getEClass(), targetId);
          }
        }

        if (reference.isMany())
        {
          EList list = (EList) object.eGet(reference);
          list.add(targetObject);
        }
        else
        {
          object.eSet(reference, targetObject);
        }
      }
    }
    finally
    {
      //      if (deliver)
      //      {
      //        ((InternalEObject) object).eSetDeliver(true);
      //      }
    }
  }
}
