/***************************************************************************
 * Copyright (c) 2004-2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.protocol.revision;

import org.eclipse.emf.cdo.internal.protocol.revision.CDORevisionImpl;
import org.eclipse.emf.cdo.protocol.model.CDOFeature;

import java.util.List;

/**
 * @author Eike Stepper
 */
public interface CDORevisionDelta
{
  public int getSourceVersion();

  public int getTargetVersion();

  public List<FeatureChange> getFeatureChanges();

  /**
   * @author Eike Stepper
   */
  public interface FeatureChange
  {
    public CDOFeature getFeature();
  }

  /**
   * @see CDORevisionImpl#set(CDOFeature, int, Object)
   * @author Eike Stepper
   */
  public interface SetFeatureChange extends FeatureChange
  {
    public int getIndex();

    public Object getValue();
  }

  /**
   * @see CDORevisionImpl#unset(CDOFeature)
   * @author Eike Stepper
   */
  public interface UnsetFeatureChange extends FeatureChange
  {
  }

  /**
   * @see CDORevisionImpl#add(CDOFeature, int, Object)
   * @author Eike Stepper
   */
  public interface AddFeatureChange extends FeatureChange
  {
    public int getIndex();

    public Object getValue();
  }

  /**
   * @see CDORevisionImpl#remove(CDOFeature, int)
   * @author Eike Stepper
   */
  public interface RemoveFeatureChange extends FeatureChange
  {
    public int getIndex();
  }

  /**
   * @see CDORevisionImpl#move(CDOFeature, int, int)
   * @author Eike Stepper
   */
  public interface MoveFeatureChange extends FeatureChange
  {
    public int getSourceIndex();

    public int getTargetIndex();
  }
}
