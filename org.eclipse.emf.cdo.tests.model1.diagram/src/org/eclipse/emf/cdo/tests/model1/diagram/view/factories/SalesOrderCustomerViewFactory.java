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
package org.eclipse.emf.cdo.tests.model1.diagram.view.factories;

import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.SalesOrderCustomerEditPart;
import org.eclipse.emf.cdo.tests.model1.diagram.part.Model1VisualIDRegistry;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;

import java.util.ArrayList;
import java.util.List;

/**
 * @generated
 */
public class SalesOrderCustomerViewFactory extends ConnectionViewFactory
{

  /**
   * @generated
   */
  protected List createStyles(View view)
  {
    List styles = new ArrayList();
    styles.add(NotationFactory.eINSTANCE.createConnectorStyle());
    styles.add(NotationFactory.eINSTANCE.createFontStyle());
    return styles;
  }

  /**
   * @generated
   */
  protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint,
      int index, boolean persisted)
  {
    if (semanticHint == null)
    {
      semanticHint = Model1VisualIDRegistry.getType(SalesOrderCustomerEditPart.VISUAL_ID);
      view.setType(semanticHint);
    }
    super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
  }
}
