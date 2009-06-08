package org.eclipse.net4j.examples.fshare.ui.view;

import org.eclipse.net4j.examples.fshare.IFile;
import org.eclipse.net4j.examples.fshare.IFolder;
import org.eclipse.net4j.examples.fshare.IResource;
import org.eclipse.net4j.examples.fshare.ui.Activator;

import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class FShareLabelProvider extends LabelProvider implements IColorProvider
{
  private Image folderImage;

  private Image fileImage;

  private Color grayColor;

  public FShareLabelProvider()
  {
    Display display = Display.getCurrent();
    folderImage = Activator.getImageDescriptor("icons/folder.gif").createImage(display);
    fileImage = Activator.getImageDescriptor("icons/file.gif").createImage(display);
    grayColor = display.getSystemColor(SWT.COLOR_GRAY);
  }

  @Override
  public void dispose()
  {
    fileImage.dispose();
    folderImage.dispose();
    super.dispose();
  }

  @Override
  public String getText(Object element)
  {
    if (element instanceof IResource)
    {
      IResource resource = (IResource)element;
      String name = resource.getName();
      int percentUploaded = resource.getUploadedPercent();
      if (percentUploaded < 100)
      {
        name += " - " + percentUploaded + "%";
      }

      return name;
    }

    return super.getText(element);
  }

  @Override
  public Image getImage(Object element)
  {
    if (element instanceof IFolder)
    {
      return folderImage;
    }

    if (element instanceof IFile)
    {
      return fileImage;
    }

    return super.getImage(element);
  }

  public Color getBackground(Object element)
  {
    return null;
  }

  public Color getForeground(Object element)
  {
    if (element instanceof IResource)
    {
      IResource resource = (IResource)element;
      if (resource.getUploadedPercent() < 100)
      {
        return grayColor;
      }
    }

    return null;
  }
}
