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
package org.eclipse.emf.cdo.examples.ui;

import org.eclipse.emf.cdo.client.ResourceInfo;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class ResourceLabelProvider extends LabelProvider
{
  public String getText(Object obj)
  {
    if (obj instanceof ResourceInfo)
    {
      ResourceInfo info = ((ResourceInfo)obj);
      return info.getPath();
    }

    return obj.toString();
  }

  public Image getImage(Object obj)
  {
    if (obj instanceof ResourceInfo)
    {
      return UIUtils.getImage("full/obj16/CDOResource");
    }

    ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
    return sharedImages.getImage(ISharedImages.IMG_OBJ_ELEMENT);
  }
}
