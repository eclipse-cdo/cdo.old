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
package org.eclipse.emf.cdo.client.impl;


import org.eclipse.emf.cdo.client.AttributeConverter;
import org.eclipse.emf.cdo.client.AttributeInfo;
import org.eclipse.emf.cdo.client.ClassInfo;
import org.eclipse.emf.cdo.client.PackageManager;
import org.eclipse.emf.cdo.mapping.AttributeMapping;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;


public class AttributeInfoImpl implements AttributeInfo
{
  private ClassInfo classInfo;

  private transient EAttribute attribute;

  private transient int dataType;

  private transient AttributeMapping mapping;

  /**
   * @param attribute
   * @param mapping
   */
  public AttributeInfoImpl(EAttribute attribute, AttributeMapping mapping, ClassInfo classInfo)
  {
    this.attribute = attribute;
    this.mapping = mapping;
    this.classInfo = classInfo;

    initDataType();
  }

  public String toString()
  {
    return getName();
  }

  public String getName()
  {
    return attribute.getName();
  }

  public EAttribute getEAttribute()
  {
    return attribute;
  }

  public AttributeMapping getMapping()
  {
    return mapping;
  }

  public int getDataType()
  {
    return dataType;
  }

  private void initDataType()
  {
    EDataType attributeType = attribute.getEAttributeType();
    PackageManager packageManager = getClassInfo().getPackageInfo().getPackageManager();
    AttributeConverter converter = packageManager.getAttributeConverter();
    dataType = converter.getCDODataType(attributeType);
  }

  public ClassInfo getClassInfo()
  {
    return classInfo;
  }
}
