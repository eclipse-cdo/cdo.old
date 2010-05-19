/*******************************************************************************
 * Copyright (c) 2004 - 2010 Eike Stepper (Berlin, Germany).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fluegge - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.navigator;

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramVisualIDRegistry;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class ClassdiagramNavigatorSorter extends ViewerSorter
{

  /**
   * @generated
   */
  private static final int GROUP_CATEGORY = 7006;

  /**
   * @generated
   */
  public int category(Object element)
  {
    if (element instanceof ClassdiagramNavigatorItem)
    {
      ClassdiagramNavigatorItem item = (ClassdiagramNavigatorItem)element;
      return ClassdiagramVisualIDRegistry.getVisualID(item.getView());
    }
    return GROUP_CATEGORY;
  }

}
