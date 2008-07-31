package org.eclipse.net4j.pop.task;

import org.eclipse.core.runtime.IAdaptable;

import java.util.List;

/**
 * @author Eike Stepper
 */
public interface ITaskComment extends IAdaptable
{
  public String getID();

  public String getMessage();

  public ITask getTask();

  public ITaskComment getParent();

  public List<ITaskComment> getResponses();

  public ITaskComment addResponse(String message);
}
