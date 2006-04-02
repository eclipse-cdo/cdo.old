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
package org.eclipse.emf.cdo.client.impl;


import org.eclipse.net4j.core.Channel;

import org.eclipse.emf.cdo.client.AttributeConverter;
import org.eclipse.emf.cdo.core.impl.AbstractConverter;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;


public class AttributeConverterImpl extends AbstractConverter implements AttributeConverter
{
  private static final EcorePackage ECORE = EcorePackage.eINSTANCE;

  public void fromChannel(EObject object, EAttribute attribute, Channel channel)
  {
    int dataType = getCDODataType(attribute.getEAttributeType());

    if (dataType > MIN_PRIMITIVE)
    {
      boolean isNull = channel.receiveBoolean();

      if (isNull)
      {
        object.eSet(attribute, null);
        return;
      }

      if (dataType < MAX_PRIMITIVE)
      {
        dataType = -dataType;
      }
      else if (dataType == USER_DEFINED)
      {
        Object value = fromChannelUserDefined(channel, attribute);
        object.eSet(attribute, value);
        return;
      }
    }

    Object value = dispatchFromChannel(channel, dataType);
    object.eSet(attribute, value);
  }

  public void toChannel(EObject object, EAttribute attribute, Channel channel)
  {
    int dataType = getCDODataType(attribute.getEAttributeType());
    Object value = object.eGet(attribute);

    if (dataType > MIN_PRIMITIVE)
    {
      boolean isNull = value == null;
      channel.transmitBoolean(isNull);

      if (isNull)
      {
        return;
      }

      if (dataType < MAX_PRIMITIVE)
      {
        dataType = -dataType;
      }
      else if (dataType == USER_DEFINED)
      {
        toChannelUserDefined(channel, attribute, value);
        return;
      }
    }

    dispatchToChannel(channel, dataType, value);
  }

  protected Object fromChannelUserDefined(Channel channel, EAttribute attribute)
  {
    EFactory factory = attribute.getEType().getEPackage().getEFactoryInstance();
    EDataType dataType = attribute.getEAttributeType();

    String deserialized = channel.receiveString();
    Object value;

    if (dataType.getInstanceClassName().equals("java.lang.String"))
    {
      value = deserialized;
    }
    else
    {
      value = factory.createFromString(dataType, deserialized);
    }

    return value;
  }

  protected void toChannelUserDefined(Channel channel, EAttribute attribute, Object value)
  {
    EFactory factory = attribute.getEType().getEPackage().getEFactoryInstance();
    EDataType dataType = attribute.getEAttributeType();

    String serialized;

    if (value instanceof String)
    {
      serialized = (String) value;
    }
    else if (value == null)
    {
      serialized = null;
    }
    else
    {
      serialized = factory.convertToString(dataType, value);
    }

    channel.transmitString(serialized);
  }

  public int getCDODataType(EDataType eDataType)
  {
    if (eDataType == ECORE.getEChar())
    {
      return CHAR;
    }
    else if (eDataType == ECORE.getECharacterObject())
    {
      return CHAR_OBJECT;
    }
    else if (eDataType == ECORE.getEBoolean())
    {
      return BOOLEAN;
    }
    else if (eDataType == ECORE.getEBooleanObject())
    {
      return BOOLEAN_OBJECT;
    }
    else if (eDataType == ECORE.getEByte())
    {
      return BYTE;
    }
    else if (eDataType == ECORE.getEByteObject())
    {
      return BYTE_OBJECT;
    }
    else if (eDataType == ECORE.getEShort())
    {
      return SHORT;
    }
    else if (eDataType == ECORE.getEShortObject())
    {
      return SHORT_OBJECT;
    }
    else if (eDataType == ECORE.getEInt())
    {
      return INT;
    }
    else if (eDataType == ECORE.getEIntegerObject())
    {
      return INT_OBJECT;
    }
    else if (eDataType == ECORE.getELong())
    {
      return LONG;
    }
    else if (eDataType == ECORE.getELongObject())
    {
      return LONG_OBJECT;
    }
    else if (eDataType == ECORE.getEFloat())
    {
      return FLOAT;
    }
    else if (eDataType == ECORE.getEFloatObject())
    {
      return FLOAT_OBJECT;
    }
    else if (eDataType == ECORE.getEDouble())
    {
      return DOUBLE;
    }
    else if (eDataType == ECORE.getEDoubleObject())
    {
      return DOUBLE_OBJECT;
    }
    else if (eDataType == ECORE.getEString())
    {
      return STRING;
    }
    else
    {
      return USER_DEFINED;
    }
  }
}
