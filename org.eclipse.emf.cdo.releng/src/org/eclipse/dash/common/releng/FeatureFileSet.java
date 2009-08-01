package org.eclipse.dash.common.releng;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.FileSet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Eike Stepper
 */
public class FeatureFileSet extends FileSet
{
  private String featureID;

  private transient boolean isPopulated;

  public FeatureFileSet()
  {
  }

  protected FeatureFileSet(FeatureFileSet s)
  {
    super(s);
    featureID = s.featureID;
  }

  public String getFeatureID()
  {
    return getFeatureID(getProject());
  }

  public synchronized String getFeatureID(Project p)
  {
    return isReference() ? ((FeatureFileSet)getRef(p)).getFeatureID(p) : featureID;
  }

  public synchronized void setFeatureID(String featureID) throws BuildException
  {
    if (isReference())
    {
      throw tooManyAttributes();
    }

    this.featureID = featureID;
  }

  public Object clone()
  {
    return new FeatureFileSet(isReference() ? (FeatureFileSet)getRef(getProject()) : this);
  }

  public DirectoryScanner getDirectoryScanner(Project p)
  {
    synchronized (this)
    {
      if (!isPopulated)
      {
        populate(p);
        isPopulated = true;
      }
    }

    return super.getDirectoryScanner(p);
  }

  private void populate(Project p)
  {
    String featureID = getFeatureID(p);
    File dir = getDir(p);
    p.log(" ");
    p.log("Populating " + featureID);
    p.log("From " + dir);
    p.log(" ");

    File[] features = getComponents(dir, "features");
    File[] plugins = getComponents(dir, "plugins");

    File rootFeature = getComponent(features, featureID, null);
    Set includes = new HashSet();
    calculateIncludes(p, features, plugins, rootFeature, includes);

    p.log(" ");
    log(p, "Includes ", includes);
    p.log(" ");

    appendExcludes(p, features, includes);
    appendExcludes(p, plugins, includes);
  }

  private File[] getComponents(File dir, String path)
  {
    return new File(dir, path).listFiles();
  }

  private File getComponent(File[] components, String id, String version)
  {
    File result = null;
    String prefix = id + "_";
    if (version != null)
    {
      prefix += version;
    }

    for (int i = 0; i < components.length; i++)
    {
      File component = components[i];
      if (component.getName().startsWith(prefix))
      {
        if (result != null)
        {
          throw new BuildException("Duplicate component: " + id);
        }

        result = component;
      }
    }

    if (result == null)
    {
      throw new BuildException("Component not found: " + id);
    }

    return result;
  }

  private void calculateIncludes(Project p, File[] features, File[] plugins, File feature, Set includes)
  {
    if (includes.contains(feature))
    {
      return;
    }

    p.log("Scanning " + feature);
    includes.add(feature);
    InputStream stream = null;

    try
    {
      stream = getFeatureStream(feature);

      Element topElement = loadXmlElement(stream);

      includes.addAll(caluculateIncludes(plugins, topElement.getElementsByTagName("plugin")));

      List featureIncludes = caluculateIncludes(features, topElement.getElementsByTagName("includes"));
      for (Iterator it = featureIncludes.iterator(); it.hasNext();)
      {
        File featureToInclude = (File)it.next();
        calculateIncludes(p, features, plugins, featureToInclude, includes);
      }
    }
    catch (Exception ex)
    {
      throw new BuildException(ex);
    }
    finally
    {
      if (stream != null)
      {
        try
        {
          stream.close();
        }
        catch (IOException ex)
        {
          p.log("", ex, Project.MSG_DEBUG);
        }
      }
    }

  }

  private List caluculateIncludes(File[] components, NodeList componentNodes)
  {
    List result = new ArrayList();
    for (int i = 0; i < componentNodes.getLength(); i++)
    {
      Node node = componentNodes.item(i);
      NamedNodeMap attributes = node.getAttributes();
      String id = attributes.getNamedItem("id").getNodeValue();
      String version = attributes.getNamedItem("version").getNodeValue();

      File component = getComponent(components, id, version);
      result.add(component);
    }

    return result;
  }

  private InputStream getFeatureStream(File feature) throws IOException
  {
    if (feature.isDirectory())
    {
      return new FileInputStream(new File(feature, "feature.xml"));
    }

    return new URL("jar:file://" + feature + "!/feature.xml").openStream();
  }

  private Element loadXmlElement(InputStream stream) throws ParserConfigurationException, SAXException, IOException
  {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setValidating(false);
    factory.setNamespaceAware(false);

    Document document = factory.newDocumentBuilder().parse(stream);
    return document.getDocumentElement();
  }

  private void appendExcludes(Project p, File[] components, Set includes)
  {
    for (int i = 0; i < components.length; i++)
    {
      File component = components[i];
      if (!includes.contains(component))
      {
        String exclude = component.getParentFile().getName() + "/" + component.getName();
        if (component.isDirectory())
        {
          exclude += "/**";
        }

        // p.log("Excludes " + exclude);
        appendExcludes(new String[] { exclude });
      }
    }
  }

  private void log(Project p, String prefix, Collection collection)
  {
    List sorted = collection instanceof List ? (List)collection : new ArrayList(collection);
    Collections.sort(sorted);

    for (Iterator it = sorted.iterator(); it.hasNext();)
    {
      Object object = it.next();
      p.log(prefix + object);
    }
  }
}
