package org.eclipse.net4j.tools.workingset.evaluation;

import org.eclipse.core.resources.IResource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class PropertyRegistry
{
  public static final PropertyRegistry INSTANCE = new PropertyRegistry();

  private Map<String, IAccessor> accessors = new HashMap<String, IAccessor>();

  private List<String> keys;

  private PropertyRegistry()
  {
    accessors.put("name", new IAccessor()
    {
      public String access(IResource resource)
      {
        return resource.getName();
      }
    });

    accessors.put("extension", new IAccessor()
    {
      public String access(IResource resource)
      {
        return resource.getFileExtension();
      }
    });

    accessors.put("path", new IAccessor()
    {
      public String access(IResource resource)
      {
        return resource.getFullPath().toPortableString();
      }
    });

    accessors.put("pathFromProject", new IAccessor()
    {
      public String access(IResource resource)
      {
        return resource.getProjectRelativePath().toPortableString();
      }
    });

    accessors.put("projectName", new IAccessor()
    {
      public String access(IResource resource)
      {
        return resource.getProject().getName();
      }
    });

    accessors.put("location", new IAccessor()
    {
      public String access(IResource resource)
      {
        return resource.getLocation().toPortableString();
      }
    });

    accessors.put("uri", new IAccessor()
    {
      public String access(IResource resource)
      {
        return resource.getLocationURI().toString();
      }
    });

    keys = new ArrayList<String>(accessors.keySet());
    Collections.sort(keys);

    // System.out.println();
    // System.out.println("Properties: ");
    // for (String key : keys)
    // {
    // System.out.println(key);
    // }
  }

  public List<String> getKeys()
  {
    return keys;
  }

  public Map<String, IAccessor> getAccessors()
  {
    return accessors;
  }

  public String access(IResource resource, String property)
  {
    IAccessor accessor = accessors.get(property);
    if (accessor == null)
    {
      throw new IllegalArgumentException("Unknown property " + property);
    }

    return accessor.access(resource);
  }

  /**
   * @author Eike Stepper
   */
  public static interface IAccessor
  {
    public String access(IResource resource);
  }
}
