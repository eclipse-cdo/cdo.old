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


import org.eclipse.net4j.examples.mvc.IController;
import org.eclipse.net4j.examples.mvc.IRecordController;
import org.eclipse.net4j.examples.mvc.IAdapter.Manager;
import org.eclipse.net4j.examples.mvc.binding.EnablementViewBinding;
import org.eclipse.net4j.examples.mvc.binding.RecordModelBinding;
import org.eclipse.net4j.examples.mvc.binding.SelectionViewBinding;
import org.eclipse.net4j.examples.mvc.binding.TextViewBinding;

import java.util.HashMap;
import java.util.Map;


public class RecordController<RECORD_TARGET, VIEW_TARGET> extends Controller<Object> implements
        IRecordController<RECORD_TARGET, VIEW_TARGET>
{
  public static final String RECORD_TARGET_NAME = "record";

  private EnablementViewBinding<VIEW_TARGET> loadEnablementBinding;

  private SelectionViewBinding<VIEW_TARGET> loadSelectionBinding;

  private EnablementViewBinding<VIEW_TARGET> saveEnablementBinding;

  private SelectionViewBinding<VIEW_TARGET> saveSelectionBinding;

  private Map<String, AbstractRecordBridge<RECORD_TARGET>> bridges = new HashMap<String, AbstractRecordBridge<RECORD_TARGET>>();

  private boolean recordTransient;

  public RecordController(Manager<Object> adapterManager, String name)
  {
    super(adapterManager, name);
  }

  public RecordController(Manager<Object> adapterManager, String name, RECORD_TARGET recordTarget)
  {
    super(adapterManager, name);
    setRecordTarget(recordTarget);
  }

  public RECORD_TARGET getRecordTarget()
  {
    return (RECORD_TARGET)getTarget(RECORD_TARGET_NAME);
  }

  public RECORD_TARGET setRecordTarget(RECORD_TARGET target)
  {
    return (RECORD_TARGET)putTarget(RECORD_TARGET_NAME, target);
  }

  public EnablementViewBinding<VIEW_TARGET> getLoadEnablementBinding()
  {
    return loadEnablementBinding;
  }

  public EnablementViewBinding<VIEW_TARGET> getSaveEnablementBinding()
  {
    return saveEnablementBinding;
  }

  public SelectionViewBinding<VIEW_TARGET> getLoadSelectionBinding()
  {
    return loadSelectionBinding;
  }

  public void setLoadBinding(String loadTargetName)
  {
    loadEnablementBinding = new EnablementViewBinding<VIEW_TARGET>((IController)this,
            loadTargetName);

    loadSelectionBinding = new SelectionViewBinding<VIEW_TARGET>((IController)this, loadTargetName)
    {
      public boolean onSelection(Object item, int detail, int x, int y, int width, int height,
              int stateMask, boolean doit)
      {
        loadView();
        return true;
      }
    };
  }

  public SelectionViewBinding<VIEW_TARGET> getSaveSelectionBinding()
  {
    return saveSelectionBinding;
  }

  public void setSaveBinding(String saveTargetName)
  {
    saveEnablementBinding = new EnablementViewBinding<VIEW_TARGET>((IController)this,
            saveTargetName);

    saveSelectionBinding = new SelectionViewBinding<VIEW_TARGET>((IController)this, saveTargetName)
    {
      public boolean onSelection(Object item, int detail, int x, int y, int width, int height,
              int stateMask, boolean doit)
      {
        saveView();
        return true;
      }
    };
  }

  public void addTextBridge(String textTargetName, String fieldName)
  {
    AbstractRecordBridge<RECORD_TARGET> bridge = new TextRecordBridge<RECORD_TARGET, VIEW_TARGET>(
            this, RECORD_TARGET_NAME, fieldName, false, textTargetName);
    bridges.put(textTargetName, bridge);
  }

  public void addSelectionBridge(String selectionTargetName, String fieldName)
  {
    AbstractRecordBridge<RECORD_TARGET> bridge = new SelectionRecordBridge<RECORD_TARGET, VIEW_TARGET>(
            this, RECORD_TARGET_NAME, fieldName, false, selectionTargetName);
    bridges.put(selectionTargetName, bridge);
  }

  public boolean isDirty()
  {
    for (AbstractRecordBridge<RECORD_TARGET> bridge : bridges.values())
    {
      if (bridge.isDirty())
      {
        return true;
      }
    }

    return false;
  }

  public void setDirty(boolean on)
  {
    for (AbstractRecordBridge<RECORD_TARGET> bridge : bridges.values())
    {
      bridge.setDirty(on);
    }
  }

  public boolean isTransient()
  {
    return recordTransient;
  }

  public void setTransient(boolean on)
  {
    recordTransient = on;
  }

  public void enableView(boolean on)
  {
    for (AbstractRecordBridge<RECORD_TARGET> bridge : bridges.values())
    {
      bridge.enable(on);
    }
  }

  public void clearView()
  {
    for (AbstractRecordBridge<RECORD_TARGET> bridge : bridges.values())
    {
      bridge.clear();
    }

    updateEnablements();
  }

  public void loadView()
  {
    if (getRecordTarget() == null)
    {
      clearView();
      return;
    }

    for (AbstractRecordBridge<RECORD_TARGET> bridge : bridges.values())
    {
      bridge.load();
    }

    setTransient(false);
    updateEnablements();
  }

  public void saveView()
  {
    for (AbstractRecordBridge<RECORD_TARGET> bridge : bridges.values())
    {
      bridge.save();
    }

    setTransient(false);
    updateEnablements();
  }

  public void afterTargetsSet()
  {
    super.afterTargetsSet();
    loadView();
  }

  public abstract class AbstractRecordBridge<TARGET>
  {
    private String fieldName;

    private boolean autoSave;

    private boolean dirty = true;

    private RecordModelBinding<TARGET> recordBinding;

    private EnablementViewBinding<Object> enablementBinding;

    public AbstractRecordBridge(IController controller, String recordTargetName, String fieldName,
            boolean autoSync, String viewTargetName)
    {
      this.fieldName = fieldName;
      this.autoSave = autoSync;

      recordBinding = new RecordModelBinding(controller, recordTargetName)
      {
        public void onSet(String fieldName, Object newValue, Object oldValue)
        {
          if (fieldName.equals(getFieldName()))
          {
            doSync();
          }
        }

        public Object setTarget(Object target)
        {
          Object oldTarget = super.setTarget(target);

          if (target != oldTarget)
          {
            doSync();
          }

          return oldTarget;
        }

        private void doSync()
        {
          if (isAutoSave())
          {
            save();
            setDirty(false);
          }
          else
          {
            setDirty(true);
          }
        }
      };

      enablementBinding = new EnablementViewBinding<Object>(controller, viewTargetName);
    }

    public RecordModelBinding<TARGET> getRecordModelBinding()
    {
      return recordBinding;
    }

    public String getFieldName()
    {
      return fieldName;
    }

    public Class getFieldType()
    {
      return getRecordModelBinding().getFieldType(fieldName);
    }

    public boolean isAutoSave()
    {
      return autoSave;
    }

    public void setAutoSave(boolean recordAutoSync)
    {
      this.autoSave = recordAutoSync;
    }

    public boolean isDirty()
    {
      return dirty;
    }

    public void setDirty(boolean recordDirty)
    {
      if (this.dirty == recordDirty)
      {
        return;
      }

      this.dirty = recordDirty;
      updateEnablements();
    }

    protected abstract void clear();

    protected abstract void load();

    protected abstract void save();

    protected String fieldToString(Object value)
    {
      return value == null ? "" : value.toString();
    }

    protected Object fieldFromString(String text)
    {
      Class fieldType = getFieldType();

      if (fieldType == char.class)
      {
        return text.length() == 0 ? 0 : text.charAt(0);
      }
      else if (fieldType == boolean.class)
      {
        return "false".equals(text) ? false : true;
      }
      else if (fieldType == byte.class)
      {
        return Byte.parseByte(text);
      }
      else if (fieldType == short.class)
      {
        return Short.parseShort(text);
      }
      else if (fieldType == int.class)
      {
        return Integer.parseInt(text);
      }
      else if (fieldType == long.class)
      {
        return Long.parseLong(text);
      }
      else if (fieldType == float.class)
      {
        return Float.parseFloat(text);
      }
      else if (fieldType == double.class)
      {
        return Double.parseDouble(text);
      }
      else if (fieldType == String.class)
      {
        return text;
      }

      // TODO Consider an exception here
      return null;
    }

    protected int fieldToInteger(Object value)
    {
      Class fieldType = getFieldType();

      if (fieldType == char.class)
      {
        return ((Character)value).charValue();
      }
      else if (fieldType == boolean.class)
      {
        return ((Boolean)value).booleanValue() ? 1 : 0;
      }
      else if (fieldType == byte.class)
      {
        return ((Byte)value).byteValue();
      }
      else if (fieldType == short.class)
      {
        return ((Short)value).shortValue();
      }
      else if (fieldType == int.class)
      {
        return ((Integer)value).intValue();
      }
      else if (fieldType == long.class)
      {
        return (int)((Long)value).longValue();
      }
      else if (fieldType == float.class)
      {
        return (int)((Float)value).floatValue();
      }
      else if (fieldType == double.class)
      {
        return (int)((Double)value).doubleValue();
      }
      else if (fieldType == String.class)
      {
        return new Integer((String)value);
      }

      // TODO Consider an exception here
      return 0;
    }

    protected Object fieldFromInteger(int number)
    {
      Class fieldType = getFieldType();

      if (fieldType == char.class)
      {
        return new Character((char)number);
      }
      else if (fieldType == boolean.class)
      {
        return new Boolean(number != 0);
      }
      else if (fieldType == byte.class)
      {
        return new Byte((byte)number);
      }
      else if (fieldType == short.class)
      {
        return new Short((short)number);
      }
      else if (fieldType == int.class)
      {
        return new Integer(number);
      }
      else if (fieldType == long.class)
      {
        return new Long(number);
      }
      else if (fieldType == float.class)
      {
        return new Float(number);
      }
      else if (fieldType == double.class)
      {
        return new Double(number);
      }
      else if (fieldType == String.class)
      {
        return Integer.toString(number);
      }

      // TODO Consider an exception here
      return null;
    }

    protected void enable(boolean on)
    {
      getEnablementBinding().setEnabled(on);
    }

    public EnablementViewBinding<Object> getEnablementBinding()
    {
      return enablementBinding;
    }
  }

  public class TextRecordBridge<RECORD_TARGET2, TEXT_TARGET> extends
          AbstractRecordBridge<RECORD_TARGET2>
  {
    private TextViewBinding<TEXT_TARGET> textBinding;

    public TextRecordBridge(IController controller, String recordTargetName, String fieldName,
            boolean autoSync, String textTargetName)
    {
      super(controller, recordTargetName, fieldName, autoSync, textTargetName);

      textBinding = new TextViewBinding(controller, textTargetName)
      {
        public void onModify()
        {
          setDirty(true);

          if (isAutoSave())
          {
            save();
            setDirty(false);
          }
        }
      };
    }

    public TextViewBinding<TEXT_TARGET> getTextViewBinding()
    {
      return textBinding;
    }

    protected void clear()
    {
      getTextViewBinding().setText("");
      setDirty(false);
    }

    protected void load()
    {
      String value = fieldToString(getRecordModelBinding().getValue(getFieldName()));
      getTextViewBinding().setText(value);
      setDirty(false);
    }

    protected void save()
    {
      if (isDirty())
      {
        Object value = fieldFromString(getTextViewBinding().getText());
        getRecordModelBinding().setValue(getFieldName(), value);
        setDirty(false);
      }
    }
  }

  public class SelectionRecordBridge<RECORD_TARGET2, SELECTION_TARGET> extends
          AbstractRecordBridge<RECORD_TARGET2>
  {
    private SelectionViewBinding<SELECTION_TARGET> selectionViewBinding;

    public SelectionRecordBridge(IController controller, String recordTargetName, String fieldName,
            boolean autoSync, String selectionTargetName)
    {
      super(controller, recordTargetName, fieldName, autoSync, selectionTargetName);

      selectionViewBinding = new SelectionViewBinding(controller, selectionTargetName)
      {
        public boolean onSelection(Object item, int detail, int x, int y, int width, int height,
                int stateMask, boolean doit)
        {
          setDirty(true);

          if (isAutoSave())
          {
            save();
          }

          return true;
        }
      };
    }

    public SelectionViewBinding<SELECTION_TARGET> getSelectionViewBinding()
    {
      return selectionViewBinding;
    }

    protected void clear()
    {
      getSelectionViewBinding().setSelection(-1);
      setDirty(false);
    }

    protected void load()
    {
      int index;

      if (isIntegral())
      {
        index = fieldToInteger(getRecordModelBinding().getValue(getFieldName()));
      }
      else
      {
        String value = fieldToString(getRecordModelBinding().getValue(getFieldName()));
        index = getSelectionViewBinding().indexOf(value);
      }

      getSelectionViewBinding().setSelection(index);
      setDirty(false);
    }

    protected void save()
    {
      if (isDirty())
      {
        // TODO Distinguish non integral field types?
        Object value = fieldFromInteger(getSelectionViewBinding().getSelectionIndex());
        getRecordModelBinding().setValue(getFieldName(), value);
        setDirty(false);
      }
    }

    private boolean isIntegral()
    {
      Class fieldType = getFieldType();
      return fieldType == char.class || fieldType == boolean.class || fieldType == byte.class
              || fieldType == short.class || fieldType == int.class || fieldType == long.class;
    }
  }

  protected void updateEnablements()
  {
    boolean dirty = isDirty();

    if (loadEnablementBinding != null)
    {
      loadEnablementBinding.setEnabled(dirty && !isTransient());
    }

    if (saveEnablementBinding != null)
    {
      saveEnablementBinding.setEnabled(dirty);
    }
  }
}
