/*
 * Copyright (c) 2008-2012, 2015, 2016 Eike Stepper (Loehne, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Martin Taal - copied from CDORevisionPropertyHandler and adapted
 *    Eike Stepper - maintenance
 */
package org.eclipse.emf.cdo.server.internal.hibernate.tuplizer;

import org.eclipse.emf.cdo.common.revision.CDORevisionData;
import org.eclipse.emf.cdo.server.internal.hibernate.tuplizer.CDORevisionPropertyAccessor.CDORevisionSetter;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDORevision;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.teneo.PersistenceOptions;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.property.Setter;

import java.lang.reflect.Method;

/**
 * TODO How does this differ from {@link CDORevisionSetter}? Both needed?
 *
 * @author Martin Taal
 */
public class CDOPropertySetter extends CDOPropertyHandler implements Setter
{
  private static final long serialVersionUID = 1L;

  private final boolean convertByteArray;

  private boolean handleUnsetAsNull = false;

  public CDOPropertySetter(CDORevisionTuplizer tuplizer, String propertyName)
  {
    super(tuplizer, propertyName);

    // handle a special case CDO/EMF expect a byte[] but Hibernate
    // will return a Byte[]
    final EStructuralFeature eFeature = getEStructuralFeature();
    if (eFeature instanceof EAttribute)
    {
      final EAttribute eAttribute = (EAttribute)eFeature;
      if (eAttribute.getEAttributeType().getInstanceClass() != null && byte[].class.isAssignableFrom(eAttribute.getEAttributeType().getInstanceClass()))
      {
        convertByteArray = true;
      }
      else
      {
        convertByteArray = false;
      }
    }
    else
    {
      convertByteArray = false;
    }
  }

  public Method getMethod()
  {
    return null;
  }

  public String getMethodName()
  {
    return null;
  }

  public void set(Object target, Object value, SessionFactoryImplementor factory) throws HibernateException
  {
    InternalCDORevision revision = (InternalCDORevision)target;

    final EStructuralFeature eFeature = getEStructuralFeature();
    final Object defaultValue = eFeature.getDefaultValue();

    // handle a special case: the byte array.
    // hibernate will pass a Byte[] while CDO wants a byte[] (object vs. primitive array)
    final Object newValue;
    if (value instanceof Byte[] && convertByteArray)
    {
      final Byte[] objectArray = (Byte[])value;
      final byte[] newByteValue = new byte[objectArray.length];
      int i = 0;
      for (byte b : objectArray)
      {
        newByteValue[i++] = b;
      }
      newValue = newByteValue;
    }
    else
    {
      // hibernate sees enums, cdo sees int's
      if (value instanceof Enumerator)
      {
        newValue = ((Enumerator)value).getValue();
      }
      else if (value instanceof EEnumLiteral)
      {
        newValue = ((EEnumLiteral)value).getValue();
      }
      else if (value == null)
      {
        if (defaultValue == null)
        {
          newValue = null;
        }
        else if (!handleUnsetAsNull && eFeature.isUnsettable())
        {
          // there was a default value so was explicitly set to null
          // otherwise the default value would be in the db
          newValue = CDORevisionData.NIL;
        }
        else
        {
          newValue = null;
        }
      }
      else
      {
        newValue = value;
      }
    }
    final Object currentValue = revision.getValue(eFeature);
    // do a simpler change check for ismany
    if (eFeature.isMany())
    {
      if (currentValue != newValue)
      {
        revision.setValue(eFeature, newValue);
      }
    }
    else
    {
      boolean overwriteNilOrNull = currentValue == CDORevisionData.NIL && newValue == null
          || currentValue == null && newValue != null && newValue.equals(defaultValue);
      if (!revision.isFrozen() && !overwriteNilOrNull)
      {
        revision.setValue(getEStructuralFeature(), newValue);
      }
    }
  }

  @Override
  public void setPersistenceOptions(PersistenceOptions persistenceOptions)
  {
    super.setPersistenceOptions(persistenceOptions);
    handleUnsetAsNull = persistenceOptions.getHandleUnsetAsNull();
  }

}
