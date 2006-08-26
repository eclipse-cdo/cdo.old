/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
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


/**
 * Stores CDO related information for an associated {@link EAttribute} instance.<p>
 * 
 * The most important information is the mapping specification that is determined 
 * from a mapping file or from model annotations. An {@link AttributeInfo} 
 * instance is always contained in a {@link ClassInfo} instance.<p>
 * 
 * This interface is not expected to be implemented by clients.<p>
 * 
 * @see EAttribute
 * @see AttributeMapping
 * @see ClassInfo
 * @author Eike Stepper
 */
public interface AttributeInfo extends CDODataTypes
{
  /**
   * Returns the name of this attribute.<p>
   *
   * @return The name of this attribute (is never <code>null</code>).
   */
  public String getName();

  /**
   * Returns the CDO data type ID of this attribute.<p>
   *
   * @return The CDO data type ID of this attribute.
   */
  public int getDataType();

  /**
   * Returns the Ecore structural feature of this attribute.<p>
   *
   * @return The Ecore structural feature of this attribute (is never <code>null</code>).
   */
  public EAttribute getEAttribute();

  /**
   * Returns the CDO mapping info of this attribute.<p>
   *
   * @return The CDO mapping info of this attribute (is never <code>null</code>).
   */
  public AttributeMapping getMapping();

  /**
   * Returns the {@link ClassInfo} instance this attribute is contained in.<p>
   *
   * @return The {@link ClassInfo} instance this attribute is contained in (is never <code>null</code>).
   */
  public ClassInfo getClassInfo();
}
