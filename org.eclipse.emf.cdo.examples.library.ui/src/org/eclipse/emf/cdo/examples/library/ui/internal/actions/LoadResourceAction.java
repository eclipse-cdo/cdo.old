/*******************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Sympedia Methods and Tools.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.cdo.example.library.ui.internal.actions;


import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.example.client.internal.ExampleClientPlugin;
import org.eclipse.emf.cdo.example.library.Author;
import org.eclipse.emf.cdo.example.library.Book;
import org.eclipse.emf.cdo.example.library.Library;
import org.eclipse.emf.cdo.example.library.ui.internal.ExampleLibraryUIActivator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import java.util.Iterator;


/**
 * Our sample action implements workbench action delegate.
 * The action proxy will be created by the workbench and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be 
 * delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class LoadResourceAction implements IWorkbenchWindowActionDelegate
{
  /**
   * The constructor.
   */
  public LoadResourceAction()
  {
  }

  /**
   * The action has been activated. The argument of the
   * method represents the 'real' action sitting
   * in the workbench UI.
   * @see IWorkbenchWindowActionDelegate#run
   */
  public void run(IAction action)
  {
    try
    {
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      loadResource();
    }
    catch (Throwable t)
    {
      t.printStackTrace();
    }
  }

  private void loadResource() throws Exception
  {
    // Create an EMF ResourceSet and associate it with a CDO ResourceManager.
    System.out
            .println("--> TEST: Create an EMF ResourceSet and associate it with a CDO ResourceManager");
    ResourceSet resourceSet = new ResourceSetImpl();
    ResourceManager resourceManager = ExampleClientPlugin.createResourceManager(resourceSet);

    // Load a CDO Resource.
    System.out.println("--> TEST: Load a CDO Resource");
    CDOResource resource = (CDOResource)resourceSet.getResource(URI
            .createURI(ExampleLibraryUIActivator.RESOURCE_URI1), true);

    // Populate the model from the resource.
    System.out.println("--> TEST: Populate the model from the resource");
    Library library = (Library)resource.getContents().get(0);

    Iterator it = library.getAuthors().iterator();
    for (; it.hasNext();)
    {
      Author author = (Author)it.next();
      System.out.println(author.getName());
    }

    // Load a second CDO Resource.
    System.out.println("--> TEST: Load a second CDO Resource");
    CDOResource resource2 = (CDOResource)resourceSet.getResource(URI
            .createURI(ExampleLibraryUIActivator.RESOURCE_URI2), true);

    // Populate the model from the second resource.
    System.out.println("--> TEST: Populate the model from the second resource");
    Library library2 = (Library)resource2.getContents().get(0);

    Book book = (Book)library2.getBooks().get(0);
    System.out.println(book.getTitle());

    for (Iterator iter = book.getAuthors().iterator(); iter.hasNext();)
    {
      Author author = (Author)iter.next();
      System.out.println(author.getName());
    }

    resourceManager.stop();
  }

  public void dispose()
  {
  }

  public void init(IWorkbenchWindow window)
  {
  }

  public void selectionChanged(IAction action, ISelection selection)
  {
  }
}
