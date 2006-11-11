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
import org.eclipse.net4j.util.stream.ExtendedDataInputStream;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import org.eclipse.emf.cdo.client.AttributeConverter;
import org.eclipse.emf.cdo.client.AttributeInfo;
import org.eclipse.emf.cdo.client.CDOPersistable;
import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.cdo.client.ClassInfo;
import org.eclipse.emf.cdo.client.PackageManager;
import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.client.impl.ResourceManagerImpl;
import org.eclipse.emf.cdo.client.internal.CDOClient;
import org.eclipse.emf.cdo.core.CDOProtocol;
import org.eclipse.emf.cdo.core.ImplementationError;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.ChangeFactory;
import org.eclipse.emf.ecore.change.ChangeKind;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.change.ListChange;
import org.eclipse.emf.ecore.change.impl.EObjectToChangesMapEntryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import java.io.IOException;


public class CommitTransactionRequest extends AbstractCDOClientRequest<Boolean>
{
  private static final int CAPACITY_eClassToAttributeChangesMap = 53;

  private static final int CAPACITY_referenceRecords = 1009;

  private static final int INVALID_FEATURE = -1;

  private static final int TRANSIENT_FEATURE = 0;

  private static final int ATTRIBUTE_FEATURE = 1;

  private static final int OBJECT_FEATURE = 2;

  private static final int COLLECTION_FEATURE = 3;

  private static final ContextTracer TRACER = new ContextTracer(CDOClient.DEBUG_PROTOCOL,
      CommitTransactionRequest.class);

  private Set<ReferenceRecord> referenceRecords = new HashSet<ReferenceRecord>(
      CAPACITY_referenceRecords);

  private ChangeDescription changeDescription;

  //  private boolean optimisticControlException;

  /**
   * Used for internal "protocol" between transmitObjectChange() and tryObjectChangeHeader().
   */
  private boolean firstChange;

  /**
   * Used to verify the number and order of acknowledges that are received for changed objects.
   */
  private List<EObject> changedObjects = new ArrayList<EObject>();

  private AttributeInfo attributeInfo;

  private List<EObject> objectsToAttach = new ArrayList<EObject>();

  private PackageManager packageManager;

  public CommitTransactionRequest(Channel channel, ChangeDescription changeDescription)
  {
    super(channel);
    this.changeDescription = changeDescription;
  }

  @Override
  protected short getSignalID()
  {
    return CDOProtocol.COMMIT_TRANSACTION;
  }

  @Override
  protected void requesting(ExtendedDataOutputStream out) throws IOException
  {
    packageManager = ((ClientCDOProtocolImpl) getProtocol()).getPackageManager();
    commitObjectsToDetach(out);
    commitObjectsToAttach(out);
    commitObjectChanges(out);
    announceNewResources(out);
  }

  @Override
  protected Boolean confirming(ExtendedDataInputStream in) throws IOException
  {
    if (changeDescription == null)
    {
      throw new ImplementationError("changeDescription == null");
    }

    boolean ok = in.readBoolean();
    if (!ok)
    {
      changeDescription.apply();
      return false;
    }

    ResourceManager resourceManager = getResourceManager();
    ResourceSet resourceSet = resourceManager.getResourceSet();
    EList resources = resourceSet.getResources();

    for (Iterator<?> iter = resources.iterator(); iter.hasNext();)
    {
      Resource resource = (Resource) iter.next();
      if (resource instanceof CDOResource)
      {
        CDOResource cdoResource = (CDOResource) resource;
        cdoResource.setExisting(true);
      }
    }

    // Re-register new objects (apply positive OIDs)
    int attachedCount = in.readInt();

    if (attachedCount != objectsToAttach.size())
    {
      throw new ImplementationError("attachedCount != attached.size()");
    }

    for (Iterator<EObject> iter = objectsToAttach.iterator(); iter.hasNext();)
    {
      EObject object = iter.next();
      long oid = in.readLong();

      resourceManager.reRegisterObject(object, oid);
      int rid = packageManager.getOidEncoder().getRID(oid);
      CDOResource cdoResource = resourceManager.getResource(rid);
      ResourceManagerImpl.initPersistable(object, cdoResource, oid, 1);
    }

    // Increase OCA of modified objects
    int changedCount = in.readInt();
    if (changedCount != changedObjects.size())
    {
      throw new ImplementationError("changedCount != changedObjects.size()");
    }

    for (EObject object : changedObjects)
    {
      long oid = in.readLong();
      int oca = in.readInt();

      if (ResourceManagerImpl.getOID(object) != oid)
      {
        throw new ImplementationError("getOID(object) != oid");
      }

      if (ResourceManagerImpl.getOCA(object) != oca - 1)
      {
        throw new ImplementationError("getOCA(object) != oca - 1");
      }

      ResourceManagerImpl.incOCA(object);
    }

    return true;
  }

