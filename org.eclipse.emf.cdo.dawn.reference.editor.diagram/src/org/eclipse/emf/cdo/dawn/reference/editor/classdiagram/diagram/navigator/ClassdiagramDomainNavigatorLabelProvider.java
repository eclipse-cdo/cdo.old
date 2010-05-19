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

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramDiagramEditorPlugin;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
public class ClassdiagramDomainNavigatorLabelProvider implements ICommonLabelProvider
{

  /**
   * @generated
   */
  private AdapterFactoryLabelProvider myAdapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
      ClassdiagramDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

  /**
   * @generated
   */
  public void init(ICommonContentExtensionSite aConfig)
  {
  }

  /**
   * @generated
   */
  public Image getImage(Object element)
  {
    if (element instanceof ClassdiagramDomainNavigatorItem)
    {
      return myAdapterFactoryLabelProvider.getImage(((ClassdiagramDomainNavigatorItem)element).getEObject());
    }
    return null;
  }

  /**
   * @generated
   */
  public String getText(Object element)
  {
    if (element instanceof ClassdiagramDomainNavigatorItem)
    {
      return myAdapterFactoryLabelProvider.getText(((ClassdiagramDomainNavigatorItem)element).getEObject());
    }
    return null;
  }

  /**
   * @generated
   */
  public void addListener(ILabelProviderListener listener)
  {
    myAdapterFactoryLabelProvider.addListener(listener);
  }

  /**
   * @generated
   */
  public void dispose()
  {
    myAdapterFactoryLabelProvider.dispose();
  }

  /**
   * @generated
   */
  public boolean isLabelProperty(Object element, String property)
  {
    return myAdapterFactoryLabelProvider.isLabelProperty(element, property);
  }

  /**
   * @generated
   */
  public void removeListener(ILabelProviderListener listener)
  {
    myAdapterFactoryLabelProvider.removeListener(listener);
  }

  /**
   * @generated
   */
  public void restoreState(IMemento aMemento)
  {
  }

  /**
   * @generated
   */
  public void saveState(IMemento aMemento)
  {
  }

  /**
   * @generated
   */
  public String getDescription(Object anElement)
  {
    return null;
  }

}
