package org.eclipse.emf.cdo.client.protocol;


import org.eclipse.net4j.core.Channel;


public interface CdoResListener
{
  public void notifyResourceAdded(Channel channel, int rid, String path);

  public void notifyResourceRemoved(Channel channel, int rid, String path);
}
