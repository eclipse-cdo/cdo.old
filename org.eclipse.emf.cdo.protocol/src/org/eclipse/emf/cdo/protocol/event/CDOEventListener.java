package org.eclipse.emf.cdo.protocol.event;

import java.util.EventListener;

/**
 * @author Eike Stepper
 */
public interface CDOEventListener extends EventListener
{
  public void notifyCDOEvent(CDOEvent event);
}