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
package org.eclipse.net4j.examples.prov.server.impl;


import org.eclipse.net4j.core.Executor;
import org.eclipse.net4j.core.ITempManager;
import org.eclipse.net4j.core.Task;
import org.eclipse.net4j.examples.prov.Category;
import org.eclipse.net4j.examples.prov.Feature;
import org.eclipse.net4j.examples.prov.ProvFactory;
import org.eclipse.net4j.examples.prov.Site;
import org.eclipse.net4j.examples.prov.server.ProvException;
import org.eclipse.net4j.examples.prov.server.ProvServerPlugin;
import org.eclipse.net4j.examples.prov.server.SiteManager;
import org.eclipse.net4j.examples.prov.server.util.FileSystemSilencer;
import org.eclipse.net4j.examples.prov.server.util.SaxHandler;
import org.eclipse.net4j.examples.prov.server.util.SaxParser;
import org.eclipse.net4j.spring.ValidationException;
import org.eclipse.net4j.spring.impl.ServiceImpl;
import org.eclipse.net4j.util.IOHelper;
import org.eclipse.net4j.util.StringHelper;
import org.eclipse.net4j.util.UnderlyingIOException;
import org.eclipse.net4j.util.eclipse.ResourcesHelper;
import org.eclipse.net4j.util.thread.Worker;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.internal.adaptor.IModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.osgi.framework.util.Headers;
import org.eclipse.osgi.service.resolver.VersionRange;
import org.eclipse.osgi.util.ManifestElement;
import org.eclipse.pde.core.plugin.IMatchRules;
import org.eclipse.pde.internal.core.plugin.PluginBase;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;
import org.osgi.framework.Version;
import org.xml.sax.helpers.AttributesImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


public class SiteManagerImpl extends ServiceImpl implements SiteManager
{
  public static final long DEFAULT_FILE_SYSTEM_MONITOR_INTERVAL = 1000;

  private long fileSystemMonitorInterval = DEFAULT_FILE_SYSTEM_MONITOR_INTERVAL;

  private Executor incomingExecutor;

  private ITempManager tempManager;

  private transient IFolder rootFolder;

  private transient IFolder incomingFolder;

  private transient IFolder pluginsFolder;

  private transient IFolder featuresFolder;

  private transient Site site;

  private transient FileSystemMonitor fileSystemMonitor;

  public long getFileSystemMonitorInterval()
  {
    return fileSystemMonitorInterval;
  }

  public void setFileSystemMonitorInterval(long fileSystemMonitorInterval)
  {
    doSet("fileSystemMonitorInterval", fileSystemMonitorInterval);

  }

  public Executor getIncomingExecutor()
  {
    return incomingExecutor;
  }

  public void setIncomingExecutor(Executor incomingExecutor)
  {
    doSet("incomingExecutor", incomingExecutor);
  }

  public ITempManager getTempManager()
  {
    return tempManager;
  }

  public void setTempManager(ITempManager tempManager)
  {
    doSet("tempManager", tempManager);
  }

  public Site getSite()
  {
    return site;
  }

  public Feature getFeature(String id, String version)
  {
    for (Iterator categoryIt = getSite().getCategories().iterator(); categoryIt.hasNext();)
    {
      Category category = (Category)categoryIt.next();

      for (Iterator featureIt = category.getFeatures().iterator(); featureIt.hasNext();)
      {
        Feature feature = (Feature)featureIt.next();

        if (StringHelper.equals(feature.getId(), id)
                && StringHelper.equals(feature.getVersion(), version))
        {
          return feature;
        }
      }
    }

    return null;
  }

  public InputStream getFeatureContent(String id, String version) throws CoreException
  {
    Feature feature = getFeature(id, version);
    return getFeatureContent(feature);
  }

  public InputStream getFeatureContent(Feature feature) throws CoreException
  {
    IFile file = getFeaturesFolder().getFile(new Path(feature.getUrl()));

    try
    {
      return file.getContents();
    }
    catch (CoreException ex)
    {
      file.refreshLocal(IResource.DEPTH_ZERO, new NullProgressMonitor());
      return file.getContents();
    }
  }

  public void setCategories(List<Category> categories)
  {
    IProgressMonitor monitor = new NullProgressMonitor();

    for (Category category : (List<Category>)getSite().getCategories())
    {
      String fileName = category.getName() + ".category";
      IFile file = getRootFolder().getFile(fileName);

      try
      {
        file.delete(true, monitor);
      }
      catch (CoreException ex)
      {
        error("Could not delete file " + file.getFullPath(), ex);
      }
    }

    getSite().getCategories().clear();

    ResourceSet resourceSet = new ResourceSetImpl();
    Map map = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
    map.put("category", new XMLResourceFactoryImpl());

    for (Category category : categories)
    {
      String fileName = category.getName() + ".category";
      IFile file = getRootFolder().getFile(fileName);

      URI uri = URI.createPlatformResourceURI(file.getFullPath().toString());
      Resource resource = resourceSet.createResource(uri);
      resource.getContents().add(category);

      try
      {
        resource.save(Collections.EMPTY_MAP);
      }
      catch (IOException ex)
      {
        error("Could not save file " + file.getFullPath(), ex);
      }

      getSite().getCategories().add(category);
    }
  }

