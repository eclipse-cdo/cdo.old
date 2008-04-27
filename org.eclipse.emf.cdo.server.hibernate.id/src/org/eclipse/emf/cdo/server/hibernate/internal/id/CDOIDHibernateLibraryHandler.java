package org.eclipse.emf.cdo.server.hibernate.internal.id;

import org.eclipse.emf.cdo.internal.protocol.id.CDOIDLibraryDescriptorImpl;
import org.eclipse.emf.cdo.protocol.id.CDOIDLibraryProvider;

import org.eclipse.net4j.util.io.IOUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Eike Stepper
 */
public final class CDOIDHibernateLibraryHandler extends CDOIDLibraryDescriptorImpl implements CDOIDLibraryProvider
{
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