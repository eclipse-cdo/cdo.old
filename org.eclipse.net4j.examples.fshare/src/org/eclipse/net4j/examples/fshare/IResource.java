/**
 * Copyright (c) 2004 - 2010 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *
 *  Initial Publication:
 *    Eclipse Magazin - http://www.eclipse-magazin.de
 */
package org.eclipse.net4j.examples.fshare;

/**
 * @author Eike Stepper
 */
public interface IResource
{
  public IClient getClient();

  public IFolder getParent();

  public String getName();

  public String getPath();

  public int getSize();

  public int getUploaded();

  public int getUploadedPercent();
}
