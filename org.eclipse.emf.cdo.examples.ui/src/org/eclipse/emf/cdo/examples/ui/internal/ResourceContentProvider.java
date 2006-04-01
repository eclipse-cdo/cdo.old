/**
 * 
 */
package org.eclipse.emf.cdo.example.ui.internal;


import org.eclipse.emf.cdo.client.ResourceInfo;
import org.eclipse.emf.cdo.example.client.ResourceCache;
import org.eclipse.emf.cdo.example.client.ResourceCache.Listener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;


public class ResourceContentProvider implements IStructuredContentProvider, Listener
{
  private ResourceCache resourceCache;

  private Viewer viewer;

  public ResourceContentProvider()
  {
  }

  public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
  {
    dispose();
    this.viewer = viewer;

    if (newInput instanceof ResourceCache)
    {
      resourceCache = (ResourceCache)newInput;
      resourceCache.addListener(this);
      UiUtils.refreshViewer(viewer);
    }
  }

  public void dispose()
  {
    viewer = null;
    if (resourceCache != null)
    {
      resourceCache.removeListener(this);
      resourceCache = null;
    }
  }

  public Object[] getElements(Object parent)
  {
    if (resourceCache == null) return new Object[0];
    return resourceCache.getAllResources().toArray();
  }

  public void notifyResourceAdded(ResourceCache manager, ResourceInfo resourceInfo)
  {
    UiUtils.refreshViewer(viewer);
  }

  public void notifyResourceRemoved(ResourceCache manager, ResourceInfo resourceInfo)
  {
    UiUtils.refreshViewer(viewer);
  }
}