  public String generateManifest()
  {
    StringBuffer buffer = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
    buffer.append("<site>\n");
    generateFeatures(buffer);
    generateCategories(buffer);
    buffer.append("</site>\n");
    return buffer.toString();
  }

  private void generateCategories(StringBuffer buffer)
  {
    buffer.append("   <category-def name=\"all\" label=\"All Features\">");
    buffer.append("This category is automatically generated to show all available features.");
    buffer.append("</category-def>\n");

    for (Iterator categoryIt = getSite().getCategories().iterator(); categoryIt.hasNext();)
    {
      Category category = (Category)categoryIt.next();
      buffer.append("   <category-def name=\"");
      buffer.append(category.getName());
      buffer.append("\" label=\"");
      buffer.append(category.getLabel());
      buffer.append("\"");

      if (category.getDescription() == null)
      {
        buffer.append(" />\n");
      }
      else
      {
        buffer.append(">");
        buffer.append(category.getDescription());
        buffer.append("</category-def>\n");
      }
    }
  }

  private void generateFeatures(StringBuffer buffer)
  {
    for (Iterator featureIt = site.getFeatures().iterator(); featureIt.hasNext();)
    {
      Feature feature = (Feature)featureIt.next();
      generateFeature(feature, buffer);
    }
  }

  /*
   * @ADDED
   */
  private void generateFeature(Feature feature, StringBuffer buffer)
  {
    buffer.append("   <feature url=\"features/");
    buffer.append(feature.getId());
    buffer.append("_");
    buffer.append(feature.getVersion());
    buffer.append(".jar\" patch=\"false\" id=\"");
    buffer.append(feature.getId());
    buffer.append("\" version=\"");
    buffer.append(feature.getVersion());
    buffer.append("\">\n");

    buffer.append("      <category name=\"all\" />\n");

    for (Iterator categoryIt = getSite().getCategories(feature.getId(), feature.getVersion())
            .iterator(); categoryIt.hasNext();)
    {
      Category category = (Category)categoryIt.next();
      buffer.append("      <category name=\"");
      buffer.append(category.getName());
      buffer.append("\" />\n");
    }

    buffer.append("   </feature>\n");
  }

  public IFolder getRootFolder()
  {
    if (rootFolder == null)
    {
      rootFolder = ensureFolder(ProvServerPlugin.getProject(), ProvServerPlugin.DOCUMENT_ROOT_NAME);
    }

    return rootFolder;
  }

  public IFolder getIncomingFolder()
  {
    if (incomingFolder == null)
    {
      incomingFolder = ensureFolder(ProvServerPlugin.getProject(), INCOMING_FOLDER);
    }

    return incomingFolder;
  }

  public IFolder getPluginsFolder()
  {
    if (pluginsFolder == null)
    {
      pluginsFolder = ensureFolder(getRootFolder(), PLUGINS_FOLDER);
    }

    return pluginsFolder;
  }

  public IFolder getFeaturesFolder()
  {
    if (featuresFolder == null)
    {
      featuresFolder = ensureFolder(getRootFolder(), FEATURES_FOLDER);
    }

    return featuresFolder;
  }

  public Feature[] addResource(File file, String name)
  {
    FileSystemSilencer.waitForSilence(file);

    if (isDebugEnabled()) debug("Start processing resource: " + name);
    long start = System.currentTimeMillis();
    IncomingState incomingState = new IncomingState();
    File temp = null;

    if (file.isFile())
    {
      if (name.endsWith("zip"))
      {
        temp = addArchive(file, incomingState);
      }
      else if (name.endsWith("jar"))
      {
        processFile(file, incomingState);
      }
      else if (name.endsWith("category"))
      {
        addCategory(file);
      }
    }
    else if (file.isDirectory())
    {
      processFile(file, incomingState);
    }

    if (!incomingState.hasFeature() && incomingState.hasPlugin())
    {
      try
      {
        Feature autoFeature = generateAutoFeature(file, incomingState);
        incomingState.getFeatures().add(autoFeature);
      }
      catch (Exception ex)
      {
        warn("Problem while generating an AutoFeature", ex);
      }
    }

    try
    {
      getRootFolder().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
    }
    catch (Exception ex)
    {
      warn("Problem while refreshing document root " + getRootFolder(), ex);
    }

    initSite();

    tempManager.release(temp);
    IOHelper.deleteFile(file);

    long time = System.currentTimeMillis() - start;
    if (isDebugEnabled()) debug("Finished processing resource: " + name + " (" + time + " msec)");

    List<Feature> features = incomingState.getFeatures();
    return features.toArray(new Feature[features.size()]);
  }

