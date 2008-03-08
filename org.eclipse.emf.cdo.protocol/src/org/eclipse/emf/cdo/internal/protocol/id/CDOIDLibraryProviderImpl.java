package org.eclipse.emf.cdo.internal.protocol.id;

import org.eclipse.emf.cdo.protocol.id.CDOIDLibraryDescriptor;
import org.eclipse.emf.cdo.protocol.id.CDOIDLibraryProvider;

import org.eclipse.net4j.util.io.ExtendedDataInput;
import org.eclipse.net4j.util.io.IOUtil;
import org.eclipse.net4j.util.io.TMPUtil;
import org.eclipse.net4j.util.om.OMBundle;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Eike Stepper
 */
public class CDOIDLibraryProviderImpl implements CDOIDLibraryProvider
{
  private Map<String, OMBundle> bundles = new HashMap<String, OMBundle>();

  private File tmpFolder;

  public CDOIDLibraryProviderImpl()
  {
  }

  public void addLibrary(String libraryName, OMBundle bundle)
  {
    bundles.put(libraryName, bundle);
  }

  public String[] getLibraryNames()
  {
    Set<String> libraryNames = bundles.keySet();
    return libraryNames.toArray(new String[libraryNames.size()]);
  }

  public CDOIDLibraryDescriptor createDescriptor(String factoryName)
  {
    return new Descriptor(factoryName);
  }

  public InputStream getContents(String libraryName) throws IOException
  {
    File library = getLibrary(libraryName);
    return IOUtil.openInputStream(library);
  }

  public int getSize(String libraryName)
  {
    File library = getLibrary(libraryName);
    return (int)library.length();
  }

  private File getLibrary(String libraryName)
  {
    OMBundle bundle = bundles.get(libraryName);
    if (bundle == null)
    {
      throw new IllegalStateException("Unknown library: " + libraryName);
    }

    URL url = bundle.getBaseURL();
    return null;
  }

  private File getTempFolder()
  {
    if (tmpFolder == null)
    {
      tmpFolder = TMPUtil.createTempFolder();
    }

    return tmpFolder;
  }

  /**
   * @author Eike Stepper
   */
  private final class Descriptor extends CDOIDLibraryDescriptorImpl
  {
    public Descriptor(String factoryName)
    {
      super(factoryName, CDOIDLibraryProviderImpl.this.getLibraryNames());
    }

    public Descriptor(ExtendedDataInput in) throws IOException
    {
      super(in);
    }
  }
}
