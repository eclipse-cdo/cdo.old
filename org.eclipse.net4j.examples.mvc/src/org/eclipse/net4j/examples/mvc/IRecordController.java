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
package org.eclipse.net4j.examples.mvc;


public interface IRecordController<RECORD_TARGET, VIEW_TARGET> extends IController<Object>
{
  public RECORD_TARGET getRecordTarget();

  public RECORD_TARGET setRecordTarget(RECORD_TARGET target);

  public void addTextBridge(String textTargetName, String fieldName);

  public void addSelectionBridge(String selectionTargetName, String fieldName);

  public void enableView(boolean on);

  public void clearView();

  public void loadView();

  public void saveView();

  public boolean isDirty();

  public void setDirty(boolean on);

  public boolean isTransient();

  public void setTransient(boolean on);
}
