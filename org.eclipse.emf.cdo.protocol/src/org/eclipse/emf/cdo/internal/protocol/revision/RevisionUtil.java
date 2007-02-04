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
package org.eclipse.emf.cdo.internal.protocol;

import org.eclipse.emf.cdo.internal.protocol.CDOIDImpl;
import org.eclipse.emf.cdo.internal.protocol.bundle.CDOProtocol;
import org.eclipse.emf.cdo.internal.protocol.model.CDOFeatureImpl;
import org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl;
import org.eclipse.emf.cdo.protocol.CDOID;

import org.eclipse.net4j.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import java.io.IOException;

/**
 * @author Eike Stepper
 */
public final class RevisionUtil
{
  @SuppressWarnings("unused")
  private static final ContextTracer TRACER = new ContextTracer(CDO.DEBUG_REVISION,
      RevisionUtil.class);

  private static final ContextTracer PROTOCOL = new ContextTracer(CDOProtocol.DEBUG_PROTOCOL,
      RevisionUtil.class);

  private RevisionUtil()
  {
  }

  public static Object cloneAttribute(CDOFeatureImpl feature, Object setting)
  {
    CDOTypeImpl type = feature.getType();
    EFactory factory = dataType.getEPackage().getEFactoryInstance();
    if (feature.isMany())
    {
      EList<Object> sourceList = (EList<Object>)setting;
      EList<Object> targetList = new BasicEList<Object>(sourceList.size());
      for (Object sourceValue : sourceList)
      {
        Object targetValue = cloneAttributeValue(dataType, factory, sourceValue);
        targetList.add(targetValue);
      }

      return targetList;
    }

    return cloneAttributeValue(dataType, factory, setting);
  }

  public static Object cloneAttributeValue(EDataType dataType, EFactory factory, Object value)
  {
    if (dataType.getEPackage() == EcorePackage.eINSTANCE)
    {
      int classifierID = dataType.getClassifierID();
      switch (classifierID)
      {
      case EcorePackage.EBOOLEAN:
      case EcorePackage.EBOOLEAN_OBJECT:

      case EcorePackage.EBYTE:
      case EcorePackage.EBYTE_OBJECT:

      case EcorePackage.ECHAR:
      case EcorePackage.ECHARACTER_OBJECT:

      case EcorePackage.EDOUBLE:
      case EcorePackage.EDOUBLE_OBJECT:

      case EcorePackage.EFLOAT:
      case EcorePackage.EFLOAT_OBJECT:

      case EcorePackage.EINT:
      case EcorePackage.EINTEGER_OBJECT:

      case EcorePackage.ELONG:
      case EcorePackage.ELONG_OBJECT:

      case EcorePackage.ESHORT:
      case EcorePackage.ESHORT_OBJECT:

      case EcorePackage.EBIG_DECIMAL:
      case EcorePackage.EBIG_INTEGER:
      case EcorePackage.ESTRING:
        return value;
      }
    }

    String literal = factory.convertToString(dataType, value);
    return factory.createFromString(dataType, literal);
  }

  public static Object cloneReference(CDOFeatureImpl reference, Object setting)
  {
    if (reference.isMany())
    {
      EList<Object> sourceList = (EList<Object>)setting;
      EList<Object> targetList = new BasicEList<Object>(sourceList.size());
      for (Object sourceValue : sourceList)
      {
        Object targetValue = cloneReferenceValue(sourceValue);
        targetList.add(targetValue);
      }

      return targetList;
    }

    return cloneReferenceValue(setting);
  }

  public static CDOID cloneReferenceValue(Object value)
  {
    return CDOIDImpl.copy((CDOID)value);
  }

  public static void writeAttribute(ExtendedDataOutputStream out, EAttribute attribute,
      Object setting) throws IOException
  {
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.trace("Writing attribute: " + attribute.getName());
    }

    EDataType dataType = attribute.getEAttributeType();
    EFactory factory = dataType.getEPackage().getEFactoryInstance();
    if (attribute.isMany())
    {
      EList<Object> list = (EList<Object>)setting;
      if (PROTOCOL.isEnabled())
      {
        PROTOCOL.trace("Writing size " + list.size());
      }

      out.writeInt(list.size());
      for (Object value : list)
      {
        Object targetValue = cloneAttributeValue(dataType, factory, value);
        writeAttributeValue(out, dataType, factory, targetValue);
      }
    }
    else
    {
      writeAttributeValue(out, dataType, factory, setting);
    }
  }

  public static void writeAttributeValue(ExtendedDataOutputStream out, EDataType dataType,
      EFactory factory, Object value) throws IOException
  {
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.trace("Writing value " + value);
    }

    if (dataType.getEPackage() == EcorePackage.eINSTANCE)
    {
      int classifierID = dataType.getClassifierID();
      switch (classifierID)
      {
      case EcorePackage.EBOOLEAN:
      case EcorePackage.EBOOLEAN_OBJECT:
        out.writeBoolean((Boolean)value);
        break;

      case EcorePackage.EBYTE:
      case EcorePackage.EBYTE_OBJECT:
        out.writeByte((Byte)value);
        break;

      case EcorePackage.ECHAR:
      case EcorePackage.ECHARACTER_OBJECT:
        out.writeChar((Character)value);
        break;

      case EcorePackage.EDOUBLE:
      case EcorePackage.EDOUBLE_OBJECT:
        out.writeDouble((Double)value);
        break;

      case EcorePackage.EFLOAT:
      case EcorePackage.EFLOAT_OBJECT:
        out.writeFloat((Float)value);
        break;

      case EcorePackage.EINT:
      case EcorePackage.EINTEGER_OBJECT:
        out.writeInt((Integer)value);
        break;

      case EcorePackage.ELONG:
      case EcorePackage.ELONG_OBJECT:
        out.writeLong((Long)value);
        break;

      case EcorePackage.ESHORT:
      case EcorePackage.ESHORT_OBJECT:
        out.writeShort((Short)value);
        break;

      case EcorePackage.ESTRING:
        out.writeString((String)value);
        break;

      case EcorePackage.EBIG_DECIMAL:
      case EcorePackage.EBIG_INTEGER:
        // TODO Implement method CDOFeatureUtil.writeAttributeValue()
        throw new UnsupportedOperationException("Not yet implemented");

      default:
        String literal = factory.convertToString(dataType, value);
        out.writeString(literal);
      }
    }
  }

  public static void writeReference(ExtendedDataOutputStream out, EReference reference,
      Object setting) throws IOException
  {
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.trace("Writing reference: " + reference.getName());
    }

    if (reference.isMany())
    {
      EList<Object> list = (EList<Object>)setting;
      if (PROTOCOL.isEnabled())
      {
        PROTOCOL.trace("Writing size " + list.size());
      }

      out.writeInt(list.size());
      for (Object value : list)
      {
        writeReferenceValue(out, value);
      }
    }
    else
    {
      writeReferenceValue(out, setting);
    }
  }

  public static void writeReferenceValue(ExtendedDataOutputStream out, Object value)
      throws IOException
  {
    if (PROTOCOL.isEnabled())
    {
      PROTOCOL.trace("Writing OID " + value);
    }

    ((CDOID)value).write(out);
  }
}
