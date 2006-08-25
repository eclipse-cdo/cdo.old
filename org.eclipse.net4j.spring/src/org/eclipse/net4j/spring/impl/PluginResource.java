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
package org.eclipse.net4j.spring.impl;


import org.springframework.core.io.FileSystemResource;

import java.io.File;


public class PluginResource extends FileSystemResource
{
  /**
   * @param file
   */
  public PluginResource(File file)
  {
    super(file);
  }

  /**
   * @param path
   */
  public PluginResource(String path)
  {
    super(path);
  }
}
