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
package org.eclipse.net4j.examples.mvc.controller;


import org.eclipse.net4j.examples.mvc.IRecordController;
import org.eclipse.net4j.examples.mvc.IAdapter.Manager;
import org.eclipse.net4j.examples.mvc.binding.MetaDataBinding;


public class MetaDataSelectionSequenceController<SEQUENCE_TARGET, RECORD_TARGET, VIEW_TARGET>
        extends SelectionSequenceController<SEQUENCE_TARGET, RECORD_TARGET, VIEW_TARGET>
{
  public static final String FIELD_NAME_KEY = "fieldName";

  public static final String RECORD_ACTION_KEY = "recordAction";

  public static final String RECORD_ACTION_LOAD_VALUE = "load";

  public static final String RECORD_ACTION_SAVE_VALUE = "save";

  public static final String BRIDG_TYPE_KEY = "bridgeType";

  public static final String BRIDG_TYPE_TEXT_VALUE = "text";

  public static final String BRIDG_TYPE_SELECTION_VALUE = "selection";

  /**
   * 
   * @param adapterManager
   * @param name
   * @param sequenceModelTargetName
   * @param selectionViewTargetName
   * @param recordController
   */
  public MetaDataSelectionSequenceController(Manager<Object> adapterManager, String name,
          String sequenceModelTargetName, String selectionViewTargetName,
          IRecordController<RECORD_TARGET, VIEW_TARGET> recordController)
  {
    super(adapterManager, name, sequenceModelTargetName, selectionViewTargetName, recordController);
  }

  @Override
  public Object putTarget(String name, Object target)
  {
    new MetaDataBinding(this, name);
    Object oldTarget = super.putTarget(name, target);

    // IAdapter<VIEW_TARGET> adapter = metaDataBinding.getAdapter();
    // if (adapter != null)
    // {
    // Object fieldNameData = metaDataBinding.getMetaData(FIELD_NAME_KEY);
    // if (fieldNameData instanceof String)
    // {
    // Object bridgeTypeData = metaDataBinding.getMetaData(BRIDG_TYPE_KEY);
    // String bridgeType = bridgeTypeData instanceof String ? (String)bridgeTypeData : null;
    //
    // String fieldName = (String)fieldNameData;
    // if (BRIDG_TYPE_TEXT_VALUE.equals(bridgeType) || adapter.hasAspect(ITextViewAspect.class))
    // {
    // addTextBridge(name, fieldName);
    // }
    // else if (BRIDG_TYPE_SELECTION_VALUE.equals(bridgeType)
    // || metaDataBinding.getAdapter().hasAspect(ISelectionViewAspect.class))
    // {
    // addSelectionBridge(name, fieldName);
    // }
    // }
    //
    // Object recordActionData = metaDataBinding.getMetaData(RECORD_ACTION_KEY);
    // if (recordActionData instanceof String)
    // {
    // String recordAction = (String)recordActionData;
    //
    // if (adapter.hasAspect(ISelectionViewAspect.class))
    // {
    // if (RECORD_ACTION_LOAD_VALUE.equals(recordAction))
    // {
    // setLoadBinding(name);
    // }
    // else if (RECORD_ACTION_SAVE_VALUE.equals(recordAction))
    // {
    // setSaveBinding(name);
    // }
    // }
    // }
    // }

    return oldTarget;
  }
}
