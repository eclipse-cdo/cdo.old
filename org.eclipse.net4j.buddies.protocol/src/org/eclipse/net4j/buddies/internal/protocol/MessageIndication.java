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

import org.eclipse.net4j.buddies.protocol.ICollaboration;
import org.eclipse.net4j.buddies.protocol.ICollaborationContainer;
import org.eclipse.net4j.buddies.protocol.IMessage;
import org.eclipse.net4j.buddies.protocol.ProtocolUtil;
import org.eclipse.net4j.signal.Indication;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;

import java.io.IOException;

/**
 * @author Eike Stepper
 */
public class MessageIndication extends Indication
{
  private ICollaborationContainer collaborationContainer;

  public MessageIndication(ICollaborationContainer collaborationContainer)
  {
    this.collaborationContainer = collaborationContainer;
  }

  @Override
  protected short getSignalID()
  {
    return ProtocolConstants.SIGNAL_MESSAGE;
  }

  @Override
  protected void indicating(ExtendedDataInputStream in) throws IOException
  {
    long collaborationID = in.readLong();
    String facilityType = in.readString();
    Facility facility = getFacility(collaborationID, facilityType);

    IMessage message = ProtocolUtil.readMessage(in, facility.getClass().getClassLoader());
    facility.handleMessage(message);

    // ClassLoader oldClassLoader = Thread.currentThread().getContextClassLoader();
    //
    // try
    // {
    // Thread.currentThread().setContextClassLoader(facility.getClass().getClassLoader());
    // IMessage message = ProtocolUtil.readMessage(in);
    // facility.handleMessage(message);
    // }
    // finally
    // {
    // Thread.currentThread().setContextClassLoader(oldClassLoader);
    // }
  }

  private Facility getFacility(long collaborationID, String facilityType)
  {
    ICollaboration collaboration = collaborationContainer.getCollaboration(collaborationID);
    return (Facility)collaboration.getFacility(facilityType);
  }
}
