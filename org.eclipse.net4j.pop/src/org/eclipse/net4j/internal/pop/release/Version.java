/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.internal.pop.release;

import org.eclipse.net4j.internal.pop.util.Element;
import org.eclipse.net4j.pop.release.IVersion;

import org.eclipse.core.runtime.PlatformObject;

import java.text.MessageFormat;

/**
 * @author Eike Stepper
 */
public class Version extends PlatformObject implements IVersion
{
  private int major;

  private int minor;

  private int micro;

  public Version(int major, int minor, int micro)
  {
    Element.checkArgument(major >= 0, "major");
    Element.checkArgument(minor >= 0, "minor");
    Element.checkArgument(micro >= 0, "micro");
    this.major = major;
    this.minor = minor;
    this.micro = micro;
  }

  public Version(int major, int minor)
  {
    this(major, minor, 0);
  }

  public Version(int major)
  {
    this(major, 0);
  }

  public Version()
  {
    this(0);
  }

  public int getMajor()
  {
    return major;
  }

  public int getMinor()
  {
    return minor;
  }

  public int getMicro()
  {
    return micro;
  }

  public boolean isMajor()
  {
    return !isMinor() && major != 0;
  }

  public boolean isMinor()
  {
    return !isMicro() && minor != 0;
  }

  public boolean isMicro()
  {
    return micro != 0;
  }

  public IVersion nextMajor(int increment)
  {
    return new Version(major + increment, 0, 0);
  }

  public IVersion nextMinor(int increment)
  {
    return new Version(major, minor + increment, 0);
  }

  public IVersion nextMicro()
  {
    return new Version(major, minor, micro + 1);
  }

  public int compareTo(IVersion o)
  {
    // TODO Implement Version.compareTo(o)
    throw new UnsupportedOperationException("Not yet implemented");
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj == this)
    {
      return true;
    }

    if (obj instanceof IVersion)
    {
      IVersion that = (IVersion)obj;
      return major == that.getMajor() && minor == that.getMinor() && micro == that.getMicro();
    }

    return false;
  }

  @Override
  public int hashCode()
  {
    return major * 1000000 ^ minor * 1000 ^ micro;
  }

  public String toString(boolean forceMicro)
  {
    if (micro != 0 || forceMicro)
    {
      return MessageFormat.format("{0}.{1}.{2}", major, minor, micro);
    }

    return MessageFormat.format("{0}.{1}", major, minor);
  }

  @Override
  public String toString()
  {
    return toString(false);
  }
}
