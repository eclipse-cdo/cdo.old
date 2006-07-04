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
package org.eclipse.net4j.examples.prov.server.impl;


import org.eclipse.net4j.examples.prov.server.UrlCodec;
import org.eclipse.net4j.spring.ValidationException;
import org.eclipse.net4j.spring.impl.ServiceImpl;
import org.eclipse.net4j.util.ImplementationError;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;


public class UrlCodecImpl extends ServiceImpl implements UrlCodec
{
  protected String charset;

  public String decode(String string)
  {
    try
    {
      return URLDecoder.decode(string, charset);
    }
    catch (UnsupportedEncodingException ex)
    {
      throw new ImplementationError("Charset " + charset + " has been tested before", ex);
    }
  }

  public String encode(String string)
  {
    try
    {
      return URLEncoder.encode(string, charset);
    }
    catch (UnsupportedEncodingException ex)
    {
      throw new ImplementationError("Charset " + charset + " has been tested before", ex);
    }
  }

  public String getCharset()
  {
    return charset;
  }

  public void setCharset(String charset)
  {
    doSet("charset", charset);
  }

  protected void validate() throws ValidationException
  {
    super.validate();
    assertNotNull("charset");

    try
    {
      final String v = "dummy";
      String v1 = URLEncoder.encode(v, charset);
      String v2 = URLDecoder.decode(v1, charset);

      if (!v.equals(v2))
      {
        // Should never happen
        throw new ValidationException("Charset not bijective: " + charset);
      }
    }
    catch (UnsupportedEncodingException ex)
    {
      throw new ValidationException("Unsupported Charset " + charset, ex);
    }
  }
}
