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
package org.eclipse.net4j.pop.task.web.spi.ui;

import org.eclipse.net4j.pop.task.ITaskRepositoryConfiguration;
import org.eclipse.net4j.pop.task.spi.ui.TaskRepositoryConfigurer;
import org.eclipse.net4j.pop.task.spi.web.WebConfiguration;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

/**
 * @author Eike Stepper
 */
public class WebConfigurer extends TaskRepositoryConfigurer
{
  private WebConfiguration configuration;

  private Text urlText;

  private Text userNameText;

  private Text passwordText;

  protected WebConfigurer(String name)
  {
    super(name);
  }

  public Text getURLText()
  {
    return urlText;
  }

  public Text getUserNameText()
  {
    return userNameText;
  }

  public Text getPasswordText()
  {
    return passwordText;
  }

  public Control createControl(Composite parent, ITaskRepositoryConfiguration configuration)
  {
    this.configuration = (WebConfiguration)configuration;

    Composite composite = new Composite(parent, SWT.NONE);
    composite.setLayout(new GridLayout(2, false));

    urlText = addField(composite, "URL:", this.configuration.getUrl());
    userNameText = addField(composite, "User name:", this.configuration.getUserName());
    passwordText = addField(composite, "Password:", "");
    passwordText.setEchoChar('*');
    return composite;
  }

  @Override
  protected void controlChanged()
  {
    configuration.setUrl(urlText.getText());
    configuration.setUserName(userNameText.getText());
    configuration.setPassword(passwordText.getText());
  }
}
