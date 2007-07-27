/***************************************************************************
 * Copyright (c) 2004 - 2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.internal.weaver;

import org.aspectj.weaver.ExtensibleURLClassLoader;
import org.aspectj.weaver.tools.WeavingAdaptor;
import org.aspectj.weaver.tools.WeavingClassLoader;

import java.io.IOException;
import java.net.URL;
import java.security.CodeSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class CDOWeaverURLClassLoader extends ExtensibleURLClassLoader implements WeavingClassLoader
{
  private URL[] aspectURLs;

  private WeavingAdaptor adaptor;

  private Map generatedClasses = new HashMap(); /* String -> byte[] */

  public CDOWeaverURLClassLoader(URL[] classURLs, URL[] aspectURLs, ClassLoader parent)
  {
    super(classURLs, parent);
    this.aspectURLs = aspectURLs;
    adaptor = new WeavingAdaptor(this);
  }

  public URL[] getAspectURLs()
  {
    return aspectURLs;
  }

  public void acceptClass(String name, byte[] bytes)
  {
    generatedClasses.put(name, bytes);
  }

  @Override
  protected void addURL(URL url)
  {
    adaptor.addURL(url);
    super.addURL(url);
  }

  @Override
  protected Class defineClass(String name, byte[] b, CodeSource cs) throws IOException
  {
    byte[] newb = adaptor.weaveClass(name, b);
    if (!Arrays.equals(b, newb))
    {
      woven(name, newb, cs);
      b = newb;
    }

    return super.defineClass(name, b, cs);
  }

  protected void woven(String name, byte[] newb, CodeSource cs)
  {
  }

  /**
   * Override to find classes generated by WeavingAdaptor
   */
  @Override
  protected byte[] getBytes(String name) throws IOException
  {
    byte[] bytes = super.getBytes(name);
    if (bytes == null)
    {
      return (byte[])generatedClasses.remove(name);
    }

    return bytes;
  }
}
