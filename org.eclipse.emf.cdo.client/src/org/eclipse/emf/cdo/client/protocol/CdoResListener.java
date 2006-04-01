package org.eclipse.emf.cdo.client.protocol;


import org.eclipse.net4j.core.Channel;

import org.eclipse.emf.cdo.core.protocol.ResourceChangeInfo;

import java.util.List;


public interface CdoResListener
{
  public void notifyResourcesChanged(Channel channel, List<ResourceChangeInfo> infos);
}
