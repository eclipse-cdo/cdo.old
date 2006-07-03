package org.eclipse.net4j.core;


import org.eclipse.net4j.spring.Service;

import java.io.File;


public interface ITempManager extends Service
{
  public File createTempFile(String prefix, String suffix);

  public File createTempFile(String prefix);

  public File createTempFile();

  public File createTempFolder(String prefix, String suffix);

  public File createTempFolder(String prefix);

  public File createTempFolder();

  public void release(File temp);
}
