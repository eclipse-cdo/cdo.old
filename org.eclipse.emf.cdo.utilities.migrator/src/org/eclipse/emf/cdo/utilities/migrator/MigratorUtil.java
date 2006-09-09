/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.utilities.migrator;


import org.eclipse.net4j.util.eclipse.ResourcesHelper;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MigratorUtil
{
  public static final String CLIENT_PLUGIN_ID = "org.eclipse.emf.cdo.client";

  private static final String CLIENT_PATH = "/" + CLIENT_PLUGIN_ID;

  private static final String ROOT_MODEL_PATH = CLIENT_PATH + "/model/client.ecore";

  private static final String ROOT_GENMODEL_PATH = CLIENT_PATH + "/model/client.genmodel";

  private static final String TEMPLATES_URI = "platform:/resource" + CLIENT_PATH + "/templates";

  /**
   * @return The number of added extensions.<p>
   * @throws CoreException 
   */
  public static int addMappings(String fullPath) throws IOException, CoreException
  {
    ResourceSet resourceSet = new ResourceSetImpl();
    Resource resource = loadResource(resourceSet, fullPath);
    EPackage ePackage = (EPackage)resource.getContents().get(0);

    final String[] content = new String[1];
    IProject project = ResourcesHelper.ROOT.getProject(new Path(fullPath).segment(0));
    IFile file = project.getFile("plugin.xml");
    if (file != null && file.exists())
    {
      content[0] = ResourcesHelper.readFileIntoString(file).trim();
    }
    else
    {
      content[0] = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + // 
              "<?eclipse version=\"3.0\"?>\n" + //
              "<plugin>\n" + //
              "\n" + //
              "</plugin>\n";
    }

    int additions = addPackageMapping(ePackage, content);
    if (additions > 0)
    {
      ResourcesHelper.writeFile(file, content[0], new NullProgressMonitor());
    }

    return additions;
  }

  /**
   * @param content Element 0 contains the whole content and can be modified.<p>
   * @return The number of added extensions.<p>
   */
  private static int addPackageMapping(EPackage ePackage, String[] content)
  {
    int additions = 0;
    String nsURI = ePackage.getNsURI();
    if (nsURI != null && nsURI.length() != 0)
    {
      if (!containsMapping(content[0], nsURI))
      {
        addMapping(content, nsURI, "META-INF/" + ePackage.getName() + ".mapping");
        ++additions;
      }
    }

    EList subpackages = ePackage.getESubpackages();
    for (Iterator it = subpackages.iterator(); it.hasNext();)
    {
      EPackage subpackage = (EPackage)it.next();
      additions += addPackageMapping(subpackage, content);
    }

    return additions;
  }

  private static void addMapping(String[] content, String nsURI, String map)
  {
    content[0] = content[0].replaceFirst("</plugin>",
            "  <extension point=\"org.eclipse.emf.cdo.client.mappings\">\n" + "    <mapping\n"
                    + "       map=\"" + map + "\"\n" + "       uri=\"" + nsURI + "\"/>\n"
                    + "  </extension>\n" + "\n" + "</plugin>");
  }

  private static boolean containsMapping(String content, String nsURI)
  {
    String regex = "<extension[\\s]+point[\\s]*=[\\s]*\"org\\.eclipse\\.emf\\.cdo\\.client\\.mappings\">"
            + "[\\s\\S]*uri[\\s]*=[\\s]*\"" + Pattern.quote(nsURI) + "\"[\\s\\S]*" + //
            "(/>|</mapping>)";

    Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
    Matcher matcher = pattern.matcher(content);
    return matcher.find();
  }

  /**
   * @return <code>true</code> if a modification occured, <code>false</code>
   * otherwise.<p>
   */
  public static boolean migrateGenmodel(String fullPath) throws IOException
  {
    boolean modified = false;
    ResourceSet resourceSet = new ResourceSetImpl();
    GenPackage usedPackage = getCDOGenPackage(resourceSet);

    Resource resource = loadResource(resourceSet, fullPath);
    GenModel genModel = (GenModel)resource.getContents().get(0);

    if (!genModel.getUsedGenPackages().contains(usedPackage))
    {
      genModel.getUsedGenPackages().add(usedPackage);
      modified = true;
    }

    if (!genModel.isDynamicTemplates())
    {
      genModel.setDynamicTemplates(true);
      modified = true;
    }

    if (!TEMPLATES_URI.equals(genModel.getTemplateDirectory()))
    {
      genModel.setTemplateDirectory(TEMPLATES_URI);
      modified = true;
    }

    if (modified)
    {
      resource.save(Collections.EMPTY_MAP);
      return true;
    }

    return false;
  }

  /**
   * @return The number of modifications.<p>
   */
  public static int migrateEcore(String fullPath) throws IOException
  {
    ResourceSet resourceSet = new ResourceSetImpl();
    EClass cdoRootClass = getCDORootClass(resourceSet);

    Resource resource = loadResource(resourceSet, fullPath);
    EPackage ePackage = (EPackage)resource.getContents().get(0);

    int modifications = migrateEcorePackage(ePackage, cdoRootClass);
    if (modifications > 0)
    {
      resource.save(Collections.EMPTY_MAP);
    }

    return modifications;
  }

  /**
   * @return The number of modifications.<p>
   */
  private static int migrateEcorePackage(EPackage ePackage, EClass cdoRootClass)
  {
    int modifications = 0;
    EList classifiers = ePackage.getEClassifiers();
    for (Iterator it = classifiers.iterator(); it.hasNext();)
    {
      EClassifier classifier = (EClassifier)it.next();
      if (classifier instanceof EClass)
      {
        if (migrateEcoreClass((EClass)classifier, cdoRootClass))
        {
          ++modifications;
        }
      }
    }

    EList subpackages = ePackage.getESubpackages();
    for (Iterator it = subpackages.iterator(); it.hasNext();)
    {
      EPackage subpackage = (EPackage)it.next();
      modifications += migrateEcorePackage(subpackage, cdoRootClass);
    }

    return modifications;
  }

  /**
   * @return <code>true</code> if a modification occured, <code>false</code>
   * otherwise.<p>
   */
  private static boolean migrateEcoreClass(EClass eClass, EClass cdoRootClass)
  {
    boolean foundAClass = false;

    EList superTypes = eClass.getESuperTypes();
    for (Iterator it = superTypes.iterator(); it.hasNext();)
    {
      EClass superType = (EClass)it.next();
      if (!superType.isInterface())
      {
        if (superType.getClassifierID() == EcorePackage.EOBJECT)
        {
          it.remove();
        }
        else if (superType == cdoRootClass)
        {
          return false;
        }
        else
        {
          foundAClass = true;
        }
      }
    }

    if (!foundAClass)
    {
      superTypes.add(0, cdoRootClass);
      return true;
    }

    return false;
  }

  private static Resource loadResource(ResourceSet resourceSet, String uri) throws IOException
  {
    Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(uri));
    resource.load(Collections.EMPTY_MAP);
    return resource;
  }

  private static EClass getCDORootClass(ResourceSet resourceSet) throws IOException
  {
    Resource cdoResource = loadResource(resourceSet, ROOT_MODEL_PATH);
    EPackage cdoPackage = (EPackage)cdoResource.getContents().get(0);
    return (EClass)cdoPackage.getEClassifier("CDOPersistent");
  }

  private static GenPackage getCDOGenPackage(ResourceSet resourceSet) throws IOException
  {
    Resource usedResource = loadResource(resourceSet, ROOT_GENMODEL_PATH);
    GenModel usedModel = (GenModel)usedResource.getContents().get(0);
    return (GenPackage)usedModel.getGenPackages().get(0);
  }

  @SuppressWarnings("restriction")
  public static boolean importClientPlugin() throws InvocationTargetException, InterruptedException
  {
    Display display = Display.getCurrent();
    if (display == null)
    {
      display = Display.getDefault();
    }

    Shell shell = display.getActiveShell();

    IPluginModelBase model = findClientPlugin();
    if (model == null)
    {
      MessageDialog.openError(shell, "", "Plugin " + CLIENT_PLUGIN_ID + " not found.");
      return false;
    }

    IRunnableWithProgress op = org.eclipse.pde.internal.ui.wizards.imports.PluginImportWizard
            .getImportOperation(
                    shell,
                    org.eclipse.pde.internal.ui.wizards.imports.PluginImportOperation.IMPORT_WITH_SOURCE,
                    new IPluginModelBase[] {model}, false);
    PlatformUI.getWorkbench().getProgressService().busyCursorWhile(op);
    return true;
  }

  @SuppressWarnings("restriction")
  private static IPluginModelBase findClientPlugin()
  {
    org.eclipse.pde.internal.core.PluginModelManager manager = org.eclipse.pde.internal.core.PDECore
            .getDefault().getModelManager();
    IPluginModelBase[] models = manager.getExternalModels();
    //    ArrayList<String> names = new ArrayList<String>();
    for (IPluginModelBase model : models)
    {
      String name = model.getBundleDescription().getName();
      //      names.add(name);

      if (CLIENT_PLUGIN_ID.equals(name))
      {
        return model;
      }
    }

    //    Collections.sort(names);
    //    for (String name : names)
    //    {
    //      System.out.println(name);
    //    }

    return null;
  }
}
