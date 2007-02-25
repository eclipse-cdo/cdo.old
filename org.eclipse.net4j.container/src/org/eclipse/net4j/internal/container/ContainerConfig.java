package org.eclipse.net4j.internal.container;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Eike Stepper
 */
public final class ContainerConfig implements Serializable
{
  private static final long serialVersionUID = 1L;

  private Set<String> acceptorDescriptions = new HashSet();

  private Set<String> connectorDescriptions = new HashSet();

  private Map<String, Set<String>> adapterConfigs = new HashMap();

  public ContainerConfig()
  {
  }

  public Set<String> getAcceptorDescriptions()
  {
    return acceptorDescriptions;
  }

  public Set<String> getConnectorDescriptions()
  {
    return connectorDescriptions;
  }

  public Map<String, Set<String>> getAdapterConfigs()
  {
    return adapterConfigs;
  }
}