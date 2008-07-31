package org.eclipse.net4j.pop.task;

import org.eclipse.core.runtime.IAdaptable;

import java.util.Map;

/**
 * @author Eike Stepper
 */
public interface ITaskRepositoryConnector extends Comparable<ITaskRepositoryConnector>, IAdaptable
{
  public String getName();

  public ITaskRepositoryConfiguration createConfiguration();

  public void validateConfiguration(ITaskRepositoryConfiguration configuration);

  public Map<String, ITaskAttribute> getAttributes();

  public ITaskAttribute getTitleAttribute();

  public ITaskAttribute getStateAttribute();

  public String[] getAttributeChoices(ITaskAttribute attribute);
}
