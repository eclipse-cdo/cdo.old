package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.providers;

import org.eclipse.emf.cdo.dawn.logging.logger.LOG;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.DawnClassdiagramEditPartFactory;

public class DawnClassdiagramEditPartProvider extends ClassdiagramEditPartProvider
{
  public DawnClassdiagramEditPartProvider()
  {
    super();
    LOG.info("Using DawnClassdiagramEditPartProvider instead of the original one.");
    setFactory(new DawnClassdiagramEditPartFactory());
  }
}
