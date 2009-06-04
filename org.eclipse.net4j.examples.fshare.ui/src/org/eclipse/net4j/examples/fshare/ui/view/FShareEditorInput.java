package org.eclipse.net4j.examples.fshare.ui.view;

import org.eclipse.net4j.examples.fshare.ui.Activator;

import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class FShareEditorInput extends PlatformObject implements IEditorInput
{
  private String connectorType;

  private String connectorDescription;

  private String folderName;

  public FShareEditorInput(String connectorType, String connectorDescription, String folderName)
  {
    this.connectorType = connectorType;
    this.connectorDescription = connectorDescription;
    this.folderName = folderName;
  }

  public String getConnectorType()
  {
    return connectorType;
  }

  public String getConnectorDescription()
  {
    return connectorDescription;
  }

  public String getFolderName()
  {
    return folderName;
  }

  public String getName()
  {
    return getFolderName();
  }

  public String getToolTipText()
  {
    return getConnectorDescription() + "://" + getConnectorDescription() + "/" + getFolderName();
  }

  public boolean exists()
  {
    return true;
  }

  public ImageDescriptor getImageDescriptor()
  {
    return Activator.getImageDescriptor("icons/sample.gif");
  }

  public IPersistableElement getPersistable()
  {
    return null;
  }
}
