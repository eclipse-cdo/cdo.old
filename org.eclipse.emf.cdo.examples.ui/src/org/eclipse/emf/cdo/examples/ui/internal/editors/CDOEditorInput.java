package org.eclipse.emf.cdo.example.ui.internal.editors;


import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.cdo.client.ResourceInfo;
import org.eclipse.emf.cdo.example.ui.internal.ExampleUIActivator;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;


public final class CDOEditorInput implements IEditorInput
{
  private ResourceInfo resourceInfo;

  public CDOEditorInput(ResourceInfo resourceInfo)
  {
    this.resourceInfo = resourceInfo;
  }

  public ResourceInfo getResourceInfo()
  {
    return resourceInfo;
  }

  public boolean exists()
  {
    return resourceInfo.isExisting();
  }

  public String getResourceURI()
  {
    //int rid = resourceInfo.getRid();
    //return "cdo://" + (rid != 0 ? Integer.toString(rid) : resourceInfo.getPath());
    return "cdo://" + resourceInfo.getPath();
  }

  public ImageDescriptor getImageDescriptor()
  {
    return getImageDescriptor("full/obj16/CDOResource");
  }

  public String getName()
  {
    String path = resourceInfo.getPath();
    if (path != null)
    {
      return path;
    }

    int rid = resourceInfo.getRid();
    return Integer.toString(rid);
  }

  public IPersistableElement getPersistable()
  {
    return null;
  }

  public String getToolTipText()
  {
    return "CDO Resource " + getName();
  }

  public Object getAdapter(Class adapterType)
  {
    return Platform.getAdapterManager().getAdapter(this, adapterType);
  }

  private static ImageDescriptor getImageDescriptor(String key)
  {
    Object image = ExampleUIActivator.getPlugin().getImage(key);
    return ExtendedImageRegistry.getInstance().getImageDescriptor(image);
  }
}
