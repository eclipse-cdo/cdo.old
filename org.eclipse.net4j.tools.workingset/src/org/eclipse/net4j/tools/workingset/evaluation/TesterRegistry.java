package org.eclipse.net4j.tools.workingset.evaluation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.core.expressions.IPropertyTester;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import com.ibm.icu.util.StringTokenizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class TesterRegistry
{
  public static final TesterRegistry INSTANCE = new TesterRegistry();

  private Map<String, IConfigurationElement> testers;

  private List<String> keys;

  private TesterRegistry()
  {
  }

  public List<String> getKeys()
  {
    getTesters();
    return keys;
  }

  public Map<String, IConfigurationElement> getTesters()
  {
    if (testers == null)
    {
      testers = new HashMap<String, IConfigurationElement>();
      keys = new ArrayList<String>();

      IExtensionRegistry registry = Platform.getExtensionRegistry();
      IConfigurationElement[] elements = registry
          .getConfigurationElementsFor("org.eclipse.core.expressions.propertyTesters");
      for (IConfigurationElement element : elements)
      {
        try
        {
          String type = element.getAttribute("type").trim();
          if (isResourceRelevant(type))
          {
            String namespace = element.getAttribute("namespace").trim();
            String properties = element.getAttribute("properties");

            StringTokenizer tokenizer = new StringTokenizer(properties, ",");
            while (tokenizer.hasMoreTokens())
            {
              String key = namespace + "." + tokenizer.nextToken().trim();
              keys.add(key);
              testers.put(key, element);
            }
          }
        }
        catch (RuntimeException ex)
        {
          // Ignore
        }
      }

      Collections.sort(keys);
    }

    return testers;
  }

  private boolean isResourceRelevant(String type)
  {
    if (IResource.class.getName().equals(type))
    {
      return true;
    }

    if (IFile.class.getName().equals(type))
    {
      return true;
    }

    if (IContainer.class.getName().equals(type))
    {
      return true;
    }

    if (IFolder.class.getName().equals(type))
    {
      return true;
    }

    if (IProject.class.getName().equals(type))
    {
      return true;
    }

    if (IAdaptable.class.getName().equals(type))
    {
      return true;
    }

    return false;
  }

  public boolean test(Object receiver, String property, Object[] args, Object expected)
  {
    IConfigurationElement element = getTesters().get(property);
    if (element == null)
    {
      return false;
    }

    try
    {
      IPropertyTester tester = (IPropertyTester)element.createExecutableExtension("class");
      return tester.test(receiver, property, args, expected);
    }
    catch (Exception ex)
    {
      return false;
    }
  }

  public static String makeProperty(EList<String> segments)
  {
    StringBuilder builder = new StringBuilder();
    for (String segment : segments)
    {
      if (builder.length() != 0)
      {
        builder.append(".");
      }

      builder.append(segment);
    }

    return builder.toString();
  }
}
