package org.eclipse.net4j.tools.workingset.ui.embedded;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.StateBasedContainerManager;
import org.eclipse.xtext.resource.impl.DefaultResourceDescription;

import com.google.inject.Inject;

public class EmbeddedStateBasedContainerManager extends StateBasedContainerManager
{

  @Inject
  private IResourceDescription.Manager descriptionManager;

  public EmbeddedStateBasedContainerManager()
  {
    super();
  }

  @Override
  protected String internalGetContainerHandle(IResourceDescription desc, IResourceDescriptions resourceDescriptions)
  {
    Resource resource = null;
    IResourceDescription parentDescription = null;
    if (desc instanceof DefaultResourceDescription)
    {
      DefaultResourceDescription resDesc = (DefaultResourceDescription)desc;
      resource = resDesc.getResource();
    }
    if (resource != null && resource instanceof EmbeddedXtextResource)
    {
      EmbeddedXtextResource embbeddedResource = (EmbeddedXtextResource)resource;
      Resource parentResource = embbeddedResource.getParentResource();
      parentDescription = descriptionManager.getResourceDescription(parentResource);
      return super.internalGetContainerHandle(parentDescription, resourceDescriptions);
    }
    return super.internalGetContainerHandle(desc, resourceDescriptions);
  }

}
