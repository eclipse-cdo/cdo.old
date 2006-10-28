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
package org.eclipse.emf.cdo.client.protocol;


import org.eclipse.net4j.transport.Channel;
import org.eclipse.net4j.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.stream.ExtendedDataInput;

import org.eclipse.emf.cdo.client.AttributeConverter;
import org.eclipse.emf.cdo.client.AttributeInfo;
import org.eclipse.emf.cdo.client.CDOPersistable;
import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.cdo.client.ClassInfo;
import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.client.internal.CDOClient;
import org.eclipse.emf.cdo.core.ImplementationError;
import org.eclipse.emf.cdo.core.OIDEncoder;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import java.io.IOException;


public abstract class AbstractDataRequest<RESULT> extends AbstractCDOClientRequest<RESULT>
{
  private static final ContextTracer TRACER = new ContextTracer(CDOClient.DEBUG_PROTOCOL,
      AbstractDataRequest.class);

  public AbstractDataRequest(Channel channel)
  {
    super(channel);
  }

  protected EObject receiveObject(ExtendedDataInput in, long oid, int oca, int cid)
      throws IOException
  {
    ClassInfo classInfo = getPackageManager().getClassInfo(cid);
    if (classInfo == null) throw new ImplementationError("Unknown cid " + cid);

    if (TRACER.isEnabled())
    {
      TRACER.trace(this, "Receiving object " + classInfo.getName() + " "
          + getPackageManager().getOidEncoder().toString(oid) + "v" + oca);
    }

    receiveContainers(in);

    EClass eClass = classInfo.getEClass();
    EObject eObject = provideObject(eClass, oid, oca);

    receiveAttributes(in, eObject, classInfo);
    receiveReferences(in, eObject);

    return eObject;
  }

  protected void receiveContainers(ExtendedDataInput in) throws IOException
  {
    int count = in.readInt();
    for (int i = 0; i < count; i++)
    {
      long oid = in.readLong();
      int cid = in.readInt();

      if (TRACER.isEnabled())
      {
        TRACER.trace(this, "Receiving container oid="
            + getPackageManager().getOidEncoder().toString(oid) + ", cid=" + cid);
      }

      provideObject(oid, cid);
    }
  }

  protected abstract EObject provideObject(EClass eClass, long oid, int oca);

  protected EObject createProxyObject(EClass eClass, long oid)
  {
    OIDEncoder oidEncoder = getPackageManager().getOidEncoder();

    if (TRACER.isEnabled())
    {
      TRACER.trace(this, "Creating proxy " + eClass.getName() + " " + oidEncoder.toString(oid));
    }

    int rid = oidEncoder.getRID(oid);
    ResourceManager resourceManager = getResourceManager();
    CDOResource cdoResource = resourceManager.getResource(rid);
    URI uri = resourceManager.createProxyURI(oid);

    EObject object = resourceManager.createEObject(eClass, oid, CDOPersistable.NOT_LOADED_YET,
        cdoResource);
    ((InternalEObject) object).eSetProxyURI(uri);

    resourceManager.registerObject(oid, object);
    return object;
  }

  protected EObject getProxyObject(long oid)
  {
    if (TRACER.isEnabled())
    {
      OIDEncoder oidEncoder = getPackageManager().getOidEncoder();
      TRACER.trace(this, "Searching proxy " + oidEncoder.toString(oid));
    }

    EObject object = getResourceManager().getProxyObject(oid);
    return object;
  }

  protected void receiveAttributes(ExtendedDataInput in, EObject object, ClassInfo classInfo)
      throws IOException
  {
    AttributeConverter converter = getPackageManager().getAttributeConverter();

    while (classInfo != null)
    {
      AttributeInfo[] attributeInfos = classInfo.getAttributeInfos();

      for (int i = 0; i < attributeInfos.length; i++)
      {
        AttributeInfo attributeInfo = attributeInfos[i];
        if (TRACER.isEnabled())
        {
          TRACER.trace(this, "Receiving attribute " + attributeInfo.getName());
        }

        converter.fromChannel(object, attributeInfo.getEAttribute(), in);
      }

      classInfo = classInfo.getParent();
    }
  }

  @SuppressWarnings("unchecked")
  protected void receiveReferences(ExtendedDataInput in, EObject object) throws IOException
  {
    for (;;)
    {
      int featureId = in.readInt();
      if (featureId == -1)
      {
        break;
      }

      EReference reference = (EReference) object.eClass().getEStructuralFeature(featureId);
      if (reference == null)
      {
        throw new ImplementationError("Feature id " + featureId
            + " is not known. Maybe signalling is out of sequence.");
      }

      long targetId = in.readLong();
      int cid = in.readInt();
      if (TRACER.isEnabled())
      {
        TRACER.trace(this, "Receiving reference \"" + reference.getName() + "\": "
            + getPackageManager().getOidEncoder().toString(targetId) + ", cid=" + cid
            + ", feature=" + featureId);
      }

      EObject targetObject = provideObject(targetId, cid);
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

  protected EObject provideObject(long oid, int cid)
  {
    EObject object = getResourceManager().getObject(oid);
    if (object == null)
    {
      object = getProxyObject(oid);

      if (object == null)
      {
        ClassInfo classInfo = getPackageManager().getClassInfo(cid);
        if (classInfo == null) throw new ImplementationError("Unknown cid " + cid);

        object = createProxyObject(classInfo.getEClass(), oid);
      }
    }

    return object;
  }
}
