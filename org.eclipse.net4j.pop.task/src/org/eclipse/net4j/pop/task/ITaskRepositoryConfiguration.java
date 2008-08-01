package org.eclipse.net4j.pop.task;

import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.INotifier;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.equinox.security.storage.ISecurePreferences;
import org.eclipse.equinox.security.storage.StorageException;

/**
 * @author Eike Stepper
 */
public interface ITaskRepositoryConfiguration extends INotifier, IAdaptable
{
  public ITaskRepositoryConnector getConnector();

  public ITaskRepositoryConfiguration copy();

  public void load(ISecurePreferences preferences) throws StorageException;

  public void save(ISecurePreferences preferences) throws StorageException;

  /**
   * @author Eike Stepper
   */
  public interface IConfigurationChangedEvent extends IEvent
  {
    public ITaskRepositoryConfiguration getConfiguration();
  }
}
