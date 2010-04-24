/*******************************************************************************
 * Copyright (c) 2010 Martin Fluegge (Berlin, Germany).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fluegge - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.cdo.dawn.logging.logger.LOG;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassDiagram;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramFactory;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.DawnClassDiagramEditPart;
import org.eclipse.emf.cdo.dawn.runtime.commands.CreateSemanticResourceRecordingCommand;
import org.eclipse.emf.cdo.dawn.runtime.preferences.PreferenceConstants;
import org.eclipse.emf.cdo.dawn.runtime.transaction.DawnGMFEditingDomainFactory;
import org.eclipse.emf.cdo.dawn.ui.DawnEditorInput;
import org.eclipse.emf.cdo.dawn.util.connection.CDOConnectionUtil;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * @author Martin Fluegge
 */
public class DawnClassdiagramDiagramEditorUtil extends ClassdiagramDiagramEditorUtil
{

  static CDOSession session;

  /**
   * @generated
   */
  public static boolean openDiagram(Resource diagram) throws PartInitException
  {
    IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    return null != page.openEditor(new DawnEditorInput(diagram.getURI()), DawnClassdiagramDiagramEditor.ID);
  }

  // /**
  // * @generated
  // */
  // public static String getUniqueFileName(IPath containerFullPath, String fileName, String extension)
  // {
  // if (containerFullPath == null)
  // {
  //      containerFullPath = new Path(""); //$NON-NLS-1$
  // }
  // if (fileName == null || fileName.trim().length() == 0)
  // {
  //      fileName = "default"; //$NON-NLS-1$
  // }
  // IPath filePath = containerFullPath.append(fileName);
  // if (extension != null && !extension.equals(filePath.getFileExtension()))
  // {
  // filePath = filePath.addFileExtension(extension);
  // }
  // extension = filePath.getFileExtension();
  // fileName = filePath.removeFileExtension().lastSegment();
  // int i = 1;
  // while (ResourcesPlugin.getWorkspace().getRoot().exists(filePath))
  // {
  // i++;
  // filePath = containerFullPath.append(fileName + i);
  // if (extension != null)
  // {
  // filePath = filePath.addFileExtension(extension);
  // }
  // }
  // return filePath.lastSegment();
  // }

  /**
   * Runs the wizard in a dialog.
   * 
   * @generated
   */
  public static void runWizard(Shell shell, Wizard wizard, String settingsKey)
  {
    IDialogSettings pluginDialogSettings = ClassdiagramDiagramEditorPlugin.getInstance().getDialogSettings();
    IDialogSettings wizardDialogSettings = pluginDialogSettings.getSection(settingsKey);
    if (wizardDialogSettings == null)
    {
      wizardDialogSettings = pluginDialogSettings.addNewSection(settingsKey);
    }
    wizard.setDialogSettings(wizardDialogSettings);
    WizardDialog dialog = new WizardDialog(shell, wizard);
    dialog.create();
    dialog.getShell().setSize(Math.max(500, dialog.getShell().getSize().x), 500);
    dialog.open();
  }

