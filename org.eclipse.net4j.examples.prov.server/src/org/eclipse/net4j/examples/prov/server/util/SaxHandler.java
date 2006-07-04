/***************************************************************************
 * Copyright (c) 2004-2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.examples.prov.server.util;


import org.eclipse.net4j.examples.prov.server.ProvServerPlugin;
import org.eclipse.net4j.util.StringHelper;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;


public class SaxHandler extends DefaultHandler implements LexicalHandler
{
  protected Locator locator;

  private ContextStack contextStack = new ContextStack();

  public SaxHandler()
  {
  }

  public void setDocumentLocator(Locator locator)
  {
    this.locator = locator;
  }

  public void startElement(String uri, String localName, String qName, Attributes attributes)
          throws SAXException
  {
    AttributesImpl impl = new AttributesImpl(attributes);
    String[] context = contextStack.getContext();
    contextStack.push(qName, impl);

    try
    {
      handleStart(context, qName, impl);
    }
    catch (Exception ex)
    {
      ProvServerPlugin.getDefault().error(ex);
      throw new SAXException("Error while handling startElement", ex);
    }
  }

  public void endElement(String uri, String localName, String qName) throws SAXException
  {
    try
    {
      AttributesImpl impl = contextStack.getAttributes();
      contextStack.pop();
      String[] context = contextStack.getContext();
      handleEnd(context, qName, impl);
    }
    catch (Exception ex)
    {
      ProvServerPlugin.getDefault().error(ex);
      throw new SAXException("Error while handling endElement", ex);
    }
  }

  public void characters(char[] ch, int start, int length) throws SAXException
  {
    try
    {
      handleCharacters(String.valueOf(ch, start, length));
    }
    catch (Exception ex)
    {
      ProvServerPlugin.getDefault().error(ex);
      throw new SAXException("Error while handling characters", ex);
    }
  }

  public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException
  {
    try
    {
      handleCharacters(String.valueOf(ch, start, length));
    }
    catch (Exception ex)
    {
      ProvServerPlugin.getDefault().error(ex);
      throw new SAXException("Error while handling ignorableWhitespace", ex);
    }
  }

  public void comment(char[] ch, int start, int length) throws SAXException
  {
    try
    {
      handleCharacters("<!--" + String.valueOf(ch, start, length) + "-->");
    }
    catch (Exception ex)
    {
      ProvServerPlugin.getDefault().error(ex);
      throw new SAXException("Error while handling comment", ex);
    }
  }

  public void startDTD(String name, String publicId, String systemId) throws SAXException
  {
    System.out.println("Ignoring startDTD");
  }

  public void endDTD() throws SAXException
  {
    System.out.println("Ignoring startDTD");
  }

  public void startEntity(String name) throws SAXException
  {
    System.out.println("Ignoring startDTD");
  }

  public void endEntity(String name) throws SAXException
  {
    System.out.println("Ignoring startDTD");
  }

  public void startCDATA() throws SAXException
  {
    System.out.println("Ignoring startDTD");
  }

  public void endCDATA() throws SAXException
  {
    System.out.println("Ignoring startDTD");
  }

  protected void handleStart(String[] context, String name, AttributesImpl attributes)
          throws Exception
  {
  }

  protected void handleEnd(String[] context, String name, AttributesImpl attributes)
          throws Exception
  {
  }

  protected void handleCharacters(String chars) throws Exception
  {
  }

  protected String getAttribute(AttributesImpl attributes, String name)
  {
    return attributes.getValue(name);
  }

  protected void setAttribute(AttributesImpl attributes, String name, String value)
  {
    int index = attributes.getIndex(name);
    try
    {
      attributes.setValue(index, value);
    }
    catch (Exception ignore)
    {
    }
  }

  protected boolean matchContext(String[] context, String elementName, String compare)
  {
    if (compare.startsWith("/"))
    {
      String[] array = compare.substring(1).split("/");

      if (array.length != context.length + 1)
      {
        return false;
      }

      for (int i = 0; i < array.length; i++)
      {
        String compareElement = array[i];
        String contextElement = i < context.length ? context[i] : elementName;

        if (!StringHelper.equals(compareElement, contextElement))
        {
          return false;
        }
      }
    }
    else
    {
      String[] array = (compare + "/" + elementName).split("/");

      if (array.length > context.length + 1)
      {
        return false;
      }

      for (int i = array.length; i > 0; --i)
      {
        String compareElement = array[i];
        String contextElement = i < context.length ? context[i] : elementName;

        if (!StringHelper.equals(compareElement, contextElement))
        {
          return false;
        }
      }
    }

    return true;
  }

  private static class ContextStack
  {
    private Stack<String> elementStack = new Stack<String>();

    private Stack<AttributesImpl> attributesStack = new Stack<AttributesImpl>();

    public void push(String element, AttributesImpl attributes)
    {
      elementStack.push(element);
      attributesStack.push(attributes);
    }

    public void pop()
    {
      attributesStack.pop();
      elementStack.pop();
    }

    public String getElement()
    {
      return elementStack.peek();
    }

    public AttributesImpl getAttributes()
    {
      return attributesStack.peek();
    }

    public String[] getContext()
    {
      return elementStack.toArray(new String[elementStack.size()]);
    }
  }
}
