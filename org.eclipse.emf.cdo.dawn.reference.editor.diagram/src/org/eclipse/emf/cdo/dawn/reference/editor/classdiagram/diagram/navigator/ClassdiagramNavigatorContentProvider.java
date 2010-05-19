/*******************************************************************************
 * Copyright (c) 2004 - 2010 Eike Stepper (Berlin, Germany).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fluegge - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.navigator;

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassAggregationsEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassAnAttributeCompartmentEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassAnOperationClassCompartmentEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassAssociationsEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassCompositionsEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassImplementedInterfacesEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassSubClassesEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AInterfaceAnAttributeInterfaceCompartmentEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AInterfaceAnOperationInterfaceCompartmentEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AInterfaceEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnAttribute2EditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnAttributeEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnOperation2EditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnOperationEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.ClassDiagramEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramVisualIDRegistry;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.Messages;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;

import org.eclipse.core.resources.IFile;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @generated
 */
public class ClassdiagramNavigatorContentProvider implements ICommonContentProvider
{

  /**
   * @generated
   */
  private static final Object[] EMPTY_ARRAY = new Object[0];

  /**
   * @generated
   */
  private Viewer myViewer;

  /**
   * @generated
   */
  private AdapterFactoryEditingDomain myEditingDomain;

  /**
   * @generated
   */
  private WorkspaceSynchronizer myWorkspaceSynchronizer;

  /**
   * @generated
   */
  private Runnable myViewerRefreshRunnable;

  /**
   * @generated
   */
  public ClassdiagramNavigatorContentProvider()
  {
    TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
    myEditingDomain = (AdapterFactoryEditingDomain)editingDomain;
    myEditingDomain.setResourceToReadOnlyMap(new HashMap()
    {
      public Object get(Object key)
      {
        if (!containsKey(key))
        {
          put(key, Boolean.TRUE);
        }
        return super.get(key);
      }
    });
    myViewerRefreshRunnable = new Runnable()
    {
      public void run()
      {
        if (myViewer != null)
        {
          myViewer.refresh();
        }
      }
    };
    myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain, new WorkspaceSynchronizer.Delegate()
    {
      public void dispose()
      {
      }

      public boolean handleResourceChanged(final Resource resource)
      {
        for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();)
        {
          Resource nextResource = (Resource)it.next();
          nextResource.unload();
        }
        if (myViewer != null)
        {
          myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
        }
        return true;
      }

      public boolean handleResourceDeleted(Resource resource)
      {
        for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();)
        {
          Resource nextResource = (Resource)it.next();
          nextResource.unload();
        }
        if (myViewer != null)
        {
          myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
        }
        return true;
      }

