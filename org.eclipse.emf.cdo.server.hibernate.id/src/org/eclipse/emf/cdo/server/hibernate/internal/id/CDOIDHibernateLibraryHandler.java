/**
 * Copyright (c) 2004 - 2009 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.emf.cdo.server.hibernate.internal.id;

import org.eclipse.emf.cdo.common.id.CDOIDLibraryProvider;
import org.eclipse.emf.cdo.spi.common.id.CDOIDLibraryDescriptorImpl;

import org.eclipse.net4j.util.io.IOUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Eike Stepper
 */
public final class CDOIDHibernateLibraryHandler extends CDOIDLibraryDescriptorImpl implements CDOIDLibraryProvider
{
  public static final String LIBRARY_NAME = "hibernate-id-v3.jar";

  CDOIDHibernateLibraryHandler()
  {
    super(CDOIDHibernateFactoryImpl.class.getName(), null);
  }

  public InputStream getContents(String libraryName) throws IOException
  {
    File library = getFile(libraryName);
    return IOUtil.openInputStream(library);
  }

  public int getSize(String libraryName)
  {
    File library = getFile(libraryName);
    return (int)library.length();
  }

  private File getFile(String libraryName)
  {
    return null;
  }
}
