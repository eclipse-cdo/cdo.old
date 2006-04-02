/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.socket.impl;


import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.core.NegotiationException;
import org.eclipse.net4j.core.SelectionListener;
import org.eclipse.net4j.core.impl.AbstractConnector;
import org.eclipse.net4j.core.impl.BufferImpl;
import org.eclipse.net4j.core.impl.ChannelImpl;
import org.eclipse.net4j.socket.SelectorManager;
import org.eclipse.net4j.socket.SocketConnector;
import org.eclipse.net4j.spring.ValidationException;
import org.eclipse.net4j.util.ImplementationError;
import org.eclipse.net4j.util.ThreadInterruptedException;
import org.eclipse.net4j.util.UnderlyingIOException;
import org.eclipse.net4j.util.thread.DeadlockDetector;

import java.io.IOException;

import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;


public abstract class AbstractSocketConnector extends AbstractConnector implements SocketConnector,
    SelectionListener
{
  public static final int TRACE_MODE = BufferImpl.HEX_MODE;

  private long authenticationTimeout = DEFAULT_AUTHENTICATION_TIMEOUT;

  private BufferImpl receiveBuffer;

  private SelectorManager selectorManager;

  private SocketChannel socketChannel;

  private transient boolean inHeader = true;

  private transient int maxReceiveLength;

  private transient short receiveLength;

  private transient short receiveChannelIndex;

  public long getAuthenticationTimeout()
  {
    return authenticationTimeout;
  }

  public void setAuthenticationTimeout(long authenticationTimeout)
  {
    doSet("authenticationTimeout", authenticationTimeout);
  }

  /**
   * @return Returns the selectorManager.
   */
  public SelectorManager getSelectorManager()
  {
    return selectorManager;
  }

  /**
   * @param selectorManager The selectorManager to set.
   */
  public void setSelectorManager(SelectorManager selectorManager)
  {
    doSet("selectorManager", selectorManager);
  }

  public SocketChannel getSocketChannel()
  {
    return socketChannel;
  }

  public void setSocketChannel(SocketChannel socketChannel)
  {
    doSet("socketChannel", socketChannel);
  }

  /**
   * Called in the context of a Selector.Controller thread.
   */
  protected void doRead() throws IOException
  {
    boolean ok = receiveBuffer.readFrom(socketChannel);
    if (!ok)
    {
      try
      {
        stop();
      }
      catch (Exception ex)
      {
        ex.printStackTrace();
      }

      return;
    }

    if (receiveBuffer.remaining() == 0)
    {
      receiveBuffer.flip();

      if (inHeader)
      {
        receiveLength = receiveBuffer.getShort();
        receiveChannelIndex = receiveBuffer.getShort();
        if (ChannelImpl.TRACING_BUFFERS)
        {
          if (isDebugEnabled())
            debug("Receiving buffer with length=" + receiveLength + ", channelIndex="
                + receiveChannelIndex);
        }

        receiveBuffer.clear();
        receiveBuffer.limit(receiveLength);
        inHeader = false;
      }
      else
      {
        Channel channel = getChannel(receiveChannelIndex);
        channel.notifyData(receiveBuffer);
        newReceiverBuffer();
        inHeader = true;
      }
    }
  }

  /**
   * The buffer is expected to be flipped already.
   */
  public void transmit(int channelIndex, BufferImpl buffer)
  {
    final int limit = buffer.limit();
    final int length = limit - Channel.HEADER_SIZE;

    if (ChannelImpl.TRACING_BUFFERS)
    {
      if (isDebugEnabled())
        debug("Transmitting buffer: " + buffer + ", length=" + length + ", channelIndex="
            + channelIndex);
    }

    buffer.position(0);
    buffer.putShort((short) length);
    buffer.putShort((short) channelIndex);
    buffer.position(0);
    buffer.limit(limit);

    try
    {
      socketChannel.write(buffer.getByteBuffer());

      long start = System.currentTimeMillis();
      while (buffer.position() < limit)
      {
        if (System.currentTimeMillis() - start > 100000) //XXX
        {
          error("Timeout while writing");
          throw new ImplementationError("Timeout while writing");
        }

        try
        {
          Thread.sleep(100);
        }
        catch (InterruptedException ex)
        {
          throw new ThreadInterruptedException(ex);
        }

        socketChannel.write(buffer.getByteBuffer());
      }
    }
    catch (IOException e)
    {
      throw new UnderlyingIOException(e);
    }
  }

  public void notifyRegistration(SelectableChannel selectable, SelectionKey key)
  {
    if (isDebugEnabled()) debug("Registered " + selectable + " under key " + key);
  }

  /**
   * Effectively this method will be invoked in the context of a SelectorController thread.
   * 
   * Some observations on ByteBuffer:
   * 1. For a given ByteBuffer we can't control how many bytes are read in from a SelectableChannel.
   *    If the buffer is bigger then needed, we will have to be prepared that we got more 
   *    bytes then logically needed. It's also always possible that we got fewer bytes or 
   *    even no bytes at all.
   * 2. Creation is expensive (especially for DirectByteBuffer), pooling is adequate.
   * 3. Since buffers are potentially pooled (2), we cant't order arbitrary capacities.
   *    Otherwise we had lower reusage rate of appropriate buffers or higher memory consumption.
   *    For effective pooling buffer capacities must be the same.
   * 4. Before we know how many bytes of  data we need, we have to read a header that contains
   *    this number (unsigned, two-byte number). The header size is constant (2x2 bytes).
   * 5. Since header size is constant (4), we could use fixed 4-byte buffers for that. But
   *    since the buffers for bodies are all of equal capacity (3), we can't fight against
   *    having a (part of a) header in the body buffer (1) remaining after the last body read.
   * 6. When a body is completely read into a buffer, this buffer is handed out of the scope of
   *    this reader. Any additional data in this buffer (next header, plus body or part of body, ...)
   *    has to be copied elsewhere to not get lost. the original buffer has to be trimmed. 
   * 
   * Our solution:
   * We use only buffers of maximum capacity to read from sockets (headers and bodies).
   * The reader (this connector within the context of a selector-controller thread) maintains
   * 2 states for reading header and body into the same buffer. 
   */
  public void readyForRead(SelectableChannel selectable)
  {
    if (ChannelImpl.TRACING && isDebugEnabled())
    {
      debug("readyForRead(): " + selectable);
    }

    try
    {
      doRead();
    }
    catch (IOException ex)
    {
      error("Error while reading from socket", ex);
      throw new UnderlyingIOException(ex);
    }
  }

  public byte[] receiveNegotiation() throws NegotiationException
  {
    try
    {
      ByteBuffer lengthBuffer = ByteBuffer.allocateDirect(4);
      receiveBuffer(lengthBuffer);
      lengthBuffer.flip();
      int length = lengthBuffer.getInt();

      byte[] data = new byte[length];
      ByteBuffer buffer = ByteBuffer.wrap(data);
      receiveBuffer(buffer);
      buffer.flip();
      return buffer.array();
    }
    catch (Exception ex)
    {
      throw new NegotiationException("Negotiation data could not be received", ex);
    }
  }

  public void transmitNegotiation(byte[] data) throws NegotiationException
  {
    try
    {
      ByteBuffer lengthBuffer = ByteBuffer.allocateDirect(4);
      lengthBuffer.putInt(data.length);
      lengthBuffer.flip();
      transmitBuffer(lengthBuffer);

      ByteBuffer buffer = ByteBuffer.wrap(data);
      transmitBuffer(buffer);
    }
    catch (Exception ex)
    {
      throw new NegotiationException("Negotiation data could not be transmitted", ex);
    }
  }

  private void transmitBuffer(ByteBuffer buffer) throws IOException
  {
    int written = socketChannel.write(buffer);

    while (written < buffer.capacity())
    {
      DeadlockDetector.sleep(50);
      written += socketChannel.write(buffer);
    }
  }

  private void receiveBuffer(ByteBuffer buffer) throws IOException
  {
    int read = socketChannel.read(buffer);

    while (read < buffer.capacity())
    {
      DeadlockDetector.sleep(50);
      read += socketChannel.read(buffer);
    }
  }

  public static void waitForConnection(SocketChannel socketChannel) throws InterruptedException,
      IOException
  {
    while (socketChannel.isConnectionPending())
    {
      Thread.sleep(200);
      socketChannel.finishConnect();
    }
  }

  @Override
  protected void validate() throws ValidationException
  {
    super.validate();
    assertNotNull("selectorManager");

    maxReceiveLength = getBufferPool().getBufferSize() - Channel.HEADER_SIZE;
    if (maxReceiveLength < 1)
    {
      throw new ValidationException("No space left for data: " + maxReceiveLength);
    }

    newReceiverBuffer();
  }

  protected void newReceiverBuffer()
  {
    receiveBuffer = getBufferPool().getBuffer();
    receiveBuffer.limit(Channel.HEADER_SIZE);
    receiveLength = 0;
    receiveChannelIndex = -1;
  }

  @Override
  public void adjustTransmitterBuffer(BufferImpl transmitterBuffer)
  {
    transmitterBuffer.position(Channel.HEADER_SIZE);
  }

  @Override
  protected void activate() throws Exception
  {
    socketChannel.configureBlocking(false);

    if (isDebugEnabled()) debug("Waiting for connection...");
    waitForConnection(socketChannel);
    info("Connected socketChannel: " + socketChannel);

    super.activate();
    selectorManager.register(socketChannel, this);
  }

  @Override
  protected void deactivate() throws Exception
  {
    selectorManager.deregister(socketChannel);
    super.deactivate();
  }
}
