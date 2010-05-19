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

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

/**
 * @generated
 */
public abstract class ClassdiagramAbstractNavigatorItem extends PlatformObject
{

  /**
   * @generated
   */
  static
  {
    final Class[] supportedTypes = new Class[] { ITabbedPropertySheetPageContributor.class };
    final ITabbedPropertySheetPageContributor propertySheetPageContributor = new ITabbedPropertySheetPageContributor()
    {
      public String getContributorId()
      {
        return "org.eclipse.emf.cdo.dawn.reference.editor.diagram"; //$NON-NLS-1$
      }
    };
    Platform.getAdapterManager().registerAdapters(new IAdapterFactory()
    {

      public Object getAdapter(Object adaptableObject, Class adapterType)
      {
        if (adaptableObject instanceof org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.navigator.ClassdiagramAbstractNavigatorItem
            && adapterType == ITabbedPropertySheetPageContributor.class)
        {
          return propertySheetPageContributor;
        }
        return null;
      }

      public Class[] getAdapterList()
      {
        return supportedTypes;
      }
    }, org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.navigator.ClassdiagramAbstractNavigatorItem.class);
  }

  /**
   * @generated
   */
  private Object myParent;

  /**
   * @generated
   */
  protected ClassdiagramAbstractNavigatorItem(Object parent)
  {
    myParent = parent;
  }

  /**
   * @generated
   */
  public Object getParent()
  {
    return myParent;
  }

}
