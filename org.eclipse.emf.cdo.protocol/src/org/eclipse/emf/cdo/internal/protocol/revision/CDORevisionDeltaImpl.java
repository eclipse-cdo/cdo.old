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
package org.eclipse.emf.cdo.internal.protocol.revision;

import org.eclipse.emf.cdo.internal.protocol.model.CDOClassImpl;
import org.eclipse.emf.cdo.internal.protocol.model.CDOFeatureImpl;
import org.eclipse.emf.cdo.protocol.revision.CDORevisionDelta;

import org.eclipse.net4j.util.ObjectUtil;

import java.util.List;

/**
 * @author Eike Stepper
 */
public class CDORevisionDeltaImpl implements CDORevisionDelta
{
  public CDORevisionDeltaImpl(CDORevisionImpl origin, CDORevisionImpl target)
  {
    CDOClassImpl cdoClass = origin.getCDOClass();
    if (cdoClass != target.getCDOClass())
    {
      throw new IllegalArgumentException("CDO classes are not the same");
    }

    for (CDOFeatureImpl feature : cdoClass.getFeatures())
    {
      Object originValue = origin.getValue(feature);
      Object targetValue = target.getValue(feature);
      if (feature.isMany())
      {
        // TODO Implement method CDORevisionDeltaImpl.CDORevisionDeltaImpl()
        throw new UnsupportedOperationException("Not yet implemented");
      }
      else
      {
        if (!ObjectUtil.equals(originValue, targetValue))
        {
          // TODO Implement method CDORevisionDeltaImpl.CDORevisionDeltaImpl()
          throw new UnsupportedOperationException("Not yet implemented");
        }
      }
    }
  }

  public int getSourceVersion()
  {
    // TODO Implement method CDORevisionDeltaImpl.getSourceVersion()
    throw new UnsupportedOperationException("Not yet implemented");
  }

  public int getTargetVersion()
  {
    // TODO Implement method CDORevisionDeltaImpl.getTargetVersion()
    throw new UnsupportedOperationException("Not yet implemented");
  }

  public List<FeatureChange> getFeatureChanges()
  {
    // TODO Implement method CDORevisionDeltaImpl.getFeatureChanges()
    throw new UnsupportedOperationException("Not yet implemented");
  }
}