  private File addArchive(File file, IncomingState incomingState)
  {
    String zipName = StringHelper.removeSuffix(file.getName(), ".zip");
    File temp = tempManager.createTempFolder("archive");

    File targetFolder = new File(temp, zipName);
    targetFolder.mkdirs();

    String targetPath = targetFolder.getAbsolutePath();
    IOHelper.unzip(file.getAbsolutePath(), targetPath);

    processFile(targetFolder, incomingState);

    return temp;
  }

  private void processFile(File file, IncomingState incomingState)
  {
    String features = getFeaturesFolder().getLocation().toString();
    String plugins = getPluginsFolder().getLocation().toString();

    if (file.isDirectory())
    {
      if (new File(file, "feature.xml").exists())
      {
        if (isDebugEnabled()) debug("Adding feature " + file.getName());

        try
        {
          incomingState.addFeature(new FileInputStream(new File(file, "feature.xml")));
        }
        catch (FileNotFoundException ignore)
        {
          // Can't happen
        }

        File target = new File(features, file.getName() + ".jar");
        IOHelper.jar(file, target, true);
      }
      else if (new File(file, "plugin.xml").exists())
      {
        if (isDebugEnabled()) debug("Adding plugin " + file.getName());
        incomingState.addPlugin(file);
        File target = new File(plugins, file.getName() + ".jar");
        IOHelper.jar(file, target, true);
      }
      else if (new File(file, "fragment.xml").exists())
      {
        if (isDebugEnabled()) debug("Adding fragment " + file.getName());
        incomingState.addPlugin(file);
        File target = new File(plugins, file.getName() + ".jar");
        IOHelper.jar(file, target, true);
      }
      else
      {
        File manifestFile = new File(file, "META-INF/MANIFEST.MF");
        if (manifestFile.exists())
        {
          InputStream is = null;
          try
          {
            is = new FileInputStream(manifestFile);
            Headers headers = Headers.parseManifest(is);

            if (headers.get(Constants.BUNDLE_SYMBOLICNAME) != null)
            {
              if (headers.get(Constants.FRAGMENT_HOST) != null)
              {
                if (isDebugEnabled()) debug("Adding fragment " + file.getName());
              }
              else
              {
                if (isDebugEnabled()) debug("Adding plugin " + file.getName());
              }

              incomingState.addPlugin(file);
              File target = new File(plugins, file.getName() + ".jar");
              IOHelper.jar(file, target, true);
            }
            else
            {
              manifestFile = null;
            }
          }
          catch (Exception ignore)
          {
          }
          finally
          {
            IOHelper.close(is);
          }
        }
        else
        {
          manifestFile = null;
        }

        if (manifestFile == null)
        {
          File[] children = file.listFiles();
          for (int i = 0; i < children.length; i++)
          {
            File child = children[i];
            processFile(child, incomingState);
          }
        }
      }
    }
    else if (file.isFile())
    {
      if (file.getName().endsWith(".jar"))
      {
        processJar(file, incomingState);
      }
    }
  }

  private void processJar(File file, IncomingState incomingState)
  {
    String features = getFeaturesFolder().getLocation().toString();
    String plugins = getPluginsFolder().getLocation().toString();
    JarFile jarFile = null;
    JarEntry entry = null;

    try
    {
      File target = null;
      jarFile = new JarFile(file);

      entry = jarFile.getJarEntry("feature.xml");
      if (entry != null)
      {
        String name = StringHelper.removeSuffix(file.getName(), ".jar");
        if (isDebugEnabled()) debug("Adding feature " + name);
        incomingState.addFeature(jarFile.getInputStream(entry));
        target = new File(features, file.getName());
      }
      else
      {
        entry = jarFile.getJarEntry("plugin.xml");
        if (entry != null)
        {
          String name = StringHelper.removeSuffix(file.getName(), ".jar");
          if (isDebugEnabled()) debug("Adding plugin " + name);
          incomingState.addPlugin(file);
          target = new File(plugins, file.getName());
        }
        else
        {
          entry = jarFile.getJarEntry("fragment.xml");
          if (entry != null)
          {
            String name = StringHelper.removeSuffix(file.getName(), ".jar");
            if (isDebugEnabled()) debug("Adding fragment " + name);
            incomingState.addPlugin(file);
            target = new File(plugins, file.getName());
          }
          else
          {
            entry = jarFile.getJarEntry("META-INF/MANIFEST.MF");
            if (entry != null)
            {
              InputStream is = null;

              try
              {
                is = jarFile.getInputStream(entry);
                Headers headers = Headers.parseManifest(is);

                if (headers.get(Constants.BUNDLE_SYMBOLICNAME) != null)
                {
                  if (headers.get(Constants.FRAGMENT_HOST) != null)
                  {
                    if (isDebugEnabled()) debug("Adding fragment " + file.getName());
                  }
                  else
                  {
                    if (isDebugEnabled()) debug("Adding plugin " + file.getName());
                  }

                  // String name = StringHelper.removeSuffix(file.getName(), ".jar");
                  incomingState.addPlugin(file);
                  target = new File(plugins, file.getName());
                }
              }
              catch (Exception ignore)
              {
              }
              finally
              {
                IOHelper.close(is);
              }
            }
          }
        }
      }

      if (target != null)
      {
        IOHelper.copy(file, target);
      }
    }
    catch (IOException ex)
    {
      throw new UnderlyingIOException("Error while analyzing jarfile " + file, ex);
    }
    finally
    {
      if (jarFile != null)
      {
        try
        {
          jarFile.close();
        }
        catch (IOException ex)
        {
          warn("Problem while closing jar " + file, ex);
        }
      }
    }
  }

