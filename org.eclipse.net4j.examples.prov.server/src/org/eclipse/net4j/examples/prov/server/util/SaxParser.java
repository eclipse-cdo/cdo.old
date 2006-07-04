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

import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.InputStream;


public class SaxParser
{
  protected SAXParser parser;

  public SaxParser()
  {
    try
    {
      parser = SAXParserFactory.newInstance().newSAXParser();
    }
    catch (Exception ex)
    {
      ProvServerPlugin.getDefault().error(ex);
    }
  }

  public boolean parse(InputStream is, DefaultHandler handler)
  {
    if (parser == null)
    {
      return false;
    }

    try
    {
      if (handler instanceof LexicalHandler)
      {
        parser.setProperty("http://xml.org/sax/properties/lexical-handler", handler);
      }

      parser.parse(is, handler);
    }
    catch (Exception ex)
    {
      ProvServerPlugin.getDefault().error(ex);
      return false;
    }

    return true;
  }
}
