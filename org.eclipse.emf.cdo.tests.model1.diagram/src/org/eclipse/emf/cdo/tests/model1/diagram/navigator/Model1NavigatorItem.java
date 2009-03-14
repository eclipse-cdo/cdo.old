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
package org.eclipse.emf.cdo.tests.model1.diagram.navigator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class Model1NavigatorItem extends Model1AbstractNavigatorItem
{

  /**
   * @generated
   */
  static
  {
    final Class[] supportedTypes = new Class[] { View.class, EObject.class };
    Platform.getAdapterManager().registerAdapters(new IAdapterFactory()
    {

      public Object getAdapter(Object adaptableObject, Class adapterType)
      {
        if (adaptableObject instanceof org.eclipse.emf.cdo.tests.model1.diagram.navigator.Model1NavigatorItem
            && (adapterType == View.class || adapterType == EObject.class))
        {
          return ((org.eclipse.emf.cdo.tests.model1.diagram.navigator.Model1NavigatorItem)adaptableObject).getView();
        }
        return null;
      }

      public Class[] getAdapterList()
      {
        return supportedTypes;
      }
    }, org.eclipse.emf.cdo.tests.model1.diagram.navigator.Model1NavigatorItem.class);
  }

  /**
   * @generated
   */
  private View myView;

  /**
   * @generated
   */
  private boolean myLeaf = false;

  /**
   * @generated
   */
  public Model1NavigatorItem(View view, Object parent, boolean isLeaf)
  {
    super(parent);
    myView = view;
    myLeaf = isLeaf;
  }

  /**
   * @generated
   */
  public View getView()
  {
    return myView;
  }

  /**
   * @generated
   */
  public boolean isLeaf()
  {
    return myLeaf;
  }

  /**
   * @generated
   */
  public boolean equals(Object obj)
  {
    if (obj instanceof org.eclipse.emf.cdo.tests.model1.diagram.navigator.Model1NavigatorItem)
    {
      return EcoreUtil.getURI(getView()).equals(
          EcoreUtil.getURI(((org.eclipse.emf.cdo.tests.model1.diagram.navigator.Model1NavigatorItem)obj).getView()));
    }
    return super.equals(obj);
  }

  /**
   * @generated
   */
  public int hashCode()
  {
    return EcoreUtil.getURI(getView()).hashCode();
  }

}
