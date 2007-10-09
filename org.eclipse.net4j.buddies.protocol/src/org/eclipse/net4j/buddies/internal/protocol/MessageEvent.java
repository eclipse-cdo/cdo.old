package org.eclipse.net4j.buddies.internal.protocol;

import org.eclipse.net4j.buddies.protocol.IMessage;
import org.eclipse.net4j.buddies.protocol.IMessageEvent;
import org.eclipse.net4j.internal.util.event.Event;
import org.eclipse.net4j.util.event.INotifier;

/**
 * @author Eike Stepper
 */
public final class MessageEvent extends Event implements IMessageEvent
{
  private static final long serialVersionUID = 1L;

  private IMessage message;

  public MessageEvent(INotifier notifier, IMessage message)
  {
    super(notifier);
    this.message = message;
  }

  public IMessage getMessage()
  {
    return message;
  }
}