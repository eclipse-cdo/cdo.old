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
package org.eclipse.emf.cdo.protocol.revision;

import java.util.List;

/**
 * @author Eike Stepper
 */
public interface CDORevisionDelta
{
  public CDORevision getOrigin();

  public CDORevision getTarget();

  public List<Change> getChanges();

  /**
   * @author Eike Stepper
   */
  public interface Change
  {
    // public CDORevisionDelta getDelta();
    //
    // public CDOFeature getFeature();
    //
    // public Object getOriginValue();
    //
    // public Object getTargetValue();
  }

  /**
   * @author Eike Stepper
   */
  public interface ListChange extends Change
  {

    public enum ChangeKind
    {
      ADDED, REMOVED, MOVED
    }
  }
}
