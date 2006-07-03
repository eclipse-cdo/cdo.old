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
package org.eclipse.net4j.core.impl;


import org.eclipse.net4j.core.AuthenticationManager;
import org.eclipse.net4j.spring.ValidationException;
import org.eclipse.net4j.spring.impl.ServiceImpl;

import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesAuthenticationManagerImpl extends ServiceImpl implements
        AuthenticationManager
{
  protected String fileName;

  protected transient Properties properties; // Transient to prevent from logging

  /**
   * @return Returns the fileName.
   */
  public String getFileName()
  {
    return fileName;
  }

  /**
   * @param fileName
   *          The fileName to set.
   */
  public void setFileName(String fileName)
  {
    doSet("fileName", fileName);
  }

  public char[] getPassword(String userName)
  {
    if (userName == null)
    {
      throw new IllegalArgumentException("userName == null");
    }

    String pw = properties.getProperty(userName);

    if (pw == null)
    {
      return null;
    }

    return pw.toCharArray();
  }

  protected void validate() throws ValidationException
  {
    super.validate();
    assertNotNull("fileName");

    try
    {
      Resource resource = getContainer().getResource(fileName);
      InputStream stream = resource.getInputStream();
      properties = new Properties();
      properties.load(stream);
    }
    catch (IOException ex)
    {
      error("Error while reading file " + fileName, ex);
      throw new ValidationException("Error while loading credentials", ex);
    }
  }
}