  private void announceNewResources(ExtendedDataOutputStream out) throws IOException
  {
    ResourceManager resourceManager = getResourceManager();
    ResourceSet resourceSet = resourceManager.getResourceSet();
    EList resources = resourceSet.getResources();

    for (Iterator<?> iter = resources.iterator(); iter.hasNext();)
    {
      Resource resource = (Resource) iter.next();
      if (resource instanceof CDOResource)
      {
        CDOResource cdoResource = (CDOResource) resource;
        if (!cdoResource.isExisting())
        {
          out.writeInt(cdoResource.getRID());
          out.writeString(cdoResource.getPath());
        }
      }
    }

    out.writeInt(0);
  }

  private void commitObjectsToDetach(ExtendedDataOutputStream out) throws IOException
  {
    // Use getObjectsToAttach() because changeDescription is reversed
    EList attached = changeDescription.getObjectsToAttach();
    if (TRACER.isEnabled())
    {
      TRACER.trace("commitObjectsToDetach(" + attached.size() + " object"
          + (attached.size() != 1 ? "s" : "") + ")");
    }

    for (Iterator it = EcoreUtil.getAllContents(attached); it.hasNext();)
    {
      EObject object = (EObject) it.next();

      // All changes to detached objects are ignored
      changeDescription.getObjectChanges().removeKey(object);

      long oid = ResourceManagerImpl.getOID(object);
      int oca = ((CDOPersistable) object).cdoGetOCA();
      if ((oid != 0) && (oca != -1))
      {
        if (TRACER.isEnabled())
        {
          TRACER.trace(ResourceManagerImpl.getLabel(object));
        }

        out.writeLong(oid);
      }
    }

    // End of list
    out.writeLong(0);
  }

  private void commitObjectsToAttach(ExtendedDataOutputStream out) throws IOException
  {
    // Use getObjectsToDetach() because changeDescription is reversed
    for (Iterator it = changeDescription.getObjectsToDetach().iterator(); it.hasNext();)
    {
      EObject eObject = (EObject) it.next();
      objectsToAttach.add(eObject);

      for (Iterator tree = eObject.eAllContents(); tree.hasNext();)
      {
        EObject child = (EObject) tree.next();
        objectsToAttach.add(child);
      }
    }

    out.writeInt(objectsToAttach.size());

    if (TRACER.isEnabled())
    {
      TRACER.trace("commitObjectsToAttach(" + objectsToAttach.size() + " object"
          + (objectsToAttach.size() != 1 ? "s" : "") + ")");
    }

    // First transmit all the temporary oids, so that the server knows in advance how to handle references
    for (Iterator<EObject> it = objectsToAttach.iterator(); it.hasNext();)
    {
      EObject eObject = it.next();
      ClassInfo classInfo = packageManager.getClassInfo(eObject);
      if (classInfo == null)
        throw new ImplementationError("Class not registered as CDO persistent: " + eObject.eClass());

      // All changes to attached objects are handled through attachment
      changeDescription.getObjectChanges().removeKey(eObject);

      long oid = ResourceManagerImpl.getOID(eObject);
      if (oid == CDOProtocol.NO_MORE_OBJECTS) throw new ImplementationError("oid == 0");

      int cid = classInfo.getCID();
      if (cid <= 0) throw new ImplementationError("cid <= 0");

      boolean isContent = (eObject.eContainer() == null);

      if (TRACER.isEnabled())
      {
        TRACER.trace("Transmitting object to attach: oid="
            + packageManager.getOidEncoder().toString(oid) + ", cid=" + cid + ", isContent="
            + isContent);
      }

      out.writeLong(oid);
      out.writeInt(cid);
      out.writeBoolean(isContent);

      commitObjectsToAttachAttributes(out, eObject);
      rememberObjectsToAttachReferences(eObject, classInfo);
    }

    // Then transmit the references of all new objects together 
    commitReferencesToAdd(out);
  }

