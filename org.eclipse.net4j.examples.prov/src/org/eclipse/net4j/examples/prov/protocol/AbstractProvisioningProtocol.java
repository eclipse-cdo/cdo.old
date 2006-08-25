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
package org.eclipse.net4j.examples.prov.protocol;


import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.core.impl.AbstractProtocol;
import org.eclipse.net4j.examples.prov.Category;
import org.eclipse.net4j.examples.prov.Feature;
import org.eclipse.net4j.examples.prov.ProvFactory;
import org.eclipse.net4j.examples.prov.ProvisioningProtocol;
import org.eclipse.net4j.examples.prov.Site;

import java.util.List;


public abstract class AbstractProvisioningProtocol extends AbstractProtocol implements
        ProvisioningProtocol
{
  public String getName()
  {
    return PROTOCOL_NAME;
  }

  public static Site receiveSite(Channel channel)
  {
    Site site = ProvFactory.eINSTANCE.createSite();
    receiveFeatures(channel, site.getFeatures());
    receiveCategories(channel, site.getCategories());
    return site;
  }

  public static void receiveCategories(Channel channel, List<Category> categories)
  {
    int count = channel.receiveInt();

    for (int i = 0; i < count; i++)
    {
      String name = channel.receiveString();
      String label = channel.receiveString();
      String description = channel.receiveString();

      Category category = ProvFactory.eINSTANCE.createCategory();
      category.setName(name);
      category.setLabel(label);
      category.setDescription(description);
      categories.add(category);

      receiveFeatures(channel, category.getFeatures());
    }
  }

  public static void receiveFeatures(Channel channel, List<Feature> features)
  {
    int count = channel.receiveInt();

    for (int i = 0; i < count; i++)
    {
      String id = channel.receiveString();
      String version = channel.receiveString();

      Feature feature = ProvFactory.eINSTANCE.createFeature();
      feature.setId(id);
      feature.setVersion(version);
      features.add(feature);
    }
  }

  public static void transmitSite(Channel channel, Site site)
  {
    transmitFeatures(channel, site.getFeatures());
    transmitCategories(channel, site.getCategories());
  }

  public static void transmitCategories(Channel channel, List<Category> categories)
  {
    channel.transmitInt(categories.size());

    for (Category category : categories)
    {
      channel.transmitString(category.getName());
      channel.transmitString(category.getLabel());
      channel.transmitString(category.getDescription());
      transmitFeatures(channel, category.getFeatures());
    }
  }

  public static void transmitFeatures(Channel channel, List<Feature> features)
  {
    channel.transmitInt(features.size());

    for (Feature feature : features)
    {
      channel.transmitString(feature.getId());
      channel.transmitString(feature.getVersion());
    }
  }
}
