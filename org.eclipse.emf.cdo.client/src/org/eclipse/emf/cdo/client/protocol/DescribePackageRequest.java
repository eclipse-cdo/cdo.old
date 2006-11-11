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
package org.eclipse.emf.cdo.client.protocol;


import org.eclipse.net4j.transport.Channel;
import org.eclipse.net4j.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.stream.ExtendedDataInputStream;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import org.eclipse.emf.cdo.client.AttributeInfo;
import org.eclipse.emf.cdo.client.ClassInfo;
import org.eclipse.emf.cdo.client.PackageInfo;
import org.eclipse.emf.cdo.client.internal.CDOClient;
import org.eclipse.emf.cdo.core.CDOProtocol;

import java.io.IOException;


public class DescribePackageRequest extends AbstractPackageRequest<Boolean>
{
  private static final ContextTracer TRACER = new ContextTracer(CDOClient.DEBUG_PROTOCOL,
      DescribePackageRequest.class);

  private PackageInfo packageInfo;

  public DescribePackageRequest(Channel channel, PackageInfo packageInfo)
  {
    super(channel);
    this.packageInfo = packageInfo;
  }

  @Override
  protected short getSignalID()
  {
    return CDOProtocol.DESCRIBE_PACKAGE;
  }

  @Override
  protected void requesting(ExtendedDataOutputStream out) throws IOException
  {
    if (TRACER.isEnabled())
    {
      TRACER.trace("Describing package " + packageInfo.getFullName());
    }

    out.writeString(packageInfo.getFullName());
    ClassInfo[] classes = packageInfo.getClasses();
    out.writeInt(classes.length);
    for (int i = 0; i < classes.length; i++)
    {
      ClassInfo classInfo = classes[i];
      if (TRACER.isEnabled())
      {
        TRACER.trace("Describing class " + classInfo.getFullName());
      }

      out.writeString(classInfo.getFullName());
      out.writeString(classInfo.getParent() == null ? null : classInfo.getParent().getFullName());
      out.writeString(classInfo.getMapping().getTableName());
      transmitAttributes(out, classInfo);
    }
  }

  @Override
  protected Boolean confirming(ExtendedDataInputStream in) throws IOException
  {
    int count = in.readInt();
    if (count >= 0)
    {
      handlePackageResponse(in, count);
      return Boolean.TRUE;
    }
    else
    {
      if (TRACER.isEnabled())
      {
        TRACER.trace("Unknown package " + packageInfo.getFullName());
      }

      return false;
    }
  }

  private void transmitAttributes(ExtendedDataOutputStream out, ClassInfo classInfo)
      throws IOException
  {
    AttributeInfo[] attributes = classInfo.getAttributeInfos();
    out.writeInt(attributes.length);

    for (int j = 0; j < attributes.length; j++)
    {
      AttributeInfo attributeInfo = attributes[j];
      if (TRACER.isEnabled())
      {
        TRACER.trace("Describing attribute " + attributeInfo.getName());
      }

      out.writeString(attributeInfo.getName());
      out.writeInt(attributeInfo.getEAttribute().getFeatureID());
      out.writeInt(attributeInfo.getDataType());
      out.writeString(attributeInfo.getMapping().getColumnName());
      out.writeInt(attributeInfo.getMapping().getColumnType());
      // TODO Handle column length, precision, ...
    }
  }
}