  private void commitObjectsToAttachAttributes(ExtendedDataOutputStream out, EObject eObject)
      throws IOException
  {
    ClassInfo classInfo = packageManager.getClassInfo(eObject);
    if (classInfo == null)
      throw new ImplementationError("Class not registered as CDO persistent: " + eObject.eClass());

    while (classInfo != null)
    {
      if (TRACER.isEnabled())
      {
        TRACER.trace("Transmitting attributeSegment " + classInfo.getFullName());
      }

      AttributeInfo[] attributeInfos = classInfo.getAttributeInfos();

      for (int i = 0; i < attributeInfos.length; i++)
      {
        AttributeInfo attributeInfo = attributeInfos[i];
        if (TRACER.isEnabled())
        {
          TRACER.trace("Transmitting attribute " + attributeInfo.getName());
        }

        AttributeConverter converter = packageManager.getAttributeConverter();
        converter.toChannel(eObject, attributeInfo.getEAttribute(), out);
      }

      classInfo = classInfo.getParent();
    }
  }

  private void rememberObjectsToAttachReferences(EObject object, ClassInfo classInfo)
  {
    EReference[] references = classInfo.getAllReferences();
    for (int i = 0; i < references.length; i++)
    {
      EReference reference = references[i];

      if (reference.isMany())
      {
        int ordinal = 0;
        EList values = (EList) object.eGet(reference);

        for (Iterator<?> valuesIt = values.iterator(); valuesIt.hasNext();)
        {
          EObject value = (EObject) valuesIt.next();
          long oid = ResourceManagerImpl.getOID(value);

          rememberReferenceToAdd(ResourceManagerImpl.getOID(object), reference, ++ordinal, oid);
        }
      }
      else
      {
        EObject value = (EObject) object.eGet(reference);

        if (value != null)
        {
          long id = ResourceManagerImpl.getOID(value);
          rememberReferenceToAdd(ResourceManagerImpl.getOID(object), reference, 0, id);
        }
      }
    }
  }

  private void commitReferencesToAdd(ExtendedDataOutputStream out) throws IOException
  {
    out.writeInt(referenceRecords.size());

    for (Iterator<ReferenceRecord> it = referenceRecords.iterator(); it.hasNext();)
    {
      ReferenceRecord record = it.next();
      long oid = record.getOID();
      EReference feature = record.getFeature();
      int ordinal = record.getOrdinal();
      long target = record.getTarget();
      boolean containment = feature.isContainment();

      if (TRACER.isEnabled())
      {
        TRACER.trace("Transmitting reference to add: oid="
            + packageManager.getOidEncoder().toString(oid) + ", feature=" + feature.getFeatureID()
            + ", ordinal=" + ordinal + ", target="
            + packageManager.getOidEncoder().toString(target) + ", containment=" + containment);
      }

      out.writeLong(oid);
      out.writeInt(feature.getFeatureID());
      out.writeInt(ordinal); // TODO ordinal necessary?
      out.writeLong(target);
      out.writeBoolean(containment);
    }
  }

  private void commitObjectChanges(ExtendedDataOutputStream out) throws IOException
  {
    EMap objectChanges = changeDescription.getObjectChanges();

    if (TRACER.isEnabled())
    {
      TRACER.trace("commitObjectChanges(" + objectChanges.size() + " objects)");
    }

    for (Iterator<?> iter = objectChanges.iterator(); iter.hasNext();)
    {
      EObjectToChangesMapEntryImpl entry = (EObjectToChangesMapEntryImpl) iter.next();
      EObject eObject = (EObject) entry.getKey();
      EList featureChanges = (EList) entry.getValue();

      transmitObjectChange(out, eObject, featureChanges);
    }

    out.writeLong(CDOProtocol.NO_MORE_OBJECT_CHANGES);
  }

  @SuppressWarnings("unchecked")
  private void transmitObjectChange(ExtendedDataOutputStream out, EObject eObject,
      EList featureChanges) throws IOException
  {
    ClassInfo classInfo = packageManager.getClassInfo(eObject);
    if (classInfo == null)
      throw new ImplementationError("Class not registered as CDO persistent: " + eObject.eClass());

    Map<EClass, List<AttributeInfo>> eClassToAttributeChangesMap = new HashMap<EClass, List<AttributeInfo>>(
        CAPACITY_eClassToAttributeChangesMap);
    firstChange = true;

    for (Iterator<FeatureChange> iterator = featureChanges.iterator(); iterator.hasNext();)
    {
      FeatureChange featureChange = iterator.next();
      EStructuralFeature feature = featureChange.getFeature();
      int type = featureType(feature, classInfo);

      switch (type)
      {
        case TRANSIENT_FEATURE:
          break;

        case ATTRIBUTE_FEATURE:
          tryObjectChangeHeader(out, eObject);
          rememberAttributeChange(feature, eClassToAttributeChangesMap);
          break;

        case OBJECT_FEATURE:
          tryObjectChangeHeader(out, eObject);
          commitObjectChangeReferenceOne(out, eObject, (EReference) feature);
          break;

        case COLLECTION_FEATURE:
          tryObjectChangeHeader(out, eObject);
          commitObjectChangeReferenceMany(out, eObject, featureChange, (EReference) feature);
          break;

        default:
          throw new ImplementationError("Invalid feature type: " + type);
      }
    }

    if (firstChange)
    {
      // There was no change
      return;
    }

    out.writeByte(CDOProtocol.NO_MORE_REFERENCE_CHANGES);
    transmitAttributeChanges(out, eObject, eClassToAttributeChangesMap);
    changedObjects.add(eObject);
  }

