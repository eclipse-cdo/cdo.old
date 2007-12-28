/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Simon McDuff - https://bugs.eclipse.org/bugs/show_bug.cgi?id=201266
 **************************************************************************/
package org.eclipse.emf.cdo.internal.protocol.revision.delta;

import org.eclipse.emf.cdo.internal.protocol.CDOIDImpl;
import org.eclipse.emf.cdo.internal.protocol.model.CDOClassRefImpl;
import org.eclipse.emf.cdo.internal.protocol.model.CDOFeatureImpl;
import org.eclipse.emf.cdo.internal.protocol.revision.CDOIDProvider;
import org.eclipse.emf.cdo.internal.protocol.revision.CDORevisionImpl;
import org.eclipse.emf.cdo.protocol.CDOID;
import org.eclipse.emf.cdo.protocol.model.CDOClass;
import org.eclipse.emf.cdo.protocol.model.CDOClassRef;
import org.eclipse.emf.cdo.protocol.model.CDOFeature;
import org.eclipse.emf.cdo.protocol.model.CDOPackageManager;
import org.eclipse.emf.cdo.protocol.revision.CDORevision;
import org.eclipse.emf.cdo.protocol.revision.delta.CDOFeatureDelta;
import org.eclipse.emf.cdo.protocol.revision.delta.CDOFeatureDeltaVisitor;
import org.eclipse.emf.cdo.protocol.revision.delta.CDORevisionDelta;

