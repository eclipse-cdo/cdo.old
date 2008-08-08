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
package org.eclipse.net4j.pop.base;

import org.eclipse.net4j.pop.base.util.Argument;

import java.text.MessageFormat;
import java.util.StringTokenizer;

/**
 * @author Eike Stepper
 */
public final class Version implements Comparable<Version>
{
  private int major;

  private int minor;

  private int micro;

  public Version(int major, int minor, int micro)
  {
    Argument.check(major >= 0, "major");
    Argument.check(minor >= 0, "minor");
    Argument.check(micro >= 0, "micro");
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

  public Version(String version)
  {
    StringTokenizer tokenizer = new StringTokenizer(version, ".");
    if (!tokenizer.hasMoreTokens())
    {
      return;
    }

    major = Integer.parseInt(tokenizer.nextToken());
    if (!tokenizer.hasMoreTokens())
    {
      return;
    }

    minor = Integer.parseInt(tokenizer.nextToken());
    if (!tokenizer.hasMoreTokens())
    {
      return;
    }

    micro = Integer.parseInt(tokenizer.nextToken());
  }

  public static Version parseVersion(String version)
  {
    return new Version(version);
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

  public Version nextMajor(int increment)
  {
    return new Version(major + increment, 0, 0);
  }

  public Version nextMinor(int increment)
  {
    return new Version(major, minor + increment, 0);
  }

  public Version nextMicro()
  {
    return new Version(major, minor, micro + 1);
  }

  public int compareTo(Version o)
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

    if (obj instanceof Version)
    {
      Version that = (Version)obj;
      return major == that.major && minor == that.minor && micro == that.micro;
    }

    return false;
  }

  @Override
  public int hashCode()
  {
    return major * 1000000 ^ minor * 1000 ^ micro;
  }

  public String asId()
  {
    // TODO Provide static helper method for producing id strings
    return MessageFormat.format("{0}_{1}_{2}", major, minor, micro);
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
