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


import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.spring.Service;

import org.eclipse.emf.cdo.core.CDODataTypes;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;


/**
 * Maps {@link EDataType} instances to CDO data type IDs
 * and transfers attribute values between {@link EObject} 
 * and {@link Channel} instances.<p>
 * 
 * An {@link AttributeConverter} may apply any sort of data type conversion to 
 * optimize the payload traffic through the {@link Channel}, as long as the 
 * corresponding {@link AttributeConverter} at server side is able to handle 
 * the specific data format.<p> 
 *
 * <b>Note:</b> An {@link AttributeConverter} service is needed both at server 
 * and at client side (different interfaces). Their interpretations of the data type 
 * formats have to be identical under all circumstances! Otherwise unpredictable
 * behaviour will occur, in the best case resulting in an 
 * {@link org.eclipse.net4j.core.OutOfSequenceException} being thrown and always rendering the
 * affected {@link Channel} unusable. Other channels of the same 
 * {@link org.eclipse.net4j.core.Connector} are not affected.<p>
 *
 * @see CDODataTypes
 * @author Eike Stepper
 */
public interface AttributeConverter extends Service, CDODataTypes
{
  /**
   * Reads a value from a {@link Channel} and writes it to the given
   * object attribute.<p>
   *
   * @param object The object to store value in.
   * @param attribute The attribute to store the value in.
   * @param channel The channel to read the value from.
   */
  public void fromChannel(EObject object, EAttribute attribute, Channel channel);

  /**
   * Reads a value from an object attribute and writes it to the given
   * {@link Channel} .<p>
   *
   * @param object The object to read the value from.
   * @param attribute The attribute to read the value from.
   * @param channel The channel to write the value to.
   */
  public void toChannel(EObject object, EAttribute attribute, Channel channel);

  /**
   * Returns the CDO data type ID (as specified in 
   * {@link CDODataTypes}) for the given {@link EDataType} 
   * instance.<p>
   *
   * @param eDataType The EMF data type instance to map to the CDO type system.
   * @return The CDO data type ID.
   */
  public int getCDODataType(EDataType eDataType);
}
