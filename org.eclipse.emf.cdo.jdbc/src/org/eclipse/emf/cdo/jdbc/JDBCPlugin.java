/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.jdbc;


import org.eclipse.net4j.util.eclipse.AbstractPlugin;
import org.eclipse.net4j.util.eclipse.Element;
import org.eclipse.net4j.util.eclipse.ExecutableElement;
import org.eclipse.net4j.util.eclipse.ExtensionParser;
import org.eclipse.net4j.util.eclipse.ListExtensionParser;

import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import org.osgi.framework.Bundle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.net.URL;


/**
 * The main plugin class to be used in the desktop.
 */
public class JDBCPlugin extends AbstractPlugin
{
  public static final String PLUGIN_ID = "org.eclipse.emf.cdo.jdbc";

  public static final String DRIVERS_EXT_POINT_ID = "drivers";

  //The shared instance.
  private static JDBCPlugin plugin;

  private List<DriverElement> driverElements = new ArrayList<DriverElement>();

  private ExtensionParser driverParser = new DriverParser(driverElements);

  /**
   * The constructor.
   */
  public JDBCPlugin()
  {
    if (plugin == null) plugin = this;
  }

  /**
   * Returns the shared instance.
   */
  public static JDBCPlugin getDefault()
  {
    return plugin;
  }

  /**
   * @return Returns the driverElements.
   */
  public List<DriverElement> getDriverElements()
  {
    return driverElements;
  }

  /**
   * @param driverName
   * @return
   */
  public DriverElement getDriverElement(String driverName)
  {
    for (Iterator<DriverElement> it = getDriverElements().iterator(); it.hasNext();)
    {
      DriverElement driver = it.next();
      if (driver.getName().equals(driverName))
      {
        return driver;
      }
    }

    return null;
  }

  /**
   * @param driverName
   * @return
   */
  public String getDriverClassName(String driverName)
  {
    DriverElement driver = getDriverElement(driverName);
    return driver == null ? null : driver.getClassName();
  }

  /**
   * @param driverName
   * @return
   */
  public String getDriverExampleURL(String driverName)
  {
    DriverElement driver = getDriverElement(driverName);
    return driver == null ? "" : driver.getExampleURL();
  }

  /**
   * @param driverName
   * @return
   */
  public SupportedDialectElement[] getSupportedDialects(String driverName)
  {
    DriverElement driver = getDriverElement(driverName);
    return driver == null ? null : driver.getSupportedDialects();
  }

  protected void doStart() throws Exception
  {
    IExtensionRegistry registry = Platform.getExtensionRegistry();
    IExtensionPoint point = registry.getExtensionPoint(PLUGIN_ID + "." + DRIVERS_EXT_POINT_ID);
    driverParser.parse(point);
    checkLibraries();
  }

  protected void doStop() throws Exception
  {
    driverParser = null;
    driverElements = null;
    plugin = null;
  }

  @SuppressWarnings("deprecation")
  protected void checkLibraries()
  {
    for (DriverElement element : driverElements)
    {
      LibraryElement[] libraries = element.getLibraries();
      for (LibraryElement library : libraries)
      {
        String fragmentId = library.getFragmentId();
        Bundle bundle = Platform.getBundle(fragmentId);
        if (bundle != null)
        {
          String entryPath = library.getEntryPath();
          URL entry = bundle.getEntry(entryPath);
          if (entry == null)
          {
            String downloadURL = library.getDownloadURL();
            warn("MISSING JDBC LIBRARY: " + fragmentId + "/" + entryPath
                + (downloadURL != null ? " (" + downloadURL + ")" : ""));

          }
        }
      }
    }
  }


  public class DriverElement extends ExecutableElement
  {
    private String name;

    private String exampleURL;

    private List<SupportedDialectElement> supportedDialects = new ArrayList<SupportedDialectElement>();

    private List<LibraryElement> libraries = new ArrayList<LibraryElement>();

    public DriverElement()
    {
    }

    public String toString()
    {
      return "Driver(" + name + ", " + className + ")";
    }

    /**
     * @return Returns the entryPath.
     */
    public String getName()
    {
      return name;
    }

    /**
     * @param entryPath The entryPath to set.
     */
    public void setName(String name)
    {
      this.name = name;
    }

    public void addSupportedDialect(SupportedDialectElement dialect)
    {
      supportedDialects.add(dialect);
    }

    public SupportedDialectElement[] getSupportedDialects()
    {
      return supportedDialects.toArray(new SupportedDialectElement[supportedDialects.size()]);
    }

    public void addLibrary(LibraryElement library)
    {
      libraries.add(library);
    }

    public LibraryElement[] getLibraries()
    {
      return libraries.toArray(new LibraryElement[libraries.size()]);
    }

    /**
     * @return Returns the exampleURL.
     */
    public String getExampleURL()
    {
      return exampleURL;
    }

    /**
     * @param exampleURL The exampleURL to set.
     */
    public void setExampleURL(String exampleURL)
    {
      this.exampleURL = exampleURL;
    }
  }


  public class SupportedDialectElement extends Element
  {
    private String name;

    public SupportedDialectElement()
    {
    }

    public String toString()
    {
      return "SupportedDialect(" + name + ")";
    }

    /**
     * @return Returns the entryPath.
     */
    public String getName()
    {
      return name;
    }

    /**
     * @param entryPath The entryPath to set.
     */
    public void setName(String name)
    {
      this.name = name;
    }
  }


  public class LibraryElement extends Element
  {
    private String fragmentId;

    private String entryPath;

    private String downloadURL;

    public LibraryElement()
    {
    }

    public String toString()
    {
      return "LibraryElement(" + fragmentId + ", " + entryPath + ", " + downloadURL + ")";
    }

    public String getFragmentId()
    {
      return fragmentId;
    }

    public void setFragmentId(String fragmentId)
    {
      this.fragmentId = fragmentId;
    }

    public String getEntryPath()
    {
      return entryPath;
    }

    public void setEntryPath(String name)
    {
      this.entryPath = name;
    }

    public String getDownloadURL()
    {
      return downloadURL;
    }

    public void setDownloadURL(String downloadURL)
    {
      this.downloadURL = downloadURL;
    }
  }


  public class DriverParser extends ListExtensionParser
  {
    public DriverParser(List<DriverElement> list)
    {
      super(list);

      addFactory("driver", new Element.Factory()
      {
        public Element createElementData()
        {
          return new DriverElement();
        }
      });

      addFactory("driver/supportedDialect", new Element.Factory()
      {
        public Element createElementData()
        {
          return new SupportedDialectElement();
        }
      });

      addFactory("driver/library", new Element.Factory()
      {
        public Element createElementData()
        {
          return new LibraryElement();
        }
      });
    }
  }
}
