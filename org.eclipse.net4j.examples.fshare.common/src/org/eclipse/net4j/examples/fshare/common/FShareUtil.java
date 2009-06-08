package org.eclipse.net4j.examples.fshare.common;

/**
 * @author Eike Stepper
 */
public final class FShareUtil
{
  public static final char SLASH = '/';

  private FShareUtil()
  {
  }

  public static String[] splitPathFirst(String path)
  {
    if (path.length() != 0 && path.charAt(0) == SLASH)
    {
      path = path.substring(1);
    }

    int slash = path.indexOf(SLASH);
    if (slash == -1)
    {
      return new String[] { path, null };
    }

    return new String[] { path.substring(0, slash), path.substring(slash + 1) };
  }

  public static String[] splitPathLast(String path)
  {
    if (path.length() != 0 && path.charAt(0) == SLASH)
    {
      path = path.substring(1);
    }

    int slash = path.lastIndexOf(SLASH);
    if (slash == -1)
    {
      return new String[] { null, path };
    }

    return new String[] { path.substring(0, slash), path.substring(slash + 1) };
  }
}
