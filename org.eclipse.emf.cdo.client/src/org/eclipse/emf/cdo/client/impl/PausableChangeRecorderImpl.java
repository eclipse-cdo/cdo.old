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
package org.eclipse.emf.cdo.client.impl;


import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.cdo.client.PausableChangeRecorder;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ResourceChange;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import java.util.Collections;
import java.util.List;


public class PausableChangeRecorderImpl extends ChangeRecorder implements PausableChangeRecorder
{

  public PausableChangeRecorderImpl()
  {
    setResolveProxies(false);
  }

  public void setRecording(boolean on)
  {
    recording = on;
  }

  public void setLoading(boolean on)
  {
    loadingTargets = on;
  }

  public boolean isChanged(Object object)
  {
    if (object instanceof EObject)
    {
      List featureChanges = getFeatureChanges((EObject) object);
      return !featureChanges.isEmpty();
    }

    if (object instanceof Resource)
    {
      ResourceChange resourceChange = getResourceChange((Resource) object);
      return resourceChange != null;
    }

    return false;
  }

  public void beginRecording(ResourceSet resourceSet)
  {
    beginRecording(Collections.singleton(resourceSet));
  }

  public void setTarget(Notifier target)
  {
    if (!targetObjects.add(target))
    {
      throw new IllegalStateException("The target should not be set more than once");
    }

    if (loadingTargets)
    {
      originalTargetObjects.add(target);
    }

    //    Iterator contents = 
    //      target instanceof EObject ? 
    //        resolveProxies ?  
    //          ((EObject)target).eContents().iterator() : 
    //          ((InternalEList)((EObject)target).eContents()).basicIterator() :
    //        target instanceof ResourceSet ? 
    //          ((ResourceSet)target).getResources().iterator() : 
    //            target instanceof Resource ? 
    //              ((Resource)target).getContents().iterator() : 
    //                null;
    //
    //    if (contents != null)
    //    {
    //      while (contents.hasNext())
    //      {
    //        Notifier notifier = (Notifier)contents.next();
    //        addAdapter(notifier);
    //      }
    //    }
  }

  //  public void notifyChanged(Notification notification)
  //  {
  //    Object notifier = notification.getNotifier();
  //    if (notifier instanceof Resource)
  //    {
  //      int featureID = notification.getFeatureID(Resource.class);
  //      switch (featureID)
  //      {
  //        case Resource.RESOURCE__IS_LOADED:
  //          return;
  //      }
  //    }
  //
  //    super.notifyChanged(notification);
  //  }

  @Override
  public void addAdapter(Notifier notifier)
  {
    // XXX
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
