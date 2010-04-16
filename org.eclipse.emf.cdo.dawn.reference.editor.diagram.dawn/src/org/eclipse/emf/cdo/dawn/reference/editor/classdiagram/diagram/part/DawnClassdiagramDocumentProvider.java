package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.cdo.dawn.logging.logger.LOG;
import org.eclipse.emf.cdo.dawn.ui.DawnEditorInput;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.internal.util.DiagramIOUtil;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResourceFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;

/**
 * @generated
 */
public class DawnClassdiagramDocumentProvider extends ClassdiagramDocumentProvider
{

  public DawnClassdiagramDocumentProvider()
  {
    super();
    LOG.info("DAWN DOCUMENTPROVIDER");
  }

  @Override
  protected void setDocumentContent(IDocument document, IEditorInput element) throws CoreException
  {
    LOG.info("USING MY DOCUMENTPROVIDER TO GENRATE THE CDO STUFF");
    LOG.info("Editor Input: " + element.getName());

    IDiagramDocument diagramDocument = (IDiagramDocument)document;
    TransactionalEditingDomain domain = diagramDocument.getEditingDomain();
    if (element instanceof FileEditorInput)
    {
      IStorage storage = ((FileEditorInput)element).getStorage();
      Diagram diagram = DiagramIOUtil.load(domain, storage, true, getProgressMonitor());
      document.setContent(diagram);
    }
    else if (element instanceof URIEditorInput)
    {
      URIEditorInput editorInput = (URIEditorInput)element;

      // CDOConnectionUtil.instance.getOrOpenCurrentTransaction(editorInput.getURI().toString(),
      // domain.getResourceSet());// session.openTransaction(resourceSet);

      URI uri = editorInput.getURI();
      Resource resource = null;
      try
      {
        // TODO change this fake!!
        URI dawnURI = URI.createURI(uri.toString().replace("cdo", "dawn"));
        resource = domain.getResourceSet().getResource(dawnURI, false);
        if (resource == null)
        {
          // TODO clarify with Eike why here a transaction will be opended??
          resource = domain.getResourceSet().getResource(dawnURI, true);
        }

        if (editorInput instanceof DawnEditorInput)
        {
          ((DawnEditorInput)editorInput).setResource((CDOResource)resource);
        }
        if (!resource.isLoaded())
        {
          try
          {
            Map options = new HashMap(GMFResourceFactory.getDefaultLoadOptions());
            // @see 171060
            // options.put(org.eclipse.emf.ecore.xmi.XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
            resource.load(options);
          }
          catch (IOException e)
          {
            resource.unload();
            throw e;
          }
        }
        if (uri.fragment() != null)
        {
          EObject rootElement = resource.getEObject(uri.fragment());
          if (rootElement instanceof Diagram)
          {
            document.setContent((Diagram)rootElement);
            return;
          }
        }
        else
        {
          for (Iterator it = resource.getContents().iterator(); it.hasNext();)
          {
            Object rootElement = it.next();
            if (rootElement instanceof Diagram)
            {
              document.setContent((Diagram)rootElement);
              return;
            }
          }
        }
        throw new RuntimeException(Messages.ClassdiagramDocumentProvider_NoDiagramInResourceError);
      }
      catch (Exception e)
      {
        CoreException thrownExcp = null;
        if (e instanceof CoreException)
        {
          thrownExcp = (CoreException)e;
        }
        else
        {
          String msg = e.getLocalizedMessage();
          thrownExcp = new CoreException(new Status(IStatus.ERROR, ClassdiagramDiagramEditorPlugin.ID, 0,
              msg != null ? msg : Messages.ClassdiagramDocumentProvider_DiagramLoadingError, e));
        }
        throw thrownExcp;
      }
    }
    else
    {
      throw new CoreException(new Status(IStatus.ERROR, ClassdiagramDiagramEditorPlugin.ID, 0, NLS.bind(
          Messages.ClassdiagramDocumentProvider_IncorrectInputError, new Object[] { element,
              "org.eclipse.ui.part.FileEditorInput", "org.eclipse.emf.common.ui.URIEditorInput" }), //$NON-NLS-1$ //$NON-NLS-2$ 
          null));
    }
  }

  @Override
  public void changed(Object element)
  {
    if (element instanceof IEditorInput)
    {
      fireElementDirtyStateChanged(element, true);
    }
  }
  // /**
  // *
  // */
  // @Override
  // protected IDocument createEmptyDocument()
  // {
  // DiagramDocument document = new DiagramDocument();
  // document.setEditingDomain(createEditingDomain());
  // return document;
  // }
  // /**
  // * implement createEditingDomain() an change the TransactionalEditingDomain here.
  // */
  // private TransactionalEditingDomain createEditingDomain()
  // {
  // TransactionalEditingDomain editingDomain = new DawnTransactionalEditingDomainImpl(new ComposedAdapterFactory(
  // ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
  //    editingDomain.setID("org.eclipse.emf.cdo.dawn.reference.editor.diagram.EditingDomain"); //$NON-NLS-1$
  // final NotificationFilter diagramResourceModifiedFilter = NotificationFilter.createNotifierFilter(
  // editingDomain.getResourceSet()).and(NotificationFilter.createEventTypeFilter(Notification.ADD)).and(
  // NotificationFilter.createFeatureFilter(ResourceSet.class, ResourceSet.RESOURCE_SET__RESOURCES));
  // editingDomain.getResourceSet().eAdapters().add(new Adapter()
  // {
  //
  // private Notifier myTarger;
  //
  // public Notifier getTarget()
  // {
  // return myTarger;
  // }
  //
  // public boolean isAdapterForType(Object type)
  // {
  // return false;
  // }
  //
  // public void notifyChanged(Notification notification)
  // {
  // if (diagramResourceModifiedFilter.matches(notification))
  // {
  // Object value = notification.getNewValue();
  // if (value instanceof Resource)
  // {
  // ((Resource)value).setTrackingModification(true);
  // }
  // }
  // }
  //
  // public void setTarget(Notifier newTarget)
  // {
  // myTarger = newTarget;
  // }
  //
  // });
  //
  // return editingDomain;
  // }

}
