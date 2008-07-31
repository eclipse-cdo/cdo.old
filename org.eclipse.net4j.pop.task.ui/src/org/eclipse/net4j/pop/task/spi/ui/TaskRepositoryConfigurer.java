/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.pop.task.spi.ui;

import org.eclipse.net4j.pop.task.internal.ui.bundle.OM;
import org.eclipse.net4j.pop.task.ui.ITaskRepositoryConfigurer;
import org.eclipse.net4j.util.ObjectUtil;
import org.eclipse.net4j.util.StringUtil;
import org.eclipse.net4j.util.lifecycle.Lifecycle;
import org.eclipse.net4j.util.ui.UIUtil;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public abstract class TaskRepositoryConfigurer extends PlatformObject implements ITaskRepositoryConfigurer
{
  private String name;

  protected TaskRepositoryConfigurer(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }

  public int compareTo(ITaskRepositoryConfigurer o)
  {
    return StringUtil.compare(name, o.getName());
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj == this)
    {
      return true;
    }

    if (obj instanceof ITaskRepositoryConfigurer)
    {
      ITaskRepositoryConfigurer that = (ITaskRepositoryConfigurer)obj;
      return ObjectUtil.equals(name, that.getName());
    }

    return false;
  }

  @Override
  public int hashCode()
  {
    return ObjectUtil.hashCode(name);
  }

  @Override
  public String toString()
  {
    return name;
  }

  protected void controlChanged()
  {
  }

  protected Text addField(Composite parent, String label, String value)
  {
    new Label(parent, SWT.NONE).setText(label);
    Text text = new Text(parent, SWT.BORDER);
    text.setText(StringUtil.safe(value));
    text.setLayoutData(UIUtil.createGridData(true, false));
    text.addModifyListener(new ModifyListener()
    {
      public void modifyText(ModifyEvent e)
      {
        controlChanged();
      }
    });

    return text;
  }

  /**
   * @author Eike Stepper
   */
  public static class Registry extends Lifecycle
  {
    public static final Registry INSTANCE = new Registry();

    private Map<String, ITaskRepositoryConfigurer> configurers = new HashMap<String, ITaskRepositoryConfigurer>();

    private Registry()
    {
    }

    public Map<String, ITaskRepositoryConfigurer> getConfigurers()
    {
      checkActive();
      return configurers;
    }

    @Override
    protected void doActivate() throws Exception
    {
      super.doActivate();
      initConfigurers();
    }

    @Override
    protected void doDeactivate() throws Exception
    {
      configurers.clear();
      super.doDeactivate();
    }

    private void initConfigurers()
    {
      IExtensionRegistry registry = Platform.getExtensionRegistry();
      IConfigurationElement[] elements = registry.getConfigurationElementsFor(OM.BUNDLE_ID, "repositoryConfigurers");
      for (IConfigurationElement element : elements)
      {
        try
        {
          ITaskRepositoryConfigurer configurer = (ITaskRepositoryConfigurer)element.createExecutableExtension("class");
          configurers.put(configurer.getName(), configurer);
        }
        catch (Exception ex)
        {
          OM.LOG.error(ex);
        }
      }
    }
  }
}
