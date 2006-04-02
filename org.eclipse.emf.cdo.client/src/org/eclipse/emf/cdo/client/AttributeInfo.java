/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.client;


import org.eclipse.emf.cdo.core.CDODataTypes;
import org.eclipse.emf.cdo.mapping.AttributeMapping;
import org.eclipse.emf.ecore.EAttribute;


public interface AttributeInfo extends CDODataTypes
{
  public String getName();

  public int getDataType();

  public EAttribute getEAttribute();

  public AttributeMapping getMapping();

  public ClassInfo getClassInfo();
}
