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
package org.eclipse.emf.cdo.dbgen.internal;


import org.eclipse.net4j.util.eclipse.Element;
import org.eclipse.net4j.util.eclipse.ExtensionParser;
import org.eclipse.net4j.util.eclipse.ListExtensionParser;

import org.eclipse.emf.cdo.dbgen.SQLDialect;
import org.eclipse.emf.cdo.dbgen.impl.SQLDialectImpl;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import org.osgi.framework.BundleContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * This is the central singleton for the DBGen model plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class DBGenActivator extends EMFPlugin
{
  /**
   * Keep track of the singleton.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final DBGenActivator INSTANCE = new DBGenActivator();

  public static final String DIALECTS_EXT_POINT_ID = "dialects";

  public static final String PLUGIN_ID = "org.eclipse.emf.cdo.dbgen";

  /**
   * Keep track of the singleton.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static Implementation plugin;

  private static List dialectElements = new ArrayList();

  /**
   * Create the instance.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DBGenActivator()
  {
    super(new ResourceLocator[] {});
  }

  /**
   * Returns the singleton instance of the Eclipse plugin.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the singleton instance.
   * @generated
   */
  public ResourceLocator getPluginResourceLocator()
  {
    return plugin;
  }

  public SQLDialect createDialect(String dialectName)
  {
    DialectElement element = getDialectElement(dialectName);
    return new SQLDialectImpl(element);
  }

  /**
   * @param dialectName
   * @return
   */
  public DialectElement getDialectElement(String dialectName)
  {
    for (Iterator it = getDialectElements().iterator(); it.hasNext();)
    {
      DialectElement element = (DialectElement) it.next();
      if (element.getName().equals(dialectName))
      {
        return element;
      }
    }

    return null;
  }

  /**
   * @return Returns the dialectElements.
   */
  public List getDialectElements()
  {
    return dialectElements;
  }

  /**
   * Returns the singleton instance of the Eclipse plugin.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the singleton instance.
   * @generated
   */
  public static Implementation getPlugin()
  {
    return plugin;
  }


  /**
   * The actual implementation of the Eclipse <b>Plugin</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static class Implementation extends EclipsePlugin
  {
    private ExtensionParser dialectParser = new DialectParser(dialectElements);

    /**
     * Creates an instance.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Implementation()
    {
      super();

      // Remember the static instance.
      //
      plugin = this;
    }

    @Override
    public void start(BundleContext context) throws Exception
    {
      super.start(context);
      IExtensionRegistry registry = Platform.getExtensionRegistry();
      IExtensionPoint point = registry.getExtensionPoint(PLUGIN_ID + "." + DIALECTS_EXT_POINT_ID);
      dialectParser.parse(point);
    }

    @Override
    public void stop(BundleContext context) throws Exception
    {
      dialectParser = null;
      dialectElements = null;
      plugin = null;
      super.stop(context);
    }
  }


  public static class DialectElement extends Element
  {
    private String name;

    private String dropTableTemplate;

    private String createTableTemplate;

    private String createTablePrimaryTemplate;

    private String createIndexTemplate;

    private String createUniqueIndexTemplate;

    private String createPrimaryIndexTemplate;

    private List typeMappings = new ArrayList();

    public DialectElement()
    {
    }

    public String toString()
    {
      return "Dialect(" + name + ")";
    }

    /**
     * @return Returns the name.
     */
    public String getName()
    {
      return name;
    }

    /**
     * @param name The name to set.
     */
    public void setName(String name)
    {
      this.name = name;
    }

    public String getCreateIndexTemplate()
    {
      return createIndexTemplate;
    }

    public void setCreateIndexTemplate(String createIndexTemplate)
    {
      this.createIndexTemplate = createIndexTemplate;
    }

    public String getCreatePrimaryIndexTemplate()
    {
      return createPrimaryIndexTemplate;
    }

    public void setCreatePrimaryIndexTemplate(String createPrimaryIndexTemplate)
    {
      this.createPrimaryIndexTemplate = createPrimaryIndexTemplate;
    }

    public String getCreateTablePrimaryTemplate()
    {
      return createTablePrimaryTemplate;
    }

    public void setCreateTablePrimaryTemplate(String createTablePrimaryTemplate)
    {
      this.createTablePrimaryTemplate = createTablePrimaryTemplate;
    }

    public String getCreateTableTemplate()
    {
      return createTableTemplate;
    }

    public void setCreateTableTemplate(String createTableTemplate)
    {
      this.createTableTemplate = createTableTemplate;
    }

    public String getCreateUniqueIndexTemplate()
    {
      return createUniqueIndexTemplate;
    }

    public void setCreateUniqueIndexTemplate(String createUniqueIndexTemplate)
    {
      this.createUniqueIndexTemplate = createUniqueIndexTemplate;
    }

    public String getDropTableTemplate()
    {
      return dropTableTemplate;
    }

    public void setDropTableTemplate(String dropTableTemplate)
    {
      this.dropTableTemplate = dropTableTemplate;
    }

    public void addTypeMapping(TypeMappingElement dialect)
    {
      typeMappings.add(dialect);
    }

    public TypeMappingElement[] getTypeMappings()
    {
      return (TypeMappingElement[]) typeMappings
          .toArray(new TypeMappingElement[typeMappings.size()]);
    }
  }


  public static class DialectParser extends ListExtensionParser
  {
    public DialectParser(List list)
    {
      super(list);

      addFactory("dialect", new Element.Factory()
      {
        public Element createElementData()
        {
          return new DialectElement();
        }
      });

      addFactory("dialect/typeMapping", new Element.Factory()
      {
        public Element createElementData()
        {
          return new TypeMappingElement();
        }
      });
    }
  }


  public static class TypeMappingElement extends Element
  {
    private String sqlType;

    private String vendorString;

    public TypeMappingElement()
    {
    }

    public String toString()
    {
      return "TypeMapping(" + sqlType + ", " + vendorString + ")";
    }

    public String getSqlType()
    {
      return sqlType;
    }

    public void setSqlType(String sqlType)
    {
      this.sqlType = sqlType;
    }

    public String getVendorString()
    {
      return vendorString;
    }

    public void setVendorString(String vendorString)
    {
      this.vendorString = vendorString;
    }
  }

}
