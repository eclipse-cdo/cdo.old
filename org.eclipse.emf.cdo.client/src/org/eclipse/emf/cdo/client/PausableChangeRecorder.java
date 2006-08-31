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
package org.eclipse.emf.cdo.client;


import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;


/**
 * For internal use only.<p>
 * 
 * @author Eike Stepper
 */
public interface PausableChangeRecorder extends Adapter.Internal
{
  /**
   * For internal use only.<p>
   */
  public void setRecording(boolean on);

  /**
   * For internal use only.<p>
   */
  public void setLoading(boolean on);

  /**
   * For internal use only.<p>
   */
  public void addAdapter(Notifier notifier);

  /**
   * For internal use only.<p>
   */
  public void beginRecording(ResourceSet resourceSet);

  /**
   * For internal use only.<p>
   */
  public ChangeDescription endRecording();

  /**
   * For internal use only.<p>
   */
  public boolean isChanged(Object object);
}
