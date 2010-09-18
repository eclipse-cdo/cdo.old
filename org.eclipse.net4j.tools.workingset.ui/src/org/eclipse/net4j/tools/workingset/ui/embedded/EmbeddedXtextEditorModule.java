package org.eclipse.net4j.tools.workingset.ui.embedded;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.AbstractGenericModule;

public class EmbeddedXtextEditorModule extends AbstractGenericModule
{

  public Class<? extends XtextResource> bindXtextResource()
  {
    return EmbeddedXtextResource.class;
  }

  public Class<? extends org.eclipse.xtext.resource.IContainer.Manager> bindIContainer$Manager()
  {
    return EmbeddedStateBasedContainerManager.class;
  }

}
