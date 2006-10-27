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

import org.eclipse.emf.cdo.client.ClassInfo;
import org.eclipse.emf.cdo.client.PackageInfo;
import org.eclipse.emf.cdo.examples.ui.internal.ExampleUIActivator;

import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public final class PackageLabelProvider extends LabelProvider
{
  public PackageLabelProvider()
  {
  }

  @Override
  public Image getImage(Object element)
  {
    if (element instanceof PackageInfo)
    {
      return ExtendedImageRegistry.getInstance().getImage(
          ExampleUIActivator.INSTANCE.getImage("full/obj16/EPackage"));
    }

    if (element instanceof ClassInfo)
    {
      return ExtendedImageRegistry.getInstance().getImage(
          ExampleUIActivator.INSTANCE.getImage("full/obj16/EClass"));
    }

    return super.getImage(element);
  }

  @Override
  public String getText(Object element)
  {
    if (element instanceof PackageInfo)
    {
      return ((PackageInfo)element).getEPackage().getNsURI();
    }

    if (element instanceof ClassInfo)
    {
      return ((ClassInfo)element).getName();
    }

    return super.getText(element);
  }
}
