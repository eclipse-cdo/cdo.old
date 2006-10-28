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
package org.eclipse.emf.cdo.core.util.extensions;


import org.eclipse.net4j.util.om.trace.ContextTracer;

import org.eclipse.emf.cdo.core.ImplementationError;
import org.eclipse.emf.cdo.core.internal.CDOCore;
import org.eclipse.emf.cdo.core.util.StringHelper;
import org.eclipse.emf.cdo.core.util.extensions.Element.Factory;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ExtensionParser
{
  protected Map<Pattern, Factory> elementDataFactoryRegistry = new HashMap<Pattern, Factory>();

  protected List<String> contextStack = new ArrayList<String>();

  private static final ContextTracer TRACER = new ContextTracer(CDOCore.DEBUG_EXTENSION,
      ExtensionParser.class);

  public void parse(String extPointId)
  {
    IExtensionRegistry registry = Platform.getExtensionRegistry();
    IExtensionPoint point = registry.getExtensionPoint(extPointId);

    if (point == null)
    {
      CDOCore.LOG.error("Extension point '" + extPointId + "' does not exist.");
      return;
    }

    parse(point);
  }

  public void parse(IExtensionPoint point)
  {
    IExtension[] extensions = point.getExtensions();
    for (int i = 0; extensions != null && i < extensions.length; i++)
    {
      try
      {
        parse(extensions[i]);
      }
      catch (Throwable t)
      {
        String msg = "Error in plugin " + extensions[i].getNamespaceIdentifier()
            + " while reading extension to " + point.getUniqueIdentifier();
        CDOCore.LOG.error(msg, t);
      }
    }
  }

  public Element[] parse(IExtension extension)
  {
    if (TRACER.isEnabled())
    {
      TRACER.trace(this, "Parsing plugin " + extension.getNamespaceIdentifier()
          + " (extension-point = " + extension.getExtensionPointUniqueIdentifier() + ")");
    }

    IConfigurationElement[] elems = extension.getConfigurationElements();
    return parse(elems);
  }

  public Element[] parse(IConfigurationElement[] elems)
  {
    Element[] result = new Element[elems.length];

    for (int i = 0; i < elems.length; i++)
    {
      IConfigurationElement elem = elems[i];
      result[i] = parse(elem);
    }

    if (TRACER.isEnabled())
    {
      TRACER.trace(this, "All extension data: " + StringHelper.implode(result, ", "));
    }

    return result;
  }

  public Element parse(IConfigurationElement elem)
  {
    pushContext(elem.getName());
    String context = getContextString();

    Element.Factory factory = findFactory(context);
    if (factory == null)
      throw new ExtensionConfigException("No element factory for context " + context);

    Element elementData = factory.createElementData();
    if (elementData == null)
      throw new ExtensionConfigException("No element created for context " + context);
    elementData.internalSetConfigurationElement(elem);

    String[] attributeNames = elem.getAttributeNames();
    for (int i = 0; i < attributeNames.length; i++)
    {
      String attributeName = attributeNames[i];
      String attributeValue = elem.getAttribute(attributeName);

      if (TRACER.isEnabled())
      {
        TRACER.trace(this, "Dispatching " + context + "." + attributeName + " = " + attributeValue);
      }

      elementData.dispatchAttributeValue(attributeName, attributeValue);
    }

    // Recurse
    for (int i = 0; i < elem.getChildren().length; i++)
    {
      IConfigurationElement child = elem.getChildren()[i];
      Element childData = parse(child);
      elementData.dispatchChild(child.getName(), childData);
    }

    popContext();
    validate(elementData);
    return elementData;
  }

  public void addFactory(String contextPattern, Factory factory)
  {
    Pattern pattern = Pattern.compile(contextPattern);
    elementDataFactoryRegistry.put(pattern, factory);
  }

  public Factory findFactory(String context)
  {
    for (Map.Entry<Pattern, Factory> entry : elementDataFactoryRegistry.entrySet())
    {
      Pattern pattern = entry.getKey();
      Matcher matcher = pattern.matcher(context);
      if (matcher.matches())
      {
        return entry.getValue();
      }
    }

    return null;
  }

  protected void pushContext(String elementName)
  {
    contextStack.add(elementName);
  }

  protected String popContext()
  {
    if (contextStack.isEmpty()) throw new ImplementationError("contextStack is empty");
    return contextStack.remove(contextStack.size() - 1);
  }

  protected String getContextString()
  {
    return StringHelper.implode(contextStack, "/");
  }

  protected void validate(Element elementData)
  {
    elementData.validate(this);
  }
}
