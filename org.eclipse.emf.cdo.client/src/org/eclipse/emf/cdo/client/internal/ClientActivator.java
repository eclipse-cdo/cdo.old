/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.cdo.client.internal;


import org.eclipse.net4j.util.eclipse.Element;
import org.eclipse.net4j.util.eclipse.ExtensionParser;
import org.eclipse.net4j.util.eclipse.ListExtensionParser;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;

import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import org.osgi.framework.BundleContext;

import java.util.ArrayList;
import java.util.List;


/**
 * This is the central singleton for the Cdo edit plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class ClientActivator extends EMFPlugin
{
  /**
   * @ADDED
   */
  public static final String EXTENSION_POINT_ID = "mappings";

  /**
   * @ADDED
   */
  public static final String PLUGIN_ID = "org.eclipse.emf.cdo.client";

  /**
   * Keep track of the singleton.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final ClientActivator INSTANCE = new ClientActivator();

  /**
   * Keep track of the singleton.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static Implementation plugin;

  /**
   * Create the instance.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public ClientActivator()
  {
    super(new ResourceLocator[] { EcoreEditPlugin.INSTANCE});
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
    /**
     * @ADDED
     */
    private List mappingElements = new ArrayList();

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
      ExtensionParser mappingParser = new MappingExtensionParser(mappingElements);

      IExtensionRegistry registry = Platform.getExtensionRegistry();
      IExtensionPoint point = registry.getExtensionPoint(PLUGIN_ID + "." + EXTENSION_POINT_ID);
      mappingParser.parse(point);
    }

    @Override
    public void stop(BundleContext context) throws Exception
    {
      mappingElements = null;
      plugin = null;
      super.stop(context);
    }

    /**
     * @ADDED
     */
    public List getMappingElements()
    {
      return mappingElements;
    }
  }


  /**
   * @ADDED
   */
  public static class MappingElement extends Element
  {
    protected String uri;

    protected String map;

    public String getMap()
    {
      return map;
    }

    public void setMap(String map)
    {
      this.map = map;
    }

    public String getUri()
    {
      return uri;
    }

    public void setUri(String url)
    {
      this.uri = url;
    }

    public String toString()
    {
      return "Mapping(" + uri + ", " + map + ")";
    }
  }


  /**
   * @ADDED
   */
  public static class MappingExtensionParser extends ListExtensionParser
  {
    public MappingExtensionParser(List list)
    {
      super(list);

      addFactory("mapping", new Element.Factory()
      {
        public Element createElementData()
        {
          return new MappingElement();
        }
      });
    }
  }

}
