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
package org.eclipse.net4j.examples.mvc.aspect;


public interface IRecordModelAspect
{
  public int getFieldCount();

  public String[] getFieldNames();

  public Class getFieldType(String fieldName);

  public Object getValue(String fieldName);

  public void setValue(String fieldName, Object value);

  public Object onVerify(String fieldName, Object newValue);

  public void onSet(String fieldName, Object newValue, Object oldValue);

  public void onAdd(String fieldName, Object item);

  public void onRemove(String fieldName, Object item);

  public void onAdd(String fieldName, Object item, int index);

  public void onRemove(String fieldName, Object item, int index);

  public void onMove(String fieldName, int fromIndex, int toIndex);

  public void onAdd(String fieldName, Object key, Object value);

  public void onRemove(String fieldName, Object key, Object value);
}
