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

import org.eclipse.net4j.buddies.protocol.ICollaborationContainer;
import org.eclipse.net4j.signal.Indication;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;

import java.io.IOException;

/**
 * @author Eike Stepper
 */
public class CollaborationLeftIndication extends Indication
{
  private ICollaborationContainer collaborationContainer;

  public CollaborationLeftIndication(ICollaborationContainer collaborationContainer)
  {
    this.collaborationContainer = collaborationContainer;
  }

  @Override
  protected short getSignalID()
  {
    return ProtocolConstants.SIGNAL_COLLABORATION_LEFT;
  }

  @Override
  protected void indicating(ExtendedDataInputStream in) throws IOException
  {
    long collaborationID = in.readLong();
    String userID = in.readString();

    Collaboration collaboration = (Collaboration)collaborationContainer.getCollaboration(collaborationID);
    if (collaboration != null)
    {
      collaborationLeft(collaboration, userID);
    }
  }

  protected void collaborationLeft(Collaboration collaboration, String userID)
  {
    collaboration.removeBuddy(userID);
  }
}
