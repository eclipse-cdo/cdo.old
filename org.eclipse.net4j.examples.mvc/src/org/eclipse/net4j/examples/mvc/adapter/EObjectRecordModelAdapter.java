/***************************************************************************
 * Copyright (c) 2004-2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.examples.mvc.adapter;


import org.eclipse.net4j.examples.mvc.IAdapter;
import org.eclipse.net4j.examples.mvc.aspect.IMetaDataAspect;
import org.eclipse.net4j.examples.mvc.aspect.IRecordModelAspect;
import org.eclipse.net4j.examples.mvc.util.NoTargetException;
import org.eclipse.net4j.examples.mvc.util.UnknownFieldException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class EObjectRecordModelAdapter extends AbstractRecordModelAdapter<EObject>
{
  // private static final Logger logger = Logger.getLogger(EObjectRecordModelAdapter.class);

  private String[] cachedFieldNames;

  private Adapter eAdapter = new AdapterImpl()
  {
    public void notifyChanged(Notification msg)
    {
      Object feature = msg.getFeature();

      if (feature instanceof EStructuralFeature)
      {
        String fieldName = ((EStructuralFeature)feature).getName();

        switch (msg.getEventType())
        {
        case Notification.SET:
        case Notification.UNSET:
          onSet(fieldName, msg.getNewValue(), msg.getOldValue());
          break;

        case Notification.ADD:
          onAdd(fieldName, msg.getOldValue(), msg.getPosition());
          break;

        case Notification.ADD_MANY:
          break;

        case Notification.REMOVE:
          onRemove(fieldName, msg.getOldValue(), msg.getPosition());
          break;

        case Notification.REMOVE_MANY:
          break;

        case Notification.MOVE:
          onMove(fieldName, msg.getOldIntValue(), msg.getPosition());
          break;
        }
      }
      msg.getOldValue();
      msg.getNewValue();

    }
  };

  public EObjectRecordModelAdapter(Factory factory)
  {
    super(factory);
  }

  public int getFieldCount() throws NoTargetException
  {
    return getFieldNames().length;
  }

  public String[] getFieldNames() throws NoTargetException
  {
    if (getTarget() == null)
    {
      throw new NoTargetException();
    }

    if (cachedFieldNames == null)
    {
      List<String> names = new ArrayList<String>();
      EList fields = getTarget().eClass().getEAllStructuralFeatures();

      for (Object field : fields)
      {
        EStructuralFeature feature = (EStructuralFeature)field;
        names.add(feature.getName());
      }

      cachedFieldNames = names.toArray(new String[fields.size()]);
    }

    return cachedFieldNames;
  }

  public Class getFieldType(String fieldName)
  {
    return getFeature(fieldName).getEType().getInstanceClass();
  }

  public Object[] getMetaDataKeys()
  {
    EList data = getTarget().eClass().getEAnnotations();
    Object[] result = new Object[data.size()];

    Iterator<EAnnotation> it = data.iterator();
    for (int i = 0; i < data.size(); i++)
    {
      EAnnotation annotation = it.next();
      result[i] = annotation.getSource();
    }

    return result;
  }

  public Object getMetaData(Object key)
  {
    return getTarget().eClass().getEAnnotation((String)key);
  }

  public Object getValue(String fieldName)
  {
    if (getTarget() == null)
    {
      throw new NoTargetException();
    }

    return getTarget().eGet(getFeature(fieldName));
  }

  public void setValue(String fieldName, Object value)
  {
    Object oldValue = getValue(fieldName);
    Object newValue = onVerify(fieldName, value);

    if (newValue == oldValue)
    {
      return;
    }

    getTarget().eSet(getFeature(fieldName), newValue);
  }

  @Override
  protected void onRetarget()
  {
    cachedFieldNames = null;
  }

  @Override
  protected void connectTarget(Class aspect)
  {
    if (aspect == IRecordModelAspect.class)
    {
      getTarget().eAdapters().add(eAdapter);
    }
  }

  @Override
  protected void disconnectTarget(Class aspect)
  {
    if (aspect == IRecordModelAspect.class)
    {
      getTarget().eAdapters().remove(eAdapter);
    }
  }

  private EStructuralFeature getFeature(String fieldName)
  {
    if (getTarget() == null)
    {
      throw new NoTargetException();
    }

    EStructuralFeature feature = getTarget().eClass().getEStructuralFeature(fieldName);

    if (feature == null)
    {
      throw new UnknownFieldException(fieldName);
    }

    return feature;
  }

  public static class Factory extends AbstractFactory<EObject>
  {
    private static final Class[] ASPECTS = {IMetaDataAspect.class, IRecordModelAspect.class};

    private static final Class[] ADAPTABLE_CLASSES = {EObject.class};

    public IAdapter<EObject> createAdapter()
    {
      return new EObjectRecordModelAdapter(this);
    }

    public Class[] getAspects()
    {
      return ASPECTS;
    }

    public Class[] getAdaptableClasses()
    {
      return ADAPTABLE_CLASSES;
    }
  }
}
