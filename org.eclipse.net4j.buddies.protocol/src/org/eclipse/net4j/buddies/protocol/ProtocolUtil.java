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
package org.eclipse.net4j.buddies.protocol;

import org.eclipse.net4j.util.WrappedException;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Eike Stepper
 */
public final class ProtocolUtil
{
  private ProtocolUtil()
  {
  }

  public static void writeAccount(ExtendedDataOutputStream out, IBuddyAccount account) throws IOException
  {
    if (account != null)
    {
      out.writeBoolean(true);
      ObjectOutputStream oos = new ObjectOutputStream(out);
      oos.writeObject(account);
    }
    else
    {
      out.writeBoolean(false);
    }
  }

  public static IBuddyAccount readAccount(ExtendedDataInputStream in) throws IOException
  {
    boolean exists = in.readBoolean();
    if (!exists)
    {
      return null;
    }

    try
    {
      ObjectInputStream ois = new ObjectInputStream(in);
      return (IBuddyAccount)ois.readObject();
    }
    catch (IOException ex)
    {
      throw ex;
    }
    catch (Exception ex)
    {
      throw WrappedException.wrap(ex);
    }
  }

  public static void writeState(ExtendedDataOutputStream out, IBuddy.State state) throws IOException
  {
    switch (state)
    {
    case AVAILABLE:
      out.writeByte(ProtocolConstants.STATE_AVAILABLE);
      break;

    case AWAY:
      out.writeByte(ProtocolConstants.STATE_AWAY);
      break;

    case DO_NOT_DISTURB:
      out.writeByte(ProtocolConstants.STATE_DO_NOT_DISTURB);
      break;

    default:
      throw new IllegalArgumentException("Illegal state: " + state);
    }
  }

  public static IBuddy.State readState(ExtendedDataInputStream in) throws IOException
  {
    byte state = in.readByte();
    switch (state)
    {
    case ProtocolConstants.STATE_AVAILABLE:
      return IBuddy.State.AVAILABLE;

    case ProtocolConstants.STATE_AWAY:
      return IBuddy.State.AWAY;

    case ProtocolConstants.STATE_DO_NOT_DISTURB:
      return IBuddy.State.DO_NOT_DISTURB;

    default:
      throw new IllegalArgumentException("Illegal state: " + state);
    }
  }
}
