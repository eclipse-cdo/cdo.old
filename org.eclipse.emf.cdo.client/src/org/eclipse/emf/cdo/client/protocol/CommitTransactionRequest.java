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
import org.eclipse.emf.cdo.client.CdoPersistable;
import org.eclipse.emf.cdo.client.CdoResource;
import org.eclipse.emf.cdo.client.ClassInfo;
import org.eclipse.emf.cdo.client.OptimisticControlException;
import org.eclipse.emf.cdo.client.PackageManager;
import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.client.impl.ResourceManagerImpl;
import org.eclipse.emf.cdo.core.CdoProtocol;
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
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class CommitTransactionRequest extends AbstractCdoClientRequest
{
  private static final int CAPACITY_eClassToAttributeChangesMap = 53;

  private static final int CAPACITY_referenceRecords = 1009;

  private static final int INVALID_FEATURE = -1;

  private static final int TRANSIENT_FEATURE = 0;

  private static final int ATTRIBUTE_FEATURE = 1;

  private static final int OBJECT_FEATURE = 2;

  private static final int COLLECTION_FEATURE = 3;

  private Map referenceRecords = new Hashtable(CAPACITY_referenceRecords);

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

  private List objectsToAttach = new ArrayList();

  private PackageManager packageManager;

  public CommitTransactionRequest(ChangeDescription changeDescription)
  {
    this.changeDescription = changeDescription;
  }

  public short getSignalId()
  {
    return CdoProtocol.COMMIT_TRANSACTION;
  }

  public void request()
  {
    packageManager = ((CdoClientProtocolImpl) getProtocol()).getPackageManager();

    commitObjectsToDetach();
    commitObjectsToAttach();
    commitObjectChanges();

    announceNewResources();
  }

  public Object confirm()
  {
    if (changeDescription == null)
    {
      throw new ImplementationError("changeDescription == null");
    }

    boolean ok = receiveBoolean();
    if (!ok)
    {
      changeDescription.apply();
      throw new OptimisticControlException();
    }

    // Re-register new objects (apply positive OIDs)
    int attachedCount = receiveInt();

    if (attachedCount != objectsToAttach.size())
    {
      throw new ImplementationError("attachedCount != attached.size()");
    }

    for (Iterator iter = objectsToAttach.iterator(); iter.hasNext();)
    {
      EObject object = (EObject) iter.next();
      long oid = receiveLong();

      getResourceManager().reRegisterObject(object, oid);
      int rid = packageManager.getOidEncoder().getRID(oid);
      CdoResource cdoResource = getResourceManager().getResource(rid);
      ResourceManagerImpl.setOID(object, oid, cdoResource);
      ResourceManagerImpl.setOCA(object, 1);
    }

    // Increase OCA of modified objects
    int changedCount = receiveInt();
    if (changedCount != changedObjects.size())
    {
      throw new ImplementationError("changedCount != changedObjects.size()");
    }

    for (EObject object : changedObjects)
    {
      long oid = receiveLong();
      int oca = receiveInt();

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

    return null;
  }

  private void announceNewResources()
  {
    ResourceManager resourceManager = CdoClientProtocolImpl.getResourceManager(getChannel());
    ResourceSet resourceSet = resourceManager.getResourceSet();
    EList resources = resourceSet.getResources();

    for (Iterator iter = resources.iterator(); iter.hasNext();)
    {
      Resource resource = (Resource) iter.next();

      if (resource instanceof CdoResource)
      {
        CdoResource cdoResource = (CdoResource) resource;

        if (!cdoResource.isExisting())
        {
          transmitInt(cdoResource.getRid());
          transmitString(cdoResource.getPath());
        }
      }
    }

    transmitInt(0);
  }

  private void commitObjectsToDetach()
  {
    if (isDebugEnabled()) debug("commitObjectsToDetach()");

    // Use getObjectsToAttach() because changeDescription is reversed
    for (Iterator iter = EcoreUtil.getAllContents(changeDescription.getObjectsToAttach()); iter
        .hasNext();)
    {
      EObject object = (EObject) iter.next();

      // All changes to detached objects are handled through detachment
      changeDescription.getObjectChanges().removeKey(object);

      long oid = ResourceManagerImpl.getOID(object);
      int oca = ((CdoPersistable) object).cdoGetOCA();
      if ((oid != 0) && (oca != -1))
      {
        if (isDebugEnabled()) debug(ResourceManagerImpl.getLabel(object));
        transmitLong(oid);
      }
    }

    // End of list
    transmitLong(0);
  }

  private void commitObjectsToAttach()
  {
    // TODO Move this to getObjectsToAttach()
    // Use getObjectsToDetach() because changeDescription is reversed
    for (Iterator iter = changeDescription.getObjectsToDetach().iterator(); iter.hasNext();)
    {
      EObject eObject = (EObject) iter.next();
      objectsToAttach.add(eObject);

      for (Iterator tree = eObject.eAllContents(); tree.hasNext();)
      {
        EObject child = (EObject) tree.next();
        objectsToAttach.add(child);
      }
    }

    transmitInt(objectsToAttach.size());

    if (isDebugEnabled())
    {
      debug("commitObjectsToAttach(" + objectsToAttach.size() + " objects)");
    }

    // First transmit all the temporary oids, so that the server knows in advance how to handle references
    for (Iterator iter = objectsToAttach.iterator(); iter.hasNext();)
    {
      EObject eObject = (EObject) iter.next();
      ClassInfo classInfo = packageManager.getClassInfo(eObject);
      if (classInfo == null)
        throw new ImplementationError("Class not registered as CDO persistent: " + eObject.eClass());

      // TODO Remove this after EMF has fixed zero bug
      if (!changeDescription.getObjectChanges().isEmpty())
      {
        // All changes to attached objects are handled through attachment
        changeDescription.getObjectChanges().removeKey(eObject);
      }

      long oid = ResourceManagerImpl.getOID(eObject);
      if (oid == 0) throw new ImplementationError("oid == 0");

      int cid = classInfo.getCID();
      if (cid <= 0) throw new ImplementationError("cid <= 0");

      boolean isContent = (eObject.eContainer() == null);

      if (isDebugEnabled())
        debug("Transmitting object to attach: oid=" + packageManager.getOidEncoder().toString(oid)
            + ", cid=" + cid + ", isContent=" + isContent);

      transmitLong(oid);
      transmitInt(cid);
      transmitBoolean(isContent);

      commitObjectsToAttachAttributes(eObject);
      rememberObjectsToAttachReferences(eObject, classInfo);
    }

    // Then transmit the references of all new objects together 
    commitReferencesToAdd();
  }

  private void commitObjectsToAttachAttributes(EObject eObject)
  {
    ClassInfo classInfo = packageManager.getClassInfo(eObject);
    if (classInfo == null)
      throw new ImplementationError("Class not registered as CDO persistent: " + eObject.eClass());

    while (classInfo != null)
    {
      if (isDebugEnabled()) debug("Transmitting attributeSegment " + classInfo.getFullName());

      AttributeInfo[] attributeInfos = classInfo.getAttributeInfos();

      for (int i = 0; i < attributeInfos.length; i++)
      {
        AttributeInfo attributeInfo = attributeInfos[i];

        if (isDebugEnabled()) debug("Transmitting attribute " + attributeInfo.getName());

        AttributeConverter converter = packageManager.getAttributeConverter();
        converter.toChannel(eObject, attributeInfo.getEAttribute(), getChannel());
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

        for (Iterator valuesIt = values.iterator(); valuesIt.hasNext();)
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

  private void commitReferencesToAdd()
  {
    transmitInt(referenceRecords.size());

    for (Iterator it = referenceRecords.values().iterator(); it.hasNext();)
    {
      ReferenceRecord record = (ReferenceRecord) it.next();
      long oid = record.getOid();
      EReference feature = record.getFeature();
      int ordinal = record.getOrdinal();
      long target = record.getTarget();

      if (isDebugEnabled())
        debug("Transmitting reference to add: oid=" + packageManager.getOidEncoder().toString(oid)
            + ", feature=" + feature.getFeatureID() + ", ordinal=" + ordinal + ", target=" + target);

      transmitLong(oid);
      transmitInt(feature.getFeatureID());
      transmitInt(ordinal); // TODO ordinal necessary?
      transmitLong(target);
      transmitBoolean(feature.isContainment());
    }
  }

  private void commitObjectChanges()
  {
    EMap objectChanges = changeDescription.getObjectChanges();

    if (isDebugEnabled())
    {
      debug("commitObjectChanges(" + objectChanges.size() + " objects)");
    }

    for (Iterator iter = objectChanges.iterator(); iter.hasNext();)
    {
      EObjectToChangesMapEntryImpl entry = (EObjectToChangesMapEntryImpl) iter.next();
      EObject eObject = (EObject) entry.getKey();
      EList featureChanges = (EList) entry.getValue();

      transmitObjectChange(eObject, featureChanges);
    }

    transmitLong(CdoProtocol.NO_MORE_OBJECT_CHANGES);
  }

  private void transmitObjectChange(EObject eObject, EList featureChanges)
  {
    ClassInfo classInfo = packageManager.getClassInfo(eObject);
    if (classInfo == null)
      throw new ImplementationError("Class not registered as CDO persistent: " + eObject.eClass());

    Map eClassToAttributeChangesMap = new HashMap(CAPACITY_eClassToAttributeChangesMap);
    firstChange = true;

    for (Iterator iterator = featureChanges.iterator(); iterator.hasNext();)
    {
      FeatureChange featureChange = (FeatureChange) iterator.next();
      EStructuralFeature feature = featureChange.getFeature();
      int type = featureType(feature, classInfo);

      switch (type)
      {
        case TRANSIENT_FEATURE:
          break;

        case ATTRIBUTE_FEATURE:
          tryObjectChangeHeader(eObject);
          rememberAttributeChange(feature, eClassToAttributeChangesMap);
          break;

        case OBJECT_FEATURE:
          tryObjectChangeHeader(eObject);
          commitObjectChangeReferenceOne(eObject, (EReference) feature);
          break;

        case COLLECTION_FEATURE:
          tryObjectChangeHeader(eObject);
          commitObjectChangeReferenceMany(eObject, featureChange, (EReference) feature);
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

    transmitByte(CdoProtocol.NO_MORE_REFERENCE_CHANGES);
    transmitAttributeChanges(eObject, eClassToAttributeChangesMap);
    changedObjects.add(eObject);
  }

  /**
   * @param object
   * @param classToAttributeChangesMap
   */
  private void transmitAttributeChanges(EObject eObject, Map eClassToAttributeChangesMap)
  {
    for (Iterator mapIt = eClassToAttributeChangesMap.entrySet().iterator(); mapIt.hasNext();)
    {
      Map.Entry entry = (Map.Entry) mapIt.next();
      List attributeChangesOfClassifierList = (List) entry.getValue();

      ClassInfo classInfo = packageManager.getClassInfo((EClass) entry.getKey());
      if (classInfo == null)
        throw new ImplementationError("Class not registered as CDO persistent: " + entry.getKey());

      int cid = classInfo.getCID();
      int count = attributeChangesOfClassifierList.size();

      if (isDebugEnabled())
        debug("Transmitting segment " + classInfo.getFullName() + ": count=" + count);

      transmitInt(cid);
      transmitInt(count);

      for (Iterator listIt = attributeChangesOfClassifierList.iterator(); listIt.hasNext();)
      {
        AttributeInfo attributeInfo = (AttributeInfo) listIt.next();
        transmitAttributeChange(eObject, attributeInfo);
      }
    }

    transmitInt(CdoProtocol.NO_MORE_SEGMENTS);
  }

  /**
   * @param feature
   * @param classToAttributeChangesMap
   */
  private void rememberAttributeChange(EStructuralFeature feature, Map eClassToAttributeChangesMap)
  {
    EClass eClass = feature.getEContainingClass();
    List attributeChangesOfEClass = (List) eClassToAttributeChangesMap.get(eClass);

    if (attributeChangesOfEClass == null)
    {
      attributeChangesOfEClass = new ArrayList();
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
   * @param eObject
   */
  private void tryObjectChangeHeader(EObject eObject)
  {
    if (firstChange)
    {
      firstChange = false;

      long oid = ResourceManagerImpl.getOID(eObject);
      int oca = ResourceManagerImpl.getOCA(eObject);

      if (isDebugEnabled())
        debug("Transmitting object to change: " + ResourceManagerImpl.getLabel(eObject) + ")");

      transmitLong(oid);
      transmitInt(oca);
    }
  }

  private void transmitAttributeChange(EObject eObject, AttributeInfo attributeInfo)
  {
    if (isDebugEnabled()) debug("commitObjectChangeAttribute(" + attributeInfo.getName() + ")");
    EAttribute attribute = attributeInfo.getEAttribute();
    transmitInt(attribute.getFeatureID());

    AttributeConverter converter = packageManager.getAttributeConverter();
    converter.toChannel(eObject, attribute, getChannel());
  }

  private void commitObjectChangeReferenceMany(EObject object, FeatureChange featureChange,
      EReference reference)
  {
    if (isDebugEnabled()) debug("commitObjectChangeReferenceMany(" + reference.getName() + ")");

    long oid = ResourceManagerImpl.getOID(object);

    if (featureChange.isSet())
    {
      EList currentObjects = (EList) object.eGet(reference);
      EList originalObjects = new BasicEList(currentObjects);
      EList listChanges = new BasicEList(featureChange.getListChanges().size());
      for (Iterator it = featureChange.getListChanges().iterator(); it.hasNext();)
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
      for (Iterator it = listChanges.iterator(); it.hasNext();)
      {
        ListChange listChange = (ListChange) it.next();
        ChangeKind changeKind = listChange.getKind();

        switch (changeKind.getValue())
        {
          case ChangeKind.MOVE:
          {
            int index = listChange.getIndex();
            int moveToIndex = listChange.getMoveToIndex();
            transmitReferenceChange(CdoProtocol.LIST_MOVE, oid, reference, index, 0, moveToIndex);
            break;
          }
          case ChangeKind.ADD:
          {
            int index = listChange.getIndex();
            EList values = listChange.getValues();
            for (Iterator itValues = values.iterator(); itValues.hasNext();)
            {
              EObject value = (EObject) itValues.next();
              long target = ResourceManagerImpl.getOID(value);
              transmitReferenceChange(CdoProtocol.LIST_ADD, oid, reference, index, target, 0);
            }
            break;
          }
          case ChangeKind.REMOVE:
          {
            int index = listChange.getIndex();
            transmitReferenceChange(CdoProtocol.LIST_REMOVE, oid, reference, index, 0, 0);
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
      for (Iterator valuesIt = values.iterator(); valuesIt.hasNext();)
      {
        EObject value = (EObject) valuesIt.next();
        long target = ResourceManagerImpl.getOID(value);

        transmitReferenceChange(CdoProtocol.LIST_ADD, oid, reference, ordinal++, target, 0);
      }
    }
  }

  private void commitObjectChangeReferenceOne(EObject object, EReference reference)
  {
    if (isDebugEnabled()) debug("commitObjectChangeReferenceOne()");
    EObject refObject = (EObject) object.eGet(reference);

    long oid = ResourceManagerImpl.getOID(object);
    long target = refObject == null ? 0 : ResourceManagerImpl.getOID(refObject);

    // Add the reference
    byte changeKind = refObject == null ? CdoProtocol.FEATURE_UNSET : CdoProtocol.FEATURE_SET;
    transmitReferenceChange(changeKind, oid, reference, 0, target, 0);
    if (isDebugEnabled() && (refObject != null))
      debug("--> " + reference.getName() + ": " + ResourceManagerImpl.getLabel(refObject));
  }

  private void transmitReferenceChange(byte changeKind, long sourceId, EReference feature,
      int sourceOrdinal, long targetId, int moveToIndex)
  {
    transmitByte(changeKind);
    transmitLong(sourceId);
    transmitInt(feature.getFeatureID());

    switch (changeKind)
    {
      case CdoProtocol.FEATURE_SET:
      {
        if (isDebugEnabled())
          debug("transmitReferenceChange(SET, oid="
              + packageManager.getOidEncoder().toString(sourceId) + ", featureId="
              + feature.getFeatureID() + ", target="
              + packageManager.getOidEncoder().toString(targetId) + ", content="
              + feature.isContainment() + ")");
        transmitLong(targetId);
        transmitBoolean(feature.isContainment());
        break;
      }
      case CdoProtocol.FEATURE_UNSET:
      {
        // Do nothing
        break;
      }
      case CdoProtocol.LIST_ADD:
      {
        if (isDebugEnabled())
          debug("transmitReferenceChange(ADD, oid="
              + packageManager.getOidEncoder().toString(sourceId) + ", featureId="
              + feature.getFeatureID() + ", ordinal=" + sourceOrdinal + ", target=" + targetId
              + ", content=" + feature.isContainment() + ")");
        transmitInt(sourceOrdinal);
        transmitLong(targetId);
        transmitBoolean(feature.isContainment());
        break;
      }
      case CdoProtocol.LIST_REMOVE:
      {
        if (isDebugEnabled())
          debug("transmitReferenceChange(REMOVE, oid="
              + packageManager.getOidEncoder().toString(sourceId) + ", featureId="
              + feature.getFeatureID() + ", ordinal=" + sourceOrdinal + ")");
        transmitInt(sourceOrdinal);
        break;
      }
      case CdoProtocol.LIST_MOVE:
      {
        if (isDebugEnabled())
          debug("transmitReferenceChange(MOVE, oid="
              + packageManager.getOidEncoder().toString(sourceId) + ", featureId="
              + feature.getFeatureID() + ", ordinal=" + sourceOrdinal + ", moveToIndex="
              + moveToIndex + ")");
        transmitInt(sourceOrdinal);
        transmitInt(moveToIndex);
        break;
      }
    }
  }

  private void rememberReferenceToAdd(long oid, EReference feature, int ordinal, long target)
  {
    ReferenceRecord record = new ReferenceRecord(oid, feature, ordinal, target);
    referenceRecords.put(record, record);
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

    public long getOid()
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
