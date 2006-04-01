/*******************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Sympedia Methods and Tools.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *******************************************************************************/

package org.eclipse.emf.cdo.client;


import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.spring.Service;

import org.eclipse.emf.cdo.core.CdoDataTypes;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;


public interface AttributeConverter extends Service, CdoDataTypes
{
  public void fromChannel(EObject object, EAttribute attribute, Channel channel);

  public void toChannel(EObject object, EAttribute attribute, Channel channel);

  public int getCdoDataType(EDataType eDataType);
}