  /**
   * @param out 
   * @param object
   * @param classToAttributeChangesMap
   * @throws IOException 
   */
  @SuppressWarnings("unchecked")
  private void transmitAttributeChanges(ExtendedDataOutputStream out, EObject eObject,
      Map<EClass, List<AttributeInfo>> eClassToAttributeChangesMap) throws IOException
  {
    Set<Entry<EClass, List<AttributeInfo>>> entrySet = eClassToAttributeChangesMap.entrySet();
    for (Iterator<Entry<EClass, List<AttributeInfo>>> mapIt = entrySet.iterator(); mapIt.hasNext();)
    {
      Entry<EClass, List<AttributeInfo>> entry = mapIt.next();
      EClass eClass = entry.getKey();
      List<AttributeInfo> attributeChangesOfClassifierList = entry.getValue();

      ClassInfo classInfo = packageManager.getClassInfo(eClass);
      if (classInfo == null)
        throw new ImplementationError("Class not registered as CDO persistent: " + entry.getKey());

      int cid = classInfo.getCID();
      int count = attributeChangesOfClassifierList.size();

      if (TRACER.isEnabled())
      {
        TRACER.trace("Transmitting segment " + classInfo.getFullName() + ": count=" + count);
      }

      out.writeInt(cid);
      out.writeInt(count);

      for (Iterator<AttributeInfo> listIt = attributeChangesOfClassifierList.iterator(); listIt
          .hasNext();)
      {
        AttributeInfo attributeInfo = listIt.next();
        transmitAttributeChange(out, eObject, attributeInfo);
      }
    }

    out.writeInt(CDOProtocol.NO_MORE_SEGMENTS);
  }

  /**
   * @param feature
   * @param classToAttributeChangesMap
   */
  @SuppressWarnings("unchecked")
  private void rememberAttributeChange(EStructuralFeature feature,
      Map<EClass, List<AttributeInfo>> eClassToAttributeChangesMap)
  {
    EClass eClass = feature.getEContainingClass();
    List<AttributeInfo> attributeChangesOfEClass = eClassToAttributeChangesMap.get(eClass);

    if (attributeChangesOfEClass == null)
    {
      attributeChangesOfEClass = new ArrayList<AttributeInfo>();
      eClassToAttributeChangesMap.put(eClass, attributeChangesOfEClass);
    }

    attributeChangesOfEClass.add(attributeInfo);
  }

  /**
   * @param feature
   * @return
   */
  private int featureType(EStructuralFeature feature, ClassInfo classInfo)
  {
    attributeInfo = null;

    if (feature instanceof EReference && feature.isTransient())
    {
      // TODO provide and use mapping info for references
      return TRANSIENT_FEATURE;
    }

    if (feature instanceof EAttribute)
    {
      attributeInfo = classInfo.getAttributeInfo((EAttribute) feature);

      if (attributeInfo == null)
      {
        return TRANSIENT_FEATURE;
      }

      return ATTRIBUTE_FEATURE;
    }

    if (feature instanceof EReference)
    {
      if (feature.isMany())
      {
        return COLLECTION_FEATURE;
      }
      else
      {
        return OBJECT_FEATURE;
      }
    }

    return INVALID_FEATURE;
  }

  /**
   * @param out 
   * @param eObject
   * @throws IOException 
   */
  private void tryObjectChangeHeader(ExtendedDataOutputStream out, EObject eObject)
      throws IOException
  {
    if (firstChange)
    {
      firstChange = false;
      long oid = ResourceManagerImpl.getOID(eObject);
      int oca = ResourceManagerImpl.getOCA(eObject);
      if (TRACER.isEnabled())
      {
        TRACER.trace("Transmitting object to change: " + ResourceManagerImpl.getLabel(eObject)
            + ")");
      }

      out.writeLong(oid);
      out.writeInt(oca);
    }
  }

