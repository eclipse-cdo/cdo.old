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
package org.eclipse.emf.cdo.client.impl;


import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.cdo.client.PausableChangeRecorder;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import java.util.Collections;


public class PausableChangeRecorderImpl extends ChangeRecorder implements PausableChangeRecorder
{
  public void setRecording(boolean on)
  {
    recording = on;
  }

  public void setLoading(boolean on)
  {
    loadingTargets = on;
  }

  public void beginRecording(ResourceSet resourceSet)
  {
    beginRecording(Collections.singleton(resourceSet));
  }

  //  public void notifyChanged(Notification notification)
  //  {
  //    Object notifier = notification.getNotifier();
  //    if (notifier instanceof ResourceSet)
  //    {
  //      if (notification.getFeatureID(ResourceSet.class) == ResourceSet.RESOURCE_SET__RESOURCES)
  //      {
  //        if (notification.getEventType() == Notification.ADD)
  //        {
  //          Notifier newValue = (Notifier) notification.getNewValue();
  //          if (!(newValue instanceof CDOResource))
  //          {
  //            return;
  //          }
  //        }
  //      }
  //
  //      super.notifyChanged(notification);
  //    }
  //  }

  @Override
  protected void addAdapter(Notifier notifier)
  {
    if (notifier instanceof Resource)
    {
      if (notifier instanceof CDOResource)
      {
        super.addAdapter(notifier);
      }
    }
    else
    {
      super.addAdapter(notifier);
    }
  }
}