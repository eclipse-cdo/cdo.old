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


import org.eclipse.net4j.examples.prov.server.DateFormatter;
import org.eclipse.net4j.spring.ValidationException;
import org.eclipse.net4j.spring.impl.ServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public class SimpleDateFormatter extends ServiceImpl implements DateFormatter
{
  protected String pattern;

  protected String timeZone;

  protected Locale locale;

  private transient SimpleDateFormat simpleDateFormat;

  public String format(Date date)
  {
    return simpleDateFormat.format(date);
  }

  public String getPattern()
  {
    return pattern;
  }

  public void setPattern(String pattern)
  {
    doSet("pattern", pattern);
  }

  public String getTimeZone()
  {
    return timeZone;
  }

  public void setTimeZone(String timeZone)
  {
    doSet("timeZone", timeZone);
  }

  public Locale getLocale()
  {
    return locale;
  }

  public void setLocale(Locale locale)
  {
    doSet("locale", locale);
  }

  protected void validate() throws ValidationException
  {
    super.validate();
    assertNotNull("pattern");
    simpleDateFormat = new SimpleDateFormat(pattern, locale);

    if (timeZone != null)
    {
      simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
    }
  }
}
