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


import org.eclipse.emf.cdo.client.CdoResource;
import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.example.client.CdoExampleClientPlugin;
import org.eclipse.emf.cdo.example.library.Author;
import org.eclipse.emf.cdo.example.library.Book;
import org.eclipse.emf.cdo.example.library.EBook;
import org.eclipse.emf.cdo.example.library.Library;
import org.eclipse.emf.cdo.example.library.LibraryFactory;
import org.eclipse.emf.cdo.example.library.Topic;
import org.eclipse.emf.cdo.example.library.ui.internal.CdoExampleLibraryUiActivator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;


/**
 * Our sample action implements workbench action delegate.
 * The action proxy will be created by the workbench and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be 
 * delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class CreateResourceAction implements IWorkbenchWindowActionDelegate
{
  /**
   * The constructor.
   */
  public CreateResourceAction()
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
      createResource();
    }
    catch (Throwable t)
    {
      t.printStackTrace();
    }
  }

  private void createResource() throws Exception
  {
    // Create an EMF ResourceSet and associate it with a CDO ResourceManager.
    System.out
            .println("--> TEST: Create an EMF ResourceSet and associate it with a CDO ResourceManager");
    ResourceSet resourceSet = new ResourceSetImpl();
    ResourceManager resourceManager = CdoExampleClientPlugin.createResourceManager(resourceSet);

    // Create a new CDO Resource.
    System.out.println("--> TEST: Create a new CDO Resource");
    CdoResource resource = (CdoResource)resourceSet.createResource(URI
            .createURI(CdoExampleLibraryUiActivator.RESOURCE_URI1));

    // Populate the resource with an example model.
    System.out.println("--> TEST: Populate the resource with an example model");

    Book book1 = LibraryFactory.eINSTANCE.createBook();
    book1.setTitle("Book 1");
    book1.setNumberOfPages(42);

    EBook book2 = LibraryFactory.eINSTANCE.createEBook();
    book2.setTitle("Book 2");
    book2.setNumberOfPages(4711);
    book2.setUrl("http://www.foo.org/bar.html");

    Author author1 = LibraryFactory.eINSTANCE.createAuthor();
    author1.setName("Albert Einstein");
    author1.getBooks().add(book1);
    author1.getBooks().add(book2);

    Author author2 = LibraryFactory.eINSTANCE.createAuthor();
    author2.setName("Karl Dall");
    author2.getBooks().add(book2);

    Topic topic1 = LibraryFactory.eINSTANCE.createTopic();
    topic1.setName("Special");
    topic1.getBooks().add(book1);

    Topic topic2 = LibraryFactory.eINSTANCE.createTopic();
    topic2.setName("Miscellaneous");
    topic2.getBooks().add(book2);

    Topic topic0 = LibraryFactory.eINSTANCE.createTopic();
    topic0.setName("General");
    topic0.getTopics().add(topic1);
    topic0.getTopics().add(topic2);

    Library library = LibraryFactory.eINSTANCE.createLibrary();
    library.getAuthors().add(author1);
    library.getAuthors().add(author2);
    library.getTopics().add(topic0);

    resource.getContents().add(library);

    // Create a second CDO Resource.
    System.out.println("--> TEST: Create a second CDO Resource");
    CdoResource resource2 = (CdoResource)resourceSet.createResource(URI
            .createURI(CdoExampleLibraryUiActivator.RESOURCE_URI2));

    // Populate the second resource with an example model.
    System.out.println("--> TEST: Populate the second resource with an example model");

    Book book = LibraryFactory.eINSTANCE.createBook();
    book.setTitle("Cross Book");
    book.setNumberOfPages(815);
    book.getAuthors().add(author1);
    book.getAuthors().add(author2);

    Library library2 = LibraryFactory.eINSTANCE.createLibrary();
    library2.getBooks().add(book);

    resource2.getContents().add(library2);

    // Commit the changes to the database.
    System.out.println("--> TEST: Commit the changes to the database");
    resourceManager.commit();
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