  private Feature generateAutoFeature(File file, IncomingState incomingState) throws IOException
  {
    String resourceName = file.getName();
    resourceName = StringHelper.removeSuffix(resourceName, ".jar");
    resourceName = StringHelper.removeSuffix(resourceName, ".zip");

    String id;
    String version;

    int lastUnderscore = resourceName.lastIndexOf('_');
    if (lastUnderscore != -1)
    {
      id = resourceName.substring(0, lastUnderscore);
      version = resourceName.substring(lastUnderscore + 1);

      try
      {
        Version.parseVersion(version);
      }
      catch (Exception ex)
      {
        id = resourceName;
        version = "1.0.0";
      }
    }
    else
    {
      id = resourceName;
      version = "1.0.0";
    }

    AutoFeature feature = new AutoFeature(id, new Version(version));
    for (File pluginFile : incomingState.getPlugins())
    {
      if (feature.addPlugin(pluginFile) == null)
      {
        warn("Plugin or fragment not added: " + pluginFile);
      }
    }

    String name = feature.getId() + "_" + feature.getVersion();

    if (isDebugEnabled())
    {
      debug("Generating feature " + name);
    }

    File temp = null;

    try
    {
      temp = tempManager.createTempFolder("feature");
      File folder = new File(temp, name);
      folder.mkdirs();

      File manifestFile = new File(folder, "feature.xml");
      feature.writeManifest(manifestFile);

      File target = new File(getFeaturesFolder().getLocation().toString(), name + ".jar");
      IOHelper.jar(folder, target, true);
    }
    finally
    {
      tempManager.release(temp);
    }

    Feature result = ProvFactory.eINSTANCE.createFeature();
    result.setId(id);
    result.setVersion(version);
    return result;
  }

  private void addCategory(File file)
  {
    try
    {
      Category category = loadCategory(file);
      if (isDebugEnabled()) debug("Adding category " + category.getName());

      InputStream fis = new FileInputStream(file);
      IFile target = getRootFolder().getFile(file.getName());

      if (target.exists())
      {
        target.setContents(fis, true, false, new NullProgressMonitor());
      }
      else
      {
        target.create(fis, true, new NullProgressMonitor());
      }
    }
    catch (Exception ex)
    {
      error("Could not add category file " + file, ex);
    }
  }

  protected void activate() throws Exception
  {
    super.activate();
    fileSystemMonitor = new FileSystemMonitor(getIncomingFolder(), IResource.DEPTH_ONE,
            getFileSystemMonitorInterval());
    fileSystemMonitor.setDaemon(true);
    fileSystemMonitor.startup();
  }

  protected void deactivate() throws Exception
  {
    fileSystemMonitor.shutdown(200);
    fileSystemMonitor = null;
    super.deactivate();
  }

  protected void validate() throws ValidationException
  {
    super.validate();
    assertNotNull("incomingExecutor");
    assertNotNull("tempManager");

    getPluginsFolder();
    getFeaturesFolder();

    // IFolder folder = getIncomingFolder();
    // IOHelper.deleteFile(new File(folder.getLocation().toString()));

    initSite();
  }

  private static IFolder ensureFolder(IContainer container, String path)
  {
    try
    {
      return ResourcesHelper.ensureFolder(container, path);
    }
    catch (CoreException ex)
    {
      throw new ProvException(
              "Error while creating folder " + container.getLocation() + "/" + path, ex);
    }
  }

  private void initSite() throws ValidationException
  {
    site = ProvFactory.eINSTANCE.createSite();
    site.setName("Density Update Site");

    try
    {
      initFeatures();
      initCategories();
    }
    catch (Exception ex)
    {
      throw new ValidationException("Error while initializing site", ex);
    }
  }