import org.eclipse.net4j.util.io.ExtendedDataInput;
import org.eclipse.net4j.util.io.ExtendedDataOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class CDORevisionDeltaImpl implements CDORevisionDelta
{
  private CDOID cdoID;

  private CDOClass cdoClass;

  private int dirtyVersion;

  private int originVersion;

  private Map<CDOFeature, CDOFeatureDelta> featureDeltas = new HashMap<CDOFeature, CDOFeatureDelta>();

  public CDORevisionDeltaImpl(CDORevision cdoRevision)
  {
    cdoClass = cdoRevision.getCDOClass();
    cdoID = cdoRevision.getID();
    dirtyVersion = cdoRevision.getVersion();
    originVersion = cdoRevision.getVersion() - 1;
  }

  public CDORevisionDeltaImpl(CDORevision originRevision, CDORevision dirtyRevision)
  {
    if (originRevision.getCDOClass() != dirtyRevision.getCDOClass())
    {
      throw new IllegalArgumentException();
    }

    this.cdoClass = originRevision.getCDOClass();
    this.cdoID = originRevision.getID();
    this.dirtyVersion = originRevision.getVersion();
    this.originVersion = dirtyRevision.getVersion();

    this.compare(originRevision, dirtyRevision);

    if (!this.compare(originRevision.getData().getContainerID(), dirtyRevision.getData().getContainerID())
        || !this.compare(originRevision.getData().getContainingFeatureID(), dirtyRevision.getData()
            .getContainingFeatureID()))
    {
      addFeatureDelta(new CDOContainerFeatureDeltaImpl(dirtyRevision.getData().getContainerID(), dirtyRevision
          .getData().getContainingFeatureID()));
    }

  }

  public CDORevisionDeltaImpl(ExtendedDataInput in, CDOPackageManager packageManager) throws IOException
  {
    read(in, packageManager);
  }

  public CDOID getId()
  {
    return cdoID;
  }

  public int getOriginVersion()
  {
    return originVersion;
  }

  public int getDirtyVersion()
  {
    return dirtyVersion;
  }

  public List<CDOFeatureDelta> getFeatureDeltas()
  {
    return new ArrayList<CDOFeatureDelta>(featureDeltas.values());
  }

  public void applyChanges(CDORevisionImpl revision)
  {
    revision.setVersion(dirtyVersion < 0 ? -dirtyVersion : dirtyVersion);
    for (CDOFeatureDelta featureChange : featureDeltas.values())
    {
      CDOFeatureDeltaImpl changeImpl = (CDOFeatureDeltaImpl)featureChange;
      changeImpl.apply(revision);
    }
  }

  public void read(ExtendedDataInput in, CDOPackageManager packageManager) throws IOException
  {
    CDOClassRef classRef = new CDOClassRefImpl(in, null);
    cdoClass = classRef.resolve(packageManager);
    cdoID = CDOIDImpl.read(in);
    originVersion = in.readInt();
    dirtyVersion = in.readInt();
    int size = in.readInt();
    for (int i = 0; i < size; i++)
    {
      CDOFeatureDelta featureChange = CDOFeatureDeltaImpl.readFeature(in, cdoClass);
      featureDeltas.put(featureChange.getFeature(), featureChange);
    }
  }

  public void write(ExtendedDataOutput out, CDOIDProvider idProvider) throws IOException
  {
    CDOClassRefImpl classRef = (CDOClassRefImpl)cdoClass.createClassRef();
    classRef.write(out, null);
    CDOIDImpl.write(out, cdoID);

    out.writeInt(originVersion);
    out.writeInt(dirtyVersion);

    out.writeInt(featureDeltas.size());
    for (CDOFeatureDelta featureChange : featureDeltas.values())
    {
      ((CDOFeatureDeltaImpl)featureChange).write(out, idProvider);
    }
  }

  public void addFeatureDelta(CDOFeatureDelta delta)
  {
    if (delta.getFeature().isMany())
    {
      CDOListFeatureDeltaImpl lookupDelta = (CDOListFeatureDeltaImpl)featureDeltas.get(delta.getFeature());
      if (lookupDelta == null)
      {
        lookupDelta = new CDOListFeatureDeltaImpl(delta.getFeature());
        featureDeltas.put(lookupDelta.getFeature(), lookupDelta);
      }

      lookupDelta.add(delta);
    }
    else
    {
      featureDeltas.put(delta.getFeature(), delta);
    }
  }

  public void adjustReferences(Map<CDOID, CDOID> idMappings)
  {
    for (CDOFeatureDelta featureChange : featureDeltas.values())
    {
      ((CDOFeatureDeltaImpl)featureChange).adjustReferences(idMappings);
    }
  }

  public void accept(CDOFeatureDeltaVisitor visitor)
  {
    for (CDOFeatureDelta featureChange : featureDeltas.values())
    {
      ((CDOFeatureDeltaImpl)featureChange).accept(visitor);
    }
  }

  private void compare(CDORevision originRevision, CDORevision dirtyRevision)
  {
    CDOFeature features[] = cdoClass.getAllFeatures();
    int count = cdoClass.getFeatureCount();
    for (int i = 0; i < count; i++)
    {
      CDOFeatureImpl feature = (CDOFeatureImpl)features[i];
      if (feature.isMany())
      {
        int originSize = originRevision.getData().size(feature);
        int dirtySize = dirtyRevision.getData().size(feature);
        if (dirtySize == 0 && originSize > 0)
        {
          addFeatureDelta(new CDOClearFeatureDeltaImpl(feature));
        }
        else
        {
          int originIndex = 0;
          int dirtyIndex = 0;
          if (originSize == dirtySize)
          {
            for (; originIndex < originSize && dirtyIndex < dirtySize; dirtyIndex++, originIndex++)
            {
              Object originValue = originRevision.getData().get(feature, originIndex);
              Object dirtyValue = dirtyRevision.getData().get(feature, dirtyIndex);

              if (!compare(originValue, dirtyValue))
              {
                dirtyIndex = 0;
                break;
              }
            }
          }

          if (originIndex != originSize || dirtyIndex != dirtySize)
          {
            // Not identical
            // Be very stupid and do the simplest thing.
            // Clear and add all value;
            if (originSize > 0)
            {
              addFeatureDelta(new CDOClearFeatureDeltaImpl(feature));
            }

            for (int k = 0; k < dirtySize; k++)
            {
              Object dirtyValue = dirtyRevision.getData().get(feature, k);
              addFeatureDelta(new CDOAddFeatureDeltaImpl(feature, k, dirtyValue));
            }
          }
        }
      }
      else
      {
        Object originValue = originRevision.getData().get(feature, 0);
        Object dirtyValue = dirtyRevision.getData().get(feature, 0);
        if (!compare(originValue, dirtyValue))
        {
          if (dirtyValue == null)
          {
            addFeatureDelta(new CDOUnsetFeatureDeltaImpl(feature));
          }
          else
          {
            addFeatureDelta(new CDOSetFeatureDeltaImpl(feature, 0, dirtyValue));
          }
        }
      }
    }
  }

  private boolean compare(Object originValue, Object dirtyValue)
  {
    return originValue == dirtyValue || originValue != null && dirtyValue != null && originValue.equals(dirtyValue);
  }
}