  private void transmitAttributeChange(ExtendedDataOutputStream out, EObject eObject,
      AttributeInfo attributeInfo) throws IOException
  {
    if (TRACER.isEnabled())
    {
      TRACER.trace("commitObjectChangeAttribute(" + attributeInfo.getName() + ")");
    }

    EAttribute attribute = attributeInfo.getEAttribute();
    out.writeInt(attribute.getFeatureID());

    AttributeConverter converter = packageManager.getAttributeConverter();
    converter.toChannel(eObject, attribute, out);
  }

  @SuppressWarnings("unchecked")
  private void commitObjectChangeReferenceMany(ExtendedDataOutputStream out, EObject object,
      FeatureChange featureChange, EReference reference) throws IOException
  {
    if (TRACER.isEnabled())
    {
      TRACER.trace("commitObjectChangeReferenceMany(" + reference.getName() + ")");
    }

    long oid = ResourceManagerImpl.getOID(object);
    if (featureChange.isSet())
    {
      EList currentObjects = (EList) object.eGet(reference);
      EList originalObjects = new BasicEList(currentObjects);
      EList listChanges = new BasicEList(featureChange.getListChanges().size());
      for (Iterator<?> it = featureChange.getListChanges().iterator(); it.hasNext();)
      {
        ListChange listChange = (ListChange) it.next();
        ListChange changeCopy = ChangeFactory.eINSTANCE.createListChange();
        changeCopy.setKind(listChange.getKind());
        changeCopy.setFeature(listChange.getFeature());
        changeCopy.setIndex(listChange.getIndex());
        changeCopy.setMoveToIndex(listChange.getMoveToIndex());
        changeCopy.getValues().addAll(listChange.getValues());
        changeCopy.applyAndReverse(originalObjects);
        listChanges.add(changeCopy);
      }

      ECollections.reverse(listChanges);

      // Second iteration to apply changes 
      for (Iterator<ListChange> it = listChanges.iterator(); it.hasNext();)
      {
        ListChange listChange = it.next();
        ChangeKind changeKind = listChange.getKind();

        switch (changeKind.getValue())
        {
          case ChangeKind.MOVE:
          {
            int index = listChange.getIndex();
            int moveToIndex = listChange.getMoveToIndex();
            transmitReferenceChange(out, CDOProtocol.LIST_MOVE, oid, reference, index, 0,
                moveToIndex);
            break;
          }
          case ChangeKind.ADD:
          {
            int index = listChange.getIndex();
            EList values = listChange.getValues();
            for (Iterator<?> itValues = values.iterator(); itValues.hasNext();)
            {
              EObject value = (EObject) itValues.next();
              long target = ResourceManagerImpl.getOID(value);
              transmitReferenceChange(out, CDOProtocol.LIST_ADD, oid, reference, index, target, 0);
            }
            break;
          }
          case ChangeKind.REMOVE:
          {
            int index = listChange.getIndex();
            transmitReferenceChange(out, CDOProtocol.LIST_REMOVE, oid, reference, index, 0, 0);
            break;
          }
          default:
          {
            throw new ImplementationError("Unexpected change kind: " + changeKind.getName());
          }
        }
      }
    }
    else
    {
      // When the feature (list) has to be unset,
      // all current elements have to be added from scratch
      int ordinal = 0;

      EList values = (EList) object.eGet(reference);
      for (Iterator<?> valuesIt = values.iterator(); valuesIt.hasNext();)
      {
        EObject value = (EObject) valuesIt.next();
        long target = ResourceManagerImpl.getOID(value);

        transmitReferenceChange(out, CDOProtocol.LIST_ADD, oid, reference, ordinal++, target, 0);
      }
    }
  }

  private void commitObjectChangeReferenceOne(ExtendedDataOutputStream out, EObject object,
      EReference reference) throws IOException
  {
    if (TRACER.isEnabled())
    {
      TRACER.trace("commitObjectChangeReferenceOne()");
    }

    EObject refObject = (EObject) object.eGet(reference);
    long oid = ResourceManagerImpl.getOID(object);
    long target = refObject == null ? 0 : ResourceManagerImpl.getOID(refObject);

    // Add the reference
    byte changeKind = refObject == null ? CDOProtocol.FEATURE_UNSET : CDOProtocol.FEATURE_SET;
    transmitReferenceChange(out, changeKind, oid, reference, 0, target, 0);
    if (TRACER.isEnabled() && refObject != null)
    {
      TRACER.trace("--> " + reference.getName() + ": " + ResourceManagerImpl.getLabel(refObject));
    }
  }