  private void initCategories() throws ValidationException, IOException, CoreException
  {
    IFolder folder = getRootFolder();
    for (int i = 0; i < folder.members().length; i++)
    {
      IResource member = folder.members()[i];
      if (member instanceof IFile && member.getName().endsWith(".category"))
      {
        initCategory((IFile)member);
      }
    }
  }

  private void initCategory(IFile file) throws ValidationException, IOException
  {
    Category category = loadCategory(new File(file.getLocation().toString()));
    site.getCategories().add(category);
  }

  private Category loadCategory(File file) throws IOException
  {
    ResourceSet resourceSet = new ResourceSetImpl();
    Map map = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
    map.put("category", new XMLResourceFactoryImpl());

    URI uri = URI.createFileURI(file.getAbsolutePath());
    Resource resource = resourceSet.getResource(uri, true);
    resource.load(Collections.EMPTY_MAP);

    Category category = (Category)resource.getContents().get(0);
    return category;
  }

  private void initFeatures() throws ValidationException, CoreException
  {
    IFolder folder = getFeaturesFolder();
    for (int i = 0; i < folder.members().length; i++)
    {
      IResource member = folder.members()[i];
      if (member instanceof IFile && member.getFileExtension().equals("jar"))
      {
        initFeature((IFile)member);
      }
    }
  }

  private void initFeature(IFile file) throws ValidationException
  {
    String name = file.getName();
    int lastUnderscore = name.lastIndexOf('_');

    if (lastUnderscore == -1)
    {
      throw new ValidationException("Feature archive has invalid filename " + name);
    }

    String id = name.substring(0, lastUnderscore);
    String version = name.substring(lastUnderscore + 1, name.lastIndexOf('.'));

    site.addFeature(id, version);
  }

  private class FileSystemMonitor extends Worker implements IResourceChangeListener
  {
    private IContainer container;

    private int depth;

    private long interval;

    private transient IProgressMonitor monitor = new NullProgressMonitor();

    private transient boolean inResourceChanged;

    public FileSystemMonitor(IContainer container, int depth, long interval)
    {
      super(getFullBeanName() + ".FileSystemMonitor");
      this.container = container;
      this.depth = depth;
      this.interval = interval;

      ResourcesPlugin.getWorkspace().addResourceChangeListener(this,
              IResourceChangeEvent.POST_CHANGE);
    }

    @Override
    protected long doWorkStep(int progress)
    {
      if (!inResourceChanged)
      {
        try
        {
          if (container != null)
          {
            container.refreshLocal(depth, monitor);
          }
        }
        catch (CoreException ex)
        {
          error("Error while refreshing container " + container.getLocation().toString(), ex);
          return TERMINATE;
        }
      }

      return interval;
    }

    public void resourceChanged(IResourceChangeEvent event)
    {
      if (event.getType() != IResourceChangeEvent.POST_CHANGE)
      {
        return;
      }

      IResourceDelta delta = event.getDelta().findMember(container.getFullPath());
      if (delta == null)
      {
        return;
      }

      inResourceChanged = true;

      IResourceDelta[] children = delta.getAffectedChildren(IResourceDelta.ADDED);
      for (int i = 0; i < children.length; i++)
      {
        IResource child = children[i].getResource();
        onResourceAdded(child);
      }

      inResourceChanged = false;
    }

    public void onResourceAdded(IResource resource)
    {
      String prefix = container.getFullPath().toString() + "/";
      String path = resource.getFullPath().toString() + (resource instanceof IContainer ? "/" : "");
      String name = StringHelper.removePrefix(path, prefix);

      if (isDebugEnabled()) debug("Detected incoming resource: " + name);

      try
      {
        Task task = new IncomingTask(new File(resource.getLocation().toString()), name);
        incomingExecutor.execute(task, null);
      }
      catch (Exception ex)
      {
        error("Error while executing IncomingTask for resource " + resource, ex);
      }
    }
  }

  private class IncomingTask implements Task
  {
    private File file;

    private String name;

    public IncomingTask(File file, String name)
    {
      this.file = file;
      this.name = name;
    }

    public void execute() throws Exception
    {
      addResource(file, name);
    }
  }

  private static class IncomingState
  {
    private List<Feature> features = new ArrayList<Feature>();

    private List<File> plugins = new ArrayList<File>();

    public void addFeature(InputStream is)
    {
      try
      {
        Analzyer handler = new Analzyer();
        SaxParser parser = new SaxParser();
        parser.parse(is, handler);
      }
      finally
      {
        IOHelper.close(is);
      }
    }

