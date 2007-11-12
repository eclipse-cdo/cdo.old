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
import org.eclipse.net4j.buddies.protocol.IMembership;
import org.eclipse.net4j.buddies.protocol.IMessage;
import org.eclipse.net4j.internal.util.event.Event;
import org.eclipse.net4j.util.ObjectUtil;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Eike Stepper
 */
public class Collaboration extends MembershipContainer implements ICollaboration
{
  private long id;

  private String title;

  private String description;

  private Visibility visibility = Visibility.PRIVATE;

  private ConcurrentMap<String, IFacility> facilities = new ConcurrentHashMap<String, IFacility>();

  public Collaboration(long id)
  {
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

  public IMembership getMembership(IBuddy buddy)
  {
    return getMembership(buddy, this);
  }

  public IMembership removeMembership(IBuddy buddy)
  {
    return removeMembership(buddy, this);
  }

  public IBuddy getBuddy(String userID)
  {
    for (IMembership membership : getMemberships())
    {
      IBuddy buddy = membership.getBuddy();
      if (ObjectUtil.equals(buddy.getUserID(), userID))
      {
        return buddy;
      }
    }

    return null;
  }

  public IBuddy[] getBuddies()
  {
    List<IBuddy> buddies = new ArrayList<IBuddy>();
    for (IMembership membership : getMemberships())
    {
      IBuddy buddy = membership.getBuddy();
      buddies.add(buddy);
    }

    return buddies.toArray(new IBuddy[buddies.size()]);
  }

  public String[] getFacilityTypes()
  {
    return facilities.keySet().toArray(new String[facilities.size()]);
  }

  public IFacility[] getFacilities()
  {
    return facilities.values().toArray(new IFacility[facilities.size()]);
  }

  public IFacility getFacility(String type)
  {
    return facilities.get(type);
  }

  public boolean addFacility(IFacility facility, boolean remote)
  {
    String type = facility.getType();
    if (!facilities.containsKey(type))
    {
      facilities.put(type, facility);
      fireEvent(new FacilityInstalledEvent(facility, remote));
      facility.addListener(this);
      return true;
    }

    return false;
  }

  public void sendMessage(long collaborationID, String facilityType, IMessage message)
  {
    IMembership[] elements = getElements();
    for (IMembership membership : elements)
    {
      IBuddy receiver = membership.getBuddy();
      if (!ObjectUtil.equals(receiver.getUserID(), message.getSenderID()))
      {
        try
        {
          new MessageNotification(receiver.getSession().getChannel(), collaborationID, facilityType, message).send();
        }
        catch (Exception ex)
        {
          OM.LOG.error(ex);
        }
      }
    }
  }

  /**
   * @see PlatformObject#getAdapter(Class)
   */
  @SuppressWarnings("unchecked")
  public Object getAdapter(Class adapter)
  {
    return Platform.getAdapterManager().getAdapter(this, adapter);
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj instanceof ICollaboration)
    {
      ICollaboration collaboration = (ICollaboration)obj;
      return getID() == collaboration.getID();
    }

    return false;
  }

  @Override
  public int hashCode()
  {
    return ObjectUtil.hashCode(id);
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("{0}[{1}]", getClass().getSimpleName(), getTitle());
  }

  @Override
  public void notifyEvent(IEvent event)
  {
    super.notifyEvent(event);
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

    for (IMembership membership : getMemberships())
    {
      LifecycleUtil.deactivate(membership);
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
