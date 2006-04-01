/**
 * 
 */
package org.eclipse.emf.cdo.example.ui.internal;


import org.eclipse.emf.cdo.client.ResourceInfo;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;


public class ResourceLabelProvider extends LabelProvider
{
  public String getText(Object obj)
  {
    if (obj instanceof ResourceInfo)
    {
      ResourceInfo info = ((ResourceInfo)obj);
      return info.getPath();
    }

    return obj.toString();
  }

  public Image getImage(Object obj)
  {
    if (obj instanceof ResourceInfo)
    {
      return UiUtils.getImage("full/obj16/CdoResource");
    }

    ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
    return sharedImages.getImage(ISharedImages.IMG_OBJ_ELEMENT);
  }
}
