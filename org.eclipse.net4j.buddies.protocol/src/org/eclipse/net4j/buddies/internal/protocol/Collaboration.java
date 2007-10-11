/***************************************************************************
 * Copyright (c) 2004 - 2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.buddies.internal.protocol;

import org.eclipse.net4j.buddies.internal.protocol.bundle.OM;
import org.eclipse.net4j.buddies.protocol.IBuddy;
import org.eclipse.net4j.buddies.protocol.ICollaboration;
import org.eclipse.net4j.buddies.protocol.IFacility;
import org.eclipse.net4j.buddies.protocol.IFacilityInstalledEvent;
import org.eclipse.net4j.buddies.protocol.IMessage;
import org.eclipse.net4j.internal.util.event.Event;
import org.eclipse.net4j.util.ObjectUtil;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Eike Stepper
 */
public class Collaboration extends BuddyContainer implements ICollaboration
{
  private long id;

  private String title;

  private String description;

  private Visibility visibility = Visibility.PRIVATE;

  private Map<String, IFacility> facilities = new HashMap<String, IFacility>();

  public Collaboration(long id, Set<IBuddy> buddies)
  {
    super(buddies);
    this.id = id;
  }

  public long getID()
  {
    return id;
  }

  public String getTitle()
  {
    return title == null ? String.valueOf(id) : title;
  }

  public String getDescription()
  {
    return description;
  }

  public Visibility getVisibility()
  {
    return visibility;
  }

  public boolean isPublic()
  {
    return visibility == Visibility.PUBLIC;
  }

  public void setPublic(String title, String description)
  {
    visibility = Visibility.PUBLIC;
    this.title = title;
    this.description = description;
  }

  public void setPrivate()
  {
    visibility = Visibility.PRIVATE;
    title = null;
    description = null;
  }

  // public Map<String, IFacility> getFacilities()
  // {
  // return Collections.unmodifiableMap(facilities);
  // }

  public IFacility[] getFacilities()
  {
    synchronized (facilities)
    {
      return facilities.values().toArray(new IFacility[facilities.size()]);
    }
  }

  public IFacility getFacility(String type)
  {
    synchronized (facilities)
    {
      return facilities.get(type);
    }
  }

  public boolean addFacility(IFacility facility, boolean remote)
  {
    String type = facility.getType();
    synchronized (facilities)
    {
      if (!facilities.containsKey(type))
      {
        facilities.put(type, facility);
        fireEvent(new FacilityInstalledEvent(facility, remote));
        facility.addListener(this);
        return true;
      }
    }

    return false;
  }

  public void sendMessage(IMessage message)
  {
    for (IBuddy receiver : getElements())
    {
      if (!ObjectUtil.equals(receiver.getUserID(), message.getSenderID()))
      {
        try
        {
          new MessageNotification(receiver.getSession().getChannel(), message).send();
        }
        catch (Exception ex)
        {
          OM.LOG.error(ex);
        }
      }
    }
  }

  public void notifyMessage(IMessage message)
  {
    IFacility[] handlers;
    synchronized (facilities)
    {
      handlers = facilities.values().toArray(new IFacility[facilities.size()]);
    }

    for (IFacility facility : handlers)
    {
      try
      {
        facility.handleMessage(message);
      }
      catch (RuntimeException ex)
      {
        OM.LOG.error(ex);
      }
    }

    fireEvent(new MessageEvent(this, message));
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("{0}[{1}]", getClass().getSimpleName(), getTitle());
  }

  @Override
  public void notifyEvent(IEvent event)
  {
    if (event.getSource() instanceof IFacility)
    {
      notifyFacilityEvent(event);
    }
  }

  protected void notifyFacilityEvent(IEvent event)
  {
  }

  @Override
  protected void doDeactivate() throws Exception
  {
    for (IFacility facility : getFacilities())
    {
      facility.removeListener(this);
      LifecycleUtil.deactivate(facility);
    }

    super.doDeactivate();
  }

  /**
   * @author Eike Stepper
   */
  private final class FacilityInstalledEvent extends Event implements IFacilityInstalledEvent
  {
    private static final long serialVersionUID = 1L;

    private IFacility facility;

    private boolean remote;

    public FacilityInstalledEvent(IFacility facility, boolean remote)
    {
      super(Collaboration.this);
      this.facility = facility;
      this.remote = remote;
    }

    public ICollaboration getCollaboration()
    {
      return Collaboration.this;
    }

    public IFacility getFacility()
    {
      return facility;
    }

    public boolean fromRemote()
    {
      return remote;
    }

    @Override
    public String toString()
    {
      return MessageFormat.format("FacilityInstalledEvent[source={0}, facility={1}, remote={2}]", getSource(),
          facility, remote);
    }
  }
}
