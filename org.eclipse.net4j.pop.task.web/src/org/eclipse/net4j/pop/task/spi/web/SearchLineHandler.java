package org.eclipse.net4j.pop.task.spi.web;

/**
 * @author Eike Stepper
 */
public final class SearchLineHandler implements LineHandler
{
  private String search;

  private boolean found;

  public SearchLineHandler(String search)
  {
    this.search = search;
  }

  public String getSearch()
  {
    return search;
  }

  public boolean isFound()
  {
    return found;
  }

  public boolean handleLine(String line)
  {
    System.out.println(line);
    if (line.indexOf(search) != -1)
    {
      found = true;
      return false;
    }

    return true;
  }
}
