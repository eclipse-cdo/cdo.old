/*******************************************************************************
 * Copyright (c) 2010 Martin Fluegge (Berlin, Germany).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fluegge - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.sheet;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.navigator.ClassdiagramNavigatorGroup;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramVisualIDRegistry;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.providers.ClassdiagramElementTypes;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class ClassdiagramSheetLabelProvider extends BaseLabelProvider implements ILabelProvider
{

  /**
   * @generated
   */
  public String getText(Object element)
  {
    element = unwrap(element);
    if (element instanceof ClassdiagramNavigatorGroup)
    {
      return ((ClassdiagramNavigatorGroup)element).getGroupName();
    }
    IElementType etype = getElementType(getView(element));
    return etype == null ? "" : etype.getDisplayName();
  }

  /**
   * @generated
   */
  public Image getImage(Object element)
  {
    IElementType etype = getElementType(getView(unwrap(element)));
    return etype == null ? null : ClassdiagramElementTypes.getImage(etype);
  }

  /**
   * @generated
   */
  private Object unwrap(Object element)
  {
    if (element instanceof IStructuredSelection)
    {
      return ((IStructuredSelection)element).getFirstElement();
    }
    return element;
  }

  /**
   * @generated
   */
  private View getView(Object element)
  {
    if (element instanceof View)
    {
      return (View)element;
    }
    if (element instanceof IAdaptable)
    {
      return (View)((IAdaptable)element).getAdapter(View.class);
    }
    return null;
  }

  /**
   * @generated
   */
  private IElementType getElementType(View view)
  {
    // For intermediate views climb up the containment hierarchy to find the one associated with an element type.
    while (view != null)
    {
      int vid = ClassdiagramVisualIDRegistry.getVisualID(view);
      IElementType etype = ClassdiagramElementTypes.getElementType(vid);
      if (etype != null)
      {
        return etype;
      }
      view = view.eContainer() instanceof View ? (View)view.eContainer() : null;
    }
    return null;
  }

}
