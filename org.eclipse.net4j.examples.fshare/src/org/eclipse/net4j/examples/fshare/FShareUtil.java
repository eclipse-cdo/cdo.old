package org.eclipse.net4j.examples.fshare;

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
    int slash = path.indexOf(SLASH);
    if (slash == -1)
    {
      return new String[] { path, null };
    }

    return new String[] { path.substring(0, slash), path.substring(slash + 1) };
  }

  public static String[] splitPathLast(String path)
  {
    int slash = path.lastIndexOf(SLASH);
    if (slash == -1)
    {
      return new String[] { null, path };
    }

    return new String[] { path.substring(0, slash), path.substring(slash + 1) };
  }
}
