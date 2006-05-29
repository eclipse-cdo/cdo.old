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


import org.eclipse.net4j.util.ImplementationError;
import org.eclipse.net4j.util.StringHelper;

import org.eclipse.emf.cdo.client.AttributeConverter;
import org.eclipse.emf.cdo.client.MappingProvider;
import org.eclipse.emf.cdo.core.CDODataTypes;
import org.eclipse.emf.cdo.core.UnknownDataTypeException;
import org.eclipse.emf.cdo.mapping.AttributeMapping;
import org.eclipse.emf.cdo.mapping.ClassMapping;
import org.eclipse.emf.cdo.mapping.MappingFactory;
import org.eclipse.emf.cdo.mapping.PackageMapping;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import java.sql.Types;


public class AnnotationMappingProviderImpl implements MappingProvider, CDODataTypes
{
  public static final String ANNOTATION_SOURCE = "cdo";

  private static final String KEY_PERSISTENT = "persistent";

  private static final String KEY_TABLE_NAME = "tableName";

  private static final String KEY_COLUMN_NAME = "columnName";

  private static final String KEY_COLUMN_TYPE = "columnType";

  protected EPackage ePackage;

  protected PackageMapping mappingModel;

  protected boolean autoPersistent;

  protected AttributeConverter attributeConverter;

  public boolean getAutoPersistent()
  {
    return autoPersistent;
  }

  /**
   * @param ePackage
   */
  public AnnotationMappingProviderImpl(EPackage ePackage, boolean autoPersistent,
      AttributeConverter attributeConverter)
  {
    this.ePackage = ePackage;
    this.autoPersistent = autoPersistent;
    this.attributeConverter = attributeConverter;
    mappingModel = createPackageMapping();
  }

  public PackageMapping getPackageMapping()
  {
    return mappingModel;
  }

  public ClassMapping getClassMapping(String className)
  {
    try
    {
      EClass eClass = getEClass(className);
      ClassMapping result = createClassMapping(eClass, getAutoPersistent());
      return result;
    }
    catch (NoSuchElementException ex)
    {
      return null;
    }
  }

  public AttributeMapping getAttributeMapping(String className, String attributeName)
  {
    try
    {
      EAttribute eAttribute = getEAttribute(className, attributeName);
      AttributeMapping result = createAttributeMapping(eAttribute, getAutoPersistent());
      return result;
    }
    catch (NoSuchElementException ex)
    {
      return null;
    }
  }

  protected EClass getEClass(String className)
  {
    EClassifier result = ePackage.getEClassifier(className);
    if (result == null)
    {
      throw new NoSuchElementException("package " + ePackage.getName()
          + " does not contain classifier " + className);
    }

    if (result instanceof EClass)
    {
      return (EClass) result;
    }

    throw new NoSuchElementException("classifier " + className + " is not a class");
  }

  protected EAttribute getEAttribute(String className, String attributeName)
  {
    EClass eClass = getEClass(className);
    EStructuralFeature result = eClass.getEStructuralFeature(attributeName);
    if (result == null)
    {
      throw new NoSuchElementException("package " + ePackage.getName()
          + " does not contain attribute " + className + "." + attributeName);
    }

    if (result instanceof EAttribute)
    {
      return (EAttribute) result;
    }

    throw new NoSuchElementException("structural feature " + className + "." + attributeName
        + " is not an attribute");
  }

  protected AttributeMapping createAttributeMapping(EAttribute eAttribute,
      boolean autoPersistentToUse)
  {
    boolean persistent = getBooleanAnnotation(eAttribute, KEY_PERSISTENT, autoPersistentToUse);
    if (!persistent) return null;

    String attributeName = eAttribute.getName();

    String defaultColumnName = sqlIdentifier(attributeName);
    String columnName = getAnnotation(eAttribute, KEY_COLUMN_NAME, defaultColumnName);

    int defaultColumnType = getDefaultColumnType(eAttribute, attributeConverter);
    int columnType = getIntAnnotation(eAttribute, KEY_COLUMN_TYPE, defaultColumnType);

    AttributeMapping attributeMapping = MappingFactory.eINSTANCE.createAttributeMapping();
    attributeMapping.setAttributeName(attributeName);
    attributeMapping.setColumnName(columnName);
    attributeMapping.setColumnType(columnType);
    return attributeMapping;
  }

