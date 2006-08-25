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


import org.eclipse.emf.cdo.client.AttributeInfo;
import org.eclipse.emf.cdo.client.ClassInfo;
import org.eclipse.emf.cdo.client.PackageInfo;
import org.eclipse.emf.cdo.core.CDOProtocol;


public class DescribePackageRequest extends AbstractPackageRequest
{
  private PackageInfo packageInfo;

  public DescribePackageRequest(PackageInfo packageInfo)
  {
    this.packageInfo = packageInfo;
  }

  public short getSignalId()
  {
    return CDOProtocol.DESCRIBE_PACKAGE;
  }

  public void request()
  {
    if (isDebugEnabled()) debug("Describing package " + packageInfo.getFullName());
    transmitString(packageInfo.getFullName());

    ClassInfo[] classes = packageInfo.getClasses();
    transmitInt(classes.length);

    for (int i = 0; i < classes.length; i++)
    {
      ClassInfo classInfo = classes[i];
      if (isDebugEnabled()) debug("Describing class " + classInfo.getFullName());

      transmitString(classInfo.getFullName());
      transmitString(classInfo.getParent() == null ? null : classInfo.getParent().getFullName());
      transmitString(classInfo.getMapping().getTableName());
      transmitAttributes(classInfo);
    }
  }

  public Object confirm()
  {
    int count = receiveInt();

    if (count >= 0)
    {
      handlePackageResponse(count);
      return Boolean.TRUE;
    }
    else
    {
      if (isDebugEnabled()) debug("Unknown package " + packageInfo.getFullName());
      return Boolean.FALSE;
    }
  }

  private void transmitAttributes(ClassInfo classInfo)
  {
    AttributeInfo[] attributes = classInfo.getAttributeInfos();
    transmitInt(attributes.length);

    for (int j = 0; j < attributes.length; j++)
    {
      AttributeInfo attributeInfo = attributes[j];
      if (isDebugEnabled()) debug("Describing attribute " + attributeInfo.getName());

      transmitString(attributeInfo.getName());
      transmitInt(attributeInfo.getEAttribute().getFeatureID());
      transmitInt(attributeInfo.getDataType());
      transmitString(attributeInfo.getMapping().getColumnName());
      transmitInt(attributeInfo.getMapping().getColumnType());
      // TODO Handle column length, precision, ...
    }
  }
}