    public void addFeature(String id, String version)
    {
      Feature feature = ProvFactory.eINSTANCE.createFeature();
      feature.setId(id);
      feature.setVersion(version);
      features.add(feature);
    }

    public List<Feature> getFeatures()
    {
      return features;
    }

    public boolean hasFeature()
    {
      return !features.isEmpty();
    }

    public void addPlugin(File file)
    {
      plugins.add(file);
    }

    public List<File> getPlugins()
    {
      return plugins;
    }

    public boolean hasPlugin()
    {
      return !plugins.isEmpty();
    }

    private class Analzyer extends SaxHandler
    {
      protected void handleStart(String[] context, String name, AttributesImpl attributes)
              throws Exception
      {
        if (matchContext(context, name, "/feature"))
        {
          String id = getAttribute(attributes, "id");
          String version = getAttribute(attributes, "version");
          addFeature(id, version);
        }

        super.handleStart(context, name, attributes);
      }
    }
  }

  /**
   * 
   */
  public static class IdAndVersion
  {
    private String id;

    private Version version;

    public IdAndVersion(String id, Version version)
    {
      if (id == null || id.length() == 0)
      {
        throw new IllegalArgumentException("id == null || id.length() == 0");
      }

      this.id = id;
      this.version = version;
    }

    public String getId()
    {
      return id;
    }

    public Version getVersion()
    {
      return version;
    }

    public boolean equals(Object obj)
    {
      if (obj == null || !(obj instanceof IdAndVersion))
      {
        return false;
      }

      IdAndVersion that = (IdAndVersion)obj;
      return StringHelper.equals(this.id, that.id)
              && StringHelper.equals(this.version, that.version);
    }

    public int hashCode()
    {
      return id.hashCode() ^ version.hashCode();
    }
  }

  /**
   * 
   */
  public static class WithIdAndVersion
  {
    private IdAndVersion idAndVersion;

    public WithIdAndVersion(String id, Version version)
    {
      idAndVersion = new IdAndVersion(id, version);
    }

    public String getId()
    {
      return idAndVersion.getId();
    }

    public Version getVersion()
    {
      return idAndVersion.getVersion();
    }

    public IdAndVersion getIdAndVersion()
    {
      return idAndVersion;
    }
  }

  /**
   * 
   */
  public static class AutoFeature extends WithIdAndVersion
  {
    private Map<IdAndVersion, AutoPlugin> plugins = new HashMap<IdAndVersion, AutoPlugin>();

    public AutoFeature(String id, Version version)
    {
      super(id, version);
    }

    private Set<String> getDependencies()
    {
      Set<String> result = new HashSet<String>();

      for (AutoPlugin plugin : plugins.values())
      {
        for (ListIterator<AutoDependency> it = plugin.getDependencies().listIterator(); it
                .hasNext();)
        {
          AutoDependency dependency = it.next();

          if (!hasPlugin(dependency.getId(), dependency.getVersionRange()))
          {
            result.add(dependency.toString());
          }
        }
      }

      return result;
    }

    private boolean hasPlugin(String id, VersionRange versionRange)
    {
      for (AutoPlugin plugin : plugins.values())
      {
        if (StringHelper.equals(id, plugin.getId())
                && (versionRange == null || versionRange.isIncluded(plugin.getVersion())))
        {
          return true;
        }
      }

      return false;
    }

    public void writeManifest(File file) throws FileNotFoundException
    {
      PrintWriter writer = null;

      try
      {
        writer = new PrintWriter(file);
        writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        writer.println();

        writer.println("<feature");
        writer.println("   id=\"" + getId() + "\"");
        writer.println("   label=\"" + getId() + "\"");
        writer.println("   version=\"" + getVersion() + "\"");
        writer.println("   provider-name=\"\">");
        writer.println();

        writer.println("   <description url=\"http://www.yourdomain.com/description\">");
        writeManifestDescription(writer);
        writer.println("   </description>");
        writer.println();

        writer.println("   <copyright url=\"http://www.yourdomain.com/copyright\">");
        writer.println("The copyrights of the contained plugins and fragments apply.");
        writer.println();
        writeManifestDescription(writer);
        writer.println("   </copyright>");
        writer.println();

        writer.println("   <license url=\"http://www.yourdomain.com/license\">");
        writer.println("The licenses of the contained plugins and fragments apply.");
        writer.println();
        writeManifestDescription(writer);
        writer.println("   </license>");
        writer.println();

        writer.println("   <requires>");
        for (String dependency : getDependencies())
        {
          writer.println("      " + dependency);
        }
        writer.println("   </requires>");
        writer.println();

        for (AutoPlugin plugin : plugins.values())
        {
          writer.println("   <plugin");
          writer.println("      id=\"" + plugin.getId() + "\"");
          writer.println("      download-size=\"0\"");
          writer.println("      install-size=\"0\"");
          writer.println("      version=\"" + plugin.getVersion() + "\"/>");
          writer.println();
        }

        writer.println("</feature>");
        writer.flush();
      }
      finally
      {
        IOHelper.close(writer);
      }
    }

