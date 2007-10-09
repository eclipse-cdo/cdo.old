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
import org.eclipse.net4j.buddies.protocol.IMessage;
import org.eclipse.net4j.util.ObjectUtil;

import java.text.MessageFormat;
import java.util.Collections;
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

  public Map<String, IFacility> getFacilities()
  {
    return Collections.unmodifiableMap(facilities);
  }

  public void addFacility(IFacility facility)
  {
    synchronized (facilities)
    {
      facilities.put(facility.getType(), facility);
    }
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
}