  public static Resource createDiagram(URI diagramURI, URI modelURI, IProgressMonitor progressMonitor)
  {
    TransactionalEditingDomain editingDomain = DawnGMFEditingDomainFactory.getInstance().createEditingDomain();

    progressMonitor.beginTask(Messages.ClassdiagramDiagramEditorUtil_CreateDiagramProgressTask, 3);

    // CDOConnectionUtil.instance.init("repo1", "tcp", "localhost");
    CDOConnectionUtil.instance.init(PreferenceConstants.getRepositoryName(), PreferenceConstants.getProtocol(),
        PreferenceConstants.getServerName());
    CDOSession session = CDOConnectionUtil.instance.openSession();
    ResourceSet resourceSet = editingDomain.getResourceSet();

    LOG.info("URI toString: " + diagramURI.toString());
    LOG.info("URI authority: " + diagramURI.authority());

    CDOTransaction transaction = CDOConnectionUtil.instance.openCurrentTransaction(resourceSet, diagramURI.toString());

    final Resource diagramResource = resourceSet.createResource(diagramURI);

    LOG.info("Diagram URI: " + diagramURI);
    LOG.info("Diagram Resource: " + diagramResource);

    CreateSemanticResourceRecordingCommand createSemanticResourceCommand = new CreateSemanticResourceRecordingCommand(
        editingDomain, transaction, modelURI.toString());

    editingDomain.getCommandStack().execute(createSemanticResourceCommand);
    final Resource modelResource = createSemanticResourceCommand.getResource();
    LOG.info("Model URI: " + modelURI);
    LOG.info("Model Resource: " + modelResource);

    final String diagramName = diagramURI.lastSegment();
    AbstractTransactionalCommand command = new AbstractTransactionalCommand(editingDomain,
        Messages.ClassdiagramDiagramEditorUtil_CreateDiagramCommandLabel, Collections.EMPTY_LIST)
    {
      protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException
      {
        ClassDiagram model = null;
        if (modelResource.getContents().size() > 0)
        {
          model = (ClassDiagram)modelResource.getContents().get(0);
        }
        else
        {
          model = createInitialModel();
          attachModelToResource(model, modelResource);
        }

        Diagram diagram = ViewService.createDiagram(model, DawnClassDiagramEditPart.MODEL_ID,
            ClassdiagramDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
        if (diagram != null)
        {
          diagramResource.getContents().add(diagram);
          diagram.setName(diagramName);
          diagram.setElement(model);
        }

        try
        {
          modelResource.save(Collections.EMPTY_MAP);
          diagramResource.save(Collections.EMPTY_MAP);
        }
        catch (IOException e)
        {
          ClassdiagramDiagramEditorPlugin.getInstance().logError("Unable to store model and diagram resources", e); //$NON-NLS-1$
        }

        return CommandResult.newOKCommandResult();
      }
    };
    try
    {
      OperationHistoryFactory.getOperationHistory().execute(command, new SubProgressMonitor(progressMonitor, 1), null);
    }
    catch (ExecutionException e)
    {
      ClassdiagramDiagramEditorPlugin.getInstance().logError("Unable to create model and diagram", e); //$NON-NLS-1$
    }
    setCharset(WorkspaceSynchronizer.getFile(modelResource));
    setCharset(WorkspaceSynchronizer.getFile(diagramResource));
    return diagramResource;
  }

  /**
   * Create a new instance of domain element associated with canvas. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private static ClassDiagram createInitialModel()
  {
    return ClassdiagramFactory.eINSTANCE.createClassDiagram();
  }

  /**
   * Store model element in the resource. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private static void attachModelToResource(ClassDiagram model, Resource resource)
  {
    resource.getContents().add(model);
  }

  // /**
  // * @generated
  // */
  // public static void selectElementsInDiagram(IDiagramWorkbenchPart diagramPart, List/* EditPart */editParts)
  // {
  // diagramPart.getDiagramGraphicalViewer().deselectAll();
  //
  // EditPart firstPrimary = null;
  // for (Iterator it = editParts.iterator(); it.hasNext();)
  // {
  // EditPart nextPart = (EditPart)it.next();
  // diagramPart.getDiagramGraphicalViewer().appendSelection(nextPart);
  // if (firstPrimary == null && nextPart instanceof IPrimaryEditPart)
  // {
  // firstPrimary = nextPart;
  // }
  // }
  //
  // if (!editParts.isEmpty())
  // {
  // diagramPart.getDiagramGraphicalViewer().reveal(firstPrimary != null ? firstPrimary : (EditPart)editParts.get(0));
  // }
  // }

  // /**
  // * @generated
  // */
  // private static int findElementsInDiagramByID(DiagramEditPart diagramPart, EObject element, List editPartCollector)
  // {
  // IDiagramGraphicalViewer viewer = (IDiagramGraphicalViewer)diagramPart.getViewer();
  // final int intialNumOfEditParts = editPartCollector.size();
  //
  // if (element instanceof View)
  // { // support notation element lookup
  // EditPart editPart = (EditPart)viewer.getEditPartRegistry().get(element);
  // if (editPart != null)
  // {
  // editPartCollector.add(editPart);
  // return 1;
  // }
  // }
  //
  // String elementID = EMFCoreUtil.getProxyID(element);
  // List associatedParts = viewer.findEditPartsForElement(elementID, IGraphicalEditPart.class);
  // // perform the possible hierarchy disjoint -> take the top-most parts only
  // for (Iterator editPartIt = associatedParts.iterator(); editPartIt.hasNext();)
  // {
  // EditPart nextPart = (EditPart)editPartIt.next();
  // EditPart parentPart = nextPart.getParent();
  // while (parentPart != null && !associatedParts.contains(parentPart))
  // {
  // parentPart = parentPart.getParent();
  // }
  // if (parentPart == null)
  // {
  // editPartCollector.add(nextPart);
  // }
  // }
  //
  // if (intialNumOfEditParts == editPartCollector.size())
  // {
  // if (!associatedParts.isEmpty())
  // {
  // editPartCollector.add(associatedParts.iterator().next());
  // }
  // else
  // {
  // if (element.eContainer() != null)
  // {
  // return findElementsInDiagramByID(diagramPart, element.eContainer(), editPartCollector);
  // }
  // }
  // }
  // return editPartCollector.size() - intialNumOfEditParts;
  // }

  // /**
  // * @generated
  // */
  // public static View findView(DiagramEditPart diagramEditPart, EObject targetElement,
  // LazyElement2ViewMap lazyElement2ViewMap)
  // {
  // boolean hasStructuralURI = false;
  // if (targetElement.eResource() instanceof XMLResource)
  // {
  // hasStructuralURI = ((XMLResource)targetElement.eResource()).getID(targetElement) == null;
  // }
  //
  // View view = null;
  // if (hasStructuralURI && !lazyElement2ViewMap.getElement2ViewMap().isEmpty())
  // {
  // view = (View)lazyElement2ViewMap.getElement2ViewMap().get(targetElement);
  // }
  // else if (findElementsInDiagramByID(diagramEditPart, targetElement, lazyElement2ViewMap.editPartTmpHolder) > 0)
  // {
  // EditPart editPart = (EditPart)lazyElement2ViewMap.editPartTmpHolder.get(0);
  // lazyElement2ViewMap.editPartTmpHolder.clear();
  // view = editPart.getModel() instanceof View ? (View)editPart.getModel() : null;
  // }
  //
  // return (view == null) ? diagramEditPart.getDiagramView() : view;
  // }

  // /**
  // * @generated
  // */
  // public static class LazyElement2ViewMap
  // {
  // /**
  // * @generated
  // */
  // private Map element2ViewMap;
  //
  // /**
  // * @generated
  // */
  // private View scope;
  //
  // /**
  // * @generated
  // */
  // private Set elementSet;
  //
  // /**
  // * @generated
  // */
  // public final List editPartTmpHolder = new ArrayList();
  //
  // /**
  // * @generated
  // */
  // public LazyElement2ViewMap(View scope, Set elements)
  // {
  // this.scope = scope;
  // this.elementSet = elements;
  // }
  //
  // /**
  // * @generated
  // */
  // public final Map getElement2ViewMap()
  // {
  // if (element2ViewMap == null)
  // {
  // element2ViewMap = new HashMap();
  // // map possible notation elements to itself as these can't be found by view.getElement()
  // for (Iterator it = elementSet.iterator(); it.hasNext();)
  // {
  // EObject element = (EObject)it.next();
  // if (element instanceof View)
  // {
  // View view = (View)element;
  // if (view.getDiagram() == scope.getDiagram())
  // {
  // element2ViewMap.put(element, element); // take only those that part of our diagram
  // }
  // }
  // }
  //
  // buildElement2ViewMap(scope, element2ViewMap, elementSet);
  // }
  // return element2ViewMap;
  // }
  //
  // /**
  // * @generated
  // */
  // static Map buildElement2ViewMap(View parentView, Map element2ViewMap, Set elements)
  // {
  // if (elements.size() == element2ViewMap.size())
  // return element2ViewMap;
  //
  // if (parentView.isSetElement() && !element2ViewMap.containsKey(parentView.getElement())
  // && elements.contains(parentView.getElement()))
  // {
  // element2ViewMap.put(parentView.getElement(), parentView);
  // if (elements.size() == element2ViewMap.size())
  // return element2ViewMap;
  // }
  //
  // for (Iterator it = parentView.getChildren().iterator(); it.hasNext();)
  // {
  // buildElement2ViewMap((View)it.next(), element2ViewMap, elements);
  // if (elements.size() == element2ViewMap.size())
  // return element2ViewMap;
  // }
  // for (Iterator it = parentView.getSourceEdges().iterator(); it.hasNext();)
  // {
  // buildElement2ViewMap((View)it.next(), element2ViewMap, elements);
  // if (elements.size() == element2ViewMap.size())
  // return element2ViewMap;
  // }
  // for (Iterator it = parentView.getSourceEdges().iterator(); it.hasNext();)
  // {
  // buildElement2ViewMap((View)it.next(), element2ViewMap, elements);
  // if (elements.size() == element2ViewMap.size())
  // return element2ViewMap;
  // }
  // return element2ViewMap;
  // }
  // } // LazyElement2ViewMap

}