    private void writeManifestDescription(PrintWriter writer)
    {
      writer.println("This feature was automatically generated to contain");
      writer.println("the following plugins and fragments:");
      writer.println();
      for (AutoPlugin plugin : plugins.values())
      {
        writer.println("      " + plugin.getId() + " " + plugin.getVersion());
      }
    }

    public AutoPlugin addPlugin(File file)
    {
      boolean isJar = file.isFile() && file.getName().endsWith(".jar");
      AutoPlugin plugin = null;
      InputStream is = null;

      try
      {
        is = getInputStream(file, isJar, "META-INF/MANIFEST.MF");
        plugin = readManifest(is);
      }
      catch (Exception ignore)
      {
      }
      finally
      {
        IOHelper.close(is);
      }

      if (plugin == null)
      {
        try
        {
          is = getInputStream(file, isJar, "plugin.xml");
          plugin = readPlugin(is, false);
        }
        catch (IOException ignore)
        {
        }
        finally
        {
          IOHelper.close(is);
        }
      }

      if (plugin == null)
      {
        try
        {
          is = getInputStream(file, isJar, "fragment.xml");
          plugin = readPlugin(is, true);
        }
        catch (IOException ignore)
        {
        }
        finally
        {
          IOHelper.close(is);
        }
      }

      if (plugin != null)
      {
        plugins.put(plugin.getIdAndVersion(), plugin);
      }

      return plugin;
    }

    public AutoPlugin addPlugin(String id, Version version, boolean isFragment)
    {
      AutoPlugin plugin = new AutoPlugin(id, version, isFragment);
      plugins.put(plugin.getIdAndVersion(), plugin);
      return plugin;
    }

    public AutoPlugin getPlugin(String id, Version version)
    {
      AutoPlugin plugin = plugins.get(new IdAndVersion(id, version));
      return plugin;
    }

    public Map<IdAndVersion, AutoPlugin> getPlugins()
    {
      return plugins;
    }

    private InputStream getInputStream(File file, boolean isJar, String entry) throws IOException
    {
      if (isJar)
      {
        URL url = new URL("jar:file:/" + file.getAbsolutePath() + "!/" + entry);
        JarURLConnection connection = (JarURLConnection)url.openConnection();
        return connection.getInputStream();
      }
      else
      {
        return new FileInputStream(new File(file, entry));
      }
    }

    private AutoPlugin readManifest(InputStream is) throws IOException, BundleException
    {
      Headers headers = Headers.parseManifest(is);
      String id = (String)headers.get(Constants.BUNDLE_SYMBOLICNAME);
      String version = (String)headers.get(Constants.BUNDLE_VERSION);

      if (id == null)
      {
        return null;
      }

      int semicolon = id.indexOf(';');
      if (semicolon != -1)
      {
        id = id.substring(0, semicolon);
      }

      if (version == null)
      {
        return null;
      }

      String fragmentHost = (String)headers.get(Constants.REQUIRE_BUNDLE);
      AutoPlugin plugin = addPlugin(id, new Version(version), fragmentHost != null);

      String requires = (String)headers.get(Constants.REQUIRE_BUNDLE);
      if (requires != null && requires.length() > 0)
      {
        ManifestElement[] elements = ManifestElement
                .parseHeader(Constants.REQUIRE_BUNDLE, requires);
        for (int i = 0; i < elements.length; i++)
        {
          ManifestElement element = elements[i];
          String depId = element.getValue();
          String attr = element.getAttribute(Constants.BUNDLE_VERSION_ATTRIBUTE);
          VersionRange depVersionRange = attr == null ? null : new VersionRange(attr);
          plugin.addDependency(depId, depVersionRange);
        }
      }

      return plugin;
    }

    private AutoPlugin readPlugin(InputStream is, boolean isFragment)
    {
      Analzyer handler = new Analzyer(isFragment);
      SaxParser parser = new SaxParser();
      parser.parse(is, handler);
      return handler.getPlugin();
    }