  protected ClassMapping createClassMapping(EClass eClass, boolean autoPersistentToUse)
  {
    boolean persistent = getBooleanAnnotation(eClass, KEY_PERSISTENT, autoPersistentToUse);
    if (!persistent) return null;

    String className = eClass.getName();
    String defaultTableName = sqlIdentifier(className);
    String tableName = getAnnotation(eClass, KEY_TABLE_NAME, defaultTableName);

    ClassMapping classMapping = MappingFactory.eINSTANCE.createClassMapping();
    classMapping.setClassName(className);
    classMapping.setTableName(tableName);

    //EList attributes = eClass.getEAttributes();
    EList attributes = eClass.getEAllAttributes(); // TODO is this how to get superClass attributes also..?
    for (Iterator<?> iter = attributes.iterator(); iter.hasNext();)
    {
      EAttribute attribute = (EAttribute) iter.next();
      AttributeMapping attributeMapping = createAttributeMapping(attribute, persistent);
      classMapping.getAttributes().add(attributeMapping);
    }

    return classMapping;
  }

  @SuppressWarnings("unchecked")
  protected PackageMapping createPackageMapping()
  {
    PackageMapping packageMapping = MappingFactory.eINSTANCE.createPackageMapping();
    packageMapping.setPackageName(ePackage.getName());

    EList classifiers = ePackage.getEClassifiers();
    for (Iterator<?> classifierIt = classifiers.iterator(); classifierIt.hasNext();)
    {
      EClassifier classifier = (EClassifier) classifierIt.next();
      if (classifier instanceof EClass)
      {
        EClass eClass = (EClass) classifier;
        ClassMapping classMapping = createClassMapping(eClass, autoPersistent);
        if (classMapping != null)
        {
          packageMapping.getClasses().add(classMapping);
        }
      }
    }
    return packageMapping;
  }

  public static String getAnnotation(EModelElement element, String key, String defaultValue)
  {
    EAnnotation annotation = element.getEAnnotation(ANNOTATION_SOURCE);
    if (annotation != null)
    {
      EMap details = annotation.getDetails();
      if (details != null)
      {
        String value = (String) details.get(key);
        return value == null ? defaultValue : value;
      }
    }
    return defaultValue;
  }

  public static boolean getBooleanAnnotation(EModelElement element, String key, boolean defaultValue)
  {
    String annotation = getAnnotation(element, key, defaultValue ? "true" : "false");

    if (annotation.equals("true"))
    {
      return true;
    }
    else if (annotation.equals("false"))
    {
      return false;
    }
    else
    {
      // TODO this should not be an ImplementationError 
      throw new ImplementationError("the value of " + ANNOTATION_SOURCE + "." + key
          + " should be 'false' or 'true'");
    }
  }

  public static int getIntAnnotation(EModelElement element, String key, int defaultValue)
  {
    String annotation = getAnnotation(element, key, Integer.toString(defaultValue));
    return Integer.parseInt(annotation);
  }

  public static String columnName(EAttribute attribute)
  {
    String name = attribute.getName();
    return sqlIdentifier(name);
  }

  public static String sqlIdentifier(String name)
  {
    StringBuffer result = new StringBuffer();
    List<String> parsedName = StringHelper.parseName(name, '_');

    for (Iterator<String> nameIter = parsedName.iterator(); nameIter.hasNext();)
    {
      String nameComponent = nameIter.next();
      result.append(nameComponent);

      if (nameIter.hasNext() && nameComponent.length() > 1)
      {
        result.append('_');
      }
    }

    return result.toString().toUpperCase();
  }

  public static String tableName(EClass eClass)
  {
    String name = eClass.getName();
    return sqlIdentifier(name);
  }

  /**
   * @param attribute
   * @return
   */
  public static int getDefaultColumnType(EAttribute attribute, AttributeConverter attributeConverter)
  {
    int dataType = attributeConverter.getCDODataType(attribute.getEAttributeType());

    switch (dataType)
    {
      case BOOLEAN:
      case BOOLEAN_OBJECT:
        return Types.BOOLEAN;
      case CHAR:
      case CHAR_OBJECT:
        return Types.CHAR;
      case BYTE:
      case BYTE_OBJECT:
        return Types.TINYINT;
      case SHORT:
      case SHORT_OBJECT:
        return Types.SMALLINT;
      case INT:
      case INT_OBJECT:
        return Types.INTEGER;
      case LONG:
      case LONG_OBJECT:
        return Types.BIGINT;
      case FLOAT:
      case FLOAT_OBJECT:
        return Types.FLOAT;
      case DOUBLE:
      case DOUBLE_OBJECT:
        return Types.DOUBLE;
      case STRING:
        return Types.LONGVARCHAR;
      case USER_DEFINED:
        return Types.LONGVARCHAR;
      default:
        throw new UnknownDataTypeException("Can't handle type " + dataType);
    }
  }
}
