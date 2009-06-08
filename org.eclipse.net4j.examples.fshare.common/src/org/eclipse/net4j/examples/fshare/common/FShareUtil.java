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
    path = trimPath(path);
    int slash = path.indexOf(SLASH);
    if (slash == -1)
    {
      return new String[] { path, null };
    }

    return new String[] { path.substring(0, slash), path.substring(slash + 1) };
  }

  public static String[] splitPathLast(String path)
  {
    path = trimPath(path);
    int slash = path.lastIndexOf(SLASH);
    if (slash == -1)
    {
      return new String[] { null, path };
    }

    return new String[] { path.substring(0, slash), path.substring(slash + 1) };
  }

  private static String trimPath(String path)
  {
    int length = path.length();
    if (length != 0 && path.charAt(0) == SLASH)
    {
      path = path.substring(1);
    }

    if (length != 0 && path.charAt(length - 1) == SLASH)
    {
      path = path.substring(0, length - 1);
    }

    return path;
  }
}