    /**
     * Copied from org.eclipse.core.runtime.adaptor.PluginConverterImpl.
     * 
     * @param reqVersion
     * @param matchRule
     * @return
     */
    private VersionRange getVersionRange(String reqVersion, String matchRule)
    {
      if (reqVersion == null) return null;

      Version minVersion = Version.parseVersion(reqVersion);

      if (matchRule != null)
      {
        if (matchRule.equalsIgnoreCase(IModel.PLUGIN_REQUIRES_MATCH_PERFECT))
        {
          return new VersionRange(minVersion, true, minVersion, true);
        }
        else if (matchRule.equalsIgnoreCase(IModel.PLUGIN_REQUIRES_MATCH_EQUIVALENT))
        {
          return new VersionRange(minVersion, true, new Version(minVersion.getMajor(), minVersion
                  .getMinor() + 1, 0, ""), false); //$NON-NLS-1$
        }
        else if (matchRule.equalsIgnoreCase(IModel.PLUGIN_REQUIRES_MATCH_COMPATIBLE))
        {
          return new VersionRange(minVersion, true,
                  new Version(minVersion.getMajor() + 1, 0, 0, ""), false); //$NON-NLS-1$
        }
        else if (matchRule.equalsIgnoreCase(IModel.PLUGIN_REQUIRES_MATCH_GREATER_OR_EQUAL))
        {
          // just return the reqVersion here without any version range
          return new VersionRange(reqVersion);
        }
        else
        {
          return new VersionRange(minVersion, true,
                  new Version(minVersion.getMajor() + 1, 0, 0, ""), false); //$NON-NLS-1$
        }
      }
      else
      {
        return new VersionRange(minVersion, true,
                new Version(minVersion.getMajor() + 1, 0, 0, ""), false); //$NON-NLS-1$
      }
    }

    private class Analzyer extends SaxHandler
    {
      private boolean isFragment;

      private AutoPlugin plugin;

      public Analzyer(boolean isFragment)
      {
        this.isFragment = isFragment;
      }

      protected void handleStart(String[] context, String name, AttributesImpl attributes)
              throws Exception
      {
        String root = isFragment ? "/fragment" : "/plugin";

        if (matchContext(context, name, root))
        {
          String id = getAttribute(attributes, "id");
          String version = getAttribute(attributes, "version");
          plugin = addPlugin(id, new Version(version), isFragment);

          if (isFragment)
          {
            String pluginId = getAttribute(attributes, "plugin-id");
            String pluginVersion = getAttribute(attributes, "plugin-version");
            String matchRule = getAttribute(attributes, "match");

            plugin.addDependency(pluginId, getVersionRange(pluginVersion, matchRule));
          }
        }
        else if (matchContext(context, name, root + "/requires/import"))
        {
          String id = getAttribute(attributes, "plugin");
          String version = getAttribute(attributes, "version");
          String matchRule = getAttribute(attributes, "match");

          plugin.addDependency(id, getVersionRange(version, matchRule));
        }

        super.handleStart(context, name, attributes);
      }

      public AutoPlugin getPlugin()
      {
        return plugin;
      }
    }
  }

  /**
   * 
   */
  public static class AutoPlugin extends WithIdAndVersion
  {
    private boolean isFragment;

    private List<AutoDependency> dependencies = new ArrayList<AutoDependency>();

    public AutoPlugin(String id, Version version, boolean isFragment)
    {
      super(id, version);
      this.isFragment = isFragment;
    }

    public AutoDependency addDependency(String id, VersionRange versionRange)
    {
      AutoDependency dependency = new AutoDependency(id, versionRange);
      dependencies.add(dependency);
      return dependency;
    }

    public List<AutoDependency> getDependencies()
    {
      return dependencies;
    }

    public boolean isFragment()
    {
      return isFragment;
    }
  }

  /**
   * 
   */
  public static class AutoDependency
  {
    private String id;

    private VersionRange versionRange;

    public AutoDependency(String id, VersionRange versionRange)
    {
      if (id == null || id.length() == 0)
      {
        throw new IllegalArgumentException("id == null || id.length() == 0");
      }

      this.id = id;
      this.versionRange = versionRange;
    }

    public String getId()
    {
      return id;
    }

    public VersionRange getVersionRange()
    {
      return versionRange;
    }

    public String toString()
    {
      StringBuffer buffer = new StringBuffer();
      buffer.append("<import plugin=\"");
      buffer.append(id);
      buffer.append("\"");

      if (versionRange != null)
      {
        buffer.append(" version=\"");
        buffer.append(versionRange.getMinimum().toString());
        buffer.append("\"");

        int matchId = PluginBase.getMatchRule(versionRange);
        String match = null;

        switch (matchId)
        {
        case IMatchRules.GREATER_OR_EQUAL:
          match = IMatchRules.RULE_GREATER_OR_EQUAL;
          break;
        case IMatchRules.COMPATIBLE:
          match = IMatchRules.RULE_COMPATIBLE;
          break;
        case IMatchRules.EQUIVALENT:
          match = IMatchRules.RULE_EQUIVALENT;
          break;
        case IMatchRules.PERFECT:
          match = IMatchRules.RULE_PERFECT;
          break;
        }

        if (match != null)
        {
          buffer.append(" match=\"");
          buffer.append(match);
          buffer.append("\"");
        }
      }

      buffer.append("/>");
      return buffer.toString();
    }
  }
}
