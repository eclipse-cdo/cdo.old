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
package org.eclipse.net4j.examples.prov.server;


import org.eclipse.net4j.examples.prov.Category;
import org.eclipse.net4j.examples.prov.Feature;
import org.eclipse.net4j.examples.prov.Site;
import org.eclipse.net4j.spring.Service;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;

import java.io.File;
import java.io.InputStream;
import java.util.List;


public interface SiteManager extends Service
{
  public static final String INCOMING_FOLDER = "incoming";

  public static final String PLUGINS_FOLDER = "plugins";

  public static final String FEATURES_FOLDER = "features";

  public static final String CATEGORY_EXTENSION = "category";

  public IFolder getRootFolder();

  public IFolder getFeaturesFolder();

  public IFolder getPluginsFolder();

  public IFolder getIncomingFolder();

  public Site getSite();

  public Feature getFeature(String id, String version);

  public InputStream getFeatureContent(String id, String version) throws CoreException;

  public InputStream getFeatureContent(Feature feature) throws CoreException;

  public String generateManifest();

  public Feature[] addResource(File file, String name);

  public void setCategories(List<Category> categories);
}
