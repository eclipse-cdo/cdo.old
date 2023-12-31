/*
 * Copyright (c) 2008 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Victor Roldan Betancort - GMF models creation and initial generation
 *    Eike Stepper - maintenance
 */
package org.eclipse.emf.cdo.tests.model1.diagram.sheet;

import org.eclipse.emf.cdo.tests.model1.diagram.navigator.Model1NavigatorGroup;
import org.eclipse.emf.cdo.tests.model1.diagram.part.Model1DiagramEditorPlugin;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class Model1SheetLabelProvider extends DecoratingLabelProvider
{

  /**
   * @generated
   */
  public Model1SheetLabelProvider()
  {
    super(new AdapterFactoryLabelProvider(Model1DiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory()),
        null);
  }

  /**
   * @generated
   */
  public String getText(Object element)
  {
    Object selected = unwrap(element);
    if (selected instanceof Model1NavigatorGroup)
    {
      return ((Model1NavigatorGroup)selected).getGroupName();
    }
    return super.getText(selected);
  }

  /**
   * @generated
   */
  public Image getImage(Object element)
  {
    return super.getImage(unwrap(element));
  }

  /**
   * @generated
   */
  private Object unwrap(Object element)
  {
    if (element instanceof IStructuredSelection)
    {
      return unwrap(((IStructuredSelection)element).getFirstElement());
    }
    if (element instanceof EditPart)
    {
      return unwrapEditPart((EditPart)element);
    }
    if (element instanceof IAdaptable)
    {
      View view = (View)((IAdaptable)element).getAdapter(View.class);
      if (view != null)
      {
        return unwrapView(view);
      }
    }
    return element;
  }

  /**
   * @generated
   */
  private Object unwrapEditPart(EditPart p)
  {
    if (p.getModel() instanceof View)
    {
      return unwrapView((View)p.getModel());
    }
    return p.getModel();
  }

  /**
   * @generated
   */
  private Object unwrapView(View view)
  {
    return view.getElement() == null ? view : view.getElement();
  }

}