      public boolean handleResourceMoved(Resource resource, final URI newURI)
      {
        for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();)
        {
          Resource nextResource = (Resource)it.next();
          nextResource.unload();
        }
        if (myViewer != null)
        {
          myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
        }
        return true;
      }
    });
  }

  /**
   * @generated
   */
  public void dispose()
  {
    myWorkspaceSynchronizer.dispose();
    myWorkspaceSynchronizer = null;
    myViewerRefreshRunnable = null;
    for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();)
    {
      Resource resource = (Resource)it.next();
      resource.unload();
    }
    ((TransactionalEditingDomain)myEditingDomain).dispose();
    myEditingDomain = null;
  }

  /**
   * @generated
   */
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
  {
    myViewer = viewer;
  }

  /**
   * @generated
   */
  public Object[] getElements(Object inputElement)
  {
    return getChildren(inputElement);
  }

  /**
   * @generated
   */
  public void restoreState(IMemento aMemento)
  {
  }

  /**
   * @generated
   */
  public void saveState(IMemento aMemento)
  {
  }

  /**
   * @generated
   */
  public void init(ICommonContentExtensionSite aConfig)
  {
  }

  /**
   * @generated
   */
  public Object[] getChildren(Object parentElement)
  {
    if (parentElement instanceof IFile)
    {
      IFile file = (IFile)parentElement;
      URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
      Resource resource = myEditingDomain.getResourceSet().getResource(fileURI, true);
      ArrayList<ClassdiagramNavigatorItem> result = new ArrayList<ClassdiagramNavigatorItem>();
      ArrayList<View> topViews = new ArrayList<View>(resource.getContents().size());
      for (Iterator<EObject> it = resource.getContents().iterator(); it.hasNext();)
      {
        EObject o = it.next();
        if (o instanceof View)
        {
          topViews.add((View)o);
        }
      }
      result.addAll(createNavigatorItems(selectViewsByType(topViews, ClassDiagramEditPart.MODEL_ID), file, false));
      return result.toArray();
    }

    if (parentElement instanceof ClassdiagramNavigatorGroup)
    {
      ClassdiagramNavigatorGroup group = (ClassdiagramNavigatorGroup)parentElement;
      return group.getChildren();
    }

    if (parentElement instanceof ClassdiagramNavigatorItem)
    {
      ClassdiagramNavigatorItem navigatorItem = (ClassdiagramNavigatorItem)parentElement;
      if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView()))
      {
        return EMPTY_ARRAY;
      }
      return getViewChildren(navigatorItem.getView(), parentElement);
    }

    return EMPTY_ARRAY;
  }

  /**
   * @generated
   */
  private Object[] getViewChildren(View view, Object parentElement)
  {
    switch (ClassdiagramVisualIDRegistry.getVisualID(view))
    {

    case AClassAggregationsEditPart.VISUAL_ID:
    {
      LinkedList<ClassdiagramAbstractNavigatorItem> result = new LinkedList<ClassdiagramAbstractNavigatorItem>();
      ClassdiagramNavigatorGroup target = new ClassdiagramNavigatorGroup(
          Messages.NavigatorGroupName_AClassAggregations_4004_target,
          "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
      ClassdiagramNavigatorGroup source = new ClassdiagramNavigatorGroup(
          Messages.NavigatorGroupName_AClassAggregations_4004_source,
          "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
      Collection<View> connectedViews;
      connectedViews = getLinksTargetByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassEditPart.VISUAL_ID));
      target.addChildren(createNavigatorItems(connectedViews, target, true));
      connectedViews = getLinksSourceByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassEditPart.VISUAL_ID));
      source.addChildren(createNavigatorItems(connectedViews, source, true));
      if (!target.isEmpty())
      {
        result.add(target);
      }
      if (!source.isEmpty())
      {
        result.add(source);
      }
      return result.toArray();
    }

    case ClassDiagramEditPart.VISUAL_ID:
    {
      LinkedList<ClassdiagramAbstractNavigatorItem> result = new LinkedList<ClassdiagramAbstractNavigatorItem>();
      ClassdiagramNavigatorGroup links = new ClassdiagramNavigatorGroup(
          Messages.NavigatorGroupName_ClassDiagram_1000_links, "icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
      Collection<View> connectedViews;
      connectedViews = getChildrenByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AInterfaceEditPart.VISUAL_ID));
      result.addAll(createNavigatorItems(connectedViews, parentElement, false));
      connectedViews = getChildrenByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassEditPart.VISUAL_ID));
      result.addAll(createNavigatorItems(connectedViews, parentElement, false));
      connectedViews = getDiagramLinksByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassSubClassesEditPart.VISUAL_ID));
      links.addChildren(createNavigatorItems(connectedViews, links, false));
      connectedViews = getDiagramLinksByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassImplementedInterfacesEditPart.VISUAL_ID));
      links.addChildren(createNavigatorItems(connectedViews, links, false));
      connectedViews = getDiagramLinksByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassAssociationsEditPart.VISUAL_ID));
      links.addChildren(createNavigatorItems(connectedViews, links, false));
      connectedViews = getDiagramLinksByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassAggregationsEditPart.VISUAL_ID));
      links.addChildren(createNavigatorItems(connectedViews, links, false));
      connectedViews = getDiagramLinksByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassCompositionsEditPart.VISUAL_ID));
      links.addChildren(createNavigatorItems(connectedViews, links, false));
      if (!links.isEmpty())
      {
        result.add(links);
      }
      return result.toArray();
    }

    case AClassSubClassesEditPart.VISUAL_ID:
    {
      LinkedList<ClassdiagramAbstractNavigatorItem> result = new LinkedList<ClassdiagramAbstractNavigatorItem>();
      ClassdiagramNavigatorGroup target = new ClassdiagramNavigatorGroup(
          Messages.NavigatorGroupName_AClassSubClasses_4001_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
      ClassdiagramNavigatorGroup source = new ClassdiagramNavigatorGroup(
          Messages.NavigatorGroupName_AClassSubClasses_4001_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
      Collection<View> connectedViews;
      connectedViews = getLinksTargetByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassEditPart.VISUAL_ID));
      target.addChildren(createNavigatorItems(connectedViews, target, true));
      connectedViews = getLinksSourceByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassEditPart.VISUAL_ID));
      source.addChildren(createNavigatorItems(connectedViews, source, true));
      if (!target.isEmpty())
      {
        result.add(target);
      }
      if (!source.isEmpty())
      {
        result.add(source);
      }
      return result.toArray();
    }

    case AClassCompositionsEditPart.VISUAL_ID:
    {
      LinkedList<ClassdiagramAbstractNavigatorItem> result = new LinkedList<ClassdiagramAbstractNavigatorItem>();
      ClassdiagramNavigatorGroup target = new ClassdiagramNavigatorGroup(
          Messages.NavigatorGroupName_AClassCompositions_4005_target,
          "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
      ClassdiagramNavigatorGroup source = new ClassdiagramNavigatorGroup(
          Messages.NavigatorGroupName_AClassCompositions_4005_source,
          "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
      Collection<View> connectedViews;
      connectedViews = getLinksTargetByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassEditPart.VISUAL_ID));
      target.addChildren(createNavigatorItems(connectedViews, target, true));
      connectedViews = getLinksSourceByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassEditPart.VISUAL_ID));
      source.addChildren(createNavigatorItems(connectedViews, source, true));
      if (!target.isEmpty())
      {
        result.add(target);
      }
      if (!source.isEmpty())
      {
        result.add(source);
      }
      return result.toArray();
    }

    case AClassAssociationsEditPart.VISUAL_ID:
    {
      LinkedList<ClassdiagramAbstractNavigatorItem> result = new LinkedList<ClassdiagramAbstractNavigatorItem>();
      ClassdiagramNavigatorGroup target = new ClassdiagramNavigatorGroup(
          Messages.NavigatorGroupName_AClassAssociations_4003_target,
          "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
      ClassdiagramNavigatorGroup source = new ClassdiagramNavigatorGroup(
          Messages.NavigatorGroupName_AClassAssociations_4003_source,
          "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
      Collection<View> connectedViews;
      connectedViews = getLinksTargetByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassEditPart.VISUAL_ID));
      target.addChildren(createNavigatorItems(connectedViews, target, true));
      connectedViews = getLinksSourceByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassEditPart.VISUAL_ID));
      source.addChildren(createNavigatorItems(connectedViews, source, true));
      if (!target.isEmpty())
      {
        result.add(target);
      }
      if (!source.isEmpty())
      {
        result.add(source);
      }
      return result.toArray();
    }

    case AClassImplementedInterfacesEditPart.VISUAL_ID:
    {
      LinkedList<ClassdiagramAbstractNavigatorItem> result = new LinkedList<ClassdiagramAbstractNavigatorItem>();
      ClassdiagramNavigatorGroup target = new ClassdiagramNavigatorGroup(
          Messages.NavigatorGroupName_AClassImplementedInterfaces_4002_target,
          "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
      ClassdiagramNavigatorGroup source = new ClassdiagramNavigatorGroup(
          Messages.NavigatorGroupName_AClassImplementedInterfaces_4002_source,
          "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
      Collection<View> connectedViews;
      connectedViews = getLinksTargetByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AInterfaceEditPart.VISUAL_ID));
      target.addChildren(createNavigatorItems(connectedViews, target, true));
      connectedViews = getLinksSourceByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassEditPart.VISUAL_ID));
      source.addChildren(createNavigatorItems(connectedViews, source, true));
      if (!target.isEmpty())
      {
        result.add(target);
      }
      if (!source.isEmpty())
      {
        result.add(source);
      }
      return result.toArray();
    }

    case AClassEditPart.VISUAL_ID:
    {
      LinkedList<ClassdiagramAbstractNavigatorItem> result = new LinkedList<ClassdiagramAbstractNavigatorItem>();
      ClassdiagramNavigatorGroup incominglinks = new ClassdiagramNavigatorGroup(
          Messages.NavigatorGroupName_AClass_2002_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
      ClassdiagramNavigatorGroup outgoinglinks = new ClassdiagramNavigatorGroup(
          Messages.NavigatorGroupName_AClass_2002_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
      Collection<View> connectedViews;
      connectedViews = getChildrenByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassAnAttributeCompartmentEditPart.VISUAL_ID));
      connectedViews = getChildrenByType(connectedViews, ClassdiagramVisualIDRegistry
          .getType(AnAttribute2EditPart.VISUAL_ID));
      result.addAll(createNavigatorItems(connectedViews, parentElement, false));
      connectedViews = getChildrenByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassAnOperationClassCompartmentEditPart.VISUAL_ID));
      connectedViews = getChildrenByType(connectedViews, ClassdiagramVisualIDRegistry
          .getType(AnOperation2EditPart.VISUAL_ID));
      result.addAll(createNavigatorItems(connectedViews, parentElement, false));
      connectedViews = getIncomingLinksByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassSubClassesEditPart.VISUAL_ID));
      incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
      connectedViews = getOutgoingLinksByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassSubClassesEditPart.VISUAL_ID));
      outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
      connectedViews = getOutgoingLinksByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassImplementedInterfacesEditPart.VISUAL_ID));
      outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
      connectedViews = getIncomingLinksByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassAssociationsEditPart.VISUAL_ID));
      incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
      connectedViews = getOutgoingLinksByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassAssociationsEditPart.VISUAL_ID));
      outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
      connectedViews = getIncomingLinksByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassAggregationsEditPart.VISUAL_ID));
      incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
      connectedViews = getOutgoingLinksByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassAggregationsEditPart.VISUAL_ID));
      outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
      connectedViews = getIncomingLinksByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassCompositionsEditPart.VISUAL_ID));
      incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
      connectedViews = getOutgoingLinksByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassCompositionsEditPart.VISUAL_ID));
      outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
      if (!incominglinks.isEmpty())
      {
        result.add(incominglinks);
      }
      if (!outgoinglinks.isEmpty())
      {
        result.add(outgoinglinks);
      }
      return result.toArray();
    }

    case AInterfaceEditPart.VISUAL_ID:
    {
      LinkedList<ClassdiagramAbstractNavigatorItem> result = new LinkedList<ClassdiagramAbstractNavigatorItem>();
      ClassdiagramNavigatorGroup incominglinks = new ClassdiagramNavigatorGroup(
          Messages.NavigatorGroupName_AInterface_2001_incominglinks,
          "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
      Collection<View> connectedViews;
      connectedViews = getChildrenByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AInterfaceAnAttributeInterfaceCompartmentEditPart.VISUAL_ID));
      connectedViews = getChildrenByType(connectedViews, ClassdiagramVisualIDRegistry
          .getType(AnAttributeEditPart.VISUAL_ID));
      result.addAll(createNavigatorItems(connectedViews, parentElement, false));
      connectedViews = getChildrenByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AInterfaceAnOperationInterfaceCompartmentEditPart.VISUAL_ID));
      connectedViews = getChildrenByType(connectedViews, ClassdiagramVisualIDRegistry
          .getType(AnOperationEditPart.VISUAL_ID));
      result.addAll(createNavigatorItems(connectedViews, parentElement, false));
      connectedViews = getIncomingLinksByType(Collections.singleton(view), ClassdiagramVisualIDRegistry
          .getType(AClassImplementedInterfacesEditPart.VISUAL_ID));
      incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
      if (!incominglinks.isEmpty())
      {
        result.add(incominglinks);
      }
      return result.toArray();
    }
    }
    return EMPTY_ARRAY;
  }

  /**
   * @generated
   */
  private Collection<View> getLinksSourceByType(Collection edges, String type)
  {
    LinkedList<View> result = new LinkedList<View>();
    for (Iterator it = edges.iterator(); it.hasNext();)
    {
      Edge nextEdge = (Edge)it.next();
      View nextEdgeSource = nextEdge.getSource();
      if (type.equals(nextEdgeSource.getType()) && isOwnView(nextEdgeSource))
      {
        result.add(nextEdgeSource);
      }
    }
    return result;
  }

  /**
   * @generated
   */
  private Collection<View> getLinksTargetByType(Collection edges, String type)
  {
    LinkedList<View> result = new LinkedList<View>();
    for (Iterator it = edges.iterator(); it.hasNext();)
    {
      Edge nextEdge = (Edge)it.next();
      View nextEdgeTarget = nextEdge.getTarget();
      if (type.equals(nextEdgeTarget.getType()) && isOwnView(nextEdgeTarget))
      {
        result.add(nextEdgeTarget);
      }
    }
    return result;
  }

  /**
   * @generated
   */
  private Collection<View> getOutgoingLinksByType(Collection<View> nodes, String type)
  {
    LinkedList<View> result = new LinkedList<View>();
    for (Iterator<View> it = nodes.iterator(); it.hasNext();)
    {
      View nextNode = it.next();
      result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
    }
    return result;
  }

  /**
   * @generated
   */
  private Collection<View> getIncomingLinksByType(Collection<View> nodes, String type)
  {
    LinkedList<View> result = new LinkedList<View>();
    for (Iterator<View> it = nodes.iterator(); it.hasNext();)
    {
      View nextNode = it.next();
      result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
    }
    return result;
  }

  /**
   * @generated
   */
  private Collection<View> getChildrenByType(Collection<View> nodes, String type)
  {
    LinkedList<View> result = new LinkedList<View>();
    for (Iterator<View> it = nodes.iterator(); it.hasNext();)
    {
      View nextNode = it.next();
      result.addAll(selectViewsByType(nextNode.getChildren(), type));
    }
    return result;
  }

  /**
   * @generated
   */
  private Collection getDiagramLinksByType(Collection diagrams, String type)
  {
    Collection result = new ArrayList();
    for (Iterator it = diagrams.iterator(); it.hasNext();)
    {
      Diagram nextDiagram = (Diagram)it.next();
      result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
    }
    return result;
  }

  /**
   * @generated
   */
  private Collection<View> selectViewsByType(Collection<View> views, String type)
  {
    ArrayList<View> result = new ArrayList<View>();
    for (Iterator<View> it = views.iterator(); it.hasNext();)
    {
      View nextView = it.next();
      if (type.equals(nextView.getType()) && isOwnView(nextView))
      {
        result.add(nextView);
      }
    }
    return result;
  }

  /**
   * @generated
   */
  private boolean isOwnView(View view)
  {
    return ClassDiagramEditPart.MODEL_ID.equals(ClassdiagramVisualIDRegistry.getModelID(view));
  }

  /**
   * @generated
   */
  private Collection<ClassdiagramNavigatorItem> createNavigatorItems(Collection<View> views, Object parent,
      boolean isLeafs)
  {
    ArrayList<ClassdiagramNavigatorItem> result = new ArrayList<ClassdiagramNavigatorItem>(views.size());
    for (Iterator<View> it = views.iterator(); it.hasNext();)
    {
      View nextView = it.next();
      result.add(new ClassdiagramNavigatorItem(nextView, parent, isLeafs));
    }
    return result;
  }

  /**
   * @generated
   */
  public Object getParent(Object element)
  {
    if (element instanceof ClassdiagramAbstractNavigatorItem)
    {
      ClassdiagramAbstractNavigatorItem abstractNavigatorItem = (ClassdiagramAbstractNavigatorItem)element;
      return abstractNavigatorItem.getParent();
    }
    return null;
  }

  /**
   * @generated
   */
  public boolean hasChildren(Object element)
  {
    return element instanceof IFile || getChildren(element).length > 0;
  }

}
