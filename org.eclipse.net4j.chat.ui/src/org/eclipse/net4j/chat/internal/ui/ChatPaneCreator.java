/***************************************************************************
 * Copyright (c) 2004 - 2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.chat.internal.ui;

import org.eclipse.net4j.buddies.internal.ui.views.FacilityPane;
import org.eclipse.net4j.buddies.ui.IFacilityPaneCreator;
import org.eclipse.net4j.internal.chat.ChatFactory;

import org.eclipse.swt.widgets.Composite;

/**
 * @author Eike Stepper
 */
public class ChatPaneCreator implements IFacilityPaneCreator
{
  public static final String TYPE = ChatFactory.TYPE;

  public ChatPaneCreator()
  {
  }

  public String getFacilityType()
  {
    return TYPE;
  }

  public FacilityPane createFacilityPane(Composite parent, int style)
  {
    return new ChatPane(parent, style);
  }
}