  private void transmitReferenceChange(ExtendedDataOutputStream out, byte changeKind,
      long sourceId, EReference feature, int sourceOrdinal, long targetId, int moveToIndex)
      throws IOException
  {
    out.writeByte(changeKind);
    out.writeLong(sourceId);
    out.writeInt(feature.getFeatureID());

    switch (changeKind)
    {
      case CDOProtocol.FEATURE_SET:
      {
        if (TRACER.isEnabled())
        {
          TRACER.trace("transmitReferenceChange(SET, oid="
              + packageManager.getOidEncoder().toString(sourceId) + ", featureId="
              + feature.getFeatureID() + ", target="
              + packageManager.getOidEncoder().toString(targetId) + ", containment="
              + feature.isContainment() + ")");
        }

        out.writeLong(targetId);
        out.writeBoolean(feature.isContainment());
        break;
      }
      case CDOProtocol.FEATURE_UNSET:
      {
        if (TRACER.isEnabled())
        {
          TRACER.trace("transmitReferenceChange(UNSET, oid="
              + packageManager.getOidEncoder().toString(sourceId) + ", featureId="
              + feature.getFeatureID() + ")");
        }

        break;
      }
      case CDOProtocol.LIST_ADD:
      {
        if (TRACER.isEnabled())
        {
          TRACER.trace("transmitReferenceChange(ADD, oid="
              + packageManager.getOidEncoder().toString(sourceId) + ", featureId="
              + feature.getFeatureID() + ", ordinal=" + sourceOrdinal + ", target="
              + packageManager.getOidEncoder().toString(targetId) + ", containment="
              + feature.isContainment() + ")");
        }

        out.writeInt(sourceOrdinal);
        out.writeLong(targetId);
        out.writeBoolean(feature.isContainment());
        break;
      }
      case CDOProtocol.LIST_REMOVE:
      {
        if (TRACER.isEnabled())
        {
          TRACER.trace("transmitReferenceChange(REMOVE, oid="
              + packageManager.getOidEncoder().toString(sourceId) + ", featureId="
              + feature.getFeatureID() + ", ordinal=" + sourceOrdinal + ")");
        }

        out.writeInt(sourceOrdinal);
        break;
      }
      case CDOProtocol.LIST_MOVE:
      {
        if (TRACER.isEnabled())
        {
          TRACER.trace("transmitReferenceChange(MOVE, oid="
              + packageManager.getOidEncoder().toString(sourceId) + ", featureId="
              + feature.getFeatureID() + ", ordinal=" + sourceOrdinal + ", moveToIndex="
              + moveToIndex + ")");
        }

        out.writeInt(sourceOrdinal);
        out.writeInt(moveToIndex);
        break;
      }
    }
  }

  private void rememberReferenceToAdd(long oid, EReference feature, int ordinal, long target)
  {
    ReferenceRecord record = new ReferenceRecord(oid, feature, ordinal, target);
    referenceRecords.add(record);
  }


  private static class ReferenceRecord
  {
    public ReferenceRecord(long oid, EReference feature, int ordinal, long target)
    {
      this.oid = oid;
      this.feature = feature;
      this.ordinal = ordinal;
      this.target = target;
    }

    public long getOID()
    {
      return oid;
    }

    public int getOrdinal()
    {
      return ordinal;
    }

    public EReference getFeature()
    {
      return feature;
    }

    public int getFeatureId()
    {
      return feature.getFeatureID();
    }

    public long getTarget()
    {
      return target;
    }

    private long oid;

    private EReference feature;

    private int ordinal;

    private long target;

    public boolean equals(Object obj)
    {
      if (obj == this)
      {
        return true;
      }

      if (!(obj instanceof ReferenceRecord))
      {
        return false;
      }

      ReferenceRecord that = (ReferenceRecord) obj;
      return this.oid == that.oid && this.getFeatureId() == that.getFeatureId()
          && this.ordinal == that.ordinal && this.target == that.target;
    }

    public int hashCode()
    {
      return ((int) (oid >> 32)) ^ ((int) (oid & 0xFFFFFFFF)) ^ ((int) (target >> 32))
          ^ ((int) (target & 0xFFFFFFFF)) ^ getFeatureId() ^ ordinal;
    }
  }
}
