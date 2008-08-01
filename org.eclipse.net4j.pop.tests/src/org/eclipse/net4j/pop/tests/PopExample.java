/**
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 * 
 *
 * $Id: PopExample.java,v 1.3 2008-08-01 07:53:25 estepper Exp $
 */
package org.eclipse.net4j.pop.tests;

import org.eclipse.net4j.pop.PopFactory;
import org.eclipse.net4j.pop.PopPackage;
import org.eclipse.net4j.pop.StreamManager;
import org.eclipse.net4j.pop.util.PopResourceFactoryImpl;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.RootXMLContentHandlerImpl;

import java.io.File;
import java.io.IOException;

/**
 * <!-- begin-user-doc --> A sample utility for the '<em><b>pop</b></em>' package. <!-- end-user-doc -->
 * 
 * @generated
 */
public class PopExample
{
  /**
   * <!-- begin-user-doc --> Load all the argument file paths or URIs as instances of the model. <!-- end-user-doc -->
   * 
   * @param args
   *          the file paths or URIs.
   * @generated NOT
   */
  public static void main(String[] args)
  {
    // Create a resource set to hold the resources.
    //
    ResourceSet resourceSet = new ResourceSetImpl();

    StreamManager streamManager = PopFactory.eINSTANCE.createStreamManager();

    // Register the appropriate resource factory to handle the content type.
    //
    resourceSet.getResourceFactoryRegistry().getContentTypeToFactoryMap().put(PopPackage.eCONTENT_TYPE,
        new PopResourceFactoryImpl(streamManager));

    // Register the appropriate content handler for all file extensions and any element from the package's namespace.
    //
    resourceSet.getURIConverter().getContentHandlers().add(
        new RootXMLContentHandlerImpl(PopPackage.eCONTENT_TYPE, null, null, PopPackage.eNS_URI, null));

    // Register the package to ensure it is available during loading.
    //
    resourceSet.getPackageRegistry().put(PopPackage.eNS_URI, PopPackage.eINSTANCE);

    // If there are no arguments, emit an appropriate usage message.
    //
    if (args.length == 0)
    {
      System.out.println("Enter a list of file paths or URIs that have content like this:");
      try
      {
        Resource resource = resourceSet.createResource(URI.createURI("http:///My.pop"), PopPackage.eCONTENT_TYPE);
        StreamManager root = PopFactory.eINSTANCE.createStreamManager();
        resource.getContents().add(root);
        resource.save(System.out, null);
      }
      catch (IOException exception)
      {
        exception.printStackTrace();
      }
    }
    else
    {
      // Iterate over all the arguments.
      //
      for (int i = 0; i < args.length; ++i)
      {
        // Construct the URI for the instance file.
        // The argument is treated as a file path only if it denotes an existing file.
        // Otherwise, it's directly treated as a URL.
        //
        File file = new File(args[i]);
        URI uri = file.isFile() ? URI.createFileURI(file.getAbsolutePath()) : URI.createURI(args[0]);

        try
        {
          // Demand load resource for this file.
          //
          Resource resource = resourceSet.getResource(uri, true);
          System.out.println("Loaded " + uri);

          // Validate the contents of the loaded resource.
          //
          for (EObject eObject : resource.getContents())
          {
            Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
            if (diagnostic.getSeverity() != Diagnostic.OK)
            {
              printDiagnostic(diagnostic, "");
            }
          }
        }
        catch (RuntimeException exception)
        {
          System.out.println("Problem loading " + uri);
          exception.printStackTrace();
        }
      }
    }
  }

  /**
   * <!-- begin-user-doc --> Prints diagnostics with indentation. <!-- end-user-doc -->
   * 
   * @param diagnostic
   *          the diagnostic to print.
   * @param indent
   *          the indentation for printing.
   * @generated
   */
  protected static void printDiagnostic(Diagnostic diagnostic, String indent)
  {
    System.out.print(indent);
    System.out.println(diagnostic.getMessage());
    for (Diagnostic child : diagnostic.getChildren())
    {
      printDiagnostic(child, indent + "  ");
    }
  }

} // PopExample
